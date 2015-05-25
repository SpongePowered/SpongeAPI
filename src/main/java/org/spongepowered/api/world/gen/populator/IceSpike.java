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

import org.spongepowered.api.world.gen.Populator;

/**
 * Represents a populator which generates large spikes of Ice.
 */
public interface IceSpike extends Populator {

    /**
     * Gets the base height of the spike.
     * 
     * @return The base height
     */
    int getBaseHeight();

    /**
     * Sets the base height of the spike.
     * 
     * @param height The new base height
     */
    void setBaseHeight(int height);

    /**
     * Gets the height variance of the spike. The final height will be the base
     * height plus a random amount between zero (inclusive) and the variance
     * (exclusive).
     * 
     * @return The height variance
     */
    int getHeightVariance();

    /**
     * Sets the height variance of the spike. The final height will be the base
     * height plus a random amount between zero (inclusive) and the variance
     * (exclusive).
     * 
     * @param variance The new height variance
     */
    void setHeightVariance(int variance);

    /**
     * Gets the chance of the spike much larger than normal. The default value
     * is 60 (therefore equating to a 1 in 60 chance).
     * 
     * @return The spawn chance
     */
    int getExtremeSpikeChance();

    /**
     * Gets the chance of the spike much larger than normal. The default value
     * is 60 (therefore equating to a 1 in 60 chance).
     * 
     * @param chance The new spawn chance
     */
    void setExtremeSpikeChance(int chance);

    /**
     * Gets the base height increase of the extreme spikes.
     * 
     * @return The base height increase
     */
    int getExtremeSpikeBaseIncrease();

    /**
     * Sets the base height increase of the extreme spikes.
     * 
     * @param increase The new base height increase
     */
    void setExtremeSpikeBaseIncrease(int increase);

    /**
     * Gets the variance in the height increase of extreme spikes. The final
     * increase will be the base increase plus a random amount between zero
     * (inclusive) and the variance (exclusive).
     * 
     * @return The increase variance
     */
    int getExtremeSpikeIncreaseVariance();

    /**
     * Sets the variance in the height increase of extreme spikes. The final
     * increase will be the base increase plus a random amount between zero
     * (inclusive) and the variance (exclusive).
     * 
     * @param variance The new increase variance
     */
    void setExtremeSpikeIncreaseVariance(int variance);

    /**
     * A builder for constructing {@link IceSpike} populators.
     */
    interface Builder {

        /**
         * Sets the base height of the spike.
         * 
         * @param height The new base height
         * @return This builder, for chaining
         */
        Builder height(int height);

        /**
         * Sets the height variance of the spike. The final height will be the
         * base height plus a random amount between zero (inclusive) and the
         * variance (exclusive).
         * 
         * @param variance The new height variance
         * @return This builder, for chaining
         */
        Builder heightVariance(int variance);

        /**
         * Gets the chance of the spike much larger than normal. The default
         * value is 60 (therefore equating to a 1 in 60 chance).
         * 
         * @param chance The new spawn chance
         * @return This builder, for chaining
         */
        Builder extremeSpikeChance(int chance);

        /**
         * Sets the base height increase of the extreme spikes.
         * 
         * @param increase The new base height increase
         * @return This builder, for chaining
         */
        Builder extremeSpikeBaseIncrease(int increase);

        /**
         * Sets the variance in the height increase of extreme spikes. The final
         * increase will be the base increase plus a random amount between zero
         * (inclusive) and the variance (exclusive).
         * 
         * @param variance The new increase variance
         * @return This builder, for chaining
         */
        Builder extremeSpikeIncreaseVariance(int variance);

        /**
         * Resets this builder to the default values.
         * 
         * @return This builder, for chaining
         */
        Builder reset();

        /**
         * Builds a new instance of a {@link IceSpike} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *             which do not have default values
         */
        IceSpike build() throws IllegalStateException;

    }

}
