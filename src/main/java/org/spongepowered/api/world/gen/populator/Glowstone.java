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
 * Represents a populator which spawns clusters of glowstone.
 */
public interface Glowstone extends Populator {

    /**
     * Gets the number of clusters to attempt to spawn per chunk, must be
     * greater than zero.
     * 
     * @return The number to spawn
     */
    int getClustersPerChunk();

    /**
     * Sets the number of clusters to attempt to spawn per chunk, must be
     * greater than zero.
     * 
     * @param count The new amount to spawn
     */
    void setClustersPerChunk(int count);

    /**
     * Gets the amount of glowstone to attempt to spawn per cluster, must be
     * greater than zero.
     * 
     * @return The number to spawn
     */
    int getAttemptsPerCluster();

    /**
     * Sets the amount of glowstone to attempt to spawn per cluster, must be
     * greater than zero.
     * 
     * @param attempts The new amount to spawn
     */
    void setAttemptsPerCluster(int attempts);

    /**
     * A builder for constructing {@link Glowstone} populators.
     */
    interface Builder {

        /**
         * Sets the number of clusters to attempt to spawn per chunk, must be
         * greater than zero.
         * 
         * @param count The new amount to spawn
         * @return This builder, for chaining
         */
        Builder perChunk(int count);

        /**
         * Sets the amount of glowstone to attempt to spawn per cluster, must be
         * greater than zero.
         * 
         * @param attempts The new amount to spawn
         * @return This builder, for chaining
         */
        Builder blocksPerCluster(int attempts);

        /**
         * Resets this builder to the default values.
         * 
         * @return This builder, for chaining
         */
        Builder reset();

        /**
         * Builds a new instance of a {@link Glowstone} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *             which do not have default values
         */
        Glowstone build() throws IllegalStateException;

    }

}
