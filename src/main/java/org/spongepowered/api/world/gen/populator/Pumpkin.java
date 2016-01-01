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
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.weighted.VariableAmount;
import org.spongepowered.api.world.gen.Populator;

/**
 * Represents a populator which spawns patches of pumpkins randomly within
 * chunks.
 */
public interface Pumpkin extends Populator {

    /**
     * Creates a new {@link Builder} to build a {@link Pumpkin} populator.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the number of pumpkins to attempt to spawn per patch, must be
     * greater than zero.
     * 
     * @return The number to spawn
     */
    VariableAmount getPumpkinsPerChunk();

    /**
     * Sets the number of pumpkins to attempt to spawn per patch, must be
     * greater than zero.
     * 
     * @param count The new number to spawn
     */
    void setPumpkinsPerChunk(VariableAmount count);

    /**
     * Sets the number of pumpkins to attempt to spawn per patch, must be
     * greater than zero.
     * 
     * @param count The new number to spawn
     */
    default void setPumpkinsPerChunk(int count) {
        setPumpkinsPerChunk(VariableAmount.fixed(count));
    }

    /**
     * Gets the probability of a pumpkin patch spawning within a chunk.
     * 
     * @return The probability of a patch spawning
     */
    double getPumpkinChance();

    /**
     * Sets the probability of a pumpkin patch spawning within a chunk.
     * 
     * @param p The new probability of a patch spawning
     */
    void setPumpkinChance(double p);

    /**
     * A builder for constructing {@link Pumpkin} populators.
     */
    interface Builder extends ResettableBuilder<Pumpkin, Builder> {

        /**
         * Sets the number of pumpkins to attempt to spawn per patch, must be
         * greater than zero.
         * 
         * @param count The new number to spawn
         * @return This builder, for chaining
         */
        Builder perChunk(VariableAmount count);

        /**
         * Sets the number of pumpkins to attempt to spawn per patch, must be
         * greater than zero.
         * 
         * @param count The new number to spawn
         * @return This builder, for chaining
         */
        default Builder perChunk(int count) {
            return perChunk(VariableAmount.fixed(count));
        }

        /**
         * Sets the probability of a pumpkin patch spawning within a chunk.
         * 
         * @param p The new probability of a patch spawning
         * @return This builder, for chaining
         */
        Builder chance(double p);

        /**
         * Builds a new instance of a {@link Pumpkin} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *         which do not have default values
         */
        Pumpkin build() throws IllegalStateException;

    }

}
