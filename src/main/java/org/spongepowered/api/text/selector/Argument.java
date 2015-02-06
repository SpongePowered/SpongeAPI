/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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
package org.spongepowered.api.text.selector;

/**
 * Represents the argument of a {@link Selector selector}. An Argument is one or
 * more key-to-value mappings ({@code key=value}) with the key represented by an
 * {@link ArgumentType}.
 *
 * @param <T> The type of the value
 */
public interface Argument<T> {

    /**
     * Returns the type of this {@link Argument}.
     *
     * @return The type of this argument
     */
    ArgumentType<T> getType();

    /**
     * Returns the value of this {@link Argument}.
     *
     * @return The value of this argument
     */
    T getValue();

    /**
     * Converts this {@link Argument} to a valid argument string.
     *
     * @return The plain argument string
     */
    String toPlain();

    /**
     * Represents an {@link Argument} which can be inverted to select all
     * targets not matching the filter.
     *
     * @param <T> The type of the value
     * @see Argument
     */
    interface Invertible<T> extends Argument<T> {

        /**
         * Returns whether this {@link Argument} is inverted and will select all
         * targets not matching the filter.
         *
         * @return Whether this argument is inverted
         */
        boolean isInverted();

        /**
         * Inverts this {@link Invertible} argument and returns the new
         * {@link Argument}. The new argument will select all targets this
         * argument didn't select.
         *
         * @return The inverted argument
         */
        Invertible<T> invert();

    }

}
