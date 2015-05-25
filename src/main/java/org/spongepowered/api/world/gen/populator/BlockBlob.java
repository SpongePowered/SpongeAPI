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

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.world.gen.Populator;

/**
 * Represents a populator which places in a number of 'blobs' of a specific
 * block state. The 'blob' is here defined as the union of three ellipsoids
 * whose radii are set randomly between the base radius (inclusive) and the base
 * radius plus the variance (exclusive).
 */
public interface BlockBlob extends Populator {

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
     * Gets the base radius of the area for the blob.
     * 
     * @return The base radius
     */
    int getBaseRadius();

    /**
     * Sets the base radius of the area for the blob, cannot be negative.
     * 
     * <p>This defaults to 1.</p>
     * 
     * @param radius The new base radius
     */
    void setBaseRadius(int radius);

    /**
     * Gets the radius variance of the blob.
     * 
     * @return The radius variance
     */
    int getRadiusVariance();

    /**
     * Sets the radius variance of the blob, must be greater than zero (a
     * variance of one will correspond to a final radius of
     * {@code finalRadius = baseRadius + [0,1) = baseRadius }).
     * 
     * <p>This defaults to 2.</p>
     * 
     * @param variance The new radius variance
     */
    void setRadiusVariance(int variance);

    /**
     * Gets the number of blobs which will be placed per chunk.
     * 
     * @return The number of blobs
     */
    int getCount();

    /**
     * Sets the number of blobs to spawn per chunk, must be greater than zero.
     * 
     * <p>This defaults to 3.</p>
     * 
     * @param count The new number of blobs
     */
    void setCount(int count);

    /**
     * A builder for constructing {@link BlockBlob} populators.
     */
    interface Builder {

        /**
         * Sets the {@link BlockState} that this populator will place down to
         * form the blob.
         * 
         * @param block the new block state
         * @return This builder, for chaining
         */
        Builder block(BlockState block);

        /**
         * Sets the base radius of the area for the blob, cannot be negative.
         * 
         * <p>This defaults to 1.</p>
         * 
         * @param radius The new base radius
         * @return This builder, for chaining
         */
        Builder baseRadius(int radius);

        /**
         * Sets the radius variance of the blob, must be greater than zero (a
         * variance of one will correspond to a final radius of
         * {@code finalRadius = baseRadius + [0,1) = baseRadius }).
         * 
         * <p>This defaults to 2.</p>
         * 
         * @param variance The new radius variance
         * @return This builder, for chaining
         */
        Builder radiusVariance(int variance);

        /**
         * Sets the number of blobs to spawn per chunk, must be greater than
         * zero.
         * 
         * <p>This defaults to 3.</p>
         * 
         * @param count The number of blobs to spawn
         * @return This builder, for chaining
         */
        Builder blockCount(int count);

        /**
         * Resets this builder to the default values.
         * 
         * @return This builder, for chaining
         */
        Builder reset();

        /**
         * Builds a new instance of a {@link BlockBlob} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *             which do not have default values
         */
        BlockBlob build() throws IllegalStateException;

    }

}
