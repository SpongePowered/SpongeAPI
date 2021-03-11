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
import org.spongepowered.api.world.biome.provider.BiomeProvider;
import org.spongepowered.api.world.generation.config.FlatGeneratorConfig;
import org.spongepowered.api.world.generation.config.NoiseGeneratorConfig;
import org.spongepowered.api.world.generation.config.structure.StructureGenerationConfig;

import java.util.Objects;

public interface ChunkGenerator {

    static <T extends FlatGeneratorConfig> ConfigurableChunkGenerator<T> flat(final T config) {
        return Sponge.game().factoryProvider().provide(ChunkGenerator.Factory.class).flat(Objects.requireNonNull(config, "config"));
    }

    static <T extends NoiseGeneratorConfig> ConfigurableChunkGenerator<T> noise(final BiomeProvider provider, final T config) {
        return Sponge.game().factoryProvider().provide(ChunkGenerator.Factory.class).noise(Objects.requireNonNull(provider, "provider"), Objects.requireNonNull(config, "config"));
    }

    static <T extends NoiseGeneratorConfig> ConfigurableChunkGenerator<T> noise(final BiomeProvider provider, final long seed, final T config) {
        return Sponge.game().factoryProvider().provide(ChunkGenerator.Factory.class).noise(Objects.requireNonNull(provider, "provider"), seed, Objects.requireNonNull(config, "config"));
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

    BiomeProvider biomeProvider();

    StructureGenerationConfig structureConfig();

    interface Factory {

        <T extends FlatGeneratorConfig> ConfigurableChunkGenerator<T> flat(T config);

        <T extends NoiseGeneratorConfig> ConfigurableChunkGenerator<T> noise(BiomeProvider provider, T config);

        <T extends NoiseGeneratorConfig> ConfigurableChunkGenerator<T> noise(BiomeProvider provider, long seed, T config);

        ConfigurableChunkGenerator<NoiseGeneratorConfig> overworld();

        ConfigurableChunkGenerator<NoiseGeneratorConfig> theNether();

        ConfigurableChunkGenerator<NoiseGeneratorConfig> theEnd();
    }
}
