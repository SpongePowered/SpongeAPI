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
import org.spongepowered.api.registry.RegistryReference;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.world.biome.Biome;
import org.spongepowered.api.world.generation.config.flat.LayerConfig;
import org.spongepowered.api.world.generation.config.structure.StructureGenerationConfig;

import java.util.List;
import java.util.Optional;

public interface FlatGeneratorConfig extends ChunkGeneratorConfig {

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class).reset();
    }

    List<LayerConfig> layers();

    Optional<LayerConfig> layer(int index);

    RegistryReference<Biome> biome();

    boolean performDecoration();

    boolean populateLakes();

    interface Builder extends org.spongepowered.api.util.Builder<FlatGeneratorConfig, Builder>, CopyableBuilder<FlatGeneratorConfig, Builder> {

        Builder structureConfig(StructureGenerationConfig config);

        Builder addLayer(int index, LayerConfig config);

        Builder addLayer(LayerConfig config);

        Builder addLayers(List<LayerConfig> layers);

        Builder removeLayer(int index);

        Builder biome(RegistryReference<Biome> biome);

        Builder performDecoration(boolean performDecoration);

        Builder populateLakes(boolean populateLakes);
    }
}
