/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.service.persistence.data;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;
import static org.spongepowered.api.service.persistence.data.DataQuery.of;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.spongepowered.api.service.persistence.DataSerializable;
import org.spongepowered.api.service.persistence.DataSerializableBuilder;
import org.spongepowered.api.service.persistence.SerializationService;
import org.spongepowered.api.util.Coerce;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

/**
 * Default implementation of a {@link DataView} being used in memory.
 */
public class MemoryDataView implements DataView {

    protected final Map<String, Object> map = Maps.newLinkedHashMap();
    private final DataContainer container;
    private final DataView parent;
    private final DataQuery path;

    protected MemoryDataView() {
        checkState(this instanceof DataContainer, "Cannot construct a root MemoryDataView without a container!");
        this.path = of();
        this.parent = this;
        this.container = (DataContainer) this;
    }

    protected MemoryDataView(DataView parent, DataQuery path) {
        checkArgument(path.getParts().size() >= 1, "Path must have at least one part");
        this.parent = parent;
        this.container = parent.getContainer();
        this.path = parent.getCurrentPath().then(path);
    }

    @Override
    public DataContainer getContainer() {
        return this.container;
    }

    @Override
    public DataQuery getCurrentPath() {
        return this.path;
    }

    @Override
    public String getName() {
        List<String> parts = this.path.getParts();
        return parts.isEmpty() ? "" : parts.get(parts.size() - 1);
    }

    @Override
    public Optional<DataView> getParent() {
        return Optional.fromNullable(this.parent);
    }

    @Override
    public Set<DataQuery> getKeys(boolean deep) {
        ImmutableSet.Builder<DataQuery> builder = ImmutableSet.builder();

        for (Map.Entry<String, Object> entry : this.map.entrySet()) {
            builder.add(of(entry.getKey()));
        }
        if (deep) {
            for (Map.Entry<String, Object> entry : this.map.entrySet()) {
                if (entry.getValue() instanceof DataView) {
                    for (DataQuery query : ((DataView) entry.getValue()).getKeys(true)) {
                        builder.add(of(entry.getKey()).then(query));
                    }
                }
            }
        }
        return builder.build();
    }

    @Override
    public Map<DataQuery, Object> getValues(boolean deep) {
        ImmutableMap.Builder<DataQuery, Object> builder = ImmutableMap.builder();
        for (DataQuery query : getKeys(deep)) {
            Object value = get(query).get();
            if (value instanceof DataView) {
                builder.put(query, ((DataView) value).getValues(deep));
            } else {
                builder.put(query, get(query).get());
            }
        }
        return builder.build();
    }

    @Override
    public boolean contains(DataQuery path) {
        checkNotNull(path);
        List<DataQuery> queryParts = path.getQueryParts();

        if (queryParts.size() == 1) {
            String key = queryParts.get(0).getParts().get(0);
            return this.map.containsKey(key);
        } else {
            DataQuery subQuery = queryParts.get(0);
            Optional<DataView> subViewOptional = this.getUnsafeView(subQuery);
            if (!subViewOptional.isPresent()) {
                return false;
            }
            List<String> subParts = Lists.newArrayListWithCapacity(queryParts.size() - 1);
            for (int i = 1; i < queryParts.size(); i++) {
                subParts.add(queryParts.get(i).asString("."));
            }
            return subViewOptional.get().contains(of(subParts));
        }
    }

    @Override
    public Optional<Object> get(DataQuery path) {
        checkNotNull(path);
        List<DataQuery> queryParts = path.getQueryParts();

        int sz = queryParts.size();

        if (sz == 0) {
            return Optional.<Object>of(this);
        }

        if (sz == 1) {
            String key = queryParts.get(0).getParts().get(0);
            if (this.map.containsKey(key)) {
                return Optional.of(this.map.get(key));
            } else {
                return Optional.absent();
            }
        }
        DataQuery subQuery = queryParts.get(0);
        Optional<DataView> subViewOptional = this.getUnsafeView(subQuery);
        DataView subView;
        if (!subViewOptional.isPresent()) {
            return Optional.absent();
        } else {
            subView = subViewOptional.get();
        }
        List<String> subParts = Lists.newArrayListWithCapacity(queryParts.size() - 1);
        for (int i = 1; i < queryParts.size(); i++) {
            subParts.add(queryParts.get(i).asString("."));
        }
        return subView.get(of(subParts));

    }

    @Override
    public void set(DataQuery path, Object value) {
        checkNotNull(path);
        checkNotNull(value);
        checkState(this.container != null);

        if (value instanceof DataView) {
            checkArgument(value != this);
            copyDataView(path, (DataView) value);
        } else if (value instanceof DataSerializable) {
            DataContainer valueContainer = ((DataSerializable) value).toContainer();
            checkArgument(!(valueContainer).equals(this));
            copyDataView(path, valueContainer);
        } else {
            List<String> parts = path.getParts();
            if (parts.size() > 1) {
                String subKey = parts.get(0);
                DataQuery subQuery = of(subKey);
                Optional<DataView> subViewOptional = this.getUnsafeView(subQuery);
                DataView subView;
                if (!subViewOptional.isPresent()) {
                    this.createView(subQuery);
                    subView = (DataView) this.map.get(subKey);
                } else {
                    subView = subViewOptional.get();
                }
                List<String> subParts = Lists.newArrayListWithCapacity(parts.size() - 1);
                for (int i = 1; i < parts.size(); i++) {
                    subParts.add(parts.get(i));
                }
                subView.set(of(subParts), value);
            } else {
                if (value instanceof Collection) {
                    setCollection(parts.get(0), (Collection) value);
                } else if (value instanceof Object[]) {
                    setCollection(parts.get(0), Lists.newArrayList((Object[]) value));
                } else if (value instanceof Map) {
                    setMap(parts.get(0), (Map) value);
                } else {
                    this.map.put(parts.get(0), value);
                }
            }
        }
    }

    private void setCollection(String key, Collection<?> value) {
        ImmutableList.Builder<Object> builder = ImmutableList.builder();
        for (Object object : value) {
            if (object instanceof DataSerializable) {
                builder.add(((DataSerializable) object).toContainer());
            } else if (object instanceof DataView) {
                MemoryDataView view = new MemoryDataContainer();
                DataView internalView = (DataView) object;
                for (Map.Entry<DataQuery, Object> entry : internalView.getValues(false).entrySet()) {
                    view.set(entry.getKey(), entry.getValue());
                }
                builder.add(view);
            } else if (object instanceof Map) {
                builder.add(ImmutableMap.copyOf((Map<?, ?>) object));
            } else if (object instanceof Collection) {
                builder.add(ImmutableList.copyOf((Collection<?>) object));
            } else {
                builder.add(object);
            }
        }
        this.map.put(key, builder.build());
    }

    private void setMap(String key, Map<?, ?> value) {
        DataView view = createView(of(key));
        for (Map.Entry<?, ?> entry : value.entrySet()) {
            view.set(of(entry.getKey().toString()), entry.getValue());
        }
    }

    private void copyDataView(DataQuery path, DataView value) {
        Collection<DataQuery> valueKeys = value.getKeys(true);
        for (DataQuery oldKey : valueKeys) {
            set(path.then(oldKey), value.get(oldKey).get());
        }
    }

    @Override
    public void remove(DataQuery path) {
        checkNotNull(path);
        List<String> parts = path.getParts();
        if (parts.size() > 1) {
            String subKey = parts.get(0);
            DataQuery subQuery = of(subKey);
            Optional<DataView> subViewOptional = this.getUnsafeView(subQuery);
            DataView subView;
            if (!subViewOptional.isPresent()) {
                return;
            } else {
                subView = subViewOptional.get();
            }
            List<String> subParts = Lists.newArrayListWithCapacity(parts.size() - 1);
            for (int i = 1; i < parts.size(); i++) {
                subParts.add(parts.get(i));
            }
            subView.remove(of(subParts));
        } else {
            this.map.remove(parts.get(0));
        }
    }

    @Override
    public DataView createView(DataQuery path) {
        checkNotNull(path);
        List<DataQuery> queryParts = path.getQueryParts();

        int sz = queryParts.size();

        checkArgument(sz != 0, "The size of the query must be at least 1");

        if (sz == 1) {
            DataQuery key = queryParts.get(0);
            DataView result = new MemoryDataView(this, key);
            this.map.put(key.getParts().get(0), result);
            return result;
        } else {
            List<String> subParts = Lists
                    .newArrayListWithCapacity(queryParts.size() - 1);
            for (int i = 1; i < sz; i++) {
                subParts.add(queryParts.get(i).asString('.'));
            }
            DataQuery subQuery = of(subParts);
            DataView subView = (DataView) this.map.get(queryParts.get(0).asString('.'));
            if (subView == null) {
                subView = new MemoryDataView(this.parent, queryParts.get(0));
                this.map.put(queryParts.get(0).asString('.'), subView);
            }
            return subView.createView(subQuery);
        }
    }

    @Override
    public DataView createView(DataQuery path, Map<?, ?> map) {
        checkNotNull(path);
        DataView section = createView(path);

        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (entry.getValue() instanceof Map) {
                section.createView(of('.', entry.getKey().toString()), (Map<?, ?>) entry.getValue());
            } else {
                section.set(of('.', entry.getKey().toString()), entry.getValue());
            }
        }
        return section;
    }

    @Override
    public Optional<DataView> getView(DataQuery path) {
        Optional<Object> val = get(path);
        if (val.isPresent()) {
            if (val.get() instanceof DataView) {
                return Optional.of((DataView) val.get());
            }
        }
        return Optional.absent();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<? extends Map<?, ?>> getMap(DataQuery path) {
        Optional<Object> val = get(path);
        if (val.isPresent()) {
            if (val.get() instanceof DataView) {
                ImmutableMap.Builder<String, Object> builder = ImmutableMap.builder();
                for (Map.Entry<DataQuery, Object> entry : ((DataView) val.get()).getValues(false).entrySet()) {
                    if (entry.getValue() instanceof Collection) {
                        builder.put(entry.getKey().asString('.'), ImmutableList.copyOf((Collection) entry.getValue()));
                    } else if (entry.getValue() instanceof Map) {
                        builder.put(entry.getKey().asString('.'), ImmutableMap.copyOf((Map) entry.getValue()));
                    } else {
                        builder.put(entry.getKey().asString('.'), entry.getValue());
                    }
                }
                return Optional.of(builder.build());
            } else if (val.get() instanceof Map) {
                return Optional.of((Map<?, ?>) val.get());
            }
        }
        return Optional.absent();
    }

    private Optional<DataView> getUnsafeView(DataQuery path) {
        Optional<Object> val = get(path);
        if (val.isPresent()) {
            if (val.get() instanceof DataView) {
                return Optional.of((DataView) val.get());
            }
        }
        return Optional.absent();
    }

    @Override
    public Optional<Boolean> getBoolean(DataQuery path) {
        Optional<Object> val = get(path);
        if (val.isPresent()) {
            return Coerce.asBoolean(val.get());
        }
        return Optional.absent();
    }

    @Override
    public Optional<Integer> getInt(DataQuery path) {
        Optional<Object> val = get(path);
        if (val.isPresent()) {
            return Coerce.asInteger(val.get());
        }
        return Optional.absent();
    }

    @Override
    public Optional<Long> getLong(DataQuery path) {
        Optional<Object> val = get(path);
        if (val.isPresent()) {
            return Coerce.asLong(val.get());
        }
        return Optional.absent();
    }

    @Override
    public Optional<Double> getDouble(DataQuery path) {
        Optional<Object> val = get(path);
        if (val.isPresent()) {
            return Coerce.asDouble(val.get());
        }
        return Optional.absent();
    }

    @Override
    public Optional<String> getString(DataQuery path) {
        Optional<Object> val = get(path);
        if (val.isPresent()) {
            return Coerce.asString(val.get());
        }
        return Optional.absent();
    }

    @Override
    public Optional<List<?>> getList(DataQuery path) {
        Optional<Object> val = get(path);
        if (val.isPresent()) {
            if (val.get() instanceof List<?>) {
                return Optional.<List<?>>of(Lists.newArrayList((List<?>) val.get()));
            }
            if (val.get() instanceof Object[]) {
                return Optional.<List<?>>of(Lists.newArrayList((Object[]) val.get()));
            }
        }
        return Optional.absent();
    }

    @Override
    public Optional<List<String>> getStringList(DataQuery path) {
        Optional<List<?>> list = getUnsafeList(path);

        if (!list.isPresent()) {
            return Optional.absent();
        }

        List<String> newList = Lists.newArrayList();

        for (Object object : list.get()) {
            Optional<String> optional = Coerce.asString(object);
            if (optional.isPresent()) {
                newList.add(optional.get());
            }
        }
        return Optional.of(newList);
    }

    private Optional<List<?>> getUnsafeList(DataQuery path) {
        Optional<Object> val = get(path);
        if (val.isPresent()) {
            if (val.get() instanceof List<?>) {
                return Optional.<List<?>>of((List<?>) val.get());
            } else if (val.get() instanceof Object[]) {
                return Optional.<List<?>>of(Arrays.asList(((Object[]) val.get())));
            }
        }
        return Optional.absent();
    }

    @Override
    public Optional<List<Character>> getCharacterList(DataQuery path) {
        Optional<List<?>> list = getUnsafeList(path);

        if (!list.isPresent()) {
            return Optional.absent();
        }

        List<Character> newList = Lists.newArrayList();

        for (Object object : list.get()) {
            Optional<Character> optional = Coerce.asChar(object);
            if (optional.isPresent()) {
                newList.add(optional.get());
            }
        }
        return Optional.of(newList);
    }

    @Override
    public Optional<List<Boolean>> getBooleanList(DataQuery path) {
        Optional<List<?>> list = getUnsafeList(path);

        if (!list.isPresent()) {
            return Optional.absent();
        }

        List<Boolean> newList = Lists.newArrayList();

        for (Object object : list.get()) {
            Optional<Boolean> optional = Coerce.asBoolean(object);
            if (optional.isPresent()) {
                newList.add(optional.get());
            }
        }
        return Optional.of(newList);
    }

    @Override
    public Optional<List<Byte>> getByteList(DataQuery path) {
        Optional<List<?>> list = getUnsafeList(path);

        if (!list.isPresent()) {
            return Optional.absent();
        }

        List<Byte> newList = Lists.newArrayList();

        for (Object object : list.get()) {
            Optional<Byte> optional = Coerce.asByte(object);
            if (optional.isPresent()) {
                newList.add(optional.get());
            }
        }
        return Optional.of(newList);
    }

    @Override
    public Optional<List<Short>> getShortList(DataQuery path) {
        Optional<List<?>> list = getUnsafeList(path);

        if (!list.isPresent()) {
            return Optional.absent();
        }

        List<Short> newList = Lists.newArrayList();

        for (Object object : list.get()) {
            Optional<Short> optional = Coerce.asShort(object);
            if (optional.isPresent()) {
                newList.add(optional.get());
            }
        }
        return Optional.of(newList);
    }

    @Override
    public Optional<List<Integer>> getIntegerList(DataQuery path) {
        Optional<List<?>> list = getUnsafeList(path);

        if (!list.isPresent()) {
            return Optional.absent();
        }

        List<Integer> newList = Lists.newArrayList();

        for (Object object : list.get()) {
            Optional<Integer> optional = Coerce.asInteger(object);
            if (optional.isPresent()) {
                newList.add(optional.get());
            }
        }
        return Optional.of(newList);
    }

    @Override
    public Optional<List<Long>> getLongList(DataQuery path) {
        Optional<List<?>> list = getUnsafeList(path);

        if (!list.isPresent()) {
            return Optional.absent();
        }

        List<Long> newList = Lists.newArrayList();

        for (Object object : list.get()) {
            Optional<Long> optional = Coerce.asLong(object);
            if (optional.isPresent()) {
                newList.add(optional.get());
            }
        }
        return Optional.of(newList);
    }

    @Override
    public Optional<List<Float>> getFloatList(DataQuery path) {
        Optional<List<?>> list = getUnsafeList(path);

        if (!list.isPresent()) {
            return Optional.absent();
        }

        List<Float> newList = Lists.newArrayList();

        for (Object object : list.get()) {
            Optional<Float> optional = Coerce.asFloat(object);
            if (optional.isPresent()) {
                newList.add(optional.get());
            }
        }
        return Optional.of(newList);
    }

    @Override
    public Optional<List<Double>> getDoubleList(DataQuery path) {
        Optional<List<?>> list = getUnsafeList(path);

        if (!list.isPresent()) {
            return Optional.absent();
        }

        List<Double> newList = Lists.newArrayList();

        for (Object object : list.get()) {
            Optional<Double> optional = Coerce.asDouble(object);
            if (optional.isPresent()) {
                newList.add(optional.get());
            }
        }
        return Optional.of(newList);
    }

    @Override
    public Optional<List<Map<?, ?>>> getMapList(DataQuery path) {
        Optional<List<?>> list = getUnsafeList(path);

        if (!list.isPresent()) {
            return Optional.absent();
        }

        List<Map<?, ?>> newList = Lists.newArrayList();

        for (Object object : list.get()) {
            if (object instanceof Map) {
                newList.add((Map<?, ?>) object);
            }
        }

        return Optional.of(newList);
    }

    @Override
    public Optional<List<DataView>> getViewList(DataQuery path) {
        Optional<List<?>> list = getUnsafeList(path);

        if (!list.isPresent()) {
            return Optional.absent();
        }

        List<DataView> newList = Lists.newArrayList();

        for (Object object : list.get()) {
            if (object instanceof DataView) {
                newList.add((DataView) object);
            }
        }

        return Optional.of(newList);
    }

    @Override
    public <T extends DataSerializable> Optional<T> getSerializable(DataQuery path, Class<T> clazz, SerializationService service) {
        checkNotNull(path);
        checkNotNull(clazz);
        checkNotNull(service);
        Optional<DataView> optional = getUnsafeView(path);

        if (!optional.isPresent()) {
            return Optional.absent();
        }

        Optional<DataSerializableBuilder<T>> builderOptional = service.getBuilder(clazz);
        if (!builderOptional.isPresent()) {
            return Optional.absent();
        } else {
            return builderOptional.get().build(optional.get());
        }
    }

    @Override
    public <T extends DataSerializable> Optional<List<T>> getSerializableList(DataQuery path, Class<T> clazz, SerializationService service) {
        checkNotNull(path);
        checkNotNull(clazz);
        checkNotNull(service);
        Optional<List<DataView>> optional = getViewList(path);

        if (!optional.isPresent()) {
            return Optional.absent();
        }

        Optional<DataSerializableBuilder<T>> builderOptional = service.getBuilder(clazz);
        if (!builderOptional.isPresent()) {
            return Optional.absent();
        } else {
            List<T> newList = Lists.newArrayList();
            for (DataView view : optional.get()) {
                Optional<T> element = builderOptional.get().build(view);
                if (element.isPresent()) {
                    newList.add(element.get());
                }
            }
            return Optional.of(newList);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.map, this.path);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final MemoryDataView other = (MemoryDataView) obj;

        return Objects.equal(this.map.entrySet(), other.map.entrySet())
               && Objects.equal(this.path, other.path);
    }
}
