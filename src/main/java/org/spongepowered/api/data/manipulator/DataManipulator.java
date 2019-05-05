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
package org.spongepowered.api.data.manipulator;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.value.MutableValueStore;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.util.annotation.eventgen.TransformWith;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Represents a changelist of data that can be applied to a {@link DataHolder}.
 * With a {@link DataManipulator}, specific sets of mutable data can be
 * represented and changed outside the live state of the {@link DataHolder}.
 *
 * <p>{@link DataManipulator}s are serializable such that they can be serialized
 * and deserialized from persistence, and applied to {@link DataHolder}s, even
 * with specialized {@link Function}s to use {@link #transform(Key, Function)}
 * such that the {@link DataManipulator} is always returned.</p>
 */
public interface DataManipulator extends ValueContainer {

    /**
     * Attempts to read data from the given {@link ValueContainer} and fills the
     * associated data onto this {@link DataManipulator}. Only {@link Key}s
     * that match the predicate will be copied.
     *
     * <p>Any data that overlaps existing data from the {@link ValueContainer} will
     * take priority and be overwritten from the pre-existing data from the
     * {@link ValueContainer}.
     *
     * @param valueContainer The {@link ValueContainer} to copy data from
     * @return This {@link DataManipulator} with relevant data filled from the
     *           given {@link ValueContainer}
     */
    DataManipulator copyFrom(ValueContainer valueContainer, Predicate<Key<?>> predicate);

    /**
     * Attempts to read data from the given {@link ValueContainer} and fills the
     * associated data onto this {@link DataManipulator}. Only the values of
     * the provided {@link Key}s will be copied if present.
     *
     * <p>Any data that overlaps existing data from the {@link ValueContainer} will
     * take priority and be overwritten from the pre-existing data from the
     * {@link ValueContainer}.
     *
     * @param valueContainer The {@link ValueContainer} to copy data from
     * @return This {@link DataManipulator} with relevant data filled from the
     *           given {@link ValueContainer}
     */
    default DataManipulator copyFrom(ValueContainer valueContainer, Key<?> first, Key<?>... more) {
        return copyFrom(valueContainer, MergeFunction.IGNORE_ALL, first, more);
    }

    /**
     * Attempts to read data from the given {@link ValueContainer} and fills the
     * associated data onto this {@link DataManipulator}. Only the values of
     * the provided {@link Key}s will be copied if present. Any data that
     * overlaps between this and the given {@link DataHolder} will be resolved
     * using the given {@link MergeFunction}.
     *
     * <p>Any data that overlaps existing data from the {@link ValueContainer} will
     * take priority and be overwritten from the pre-existing data from the
     * {@link ValueContainer}.
     *
     * @param valueContainer The {@link ValueContainer} to copy data from
     * @param overlap The overlap resolver to decide which value to retain
     * @return This {@link DataManipulator} with relevant data filled from the
     *           given {@link ValueContainer}
     */
    default DataManipulator copyFrom(ValueContainer valueContainer, MergeFunction overlap, Key<?> first, Key<?>... more) {
        return copyFrom(valueContainer, overlap, ImmutableList.<Key<?>>builder().add(first).add(more).build());
    }

    /**
     * Attempts to read data from the given {@link ValueContainer} and fills the
     * associated data onto this {@link DataManipulator}. Only the values of
     * the provided {@link Key}s will be copied if present.
     *
     * <p>Any data that overlaps existing data from the {@link ValueContainer} will
     * take priority and be overwritten from the pre-existing data from the
     * {@link ValueContainer}.
     *
     * @param valueContainer The {@link ValueContainer} to copy data from
     * @return This {@link DataManipulator} with relevant data filled from the
     *           given {@link ValueContainer}
     */
    default DataManipulator copyFrom(ValueContainer valueContainer, Iterable<Key<?>> keys) {
        return copyFrom(valueContainer, MergeFunction.IGNORE_ALL, keys);
    }

    /**
     * Attempts to read data from the given {@link ValueContainer} and fills the
     * associated data onto this {@link DataManipulator}. Only the values of
     * the provided {@link Key}s will be copied if present. Any data that
     * overlaps between this and the given {@link DataHolder} will be resolved
     * using the given {@link MergeFunction}.
     *
     * <p>Any data that overlaps existing data from the {@link ValueContainer} will
     * take priority and be overwritten from the pre-existing data from the
     * {@link ValueContainer}.
     *
     * @param valueContainer The {@link ValueContainer} to copy data from
     * @param overlap The overlap resolver to decide which value to retain
     * @return This {@link DataManipulator} with relevant data filled from the
     *           given {@link ValueContainer}
     */
    DataManipulator copyFrom(ValueContainer valueContainer, MergeFunction overlap, Iterable<Key<?>> keys);

    /**
     * Attempts to read data from the given {@link ValueContainer} and fills the
     * associated data onto this {@link DataManipulator}.
     *
     * <p>Any values that overlaps existing values from the {@link ValueContainer} will
     * take priority and be overwritten from the pre-existing data from the
     * {@link ValueContainer}.
     *
     * @param valueContainer The {@link ValueContainer} to extract data from
     * @return This {@link DataManipulator} with relevant data filled from the
     *           given {@link DataHolder}
     */
    default DataManipulator copyFrom(ValueContainer valueContainer) {
        return copyFrom(valueContainer, MergeFunction.IGNORE_ALL);
    }

    /**
     * Attempts to read data from the given {@link ValueContainer} and fills the
     * associated data onto this {@link DataManipulator}. Any data that
     * overlaps between this and the given {@link DataHolder} will be resolved
     * using the given {@link MergeFunction}.
     *
     * <p>Any values that overlaps existing values from the {@link ValueContainer} will
     * take priority and be overwritten from the pre-existing data from the
     * {@link ValueContainer}.
     *
     * @param valueContainer The {@link ValueContainer} to extract data from
     * @return This {@link DataManipulator} with relevant data filled from the
     *           given {@link DataHolder}
     */
    DataManipulator copyFrom(ValueContainer valueContainer, MergeFunction overlap);

    /**
     * Sets the {@link Key}'s value such that the value is set on
     * this {@link DataManipulator} without having to directly set the
     * {@link Value.Mutable} and {@link #set(Value)} afterwards.
     *
     * @param key The key of the value to set
     * @param value The actual value to set
     * @param <E> The type of value
     * @return This manipulator, for chaining
     */
    <E> DataManipulator set(Key<? extends Value<E>> key, E value);

    DataManipulator remove(Key<?> key);

    /**
     * Sets the {@link Value} onto this {@link DataManipulator}.
     *
     * @param value The actual value to set
     * @return This manipulator, for chaining
     */
    default <E> DataManipulator set(Value<E> value) {
        return set(value.getKey(), value.get());
    }

    /**
     * Sets the {@link Value}s onto this {@link DataManipulator}.
     *
     * @param values The actual values to set
     * @return This manipulator, for chaining
     */
    default DataManipulator set(Value<?>... values) {
        for (Value<?> value : checkNotNull(values)) {
            try {
                set(checkNotNull(value, "A null value was provided!"));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    /**
     * Sets the {@link Value}s onto this {@link DataManipulator}.
     *
     * @param values The actual values to set
     * @return This manipulator, for chaining
     */
    default DataManipulator set(Iterable<? extends Value<?>> values) {
        for (Value<?> value : checkNotNull(values)) {
            try {
                set(checkNotNull(value, "A null value was provided!"));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    /**
     * Applies a transformation on the provided value if the key is available. This
     * is the same as {@link MutableValueStore#transform(Key, Function)}.
     *
     * @param key The key to use
     * @param function The function to apply
     * @param <E> The type of element
     * @return This manipulator, for chaining
     */
    default <E> DataManipulator transform(Key<? extends Value<E>> key, Function<E, E> function) {
        checkNotNull(function, "function");
        get(key).ifPresent(element -> set(key, checkNotNull(function.apply(element))));
        return this;
    }

    @TransformWith
    @Override
    DataManipulator copy();

    /**
     * Gets an {@link ImmutableDataManipulator} copy of this
     * {@link DataManipulator} such that all backed {@link Value.Mutable}s are copied
     * into {@link Value.Immutable} counterparts. Any changes to this
     * {@link DataManipulator} will NOT be reflected on the returned
     * {@link ImmutableDataManipulator} and vice versa.
     *
     * @return This {@link DataManipulator}'s data copied into a
     *     {@link ImmutableDataManipulator}
     */
    ImmutableDataManipulator asImmutable();
}
