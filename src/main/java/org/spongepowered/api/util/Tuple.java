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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.apache.commons.lang3.tuple.Pair;

/**
 * A tuple of objects. This can be considered a {@link Pair}.
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
    public static <K, V> Tuple<K, V> of(K first, V second) {
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
    public Tuple(K first, V second) {
        this.first = checkNotNull(first);
        this.second = checkNotNull(second);
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
        return MoreObjects.toStringHelper(this)
            .add("first", this.first)
            .add("second", this.second)
            .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.first, this.second);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Tuple other = (Tuple) obj;
        return Objects.equal(this.first, other.first)
                && Objects.equal(this.second, other.second);
    }
}
