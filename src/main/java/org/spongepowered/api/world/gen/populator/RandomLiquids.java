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
 * Represents a populator which places random liquid sources in walls of caves
 * or the terrain of the chunk.
 */
public interface RandomLiquids extends Populator {

    /**
     * Gets the {@link BlockState} of the liquid to fill the lake with.
     * 
     * @return The lake block state
     */
    BlockState getLiquidType();

    /**
     * Sets the {@link BlockState} of the liquid to fill the lake with.
     * 
     * @param liquid The new lake block state
     */
    void setLiquidType(BlockState liquid);

    /**
     * Gets the number of liquid sources to attempt to spawn per chunk, must be
     * greater than zero. The default is 20 for lava and 50 for water.
     * 
     * @return The number of attempts to make
     */
    int getAttemptsPerChunk();

    /**
     * Sets the number of liquid sources to attempt to spawn per chunk, must be
     * greater than zero. The default is 20 for lava and 50 for water.
     * 
     * @param attempts The new number of attempts to make
     */
    void setAttemptsPerChunk(int attempts);

    /**
     * A builder for constructing {@link RandomLiquids} populators.
     */
    interface Builder {

        /**
         * Sets the {@link BlockState} of the liquid to fill the lake with.
         * 
         * @param liquid The new lake block state
         * @return This builder, for chaining
         */
        Builder liquidType(BlockState liquid);

        /**
         * Sets the number of liquid sources to attempt to spawn per chunk, must
         * be greater than zero. The default is 20 for lava and 50 for water.
         * 
         * @param attempts The new number of attempts to make
         * @return This builder, for chaining
         */
        Builder perChunk(int attempts);

        /**
         * Resets this builder to the default values.
         * 
         * @return This builder, for chaining
         */
        Builder reset();

        /**
         * Builds a new instance of a {@link RandomLiquids} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *             which do not have default values
         */
        RandomLiquids build() throws IllegalStateException;

    }

}
