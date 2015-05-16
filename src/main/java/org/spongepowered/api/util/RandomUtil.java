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

import java.util.List;
import java.util.Random;

/**
 * Helper class for randomization.
 */
public class RandomUtil {

    private static final Random RANDOM = new Random();

    /**
     * Returns a random int between {@code min} (inlcusive) and
     * {@code (min + delta)} (inclusive).
     *
     * @param min The minimum value
     * @param delta The none negative delta for the value
     * @return A random int between {@code min} and {@code (min + delta)}
     */
    public static int randomInt(int min, int delta) {
        return min + RANDOM.nextInt(delta + 1);
    }

    /**
     * Returns a random int between {@code min} (inlcusive) and {@code (max)}
     * (inclusive).
     *
     * @param min The minimum value
     * @param max The maximul value
     * @return A random int between {@code min} and {@code max}
     */
    public static int randomIntBetween(int min, int max) {
        return randomInt(min, max - min);
    }

    /**
     * Returns a random element from the given array.
     *
     * @param <E> The elements type
     * @param elements The elements to pick a random from
     * @return A random element from the given array
     */
    public static <E> E randomElement(E... elements) {
        return elements[RANDOM.nextInt(elements.length)];
    }

    /**
     * Returns a random element from the given list.
     *
     * @param <E> The elements type
     * @param elements The elements to pick a random from
     * @return A random element from the given list
     */
    public static <E> E randomElement(List<E> elements) {
        return elements.get(RANDOM.nextInt(elements.size()));
    }

}
