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
package org.spongepowered.api.util.weighted;

import java.util.Random;

/**
 * Represents a value which may vary depending on a seed object.
 * 
 * @param <T> The seed object type
 */
@FunctionalInterface
public interface SeededVariableAmount<T> {

    /**
     * Creates a new 'fixed' variable amount, calls to {@link #getAmount} will
     * always return the fixed value.
     * 
     * @param value The fixed value
     * @param <T> The seed object type
     * @return A variable amount representation
     */
    static <T> SeededVariableAmount<T> fixed(double value) {
        return new WrappedVariableAmount<>(VariableAmount.fixed(value));
    }

    /**
     * Creates a new variable amount wrapping the given {@link VariableAmount},
     * calls to {@link #getAmount} will always return wrapped amounts value.
     * 
     * @param value The wrapped variable amount
     * @param <T> The seed object type
     * @return A variable amount representation
     */
    static <T> SeededVariableAmount<T> wrapped(VariableAmount value) {
        return new WrappedVariableAmount<>(value);
    }

    /**
     * Gets an instance of the variable amount depending on the given random
     * object and the seed object.
     * 
     * @param rand The random object
     * @param seed The seed object
     * @return The amount
     */
    double getAmount(Random rand, T seed);

    /**
     * Gets the amount as if from {@link #getAmount(Random, Object)} but floored
     * to the nearest integer equivalent.
     * 
     * @param rand The random object
     * @param seed The seed object
     * @return The floored amount
     */
    default int getFlooredAmount(Random rand, T seed) {
        return (int) Math.floor(getAmount(rand, seed));
    }

    /**
     * A {@link SeededVariableAmount} which wraps another {@link VariableAmount}
     * and defers all operations to the inner VariableAmount without the seed.
     * 
     * @param <T> The seed type
     */
    final class WrappedVariableAmount<T> implements SeededVariableAmount<T> {

        private final VariableAmount inner;

        /**
         * Creates a new WrappedVariableAmount wrapping the given
         * {@link VariableAmount}.
         * 
         * @param inner The inner variable amount
         */
        public WrappedVariableAmount(VariableAmount inner) {
            this.inner = inner;
        }

        @Override
        public double getAmount(Random rand, T seed) {
            return this.inner.getAmount(rand);
        }

        @Override
        public String toString() {
            return this.inner.toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WrappedVariableAmount)) {
                return false;
            }
            WrappedVariableAmount<?> var = (WrappedVariableAmount<?>) obj;
            return this.inner.equals(var.inner);
        }

        @Override
        public int hashCode() {
            return this.inner.hashCode();
        }

    }

}
