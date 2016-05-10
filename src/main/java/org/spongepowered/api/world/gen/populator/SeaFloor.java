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
 * Represents a populator which places down a disc of material onto the bottom
 * on an ocean or river.
 */
public interface SeaFloor extends Populator {

    /**
     * Creates a new {@link Builder} to build a {@link SeaFloor} populator.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the {@link BlockState} to place down.
     * 
     * @return The block to place
     */
    BlockState getBlock();

    /**
     * Sets the {@link BlockState} to place down.
     * 
     * @param block The new block to place
     */
    void setBlock(BlockState block);

    /**
     * Gets the number of discs to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @return The amount to spawn
     */
    VariableAmount getDiscsPerChunk();

    /**
     * Sets the number of discs to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @param count The new amount to spawn
     */
    void setDiscsPerChunk(VariableAmount count);

    /**
     * Sets the number of discs to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @param count The new amount to spawn
     */
    default void setDiscsPerChunk(int count) {
        setDiscsPerChunk(VariableAmount.fixed(count));
    }

    /**
     * Gets the radius of the discs being spawned.
     * 
     * @return The disc radius
     */
    VariableAmount getRadius();

    /**
     * Sets the radius of the discs being spawned.
     * 
     * @param radius The new disc radius
     */
    void setRadius(VariableAmount radius);

    /**
     * Sets the radius of the discs being spawned.
     * 
     * @param radius The new disc radius
     */
    default void setRadius(double radius) {
        setRadius(VariableAmount.fixed(radius));
    }

    /**
     * Gets the depth of the sea floor cover to generate.
     * 
     * @return The depth
     */
    VariableAmount getDepth();

    /**
     * Sets the depth of the sea floor cover to generate.
     * 
     * @param depth The new depth
     */
    void setDepth(VariableAmount depth);

    /**
     * Sets the depth of the sea floor cover to generate.
     * 
     * @param depth The new depth
     */
    default void setDepth(int depth) {
        setDepth(VariableAmount.fixed(depth));
    }

    /**
     * Gets the predicate which is applied to determine what {@link BlockState}s
     * this populator may replace.
     * 
     * @return The replacement check
     */
    Predicate<BlockState> getValidBlocksToReplace();

    /**
     * Sets the predicate which will be applied to all {@link BlockState}s that
     * this populator attempts to replace in order to determine if they are
     * valid.
     * 
     * @param check The new replacement check
     */
    void setValidBlocksToReplace(Predicate<BlockState> check);

    /**
     * A builder for constructing {@link SeaFloor} populators.
     */
    interface Builder extends ResettableBuilder<SeaFloor, Builder> {

        /**
         * Sets the {@link BlockState} to place down.
         * 
         * @param block The new block to place
         * @return This builder, for chaining
         */
        Builder block(BlockState block);

        /**
         * Sets the number of discs to attempt to spawn per chunk, must be
         * greater than zero.
         * 
         * @param count The new amount to spawn
         * @return This builder, for chaining
         */
        Builder perChunk(VariableAmount count);

        /**
         * Sets the number of discs to attempt to spawn per chunk, must be
         * greater than zero.
         * 
         * @param count The new amount to spawn
         * @return This builder, for chaining
         */
        default Builder perChunk(int count) {
            return perChunk(VariableAmount.fixed(count));
        }

        /**
         * Sets the radius of the discs being spawned.
         * 
         * @param radius The new disc radius
         * @return This builder, for chaining
         */
        Builder radius(VariableAmount radius);

        /**
         * Sets the radius of the discs being spawned.
         * 
         * @param radius The new disc radius
         * @return This builder, for chaining
         */
        default Builder radius(double radius) {
            return radius(VariableAmount.fixed(radius));
        }

        /**
         * Sets the depth of the sea floor cover to generate.
         * 
         * @param depth The new depth
         * @return This builder, for chaining
         */
        Builder depth(VariableAmount depth);

        /**
         * Sets the depth of the sea floor cover to generate.
         * 
         * @param depth The new depth
         * @return This builder, for chaining
         */
        default Builder depth(int depth) {
            return depth(VariableAmount.fixed(depth));
        }

        /**
         * Sets the predicate which will be applied to all {@link BlockState}s
         * that this populator attempts to replace in order to determine if they
         * are valid.
         * 
         * @param check The new replacement check
         * @return This builder, for chaining
         */
        Builder replace(Predicate<BlockState> check);

        /**
         * Builds a new instance of a {@link SeaFloor} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *         which do not have default values
         */
        SeaFloor build() throws IllegalStateException;

    }

}
