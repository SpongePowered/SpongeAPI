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
 * Represents a populator which will randomly spawn a number of cacti within the
 * chunk. The cacti will only be spawned at valid locations, that is on top of a
 * sand block with no immediately surrounding blocks.
 */
public interface Cactus extends Populator {

    /**
     * Gets the number of cacti to spawn per chunk.
     * 
     * @return The number of cacti to spawn
     */
    int getCactiPerChunk();

    /**
     * Sets the number of cacti to spawn per chunk, cannot be negative.
     * 
     * @param count The new number of cacti to spawn
     */
    void setCactiPerChunk(int count);

    /**
     * A builder for constructing {@link Cactus} populators.
     */
    interface Builder {

        /**
         * Sets the number of cacti to spawn per chunk, cannot be negative.
         * 
         * @param count The new number of cacti to spawn
         * @return This builder, for chaining
         */
        Builder cactiPerChunk(int count);

        /**
         * Resets this builder to the default values.
         * 
         * @return This builder, for chaining
         */
        Builder reset();

        /**
         * Builds a new instance of a {@link Cactus} populator with the settings
         * set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *             which do not have default values
         */
        Cactus build() throws IllegalStateException;

    }

}
