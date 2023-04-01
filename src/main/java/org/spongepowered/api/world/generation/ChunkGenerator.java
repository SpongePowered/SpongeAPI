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
package org.spongepowered.api.world.generation;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.world.WorldTypes;
import org.spongepowered.api.world.biome.provider.BiomeProvider;
import org.spongepowered.api.world.generation.config.flat.FlatGeneratorConfig;
import org.spongepowered.api.world.generation.config.noise.NoiseGeneratorConfig;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.api.world.server.WorldTemplate;

import java.io.IOException;
import java.util.Objects;

/**
 * A chunk generator.
 * <p>
 * Vanilla builtin generators include
 * - configurable flat generator see {@link FlatGeneratorConfig}
 * - configurable noise generator see {@link NoiseGeneratorConfig}.
 * <p>
 * Other chunk generators may be provided by third parties and may be obtained from
 * - {@link ServerWorld#generator()}
 * - {@link WorldTemplate#generator()}
 * - {@link ChunkGenerator.Factory#fromDataPack} using {@link WorldTemplate} data.
 */
public interface ChunkGenerator {

    static ConfigurableChunkGenerator<FlatGeneratorConfig> flat(final FlatGeneratorConfig config) {
        return Sponge.game().factoryProvider().provide(ChunkGenerator.Factory.class).flat(Objects.requireNonNull(config, "config"));
    }

    static ConfigurableChunkGenerator<NoiseGeneratorConfig> noise(final BiomeProvider provider, final NoiseGeneratorConfig config) {
        return Sponge.game().factoryProvider().provide(ChunkGenerator.Factory.class).noise(Objects.requireNonNull(provider, "provider"), Objects.requireNonNull(config, "config"));
    }

    static ConfigurableChunkGenerator<NoiseGeneratorConfig> overworld() {
        return Sponge.game().factoryProvider().provide(ChunkGenerator.Factory.class).overworld();
    }

    static ConfigurableChunkGenerator<NoiseGeneratorConfig> theNether() {
        return Sponge.game().factoryProvider().provide(ChunkGenerator.Factory.class).theNether();
    }

    static ConfigurableChunkGenerator<NoiseGeneratorConfig> theEnd() {
        return Sponge.game().factoryProvider().provide(ChunkGenerator.Factory.class).theEnd();
    }

    /**
     * Returns the biome provider.
     *
     * @return The biome provider
     */
    BiomeProvider biomeProvider();

    interface Factory {

        /**
         * Creates a chunk generator based on given configuration.
         *
         * @param config The flat generator configuration
         * @return The new chunk generator
         */
        ConfigurableChunkGenerator<FlatGeneratorConfig> flat(FlatGeneratorConfig config);

        /**
         * Creates a chunk generator bases on given biome provider and configuration
         *
         * @param provider The biome provider
         * @param config The noise generator configuration
         * @return The new chunk generator
         */
        ConfigurableChunkGenerator<NoiseGeneratorConfig> noise(BiomeProvider provider, NoiseGeneratorConfig config);

        /**
         * Creates a chunk generator like the vanilla {@link WorldTypes#OVERWORLD}.
         *
         * @return The new chunk generator
         */
        ConfigurableChunkGenerator<NoiseGeneratorConfig> overworld();

        /**
         * Creates a chunk generator like the vanilla {@link WorldTypes#THE_NETHER}.
         *
         * @return The new chunk generator
         */
        ConfigurableChunkGenerator<NoiseGeneratorConfig> theNether();

        /**
         * Creates a chunk generator like the vanilla {@link WorldTypes#THE_END}.
         *
         * @return The new chunk generator
         */
        ConfigurableChunkGenerator<NoiseGeneratorConfig> theEnd();

        /**
         * Creates a chunk generator based on the given data view.
         * <p>The data must be equivalent to a data-pack for {@link WorldTemplate}</p>
         * see {@link WorldTemplate.Builder#fromDataPack}
         *
         * @param pack the data
         * @return the created ChunkGenerator
         */
        ChunkGenerator fromDataPack(DataView pack) throws IOException;
    }
}
