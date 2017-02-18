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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.CompositeValueStore;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.util.annotation.eventgen.TransformWith;

import java.util.Optional;
import java.util.function.Function;

/**
 * Represents a changelist of data that can be applied to a {@link DataHolder}.
 * With a {@link DataManipulator}, specific sets of mutable data can be
 * represented and changed outside the live state of the {@link DataHolder}.
 *
 * <p>{@link DataManipulator}s are serializable such that they can be serialized
 * and deserialized from persistence, and applied to {@link DataHolder}s, even
 * with specialized {@link Function}s to use {@link #transform(Key, Function)}
 * such that the {@link DataManipulator} is always returned.</p>
 *
 * @param <M> The type of {@link DataManipulator} for comparisons
 */
public interface DataManipulator<M extends DataManipulator<M, I>, I extends ImmutableDataManipulator<I, M>> extends DataSerializable,
        ValueContainer<M> {

    /**
     * Attempts to read data from the given {@link DataHolder} and fills the
     * associated data onto this {@link DataManipulator}.
     *
     * <p>Any data that overlaps existing data from the {@link DataHolder} will
     * take priority and be overwritten from the pre-existing data from the
     * {@link DataHolder}. It is recommended that a call from
     * {@link DataHolder#supports(Class)} is checked prior to using this
     * method on any {@link DataHolder}.</p>
     *
     * @param dataHolder The {@link DataHolder} to extract data
     * @return This {@link DataManipulator} with relevant data filled from the
     *     given {@link DataHolder}, if compatible
     */
    default Optional<M> fill(DataHolder dataHolder) {
        return fill(dataHolder, MergeFunction.IGNORE_ALL);
    }

    /**
     * Attempts to read data from the given {@link DataHolder} and fills the
     * associated data onto this {@link DataManipulator}. Any data that
     * overlaps between this and the given {@link DataHolder} will be resolved
     * using the given {@link MergeFunction}.
     *
     * <p>Any data that overlaps existing data from the {@link DataHolder} will
     * take priority and be overwritten from the pre-existing data from the
     * {@link DataHolder}. It is recommended that a call from
     * {@link DataHolder#supports(Class)} is checked prior to using this
     * method on any {@link DataHolder}.</p>
     *
     * @param dataHolder The {@link DataHolder} to extract data
     * @param overlap The overlap resolver to decide which data to retain
     * @return This {@link DataManipulator} with relevant data filled from the
     *     given {@link DataHolder}, if compatible
     */
    Optional<M> fill(DataHolder dataHolder, MergeFunction overlap);

    /**
     * Attempts to read the raw data from the provided {@link DataContainer}.
     * This manipulator should be "reset" to a default state and apply all data
     * from the given {@link DataContainer}. If data is missing from the
     * {@link DataContainer}, {@link Optional#empty()} can be returned.
     *
     * @param container The container of raw data
     * @return This {@link DataManipulator} with relevant data filled from the
     *     given {@link DataContainer}, if compatible
     */
    Optional<M> from(DataContainer container);

    /**
     * Sets the supported {@link Key}'s value such that the value is set on
     * this {@link DataManipulator} without having to directly set the
     * {@link Value} and {@link #set(BaseValue)} afterwards. The requirement
     * for this to succeed is that the {@link Key} must be checked that it is
     * supported via {@link #supports(BaseValue)} or {@link #supports(Key)}
     * otherwise an {@link IllegalArgumentException} may be thrown. For
     * fluency, after setting, this {@link DataManipulator} is returned.
     *
     * @param key The key of the value to set
     * @param value The actual value to set
     * @param <E> The type of value
     * @return This manipulator, for chaining
     */
    <E> M set(Key<? extends BaseValue<E>> key, E value);

    /**
     * Sets the supported {@link BaseValue} onto this {@link DataManipulator}.
     * The requirement for this to succeed is that the {@link BaseValue} is
     * checked for support via {@link #supports(BaseValue)} or
     * {@link #supports(Key)} otherwise an {@link IllegalArgumentException}
     * may be thrown. For fluency, after setting, this {@link DataManipulator}
     * is returned.
     *
     * @param value The actual value to set
     * @return This manipulator, for chaining
     */
    @SuppressWarnings("unchecked")
    default M set(BaseValue<?> value) {
        return set((Key<? extends BaseValue<Object>>) value.getKey(), value.get());
    }

    /**
     * Sets the supported {@link BaseValue}s onto this {@link DataManipulator}.
     * The requirement for this to succeed is that the {@link BaseValue} is
     * checked for support via {@link #supports(BaseValue)} or
     * {@link #supports(Key)} otherwise an {@link IllegalArgumentException}
     * may be thrown. For fluency, after setting, this {@link DataManipulator}
     * is returned.
     *
     * @param values The actual values to set
     * @return This manipulator, for chaining
     */
    @SuppressWarnings("unchecked")
    default M set(BaseValue<?>... values) {
        for (BaseValue<?> value : checkNotNull(values)) {
            try {
                set(checkNotNull(value, "A null value was provided!"));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return (M) this;
    }

    /**
     * Sets the supported {@link BaseValue}s onto this {@link DataManipulator}.
     * The requirement for this to succeed is that the {@link BaseValue} is
     * checked for support via {@link #supports(BaseValue)} or
     * {@link #supports(Key)} otherwise an {@link IllegalArgumentException}
     * may be thrown. For fluency, after setting, this {@link DataManipulator}
     * is returned.
     *
     * @param values The actual values to set
     * @return This manipulator, for chaining
     */
    @SuppressWarnings("unchecked")
    default M set(Iterable<? extends BaseValue<?>> values) {
        for (BaseValue<?> value : checkNotNull(values)) {
            try {
                set(checkNotNull(value, "A null value was provided!"));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return (M) this;
    }

    /**
     * Applies a transformation on the provided value if available. This is
     * the same as {@link CompositeValueStore#transform(Key, Function)}.
     *
     * @param key The key to use
     * @param function The function to apply
     * @param <E> The type of element
     * @return This manipulator, for chaining
     */
    default <E> M transform(Key<? extends BaseValue<E>> key, Function<E, E> function) {
        checkArgument(supports(key), "The provided key is not supported!" + key.toString());
        return set(key, checkNotNull(function.apply(get(key).get()), "The function can not be returning null!"));
    }

    @TransformWith
    @Override
    M copy();

    /**
     * Gets an {@link ImmutableDataManipulator} copy of this
     * {@link DataManipulator} such that all backed {@link Value}s are copied
     * into {@link ImmutableValue} counterparts. Any changes to this
     * {@link DataManipulator} will NOT be reflected on the returned
     * {@link ImmutableDataManipulator} and vice versa.
     *
     * @return This {@link DataManipulator}'s data copied into a
     *     {@link ImmutableDataManipulator}
     */
    I asImmutable();
}
