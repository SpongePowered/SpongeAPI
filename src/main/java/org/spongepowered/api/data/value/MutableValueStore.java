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

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataProvider;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.merge.MergeFunction;

import java.util.function.Function;

/**
 * Represents a {@link ValueContainer} that contains a various bundle of
 * {@link ValueContainer}s of type declared by the extension that can be
 * manipulated separately from this {@link MutableValueStore}.
 */
public interface MutableValueStore extends ValueContainer {

    static MutableValueStore.Simple of() {
        return Sponge.getRegistry().requireFactory(Factory.class).of();
    }

    static MutableValueStore.Simple of(Iterable<? extends Value<?>> values) {
        return Sponge.getRegistry().requireFactory(Factory.class).of(values);
    }

    static MutableValueStore.Simple of(ValueContainer valueContainer) {
        return Sponge.getRegistry().requireFactory(Factory.class).of(valueContainer);
    }

    static MutableValueStore.Simple ofKeysFrom(ValueContainer valueContainer, Key<?> firstKey, Key<?> moreKeys) { // TODO: Better name?
        return Sponge.getRegistry().requireFactory(Factory.class).ofKeysFrom(valueContainer, firstKey, moreKeys);
    }

    static MutableValueStore.Simple ofKeysFrom(ValueContainer valueContainer, Iterable<Key<?>> keys) { // TODO: Better name?
        return Sponge.getRegistry().requireFactory(Factory.class).ofKeysFrom(valueContainer, keys);
    }

    /**
     * Applies a transformation on the provided {@link Value} such that
     * the return value of {@link Function#apply(Object)} will become the end
     * resulting value set into this {@link MutableValueStore}. It is not
     * necessary that the input is actually present, in which case the
     * {@link Key}ed data is compatible, but not necessarily present. Writing
     * a {@link Function} to properly handle the potential for a null input
     * is required for this method to execute without exception.
     *
     * @param key The key linked to
     * @param function The function to manipulate the value
     * @param <E> The type of value
     * @return The end resulting value
     */
    default <E> DataTransactionResult transform(Key<? extends Value<E>> key, Function<E, E> function) {
        if (supports(key)) {
            return offer(key, checkNotNull(function.apply(get(key).orElse(null))));
        }
        return DataTransactionResult.failNoData();
    }

    /**
     * Offers the given {@code value} as defined by the provided {@link Key}
     * such that a {@link DataTransactionResult} is returned for any
     * successful, rejected, and replaced {@link Value}s from this
     * {@link MutableValueStore}.
     *
     * @param key The key to the value to set
     * @param value The value to set
     * @param <E> The type of value
     * @return The transaction result
     */
    <E> DataTransactionResult offer(Key<? extends Value<E>> key, E value);

    /**
     * Offers the given {@link Value} as defined by the provided
     * {@link Key} such that a {@link DataTransactionResult} is returned for
     * any successful, rejected, and replaced {@link Value}s from this
     * {@link MutableValueStore}.
     *
     * @param value The value to set
     * @param <E> The type of the element wrapped by the value
     * @return The transaction result
     */
    default <E> DataTransactionResult offer(Value<E> value) {
        return offer(value.getKey(), value.get());
    }


    /**
     * Offers the given {@code value} as defined by the provided {@link Key}
     * such that a {@link DataTransactionResult} is returned for any
     * successful {@link Value}s from this {@link MutableValueStore}.
     * Intentionally, however, this differs from {@link #offer(Key, Object)}
     * as it will intentionally throw an exception if the result was a failure.
     *
     * @param key The key to the value to set
     * @param value The value to set
     * @param <E> The type of value
     * @return The transaction result
     * @throws IllegalArgumentException If the result is a failure likely due to
     *     incompatibility
     */
    default <E> DataTransactionResult tryOffer(Key<? extends Value<E>> key, E value) throws IllegalArgumentException {
        final DataTransactionResult result = offer(key, value);
        if (!result.isSuccessful()) {
            throw new IllegalArgumentException("Failed offer transaction!");
        }
        return result;
    }

    /**
     * Offers the given {@code value} as defined by the provided {@link Key}
     * such that a {@link DataTransactionResult} is returned for any
     * successful {@link Value}s from this {@link MutableValueStore}.
     * Intentionally, however, this differs from {@link #offer(Key, Object)}
     * as it will intentionally throw an exception if the result was a failure.
     *
     * @param value The value to set
     * @param <E> The type of value
     * @return The transaction result
     * @throws IllegalArgumentException If the result is a failure likely due to
     *     incompatibility
     */
    default <E> DataTransactionResult tryOffer(Value<E> value) throws IllegalArgumentException {
        final DataTransactionResult result = offer(value.getKey(), value.get());
        if (!result.isSuccessful()) {
            throw new IllegalArgumentException("Failed offer transaction!");
        }
        return result;
    }

    /**
     * Attempts to remove the provided {@link Value}. All values that were
     * successfully removed will be provided in
     * {@link DataTransactionResult#getReplacedData()}. If the data can not be
     * removed, the result will be an expected
     * {@link DataTransactionResult.Type#FAILURE}.
     *
     * @param value The value to remove
     * @return The transaction result
     */
    default DataTransactionResult remove(Value<?> value) {
        return remove(value.getKey());
    }

    /**
     * Attempts to remove the data associated with the provided {@link Key}.
     * All values that were successfully removed will be provided in
     * {@link DataTransactionResult#getReplacedData()}. If the data can not be
     * removed, the result will be an expected
     * {@link DataTransactionResult.Type#FAILURE}.
     *
     * @param key The key of the data
     * @return The transaction result
     */
    DataTransactionResult remove(Key<?> key);

    /**
     * Attempts to "revert" a {@link DataTransactionResult} such that any
     * of the {@link DataTransactionResult#getReplacedData()} are offered
     * back, and any {@link DataTransactionResult#getSuccessfulData()} are
     * removed if they were not the same types as any exising in the
     * replaced values.
     *
     * @param result The result to undo
     * @return The result of the undo
     */
    DataTransactionResult undo(DataTransactionResult result);

    /**
     * Performs an absolute copy of all {@link Value.Mutable}s and
     * {@link ValueContainer}s to this {@link MutableValueStore} such that
     * any overlapping {@link Value.Mutable}s are offered for replacement. The
     * result is provided as a {@link DataTransactionResult}.
     *
     * @param that The other {@link MutableValueStore} to copy values from
     * @return The transaction result
     */
    default DataTransactionResult copyFrom(ValueContainer that) {
        return copyFrom(that, MergeFunction.IGNORE_ALL);
    }

    /**
     * Performs an absolute copy of all {@link Value.Mutable}s and
     * {@link ValueContainer}s to this {@link MutableValueStore} such that
     * any overlapping {@link Value.Mutable}s are offered for replacement. The
     * result is provided as a {@link DataTransactionResult}.
     *
     * @param that The other {@link MutableValueStore} to copy values from
     * @param function The function to resolve merge conflicts
     * @return The transaction result
     */
    DataTransactionResult copyFrom(ValueContainer that, MergeFunction function);

    /**
     * A simple version of the {@link MutableValueStore}. By default will the simple
     * {@link MutableValueStore} support every {@link Key} unless a bound
     * {@link DataProvider} said otherwise.
     */
    interface Simple extends MutableValueStore, ValueContainer.Simple {

        @Override
        MutableValueStore.Simple copy();

        @Override
        default MutableValueStore.Simple toMutable() {
            return copy();
        }
    }

    interface Factory {

        Simple of();

        Simple of(Iterable<? extends Value<?>> values);

        Simple of(ValueContainer valueContainer);

        Simple ofKeysFrom(ValueContainer valueContainer, Key<?> firstKey, Key<?> moreKeys);

        Simple ofKeysFrom(ValueContainer valueContainer, Iterable<Key<?>> keys);
    }
}
