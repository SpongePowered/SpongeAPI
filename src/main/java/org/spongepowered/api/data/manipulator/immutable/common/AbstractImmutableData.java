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
package org.spongepowered.api.data.manipulator.immutable.common;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableSet;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.Queries;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * An abstract implementation of an {@link ImmutableDataManipulator} such that
 * all fields are declared {@code final} and remain "immutable".
 *
 * @param <I> The immutable data manipulator type
 * @param <M> The mutable manipulator type
 */
@SuppressWarnings("unchecked")
public abstract class AbstractImmutableData<I extends ImmutableDataManipulator<I, M>, M extends DataManipulator<M, I>>
        implements ImmutableDataManipulator<I, M> {

    private final Map<Key<?>, Supplier<ImmutableValue<?>>> keyValueMap = new HashMap<>();
    private final Map<Key<?>, Supplier<?>> keyFieldGetterMap = new HashMap<>();

    protected AbstractImmutableData() {
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
    protected final void registerKeyValue(Key<?> key, Supplier<ImmutableValue<?>> function) {
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
        this.keyFieldGetterMap.put(checkNotNull(key), checkNotNull(function));
    }

    protected abstract void registerGetters();

    @Override
    public final I copy() {
        return (I) this;
    }

    // Beyond this point is involving keyFieldGetters or keyValueGetters. No external
    // implementation required.

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
        final Supplier<ImmutableValue<?>> supplier = this.keyValueMap.get(checkNotNull(key));
        if (supplier == null) {
            return Optional.empty();
        }
        return Optional.of((V) supplier.get());
    }

    @Override
    public boolean supports(Key<?> key) {
        return this.keyFieldGetterMap.containsKey(checkNotNull(key));
    }

    @Override
    public Set<Key<?>> getKeys() {
        return ImmutableSet.copyOf(this.keyValueMap.keySet());
    }

    @Override
    public Set<ImmutableValue<?>> getValues() {
        ImmutableSet.Builder<ImmutableValue<?>> builder = ImmutableSet.builder();
        for (Supplier<ImmutableValue<?>> function : this.keyValueMap.values()) {
            builder.add(checkNotNull(function.get()));
        }
        return builder.build();
    }

    // Then finally traditional java stuff.

    @Override
    public int hashCode() {
        return Objects.hashCode(this.keyFieldGetterMap.values().stream()
                                    .map(Supplier::get)
                                    .collect(Collectors.toList()));
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
        final AbstractImmutableData other = (AbstractImmutableData) obj;
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
