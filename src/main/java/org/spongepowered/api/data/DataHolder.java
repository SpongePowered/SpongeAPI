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

import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.data.property.PropertyHolder;
import org.spongepowered.api.data.value.CollectionValue;
import org.spongepowered.api.data.value.MapValue;
import org.spongepowered.api.data.value.MergeFunction;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * A data holder object allows the access of additional data on the object
 * that is not simply expressed by its basic type.
 */
public interface DataHolder extends DataSerializable, PropertyHolder, ValueContainer {

    interface Mutable extends DataHolder {

        /**
         * Validates the container with known data required to set the raw data to
         * this {@link DataHolder}. If the container is incomplete or contains
         * invalid data, <code>false</code> is returned.
         *
         * <p>This validation should be checked prior to calling
         * {@link #setRawData(DataView)} to avoid exceptions.</p>
         *
         * @param container The raw data to validate
         * @return True if the data is valid
         */
        boolean validateRawData(DataView container);

        /**
         * Attempts to set all data of this {@link DataHolder} according to the
         * {@link DataView}'s held information. Using this to modify known to be
         * {@link Key}s provided dynamically through {@link DataProvider}s is
         * unsupported. The format of the {@link DataView}'s contained data is
         * dependent on the type of {@link Mutable} this is. In some cases, the
         * format is specified based on a more specific type, such as for
         * {@link EntityType}s, or {@link ItemType}s.
         *
         * <p>This setter is used to provide setting custom data that is not
         * represented by the Data API, including forge mods and other
         * unknown data. Attempts to validate the provided view is not always
         * possible due to the nature of the data being parsed by the implementation,
         * and only understood by clients. Other cases where the data <b>can</b>
         * be validated and the data is incompatible will end up throwing an
         * {@link InvalidDataException}.</p>
         *
         * @param container A container containing all raw data to set on this
         *     data holder
         * @throws InvalidDataException If the container is missing or has invalid
         *     data that this holder will refuse
         */
        void setRawData(DataView container) throws InvalidDataException;

        @Override
        ValueContainer copy();

        /**
         * Applies a transformation on the provided {@link Value} such that
         * the return value of {@link Function#apply(Object)} will become the end
         * resulting value set into this {@link Mutable}. It is not
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
        default <E> DataTransactionResult transform(Key<? extends Value<E>> key, Function<@NonNull E, @NonNull E> function) {
            if (supports(key)) {
                return get(key)
                    .map(function)
                    .map(value -> offer(key, value))
                    .orElseGet(DataTransactionResult::failNoData);
            }
            return DataTransactionResult.failNoData();
        }

        /**
         * Offers the given {@code value} as defined by the provided {@link Key}
         * such that a {@link DataTransactionResult} is returned for any
         * successful, rejected, and replaced {@link Value}s from this
         * {@link Mutable}.
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
         * {@link Mutable}.
         *
         * @param value The value to set
         * @param <E> The type of the element wrapped by the value
         * @return The transaction result
         */
        default <E> DataTransactionResult offer(Value<E> value) {
            return offer(value.getKey(), value.get());
        }

        <E> DataTransactionResult offerSingle(Key<? extends CollectionValue<E, ?>> key, E element);

        <K, V> DataTransactionResult offerSingle(Key<? extends MapValue<K, V>> key, K valueKey, V value);

        <K, V> DataTransactionResult offerAll(Key<? extends MapValue<K, V>> key, Map<? extends K, ? extends V> map);

        DataTransactionResult offerAll(MapValue<?, ?> value);

         DataTransactionResult offerAll(CollectionValue<?, ?> value);

        <E> DataTransactionResult offerAll(Key<? extends CollectionValue<E, ?>> key, Collection<? extends E> elements);

        <E> DataTransactionResult removeSingle(Key<? extends CollectionValue<E, ?>> key, E element);

        <K> DataTransactionResult removeKey(Key<? extends MapValue<K, ?>> key, K mapKey);

         DataTransactionResult removeAll(CollectionValue<?, ?> value);

        <E> DataTransactionResult removeAll(Key<? extends CollectionValue<E, ?>> key, Collection<? extends E> elements);

        DataTransactionResult removeAll(MapValue<?, ?> value);

        <K, V> DataTransactionResult removeAll(Key<? extends MapValue<K, V>> key, Map<? extends K, ? extends V> map);

        /**
         * Offers the given {@code value} as defined by the provided {@link Key}
         * such that a {@link DataTransactionResult} is returned for any
         * successful {@link Value}s from this {@link Mutable}.
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
        <E> DataTransactionResult tryOffer(Key<? extends Value<E>> key, E value);

        /**
         * Offers the given {@code value} as defined by the provided {@link Key}
         * such that a {@link DataTransactionResult} is returned for any
         * successful {@link Value}s from this {@link Mutable}.
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
         * Performs an absolute copy of all {@link org.spongepowered.api.data.value.Value.Mutable}s and
         * {@link ValueContainer}s to this {@link Mutable} such that
         * any overlapping {@link org.spongepowered.api.data.value.Value.Mutable}s are offered for replacement. The
         * result is provided as a {@link DataTransactionResult}.
         *
         * @param that The other {@link Mutable} to copy values from
         * @return The transaction result
         */
        default DataTransactionResult copyFrom(ValueContainer that) {
            return copyFrom(that, MergeFunction.REPLACEMENT_PREFERRED);
        }

        /**
         * Performs an absolute copy of all {@link org.spongepowered.api.data.value.Value.Mutable}s and
         * {@link ValueContainer}s to this {@link Mutable} such that
         * any overlapping {@link org.spongepowered.api.data.value.Value.Mutable}s are offered for replacement. The
         * result is provided as a {@link DataTransactionResult}.
         *
         * @param that The other {@link Mutable} to copy values from
         * @param function The function to resolve merge conflicts
         * @return The transaction result
         */
        DataTransactionResult copyFrom(ValueContainer that, MergeFunction function);
    }

    interface Immutable<I extends Immutable<I>> extends DataHolder {

        /**
         * Applies a transformation on the provided {@link Value} such that
         * the return value of {@link Function#apply(Object)} will become the end
         * resulting value set into the newly created {@link Immutable}.
         *
         * @param key The key linked to
         * @param function The function to manipulate the value
         * @param <E> The type of value
         * @return The newly created immutable value store
         */
        <E> Optional<I> transform(Key<? extends Value<E>> key, Function<E, E> function);

        /**
         * Creates a new {@link Immutable} with the provided
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
         * {@link Immutable} is created.
         *
         * @param value The value to set
         * @return The new immutable value store
         */
        Optional<I> with(Value<?> value);

        /**
         * Creates a new {@link Immutable} without the key of the provided
         * {@link Value}. If the key is supported by this value store,
         * the returned value store will be present.
         *
         * @param value The value
         * @return The new immutable value store
         */
        default Optional<I> without(Value<?> value) {
            return without(value.getKey());
        }

        /**
         * Creates a new {@link Immutable} without the provided {@link Key}. If the
         * key is supported by this value store, the returned value store will
         * be present.
         *
         * @param key The key to remove
         * @return The new immutable value store
         */
        Optional<I> without(Key<?> key);

        /**
         * Attempts to merge the {@link org.spongepowered.api.data.value.Value.Immutable}s from this
         * {@link Immutable} and the given {@link Immutable} to
         * produce a new instance of the merged result.
         *
         * @param that The other immutable value store to gather values from
         * @return The new immutable value store instance
         */
        default I merge(I that) {
            return merge(that, MergeFunction.REPLACEMENT_PREFERRED);
        }

        /**
         * Attempts to merge the {@link org.spongepowered.api.data.value.Value.Immutable}s from this
         * {@link Immutable} and the given {@link Immutable} to
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
    }

}
