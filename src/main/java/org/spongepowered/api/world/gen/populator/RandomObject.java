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
import org.spongepowered.api.world.gen.PopulatorObject;

public interface RandomObject extends Populator {

    /**
     * Creates a new {@link Builder} to build a {@link RandomObject} populator.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the number of fires to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @return The number to spawn
     */
    VariableAmount getAttemptsPerChunk();

    /**
     * Sets the number of fires to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @param count The new number to spawn
     */
    void setAttemptsPerChunk(VariableAmount count);

    /**
     * Sets the number of fires to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @param count The new number to spawn
     */
    default void setAttemptsPerChunk(int count) {
        setAttemptsPerChunk(VariableAmount.fixed(count));
    }

    /**
     * Gets the height range that the object will be placed within.
     * 
     * @return The height range
     */
    VariableAmount getHeightRange();

    /**
     * Sets the height range that the object will be placed within.
     * 
     * @param height The new height range
     */
    void setHeightRange(VariableAmount height);

    /**
     * Gets the {@link PopulatorObject} that this populator will attempt to
     * place.
     * 
     * @return The populator object
     */
    PopulatorObject getObject();

    /**
     * Sets the {@link PopulatorObject} for this populator to attempt to place.
     * 
     * @param obj The new populator object
     */
    void setObject(PopulatorObject obj);

    /**
     * Gets the chance of spawning the object for each attempt. This chance is
     * applied before the checks for if the placement is valid. This value must
     * be between zero and one (inclusive) with a chance of zero representing no
     * chance of the object being placed, and a chance of 1 representing a 100%
     * chance of the object being placed.
     * 
     * @return The spawn chance
     */
    double getSpawnChance();

    /**
     * Sets the chance of spawning the object for each attempt. This chance is
     * applied before the checks for if the placement is valid. This value must
     * be between zero and one (inclusive) with a chance of zero representing no
     * chance of the object being placed, and a chance of 1 representing a 100%
     * chance of the object being placed.
     * 
     * @param chance The new spawn chance
     */
    void setSpawnChance(double chance);

    /**
     * A builder for constructing {@link RandomBlock} populators.
     */
    interface Builder extends ResettableBuilder<RandomObject, Builder> {

        /**
         * Sets the number of fires to attempt to spawn per chunk, must be
         * greater than zero.
         * 
         * @param count The new number to spawn
         * @return This builder, for chaining
         */
        Builder perChunk(VariableAmount count);

        /**
         * Sets the number of fires to attempt to spawn per chunk, must be
         * greater than zero.
         * 
         * @param count The new number to spawn
         * @return This builder, for chaining
         */
        default Builder perChunk(int count) {
            return perChunk(VariableAmount.fixed(count));
        }

        /**
         * Sets the height range that the object will be placed within.
         * 
         * @param height The new height range
         * @return This builder, for chaining
         */
        Builder height(VariableAmount height);

        /**
         * Sets the {@link PopulatorObject} for the populator to attempt to
         * place.
         * 
         * @param obj The new populator object
         * @return This builder, for chaining
         */
        Builder object(PopulatorObject obj);

        /**
         * Sets the chance of spawning the object for each attempt. This chance
         * is applied before the checks for if the placement is valid. This
         * value must be between zero and one (inclusive) with a chance of zero
         * representing no chance of the object being placed, and a chance of 1
         * representing a 100% chance of the object being placed.
         * 
         * @param chance The new spawn chance
         * @return This builder, for chaining
         */
        Builder spawnChance(double chance);

        /**
         * Builds a new instance of a {@link RandomBlock} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *         which do not have default values
         */
        RandomObject build() throws IllegalStateException;

    }

}
