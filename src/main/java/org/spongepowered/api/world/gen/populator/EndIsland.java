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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.weighted.VariableAmount;
import org.spongepowered.api.world.gen.Populator;

/**
 * Represents a populator which will generate small 'islands' which float in the
 * end.
 * 
 * <p> The island is formed as a cone with each layer being a circle of blocks
 * with a gradually decreasing radius. </p>
 */
public interface EndIsland extends Populator {

    /**
     * Creates a new {@link Builder} to build a {@link EndIsland} populator.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the initial starting radius range of the island.
     * 
     * @return The initial starting radius
     */
    VariableAmount getStartingRadius();

    /**
     * Sets the initial starting radius range of the island.
     * 
     * @param radius The new initial starting radius range
     */
    void setStartingRadius(VariableAmount radius);

    /**
     * Sets the initial starting radius of the island.
     * 
     * @param radius The new initial starting radius
     */
    default void setStartingRadius(double radius) {
        setStartingRadius(VariableAmount.fixed(radius));
    }

    /**
     * Gets the amount that the radius decreases for every downward step.
     * 
     * @return The radius decrement
     */
    VariableAmount getRadiusDecrement();

    /**
     * Sets the amount that the radius decreases for every downward step.
     * 
     * @param decrement The new radius decrement range
     */
    void setRadiusDecrement(VariableAmount decrement);

    /**
     * Sets the amount that the radius decreases for every downward step.
     * 
     * @param decrement The new radius decrement
     */
    default void setRadiusDecrement(double decrement) {
        setRadiusDecrement(VariableAmount.fixed(decrement));
    }

    /**
     * Gets the block state that the island will be formed from.
     * 
     * @return The island block state
     */
    BlockState getIslandBlock();

    /**
     * Sets the block state that the island will be formed from.
     * 
     * @param state The new island block state
     */
    void setIslandBlock(BlockState state);

    /**
     * Gets the radius around the center (0, 0) of the world that this populator
     * will not apply to.
     * 
     * <p>This is used to prevent the islands from generating around the ender
     * dragon fight area.</p>
     * 
     * @return The radius
     */
    int getExclusionRadius();

    /**
     * Sets the radius around the center (0, 0) of the world that this populator
     * will not apply to.
     * 
     * <p>This must be a positive value or zero.</p>
     * 
     * @param radius The exclusion radius
     */
    void setExclusionRadius(int radius);

    /**
     * A builder for constructing {@link EndIsland} populators.
     */
    interface Builder extends ResettableBuilder<EndIsland, Builder> {

        /**
         * Sets the initial starting radius range of the island.
         * 
         * @param radius The new initial starting radius
         * @return This builder, for chaining
         */
        Builder startingRadius(VariableAmount radius);

        /**
         * Sets the initial starting radius of the island.
         * 
         * @param radius The new initial starting radius range
         * @return This builder, for chaining
         */
        default Builder startingRadius(double radius) {
            startingRadius(VariableAmount.fixed(radius));
            return this;
        }

        /**
         * Sets the amount that the radius decreases for every downward step.
         * 
         * @param radius The new radius decrement range
         * @return This builder, for chaining
         */
        Builder radiusDecrement(VariableAmount radius);

        /**
         * Sets the amount that the radius decreases for every downward step.
         * 
         * @param radius The new radius decrement
         * @return This builder, for chaining
         */
        default Builder radiusDecrement(double radius) {
            radiusDecrement(VariableAmount.fixed(radius));
            return this;
        }

        /**
         * Sets the block state that the island will be formed from.
         * 
         * @param state The new island block state
         * @return This builder, for chaining
         */
        Builder islandBlock(BlockState state);

        /**
         * Sets the radius around the center (0, 0) of the world that this
         * populator will not apply to.
         * 
         * <p>This must be a positive value or zero.</p>
         * 
         * @param radius The exclusion radius
         * @return This builder, for chaining
         */
        Builder exclusionRadius(int radius);

        /**
         * Builds a new instance of a {@link EndIsland} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *         which do not have default values
         */
        EndIsland build() throws IllegalStateException;

    }

}
