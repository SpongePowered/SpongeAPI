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
     * Creates a new {@link EntityArchetype} with the specified {@link EntityType}.
     * @param type Type of the entity
     * @return An archetype of the given entity type
     */
    static EntityArchetype of(EntityType type) {
        return builder().type(type).build();
    }

    /**
     * Gets the {@link EntityType} of the entity contained in this archetype.
     * 
     * @return The entity type
     */
    EntityType getType();

    /**
     * Gets the raw {@link Entity} data that would be applied to the generated
     * entity. Note that this is a copied container.
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

        /**
         * Sets all possible bits of information from the provided {@link Entity}.
         *
         * @param entity The entity to get information from
         * @return This builder, for chaining
         */
        Builder from(Entity entity);

        /**
         * Sets the desired {@link EntityType} of the produced {@link EntityArchetype}.
         *
         * @param type The type of entity type
         * @return This builder, for chaining
         */
        Builder type(EntityType type);

        /**
         * Sets the desired {@link EntityType} of the produced {@link EntityArchetype}.
         *
         * @param view The data to set for the archetype
         * @return This builder, for chaining
         */
        Builder entityData(DataView view);

        /**
         * Sets the desired {@link EntityType} of the produced {@link EntityArchetype}.
         *
         * @param manipulator The manipulator to set for the archetype
         * @return This builder, for chaining
         */
        Builder setData(DataManipulator<?, ?> manipulator);

        /**
         * Sets the desired {@link EntityType} of the produced {@link EntityArchetype}.
         *
         * @param value The type of entity type
         * @return This builder, for chaining
         */
        <E, V extends BaseValue<E>> Builder set(V value);

        /**
         * Sets the desired {@link EntityType} of the produced {@link EntityArchetype}.
         *
         * @param key The key
         * @param value The value to set
         * @return This builder, for chaining
         */
        <E, V extends BaseValue<E>> Builder set(Key<V> key, E value);

        /**
         * Constructs a new {@link EntityArchetype}.
         *
         * @return The new entity archetype
         */
        EntityArchetype build();
    }

}
