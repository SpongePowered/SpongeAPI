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
import org.spongepowered.api.adventure.ChatTypeTemplate;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.event.cause.entity.damage.DamageTypeTemplate;
import org.spongepowered.api.fluid.FluidType;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.recipe.RecipeRegistration;
import org.spongepowered.api.tag.TagTemplate;
import org.spongepowered.api.world.WorldTypeTemplate;
import org.spongepowered.api.world.biome.BiomeTemplate;
import org.spongepowered.api.world.generation.carver.CarverTemplate;
import org.spongepowered.api.world.generation.config.noise.DensityFunctionTemplate;
import org.spongepowered.api.world.generation.config.noise.NoiseGeneratorConfigTemplate;
import org.spongepowered.api.world.generation.config.noise.NoiseTemplate;
import org.spongepowered.api.world.generation.feature.FeatureTemplate;
import org.spongepowered.api.world.generation.feature.PlacedFeatureTemplate;
import org.spongepowered.api.world.generation.structure.SchematicTemplate;
import org.spongepowered.api.world.generation.structure.StructureSetTemplate;
import org.spongepowered.api.world.generation.structure.StructureTemplate;
import org.spongepowered.api.world.generation.structure.jigsaw.JigsawPoolTemplate;
import org.spongepowered.api.world.generation.structure.jigsaw.ProcessorListTemplate;
import org.spongepowered.api.world.server.WorldTemplate;

/**
 * Sponge provided default data packs for plugins. When building a {@link DataPackEntry} these packs are set by default.
 */
public final class DataPacks {

    // SORTFIELDS:ON

    public static final DataPack<AdvancementTemplate> ADVANCEMENT = DataPackTypes.ADVANCEMENT.pack("plugin_advancements", "Sponge plugin provided advancements");

    public static final DataPack<RecipeRegistration> RECIPE = DataPackTypes.RECIPE.pack("plugin_recipes", "Sponge plugin provided recipes");

    public static final DataPack<TagTemplate<BlockType>> BLOCK_TAG = DataPackTypes.BLOCK_TAG.pack("plugin_tags", "Sponge plugin provided tags");

    public static final DataPack<TagTemplate<FluidType>> FLUID_TAG = DataPackTypes.FLUID_TAG.pack("plugin_tags", "Sponge plugin provided tags");

    public static final DataPack<TagTemplate<ItemType>> ITEM_TAG = DataPackTypes.ITEM_TAG.pack("plugin_tags", "Sponge plugin provided tags");

    public static final DataPack<TagTemplate<EntityType<?>>> ENTITY_TAG = DataPackTypes.ENTITY_TAG.pack("plugin_tags", "Sponge plugin provided tags");

    public static final DataPack<BiomeTemplate> BIOME = DataPackTypes.BIOME.pack("plugin_worlds", "Sponge plugin provided biomes");

    public static final DataPack<CarverTemplate> CARVER = DataPackTypes.CARVER.pack("plugin_worlds", "Sponge plugin provided carvers");

    public static final DataPack<FeatureTemplate> FEATURE = DataPackTypes.FEATURE.pack("plugin_worlds", "Sponge plugin provided features");

    public static final DataPack<PlacedFeatureTemplate> PLACED_FEATURE = DataPackTypes.PLACED_FEATURE.pack("plugin_worlds", "Sponge plugin provided placed features");

    public static final DataPack<WorldTypeTemplate> WORLD_TYPE = DataPackTypes.WORLD_TYPE.pack("plugin_worlds", "Sponge plugin provided world types");

    public static final DataPack<WorldTemplate> WORLD = DataPackTypes.WORLD.pack("plugin_worlds", "Sponge plugin provided worlds");

    public static final DataPack<NoiseGeneratorConfigTemplate> NOISE_GENERATOR_CONFIG = DataPackTypes.NOISE_GENERATOR_CONFIG.pack("plugin_worldgen", "Sponge plugin provided noise generator configs");

    public static final DataPack<NoiseTemplate> NOISE = DataPackTypes.NOISE.pack("plugin_worldgen", "Sponge plugin provided noises");

    public static final DataPack<DensityFunctionTemplate> DENSITY_FUNCTION = DataPackTypes.DENSITY_FUNCTION.pack("plugin_worldgen", "Sponge plugin provided density functions");

    public static final DataPack<StructureTemplate> STRUCTURE = DataPackTypes.STRUCTURE.pack("plugin_worldgen", "Sponge plugin provided structures");

    public static final DataPack<StructureSetTemplate> STRUCTURE_SET = DataPackTypes.STRUCTURE_SET.pack("plugin_worldgen", "Sponge plugin provided structure sets");

    public static final DataPack<SchematicTemplate> SCHEMATIC = DataPackTypes.SCHEMATIC.pack("plugin_worldgen", "Sponge plugin provided structure schematics");

    public static final DataPack<ProcessorListTemplate> PROCESSOR_LIST = DataPackTypes.PROCESSOR_LIST.pack("plugin_worldgen", "Sponge plugin provided processor lists");

    public static final DataPack<JigsawPoolTemplate> JIGSAW_POOL = DataPackTypes.JIGSAW_POOL.pack("plugin_worldgen", "Sponge plugin provided jigsaw pools");
    public static final DataPack<ChatTypeTemplate> CHAT_TYPE = DataPackTypes.CHAT_TYPE.pack("plugin_chat_types", "Sponge plugin provided chat types");

    public static final DataPack<DamageTypeTemplate> DAMAGE_TYPE = DataPackTypes.DAMAGE_TYPE.pack("plugin_damage_types", "Sponge plugin provided damage types");
    public static final DataPack<TagTemplate<DamageType>> DAMAGE_TYPE_TAG = DataPackTypes.DAMAGE_TYPE_TAG.pack("plugin_damage_types", "Sponge plugin provided damage type tags");

    // SORTFIELDS:ON

    private DataPacks() {
    }
}
