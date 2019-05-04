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
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.key.Key;

import java.util.Comparator;
import java.util.function.Function;

/**
 * Represents a value that may itself be {@link Comparable} or can be
 * compared using the {@link Comparator} such that the value is "bounded" by a
 * {@link #getMinValue()} and a {@link #getMaxValue()}. For a majority of
 * values, a {@link BoundedValue} is limited to being within it's destined
 * bounds. Any {@link BoundedValue} that is out of it's intended bounds will
 * throw an {@link IllegalStateException} if used or offered to a
 * {@link ValueContainer} or {@link DataHolder}.
 *
 * @param <E> The type of value that can be compared
 */
public interface BoundedValue<E> extends Value<E> {

    /**
     * Constructs a {@link Value} of the appropriate type based
     * on the given {@link Key} and the element.
     *
     * @param key The key
     * @param element The element
     * @param minimum The minimum
     * @param maximum The maximum
     * @param <V> The value type
     * @param <E> The element type
     * @return The constructed value
     */
    static <V extends BoundedValue<E>, E> V of(Key<V> key, E element, E minimum, E maximum) {
        return Sponge.getRegistry().requireFactory(Factory.class).of(key, element, minimum, maximum);
    }

    /**
     * Constructs a {@link Value} of the appropriate type based
     * on the given {@link Key} and the element.
     *
     * @param key The key
     * @param element The element
     * @param <V> The value type
     * @param <E> The element type
     * @return The constructed value
     */
    static <V extends BoundedValue<E>, E> V of(Key<V> key, E element) {
        return Sponge.getRegistry().requireFactory(Factory.class).of(key, element);
    }

    /**
     * Gets the required "minimum" value such that the value is only valid if
     * the following is true:
     * <pre>{@code if (getComparator().compare(getValue(), getMinValue()) <= 0)
     * }</pre>.
     *
     * @return The supposed minimum value
     */
    E getMinValue();

    /**
     * Gets the required "maximum" value such that the value is only valid if
     * the following is true:
     * <pre>{@code if (getComparator().compare(getValue(), getMaxValue()) >= 0)
     * }</pre>.
     *
     * @return The supposed maximum value
     */
    E getMaxValue();

    /**
     * The comparator used to compare a value of the proper type. Can be used
     * for validation with the {@link #getMinValue()} and
     * {@link #getMaxValue()}.
     *
     * @return The comparator used for this value
     */
    Comparator<E> getComparator();

    @Override
    BoundedValue.Mutable<E> asMutable();

    @Override
    BoundedValue.Mutable<E> asMutableCopy();

    @Override
    BoundedValue.Immutable<E> asImmutable();

    /**
     * A type of {@link BoundedValue} that is modifiable as a {@link Value.Mutable}.
     *
     * @param <E> The type of element
     */
    interface Mutable<E> extends BoundedValue<E>, Value.Mutable<E> {

        @Override
        BoundedValue.Mutable<E> set(E value);

        @Override
        BoundedValue.Mutable<E> transform(Function<E, E> function);

        @Override
        BoundedValue.Immutable<E> asImmutable();

        @Override
        default BoundedValue.Mutable<E> asMutable() {
            return this;
        }

        @Override
        default BoundedValue.Mutable<E> asMutableCopy() {
            return copy();
        }

        @Override
        BoundedValue.Mutable<E> copy();

    }

    /**
     * A type of {@link BoundedValue} that is immutable as an
     * {@link Value.Immutable}.
     *
     * @param <E> The type of element
     */
    interface Immutable<E> extends BoundedValue<E>, Value.Immutable<E> {

        @Override
        BoundedValue.Immutable<E> with(E value);

        @Override
        BoundedValue.Immutable<E> transform(Function<E, E> function);

        @Override
        BoundedValue.Mutable<E> asMutable();

        @Override
        default BoundedValue.Mutable<E> asMutableCopy() {
            return asMutable();
        }

        @Override
        default BoundedValue.Immutable<E> asImmutable() {
            return this;
        }
    }

    interface Factory {

        <V extends BoundedValue<E>, E> V of(Key<V> key, E element, E minimum, E maximum);

        <V extends BoundedValue<E>, E> V of(Key<V> key, E element);
    }
}
