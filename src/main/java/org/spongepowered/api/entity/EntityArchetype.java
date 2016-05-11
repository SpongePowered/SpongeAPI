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
package org.spongepowered.api.entity;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.Archetype;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.data.value.BaseValue;

public interface EntityArchetype extends Archetype<EntitySnapshot> {

    /**
     * Creates a {@link Builder} to get {@link EntityArchetype}s.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the {@link EntityType} of the entity contained in this archetype.
     * 
     * @return The entity type
     */
    EntityType getType();

    /**
     * Gets the raw {@link Entity} data that would be applied to the generated
     * tile entity. Note that this is a copied container.
     *
     * @return The copied container of the entity
     */
    DataContainer getEntityData();

    @Override
    void setRawData(DataView container) throws InvalidDataException;

    @Override
    EntityArchetype copy();

    /**
     * A builder for {@link EntityArchetype}s.
     */
    interface Builder extends DataBuilder<EntityArchetype> {

        @Override
        Builder reset();

        @Override
        Builder from(EntityArchetype value);

        Builder type(EntityType type);

        Builder from(Entity entity);

        Builder entityData(DataView view);

        Builder setData(DataManipulator<?, ?> manipulator);

        <E, V extends BaseValue<E>> Builder set(V value);

        <E, V extends BaseValue<E>> Builder set(Key<V> key, E value);

        EntityArchetype build();
    }

}
