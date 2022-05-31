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
import org.spongepowered.api.world.biome.Biome;
import org.spongepowered.api.world.biome.BiomeFinder;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Provides available Biomes for world generation.
 */
public interface BiomeProvider extends BiomeFinder {

    /**
     * Returns the vanilla overworld biome provider.
     *
     * @return the vanilla overworld biome provider.
     */
    static ConfigurableBiomeProvider<MultiNoiseBiomeConfig> overworld() {
        return Sponge.game().factoryProvider().provide(Factory.class).overworld();
    }

    /**
     * Returns a multi-noise biome provider based on a {@link MultiNoiseBiomeConfig}.
     * @param config the configuration
     * @param <T> the configuration type
     *
     * @return the configured BiomeProvider
     */
    static <T extends MultiNoiseBiomeConfig> ConfigurableBiomeProvider<T> multiNoise(final T config) {
        return Sponge.game().factoryProvider().provide(Factory.class).multiNoise(config);
    }

    /**
     * Returns the vanilla nether biome provider.
     *
     * @return the vanilla nether biome provider.
     */
    static ConfigurableBiomeProvider<MultiNoiseBiomeConfig> nether() {
        return Sponge.game().factoryProvider().provide(Factory.class).nether();
    }

    /**
     * Returns a vanilla end-style biome provider based on a {@link EndStyleBiomeConfig}.
     *
     * @param config the configuration
     * @param <T> the configuration type
     *
     * @return the configured BiomeProvider
     */
    static <T extends EndStyleBiomeConfig> ConfigurableBiomeProvider<T> endStyle(final T config) {
        return Sponge.game().factoryProvider().provide(Factory.class).endStyle(config);
    }

    /**
     * Returns the vanilla end biome provider.
     *
     * @return the vanilla end biome provider.
     */
    static ConfigurableBiomeProvider<EndStyleBiomeConfig> end() {
        return Sponge.game().factoryProvider().provide(Factory.class).end();
    }

    /**
     * Returns a checkerboard-style biome provider based on a {@link CheckerboardBiomeConfig}
     *
     * @param config the configuration
     * @param <T> the configuration type
     *
     * @return the configured BiomeProvider
     */
    static <T extends CheckerboardBiomeConfig> ConfigurableBiomeProvider<T> checkerboard(final T config) {
        return Sponge.game().factoryProvider().provide(Factory.class).checkerboard(config);
    }

    /**
     * Returns a fixed biome provider base on a single {@link Biome}
     *
     * @param biome the biome
     *
     * @return the configured BiomeProvider
     */
    static BiomeProvider fixed(final RegistryReference<Biome> biome) {
        return Sponge.game().factoryProvider().provide(Factory.class).fixed(Objects.requireNonNull(biome, "biome"));
    }

    /**
     * The list of biomes possible.
     *
     * @return the list of biomes possible.
     */
    List<Biome> choices();

    interface Factory {

        /**
         * Returns the vanilla overworld biome provider.
         *
         * @return the vanilla overworld biome provider.
         */
        ConfigurableBiomeProvider<MultiNoiseBiomeConfig> overworld();

        /**
         * Returns a multi-noise biome provider based on a {@link MultiNoiseBiomeConfig}.
         * @param config the configuration
         * @param <T> the configuration type
         *
         * @return the configured BiomeProvider
         */
        <T extends MultiNoiseBiomeConfig> ConfigurableBiomeProvider<T> multiNoise(T config);

        /**
         * Returns the vanilla nether biome provider.
         *
         * @return the vanilla nether biome provider.
         */
        ConfigurableBiomeProvider<MultiNoiseBiomeConfig> nether();

        /**
         * Returns a vanilla end-style biome provider based on a {@link EndStyleBiomeConfig}.
         *
         * @param config the configuration
         * @param <T> the configuration type
         *
         * @return the configured BiomeProvider
         */
        <T extends EndStyleBiomeConfig> ConfigurableBiomeProvider<T> endStyle(T config);

        /**
         * Returns the vanilla end biome provider.
         *
         * @return the vanilla end biome provider.
         */
        ConfigurableBiomeProvider<EndStyleBiomeConfig> end();

        /**
         * Returns a checkerboard-style biome provider based on a {@link CheckerboardBiomeConfig}
         *
         * @param config the configuration
         * @param <T> the configuration type
         *
         * @return the configured BiomeProvider
         */
        <T extends CheckerboardBiomeConfig> ConfigurableBiomeProvider<T> checkerboard(T config);

        /**
         * Returns a fixed biome provider base on a single {@link Biome}
         *
         * @param biome the biome
         *
         * @return the configured BiomeProvider
         */
        BiomeProvider fixed(RegistryReference<Biome> biome);
    }
}
