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

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.world.gen.Populator;

/**
 * Represents a populator which creates fires on the surfaces of targeted
 * blocks. In vanilla this is used to create random fires in the Nether.
 */
public interface RandomFire extends Populator {

    /**
     * Gets the number of fires to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @return The number to spawn
     */
    int getFirePerChunk();

    /**
     * Sets the number of fires to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @param count The new number to spawn
     */
    void setFirePerChunk(int count);

    /**
     * Gets the block type targeted by this populator, fires will only be
     * started when on top of this block type.
     * 
     * @return The targeted block
     */
    BlockType getPlacementTarget();

    /**
     * Sets the block type targeted by this populator, fires will only be
     * started when on top of this block type.
     * 
     * @param target The new targeted block
     */
    void setPlacementTarget(BlockType target);

    /**
     * A builder for constructing {@link RandomFire} populators.
     */
    interface Builder {

        /**
         * Sets the number of fires to attempt to spawn per chunk, must be
         * greater than zero.
         * 
         * @param count The new number to spawn
         * @return This builder, for chaining
         */
        Builder perChunk(int count);

        /**
         * Sets the block type targeted by this populator, fires will only be
         * started when on top of this block type.
         * 
         * @param target The new targeted block
         * @return This builder, for chaining
         */
        Builder placementTarget(BlockType target);

        /**
         * Resets this builder to the default values.
         * 
         * @return This builder, for chaining
         */
        Builder reset();

        /**
         * Builds a new instance of a {@link RandomFire} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *             which do not have default values
         */
        RandomFire build() throws IllegalStateException;

    }

}
