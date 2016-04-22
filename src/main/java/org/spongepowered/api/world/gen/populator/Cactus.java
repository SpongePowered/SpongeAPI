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
 * Represents a populator which will randomly spawn a number of cacti within the
 * chunk. The cacti will only be spawned at valid locations, that is on top of a
 * sand block with no immediately surrounding blocks.
 */
public interface Cactus extends Populator {

    /**
     * Creates a new {@link Builder} to build a {@link Cactus} populator.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the number of cacti to spawn per chunk.
     * 
     * @return The number of cacti to spawn
     */
    VariableAmount getCactiPerChunk();

    /**
     * Sets the number of cacti to spawn per chunk, cannot be negative.
     * 
     * <p><strong>Note:</strong> This number is not a definite number and the
     * final count of cacti which are successfully spawned by the populator will
     * almost always be lower.</p>
     * 
     * @param count The new number of cacti to spawn
     */
    void setCactiPerChunk(VariableAmount count);

    /**
     * Sets the number of cacti to spawn per chunk, cannot be negative.
     * 
     * <p><strong>Note:</strong> This number is not a definite number and the
     * final count of cacti which are successfully spawned by the populator will
     * almost always be lower.</p>
     * 
     * @param count The new number of cacti to spawn
     */
    default void setCactiPerChunk(int count) {
        setCactiPerChunk(VariableAmount.fixed(count));
    }

    /**
     * Gets the height of the cacti.
     * 
     * @return The height
     */
    VariableAmount getHeight();

    /**
     * Sets the height of the cacti.
     * 
     * @param height The new height
     */
    void setHeight(VariableAmount height);

    /**
     * Sets the height of the cacti.
     * 
     * @param count The new height
     */
    default void setHeight(int count) {
        setHeight(VariableAmount.fixed(count));
    }

    /**
     * A builder for constructing {@link Cactus} populators.
     */
    interface Builder extends ResettableBuilder<Cactus, Builder> {

        /**
         * Sets the number of cacti to spawn per chunk, cannot be negative.
         * 
         * <p><strong>Note:</strong> This number is not a definite number and
         * the final count of cacti which are successfully spawned by the
         * populator will almost always be lower.</p>
         * 
         * @param count The new number of cacti to spawn
         * @return This builder, for chaining
         */
        Builder cactiPerChunk(VariableAmount count);

        /**
         * Sets the number of cacti to spawn per chunk, cannot be negative.
         * 
         * <p><strong>Note:</strong> This number is not a definite number and
         * the final count of cacti which are successfully spawned by the
         * populator will almost always be lower.</p>
         * 
         * @param count The new number of cacti to spawn
         * @return This builder, for chaining
         */
        default Builder cactiPerChunk(int count) {
            return cactiPerChunk(VariableAmount.fixed(count));
        }

        /**
         * Sets the height of the cacti.
         * 
         * @param height The new height
         * @return This builder, for chaining
         */
        Builder height(VariableAmount height);

        /**
         * Sets the height of the cacti.
         * 
         * @param height The new height
         * @return This builder, for chaining
         */
        default Builder height(int height) {
            return height(VariableAmount.fixed(height));
        }

        /**
         * Builds a new instance of a {@link Cactus} populator with the settings
         * set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *         which do not have default values
         */
        Cactus build() throws IllegalStateException;

    }

}
