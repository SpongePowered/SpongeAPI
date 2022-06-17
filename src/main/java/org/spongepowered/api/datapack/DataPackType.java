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
package org.spongepowered.api.datapack;

import org.spongepowered.api.advancement.AdvancementTemplate;
import org.spongepowered.api.event.lifecycle.RegisterDataPackValueEvent;
import org.spongepowered.api.item.recipe.RecipeRegistration;
import org.spongepowered.api.registry.RegistryType;
import org.spongepowered.api.tag.TagTemplate;
import org.spongepowered.api.tag.Taggable;
import org.spongepowered.api.util.annotation.CatalogedBy;
import org.spongepowered.api.world.WorldTypeTemplate;
import org.spongepowered.api.world.biome.BiomeTemplate;
import org.spongepowered.api.world.generation.carver.CarverTemplate;
import org.spongepowered.api.world.generation.config.noise.DensityFunctionTemplate;
import org.spongepowered.api.world.generation.config.noise.NoiseGeneratorConfigTemplate;
import org.spongepowered.api.world.generation.config.noise.NoiseTemplate;
import org.spongepowered.api.world.generation.feature.FeatureTemplate;
import org.spongepowered.api.world.generation.feature.PlacedFeatureTemplate;
import org.spongepowered.api.world.generation.structure.SchematicTemplate;
import org.spongepowered.api.world.generation.structure.StructureTemplate;
import org.spongepowered.api.world.server.WorldTemplate;
import org.spongepowered.plugin.PluginContainer;

@CatalogedBy(DataPackTypes.class)
public interface DataPackType<T> {

    /**
     * Gets if resources created by this type will persist even if the {@link PluginContainer plugin}
     * is no longer present (or no longer performs a registration in {@link RegisterDataPackValueEvent}
     *
     * <p>Consult your implementation vendor for more details on exactly what resources are kept.</p>
     * 
     * @return True if persistent, false if not
     */
    boolean persistent();

    /**
     * Returns a data pack for this data pack type.
     *
     * @param name The pack name
     * @param description The pack description
     *
     * @return The new pack.
     */
    DataPack<T> pack(String name, String description);

    interface Factory {

        DataPackType<AdvancementTemplate> advancement();

        DataPackType<RecipeRegistration> recipe();

        DataPackType<WorldTypeTemplate> worldType();

        DataPackType<WorldTemplate> world();

        <T extends Taggable<T>> DataPackType<TagTemplate<T>> tag(RegistryType<T> registryType);

        DataPackType<BiomeTemplate> biome();

        DataPackType<CarverTemplate> carver();

        DataPackType<FeatureTemplate> feature();

        DataPackType<PlacedFeatureTemplate> placedFeature();

        DataPackType<NoiseGeneratorConfigTemplate> noiseGeneratorConfig();

        DataPackType<NoiseTemplate> noise();

        DataPackType<DensityFunctionTemplate> densityFunction();

        DataPackType<StructureTemplate> structure();

        DataPackType<SchematicTemplate> schematic();
    }
}
