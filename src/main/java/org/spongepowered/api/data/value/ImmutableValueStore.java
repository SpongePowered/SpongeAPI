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
package org.spongepowered.api.data.value;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataProvider;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.merge.MergeFunction;

import java.util.Optional;
import java.util.function.Function;

/**
 * Represents a {@link ValueContainer} that is immutable once created and
 * contains a various bundle of {@link ValueContainer}s of type declared by
 * the extension that can be managed separately from this immutable value
 * store.
 *
 * @param <I> The type of immutable value store, for self referencing
 */
public interface ImmutableValueStore<I extends ImmutableValueStore<I>> extends ValueContainer {

    /**
     * Gets a empty {@link ImmutableValueStore}.
     *
     * @return The empty immutable value store
     */
    static ImmutableValueStore.Simple empty() {
        return Sponge.getRegistry().requireFactory(Factory.class).of();
    }

    /**
     * Gets a {@link ImmutableValueStore} with the given values.
     *
     * @param values The values
     * @return The immutable value store
     */
    static ImmutableValueStore.Simple of(Iterable<? extends Value<?>> values) {
        return Sponge.getRegistry().requireFactory(Factory.class).of(values);
    }

    /**
     * Applies a transformation on the provided {@link Value} such that
     * the return value of {@link Function#apply(Object)} will become the end
     * resulting value set into the newly created {@link ImmutableValueStore}.
     *
     * @param key The key linked to
     * @param function The function to manipulate the value
     * @param <E> The type of value
     * @return The newly created immutable value store
     */
    <E> Optional<I> transform(Key<? extends Value<E>> key, Function<E, E> function);

    /**
     * Creates a new {@link ImmutableValueStore} with the provided
     * value by {@link Key}. If the key is supported by this value store,
     * the returned value store will be present.
     *
     * @param key The key to the value to set
     * @param value The value to set
     * @param <E> The type of value
     * @return The new immutable value store
     */
    <E> Optional<I> with(Key<? extends Value<E>> key, E value);

    /**
     * Offers the given {@code value} as defined by the provided {@link Key}
     * such that if the {@link Key} is supported, a new
     * {@link ImmutableValueStore} is created.
     *
     * @param value The value to set
     * @return The new immutable value store
     */
    Optional<I> with(Value<?> value);

    /**
     * Attempts to merge the {@link Value.Immutable}s from this
     * {@link ImmutableValueStore} and the given {@link ImmutableValueStore} to
     * produce a new instance of the merged result.
     *
     * @param that The other immutable value store to gather values from
     * @return The new immutable value store instance
     */
    I merge(I that);

    /**
     * Attempts to merge the {@link Value.Immutable}s from this
     * {@link ImmutableValueStore} and the given {@link ImmutableValueStore} to
     * produce a new instance of the merged result. Any overlapping
     * {@link ValueContainer}s are merged through the {@link MergeFunction}.
     *
     * @param that The other immutable value store to gather values from
     * @param function The function to resolve merge conflicts
     * @return The new immutable value store instance
     */
    I merge(I that, MergeFunction function);

    @Override
    I copy();

    /**
     * A simple version of the {@link ImmutableValueStore}. By default will the simple
     * {@link ImmutableValueStore} support every {@link Key} unless a bound
     * {@link DataProvider} said otherwise.
     */
    interface Simple extends ImmutableValueStore<Simple> {

        @Override
        default Simple copy() {
            return this;
        }

        /**
         * Creates a composite copy of this simple {@link ImmutableValueStore}.
         *
         * @return The composite copy
         */
        CompositeValueStore.Simple toComposite(); // TODO: toMutable? Rename CompositeValueStore to MutableValueStore for consistency?
    }

    interface Factory {

        Simple of();

        Simple of(Iterable<? extends Value<?>> values);
    }
}
