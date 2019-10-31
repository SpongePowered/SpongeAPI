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
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.SerializableDataHolderBuilder;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.world.Archetype;
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
     * <p>The format used for this container follows the
     * <a href="https://minecraft.gamepedia.com/Chunk_format#Block_entity_format">Mojang ChunkFormat for BlockEntities.</a>,
     * and can be customized based on the origination of the {@link BlockEntity}.
     * If the block entity originates from a content-adding mod, the format could
     * vary based on it's implementation and may change at any time.
     * </p>
     *
     *
     * @return The copied container of the block entity
     */
    DataContainer getBlockEntityData();

    /**
     * Sets the raw data for the desired {@link BlockEntity}. Note that position
     * values are not used as those are dependent on usage.
     *
     * <p>The format used for this container follows the
     * <a href="https://minecraft.gamepedia.com/Chunk_format#Block_entity_format">Mojang ChunkFormat for BlockEntities.</a>,
     * and can be customized based on the origination of the {@link BlockEntity}.
     * If the block entity originates from a content-adding mod, the format could
     * vary based on it's implementation and may change at any time.
     * </p>
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
    interface Builder extends SerializableDataHolderBuilder.Mutable<BlockEntityArchetype, Builder> {

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

        /**
         * Copies the incoming {@link BlockEntity} for it's current state
         * of information, such as {@link BlockState}, {@link BlockEntityType},
         * and all related {@link DataView contained data}, except the position
         * and potentially any Sponge-added tracking information, such as owner
         * or notifier.
         *
         * <p>Note that this overwrites data set from the following methods:</p>
         * <ul>
         *     <li>{@link #from(Location)}</li>
         *     <li>{@link #state(BlockState)}</li>
         *     <li>{@link #blockEntity(BlockEntityType)}</li>
         *     <li>{@link #blockEntityData(DataView)}</li>
         *     <li>{@link #add(Value)}</li>
         *     <li>{@link #add(Key, Object)}</li>
         *     <li>{@link #add(DataManipulator)}</li>
         * </ul>
         *
         * @param blockEntity The block entity to absorb all data
         * @return This builder, for chaining
         */
        Builder blockEntity(BlockEntity blockEntity);

        /**
         * Sets the {@link DataView} to be used to copy data onto the created
         * {@link BlockEntity} when {@link BlockEntityArchetype#apply(Location)}
         * is called.
         *
         * <p>The format used for this container follows the
         * <a href="https://minecraft.gamepedia.com/Chunk_format#Block_entity_format">Mojang ChunkFormat for BlockEntities.</a>,
         * and can be customized based on the origination of the {@link BlockEntity}.
         * If the block entity originates from a content-adding mod, the format could
         * vary based on it's implementation and may change at any time.
         * </p>
         *
         * @param dataView The data view containing data pertinent to the
         *     {@link BlockEntity}
         * @return This builder, for chaining
         */
        Builder blockEntityData(DataView dataView);

        /**
         * Creates a new {@link BlockEntityArchetype} from this builder.
         *
         * @return The new instance
         */
        BlockEntityArchetype build();

    }
}
