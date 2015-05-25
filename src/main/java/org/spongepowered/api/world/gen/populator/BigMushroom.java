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

import com.google.common.base.Optional;
import org.spongepowered.api.data.type.BigMushroomType;
import org.spongepowered.api.world.biome.BiomeTypes;
import org.spongepowered.api.world.gen.Populator;

/**
 * Represents a populator which places a number of large mushrooms. The type of
 * mushroom to place can be set or can be randomized.
 */
public interface BigMushroom extends Populator {

    /**
     * Gets the type of mushroom being placed by this populator.
     * <strong>Note:</strong> this type will be ignored if the populator is set
     * to randomize types {@link #usesRandomizedType()}. If the populator is set
     * to randomize then this method will return absent.
     * 
     * @return The type, if not randomized
     */
    Optional<BigMushroomType> getType();

    /**
     * Sets the type of mushroom to place. Setting the mushroom type will set
     * {@link #usesRandomizedType()} to false.
     * 
     * @param type The new mushroom type
     */
    void setType(BigMushroomType type);

    /**
     * Gets whether this populator is randomizing which type it is placing. If
     * set the mushroom type will be selected at random for each mushroom that
     * it places.
     * 
     * <p>This defaults to true.</p>
     * 
     * @return True if this populator is using randomized mushroom types
     */
    boolean usesRandomizedType();

    /**
     * Sets whether this populator is randomizing which type it is placing. If
     * set the mushroom type will be selected at random for each mushroom that
     * it places.
     * 
     * @param state The new state
     */
    void useRandomizedTypes(boolean state);

    /**
     * Gets the number of mushrooms which will be attempted to be spawned.
     * 
     * <p><strong>Note:</strong> This number is not a definite number and the
     * final count of mushrooms which are successfully spawned by the populator
     * will almost always be lower.</p>
     * 
     * <p>The default value for this is 1 (from
     * {@link BiomeTypes#MUSHROOM_ISLAND}.</p>
     * 
     * @return The number of mushrooms attempted to be spawned per chunk
     */
    int getMushroomsPerChunk();

    /**
     * Sets the number of mushrooms which will be attempted to be spawned.
     * 
     * <p><strong>Note:</strong> This number is not a definite number and the
     * final count of mushrooms which are successfully spawned by the populator
     * will almost always be lower.</p>
     * 
     * @param count The new amount to attempt to create
     */
    void setMushroomsPerChunk(int count);

    /**
     * A builder for constructing {@link BigMushroom} populators.
     */
    interface Builder {

        /**
         * Sets the type of mushroom to place. Setting the mushroom type will
         * set {@link #usesRandomizedType()} to false.
         * 
         * <p>Defaults to absent with the
         * {@link BigMushroom#usesRandomizedType()} flag set to true.</p>
         * 
         * @param type The new mushroom type
         * @return This builder, for chaining
         */
        Builder type(BigMushroomType type);

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
        Builder mushroomsPerChunk(int count);

        /**
         * Sets whether this populator is randomizing which type it is placing.
         * If set the mushroom type will be selected at random for each mushroom
         * that it places.
         * 
         * <p>This defaults to true.</p>
         *
         * @return This builder, for chaining
         */
        Builder randomizeType();

        /**
         * Resets this builder to the default values.
         * 
         * @return This builder, for chaining
         */
        Builder reset();

        /**
         * Builds a new instance of a {@link BigMushroom} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *             which do not have default values
         */
        BigMushroom build() throws IllegalStateException;

    }

}
