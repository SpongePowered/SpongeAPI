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
 * Represents a populator which will attempt to spawn lakes within the chunk
 * dependending on a random chance.
 */
public interface Lake extends Populator {

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
     * Gets the chance of a lake spawning in a chunk. The default value is 4 for
     * water lakes and 80 for lava lakes (therefore equating to a 1 in 4 chance
     * and a 1 in 80 chance respectively).
     * 
     * @return The lake spawn chance
     */
    int getLakeChance();

    /**
     * Sets the chance of a lake spawning in a chunk. The default value is 4 for
     * water lakes and 80 for lava lakes (therefore equating to a 1 in 4 chance
     * and a 1 in 80 chance respectively).
     * 
     * @param chance The new lake spawn chance
     */
    void setLakeChance(int chance);

    /**
     * A builder for constructing {@link Lake} populators.
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
         * Sets the chance of a lake spawning in a chunk. The default value is 4
         * for water lakes and 80 for lava lakes (therefore equating to a 1 in 4
         * chance and a 1 in 80 chance respectively).
         * 
         * @param chance The new lake spawn chance
         * @return This builder, for chaining
         */
        Builder chance(int chance);

        /**
         * Resets this builder to the default values.
         * 
         * @return This builder, for chaining
         */
        Builder reset();

        /**
         * Builds a new instance of a {@link Lake} populator with the settings
         * set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *             which do not have default values
         */
        Lake build() throws IllegalStateException;

    }

}
