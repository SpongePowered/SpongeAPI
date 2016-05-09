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

import java.util.function.Predicate;

/**
 * Represents a populator which seeds the underground areas of the chunks with
 * ores.
 */
public interface Ore extends Populator {

    /**
     * Creates a new {@link Builder} to build a {@link Ore} populator.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the block to place as ore.
     * 
     * @return The ore block
     */
    BlockState getOreBlock();

    /**
     * Sets the block to place as ore.
     * 
     * @param block The new ore block
     */
    void setOreBlock(BlockState block);

    /**
     * Gets the size of deposit of ore. This is the number of blocks per clump
     * of ores spawned.
     * 
     * @return The deposit size
     */
    VariableAmount getDepositSize();

    /**
     * Sets the size of deposit of ore. This is the number of blocks per clump
     * of ores spawned.
     * 
     * @param size The new deposit size
     */
    void setDepositSize(VariableAmount size);

    /**
     * Sets the size of deposit of ore. This is the number of blocks per clump
     * of ores spawned.
     * 
     * @param size The new deposit size
     */
    default void setDepositSize(int size) {
        setDepositSize(VariableAmount.fixed(size));
    }

    /**
     * Gets the number of ore clumps to attempt to spawn per chunk, must be
     * greater than zero.
     * 
     * @return The number of clumps to spawn
     */
    VariableAmount getDepositsPerChunk();

    /**
     * Sets the number of ore clumps to attempt to spawn per chunk, must be
     * greater than zero.
     * 
     * @param count The new number of clumps to spawn
     */
    void setDepositsPerChunk(VariableAmount count);

    /**
     * Sets the number of ore clumps to attempt to spawn per chunk, must be
     * greater than zero.
     * 
     * @param count The new number of clumps to spawn
     */
    default void setDepositsPerChunk(int count) {
        setDepositSize(VariableAmount.fixed(count));
    }

    /**
     * Gets the height that the ore will generate at.
     * 
     * @return The height
     */
    VariableAmount getHeight();

    /**
     * Sets the height that the ore will generate at.
     * 
     * @param height The new height
     */
    void setHeight(VariableAmount height);

    /**
     * Gets a predicate which checks for the placement conditions for this ore.
     * 
     * @return The placement conditions check
     */
    Predicate<BlockState> getPlacementCondition();

    /**
     * Sets a predicate which checks for the placement conditions for this ore.
     * 
     * @param condition The new placement conditions check
     */
    void setPlacementCondition(Predicate<BlockState> condition);

    /**
     * A builder for constructing {@link Ore} populators.
     */
    interface Builder extends ResettableBuilder<Ore, Builder> {

        /**
         * Sets the block to place as ore.
         * 
         * @param block The new ore block
         * @return This builder, for chaining
         */
        Builder ore(BlockState block);

        /**
         * Sets the size of deposit of ore. This is the number of blocks per
         * clump of ores spawned.
         * 
         * @param size The new deposit size
         * @return This builder, for chaining
         */
        Builder size(VariableAmount size);

        /**
         * Sets the size of deposit of ore. This is the number of blocks per
         * clump of ores spawned.
         * 
         * @param size The new deposit size
         * @return This builder, for chaining
         */
        default Builder size(int size) {
            return size(VariableAmount.fixed(size));
        }

        /**
         * Sets the number of ore clumps to attempt to spawn per chunk, must be
         * greater than zero.
         * 
         * @param count The new number of clumps to spawn
         * @return This builder, for chaining
         */
        Builder perChunk(VariableAmount count);

        /**
         * Sets the number of ore clumps to attempt to spawn per chunk, must be
         * greater than zero.
         * 
         * @param count The new number of clumps to spawn
         * @return This builder, for chaining
         */
        default Builder perChunk(int count) {
            return perChunk(VariableAmount.fixed(count));
        }

        /**
         * Sets the height that the ore can generate at.
         * 
         * @param height The new height
         * @return This builder, for chaining
         */
        Builder height(VariableAmount height);

        /**
         * Sets a predicate which checks for the placement conditions for this
         * ore.
         * 
         * @param condition The new placement conditions check
         * @return This builder, for chaining
         */
        Builder placementCondition(Predicate<BlockState> condition);

        /**
         * Builds a new instance of a {@link Ore} populator with the settings
         * set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *         which do not have default values
         */
        Ore build() throws IllegalStateException;

    }

}
