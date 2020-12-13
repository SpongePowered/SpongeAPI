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
 * An entry which contains an object with the added restriction that the object
 * be serializable.
 *
 * @param <T> The entry type
 */
public class WeightedSerializableObject<T extends DataSerializable> extends WeightedObject<T> implements DataSerializable {

    /**
     * Creates a new {@link WeightedSerializableObject} with the provided
     * {@link DataSerializable}.
     *
     * @param object The serializable object
     * @param weight The weight
     */
    public WeightedSerializableObject(final T object, final int weight) {
        super(object, weight);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", WeightedSerializableObject.class.getSimpleName() + "[", "]")
            .add("object=" + this.get())
            .add("weight=" + this.getWeight())
            .toString();
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WeightedSerializableObject)) {
            return false;
        }
        final WeightedSerializableObject object = (WeightedSerializableObject) o;
        return this.get().equals(object.get()) && this.getWeight() == object.getWeight();
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    @Override
    public DataContainer toContainer() {
        return DataContainer.createNew()
                .set(Queries.CONTENT_VERSION, this.getContentVersion())
                .set(Queries.WEIGHTED_SERIALIZABLE, this.get())
                .set(Queries.WEIGHTED_SERIALIZABLE_WEIGHT, this.getWeight());
    }
}
