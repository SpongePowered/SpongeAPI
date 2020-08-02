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
package org.spongepowered.api.util;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;

/**
 * Represents a range. The type is unbounded such that optional minima and
 * maxima can be used.
 *
 * @param <T> The type of bound
 */
public interface Range<T extends Number> {

    /**
     * Builds a {@link Range} based on integers.
     *
     * @param min The minimum, or {@code null} for no minimum
     * @param max The maximum, or {@code null} for no maximum
     * @return The range.
     * @throws IllegalArgumentException if min is smaller than max
     */
    static Range<Integer> intRange(@Nullable final Integer min, @Nullable final Integer max) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).intRange(min, max);
    }

    /**
     * Builds a {@link Range} based on doubles.
     *
     * @param min The minimum, or {@code null} for no minimum
     * @param max The maximum, or {@code null} for no maximum
     * @return The range.
     */
    static Range<Double> doubleRange(@Nullable final Double min, @Nullable final Double max) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).doubleRange(min, max);
    }

    /**
     * Gets the minimum, if it exists.
     *
     * @return The minimum.
     */
    @Nullable T getMin();

    /**
     * Gets the maximum, if it exists.
     *
     * @return The maximum
     */
    @Nullable T getMax();

    /**
     * Generates specific implementations of the {@link Range} interface.
     */
    interface Factory {

        /**
         * Builds a {@link Range} based on integers.
         *
         * @param min The minimum, or {@code null} for no minimum
         * @param max The maximum, or {@code null} for no maximum
         * @return The range.
         */
        Range<Integer> intRange(@Nullable Integer min, @Nullable Integer max);

        /**
         * Builds a {@link Range} based on doubles.
         *
         * @param min The minimum, or {@code null} for no minimum
         * @param max The maximum, or {@code null} for no maximum
         * @return The range.
         */
        Range<Double> doubleRange(@Nullable Double min, @Nullable Double max);

    }

}
