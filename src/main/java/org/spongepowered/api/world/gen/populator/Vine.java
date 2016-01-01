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
 * Represents a populator which places large amounts of vines on surfaces within
 * the chunk.
 */
public interface Vine extends Populator {

    /**
     * Creates a new {@link Builder} to build a {@link Vine} populator.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the number of vines to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @return The number to spawn
     */
    VariableAmount getVinesPerChunk();

    /**
     * Sets the number of vines to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @param count The new amount to spawn
     */
    void setVinesPerChunk(VariableAmount count);

    /**
     * Sets the number of vines to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @param count The new amount to spawn
     */
    default void setVinesPerChunk(int count) {
        setVinesPerChunk(VariableAmount.fixed(count));
    }

    /**
     * A builder for constructing {@link Vine} populators.
     */
    interface Builder extends ResettableBuilder<Vine, Builder> {

        /**
         * Sets the number of vines to attempt to spawn per chunk.
         * 
         * @param count The new amount to spawn
         * @return This builder, for chaining
         */
        Builder perChunk(VariableAmount count);

        /**
         * Sets the number of vines to attempt to spawn per chunk.
         * 
         * @param count The new amount to spawn
         * @return This builder, for chaining
         */
        default Builder perChunk(int count) {
            return perChunk(VariableAmount.fixed(count));
        }

        /**
         * Builds a new instance of a {@link Vine} populator with the settings
         * set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *         which do not have default values
         */
        Vine build() throws IllegalStateException;

    }
}
