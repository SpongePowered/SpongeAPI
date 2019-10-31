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
package org.spongepowered.api.block;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.entity.BlockEntity;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.SerializableDataHolderBuilder;
import org.spongepowered.api.data.DirectionRelativeDataHolder;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.fluid.FluidState;
import org.spongepowered.api.state.State;
import org.spongepowered.api.world.Location;

/**
 * Represents a particular "state" that can exist at a {@link Location} with
 * a particular {@link BlockType} and various {@link org.spongepowered.api.data.value.Value.Immutable}s defining
 * the information for the "block". Note that normally, there may exist only
 * a single instance of a particular {@link BlockState} as they are immutable,
 * a particular instance may be cached for various uses.
 */
public interface BlockState extends State<BlockState>, DirectionRelativeDataHolder.Immutable<BlockState> {

    /**
     * Creates a new {@link Builder} for building {@link BlockState}s.
     *
     * @return The builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Constructs a new builder to construct a {@link BlockStateMatcher}.
     *
     * @param type The block type
     * @return The builder
     */
    static BlockStateMatcher.Builder matcher(BlockType type) {
        return BlockStateMatcher.builder().type(type);
    }

    /**
     * Gets the base type of block.
     *
     * <p>The type does not include block data such as the contents of
     * inventories.</p>
     *
     * @return The type of block
     */
    BlockType getType();

    /**
     * Gets the associated {@link FluidState} for this block state.
     * Depending on whether this block state is considered "waterlogged"
     * or not, and with which fluid.
     *
     * @return The fluid state
     */
    FluidState getFluidState();

    /**
     * Creates a new {@link BlockSnapshot} with this current {@link BlockState}
     * at the desired {@link Location}. If the {@link Location} has the same
     * {@link BlockState}, and the {@link BlockType} can house a
     * {@link BlockEntity}, the data from the block entity may be included in the
     * returned  {@link BlockSnapshot}.
     *
     * @param location The location for the snapshot
     * @return The newly created snapshot
     */
    BlockSnapshot snapshotFor(Location location);

    /**
     * An {@link org.spongepowered.api.data.DataHolderBuilder.Immutable} for a {@link BlockState}. Just like the
     * {@link org.spongepowered.api.data.DataHolderBuilder.Immutable}, the {@link Value}s passed in to
     * create a {@link BlockState} are copied on creation.
     *
     * <p>Note that upon creation, the {@link BlockType} must be set for validation
     * of {@link DataManipulator}s, otherwise exceptions may be thrown.</p>
     */
    interface Builder extends SerializableDataHolderBuilder.Immutable<BlockState, Builder> {

        /**
         * Sets the {@link BlockType} for the {@link BlockState} to build.
         *
         * <p>The {@link BlockType} is used for some pre-validation on addition of
         * {@link DataManipulator}s through {@link #add(DataManipulator)}. It is
         * important to understand that not all manipulators are compatible with
         * all {@link BlockType}s.</p>
         *
         * @param blockType The block type
         * @return This builder, for chaining
         */
        Builder blockType(BlockType blockType);

    }
}
