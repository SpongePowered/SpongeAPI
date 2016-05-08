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
import org.spongepowered.api.util.weighted.WeightedTable;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.extent.Extent;
import org.spongepowered.api.world.gen.Populator;
import org.spongepowered.api.world.gen.PopulatorObject;

import java.util.Optional;
import java.util.function.Function;

import javax.annotation.Nullable;

/**
 * Represents a populator which places a number of mushrooms. The type of
 * mushroom to place can be set or can be randomized.
 */
public interface BigMushroom extends Populator {

    /**
     * Creates a new {@link Builder} to build a {@link BigMushroom} populator.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets a mutable {@link WeightedTable} of possible mushroom types to spawn.
     * 
     * @return The weighted list
     */
    WeightedTable<PopulatorObject> getTypes();

    /**
     * Gets a representation of the amount of mushrooms which will be attempted
     * to be spawned per chunk.
     * 
     * <p><strong>Note:</strong> This number is not a definite number and the
     * final count of mushrooms which are successfully spawned by the populator
     * will almost always be lower.</p>
     * 
     * @return The number of mushrooms attempted to be spawned per chunk
     */
    VariableAmount getMushroomsPerChunk();

    /**
     * Sets the representation of the amount of mushrooms which will be
     * attempted to be spawned per chunk.
     * 
     * <p><strong>Note:</strong> This number is not a definite number and the
     * final count of mushrooms which are successfully spawned by the populator
     * will almost always be lower.</p>
     * 
     * @param count The new amount to attempt to create
     */
    void setMushroomsPerChunk(VariableAmount count);

    /**
     * Sets the amount of mushrooms which will be attempted to be spawned per
     * chunk.
     * 
     * <p><strong>Note:</strong> This number is not a definite number and the
     * final count of mushrooms which are successfully spawned by the populator
     * will almost always be lower.</p>
     * 
     * @param count The new amount to attempt to create
     */
    default void setMushroomsPerChunk(int count) {
        setMushroomsPerChunk(VariableAmount.fixed(count));
    }

    /**
     * Gets the overriding supplier if it exists. If the supplier is present
     * then it is used in place of the weighted table while determining what
     * PopulatorObject to place.
     * 
     * @return The supplier override
     */
    Optional<Function<Location<Extent>, PopulatorObject>> getSupplierOverride();

    /**
     * Sets the overriding supplier. If the supplier is present then it is used
     * in place of the weighted table while determining what PopulatorObject to
     * place.
     * 
     * @param override The new supplier override, or null
     */
    void setSupplierOverride(@Nullable Function<Location<Extent>, PopulatorObject> override);

    /**
     * Clears the supplier override to force the weighted table to be used
     * instead.
     */
    default void clearSupplierOverride() {
        setSupplierOverride(null);
    }

    /**
     * A builder for constructing {@link BigMushroom} populators.
     */
    interface Builder extends ResettableBuilder<BigMushroom, Builder> {

        /**
         * Sets the weighted {@link PopulatorObject}s to select from during
         * generation.
         * 
         * @param types The weighted types
         * @return This builder, for chaining
         */
        Builder types(WeightedTable<PopulatorObject> types);

        /**
         * Adds the weighted {@link PopulatorObject} to the list of available
         * types.
         * 
         * @param type The new weighted type
         * @param weight The weight of the new type
         * @return This builder, for chaining
         */
        Builder type(PopulatorObject type, double weight);

        /**
         * Sets the number of mushrooms which will be attempted to be spawned.
         * 
         * <p><strong>Note:</strong> This number is not a definite number and
         * the final count of mushrooms which are successfully spawned by the
         * populator will almost always be lower.</p>
         * 
         * @param count The new amount to attempt to create
         * @return This builder, for chaining
         */
        Builder mushroomsPerChunk(VariableAmount count);

        /**
         * Sets the number of mushrooms which will be attempted to be spawned.
         * 
         * <p><strong>Note:</strong> This number is not a definite number and
         * the final count of mushrooms which are successfully spawned by the
         * populator will almost always be lower.</p>
         * 
         * @param count The new amount to attempt to create
         * @return This builder, for chaining
         */
        default Builder mushroomsPerChunk(int count) {
            return mushroomsPerChunk(VariableAmount.fixed(count));
        }

        /**
         * Sets the overriding supplier. If the supplier is present then it is
         * used in place of the weighted table.
         * 
         * @param override The new supplier override, or null
         * @return This builder, for chaining
         */
        Builder supplier(Function<Location<Extent>, PopulatorObject> override);

        /**
         * Builds a new instance of a {@link BigMushroom} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *         which do not have default values
         */
        BigMushroom build() throws IllegalStateException;

    }

}
