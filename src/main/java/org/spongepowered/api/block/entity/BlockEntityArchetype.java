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
package org.spongepowered.api.block.entity;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.data.Archetype;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.world.Location;

/**
 * Represents the data of a {@link BlockEntity} which does not exist in the world
 * and may be used to create new {@link BlockEntity}s with the same data.
 */
public interface BlockEntityArchetype extends Archetype<BlockSnapshot, BlockEntity> {

    /**
     * Creates a {@link Builder} to get {@link BlockEntityArchetype}s.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the block state for this archetype. Note that this state is
     * unchangeable, as much as {@link #getBlockEntityType()} is. The underlying
     * data is mutable, but all the data is heavily tied to the block entity
     * type.
     *
     * @return The block state
     */
    BlockState getState();

    /**
     * Gets the {@link BlockEntityType} for this archetype.
     *
     * @return The block entity type
     */
    BlockEntityType getBlockEntityType();

    /**
     * Gets the raw {@link BlockEntity} data that would be applied to the
     * generated block entity. Note that this is a copied container.
     *
     * @return The copied container of the block entity
     */
    DataContainer getBlockEntityData();

    /**
     * Sets the raw data for the desired {@link BlockEntity}. Note that position
     * values are not used as those are dependent on usage.
     *
     * @param container A container containing all raw data to set on this data
     *        holder
     * @throws InvalidDataException If the data is not valid for the archetyped
     *         block entity
     */
    @Override
    void setRawData(DataView container) throws InvalidDataException;

    @Override
    BlockEntityArchetype copy();

    /**
     * A builder for {@link BlockEntityArchetype}s.
     */
    interface Builder extends DataBuilder<BlockEntityArchetype> {

        @Override
        Builder reset();

        @Override
        Builder from(BlockEntityArchetype value);

        Builder from(Location location);

        /**
         * Sets the {@link BlockState} of the archetype.
         *
         * @param state The new block state
         * @return This builder, for chaining
         */
        Builder state(BlockState state);

        Builder blockEntity(BlockEntityType type);

        Builder blockEntity(BlockEntity blockEntity);

        Builder blockEntityData(DataView dataView);

        Builder set(DataManipulator manipulator);

        <E, V extends Value<E>> Builder set(V value);

        <E, V extends Value<E>> Builder set(Key<V> key, E value);

        /**
         * Creates a new {@link BlockEntityArchetype} from this builder.
         * 
         * @return The new instance
         */
        BlockEntityArchetype build();

    }
}
