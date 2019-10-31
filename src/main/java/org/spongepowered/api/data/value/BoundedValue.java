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

import java.util.Comparator;
import java.util.function.Function;

/**
 * Represents a value that may itself be {@link Comparable} or can be
 * compared using the {@link Comparator} such that the value is "bounded" by a
 * {@link #getMinValue()} and a {@link #getMaxValue()}. For a majority of
 * values, a {@link BoundedValue} is limited to being within it's destined
 * bounds. Any {@link BoundedValue} that is out of it's intended bounds will
 * throw an {@link IllegalStateException} if used or offered to a
 * {@link ValueContainer} or {@link org.spongepowered.api.data.DataHolder.Mutable}.
 *
 * @param <E> The type of value that can be compared
 */
public interface BoundedValue<E> extends Value<E> {

    /**
     * Constructs a mutable {@link Value} of the appropriate
     * type based on the given {@link Key} and the element.
     * The returned {@link Value} is guaranteed {@link Mutable},
     * this means that calling {@link #asMutable()} will return
     * itself.
     *
     * @param key The key
     * @param element The element
     * @param minimum The minimum
     * @param maximum The maximum
     * @param <E> The element type
     * @return The constructed mutable bounded value
     */
    static <E> BoundedValue.Mutable<E> mutableOf(Key<? extends BoundedValue<E>> key, E element, E minimum, E maximum) {
        return Sponge.getRegistry().requireFactory(Factory.class).mutableOf(key, element, minimum, maximum).asMutable();
    }

    /**
     * Constructs an immutable {@link Value} of the appropriate
     * type based on the given {@link Key} and the element.
     * The returned {@link Value} is guaranteed {@link Immutable},
     * this means that calling {@link #asImmutable()} will return
     * itself.
     *
     * @param key The key
     * @param element The element
     * @param minimum The minimum
     * @param maximum The maximum
     * @param <E> The element type
     * @return The constructed immutable bounded value
     */
    static <E> BoundedValue.Immutable<E> immutableOf(Key<? extends BoundedValue<E>> key, E element, E minimum, E maximum) {
        return Sponge.getRegistry().requireFactory(Factory.class).immutableOf(key, element, minimum, maximum).asImmutable();
    }

    /**
     * Constructs a mutable {@link Value} of the appropriate
     * type based on the given {@link Key} and the element.
     * The returned {@link Value} is guaranteed {@link Mutable},
     * this means that calling {@link #asMutable()} will return
     * itself.
     *
     * @param key The key
     * @param element The element
     * @param <E> The element type
     * @return The constructed mutable bounded value
     */
    static <E> BoundedValue.Mutable<E> mutableOf(Key<? extends BoundedValue<E>> key, E element) {
        return Value.genericMutableOf(key, element).asMutable();
    }

    /**
     * Constructs an immutable {@link Value} of the appropriate
     * type based on the given {@link Key} and the element.
     * The returned {@link Value} is guaranteed {@link Immutable},
     * this means that calling {@link #asImmutable()} will return
     * itself.
     *
     * @param key The key
     * @param element The element
     * @param <E> The element type
     * @return The constructed immutable bounded value
     */
    static <E> BoundedValue.Immutable<E> immutableOf(Key<? extends BoundedValue<E>> key, E element) {
        return Value.genericImmutableOf(key, element).asImmutable();
    }

    @Override
    Key<? extends BoundedValue<E>> getKey();

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
     * A type of {@link BoundedValue} that is modifiable as a {@link org.spongepowered.api.data.value.Value.Mutable}.
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
     * {@link org.spongepowered.api.data.value.Value.Immutable}.
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

        <V extends BoundedValue<E>, E> V mutableOf(Key<V> key, E element, E minimum, E maximum);

        <V extends BoundedValue<E>, E> V mutableOf(Key<V> key, E element);

        <V extends BoundedValue<E>, E> V immutableOf(Key<V> key, E element, E minimum, E maximum);

        <V extends BoundedValue<E>, E> V immutableOf(Key<V> key, E element);
    }
}
