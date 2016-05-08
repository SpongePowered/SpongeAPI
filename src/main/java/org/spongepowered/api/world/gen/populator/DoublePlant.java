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
import org.spongepowered.api.data.type.DoublePlantType;
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
 * Represents a populator which spawns in an assortment of two block tall
 * plants. The number of plants attempted to be generated is
 * {@code final = base + [0,variance) }.
 */
public interface DoublePlant extends Populator {

    /**
     * Creates a new {@link Builder} to build a {@link DoublePlant} populator.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets a mutable weighted collection of possible plants which may be
     * selected to be spawned in by this populator.
     * 
     * @return The possible types to be spawned
     */
    WeightedTable<DoublePlantType> getPossibleTypes();

    /**
     * Gets the number of plants to create per chunk.
     * 
     * @return The amount
     */
    VariableAmount getPlantsPerChunk();

    /**
     * Sets the number of plants to create per chunk, cannot be negative.
     * 
     * <p><strong>Note:</strong> This number is not a definite number and the
     * final count of plants which are successfully spawned by the populator
     * will almost always be lower.</p>
     * 
     * @param count The new amount
     */
    void setPlantsPerChunk(VariableAmount count);

    /**
     * Sets the number of plants to create per chunk, cannot be negative.
     * 
     * <p><strong>Note:</strong> This number is not a definite number and the
     * final count of plants which are successfully spawned by the populator
     * will almost always be lower.</p>
     * 
     * @param count The new amount
     */
    default void setPlantsPerChunk(int count) {
        setPlantsPerChunk(VariableAmount.fixed(count));
    }

    /**
     * Gets the overriding supplier if it exists. If the supplier is present
     * then it is used in place of the weighted table while determining what
     * DoublePlantType to place.
     * 
     * @return The supplier override
     */
    Optional<Function<Location<Extent>, DoublePlantType>> getSupplierOverride();

    /**
     * Sets the overriding supplier. If the supplier is present then it is used
     * in place of the weighted table while determining what DoublePlantType to
     * place.
     * 
     * @param override The new supplier override, or null
     */
    void setSupplierOverride(@Nullable Function<Location<Extent>, DoublePlantType> override);

    /**
     * Clears the supplier override to force the weighted table to be used
     * instead.
     */
    default void clearSupplierOverride() {
        setSupplierOverride(null);
    }

    /**
     * A builder for constructing {@link DoublePlant} populators.
     */
    interface Builder extends ResettableBuilder<DoublePlant, Builder> {

        /**
         * Sets which plant types may be spawned in by this populator.
         * 
         * @param types Possible types
         * @return This builder, for chaining
         */
        Builder types(WeightedTable<DoublePlantType> types);

        /**
         * Adds a plant type to the list that may be spawned in by this
         * populator.
         * 
         * @param type The new plant type
         * @param weight The weight
         * @return This builder, for chaining
         */
        Builder type(DoublePlantType type, double weight);

        /**
         * Sets the number of plants to create, cannot be negative.
         * 
         * <p><strong>Note:</strong> This number is not a definite number and
         * the final count of plants which are successfully spawned by the
         * populator will almost always be lower.</p>
         * 
         * @param count The new base amount
         * @return This builder, for chaining
         */
        Builder perChunk(VariableAmount count);

        /**
         * Sets the number of plants to create, cannot be negative.
         * 
         * <p><strong>Note:</strong> This number is not a definite number and
         * the final count of plants which are successfully spawned by the
         * populator will almost always be lower.</p>
         * 
         * @param count The new base amount
         * @return This builder, for chaining
         */
        default Builder perChunk(int count) {
            return perChunk(VariableAmount.fixed(count));
        }

        /**
         * Sets the overriding supplier. If the supplier is present then it is
         * used in place of the weighted table.
         * 
         * @param override The new supplier override, or null
         * @return This builder, for chaining
         */
        Builder supplier(@Nullable Function<Location<Extent>, DoublePlantType> override);

        /**
         * Builds a new instance of a {@link DoublePlant} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *         which do not have default values
         */
        DoublePlant build() throws IllegalStateException;

    }

}
