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

import org.spongepowered.api.data.Key;

import java.util.Set;

public interface SetValue<E> extends CollectionValue<E, Set<E>> {

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
        return Value.mutableOf(key, element);
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
        return Value.immutableOf(key, element);
    }

    @Override
    Key<? extends SetValue<E>> getKey();

    @Override
    SetValue.Mutable<E> asMutable();

    @Override
    SetValue.Mutable<E> asMutableCopy();

    @Override
    SetValue.Immutable<E> asImmutable();

    /**
     * Represents a type of {@link org.spongepowered.api.data.value.CollectionValue.Mutable} backed by a {@link Set}. The
     * reasoning is that a {@link Set} retains no ordering of the elements it
     * contains.
     *
     * @param <E> The type of elements supported
     */
    interface Mutable<E> extends SetValue<E>, CollectionValue.Mutable<E, Set<E>, Mutable<E>, Immutable<E>> {

        @Override
        default SetValue.Mutable<E> asMutable() {
            return this;
        }

        @Override
        default SetValue.Mutable<E> asMutableCopy() {
            return copy();
        }

        @Override
        SetValue.Immutable<E> asImmutable();
    }

    /**
     * Represents a type of {@link org.spongepowered.api.data.value.CollectionValue.Immutable} backed by a
     * {@link Set}. The reasoning is that a {@link Set} retains no ordering of the
     * elements it contains.
     *
     * @param <E> The type of elements supported
     */
    interface Immutable<E> extends SetValue<E>, CollectionValue.Immutable<E, Set<E>, Immutable<E>, Mutable<E>> {

        @Override
        SetValue.Mutable<E> asMutable();

        @Override
        default SetValue.Mutable<E> asMutableCopy() {
            return asMutable();
        }

        @Override
        default SetValue.Immutable<E> asImmutable() {
            return this;
        }
    }
}
