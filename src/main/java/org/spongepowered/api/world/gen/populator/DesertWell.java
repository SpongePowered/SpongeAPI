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
import org.spongepowered.api.world.gen.Populator;
import org.spongepowered.api.world.gen.PopulatorObject;

/**
 * Represents a populator which spawns desert wells. The wells will be created
 * according to the spawn probability of {@link #getSpawnProbability} and if the
 * spawn conditions are met (that the block its spawning on is sand).
 */
public interface DesertWell extends Populator {

    /**
     * Creates a new {@link Builder} to build a {@link DesertWell} populator.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the probability of a desert well spawning.
     * 
     * @return The spawn chance of a well
     */
    double getSpawnProbability();

    /**
     * Sets the probability of a desert well spawning.
     * 
     * @param p The new spawn probability
     */
    void setSpawnProbability(double p);

    /**
     * Gets the {@link PopulatorObject} representing the well.
     * 
     * @return The populator object
     */
    PopulatorObject getWellObject();

    /**
     * Sets the {@link PopulatorObject} representing the well.
     * 
     * @param obj The new populator object
     */
    void setWellObject(PopulatorObject obj);

    /**
     * A builder for constructing {@link DesertWell} populators.
     */
    interface Builder extends ResettableBuilder<DesertWell, Builder> {

        /**
         * Sets the probability of a desert well spawning.
         * 
         * @param p The new spawn probability
         * @return This builder, for chaining
         */
        Builder probability(double p);

        /**
         * Sets the {@link PopulatorObject} representing the well.
         * 
         * @param obj The new populator object
         * @return This builder, for chaining
         */
        Builder wellObject(PopulatorObject obj);

        /**
         * Builds a new instance of a {@link DesertWell} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *         which do not have default values
         */
        DesertWell build() throws IllegalStateException;

    }

}
