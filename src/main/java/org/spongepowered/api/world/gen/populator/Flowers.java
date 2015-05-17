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

import com.google.common.base.Optional;
import org.spongepowered.api.data.type.PlantType;
import org.spongepowered.api.world.gen.Populator;

/**
 * Represents a populator which uses perlin noise to scatter flowers randomly
 * around a chunk.
 */
public interface Flowers extends Populator {

    /**
     * Gets the number of flowers to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @return The number to spawn
     */
    int getFlowersPerChunk();

    /**
     * Sets the number of flowers to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @param count The new amount to spawn
     */
    void setFlowersPerChunk(int count);

    /**
     * Gets whether this populator will ignore the set plant type and default to
     * the biome's flower type.
     * 
     * @return Is biome dependent
     */
    boolean isBiomeDependent();

    /**
     * Sets whether this populator will ignore the set tile and default to the
     * biome's flower type.
     * 
     * @param state The new biome dependency state
     */
    void setBiomeDependent(boolean state);

    /**
     * Gets the plant type for this populator to spawn. If the populator is
     * flagged as being biome dependent ( {@link #isBiomeDependent()} ) then
     * this will return absent.
     * 
     * @return The plant type, or absent if this is biome dependent
     */
    Optional<PlantType> getFlowerType();

    /**
     * Sets the plant type for this populator to spawn. This will automatically
     * set the {@link #isBiomeDependent()} flag to false.
     * 
     * @param type The plant type to spawn
     */
    void serFlowerType(PlantType type);

    /**
     * A builder for constructing {@link Flowers} populators.
     */
    interface Builder {

        /**
         * Sets the number of flowers to attempt to spawn per chunk, must be
         * greater than zero.
         * 
         * @param count The new amount to spawn
         * @return This builder, for chaining
         */
        Builder perChunk(int count);

        /**
         * Sets whether this populator will ignore the set tile and default to
         * the biome's flower type.
         * 
         * @param state The new biome dependent state
         * @return This builder, for chaining
         */
        Builder biomeDependant(boolean state);

        /**
         * Sets the plant type for this populator to spawn. This will
         * automatically set the {@link #isBiomeDependent()} flag to false.
         * 
         * @param type The plant type to spawn
         * @return This builder, for chaining
         */
        Builder type(PlantType type);

        /**
         * Resets this builder to the default values.
         * 
         * @return This builder, for chaining
         */
        Builder reset();

        /**
         * Builds a new instance of a {@link Flowers} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *             which do not have default values
         */
        Flowers build() throws IllegalStateException;

    }

}
