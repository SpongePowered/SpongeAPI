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
import org.spongepowered.api.world.generation.config.structure.StructureGenerationConfig;

public interface NoiseGeneratorConfig extends ChunkGeneratorConfig {

    static NoiseGeneratorConfig amplified() {
        return Sponge.game().factoryProvider().provide(Factory.class).amplified();
    }

    static NoiseGeneratorConfig overworld() {
        return Sponge.game().factoryProvider().provide(Factory.class).overworld();
    }

    static NoiseGeneratorConfig nether() {
        return Sponge.game().factoryProvider().provide(Factory.class).nether();
    }

    static NoiseGeneratorConfig end() {
        return Sponge.game().factoryProvider().provide(Factory.class).end();
    }

    static NoiseGeneratorConfig caves() {
        return Sponge.game().factoryProvider().provide(Factory.class).caves();
    }

    static NoiseGeneratorConfig floatingIslands() {
        return Sponge.game().factoryProvider().provide(Factory.class).floatingIslands();
    }

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class).reset();
    }

    NoiseConfig noiseConfig();

    BlockState defaultBlock();

    BlockState defaultFluid();

    int bedrockRoofY();

    int bedrockFloorY();

    int seaLevel();

    int minSurfaceLevel();

    boolean aquifers();

    boolean noiseCaves();

    boolean deepslate();

    interface Builder extends org.spongepowered.api.util.Builder<NoiseGeneratorConfig, Builder>, CopyableBuilder<NoiseGeneratorConfig, Builder> {

        Builder structureConfig(StructureGenerationConfig config);

        Builder noiseConfig(NoiseConfig config);

        Builder defaultBlock(BlockState block);

        Builder defaultFluid(BlockState fluid);

        Builder bedrockRoofY(int y);

        Builder bedrockFloorY(int y);

        Builder seaLevel(int y);

        Builder minSurfaceLevel(int y);

        Builder aquifers(boolean enableAquifers);

        Builder noiseCaves(boolean enableNoiseCaves);

        Builder deepslate(boolean enableDeepslate);
    }

    interface Factory {

        NoiseGeneratorConfig amplified();

        NoiseGeneratorConfig overworld();

        NoiseGeneratorConfig nether();

        NoiseGeneratorConfig end();

        NoiseGeneratorConfig caves();

        NoiseGeneratorConfig floatingIslands();
    }
}
