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

import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.MergeFunction;
import org.spongepowered.api.data.value.MutableValueStore;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.util.annotation.eventgen.TransformWith;

import java.util.Optional;
import java.util.function.Function;

/**
 * Represents a changelist of data that can be applied to a {@link DataHolder.Mutable}.
 * With a {@link DataManipulator}, specific sets of mutable data can be
 * represented and changed outside the live state of the {@link DataHolder.Mutable}.
 *
 * <p>{@link DataManipulator}s are serializable such that they can be serialized
 * and deserialized from persistence, and applied to {@link DataHolder}s, even
 * with specialized {@link Function}s to use {@link Mutable#transform(Key, Function)}
 * such that the {@link DataManipulator} is always returned.</p>
 */
public interface DataManipulator extends ValueContainer {

    @TransformWith
    @Override
    DataManipulator copy();

    Mutable asMutableCopy();

    /**
     * Gets a {@link Mutable} copy of this
     * {@link DataManipulator} such that all backed
     * {@link Value}s are copied into their {@link Value.Mutable}
     * counterparts. Any changes to this {@link DataManipulator} will
     * NOT be reflected on the returned {@link Mutable} and vice versa.
     *
     * <p>The cases where this {@link DataManipulator} is already a
     * {@link Mutable}, the same manipulator object is returned.</p>
     *
     * @return This {@link DataManipulator}'s data copied into a
     *     {@link Mutable}
     */
    Mutable asMutable();

    /**
     * Gets an {@link Immutable} copy of this
     * {@link DataManipulator} such that all backed {@link Value.Mutable}s are copied
     * into {@link Value.Immutable} counterparts. Any changes to this
     * {@link DataManipulator} will NOT be reflected on the returned
     * {@link Immutable} and vice versa.
     *
     * @return This {@link DataManipulator}'s data copied into a
     *     {@link Immutable}
     */
    Immutable asImmutable();

    interface Immutable extends DataManipulator {


        /**
         * Creates a new {@link Immutable} with the provided value
         * if the {@link Key} is supported by this {@link Immutable}
         * without exception.
         *
         * @param key The key to use
         * @param value The value to set
         * @param <E> The type of value
         * @return The new immutable data manipulator, if compatible
         */
        default <E> Optional<Immutable> with(Key<? extends Value<E>> key, E value) {
            Mutable data = asMutable();
            return data.supports(key) ? Optional.of(data.set(key, value).asImmutable()) : Optional.empty();
        }

        /**
         * Creates a new {@link Immutable} with the provided
         * {@link Value} provided that the {@link Value} is supported by
         * this {@link Immutable}. A simple check can be called for
         * {@link #supports(Value)} prior to ensure
         * {@link Optional#isPresent()} returns {@code true}.
         *
         * @param value The value to set
         * @return The new immutable data manipulator, if compatible
         */
        @SuppressWarnings("unchecked")
        default Optional<Immutable> with(Value<?> value) {
            return with((Key<? extends Value<Object>>) value.getKey(), value.get());
        }

        @SuppressWarnings("unchecked")
        @Override
        default Immutable copy() {
            return this;
        }

        @Override
        default Immutable asImmutable() {
            return this;
        }

        Mutable asMutable();
    }

    interface Mutable extends DataManipulator {
        /**
         * Attempts to read data from the given {@link DataHolder} and fills the
         * associated data onto this {@link Mutable}.
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
        default Optional<Mutable> fill(DataHolder dataHolder) {
            return fill(dataHolder, MergeFunction.IGNORE_ALL);
        }

        /**
         * Attempts to read data from the given {@link DataHolder} and fills the
         * associated data onto this {@link Mutable}. Any data that
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
         * @return This {@link Mutable} with relevant data filled from the
         *     given {@link DataHolder}, if compatible
         */
        Optional<Mutable> fill(DataHolder dataHolder, MergeFunction overlap);

        /**
         * Attempts to read the raw data from the provided {@link DataContainer}.
         * This manipulator should be "reset" to a default state and apply all data
         * from the given {@link DataContainer}. If data is missing from the
         * {@link DataContainer}, {@link Optional#empty()} can be returned.
         *
         * @param container The container of raw data
         * @return This {@link Mutable} with relevant data filled from the
         *     given {@link DataContainer}, if compatible
         */
        Optional<Mutable> from(DataContainer container);

        /**
         * Sets the supported {@link Key}'s value such that the value is set on
         * this {@link Mutable} without having to directly set the
         * {@link Value.Mutable} and {@link #set(Value)} afterwards. The requirement
         * for this to succeed is that the {@link Key} must be checked that it is
         * supported via {@link #supports(Value)} or {@link #supports(Key)}
         * otherwise an {@link IllegalArgumentException} may be thrown. For
         * fluency, after setting, this {@link Mutable} is returned.
         *
         * @param key The key of the value to set
         * @param value The actual value to set
         * @param <E> The type of value
         * @return This manipulator, for chaining
         */
        <E> Mutable set(Key<? extends Value<E>> key, E value);

        /**
         * Sets the supported {@link Value} onto this {@link Mutable}.
         * The requirement for this to succeed is that the {@link Value} is
         * checked for support via {@link #supports(Value)} or
         * {@link #supports(Key)} otherwise an {@link IllegalArgumentException}
         * may be thrown. For fluency, after setting, this {@link Mutable}
         * is returned.
         *
         * @param value The actual value to set
         * @return This manipulator, for chaining
         */
        default Mutable set(Value<?> value) {
            return set((Key<? extends Value<Object>>) value.getKey(), value.get());
        }

        /**
         * Sets the supported {@link Value}s onto this {@link Mutable}.
         * The requirement for this to succeed is that the {@link Value} is
         * checked for support via {@link #supports(Value)} or
         * {@link #supports(Key)} otherwise an {@link IllegalArgumentException}
         * may be thrown. For fluency, after setting, this {@link Mutable}
         * is returned.
         *
         * @param values The actual values to set
         * @return This manipulator, for chaining
         */
        default Mutable set(Value<?>... values) {
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
         * Sets the supported {@link Value}s onto this {@link Mutable}.
         * The requirement for this to succeed is that the {@link Value} is
         * checked for support via {@link #supports(Value)} or
         * {@link #supports(Key)} otherwise an {@link IllegalArgumentException}
         * may be thrown. For fluency, after setting, this {@link Mutable}
         * is returned.
         *
         * @param values The actual values to set
         * @return This manipulator, for chaining
         */
        default Mutable set(Iterable<? extends Value<?>> values) {
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
         * Applies a transformation on the provided value if available. This is
         * the same as {@link MutableValueStore#transform(Key, Function)}.
         *
         * @param key The key to use
         * @param function The function to apply
         * @param <E> The type of element
         * @return This manipulator, for chaining
         */
        default <E> Mutable transform(Key<? extends Value<E>> key, Function<E, E> function) {
            checkArgument(supports(key), "The provided key is not supported!" + key.toString());
            return set(key, checkNotNull(function.apply(get(key).get()), "The function can not be returning null!"));
        }

        @Override
        Immutable asImmutable();

        @Override
        default Mutable asMutable() {
            return this;
        }

        @Override
        Mutable copy();

    }
}
