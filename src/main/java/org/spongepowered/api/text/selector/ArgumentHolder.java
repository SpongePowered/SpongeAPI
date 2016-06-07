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
package org.spongepowered.api.text.selector;

import java.util.Set;

/**
 * Represents a holder of {@link ArgumentHolder}s. This interface is extended by
 * both Vector3 and Limit. It is also extended by {@link ArgumentType}, as any
 * {@link ArgumentType} "holds" itself. This also allows for Limit to have more
 * strict upper bound on its maximum and minimum to allow a
 * {@code Limit<Vector3>} without allowing {@code Limit<Object>}.
 *
 * @param <T> The type for the value of this argument holder
 * @see ArgumentType
 * @see ArgumentTypes
 */
public interface ArgumentHolder<T extends ArgumentHolder<?>> {

    /**
     * Returns the size of the Set from {@link #getTypes()}.
     *
     * @return The size of the Set from {@link #getTypes()}
     */
    int getCount();

    /**
     * Returns a set containing all the {@link ArgumentHolder}s this
     * {@link ArgumentHolder} holds.
     *
     * @return A set containing all the {@link ArgumentHolder}s this
     *         {@link ArgumentHolder} holds
     */
    Set<T> getTypes();

    /**
     * Represents the holder of three {@link ArgumentType}s {@code x}, {@code y}
     * , and {@code z}.
     *
     * @param <V> The type of the vector
     * @param <T> The type of the components of the vector
     */
    interface Vector3<V, T> extends ArgumentHolder<ArgumentType<T>> {

        /**
         * Gets the {@link ArgumentType} for the x coordinate of this
         * {@link ArgumentHolder.Vector3}.
         *
         * @return The x coordinate argument type
         */
        ArgumentType<T> x();

        /**
         * Gets the {@link ArgumentType} for the y coordinate of this
         * {@link ArgumentHolder.Vector3}.
         *
         * @return The y coordinate argument type
         */
        ArgumentType<T> y();

        /**
         * Gets the {@link ArgumentType} for the z coordinate of this
         * {@link ArgumentHolder.Vector3}.
         *
         * @return The z coordinate argument type
         */
        ArgumentType<T> z();

    }

    /**
     * Represents the holder of two objects with a minimal and maximal argument
     * holder.
     *
     * @param <T> The type of the argument holder
     */
    interface Limit<T extends ArgumentHolder<?>> extends ArgumentHolder<T> {

        /**
         * Returns the minimum object of this {@link ArgumentHolder.Limit}.
         *
         * @return The minimum object
         */
        T minimum();

        /**
         * Returns the maximum object of this {@link ArgumentHolder.Limit}.
         *
         * @return The maximum object
         */
        T maximum();

    }

}
