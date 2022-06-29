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
package org.spongepowered.api.world.biome.provider;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.RegistryReference;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.world.biome.Biome;

import java.util.List;

/**
 * The configuration for {@link ConfigurableBiomeProvider} generating a checkerboard style biome distribution.
 */
public interface CheckerboardBiomeConfig extends BiomeProviderConfig {

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class).reset();
    }

    /**
     * Returns the scale of the checkerboard tiles.
     *
     * @return The scale
     */
    int scale();

    interface Builder extends org.spongepowered.api.util.Builder<CheckerboardBiomeConfig, Builder>, CopyableBuilder<CheckerboardBiomeConfig, Builder> {

        /**
         * Sets the scale of the checkerboard tiles
         *
         * @param scale The scale
         * @return This builder, for chaining
         */
        Builder scale(int scale);

        /**
         * Adds the given biome.
         *
         * @param biome The biome
         * @return This builder, for chaining
         */
        Builder addBiome(RegistryReference<Biome> biome);

        /**
         * Adds the given biomes.
         *
         * @param biomes The biomes
         * @return This builder, for chaining
         */
        Builder addBiomes(List<RegistryReference<Biome>> biomes);

        /**
         * Removes the given biome.
         *
         * @param biome The biome
         * @return This builder, for chaining
         */
        Builder removeBiome(RegistryReference<Biome> biome);
    }
}
