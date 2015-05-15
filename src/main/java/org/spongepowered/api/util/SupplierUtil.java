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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * A helper class that provides some useful {@link Supplier}s.
 */
public class SupplierUtil {

    /**
     * Creates a new {@link Supplier} that always returns the same result.
     *
     * @param value The value that should always be returned
     * @return The created supplier
     */
    public static <E> Supplier<E> fixed(E value) {
        return Suppliers.ofInstance(checkNotNull(value, "value"));
    }

    /**
     * Creates a new {@link Supplier} that returns values between {@code min}
     * (inclusive) and {@code max} (inclusive).
     *
     * @param min The min value that can be returned
     * @param max The max value that can be returned
     * @return The created supplier
     */
    public static Supplier<Integer> randomBetween(int min, int max) {
        return randomRange(min, max - min);
    }

    /**
     * Creates a new {@link Supplier} that returns values between {@code min}
     * (inclusive) and {@code min+delta} (inclusive).
     *
     * @param min The min value that can be returned
     * @param max The none negative delta value
     * @return The created supplier
     */
    public static Supplier<Integer> randomRange(int min, int delta) {
        return new RandomIntSupplier(min, delta);
    }

    private static class RandomIntSupplier implements Supplier<Integer> {

        private final int min;
        private final int delta;

        RandomIntSupplier(int min, int delta) {
            super();
            checkArgument(delta >= 0, "Delta cannot be negative!");
            this.min = min;
            this.delta = delta;
        }

        @Override
        public Integer get() {
            return RandomUtil.randomInt(this.min, this.delta);
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("min", this.min)
                    .add("delta", this.delta)
                    .toString();
        }

    }

    /**
     * Creates a {@link Supplier} that always return a random element.
     *
     * @param elements The possible elements
     * @return The created supplier.
     */
    public static <E> Supplier<E> randomOf(E... elements) {
        return randomOf(Arrays.asList(checkNotNull(elements, "elements")));
    }

    /**
     * Creates a {@link Supplier} that always return a random element.
     *
     * @param elements The possible elements
     * @return The created supplier.
     */
    public static <E> Supplier<E> randomOf(Collection<? extends E> elements) {
        return new RandomElementSupplier<E>(elements);
    }

    private static class RandomElementSupplier<E> implements Supplier<E> {

        private final List<E> elements;

        RandomElementSupplier(Collection<? extends E> elements) {
            super();
            checkNotNull(elements, "elements");
            checkArgument(!elements.isEmpty(), "Elements cannot be empty!");
            this.elements = ImmutableList.copyOf(elements);
        }

        @Override
        public E get() {
            return RandomUtil.randomElement(this.elements);
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("elements", Arrays.asList(this.elements.toArray()))
                    .toString();
        }

    }

    /**
     * Creates a {@link Supplier} that always return a given amount of random
     * elements. If count is higher than the elements count, it is automatically
     * truncated to that element count.
     *
     * @param count The number of random elements
     * @param elements The possible elements
     * @return The created supplier.
     */
    public static <E> Supplier<List<E>> randomOf(int count, E... elements) {
        return randomOf(count, Arrays.asList(checkNotNull(elements, "elements")));
    }

    /**
     * Creates a {@link Supplier} that always return a given amount of random
     * elements. If count is higher than the elements count, it is automatically
     * truncated to that element count.
     *
     * @param count The number of random elements
     * @param elements The possible elements
     * @return The created supplier.
     */
    public static <E> Supplier<List<E>> randomOf(int count, Collection<? extends E> elements) {
        return randomOf(fixed(count), elements);
    }

    /**
     * Creates a {@link Supplier} that always return a given amount of random
     * elements. If count is higher than the elements count, it is automatically
     * truncated to that element count.
     *
     * @param count The number of random elements
     * @param elements The possible elements
     * @return The created supplier.
     */
    public static <E> Supplier<List<E>> randomOf(Supplier<Integer> count, E... elements) {
        return randomOf(count, Arrays.asList(checkNotNull(elements, "elements")));
    }

    /**
     * Creates a {@link Supplier} that always return a given amount of random
     * elements. If count is higher than the elements count, it is automatically
     * truncated to that element count.
     *
     * @param count The number of random elements
     * @param elements The possible elements
     * @return The created supplier.
     */
    public static <E> Supplier<List<E>> randomOf(Supplier<Integer> count, Collection<? extends E> elements) {
        return new RandomElementsSupplier<E>(count, elements);
    }

    private static class RandomElementsSupplier<E> implements Supplier<List<E>> {

        private final Supplier<Integer> count;
        private final List<E> elements;

        RandomElementsSupplier(Supplier<Integer> count, Collection<? extends E> elements) {
            super();
            this.count = checkNotNull(count, "count");
            this.elements = ImmutableList.copyOf(checkNotNull(elements, "elements"));
        }

        @Override
        public List<E> get() {
            List<E> result = new ArrayList<E>(this.elements);
            Collections.shuffle(result);
            int count = this.count.get();
            return result.subList(0, Math.min(count, result.size()));
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("count", this.count)
                    .add("elements", Arrays.asList(this.elements.toArray()))
                    .toString();
        }

    }

    public static <E> Supplier<List<E>> randomized(E... elements) {
        return randomized(Arrays.asList(checkNotNull(elements, "elements")));
    }

    public static <E> Supplier<List<E>> randomized(Collection<? extends E> elements) {
        return new RandomizedListSupplier<E>(elements);
    }

    private static class RandomizedListSupplier<E> implements Supplier<List<E>> {

        private final List<E> elements;

        RandomizedListSupplier(Collection<? extends E> elements) {
            super();
            this.elements = ImmutableList.copyOf(checkNotNull(elements, "elements"));
        }

        @Override
        public List<E> get() {
            final List<E> result = new ArrayList<E>(this.elements);
            Collections.shuffle(result);
            return result;
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("elements", Arrays.asList(this.elements.toArray()))
                    .toString();
        }

    }

}
