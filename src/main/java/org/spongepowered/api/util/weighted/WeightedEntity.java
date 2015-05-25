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
import com.google.common.collect.ImmutableList;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.entity.EntityType;

import java.util.List;

/**
 * Represents an entity type with a numerical weight used for random selection
 * from a collection of weighted types.
 */
public class WeightedEntity extends WeightedObject<EntityType> {

    private final ImmutableList<DataManipulator<?>> additionalProperties;

    /**
     * Creates a new {@link WeightedEntity} with no additional properties.
     * 
     * @param object The entity type
     * @param weight The weight
     */
    public WeightedEntity(EntityType object, int weight) {
        super(object, weight);
        this.additionalProperties = ImmutableList.of();
    }

    /**
     * Creates a new {@link WeightedEntity} with the given additional
     * properties.
     * 
     * @param object The entity type
     * @param weight The weight
     * @param extraProperties The additional properties to apply to the entity
     */
    public WeightedEntity(EntityType object, int weight, DataManipulator<?>... extraProperties) {
        super(object, weight);
        ImmutableList.Builder<DataManipulator<?>> builder = ImmutableList.builder();
        for (DataManipulator<?> property : extraProperties) {
            builder.add(property.copy());
        }
        this.additionalProperties = builder.build();
    }

    /**
     * Creates a new {@link WeightedEntity} with the given additional
     * properties.
     *
     * @param object The entity type
     * @param weight The weight
     * @param extraProperties The additional properties to apply to the entity
     */
    public WeightedEntity(EntityType object, int weight, Iterable<DataManipulator<?>> extraProperties) {
        super(object, weight);
        ImmutableList.Builder<DataManipulator<?>> builder = ImmutableList.builder();
        for (DataManipulator<?> property : extraProperties) {
            builder.add(property.copy());
        }
        this.additionalProperties = builder.build();
    }
    
    /**
     * Gets the additional properties to apply to the entity.
     *
     * @return The additional properties
     */
    public List<DataManipulator<?>> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("object", this.object)
                .add("weight", this.weight)
                .add("additionalProperties", this.additionalProperties)
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
        WeightedEntity object = (WeightedEntity) obj;
        if (!this.object.equals(object.object)) {
            return false;
        }
        if (!this.additionalProperties.equals(object.additionalProperties)) {
            return false;
        }
        return this.weight == object.weight;
    }

}
