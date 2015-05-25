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
import org.spongepowered.api.world.gen.type.BiomeTreeType;

/**
 * Represents a populator which spawns the huge tree variants of the standard
 * trees.
 */
public interface HugeTree extends Populator {

    /**
     * Gets the number of trees to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @return The number to spawn
     */
    int getTreesPerChunk();

    /**
     * Sets the number of trees to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @param count The new amount to spawn
     */
    void setTreesPerChunk(int count);

    /**
     * Gets the type of huge tree to spawn.
     * 
     * @return The tree type
     */
    BiomeTreeType getType();

    /**
     * Sets the type of huge tree to spawn. If the given type does not have a
     * valid huge tree equivalent then this method will have no effect.
     * 
     * @param type The new tree type
     */
    void setType(BiomeTreeType type);

    /**
     * A builder for constructing {@link HugeTree} populators.
     */
    interface Builder {

        /**
         * Sets the number of trees to attempt to spawn per chunk, must be
         * greater than zero.
         * 
         * @param count The new amount to spawn
         * @return This builder, for chaining
         */
        Builder perChunk(int count);

        /**
         * Sets the type of huge tree to spawn. If the given type does not have
         * a valid huge tree equivalent then this method will have no effect.
         * 
         * @param type The new tree type
         * @return This builder, for chaining
         */
        Builder type(BiomeTreeType type);

        /**
         * Resets this builder to the default values.
         * 
         * @return This builder, for chaining
         */
        Builder reset();

        /**
         * Builds a new instance of a {@link HugeTree} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *             which do not have default values
         */
        HugeTree build() throws IllegalStateException;

    }

}
