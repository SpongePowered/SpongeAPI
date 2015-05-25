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

import org.spongepowered.api.world.gen.Populator;

/**
 * Represents a populator which spawns patches of pumpkins randomly within
 * chunks.
 */
public interface Pumpkin extends Populator {

    /**
     * Gets the number of pumpkins to attempt to spawn per patch, must be
     * greater than zero. The default value is 64.
     * 
     * @return The number to spawn
     */
    int getPumpkinsPerChunk();

    /**
     * Sets the number of pumpkins to attempt to spawn per patch, must be
     * greater than zero. The default value is 64.
     * 
     * @param count The new number to spawn
     */
    void setPumpkinsPerChunk(int count);

    /**
     * Gets the chance of a pumpkin patch spawning within a chunk. The default
     * value is 32 (which corresponds to a 1 in 32 chance).
     * 
     * @return The chance of a patch spawning
     */
    int getPumpkinChance();

    /**
     * Sets the chance of a pumpkin patch spawning within a chunk. The default
     * value is 32 (which corresponds to a 1 in 32 chance).
     * 
     * @param chance The new chance of a patch spawning
     */
    void setPumpkinChance(int chance);

    /**
     * A builder for constructing {@link Pumpkin} populators.
     */
    interface Builder {

        /**
         * Sets the number of pumpkins to attempt to spawn per patch, must be
         * greater than zero. The default value is 64.
         * 
         * @param count The new number to spawn
         * @return This builder, for chaining
         */
        Builder perChunk(int count);

        /**
         * Sets the chance of a pumpkin patch spawning within a chunk. The
         * default value is 32 (which corresponds to a 1 in 32 chance).
         * 
         * @param chance The new chance of a patch spawning
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
         * Builds a new instance of a {@link Pumpkin} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *             which do not have default values
         */
        Pumpkin build() throws IllegalStateException;

    }

}
