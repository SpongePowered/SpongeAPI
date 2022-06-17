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
package org.spongepowered.api.world.generation.config.noise;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.world.biome.BiomeAttributes;
import org.spongepowered.api.world.generation.ConfigurableChunkGenerator;
import org.spongepowered.api.world.generation.config.ChunkGeneratorConfig;
import org.spongepowered.api.world.generation.config.SurfaceRule;
import org.spongepowered.api.world.server.storage.ServerWorldProperties;

import java.util.List;

/**
 * Noise generator config used in {@link ConfigurableChunkGenerator configurable chunk generators}.
 */
public interface NoiseGeneratorConfig extends ChunkGeneratorConfig {

    static NoiseGeneratorConfigTemplate.Builder builder() {
        return Sponge.game().builderProvider().provide(NoiseGeneratorConfigTemplate.Builder.class);
    }

    /**
     * The noise configuration parameters.
     *
     * @return the noise configuration.
     */
    NoiseConfig noiseConfig();

    /**
     * The noise router.
     *
     * @return The noise router.
     */
    NoiseRouter noiseRouter();

    /**
     * The list of biome attributes to allow the initial {@link ServerWorldProperties#spawnPosition()} in.
     * <p>In vanilla this is only set for the overworld.</p>
     *
     * @return The biome attributes to determine the spawn position
     */
    List<BiomeAttributes> spawnTargets();

    /**
     * The surface rules.
     *
     * @return the surface rules.
     */
    SurfaceRule surfaceRule();

    /**
     * The default block used for terrain.
     *
     * @return the default block.
     */
    BlockState defaultBlock();

    /**
     * The default fluid used for seas and lakes.
     *
     * @return the default fluid.
     */
    BlockState defaultFluid();

    /**
     * The sea level.
     *
     * @return the sea level.
     */
    int seaLevel();

    /**
     * Whether aquifers are generated.
     *
     * @return true when aquifers are generated.
     */
    boolean aquifers();

    /**
     * Whether ore veins are generated.
     *
     * @return true when the ore veins are generated.
     */
    boolean oreVeins();

    /**
     * Whether generation uses the legacy random source.
     * <p>As of Minecraft 1.19 the legacy random source is still used for nether and end generation.</p>
     *
     * @return true when using the legacy random source.
     */
    boolean legacyRandomSource();

    /**
     * Whether mobs spawn during generation.
     *
     * @return true when mobs spawn during generation.
     */
    boolean mobGeneration();

}
