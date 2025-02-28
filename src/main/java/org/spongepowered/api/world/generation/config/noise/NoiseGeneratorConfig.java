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
import org.spongepowered.api.datapack.DataPackSerializable;
import org.spongepowered.api.registry.DefaultedRegistryValue;
import org.spongepowered.api.util.Builder;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.util.annotation.CatalogedBy;
import org.spongepowered.api.world.biome.BiomeAttributes;
import org.spongepowered.api.world.generation.ConfigurableChunkGenerator;
import org.spongepowered.api.world.generation.config.ChunkGeneratorConfig;
import org.spongepowered.api.world.generation.config.SurfaceRule;
import org.spongepowered.api.world.server.storage.ServerWorldProperties;

import java.util.List;

/**
 * Noise generator config used in {@link ConfigurableChunkGenerator configurable chunk generators}.
 */
@CatalogedBy(NoiseGeneratorConfigs.class)
public interface NoiseGeneratorConfig extends ChunkGeneratorConfig, DefaultedRegistryValue, DataPackSerializable {

    /**
     * Creates a new {@link Builder} to create a {@link NoiseGeneratorConfig}.
     *
     * @return The new builder
     */
    static NoiseGeneratorConfig.Builder builder() {
        return Sponge.game().builderProvider().provide(NoiseGeneratorConfig.Builder.class);
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

    /**
     * A builder to create {@link NoiseGeneratorConfig}s.
     */
    interface Builder extends org.spongepowered.api.util.Builder<NoiseGeneratorConfig, Builder>, CopyableBuilder<NoiseGeneratorConfig, Builder> {

        /**
         * Sets the noise configuration
         *
         * @param config The noise configuration
         * @return This builder, for chaining
         */
        Builder noiseConfig(NoiseConfig config);

        /**
         * Sets the surface rule.
         *
         * @param rule The surface rule
         * @return This builder, for chaining
         */
        Builder surfaceRule(SurfaceRule rule);

        /**
         * Sets the default block used for terrain.
         *
         * @param block The block
         * @return This builder, for chaining
         */
        Builder defaultBlock(BlockState block);

        /**
         * Sets the default fluid used for seas and lakes.
         *
         * @param fluid The fluid
         * @return This builder, for chaining
         */
        Builder defaultFluid(BlockState fluid);

        /**
         * Sets the sea level.
         *
         * @param y The sea level
         * @return This builder, for chaining
         */
        Builder seaLevel(int y);

        /**
         * Sets whether to generate aquifers.
         *
         * @param enableAquifers true to enable aquifers
         * @return This builder, for chaining
         */
        Builder aquifers(boolean enableAquifers);

        /**
         * Sets whether to generate or veins.
         *
         * @param enableOreVeins true to enable ore veins
         * @return This builder, for chaining
         */
        Builder oreVeins(boolean enableOreVeins);

        /**
         * Sets whether to enable mob generation.
         *
         * @param mobGeneration true to enable mob generation
         * @return This builder, for chaining
         */
        Builder mobGeneration(boolean mobGeneration);

        /**
         * Sets whether to use the legacy random source.
         * @param useLegacyRandomSource true when using the legacy random source
         * @return This builder, for chaining
         */
        Builder randomSource(boolean useLegacyRandomSource);

        /**
         * Sets the noise router.
         * @param router The noise router
         * @return This builder, for chaining
         */
        Builder noiseRouter(NoiseRouter router);

        /**
         * Sets the biome attributes in which the initial {@link ServerWorldProperties#spawnPosition()} is allowed.
         *
         * @param spawnTargets The spawn targets
         * @return This builder, for chaining
         */
        Builder spawnTargets(List<BiomeAttributes> spawnTargets);
    }
}
