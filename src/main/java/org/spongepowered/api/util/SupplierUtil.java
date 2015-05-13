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

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**

 *
 */
public class SupplierUtil {

    private static final Random RANDOM = new Random();

    public static <E> Supplier<E> fixed(E value) {
        return Suppliers.ofInstance(checkNotNull(value, "value"));
    }

    public static Supplier<Integer> randomBetween(int min, int max) {
        return randomRange(min, max - min);
    }

    public static Supplier<Integer> randomRange(int min, int delta) {
        return new RandomIntSupplier(min, delta);
    }

    private static class RandomIntSupplier implements Supplier<Integer> {

        private final int min;
        private final int delta;

        RandomIntSupplier(int min, int delta) {
            super();
            this.min = min;
            this.delta = delta;
        }

        @Override
        public Integer get() {
            return randomInt(this.min, this.delta);
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("min", this.min)
                    .add("delta", this.delta)
                    .toString();
        }

    }

    public static <E> Supplier<E> randomOf(E... elements) {
        return randomOf(Arrays.asList(checkNotNull(elements, "elements")));
    }

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
            return randomElement(this.elements);
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("elements", Arrays.asList(this.elements.toArray()))
                    .toString();
        }

    }

    public static int randomInt(int min, int delta) {
        return min + RANDOM.nextInt(delta + 1);
    }

    public static int randomIntBetween(int min, int max) {
        return randomInt(min, max - min);
    }

    public static <E> E randomElement(List<E> elements) {
        return elements.get(RANDOM.nextInt(elements.size()));
    }

}
