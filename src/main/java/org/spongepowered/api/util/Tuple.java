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

import java.util.Objects;
import java.util.StringJoiner;

/**
 * A tuple of objects.
 *
 * @param <K> The key
 * @param <V> The value
 */
public class Tuple<K, V> {

    /**
     * Creates a new {@link Tuple} with the desired {@code first} and
     * {@code second} objects.
     *
     * @param first The first object
     * @param second The second object
     * @param <K> The type of first object
     * @param <V> The type of second object
     * @return The new Tuple
     */
    public static <K, V> Tuple<K, V> of(final K first, final V second) {
        return new Tuple<>(first, second);
    }

    private final K first;
    private final V second;

    /**
     * Creates a new {@link Tuple}.
     *
     * @param first The first object
     * @param second The second object
     */
    public Tuple(final K first, final V second) {
        this.first = Objects.requireNonNull(first);
        this.second = Objects.requireNonNull(second);
    }

    /**
     * Gets the first object, otherwise known as "key".
     *
     * @return The first object
     */
    public K getFirst() {
        return this.first;
    }

    /**
     * Gets the second object, otherwise known as "value".
     *
     * @return The value
     */
    public V getSecond() {
        return this.second;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Tuple.class.getSimpleName() + "[", "]")
            .add("first=" + this.first)
            .add("second=" + this.second)
            .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.first, this.second);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(final @Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        final Tuple other = (Tuple) obj;
        return Objects.equals(this.first, other.first)
                && Objects.equals(this.second, other.second);
    }
}
