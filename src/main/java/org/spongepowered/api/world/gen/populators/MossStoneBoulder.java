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
package org.spongepowered.api.world.gen.populators;

import com.google.common.base.Optional;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.world.biome.BiomeTypes;
import org.spongepowered.api.world.gen.Populator;

import java.util.HashMap;

public interface MossStoneBoulder extends Populator {

    /**
     * Get the possible radius for the generator.
     *
     * @return The possible radius
     */
    Optional<HashMap<Integer, Integer>> getRadius();

    /**
     * Get the material the boulder is constructed of. If
     * the {@link BlockState} is default, will return
     * {@link Optional#absent()}.
     *
     * @return The material
     */
    Optional<BlockState> getMaterial();

    /**
     * Set the material the boulder is constructed of.
     *
     * @param material The material used to construct the object
     */
    void setMaterial(BlockState material);

    /**
     * Gets whether this populator will ignore the biome
     * ({@link BiomeTypes#MEGA_SPRUCE_TAIGA}) needed to generate the boulder.
     *
     * @return Is biome dependent
     */
    boolean isBiomeDependent();

    /**
     * Gets whether this populator will ignore biome required
     * to generate this structure.
     *
     * @param state The new biome dependency state
     */
    void setBiomeDependent(boolean state);

    /**
     * Gets the number of boulders which will be attempted to be spawned.
     *
     * <p><strong>Note:</strong> This number is not a definite number and the
     * final count of mushrooms which are successfully spawned by the populator
     * will almost always be lower.</p>
     *
     * @return The number of boulders attempted to be spawned per chunk
     */
    int getBouldersPerChunk();

    /**
     * Sets the number of boulders which will be attempted to be spawned.
     *
     * <p><strong>Note:</strong> This number is not a definite number and the
     * final count of boulders which are successfully spawned by the populator
     * will almost always be lower.</p>
     *
     * @param count The new amount to attempt to create
     */
    void setBouldersPerChunk(int count);

    /**
     * A builder for creating moss stone boulder populators.
     */
    interface Builder {

        /**
         * Set whether this populator will ignore the biome needed to generate
         * this structure.
         *
         * @param state The new biome dependency state
         * @return This builder, for chaining
         */
        Builder biomeDependant(boolean state);

        /**
         * Set the material used to create the boulder.
         *
         * @param material The material
         * @return This builder, for chaining
         */
        Builder material(BlockState material);

        /**
         * Set the radius of the boulders.
         *
         * <p>The radius cannot be negative and large numbers may cause lag.</p>
         *
         * <p>The generator will take the maximum and minimum amounts and
         * randomly generate a boulder between the two values.</p>
         *
         * @param max The maximum size of the boulder
         * @param min The minimum size of the boulder
         * @return This builder, for chaining
         */
        Builder radius(int max, int min);

        /**
         * Set the radius of the boulders.
         *
         * <p>The radius cannot be negative and large numbers may cause lag.</p>
         *
         * @param radius The absolute radius of the boulder
         * @return This builder, for chaining
         */
        Builder radius(int radius);

        /**
         * Set the radius of the boulders.
         *
         * <p>The radius cannot be negative and large numbers may cause lag.</p>
         *
         * <p>The generator will take all the values in the {@link HashMap}
         * and add them up. Then it will take the keys (radius) and
         * and generate a random number through the percentages
         * specified by the values.
         *
         * <code>
         *     HashMap map = new HashMap();
         *     map.put(1, 3);
         *     map.put(5, 10);
         *     map.put(6, 6);
         * </code></p>
         *
         * <p>The generator will add up all the values, in this case, 18.
         * Therefore it is 1/18 likely to generate a 1 radius boulder
         * while it 1/3 (6/18) likely to generate a 6 radius boulder.</p>
         *
         * @param chance The chance a certain radius will be selected. The
         *               first value stands for the radius while the second
         *               value stands for the chance.
         * @return This builder, for chaining
         */
        Builder radius(HashMap<Integer, Integer> chance);

        /**
         * Sets the number of boulders which will be attempted to be spawned.
         *
         * <p><strong>Note:</strong> This number is not a definite number and
         * the final count of boulder which are successfully spawned by the
         * populator will almost always be lower.</p>
         *
         * @param count The new amount to attempt to create
         * @return This builder, for chaining
         */
        Builder bouldersPerChunk(int count);

        /**
         * Resets this builder to the default values.
         *
         * @return This builder, for chaining
         */
        Builder reset();

        /**
         * Builds a new instance of a boulder populator with the
         * settings set within the builder.
         *
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *             which do not have default values
         */
        Builder build() throws IllegalStateException;
    }
}
