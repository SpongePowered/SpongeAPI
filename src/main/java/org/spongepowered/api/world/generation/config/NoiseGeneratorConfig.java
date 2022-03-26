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
package org.spongepowered.api.world.generation.config;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.world.generation.config.noise.NoiseConfig;

/**
 * ChunkGeneratorConfig used most of the vanilla provided dimensions.
 */
public interface NoiseGeneratorConfig extends ChunkGeneratorConfig {

    /**
     * Returns the vanilla overworld noise generation configuration.
     *
     * @return he vanilla overworld noise generation configuration.
     */
    static NoiseGeneratorConfig overworld() {
        return Sponge.game().factoryProvider().provide(Factory.class).overworld();
    }

    /**
     * Returns the vanilla amplified overworld noise generation configuration.
     *
     * @return the vanilla amplified overworld noise generation configuration.
     */
    static NoiseGeneratorConfig amplified() {
        return Sponge.game().factoryProvider().provide(Factory.class).amplified();
    }

    /**
     * Returns the vanilla overworld with large biomes noise generation configuration.
     *
     * @return the vanilla overworld with large biomes noise generation configuration.
     */
    static NoiseGeneratorConfig largeBiomes() {
        return Sponge.game().factoryProvider().provide(Factory.class).largeBiomes();
    }

    /**
     * Returns the vanilla nether noise generation configuration.
     *
     * @return the vanilla nether noise generation configuration.
     */
    static NoiseGeneratorConfig nether() {
        return Sponge.game().factoryProvider().provide(Factory.class).nether();
    }

    /**
     * Returns the vanilla end noise generation configuration.
     *
     * @return the vanilla end noise generation configuration.
     */
    static NoiseGeneratorConfig end() {
        return Sponge.game().factoryProvider().provide(Factory.class).end();
    }

    /**
     * Returns the vanilla cave overworld noise generation configuration.
     *
     * @return the vanilla cave overworld noise generation configuration.
     */
    static NoiseGeneratorConfig caves() {
        return Sponge.game().factoryProvider().provide(Factory.class).caves();
    }

    /**
     * Returns the vanilla floating islands overworld noise generation configuration.
     *
     * @return the vanilla floating islands overworld noise generation configuration.
     */
    static NoiseGeneratorConfig floatingIslands() {
        return Sponge.game().factoryProvider().provide(Factory.class).floatingIslands();
    }

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * The noise configuration parameters.
     *
     * @return the noise configuration.
     */
    NoiseConfig noiseConfig();

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
     * Whether different noise caves are generated.
     *
     * @return true when different noise caves are generated.
     */
    boolean noiseCaves();

    /**
     * Whether noodle caves are generated.
     *
     * @return true when noodle caves are generated.
     */
    boolean noodleCaves();

    /**
     * Whether generation uses the legacy random source.
     * <p>As of Minecraft 1.18 the legacy random source is still used for nether and end generation.</p>
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

    interface Builder extends org.spongepowered.api.util.Builder<NoiseGeneratorConfig, Builder>, CopyableBuilder<NoiseGeneratorConfig, Builder> {

        Builder noiseConfig(NoiseConfig config);

        Builder surfaceRule(SurfaceRule rule);

        Builder defaultBlock(BlockState block);

        Builder defaultFluid(BlockState fluid);

        Builder seaLevel(int y);

        Builder aquifers(boolean enableAquifers);

        Builder oreVeins(boolean enableOreVeins);

        Builder noiseCaves(boolean enableNoiseCaves);

        Builder noodleCaves(boolean enableNoodleCaves);

        Builder mobGeneration(boolean mobGeneration);

        Builder randomSource(boolean useLegacyRandomSource);
    }

    interface Factory {

        /**
         * Returns the vanilla overworld noise generation configuration.
         *
         * @return he vanilla overworld noise generation configuration.
         */
        NoiseGeneratorConfig overworld();

        /**
         * Returns the vanilla amplified overworld noise generation configuration.
         *
         * @return the vanilla amplified overworld noise generation configuration.
         */
        NoiseGeneratorConfig amplified();

        /**
         * Returns the vanilla overworld with large biomes noise generation configuration.
         *
         * @return the vanilla overworld with large biomes noise generation configuration.
         */
        NoiseGeneratorConfig largeBiomes();

        /**
         * Returns the vanilla nether noise generation configuration.
         *
         * @return the vanilla nether noise generation configuration.
         */
        NoiseGeneratorConfig nether();

        /**
         * Returns the vanilla end noise generation configuration.
         *
         * @return the vanilla end noise generation configuration.
         */
        NoiseGeneratorConfig end();

        /**
         * Returns the vanilla cave overworld noise generation configuration.
         *
         * @return the vanilla cave overworld noise generation configuration.
         */
        NoiseGeneratorConfig caves();

        /**
         * Returns the vanilla floating islands overworld noise generation configuration.
         *
         * @return the vanilla floating islands overworld noise generation configuration.
         */
        NoiseGeneratorConfig floatingIslands();
    }
}
