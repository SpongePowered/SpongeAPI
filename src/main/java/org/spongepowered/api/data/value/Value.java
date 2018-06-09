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

import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Living;

import java.util.Optional;
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
     * Gets the held value. Usually all held values are "filled" and not
     * "defaulted", in some cases however, the default and existing value
     * are one and the same. Occasionally there are multiple value types
     * that are not "singular" in the sense, like {@link CollectionValue}s,
     * or {@link MapValue}s that contain complex types. In these collection
     * types, usually the default will be an empty collection.
     *
     * @return The held value
     */
    E get();

    /**
     * Gets the default value. There is always a default value, however,
     * usability of the default value may be questionable in certain
     * circumstances.
     *
     * @return The default value
     */
    E getDefault();

    /**
     * Gets the direct value. Since some values may be absent for various
     * reasons, the {@link #get()} would return the {@link #getDefault()} when
     * necessary.
     *
     * @return The direct value, if available
     */
    Optional<E> getDirect();

    /**
     * Gets the key for this {@link Value}.
     *
     * @return The key for this value
     */
    Key<? extends Value<E>> getKey();

    Mutable<E, ?, ?> asMutable();

    Immutable<E, ?, ?> asImmutable();

    /**
     * Represents a type of {@link Value} that is mutable. Simply put, the
     * underlying value can always be changed without creating a new {@link Mutable}.
     *
     * @param <E> The type of element
     */
    interface Mutable<E, V extends Mutable<E, V, I>, I extends Immutable<E, I, V>> extends Value<E> {

        /**
         * Sets the underlying value to the provided {@code value}.
         *
         * @param value The value to set
         * @return The owning {@link ValueContainer}
         */
        V set(E value);

        /**
         * Attempts to transform the underlying value based on the provided
         * {@link Function} such that the result of {@link Function#apply(Object)}
         * will replace the underlying value.
         *
         * @param function The function to apply on the existing value
         * @return The owning {@link ValueContainer}
         */
        Mutable transform(Function<E, E> function);

        /**
         * Gets the {@link Immutable} version of this {@link Mutable} such that
         * all data is duplicated across to the new {@link Immutable}. Note
         * that once created, the {@link Immutable} is not going to change.
         *
         * @return A new {@link Immutable} instance
         */
        @Override
        I asImmutable();


        @SuppressWarnings("unchecked")
        @Override
        default V asMutable() {
            return (V) this;
        }

        /**
         * Makes an independent copy of this {@link Mutable} with the same initial
         * data. Both this value and the new value will refer to the same object
         * initially.
         *
         * @return A new copy of this {@link Mutable}
         */
        V copy();

        interface Single<E> extends Mutable<E, Single<E>, Immutable.Single<E>> {

        }


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
    interface Immutable<E, I extends Immutable<E, I, M>, M extends Mutable<E, M, I>> extends Value<E> {

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
        I with(E value);

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
        I transform(Function<E, E> function);

        /**
         * Creates a mutable {@link Mutable} for this {@link Immutable}.
         *
         * @return A mutable value
         */
        @Override
        M asMutable();

        @SuppressWarnings("unchecked")
        @Override
        default I asImmutable() {
            return (I) this;
        }

        interface Single<E> extends Immutable<E, Single<E>, Mutable.Single<E>> {

        }

    }
}
