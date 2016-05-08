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
import org.spongepowered.api.data.type.ShrubType;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.weighted.VariableAmount;
import org.spongepowered.api.util.weighted.WeightedTable;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.extent.Extent;
import org.spongepowered.api.world.gen.Populator;

import java.util.Optional;
import java.util.function.Function;

import javax.annotation.Nullable;

/**
 * Represents a populator which places down various variants of
 * {@link ShrubType}s within the chunk.
 */
public interface Shrub extends Populator {

    /**
     * Creates a new {@link Builder} to build a {@link Shrub} populator.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets a weighted collection of {@link ShrubType}s to place.
     * 
     * @return The shrub types
     */
    WeightedTable<ShrubType> getTypes();

    /**
     * Gets the number of shrubs to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @return The amount of shrubs to spawn
     */
    VariableAmount getShrubsPerChunk();

    /**
     * Sets the number of shrubs to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @param count The new amount of shrubs to spawn
     */
    void setShrubsPerChunk(VariableAmount count);

    /**
     * Sets the number of shrubs to attempt to spawn per chunk, must be greater
     * than zero.
     * 
     * @param count The new amount of shrubs to spawn
     */
    default void setShrubsPerChunk(int count) {
        setShrubsPerChunk(VariableAmount.fixed(count));
    }

    /**
     * Gets the overriding supplier if it exists. If the supplier is present
     * then it is used in place of the weighted table while determining what
     * ShrubType to place.
     * 
     * @return The supplier override
     */
    Optional<Function<Location<Extent>, ShrubType>> getSupplierOverride();

    /**
     * Sets the overriding supplier. If the supplier is present then it is used
     * in place of the weighted table while determining what ShrubType to place.
     * 
     * @param override The new supplier override, or null
     */
    void setSupplierOverride(@Nullable Function<Location<Extent>, ShrubType> override);

    /**
     * Clears the supplier override to force the weighted table to be used
     * instead.
     */
    default void clearSupplierOverride() {
        setSupplierOverride(null);
    }

    /**
     * A builder for constructing {@link Shrub} populators.
     */
    interface Builder extends ResettableBuilder<Shrub, Builder> {

        /**
         * Sets the number of shrubs to attempt to spawn per chunk, must be
         * greater than zero.
         * 
         * @param count The new amount of shrubs to spawn
         * @return This builder, for chaining
         */
        Builder perChunk(VariableAmount count);

        /**
         * Sets the number of shrubs to attempt to spawn per chunk, must be
         * greater than zero.
         * 
         * @param count The new amount of shrubs to spawn
         * @return This builder, for chaining
         */
        default Builder perChunk(int count) {
            return perChunk(VariableAmount.fixed(count));
        }

        /**
         * Sets the weighted {@link ShrubType}s to place.
         * 
         * @param types The new shrub types
         * @return This builder, for chaining
         */
        Builder types(WeightedTable<ShrubType> types);

        /**
         * Adds the weighted {@link ShrubType}s to the list of types.
         * 
         * @param type The new shrub type
         * @param weight The weight of the type
         * @return This builder, for chaining
         */
        Builder type(ShrubType type, int weight);

        /**
         * Sets the overriding supplier. If the supplier is present then it is
         * used in place of the weighted table.
         * 
         * @param override The new supplier override, or null
         * @return This builder, for chaining
         */
        Builder supplier(@Nullable Function<Location<Extent>, ShrubType> override);

        /**
         * Builds a new instance of a {@link Shrub} populator with the settings
         * set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *         which do not have default values
         */
        Shrub build() throws IllegalStateException;

    }

}
