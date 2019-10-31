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
import org.spongepowered.api.data.value.CopyableValueContainer;
import org.spongepowered.api.data.value.MergeFunction;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.util.annotation.eventgen.TransformWith;
import org.spongepowered.api.world.World;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

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
public interface DataManipulator extends CopyableValueContainer {

    /**
     * Creates a {@link Immutable} view directly based on the
     * {@link Value}s. No unnecessary copies of the {@link Value}s
     * will be created.
     *
     * @param values The values
     * @return The immutable data manipulator view
     */
    static Immutable immutableOf(Iterable<? extends Value<?>> values) {
        return Sponge.getRegistry().requireFactory(Immutable.Factory.class).of(values);
    }

    /**
     * Creates an {@link Immutable} view directly based on the
     * {@link Value}s provided by the given {@link ValueContainer},
     * such that all {@link ValueContainer#getValues()} will be
     * converted via {@link Value#asImmutable()} and constructed
     * into an {@link Immutable}.
     *
     * @param valueContainer The value container to populate values from
     * @return The immutable manipulator
     */
    static Immutable immutableOf(ValueContainer valueContainer) {
        return Sponge.getRegistry().requireFactory(Immutable.Factory.class).of(valueContainer);
    }

    /**
     * Gets a empty {@link Immutable}.
     *
     * @return The empty immutable data manipulator
     */
    static Immutable immutableOf() {
        return Sponge.getRegistry().requireFactory(Immutable.Factory.class).of();
    }

    /**
     * Creates an empty {@link Mutable} manipulator that can be consumed,
     * populated, and mutated at liberty.
     *
     * @return A new empty manipulator
     */
    static Mutable mutableOf() {
        return Sponge.getRegistry().requireFactory(Mutable.Factory.class).of();
    }

    /**
     * Creates a new {@link DataManipulator} with the provided
     * {@link Iterable Values} such that the resulting {@link Mutable} will
     * contain all said {@link Value values}. The returned
     * {@link DataManipulator manipulator} is still {@link Mutable mutable}.
     *
     * @param values The values to populate the mutable container
     * @return The mutable manipulator containing all values
     */
    static Mutable mutableOf(Iterable<? extends Value<?>> values) {
        return Sponge.getRegistry().requireFactory(Mutable.Factory.class).of(values);
    }

    /**
     * Creates a new {@link DataManipulator} with all {@link Value values}
     * retrievable through the given {@link ValueContainer} by
     * {@link ValueContainer#getValues()} with the connotation that all
     * {@link Value}s are provided, even those that are not persisted or
     * registered through a {@link DataRegistration}.
     *
     * @param valueContainer The value container providing all values
     * @return The mutable manipulator containing all values
     */
    static Mutable mutableOf(ValueContainer valueContainer) {
        return Sponge.getRegistry().requireFactory(Mutable.Factory.class).of(valueContainer);
    }

    @TransformWith
    @Override
    DataManipulator copy();

    /**
     * Creates a new {@link Mutable} copy of all {@link #getValues() Values}
     * contained in this {@link DataManipulator}, regardless whether this is a
     * {@link Mutable mutable} instance already. Changes to this container will
     * <strong>NOT</strong> persist to the copied instance. This is different
     * from {@link #copy()} as the copied instance may not be {@link Mutable}.
     *
     * @return The copied instance
     */
    Mutable asMutableCopy();

    /**
     * Gets a {@link Mutable} copy of this
     * {@link DataManipulator} such that all backed
     * {@link Value}s are copied into their {@link org.spongepowered.api.data.value.Value.Mutable}
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
     * {@link DataManipulator} such that all backed {@link org.spongepowered.api.data.value.Value.Mutable}s are copied
     * into {@link org.spongepowered.api.data.value.Value.Immutable} counterparts. Any changes to this
     * {@link DataManipulator} will NOT be reflected on the returned
     * {@link Immutable} and vice versa.
     *
     * @return This {@link DataManipulator}'s data copied into a
     *     {@link Immutable}
     */
    Immutable asImmutable();

    /**
     * Represents an immutable {@link DataManipulator}. Immutable meaning that
     * the contained {@link #getValues() values} are all likewise
     * {@link org.spongepowered.api.data.value.Value.Immutable}, and as such,
     * cannot be changed themselves, nor can the manipulator be modified to add
     * or remove values. All methods such as {@link #with(Value)} return new
     * instances. It is guaranteed to be thread safe to access values from this
     * container, and seeing as it does not change, can be passed around as a
     * pseudo cache for templating. It is important to note that there is no
     * guarantee on the validity of the stored {@link Value}s that their own data
     * does not "expire", cases may include outdated references of
     * {@link Entity entities} or {@link World worlds} that no longer serve valid
     * purposes.
     *
     * @see <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/immutable.html">Immutable on Oracle Java Docs</a>
     */
    interface Immutable extends DataManipulator {

        @Override
        default Immutable copy() {
            return this;
        }

        @Override
        default Immutable asImmutable() {
            return this;
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
         * @param <E> The type of value
         * @param value The value to set
         * @return The new immutable data manipulator
         */
        default <E> Immutable with(Value<E> value) {
            return with(value.getKey(), value.get());
        }

        /**
         * Applies a transformation on the provided value if the key is available. This
         * is the same as {@link DataHolder.Immutable#transform(Key, Function)}.
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

        /**
         * A factory for generating {@link Immutable}s.
         */
        interface Factory {

            /**
             * Creates an empty {@link Immutable}.
             *
             * @see DataManipulator#immutableOf()
             * @return An empty immutable manipulator
             */
            Immutable of();

            /**
             * Creates an {@link Immutable} view directly based on the
             * {@link Value}s provided by the given {@link Iterable},
             * such that all {@link Iterable#forEach(Consumer)} will be
             * converted via {@link Value#asImmutable()} and constructed
             * into an {@link Immutable}.
             *
             * @see DataManipulator#immutableOf(Iterable)
             * @param values The value container to populate values from
             * @return The immutable manipulator
             */
            Immutable of(Iterable<? extends Value<?>> values);


            /**
             * Creates an {@link Immutable} view directly based on the
             * {@link Value}s provided by the given {@link ValueContainer},
             * such that all {@link ValueContainer#getValues()} will be
             * converted via {@link Value#asImmutable()} and constructed
             * into an {@link Immutable}.
             *
             * @see DataManipulator#immutableOf(ValueContainer)
             * @param valueContainer The value container to populate values from
             * @return The immutable manipulator
             */
            Immutable of(ValueContainer valueContainer);
        }
    }

    /**
     * Represents a changelist of data that can be applied to a {@link DataHolder}.
     * With a {@link Mutable}, specific sets of mutable data can be
     * represented and changed outside the live state of the {@link DataHolder}.
     */
    interface Mutable extends DataManipulator {

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
         * @param predicate The predicate to filter which keys can be copied
         * @return This {@link Mutable} with relevant data filled from the
         *           given {@link ValueContainer}
         */
        default Mutable copyFrom(ValueContainer valueContainer, Predicate<Key<?>> predicate) {
            return this.copyFrom(valueContainer, MergeFunction.REPLACEMENT_PREFERRED, predicate);
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
         * @param overlap The overlap resolver to decide which value to retain
         * @param predicate The predicate to filter which keys can be copied
         * @return This {@link Mutable} with relevant data filled from the
         *           given {@link ValueContainer}
         */
        Mutable copyFrom(ValueContainer valueContainer, MergeFunction overlap, Predicate<Key<?>> predicate);

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
         * @param first The first key to copy
         * @param more The additional keys to copy
         * @return This {@link Mutable} with relevant data filled from the
         *           given {@link ValueContainer}
         */
        default Mutable copyFrom(ValueContainer valueContainer, Key<?> first, Key<?>... more) {
            return this.copyFrom(valueContainer, MergeFunction.REPLACEMENT_PREFERRED, first, more);
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
         * @param first The first key
         * @param more The keys to copy
         * @return This {@link Mutable} with relevant data filled from the
         *           given {@link ValueContainer}
         */
        default Mutable copyFrom(ValueContainer valueContainer, MergeFunction overlap, Key<?> first, Key<?>... more) {
            return this.copyFrom(valueContainer, overlap, ImmutableList.<Key<?>>builder().add(first).add(more).build());
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
         * @param keys The keys to copy
         * @return This {@link Mutable} with relevant data filled from the
         *           given {@link ValueContainer}
         */
        default Mutable copyFrom(ValueContainer valueContainer, Iterable<Key<?>> keys) {
            return this.copyFrom(valueContainer, MergeFunction.REPLACEMENT_PREFERRED, keys);
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
         * @param keys The keys to copy
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
            return this.copyFrom(valueContainer, MergeFunction.REPLACEMENT_PREFERRED);
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
         * @param overlap  The overlap resolver
         * @return This {@link Mutable} with relevant data filled from the
         *           given {@link DataHolder}
         */
        Mutable copyFrom(ValueContainer valueContainer, MergeFunction overlap);

        /**
         * Sets the supported {@link Key}'s value such that the value is set on
         * this {@link Mutable} without having to directly set the
         * {@link org.spongepowered.api.data.value.Value.Mutable} and {@link #set(Value)} afterwards. The requirement
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
         * the same as {@link DataHolder.Mutable#transform(Key, Function)}.
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
        default Mutable asMutable() {
            return this;
        }

        @Override
        Mutable copy();

        /**
         * A factory to create new {@link Mutable} manipulators.
         */
        interface Factory {

            /**
             * Creates an empty mutable manipulator that can be used as
             * a sink accepting new values.
             *
             * @return A new empty manipulator
             */
            Mutable of();

            /**
             * Creates a new manipulator with all the provided values.
             *
             * @param values the values to populate
             * @return The new manipulator with the provided values
             */
            Mutable of(Iterable<? extends Value<?>> values);

            /**
             * Creates a new manipulator with all the possible values
             * from the given {@link ValueContainer}.
             *
             * @param valueContainer the value container containing all values
             * @return The new manipulator with all values from the given container
             */
            Mutable of(ValueContainer valueContainer);
        }

    }
}
