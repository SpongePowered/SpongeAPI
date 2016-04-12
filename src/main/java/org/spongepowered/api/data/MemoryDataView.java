/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
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
package org.spongepowered.api.data;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;
import static org.spongepowered.api.data.DataQuery.of;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.ArrayUtils;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.persistence.DataTranslator;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.util.Coerce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        return Optional.ofNullable(this.parent);
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
    public final boolean contains(DataQuery path) {
        checkNotNull(path, "path");
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
    public boolean contains(DataQuery path, DataQuery... paths) {
        checkNotNull(path, "DataQuery cannot be null!");
        checkNotNull(paths, "DataQuery varargs cannot be null!");
        if (paths.length == 0) {
            return contains(path);
        }
        List<DataQuery> queries = new ArrayList<>();
        queries.add(path);
        for (DataQuery query : paths) {
            queries.add(checkNotNull(query, "No null queries!"));
        }
        for (DataQuery query : queries) {
            if (!contains(query)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Optional<Object> get(DataQuery path) {
        checkNotNull(path, "path");
        List<DataQuery> queryParts = path.getQueryParts();

        int sz = queryParts.size();

        if (sz == 0) {
            return Optional.<Object>of(this);
        }

        if (sz == 1) {
            String key = queryParts.get(0).getParts().get(0);
            if (this.map.containsKey(key)) {
                final Object object = this.map.get(key);
                if (object.getClass().isArray()) {
                    if (object instanceof byte[]) {
                        return Optional.<Object>of(ArrayUtils.clone((byte[]) object));
                    } else if (object instanceof short[]) {
                        return Optional.<Object>of(ArrayUtils.clone((short[]) object));
                    } else if (object instanceof int[]) {
                        return Optional.<Object>of(ArrayUtils.clone((int[]) object));
                    } else if (object instanceof long[]) {
                        return Optional.<Object>of(ArrayUtils.clone((long[]) object));
                    } else if (object instanceof float[]) {
                        return Optional.<Object>of(ArrayUtils.clone((float[]) object));
                    } else if (object instanceof double[]) {
                        return Optional.<Object>of(ArrayUtils.clone((double[]) object));
                    } else if (object instanceof boolean[]) {
                        return Optional.<Object>of(ArrayUtils.clone((boolean[]) object));
                    } else {
                        return Optional.<Object>of(ArrayUtils.clone((Object[]) object));
                    }
                }
                return Optional.of(this.map.get(key));
            } else {
                return Optional.empty();
            }
        }
        DataQuery subQuery = queryParts.get(0);
        Optional<DataView> subViewOptional = this.getUnsafeView(subQuery);
        DataView subView;
        if (!subViewOptional.isPresent()) {
            return Optional.empty();
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
    @SuppressWarnings({"rawtypes", "unchecked"})
    public DataView set(DataQuery path, Object value) {
        checkNotNull(path, "path");
        checkNotNull(value, "value");
        checkState(this.container != null);

        @Nullable DataManager manager;

        try {
            manager = Sponge.getDataManager();
        } catch (Exception e) {
            manager = null;
        }

        if (value instanceof DataView) {
            checkArgument(value != this, "Cannot set a DataView to itself.");
            copyDataView(path, (DataView) value);
        }else if (value instanceof DataSerializable) {
            DataContainer valueContainer = ((DataSerializable) value).toContainer();
            checkArgument(!(valueContainer).equals(this), "Cannot insert self-referencing DataSerializable");
            copyDataView(path, valueContainer);
        } else if (value instanceof CatalogType) {
            return set(path, ((CatalogType) value).getId());
        } else if (manager != null && manager.getTranslator(value.getClass()).isPresent()) {
            DataTranslator serializer = manager.getTranslator(value.getClass()).get();
            final DataContainer container = serializer.translate(value);
            checkArgument(!container.equals(this), "Cannot insert self-referencing Objects!");
            copyDataView(path, container);
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
                } else if (value instanceof Map) {
                    setMap(parts.get(0), (Map) value);
                } else if (value.getClass().isArray()) {
                    if (value instanceof byte[]) {
                        this.map.put(parts.get(0), ArrayUtils.clone((byte[]) value));
                    } else if (value instanceof short[]) {
                        this.map.put(parts.get(0), ArrayUtils.clone((short[]) value));
                    } else if (value instanceof int[]) {
                        this.map.put(parts.get(0), ArrayUtils.clone((int[]) value));
                    } else if (value instanceof long[]) {
                        this.map.put(parts.get(0), ArrayUtils.clone((long[]) value));
                    } else if (value instanceof float[]) {
                        this.map.put(parts.get(0), ArrayUtils.clone((float[]) value));
                    } else if (value instanceof double[]) {
                        this.map.put(parts.get(0), ArrayUtils.clone((double[]) value));
                    } else if (value instanceof boolean[]) {
                        this.map.put(parts.get(0), ArrayUtils.clone((boolean[]) value));
                    } else {
                        this.map.put(parts.get(0), ArrayUtils.clone((Object[]) value));
                    }
                } else {
                    this.map.put(parts.get(0), value);
                }
            }
        }
        return this;
    }

    @Override
    public <E> DataView set(Key<? extends BaseValue<E>> key, E value) {
        return set(checkNotNull(key, "Key was null!").getQuery(), value);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void setCollection(String key, Collection<?> value) {
        ImmutableList.Builder<Object> builder = ImmutableList.builder();
        @Nullable DataManager manager;

        try {
            manager = Sponge.getDataManager();
        } catch (Exception e) {
            manager = null;
        }

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
                builder.add(ensureSerialization((Map) object));
            } else if (object instanceof Collection) {
                builder.add(ensureSerialization((Collection) object));
            } else {
                if (manager != null) {
                    final Optional<? extends DataSerializer<?>> serializerOptional = manager.getSerializer(object.getClass());
                    if (serializerOptional.isPresent()) {
                        DataSerializer serializer = serializerOptional.get();
                        final DataContainer container = serializer.serialize(value);
                        checkArgument(!container.equals(this), "Cannot insert self-referencing Objects!");
                        copyDataView(this.path, container);
                    } else {
                        builder.add(object);
                    }
                } else {
                    builder.add(object);
                }

            }
        }
        this.map.put(key, builder.build());
    }

    @SuppressWarnings("rawtypes")
    private ImmutableList<Object> ensureSerialization(Collection<?> collection) {
        ImmutableList.Builder<Object> objectBuilder = ImmutableList.builder();
        collection.forEach(element -> {
            if (element instanceof Collection) {
                objectBuilder.add(ensureSerialization((Collection) element));
            } else if (element instanceof DataSerializable) {
                objectBuilder.add(((DataSerializable) element).toContainer());
            } else {
                objectBuilder.add(element);
            }
        });
        return objectBuilder.build();

    }

    @SuppressWarnings("rawtypes")
    private ImmutableMap<?, ?> ensureSerialization(Map<?, ?> map) {
        ImmutableMap.Builder<Object, Object> builder = ImmutableMap.builder();
        map.entrySet().forEach(entry -> {
            if (entry.getValue() instanceof Map) {
                builder.put(entry.getKey(), ensureSerialization((Map) entry.getValue()));
            } else if (entry.getValue() instanceof DataSerializable) {
                builder.put(entry.getKey(), ((DataSerializable) entry.getValue()).toContainer());
            } else if (entry.getValue() instanceof Collection) {
                builder.put(entry.getKey(), ensureSerialization((Collection) entry.getValue()));
            } else {
                builder.put(entry.getKey(), entry.getValue());
            }
        });
        return builder.build();
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
    public DataView remove(DataQuery path) {
        checkNotNull(path, "path");
        List<String> parts = path.getParts();
        if (parts.size() > 1) {
            String subKey = parts.get(0);
            DataQuery subQuery = of(subKey);
            Optional<DataView> subViewOptional = this.getUnsafeView(subQuery);
            DataView subView;
            if (!subViewOptional.isPresent()) {
                return this;
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
        return this;
    }

    @Override
    public DataView createView(DataQuery path) {
        checkNotNull(path, "path");
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
    @SuppressWarnings("rawtypes")
    public DataView createView(DataQuery path, Map<?, ?> map) {
        checkNotNull(path, "path");
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
        return get(path).filter(obj -> obj instanceof DataView).map(obj -> (DataView) obj);
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Optional<? extends Map<?, ?>> getMap(DataQuery path) {
        Optional<Object> val = get(path);
        if (val.isPresent()) {
            if (val.get() instanceof DataView) {
                ImmutableMap.Builder<String, Object> builder = ImmutableMap.builder();
                for (Map.Entry<DataQuery, Object> entry : ((DataView) val.get()).getValues(false).entrySet()) {
                    builder.put(entry.getKey().asString('.'), ensureMappingOf(entry.getValue()));
                }
                return Optional.of(builder.build());
            } else if (val.get() instanceof Map) {
                return Optional.of((Map<?, ?>) ensureMappingOf(val.get()));
            }
        }
        return Optional.empty();
    }

    private Object ensureMappingOf(Object object) {
        if (object instanceof DataView) {
            final ImmutableMap.Builder<String, Object> builder = ImmutableMap.builder();
            for (Map.Entry<DataQuery, Object> entry : ((DataView) object).getValues(false).entrySet()) {
                builder.put(entry.getKey().asString('.'), ensureMappingOf(entry.getValue()));
            }
            return builder.build();
        } else if (object instanceof Map) {
            final ImmutableMap.Builder<Object, Object> builder = ImmutableMap.builder();
            for (Map.Entry<?, ?> entry : ((Map<?, ?>) object).entrySet()) {
                builder.put(entry.getKey().toString(), ensureMappingOf(entry.getValue()));
            }
            return builder.build();
        } else if (object instanceof Collection) {
            final ImmutableList.Builder<Object> builder = ImmutableList.builder();
            for (Object entry : (Collection) object) {
                builder.add(ensureMappingOf(entry));
            }
            return builder.build();
        } else {
            return object;
        }
    }

    private Optional<DataView> getUnsafeView(DataQuery path) {
        return get(path).filter(obj -> obj instanceof DataView).map(obj -> (DataView) obj);
    }

    @Override
    public Optional<Boolean> getBoolean(DataQuery path) {
        return get(path).flatMap(Coerce::asBoolean);
    }

    @Override
    public Optional<Byte> getByte(DataQuery path) {
        return get(path).flatMap(Coerce::asByte);
    }

    @Override
    public Optional<Short> getShort(DataQuery path) {
        return get(path).flatMap(Coerce::asShort);
    }

    @Override
    public Optional<Integer> getInt(DataQuery path) {
        return get(path).flatMap(Coerce::asInteger);
    }

    @Override
    public Optional<Long> getLong(DataQuery path) {
        return get(path).flatMap(Coerce::asLong);
    }

    @Override
    public Optional<Float> getFloat(DataQuery path) {
        return get(path).flatMap(Coerce::asFloat);
    }

    @Override
    public Optional<Double> getDouble(DataQuery path) {
        return get(path).flatMap(Coerce::asDouble);
    }

    @Override
    public Optional<String> getString(DataQuery path) {
        return get(path).flatMap(Coerce::asString);
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
        return Optional.empty();
    }

    @Override
    public Optional<List<String>> getStringList(DataQuery path) {
        return getUnsafeList(path).map(list ->
                list.stream()
                        .map(Coerce::asString)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList())
        );
    }

    private Optional<List<?>> getUnsafeList(DataQuery path) {
        return get(path)
                .filter(obj -> obj instanceof List<?> || obj instanceof Object[])
                .map(obj -> {
                    if (obj instanceof List<?>) {
                        return (List<?>) obj;
                    } else {
                        return Arrays.asList((Object[]) obj);
                    }
                }
        );
    }

    @Override
    public Optional<List<Character>> getCharacterList(DataQuery path) {
        return getUnsafeList(path).map(list ->
                list.stream()
                        .map(Coerce::asChar)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public Optional<List<Boolean>> getBooleanList(DataQuery path) {
        return getUnsafeList(path).map(list ->
                list.stream()
                        .map(Coerce::asBoolean)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public Optional<List<Byte>> getByteList(DataQuery path) {
        return getUnsafeList(path).map(list ->
                list.stream()
                        .map(Coerce::asByte)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public Optional<List<Short>> getShortList(DataQuery path) {
        return getUnsafeList(path).map(list ->
                list.stream()
                        .map(Coerce::asShort)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public Optional<List<Integer>> getIntegerList(DataQuery path) {
        return getUnsafeList(path).map(list ->
                list.stream()
                        .map(Coerce::asInteger)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public Optional<List<Long>> getLongList(DataQuery path) {
        return getUnsafeList(path).map(list ->
                list.stream()
                        .map(Coerce::asLong)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public Optional<List<Float>> getFloatList(DataQuery path) {
        return getUnsafeList(path).map(list ->
                list.stream()
                        .map(Coerce::asFloat)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public Optional<List<Double>> getDoubleList(DataQuery path) {
        return getUnsafeList(path).map(list ->
                list.stream()
                        .map(Coerce::asDouble)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public Optional<List<Map<?, ?>>> getMapList(DataQuery path) {
        return getUnsafeList(path).<List<Map<?, ?>>>map(list ->
                list.stream()
                        .filter(obj -> obj instanceof Map<?, ?>)
                        .map(obj -> (Map<?, ?>) obj)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public Optional<List<DataView>> getViewList(DataQuery path) {
        return getUnsafeList(path).map(list ->
                list.stream()
                        .filter(obj -> obj instanceof DataView)
                        .map(obj -> (DataView) obj)
                        .collect(Collectors.toList())
        );
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends DataSerializable> Optional<T> getSerializable(DataQuery path, Class<T> clazz) {
        checkNotNull(path, "path");
        checkNotNull(clazz, "clazz");
        if (clazz.isAssignableFrom(CatalogType.class)) {
            final Optional<T> catalog = (Optional<T>) getCatalogType(path, ((Class<? extends CatalogType>) clazz));
            if (catalog.isPresent()) {
                return catalog;
            }
        }

        return getUnsafeView(path).flatMap(view -> Sponge.getDataManager().getBuilder(clazz)
                .flatMap(builder -> builder.build(view))
        );
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends DataSerializable> Optional<List<T>> getSerializableList(DataQuery path, Class<T> clazz) {
        checkNotNull(path, "path");
        checkNotNull(clazz, "clazz");
        return Stream.<Supplier<Optional<List<T>>>>of(
                () -> {
                    if (clazz.isAssignableFrom(CatalogType.class)) {
                        return (Optional<List<T>>) (Optional<?>) getCatalogTypeList(path, (Class<? extends CatalogType>) clazz);
                    }
                    return Optional.empty();
                },
                () -> getViewList(path).flatMap(list ->
                        Sponge.getDataManager().getBuilder(clazz).map(builder ->
                                list.stream()
                                        .map(builder::build)
                                        .filter(Optional::isPresent)
                                        .map(Optional::get)
                                        .collect(Collectors.toList())
                        )
                    )
                )
                .map(Supplier::get)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();

    }

    @Override
    public <T extends CatalogType> Optional<T> getCatalogType(DataQuery path, Class<T> catalogType) {
        checkNotNull(path, "path");
        checkNotNull(catalogType, "dummy type");
        return getString(path).flatMap(string -> Sponge.getRegistry().getType(catalogType, string));
    }

    @Override
    public <T extends CatalogType> Optional<List<T>> getCatalogTypeList(DataQuery path, Class<T> catalogType) {
        checkNotNull(path, "path");
        checkNotNull(catalogType, "catalogType");
        return getStringList(path).map(list ->
                list.stream()
                        .map(string -> Sponge.getRegistry().getType(catalogType, string))
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public <T> Optional<T> getObject(DataQuery path, Class<T> objectClass) {
        return getView(path).flatMap(view ->
                Sponge.getDataManager().getTranslator(objectClass)
                        .flatMap(serializer -> serializer.translate(view))
        );
    }

    @Override
    public <T> Optional<List<T>> getObjectList(DataQuery path, Class<T> objectClass) {
        return getViewList(path).flatMap(viewList ->
                Sponge.getDataManager().getTranslator(objectClass).map(serializer ->
                        viewList.stream()
                                .map(serializer::translate)
                                .filter(Optional::isPresent)
                                .map(Optional::get)
                                .collect(Collectors.toList())
                )
        );
    }

    @Override
    public DataContainer copy() {
        final DataContainer container = new MemoryDataContainer();
        getKeys(false).stream()
                .forEach(query ->
                        get(query).ifPresent(obj ->
                                container.set(query, obj)
                        )
                );
        return container;
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

    @Override
    public String toString() {
        final Objects.ToStringHelper helper = Objects.toStringHelper(this);
        if (!this.path.toString().isEmpty()) {
            helper.add("path", this.path);
        }
        return helper.add("map", this.map).toString();
    }
}
