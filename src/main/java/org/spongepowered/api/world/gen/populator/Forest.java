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
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.world.gen.Populator;
import org.spongepowered.api.world.gen.type.BiomeTreeType;

/**
 * A populator which will place several trees into a chunk in order to create a
 * forest.
 */
public interface Forest extends Populator {

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
     * Gets whether this populator will ignore the set tree type and default to
     * the biome's tree type.
     * 
     * @return Is biome dependent
     */
    boolean isBiomeDependent();

    /**
     * Gets whether this populator will ignore the set tree type and default to
     * the biome's tree type.
     * 
     * @param state The new biome dependency state
     */
    void setBiomeDependent(boolean state);

    /**
     * Gets the {@link BiomeTreeType} to spawn. If this populator is set to be
     * biome dependent ( {@link #isBiomeDependent()} ) then this will return
     * absent.
     * 
     * @return The type to spawn, or absent if biome dependent
     */
    Optional<BiomeTreeType> getType();

    /**
     * Sets the {@link BiomeTreeType} to spawn, this automatically sets the
     * biome dependency flag to false.
     * 
     * @param type The new type to spawn
     */
    void setType(BiomeTreeType type);

    /**
     * Gets the {@link BlockState} to spawn the trunk of the tree with. If this
     * populator is set to be biome dependent ( {@link #isBiomeDependent()} )
     * then this will return absent.
     * 
     * @return The trunk type, or absent if biome dependent
     */
    Optional<BlockState> getTrunkMaterial();

    /**
     * Sets the {@link BlockState} to spawn the trunk of the tree with, this
     * automatically sets the biome dependency flag to false.
     * 
     * @param material The new trunk material
     */
    void setTrunkMaterial(BlockState material);

    /**
     * Gets the {@link BlockState} to spawn the leaves of the tree with. If this
     * populator is set to be biome dependent ( {@link #isBiomeDependent()} )
     * then this will return absent.
     * 
     * @return The leaves type, or absent if biome dependent
     */
    Optional<BlockState> getLeavesMaterial();

    /**
     * Sets the {@link BlockState} to spawn the leaves of the tree with, this
     * automatically sets the biome dependency flag to false.
     * 
     * @param material The new leaves material
     */
    void setLeavesMaterial(BlockState material);

    /**
     * A builder for constructing {@link Forest} populators.
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
         * Gets whether this populator will ignore the set tree type and default
         * to the biome's tree type.
         * 
         * @param state The new biome dependency state
         * @return This builder, for chaining
         */
        Builder biomeDependant(boolean state);

        /**
         * Sets the {@link BiomeTreeType} to spawn, this automatically sets the
         * biome dependency flag to false.
         * 
         * @param type The new type to spawn
         * @return This builder, for chaining
         */
        Builder type(BiomeTreeType type);

        /**
         * Sets the {@link BlockState} to spawn the trunk of the tree with, this
         * automatically sets the biome dependency flag to false.
         * 
         * @param material The new trunk material
         * @return This builder, for chaining
         */
        Builder trunk(BlockState material);

        /**
         * Sets the {@link BlockState} to spawn the leaves of the tree with,
         * this automatically sets the biome dependency flag to false.
         * 
         * @param material The new leaves material
         * @return This builder, for chaining
         */
        Builder leaves(BlockState material);

        /**
         * Resets this builder to the default values.
         * 
         * @return This builder, for chaining
         */
        Builder reset();

        /**
         * Builds a new instance of a {@link Forest} populator with the settings
         * set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *             which do not have default values
         */
        Forest build() throws IllegalStateException;

    }

}
