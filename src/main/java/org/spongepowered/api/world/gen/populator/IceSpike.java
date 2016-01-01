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
 * Represents a populator which generates large spikes of Ice.
 */
public interface IceSpike extends Populator {

    /**
     * Creates a new {@link Builder} to build a {@link IceSpike} populator.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the number of spikes to generate per chunk.
     * 
     * @return The number of spikes
     */
    VariableAmount getSpikesPerChunk();

    /**
     * Sets the number of spikes to attempt to generate per chunk.
     * 
     * @param count The new number of spikes
     */
    void setSpikesPerChunk(VariableAmount count);

    /**
     * Sets the number of spikes to attempt to generate per chunk.
     * 
     * @param count The new number of spikes
     */
    default void setSpikesPerChunk(int count) {
        setSpikesPerChunk(VariableAmount.fixed(count));
    }

    /**
     * Gets the base height of the spike.
     * 
     * @return The base height
     */
    VariableAmount getHeight();

    /**
     * Sets the base height of the spike.
     * 
     * @param height The new base height
     */
    void setHeight(VariableAmount height);

    /**
     * Sets the base height of the spike.
     * 
     * @param height The new base height
     */
    default void setHeight(int height) {
        setHeight(VariableAmount.fixed(height));
    }

    /**
     * Gets the probability of the spike much larger than normal.
     * 
     * @return The spawn probability
     */
    double getExtremeSpikeProbability();

    /**
     * Gets the probability of the spike much larger than normal.
     * 
     * @param p The new spawn probability
     */
    void setExtremeSpikeProbability(double p);

    /**
     * Gets the height increase of the extreme spikes.
     * 
     * @return The height increase
     */
    VariableAmount getExtremeSpikeIncrease();

    /**
     * Sets the height increase of the extreme spikes.
     * 
     * @param increase The new height increase
     */
    void setExtremeSpikeIncrease(VariableAmount increase);

    /**
     * Sets the height increase of the extreme spikes.
     * 
     * @param increase The new height increase
     */
    default void setExtremeSpikeIncrease(int increase) {
        setExtremeSpikeIncrease(VariableAmount.fixed(increase));
    }

    /**
     * A builder for constructing {@link IceSpike} populators.
     */
    interface Builder extends ResettableBuilder<IceSpike, Builder> {

        /**
         * Sets the number of spikes to generate per chunk.
         * 
         * @param count The new number of spikes
         * @return This builder, for chaining
         */
        Builder spikesPerChunk(VariableAmount count);

        /**
         * Sets the number of spikes to generate per chunk.
         * 
         * @param count The new number of spikes
         * @return This builder, for chaining
         */
        default Builder spikesPerChunk(int count) {
            return spikesPerChunk(VariableAmount.fixed(count));
        }

        /**
         * Sets the base height of the spike.
         * 
         * @param height The new base height
         * @return This builder, for chaining
         */
        Builder height(VariableAmount height);

        /**
         * Sets the base height of the spike.
         * 
         * @param height The new base height
         * @return This builder, for chaining
         */
        default Builder height(int height) {
            return height(VariableAmount.fixed(height));
        }

        /**
         * Gets the probability of the spike much larger than normal.
         * 
         * @param p The new spawn probability
         * @return This builder, for chaining
         */
        Builder extremeSpikeProbability(double p);

        /**
         * Sets the base height increase of the extreme spikes.
         * 
         * @param increase The new base height increase
         * @return This builder, for chaining
         */
        Builder extremeSpikeIncrease(VariableAmount increase);

        /**
         * Sets the base height increase of the extreme spikes.
         * 
         * @param increase The new base height increase
         * @return This builder, for chaining
         */
        default Builder extremeSpikeIncrease(int increase) {
            return extremeSpikeIncrease(VariableAmount.fixed(increase));
        }

        /**
         * Builds a new instance of a {@link IceSpike} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *         which do not have default values
         */
        IceSpike build() throws IllegalStateException;

    }

}
