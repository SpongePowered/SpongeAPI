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
import org.spongepowered.api.data.Key;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.util.weighted.WeightedTable;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

/**
 * The abstract base interface for all of the "Value API". In short, a
 * {@link Value} is a "wrapper" around an actual value from a
 * {@link ValueContainer}. The actual value may come from various sources of
 * the {@link ValueContainer}, but usually it's a generic dynamic system for
 * being able to fetch values from object fields without having to know the
 * type of {@link Class} of the {@link ValueContainer}, the getters and
 * setters for that particular value. The driving force behind this is that
 * instead of having a traditional hierarchical structure of data that is
 * possible to be retrieved from an {@link Entity}, {@link Living}, etc.,
 * all that is required is <pre>{@code container.supports(Keys.HEALTH) ?
 * container.get(Keys.HEALTH).get() : 0 }</pre> where the container is simply
 * a {@link ValueContainer}, nothing more, nothing less.
 *
 * <p>The advantage of this is that now, these various known and unknown
 * {@link Mutable}s can be retrieved by simple java generics:
 * {@link ValueContainer#getValue(Key)}. While having a {@link Mutable} for
 * something so primitive as the current health of a {@link Living} entity,
 * the power is wielded when a {@link Mutable} can be offered up to multiple
 * {@link ValueContainer}s without worrying about whether it's supported or not,
 * or getting the right cast information.</p>
 *
 * @param <E> The type of element wrapped by this value
 */
public interface Value<E> {

    /**
     * Constructs a mutable {@link Value} of the appropriate type based
     * on the given {@link Key} and the element.
     *
     * @param key The key
     * @param element The element
     * @param <E> The element type
     * @return The constructed mutable value
     */
    static <E> Value.Mutable<E> mutableOf(Key<? extends Value<E>> key, E element) {
        return genericMutableOf(key, element).asMutable();
    }

    /**
     * Constructs an immutable {@link Value} of the appropriate type based
     * on the given {@link Key} and the element.
     *
     * @param key The key
     * @param element The element
     * @param <E> The element type
     * @return The constructed immutable value
     */
    static <E> Value.Immutable<E> immutableOf(Key<? extends Value<E>> key, E element) {
        return genericImmutableOf(key, element).asImmutable();
    }

    /**
     * Constructs a mutable {@link Value} of the appropriate type based
     * on the given {@link Key} and the element.
     *
     * @param key The key
     * @param element The element
     * @param <E> The element type
     * @return The constructed mutable value
     */
    static <E extends Comparable<E>> BoundedValue.Mutable<E> mutableOf(Key<? extends BoundedValue<E>> key, E element) {
        return genericMutableOf(key, element).asMutable();
    }

    /**
     * Constructs an immutable {@link Value} of the appropriate type based
     * on the given {@link Key} and the element.
     *
     * @param key The key
     * @param element The element
     * @param <E> The element type
     * @return The constructed immutable value
     */
    static <E extends Comparable<E>> BoundedValue.Immutable<E> immutableOf(Key<? extends BoundedValue<E>> key, E element) {
        return genericImmutableOf(key, element).asImmutable();
    }

    /**
     * Constructs a mutable {@link OptionalValue} of the appropriate type based
     * on the given {@link Key} and the element.
     *
     * @param key The key
     * @param element The element
     * @param <E> The element type
     * @return The constructed mutable value
     */
    static <E> OptionalValue.Mutable<E> mutableOf(Key<? extends OptionalValue<E>> key, Optional<E> element) {
        return genericMutableOf(key, element).asMutable();
    }

    /**
     * Constructs an immutable {@link OptionalValue} of the appropriate type based
     * on the given {@link Key} and the element.
     *
     * @param key The key
     * @param element The element
     * @param <E> The element type
     * @return The constructed immutable value
     */
    static <E> OptionalValue.Immutable<E> immutableOf(Key<? extends OptionalValue<E>> key, Optional<E> element) {
        return genericImmutableOf(key, element).asImmutable();
    }

    /**
     * Constructs a mutable {@link ListValue} of the appropriate type based
     * on the given {@link Key} and the element.
     *
     * @param key The key
     * @param element The element
     * @param <E> The element type
     * @return The constructed mutable value
     */
    static <E> ListValue.Mutable<E> mutableOf(Key<? extends ListValue<E>> key, List<E> element) {
        return genericMutableOf(key, element).asMutable();
    }

    /**
     * Constructs an immutable {@link ListValue} of the appropriate type based
     * on the given {@link Key} and the element.
     *
     * @param key The key
     * @param element The element
     * @param <E> The element type
     * @return The constructed immutable value
     */
    static <E> ListValue.Immutable<E> immutableOf(Key<? extends ListValue<E>> key, List<E> element) {
        return genericImmutableOf(key, element).asImmutable();
    }

    /**
     * Constructs a mutable {@link SetValue} of the appropriate type based
     * on the given {@link Key} and the element.
     *
     * @param key The key
     * @param element The element
     * @param <E> The element type
     * @return The constructed mutable value
     */
    static <E> SetValue.Mutable<E> mutableOf(Key<? extends SetValue<E>> key, Set<E> element) {
        return genericMutableOf(key, element).asMutable();
    }

    /**
     * Constructs an immutable {@link SetValue} of the appropriate type based
     * on the given {@link Key} and the element.
     *
     * @param key The key
     * @param element The element
     * @param <E> The element type
     * @return The constructed immutable value
     */
    static <E> SetValue.Immutable<E> immutableOf(Key<? extends SetValue<E>> key, Set<E> element) {
        return genericImmutableOf(key, element).asImmutable();
    }

    /**
     * Constructs a mutable {@link MapValue} of the appropriate type based
     * on the given {@link Key} and the element.
     *
     * @param key The key
     * @param element The element
     * @param <K> The map key type
     * @param <V> The map value type
     * @return The constructed mutable value
     */
    static <K, V> MapValue.Mutable<K, V> mutableOf(Key<? extends MapValue<K, V>> key, Map<K, V> element) {
        return genericMutableOf(key, element).asMutable();
    }

    /**
     * Constructs an immutable {@link MapValue} of the appropriate type based
     * on the given {@link Key} and the element.
     *
     * @param key The key
     * @param element The element
     * @param <K> The map key type
     * @param <V> The map value type
     * @return The constructed immutable value
     */
    static <K, V> MapValue.Immutable<K, V> immutableOf(Key<? extends MapValue<K, V>> key, Map<K, V> element) {
        return genericImmutableOf(key, element).asImmutable();
    }

    /**
     * Constructs a mutable {@link WeightedCollectionValue} of the appropriate type based
     * on the given {@link Key} and the element.
     *
     * @param key The key
     * @param element The element
     * @param <E> The element type
     * @return The constructed mutable value
     */
    static <E> WeightedCollectionValue.Mutable<E> mutableOf(Key<? extends WeightedCollectionValue<E>> key, WeightedTable<E> element) {
        return genericMutableOf(key, element).asMutable();
    }

    /**
     * Constructs an immutable {@link WeightedCollectionValue} of the appropriate type based
     * on the given {@link Key} and the element.
     *
     * @param key The key
     * @param element The element
     * @param <E> The element type
     * @return The constructed immutable value
     */
    static <E> WeightedCollectionValue.Immutable<E> immutableOf(Key<? extends WeightedCollectionValue<E>> key, WeightedTable<E> element) {
        return genericImmutableOf(key, element).asImmutable();
    }

    /**
     * Constructs a {@link Value} of the appropriate type based
     * on the given {@link Key} and the element. The returned
     * {@link Value} is guaranteed {@link Mutable}, this means that
     * calling {@link #asMutable()} will return itself.
     *
     * @param key The key
     * @param element The element
     * @param <V> The value type
     * @param <E> The element type
     * @return The constructed mutable value
     */
    static <V extends Value<E>, E> V genericMutableOf(Key<V> key, E element) {
        return Sponge.getRegistry().requireFactory(Factory.class).mutableOf(key, element);
    }

    /**
     * Constructs a {@link Value} of the appropriate type based
     * on the given {@link Key} and the element. The returned
     * {@link Value} is guaranteed {@link Immutable}, this means that
     * calling {@link #asImmutable()} will return itself.
     *
     * @param key The key
     * @param element The element
     * @param <V> The value type
     * @param <E> The element type
     * @return The constructed immutable value
     */
    static <V extends Value<E>, E> V genericImmutableOf(Key<V> key, E element) {
        return Sponge.getRegistry().requireFactory(Factory.class).immutableOf(key, element);
    }

    /**
     * Gets the held value.
     *
     * @return The held value
     */
    E get();

    /**
     * Gets the key for this {@link Value}.
     *
     * @return The key for this value
     */
    Key<? extends Value<E>> getKey();

    /**
     * Retrieves a mutable form of this value. Due to the vague nature of the
     * value itself, some cases can already provide a {@link Mutable} instance
     * where this would simply return itself. In other cases, where the retrieved
     * value is an {@link Immutable} instance, a new mutable value is created
     * with the same key and values.
     *
     * @return A mutable value
     */
    Mutable<E> asMutable();

    /**
     * Retrieves a copy in the mutable form of this value. The new is created
     * with the same key and values.
     *
     * @return A mutable value
     */
    Mutable<E> asMutableCopy();

    /**
     * Retrieves an immutable form of this value. Due to the vague nature of the
     * value itself, some cases can already provide a {@link Immutable} instance
     * where this would simply return itself. In other cases, where the retrieved
     * value is a {@link Mutable} instance, a new immutable value is created
     * with the same key and values.
     *
     * @return An immutable value
     */
    Immutable<E> asImmutable();

    /**
     * Represents a type of {@link Value} that is mutable. Simply put, the
     * underlying value can always be changed without creating a new {@link Mutable}.
     *
     * @param <E> The type of element
     */
    interface Mutable<E> extends Value<E> {

        /**
         * Sets the underlying value to the provided {@code value}.
         *
         * @param value The value to set
         * @return The owning {@link ValueContainer}
         */
        Mutable<E> set(E value);

        /**
         * Attempts to transform the underlying value based on the provided
         * {@link Function} such that the result of {@link Function#apply(Object)}
         * will replace the underlying value.
         *
         * @param function The function to apply on the existing value
         * @return The owning {@link ValueContainer}
         */
        Mutable<E> transform(Function<E, E> function);

        /**
         * Gets the {@link Immutable} version of this {@link Mutable} such that
         * all data is duplicated across to the new {@link Immutable}. Note
         * that once created, the {@link Immutable} is not going to change.
         *
         * @return A new {@link Immutable} instance
         */
        @Override
        Immutable<E> asImmutable();

        @Override
        default Mutable<E> asMutable() {
            return this;
        }

        @Override
        default Mutable<E> asMutableCopy() {
            return copy();
        }

        /**
         * Makes an independent copy of this {@link Mutable} with the same initial
         * data. Both this value and the new value will refer to the same object
         * initially.
         *
         * @return A new copy of this {@link Mutable}
         */
        Mutable<E> copy();

    }

    /**
     * Represents an immutable representation of a {@link Value} where any
     * modifications of the underlying value result in a new instance of an
     * {@link Immutable} and/or the {@link ValueContainer} if the
     * {@link ValueContainer} too is immutable.
     *
     * <p>The basis for immutability is that once created, the value can not be
     * changed for any reason. Change requires a new instance to be created. As the
     * {@link Immutable} always has a {@link ValueContainer}, it is
     * recommended that the owning {@link ValueContainer} too is immutable, unless
     * the {@link Immutable} is being passed around for data processing. The
     * underlying value of an {@link Immutable} may be itself mutable, however
     * utilizing any provided methods by any of the {@link Immutable} classes
     * is recommended.</p>
     *
     * @param <E> The type of value
     */
    interface Immutable<E> extends Value<E> {

        /**
         * Creates a new {@link Immutable} with the given <code>E</code> typed
         * value, such that if the owning {@link ValueContainer} is immutable, the
         * {@link ValueContainer} too is recreated as a new instance with the new
         * {@link Immutable}.
         *
         * @param value The value to replace
         * @return The owning {@link ValueContainer}, a new instance if it too is
         *     immutable
         */
        Immutable<E> with(E value);

        /**
         * Retrieves the underlying value for this {@link Immutable} and
         * applies the given {@link Function} onto that value, after which, the
         * product is sent to a new {@link Immutable} replacing this one.
         *
         * <p>If the {@link ValueContainer} too is immutable, a new instance of
         * the {@link ValueContainer} may be created. If the {@link ValueContainer}
         * is mutable, the same instance of the {@link ValueContainer} is retained.
         * </p>
         *
         * @param function The function to apply onto the existing value
         * @return The owning {@link ValueContainer}, a new instance if it too is
         *     immutable
         */
        Immutable<E> transform(Function<E, E> function);

        /**
         * Creates a mutable {@link Mutable} for this {@link Immutable}.
         *
         * @return A mutable value
         */
        @Override
        Mutable<E> asMutable();

        @Override
        default Mutable<E> asMutableCopy() {
            return asMutable();
        }

        @Override
        default Immutable<E> asImmutable() {
            return this;
        }

    }

    interface Factory {

        <V extends Value<E>, E> V mutableOf(Key<V> key, E element);

        <V extends Value<E>, E> V immutableOf(Key<V> key, E element);
    }
}
