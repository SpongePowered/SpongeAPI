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

import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.data.persistence.Queries;

import java.util.StringJoiner;

/**
 * Represents an entry in a table which has no associated object. Used to have
 * rolls which give nothing.
 *
 * @param <T> The type of object of this entries table
 */
public class EmptyObject<T> extends TableEntry<T> implements DataSerializable {

    /**
     * Creates a new {@link EmptyObject} with the given weight.
     * 
     * @param weight The weight of this object
     */
    public EmptyObject(double weight) {
        super(weight);
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    @Override
    public DataContainer toContainer() {
        return DataContainer.createNew()
                .set(Queries.CONTENT_VERSION, this.getContentVersion())
                .set(Queries.WEIGHTED_SERIALIZABLE_WEIGHT, this.getWeight());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof EmptyObject)) {
            return false;
        }
        EmptyObject<?> c = (EmptyObject<?>) o;
        return this.getWeight() == c.getWeight();
    }

    @Override
    public int hashCode() {
        int r = 1;
        long w = Double.doubleToLongBits(this.getWeight());
        r = r * 37 + (int) (w ^ (w >>> 32));
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EmptyObject.class.getSimpleName() + "[", "]")
            .add("weight=" + this.getWeight())
            .toString();
    }
}
