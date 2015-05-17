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
 * Represents a populator which seeds the underground areas of the chunks with
 * ores.
 */
public interface Ore extends Populator {

    /**
     * Gets the block to place as ore.
     * 
     * @return The ore block
     */
    BlockState getOreBlock();

    /**
     * Sets the block to place as ore.
     * 
     * @param block The new ore block
     */
    void setOreBlock(BlockState block);

    /**
     * Gets the size of deposit of ore. This is the number of blocks per clump
     * of ores spawned.
     * 
     * @return The deposit size
     */
    int getDepositSize();

    /**
     * Sets the size of deposit of ore. This is the number of blocks per clump
     * of ores spawned.
     * 
     * @param size The new deposit size
     */
    void setDepositSize(int size);

    /**
     * Gets the number of ore clumps to attempt to spawn per chunk, must be
     * greater than zero.
     * 
     * @return The number of clumps to spawn
     */
    int getDepositsPerChunk();

    /**
     * Sets the number of ore clumps to attempt to spawn per chunk, must be
     * greater than zero.
     * 
     * @param count The new number of clumps to spawn
     */
    void setDepositsPerChunk(int count);

    /**
     * Gets the minimum height that the ore can generate at.
     * 
     * @return The minimum height
     */
    int getMinHeight();

    /**
     * Sets the minimum height that the ore can generate at.
     * 
     * @param min The new minimum height
     */
    void setMinHeight(int min);

    /**
     * Gets the maximum height that the ore can generate at.
     * 
     * @return The maximum height
     */
    int getMaxHeight();

    /**
     * Sets the maximum height that the ore can generate at.
     * 
     * @param max The new maximum height
     */
    void setMaxHeight(int max);

    /**
     * A builder for constructing {@link Ore} populators.
     */
    interface Builder {

        /**
         * Sets the block to place as ore.
         * 
         * @param block The new ore block
         * @return This builder, for chaining
         */
        Builder ore(BlockState block);

        /**
         * Sets the size of deposit of ore. This is the number of blocks per
         * clump of ores spawned.
         * 
         * @param size The new deposit size
         * @return This builder, for chaining
         */
        Builder size(int size);

        /**
         * Sets the number of ore clumps to attempt to spawn per chunk, must be
         * greater than zero.
         * 
         * @param count The new number of clumps to spawn
         * @return This builder, for chaining
         */
        Builder perChunk(int count);

        /**
         * Sets the minimum height that the ore can generate at.
         * 
         * @param min The new minimum height
         * @return This builder, for chaining
         */
        Builder minHeight(int min);

        /**
         * Sets the maximum height that the ore can generate at.
         * 
         * @param max The new maximum height
         * @return This builder, for chaining
         */
        Builder maxHeight(int max);

        /**
         * Resets this builder to the default values.
         * 
         * @return This builder, for chaining
         */
        Builder reset();

        /**
         * Builds a new instance of a {@link Ore} populator with the settings
         * set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *             which do not have default values
         */
        Ore build() throws IllegalStateException;

    }

}
