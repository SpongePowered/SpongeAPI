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

import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.ImmutableValueStore;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueContainer;

import java.util.Optional;

public interface DataProvider<V extends Value<E>, E> {

    boolean allowsAsynchronousAccess();

    Key<V> getKey();

    default Optional<V> getValue(ValueContainer container) {
        return get(container).map(element -> Value.mutableOf(getKey(), element));
    }

    Optional<E> get(ValueContainer container);

    default DataTransactionResult offerValue(ValueContainer container, V value) {
        return offer(container, value.get());
    }

    DataTransactionResult offer(ValueContainer container, E element);

    DataTransactionResult remove(ValueContainer container);

    default <I extends ImmutableValueStore<I>> Optional<I> withValue(I immutableStore, V value) {
        return with(immutableStore, value.get());
    }

    <I extends ImmutableValueStore<I>> Optional<I> with(I immutableStore, E element);

    /**
     * Gets a {@link ImmutableValueStore} without the target {@link Key}, if successful.
     *
     * @param immutableStore The immutable value store
     * @param <I> The type of the immutable value store
     * @return The new value store, if successful
     */
    <I extends ImmutableValueStore<I>> Optional<I> without(I immutableStore);

    boolean isSupported(ValueContainer container);

}
