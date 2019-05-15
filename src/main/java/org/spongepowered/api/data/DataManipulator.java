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

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.ImmutableValueStore;
import org.spongepowered.api.data.value.MergeFunction;
import org.spongepowered.api.data.value.MutableValueStore;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.util.annotation.eventgen.TransformWith;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Represents a changelist of data that can be applied to a {@link org.spongepowered.api.data.DataHolder.Mutable}.
 * With a {@link DataManipulator}, specific sets of mutable data can be
 * represented and changed outside the live state of the {@link org.spongepowered.api.data.DataHolder.Mutable}.
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
     * {@link Value}s are copied into their {@link org.spongepowered.api.data.value.Value.Mutable}}
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
     * {@link DataManipulator} such that all backed {@link org.spongepowered.api.data.value.Value.Mutable}}s are copied
     * into {@link org.spongepowered.api.data.value.Value.Immutable}} counterparts. Any changes to this
     * {@link DataManipulator} will NOT be reflected on the returned
     * {@link Immutable} and vice versa.
     *
     * @return This {@link DataManipulator}'s data copied into a
     *     {@link Immutable}
     */
    Immutable asImmutable();

    interface Immutable extends DataManipulator {

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

        /**
         * Creates a {@link Immutable} view directly based on the
         * {@link Value}s. No unnecessary copies of the {@link Value}s
         * will be created.
         *
         * @param values The values
         * @return The immutable data manipulator view
         */
        static Immutable viewOf(Iterable<Value<?>> values) {
            return Sponge.getRegistry().requireFactory(Factory.class).viewOf(values);
        }

        static Immutable viewOf(ValueContainer valueContainer) {
            return Sponge.getRegistry().requireFactory(Factory.class).viewOf(valueContainer);
        }

        /**
         * Gets a empty {@link ImmutableValueStore}.
         *
         * @return The empty immutable data manipulator
         */
        static Immutable empty() {
            return Sponge.getRegistry().requireFactory(Factory.class).of();
        }

        /**
         * Gets a {@link ImmutableValueStore} with the given values.
         *
         * @param values The values
         * @return The immutable data manipulator
         */
        static Immutable of(Iterable<? extends Value<?>> values) {
            return Sponge.getRegistry().requireFactory(Factory.class).of(values);
        }

        /**
         * Creates a new {@link Immutable} with the provided value
         * if the {@link Key} is supported by this {@link Immutable}
         * without exception.
         *
         * @param key The key to use
         * @param value The value to set
         * @param <E> The type of value
         * @return The new immutable data manipulator
         */
        default <E> Immutable with(Key<? extends Value<E>> key, E value) {
            return asMutable().set(key, value).asImmutable();
        }

        /**
         * Creates a new {@link Immutable} without the given {@link Key}.
         *
         * @param key The key to use
         * @return The new immutable data manipulator
         */
        default Immutable without(Key<?> key) {
            return asMutable().remove(key).asImmutable();
        }

        /**
         * Creates a new {@link Immutable} with the provided
         * {@link Value} provided that the {@link Value} is supported by
         * this {@link Immutable}.
         *
         * @param value The value to set
         * @return The new immutable data manipulator
         */
        default <E> Immutable with(Value<E> value) {
            return with(value.getKey(), value.get());
        }

        /**
         * Applies a transformation on the provided value if the key is available. This
         * is the same as {@link ImmutableValueStore#transform(Key, Function)}.
         *
         * @param key The key to use
         * @param function The function to apply
         * @param <E> The type of element
         * @return This manipulator, for chaining
         */
        default <E> Immutable transform(Key<? extends Value<E>> key, Function<E, E> function) {
            checkNotNull(function, "function");
            return get(key).map(element -> with(key, checkNotNull(function.apply(element)))).orElse(this);
        }

        interface Factory {

            Immutable of();

            Immutable of(Iterable<? extends Value<?>> values);

            Immutable viewOf(Iterable<Value<?>> values);

            Immutable viewOf(ValueContainer valueContainer);
        }
    }

    /**
     * Represents a changelist of data that can be applied to a {@link DataHolder}.
     * With a {@link Mutable}, specific sets of mutable data can be
     * represented and changed outside the live state of the {@link DataHolder}.
     */
    interface Mutable extends DataManipulator {
        static Mutable of() {
            return Sponge.getRegistry().requireFactory(Mutable.Factory.class).of();
        }

        static Mutable of(Iterable<? extends Value<?>> values) {
            return Sponge.getRegistry().requireFactory(Mutable.Factory.class).of(values);
        }

        static Mutable of(ValueContainer valueContainer) {
            return Sponge.getRegistry().requireFactory(Mutable.Factory.class).of(valueContainer);
        }


        /**
         * Attempts to read data from the given {@link ValueContainer} and fills the
         * associated data onto this {@link Mutable}. Only {@link Key}s
         * that match the predicate will be copied.
         *
         * <p>Any data that overlaps existing data from the {@link ValueContainer} will
         * take priority and be overwritten from the pre-existing data from the
         * {@link ValueContainer}.
         *
         * @param valueContainer The {@link ValueContainer} to copy data from
         * @return This {@link Mutable} with relevant data filled from the
         *           given {@link ValueContainer}
         */
        Mutable copyFrom(ValueContainer valueContainer, Predicate<Key<?>> predicate);

        /**
         * Attempts to read data from the given {@link ValueContainer} and fills the
         * associated data onto this {@link Mutable}. Only the values of
         * the provided {@link Key}s will be copied if present.
         *
         * <p>Any data that overlaps existing data from the {@link ValueContainer} will
         * take priority and be overwritten from the pre-existing data from the
         * {@link ValueContainer}.
         *
         * @param valueContainer The {@link ValueContainer} to copy data from
         * @return This {@link Mutable} with relevant data filled from the
         *           given {@link ValueContainer}
         */
        default Mutable copyFrom(ValueContainer valueContainer, Key<?> first, Key<?>... more) {
            return copyFrom(valueContainer, MergeFunction.IGNORE_ALL, first, more);
        }

        /**
         * Attempts to read data from the given {@link ValueContainer} and fills the
         * associated data onto this {@link Mutable}. Only the values of
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
         * @return This {@link Mutable} with relevant data filled from the
         *           given {@link ValueContainer}
         */
        default Mutable copyFrom(ValueContainer valueContainer, MergeFunction overlap, Key<?> first, Key<?>... more) {
            return copyFrom(valueContainer, overlap, ImmutableList.<Key<?>>builder().add(first).add(more).build());
        }

        /**
         * Attempts to read data from the given {@link ValueContainer} and fills the
         * associated data onto this {@link Mutable}. Only the values of
         * the provided {@link Key}s will be copied if present.
         *
         * <p>Any data that overlaps existing data from the {@link ValueContainer} will
         * take priority and be overwritten from the pre-existing data from the
         * {@link ValueContainer}.
         *
         * @param valueContainer The {@link ValueContainer} to copy data from
         * @return This {@link Mutable} with relevant data filled from the
         *           given {@link ValueContainer}
         */
        default Mutable copyFrom(ValueContainer valueContainer, Iterable<Key<?>> keys) {
            return copyFrom(valueContainer, MergeFunction.IGNORE_ALL, keys);
        }

        /**
         * Attempts to read data from the given {@link ValueContainer} and fills the
         * associated data onto this {@link Mutable}. Only the values of
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
         * @return This {@link Mutable} with relevant data filled from the
         *           given {@link ValueContainer}
         */
        Mutable copyFrom(ValueContainer valueContainer, MergeFunction overlap, Iterable<Key<?>> keys);

        /**
         * Attempts to read data from the given {@link ValueContainer} and fills the
         * associated data onto this {@link Mutable}.
         *
         * <p>Any values that overlaps existing values from the {@link ValueContainer} will
         * take priority and be overwritten from the pre-existing data from the
         * {@link ValueContainer}.
         *
         * @param valueContainer The {@link ValueContainer} to extract data from
         * @return This {@link Mutable} with relevant data filled from the
         *           given {@link DataHolder}
         */
        default Mutable copyFrom(ValueContainer valueContainer) {
            return copyFrom(valueContainer, MergeFunction.IGNORE_ALL);
        }

        /**
         * Attempts to read data from the given {@link ValueContainer} and fills the
         * associated data onto this {@link Mutable}. Any data that
         * overlaps between this and the given {@link DataHolder} will be resolved
         * using the given {@link MergeFunction}.
         *
         * <p>Any values that overlaps existing values from the {@link ValueContainer} will
         * take priority and be overwritten from the pre-existing data from the
         * {@link ValueContainer}.
         *
         * @param valueContainer The {@link ValueContainer} to extract data from
         * @return This {@link Mutable} with relevant data filled from the
         *           given {@link DataHolder}
         */
        Mutable copyFrom(ValueContainer valueContainer, MergeFunction overlap);

        /**
         * Sets the supported {@link Key}'s value such that the value is set on
         * this {@link Mutable} without having to directly set the
         * {@link org.spongepowered.api.data.value.Value.Mutable}} and {@link #set(Value)} afterwards. The requirement
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
        @SuppressWarnings("unchecked")
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

        Mutable remove(Key<?> key);

        @Override
        Immutable asImmutable();

        @Override
        default Mutable asMutable() {
            return this;
        }

        @Override
        Mutable copy();

        interface Factory {

            Mutable of();

            Mutable of(Iterable<? extends Value<?>> values);

            Mutable of(ValueContainer valueContainer);
        }

    }
}
