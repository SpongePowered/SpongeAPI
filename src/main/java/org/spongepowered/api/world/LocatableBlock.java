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
package org.spongepowered.api.world;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.data.SerializableDataHolder;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.math.vector.Vector3i;

public interface LocatableBlock extends SerializableDataHolder.Immutable<LocatableBlock>, Locatable {

    /**
     * Creates a new {@link Builder} for creating new {@link LocatableBlock}s.
     *
     * @return A new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the {@link BlockState} for this locatable block.
     *
     * @return The block state
     */
    BlockState getBlockState();

    /**
     * Gets the {@link Vector3i position} for this locatable block.
     *
     * @return The position for the block
     */
    default Vector3i getBlockPosition() {
        return getLocation().getBlockPosition();
    }

    interface Builder extends CopyableBuilder<LocatableBlock, Builder>, DataBuilder<LocatableBlock> {

        /**
         * Sets the {@link BlockState} for this builder.
         *
         * @param blockState The block state
         * @return This builder, for chaining
         */
        Builder state(BlockState blockState);

        /**
         * Sets the {@link BlockState} and {@link Vector3i position} for this
         * builder.
         *
         * @param location The location containing the block state and position
         * @return This builder, for chaining
         */
        Builder location(Location location);

        /**
         * Sets the {@link Vector3i position} for this builder.
         *
         * @param position The position
         * @return This builder, for chaining
         */
        Builder position(Vector3i position);

        /**
         * Sets the {@code x} {@code y} {@code z} positions for this builder.
         *
         * @param x The x coordinate
         * @param y The y coordinate
         * @param z The z coordinate
         * @return This builder, for chaining
         */
        Builder position(int x, int y, int z);

        /**
         * Sets the {@link World} for this builder, used to get the {@link BlockState}
         * for a desired position.
         *
         * @param world The world
         * @return This builder, for chaining
         */
        Builder world(World world);

        @Override
        Builder reset();

        @Override
        Builder from(LocatableBlock value);

        /**
         * Creates a new {@link LocatableBlock}.
         *
         * @return The new locatable block
         */
        LocatableBlock build();
    }

}
