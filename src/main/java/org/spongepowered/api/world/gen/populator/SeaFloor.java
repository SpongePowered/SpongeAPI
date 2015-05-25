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
 * Represents a populator which places down a disc of material onto the bottom
 * on an ocean or river.
 */
public interface SeaFloor extends Populator {

    /**
     * Gets the {@link BlockState} to place down.
     * 
     * @return The block to place
     */
    BlockState getBlock();

    /**
     * Sets the {@link BlockState} to place down.
     * 
     * @param block The new block to place
     */
    void setBlock(BlockState block);

    /**
     * Gets the number of discs to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @return The amount to spawn
     */
    int getBlocksPerChunk();

    /**
     * Sets the number of discs to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @param count The new amount to spawn
     */
    void setBlocksPerChunk(int count);

    /**
     * Gets the radius of the discs being spawned.
     * 
     * @return The disc radius
     */
    int getRadius();

    /**
     * Sets the radius of the discs being spawned.
     * 
     * @param radius The new disc radius
     */
    void setRadius(int radius);

    /**
     * A builder for constructing {@link SeaFloor} populators.
     */
    interface Builder {

        /**
         * Sets the {@link BlockState} to place down.
         * 
         * @param block The new block to place
         * @return This builder, for chaining
         */
        Builder block(BlockState block);

        /**
         * Sets the number of discs to attempt to spawn per chunk, must be greater
         * than zero.
         * 
         * @param count The new amount to spawn
         * @return This builder, for chaining
         */
        Builder perChunk(int count);

        /**
         * Sets the radius of the discs being spawned.
         * 
         * @param radius The new disc radius
         * @return This builder, for chaining
         */
        Builder radius(int radius);

        /**
         * Resets this builder to the default values.
         * 
         * @return This builder, for chaining
         */
        Builder reset();

        /**
         * Builds a new instance of a {@link SeaFloor} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *             which do not have default values
         */
        SeaFloor build() throws IllegalStateException;

    }

}
