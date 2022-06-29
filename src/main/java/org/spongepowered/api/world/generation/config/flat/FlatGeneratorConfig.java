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
package org.spongepowered.api.world.generation.config.flat;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.RegistryReference;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.util.annotation.CatalogedBy;
import org.spongepowered.api.world.biome.Biome;
import org.spongepowered.api.world.generation.config.ChunkGeneratorConfig;
import org.spongepowered.api.world.generation.structure.StructureSet;

import java.util.List;
import java.util.Optional;

/**
 * {@link ChunkGeneratorConfig} used by the vanilla flat worlds.
 * See {@link FlatGeneratorConfigs} for the vanilla provided presets.
 */
@CatalogedBy(FlatGeneratorConfigs.class)
public interface FlatGeneratorConfig extends ChunkGeneratorConfig {

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * Returns the list of layers from top to bottom. TODO check
     *
     * @return The list of layers
     */
    List<LayerConfig> layers();

    /**
     * Returns the layer at given index
     *
     * @param index The index
     * @return The layer
     */
    Optional<LayerConfig> layer(int index);

    /**
     * Returns the biome
     *
     * @return The biome
     */
    RegistryReference<Biome> biome();

    /**
     * Whether to place decorations.
     *
     * @return true if decorations are placed
     */
    boolean performDecoration();

    /**
     * Whether to populate lakes.
     *
     * @return true if lakes are populated
     */
    boolean populateLakes();

    /**
     * The list of {@link StructureSet} to use.
     * <p>If empty all structure sets are used.</p>
     *
     * @return The list of structure sets
     */
    Optional<List<StructureSet>> structureSets();

    interface Builder extends org.spongepowered.api.util.Builder<FlatGeneratorConfig, Builder>, CopyableBuilder<FlatGeneratorConfig, Builder> {

        /**
         * Adds a layer at given index
         *
         * @param index The index
         * @param config The layer configuration
         *
         * @return This builder, for chaining
         */
        Builder addLayer(int index, LayerConfig config);

        /**
         * Adds a layer on top.
         *
         * @param config The layer configuration
         * @return This builder, for chaining
         */
        Builder addLayer(LayerConfig config);

        /**
         * Adds multiple layers.
         *
         * @param layers The layers
         * @return This builder, for chaining
         */
        Builder addLayers(List<LayerConfig> layers);

        /**
         * Removes a layer at given index
         *
         * @param index The index
         * @return This builder, for chaining
         */
        Builder removeLayer(int index);

        /**
         * Sets the biome.
         *
         * @param biome The biome
         * @return This builder, for chaining
         */
        Builder biome(RegistryReference<Biome> biome);

        /**
         * Sets whether to perform decorations
         *
         * @param performDecoration Whether to perform decorations
         * @return This builder, for chaining
         */
        Builder performDecoration(boolean performDecoration);

        /**
         * Sets whether to populate lakes
         *
         * @param populateLakes Whether to populate lakes
         * @return This builder, for chaining
         */
        Builder populateLakes(boolean populateLakes);

        /**
         * Sets the structure sets. If null uses all structure sets instead.
         *
         * @param structureSets The structure sets
         * @return This builder, for chaining
         */
        Builder structureSets(@Nullable List<StructureSet> structureSets);
    }

}
