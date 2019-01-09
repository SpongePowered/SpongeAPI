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
package org.spongepowered.api.data.manipulator.mutable.common;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.Queries;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.Value;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * A base abstract layer for implementing a {@link DataManipulator}. This
 * provides all the otherwise "redundant" code dealing with various methods
 * such as {@link #get(Key)} or {@link #supports(Key)} etc. The root of this
 * implementation relies on a pseudo registration of
 * {@link #registerFieldGetter(Key, Supplier)},
 * {@link #registerFieldSetter(Key, Consumer)},
 * and {@link #registerKeyValue(Key, Supplier)} of which supply and consume
 * values otherwise accessible by fields.
 *
 * @param <M> The mutable data manipulator type
 * @param <I> The immutable data manipulator type
 */
@SuppressWarnings("unchecked")
public abstract class AbstractData<M extends DataManipulator<M, I>, I extends ImmutableDataManipulator<I, M>> implements DataManipulator<M, I> {


    // Ok, so, you're probably asking "Why the hell are you doing this type of hackery?"
    // Answer: Because I'd rather have these abstract functions (read method references)
    // to get and set field values according to the key, and get values based on key
    // instead of using a Value/Data Processor. The advantage of course is that
    // in Java 8, this would all be done with lambda expressions, but since we
    // target Java 6, we can't quite do that... so, this is the compromise.
    //
    // There was a possibility for using annotations, but I (gabizou) decided against
    // it since there's a lot of magic that goes on with it, and there is very little
    // customization when it comes to the method calls for setting/getting the values.
    // The largest issue was implementation. Since most fields are simple to get and
    // set, other values, such as ItemStacks require a bit of finer tuning.
    //
    private final Map<Key<?>, Supplier<Value<?>>> keyValueMap = Maps.newHashMap();
    private final Map<Key<?>, Supplier<?>> keyFieldGetterMap = Maps.newHashMap();
    private final Map<Key<?>, Consumer<Object>> keyFieldSetterMap = Maps.newHashMap();

    protected AbstractData() {
    }

    /**
     * Simple registration method for the keys to value return methods.
     *
     * <p>Note that this is still usable with Java 8 method references.
     * Referencing {@code this::getfoo()} is recommended.</p>
     *
     * @param key The key for the value return type
     * @param function The function for getting the value
     */
    protected final void registerKeyValue(Key<?> key, Supplier<Value<?>> function) {
        this.keyValueMap.put(checkNotNull(key), checkNotNull(function));
    }

    /**
     * Simple registration method for the keys to field getter methods.
     *
     * <p>Note that this is still usable with Java 8 method references.
     * Referencing {@code this::getfoo()} is recommended.</p>
     *
     * @param key The key for the value return type
     * @param function The function for getting the field
     */
    protected final void registerFieldGetter(Key<?> key, Supplier<?> function) {
        this.keyFieldGetterMap.put(checkNotNull(key, "The key cannot be null"), checkNotNull(function, "The function cannot be null"));
    }

    /**
     * Simple registration method for the keys to field setter methods.
     *
     * <p>Note that this is still usable with Java 8 method references.
     * Referencing {@code this::setFoo(something)} is recommended.</p>
     *
     * @param key The key for the value return type
     * @param function The function for setting the field
     */
    @SuppressWarnings("rawtypes")
    protected final <E> void registerFieldSetter(Key<? extends BaseValue<E>> key, Consumer<E> function) {
        this.keyFieldSetterMap.put(checkNotNull(key), checkNotNull((Consumer) function));
    }

    /**
     * A required registration method for registering the various fields and
     * value getters. It's suggested that if multiple fields are used, each
     * field can be represented as a {@link Value} such that there is an
     * associated {@link Key} to "get" that field value.
     */
    protected abstract void registerGettersAndSetters();

    // Beyond this point is all implementation with the getter/setter functions!

    @Override
    public <E> M set(Key<? extends BaseValue<E>> key, E value) {
        checkArgument(supports(key), "This data manipulator doesn't support the following key: " + key.toString());
        this.keyFieldSetterMap.get(key).accept(value);
        return (M) this;
    }

    @Override
    public <E> M transform(Key<? extends BaseValue<E>> key, Function<E, E> function) {
        checkArgument(supports(key));
        this.keyFieldSetterMap.get(key).accept(checkNotNull(function.apply((E) this.keyFieldGetterMap.get(key).get())));
        return (M) this;
    }

    @Override
    public <E> Optional<E> get(Key<? extends BaseValue<E>> key) {
        final Supplier<?> supplier = this.keyFieldGetterMap.get(checkNotNull(key));
        if (supplier == null) {
            return Optional.empty();
        }
        return Optional.of((E) supplier.get());
    }

    @Override
    public <E, V extends BaseValue<E>> Optional<V> getValue(Key<V> key) {
        final Supplier<?> supplier = this.keyValueMap.get(checkNotNull(key));
        if (supplier == null) {
            return Optional.empty();
        }
        return Optional.of((V) supplier.get());
    }

    @Override
    public boolean supports(Key<?> key) {
        return this.keyFieldSetterMap.containsKey(checkNotNull(key));
    }

    @Override
    public Set<Key<?>> getKeys() {
        return ImmutableSet.copyOf(this.keyFieldSetterMap.keySet());
    }

    @Override
    public Set<ImmutableValue<?>> getValues() {
        ImmutableSet.Builder<ImmutableValue<?>> builder = ImmutableSet.builder();
        for (Supplier<Value<?>> function : this.keyValueMap.values()) {
            builder.add(checkNotNull(function.get()).asImmutable());
        }
        return builder.build();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.keyFieldGetterMap, this.keyFieldSetterMap, this.keyValueMap);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final AbstractData other = (AbstractData) obj;
        return Objects.equals(this.keyFieldGetterMap.values().stream()
                                 .map(Supplier::get)
                                 .collect(Collectors.toList()),
                             ((Map<Key<?>, Supplier<?>>) other.keyFieldGetterMap).values().stream()
                                 .map(Supplier::get)
                                 .collect(Collectors.toList()));
    }

    @Override
    public DataContainer toContainer() {
        final DataContainer dataContainer = DataContainer.createNew()
                .set(Queries.CONTENT_VERSION, getContentVersion());
        fillContainer(dataContainer);
        return dataContainer;
    }

    /**
     * Implement this method to add the data to be persisted.
     *
     * @param dataContainer The data container
     * @return The filled data container
     */
    protected DataContainer fillContainer(DataContainer dataContainer) {
        return dataContainer;
    }
}
