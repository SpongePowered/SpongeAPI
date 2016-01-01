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
package org.spongepowered.api.world.gen.populator;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.weighted.VariableAmount;
import org.spongepowered.api.world.gen.Populator;

/**
 * Represents a populator which places in a number of 'blobs' of a specific
 * block state. The 'blob' is here defined as the union of three ellipsoids
 * whose radii are set randomly between the base radius (inclusive) and the base
 * radius plus the variance (exclusive).
 */
public interface BlockBlob extends Populator {

    /**
     * Creates a new {@link Builder} to build a {@link BlockBlob} populator.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the {@link BlockState} that this populator will place down to form
     * the blob.
     * 
     * @return The block state
     */
    BlockState getBlock();

    /**
     * Sets the {@link BlockState} that this populator will place down to form
     * the blob.
     * 
     * @param state The new block state
     */
    void setBlock(BlockState state);

    /**
     * Gets the radius of the area for the blob.
     * 
     * @return The radius
     */
    VariableAmount getRadius();

    /**
     * Sets the radius of the area for the blob, cannot be negative.
     * 
     * @param radius The new radius
     */
    void setRadius(VariableAmount radius);

    /**
     * Sets the radius of the area for the blob, cannot be negative.
     * 
     * @param radius The new radius
     */
    default void setRadius(double radius) {
        setRadius(VariableAmount.fixed(radius));
    }

    /**
     * Gets the number of blobs which will be placed per chunk.
     * 
     * @return The number of blobs
     */
    VariableAmount getCount();

    /**
     * Sets the number of blobs to spawn per chunk, must be greater than zero.
     * 
     * @param count The new number of blobs
     */
    void setCount(VariableAmount count);

    /**
     * Sets the number of blobs to spawn per chunk, must be greater than zero.
     * 
     * @param count The new number of blobs
     */
    default void setCount(int count) {
        setCount(VariableAmount.fixed(count));
    }

    /**
     * A builder for constructing {@link BlockBlob} populators.
     */
    interface Builder extends ResettableBuilder<BlockBlob, Builder> {

        /**
         * Sets the {@link BlockState} that this populator will place down to
         * form the blob.
         * 
         * @param block the new block state
         * @return This builder, for chaining
         */
        Builder block(BlockState block);

        /**
         * Sets the radius of the area for the blob, cannot be negative.
         * 
         * @param radius The new radius
         * @return This builder, for chaining
         */
        Builder radius(VariableAmount radius);

        /**
         * Sets the radius of the area for the blob, cannot be negative.
         * 
         * @param radius The new radius
         * @return This builder, for chaining
         */
        default Builder radius(double radius) {
            return radius(VariableAmount.fixed(radius));
        }

        /**
         * Sets the number of blobs to spawn per chunk, must be greater than
         * zero.
         * 
         * @param count The number of blobs to spawn
         * @return This builder, for chaining
         */
        Builder blobCount(VariableAmount count);

        /**
         * Sets the number of blobs to spawn per chunk, must be greater than
         * zero.
         * 
         * @param count The number of blobs to spawn
         * @return This builder, for chaining
         */
        default Builder blobCount(int count) {
            return blobCount(VariableAmount.fixed(count));
        }

        /**
         * Builds a new instance of a {@link BlockBlob} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *         which do not have default values
         */
        BlockBlob build() throws IllegalStateException;

    }

}
