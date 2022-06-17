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
import org.spongepowered.api.world.biome.Biomes;

public interface EndStyleBiomeConfig extends BiomeProviderConfig {

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class).reset();
    }

    /**
     * Returns the configured end biome,
     * by default {@link Biomes#THE_END}
     *
     * @return The configured end biome
     */
    RegistryReference<Biome> endBiome();

    /**
     * Returns the configured end highlands biome,
     * by default {@link Biomes#END_HIGHLANDS}
     *
     * @return The configured end highlands biome
     */
    RegistryReference<Biome> highlandsBiome();

    /**
     * Returns the configured end midlands biome,
     * by default {@link Biomes#END_MIDLANDS}
     *
     * @return The configured end midlands biome
     */
    RegistryReference<Biome> midlandsBiome();

    /**
     * Returns the configured end islands biome,
     * by default {@link Biomes#SMALL_END_ISLANDS}
     *
     * @return The configured end islands biome
     */
    RegistryReference<Biome> islandsBiome();

    /**
     * Returns the configured end barrens biome,
     * by default {@link Biomes#END_BARRENS}
     *
     * @return The configured end barrens biome
     */
    RegistryReference<Biome> barrensBiome();

    interface Builder extends org.spongepowered.api.util.Builder<EndStyleBiomeConfig, Builder>, CopyableBuilder<EndStyleBiomeConfig, Builder> {

        Builder endBiome(RegistryReference<Biome> endBiome);

        Builder highlandsBiome(RegistryReference<Biome> highlandsBiome);

        Builder midlandsBiome(RegistryReference<Biome> midlandsBiome);

        Builder islandsBiome(RegistryReference<Biome> islandsBiome);

        Builder barrensBiome(RegistryReference<Biome> barrensBiome);
    }
}
