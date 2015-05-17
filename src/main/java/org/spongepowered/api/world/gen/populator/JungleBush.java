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
 * Represents a populator which creates the ground cover of bushes as found in
 * jungle biomes.
 */
public interface JungleBush extends Populator {

    /**
     * Gets the {@link BlockState} to spawn the trunk of the brush with.
     * 
     * @return The trunk block state
     */
    BlockState getTrunkMaterial();

    /**
     * Sets the {@link BlockState} to spawn the trunk of the brush with.
     * 
     * @param material The new trunk block state
     */
    void setTrunkMaterial(BlockState material);

    /**
     * Gets the {@link BlockState} to spawn the leaves of the brush with.
     * 
     * @return The leaves block state
     */
    BlockState getLeavesMaterial();

    /**
     * Sets the {@link BlockState} to spawn the leaves of the brush with.
     * 
     * @param material The new leaves block state
     */
    void setLeavesMaterial(BlockState material);

    /**
     * A builder for constructing {@link JungleBush} populators.
     */
    interface Builder {

        /**
         * Sets the {@link BlockState} to spawn the trunk of the brush with.
         * 
         * @param material The new trunk block state
         * @return This builder, for chaining
         */
        Builder trunkMaterial(BlockState material);

        /**
         * Sets the {@link BlockState} to spawn the leaves of the brush with.
         * 
         * @param material The new leaves block state
         * @return This builder, for chaining
         */
        Builder leavesMaterial(BlockState material);

        /**
         * Resets this builder to the default values.
         * 
         * @return This builder, for chaining
         */
        Builder reset();

        /**
         * Builds a new instance of a {@link JungleBush} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *             which do not have default values
         */
        JungleBush build() throws IllegalStateException;

    }

}
