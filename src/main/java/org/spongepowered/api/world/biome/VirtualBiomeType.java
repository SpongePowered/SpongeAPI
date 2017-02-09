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
package org.spongepowered.api.world.biome;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.World;

import java.util.function.Function;

/**
 * A virtual biome is one which exists purely for generation and therefore
 * requires no modifications to clients in order to use it. After generation for
 * a chunk is complete the biome is persisted as its specified persisted biome
 * type.
 */
public interface VirtualBiomeType extends BiomeType {

    /**
     * Gets a new builder for creating new VirtualBiomeTypes.
     * 
     * @return The builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the biome type which this virtual biome is persisted as.
     * 
     * @return The persisted biome type
     */
    BiomeType getPersistedType();

    /**
     * A builder for {@link VirtualBiomeType}s.
     */
    interface Builder extends ResettableBuilder<VirtualBiomeType, Builder> {

        /**
         * Sets the name of the new virtual biome.
         * 
         * @param name The biome name
         * @return This builder, for chaining
         */
        Builder name(String name);

        /**
         * Sets the temperature of the virtual biome.
         * 
         * @param temp The temperature
         * @return This builder, for chaining
         */
        Builder temperature(double temp);

        /**
         * Sets the humidity of the virtual biome.
         * 
         * @param humidity The humidity
         * @return This builder, for chaining
         */
        Builder humidity(double humidity);

        /**
         * Sets the {@link BiomeType} that this virtual biome is persisted as
         * after generation is complete.
         * 
         * @param biome The persisted biome type
         * @return This builder, for chaining
         */
        Builder persistedType(BiomeType biome);

        /**
         * Sets the function used for creating new
         * {@link BiomeGenerationSettings}s for this virtual biome.
         * 
         * @param settingsBuilder The settings builder function
         * @return This builder, for chaining
         */
        Builder settingsBuilder(Function<World, BiomeGenerationSettings> settingsBuilder);

        /**
         * Builds a new {@link VirtualBiomeType} with the given unique id.
         * 
         * @param id The biome id, must be unique
         * @return The new virtual biome
         * @throws IllegalStateException If any required fields were missing
         */
        VirtualBiomeType build(String id) throws IllegalStateException;

    }

}
