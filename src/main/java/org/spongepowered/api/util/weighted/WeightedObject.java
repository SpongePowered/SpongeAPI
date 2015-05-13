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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;

/**
 * Represents an object with a numerical weight used for random selection from a
 * collection of weighted types.
 * 
 * @param <T> The object type
 */
public class WeightedObject<T> {

    protected final T object;
    protected final int weight;

    /**
     * Creates a new {@link WeightedObject}.
     * 
     * @param object The object
     * @param weight The weight
     */
    public WeightedObject(T object, int weight) {
        checkArgument(weight >= 0, "Object's weight cannot be negative");
        this.object = checkNotNull(object, "object");
        this.weight = weight;
    }

    /**
     * Gets the object.
     * 
     * @return The object
     */
    public T get() {
        return this.object;
    }

    /**
     * Gets the weight of this object.
     *
     * @return The weight
     */
    public int getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("object", this.object)
                .add("weight", this.weight)
                .toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WeightedObject<?> object = (WeightedObject<?>) obj;
        if (!this.object.equals(object.object)) {
            return false;
        }
        return this.weight == object.weight;
    }
}
