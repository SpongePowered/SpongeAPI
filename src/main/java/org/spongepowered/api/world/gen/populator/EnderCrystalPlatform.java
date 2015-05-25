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

import org.spongepowered.api.entity.EnderCrystal;
import org.spongepowered.api.world.gen.Populator;

/**
 * Represents a populator which randomly generates large obsidian pillars with
 * {@link EnderCrystal}s at the peak such as are found in the End.
 */
public interface EnderCrystalPlatform extends Populator {

    /**
     * Gets the chance of a pillar spawning in a chunk. The default value is 5
     * (therefore equating to a 20% chance or 1 in 5).
     * 
     * @return The spawn chance
     */
    int getSpawnChance();

    /**
     * Sets the chance of a pillar spawning in a chunk. The default value is 5
     * (therefore equating to a 20% chance or 1 in 5).
     * 
     * @param chance The spawn chance
     */
    void setSpawnChance(int chance);

    /**
     * Gets the base height of the pillar.
     * 
     * @return The base height
     */
    int getBaseHeight();

    /**
     * Sets the base height of the pillar.
     * 
     * @param height The new base height
     */
    void setBaseHeight(int height);

    /**
     * Gets the height variance of the pillar. The final height will be the base
     * height plus a random amount between zero (inclusive) and the variance
     * (exclusive).
     * 
     * @return The height variance
     */
    int getHeightVariance();

    /**
     * Sets the height variance of the pillar. The final height will be the base
     * height plus a random amount between zero (inclusive) and the variance
     * (exclusive).
     * 
     * @param variance The new height variance
     */
    void setHeightVariance(int variance);

    /**
     * Gets the base radius of the pillar.
     * 
     * @return The base radius
     */
    int getBaseRadius();

    /**
     * Sets the base radius of the pillar.
     * 
     * @param radius The new base radius
     */
    void setBaseRadius(int radius);

    /**
     * Gets the radius variance of the pillar. The final radius will be the base
     * radius plus a random amount between zero (inclusive) and the variance
     * (exclusive).
     * 
     * @return The radius variance
     */
    int getRadiusVariance();

    /**
     * Sets the radius variance of the pillar. The final radius will be the base
     * radius plus a random amount between zero (inclusive) and the variance
     * (exclusive).
     * 
     * @param variance The new radius variance
     */
    void setRadiusVariance(int variance);

    /**
     * A builder for constructing {@link EnderCrystalPlatform} populators.
     */
    interface Builder {

        /**
         * Sets the chance of a pillar spawning in a chunk. The default value is
         * 5 (therefore equating to a 20% chance or 1 in 5).
         * 
         * @param chance The spawn chance
         * @return This builder, for chaining
         */
        Builder chance(int chance);

        /**
         * Sets the base height of the pillar.
         * 
         * @param height The new base height
         * @return This builder, for chaining
         */
        Builder height(int height);

        /**
         * Sets the height variance of the pillar. The final height will be the
         * base height plus a random amount between zero (inclusive) and the
         * variance (exclusive).
         * 
         * @param variance The new height variance
         * @return This builder, for chaining
         */
        Builder heightVariance(int variance);

        /**
         * Sets the base radius of the pillar.
         * 
         * @param radius The new base radius
         * @return This builder, for chaining
         */
        Builder radius(int radius);

        /**
         * Sets the radius variance of the pillar. The final radius will be the
         * base radius plus a random amount between zero (inclusive) and the
         * variance (exclusive).
         * 
         * @param variance The new radius variance
         * @return This builder, for chaining
         */
        Builder radiusVariance(int variance);

        /**
         * Resets this builder to the default values.
         * 
         * @return This builder, for chaining
         */
        Builder reset();

        /**
         * Builds a new instance of a {@link EnderCrystalPlatform} populator
         * with the settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *             which do not have default values
         */
        EnderCrystalPlatform build() throws IllegalStateException;

    }

}
