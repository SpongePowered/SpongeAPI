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

import java.util.Objects;
import java.util.StringJoiner;

/**
 * An entry which contains an object.
 *
 * @param <T> The entry type
 */
public class WeightedObject<T> extends TableEntry<T> {

    private final T object;

    /**
     * Creates a new {@link WeightedObject} of the provided
     * {@code object} and {@code weight}.
     *
     * @param obj The object
     * @param weight The weight of the object
     */
    public WeightedObject(final T obj, final double weight) {
        super(weight);
        this.object = Objects.requireNonNull(obj);
    }

    /**
     * Gets the entry contained in this entry.
     * 
     * @return The object
     */
    public T get() {
        return this.object;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof WeightedObject)) {
            return false;
        }
        final WeightedObject<?> c = (WeightedObject<?>) o;
        return this.object.equals(c.object) && this.getWeight() == c.getWeight();
    }

    @Override
    public int hashCode() {
        int r = 1;
        final long w = Double.doubleToLongBits(this.getWeight());
        r = r * 37 + (int) (w ^ (w >>> 32));
        r = r * 37 + this.object.hashCode();
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", WeightedObject.class.getSimpleName() + "[", "]")
            .add("object=" + this.object)
            .toString();
    }
}
