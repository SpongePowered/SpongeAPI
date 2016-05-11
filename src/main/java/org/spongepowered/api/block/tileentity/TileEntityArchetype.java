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
package org.spongepowered.api.block.tileentity;

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
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

/**
 * Represents the data of a {@link TileEntity} which does not exist in the world
 * and may be used to create new {@link TileEntity}s with the same data.
 */
public interface TileEntityArchetype extends Archetype<BlockSnapshot> {

    /**
     * Creates a {@link Builder} to get {@link TileEntityArchetype}s.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the block state for this archetype. Note that this state is
     * unchangeable, as much as {@link #getTileEntityType()} is. The underlying
     * data is mutable, but all the data is heavily tied to the tile entity
     * type.
     *
     * @return The block state
     */
    BlockState getState();

    /**
     * Gets the {@link TileEntityType} for this archetype.
     *
     * @return The tile entity type
     */
    TileEntityType getTileEntityType();

    /**
     * Gets the raw {@link TileEntity} data that would be applied to the
     * generated tile entity. Note that this is a copied container.
     *
     * @return The copied container of the tile entity
     */
    DataContainer getTileData();

    /**
     * Sets the raw data for the desired {@link TileEntity}. Note that position
     * values are not used as those are dependent on usage.
     *
     * @param container A container containing all raw data to set on this data
     *        holder
     * @throws InvalidDataException If the data is not valid for the archetyped
     *         tile entity
     */
    @Override
    void setRawData(DataView container) throws InvalidDataException;

    @Override
    TileEntityArchetype copy();

    /**
     * A builder for {@link TileEntityArchetype}s.
     */
    interface Builder extends DataBuilder<TileEntityArchetype> {

        @Override
        Builder reset();

        @Override
        Builder from(TileEntityArchetype value);

        /**
         * Sets the {@link BlockState} of the archetype.
         * 
         * @param state The new block state
         * @return This builder, for chaining
         */
        Builder state(BlockState state);

        Builder tile(TileEntityType tileEntityType);

        Builder from(Location<World> location);

        Builder tile(TileEntity tileEntity);

        Builder tileData(DataView dataView);

        Builder setData(DataManipulator<?, ?> manipulator);

        <E, V extends BaseValue<E>> Builder set(V value);

        <E, V extends BaseValue<E>> Builder set(Key<V> key, E value);

        /**
         * Creates a new {@link TileEntityArchetype} from this builder.
         * 
         * @return The new instance
         */
        TileEntityArchetype build();

    }
}
