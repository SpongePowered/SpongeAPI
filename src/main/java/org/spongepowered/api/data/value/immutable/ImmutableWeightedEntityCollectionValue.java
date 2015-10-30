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
package org.spongepowered.api.data.value.immutable;

import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.value.mutable.WeightedEntityCollectionValue;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.util.weighted.WeightedCollection;
import org.spongepowered.api.util.weighted.WeightedSerializableObject;

import java.util.Collection;

/**
 * Represents an {@link ImmutableWeightedEntityCollectionValue} that uses a
 * {@link WeightedSerializableObject} as the element type. This is mainly used to simplify
 * various {@link ImmutableCollectionValue}s to use the
 * {@link WeightedCollection} type.
 */
public interface ImmutableWeightedEntityCollectionValue extends ImmutableWeightedCollectionValue<WeightedSerializableObject<EntitySnapshot>,
    ImmutableWeightedEntityCollectionValue, WeightedEntityCollectionValue> {

    /**
     * Adds a new {@link WeightedSerializableObject} with the provided {@link EntityType}
     * and a {@link Collection} of {@link DataManipulator}s. The default weight
     * will be set to 1 for the weighted entity.
     *
     * @param entityType The entity type of the {@link WeightedSerializableObject}
     * @param entityData The extra data to provide to the weighted entity
     * @return The newly constructed weighted collection value
     */
    ImmutableWeightedEntityCollectionValue with(EntityType entityType, Collection<DataManipulator<?, ?>> entityData);

}
