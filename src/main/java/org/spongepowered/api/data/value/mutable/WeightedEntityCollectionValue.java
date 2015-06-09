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
package org.spongepowered.api.data.value.mutable;

import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.value.immutable.ImmutableWeightedEntityCollectionValue;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.util.weighted.WeightedEntity;

import java.util.Collection;

/**
 * Represents a {@link WeightedCollectionValue} that uses a
 * {@link WeightedEntity} as the element type. This is mainly used to simplify
 * various {@link CollectionValue}s to use the {@link WeightedCollectionValue}.
 */
public interface WeightedEntityCollectionValue extends WeightedCollectionValue<WeightedEntity, WeightedEntityCollectionValue,
    ImmutableWeightedEntityCollectionValue> {

    /**
     * Adds a new {@link WeightedEntity} with the provided {@link EntityType}
     * and a {@link Collection} of {@link DataManipulator}s. The default weight
     * will be set to 1 for the weighted entity.
     *
     * @param entityType The entity type of the {@link WeightedEntity}
     * @param entityData The extra data to provide to the weighted entity
     * @return This value, for chaining
     */
    WeightedEntityCollectionValue add(EntityType entityType, Collection<DataManipulator<?, ?>> entityData);



}
