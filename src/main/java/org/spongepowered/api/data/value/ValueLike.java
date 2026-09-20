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


public interface ValueLike<E> {

    /**
     * Gets the key for this {@link ValueLike}.
     *
     * @return The key for this value
     */
    Key<? extends ValueLike<E>> key();

    /**
     * Gets the held value.
     *
     * @return The held value
     */
    E get();

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

    interface Mutable<E> extends ValueLike<E> {

        @Override
        Immutable<E> asImmutable();

        @Override
        default Mutable<E> asMutable() {
            return this;
        }

        @Override
        default Mutable<E> asMutableCopy() {
            return this.copy();
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

    interface Immutable<E> extends ValueLike<E> {

        @Override
        Mutable<E> asMutable();

        @Override
        default Mutable<E> asMutableCopy() {
            return this.asMutable();
        }

        @Override
        default Immutable<E> asImmutable() {
            return this;
        }
    }
}
