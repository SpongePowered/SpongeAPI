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
import org.spongepowered.api.util.CatalogBuilder;

import java.util.function.Supplier;

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
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
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
    interface Builder extends CatalogBuilder<VirtualBiomeType, Builder> {

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
         * Sets the {@link BiomeType} that this virtual biome is persisted as
         * after generation is complete.
         *
         * @param biome The persisted biome type
         * @return This builder, for chaining
         */
        default Builder persistedType(Supplier<? extends BiomeType> biome) {
            return this.persistedType(biome.get());
        }

    }

}
