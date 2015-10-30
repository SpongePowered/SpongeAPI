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

import com.google.common.base.Objects;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.data.Queries;

public class WeightedSerializableObject<T extends DataSerializable> extends WeightedObject<T> implements DataSerializable {

    /**
     * Creates a new {@link WeightedSerializableObject} with the provided
     * {@link DataSerializable}.
     *
     * @param object The serializable
     * @param weight The weight
     */
    public WeightedSerializableObject(T object, int weight) {
        super(object, weight);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
            .add("object", this.object)
            .add("weight", this.weight)
            .toString();
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
        WeightedSerializableObject object = (WeightedSerializableObject) obj;
        return this.object.equals(object.object) && this.weight == object.weight;
    }

    @Override
    public DataContainer toContainer() {
        return new MemoryDataContainer()
            .set(Queries.WEIGHTED_SERIALIZABLE, this.get())
            .set(Queries.WEIGHTED_SERIALIZABLE_WEIGHT, this.weight);
    }
}
