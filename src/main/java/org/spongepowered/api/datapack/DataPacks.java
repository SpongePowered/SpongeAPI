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

import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.advancement.AdvancementTemplate;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.fluid.FluidType;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.recipe.RecipeRegistration;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.tag.TagTemplate;
import org.spongepowered.api.world.WorldTypeTemplate;
import org.spongepowered.api.world.generation.biome.BiomeTemplate;
import org.spongepowered.api.world.server.WorldTemplate;

public final class DataPacks {

    /**
     * The Sponge provided data pack (plugin_advancements)
     */
    public static final DataPack<AdvancementTemplate> ADVANCEMENT = Sponge.game().factoryProvider().provide(DataPack.Factory.class).advancement();

    /**
     * The Sponge provided data pack (plugin_recipes)
     */
    public static final DataPack<RecipeRegistration> RECIPE = Sponge.game().factoryProvider().provide(DataPack.Factory.class).recipe();

    /**
     * The Sponge provided data pack (plugin_tags) for block types
     */
    public static final DataPack<TagTemplate<BlockType>> BLOCK_TAG = Sponge.game().factoryProvider().provide(DataPack.Factory.class).tag(RegistryTypes.BLOCK_TYPE);

    /**
     * The Sponge provided data pack (plugin_tags) for fluid types
     */
    public static final DataPack<TagTemplate<FluidType>> FLUID_TAG = Sponge.game().factoryProvider().provide(DataPack.Factory.class).tag(RegistryTypes.FLUID_TYPE);

    /**
     * The Sponge provided data pack (plugin_tags) for item types
     */
    public static final DataPack<TagTemplate<ItemType>> ITEM_TAG = Sponge.game().factoryProvider().provide(DataPack.Factory.class).tag(RegistryTypes.ITEM_TYPE);

    /**
     * The Sponge provided data pack (plugin_tags) for entity types
     */
    public static final DataPack<TagTemplate<EntityType<?>>> ENTITY_TAG = Sponge.game().factoryProvider().provide(DataPack.Factory.class).tag(RegistryTypes.ENTITY_TYPE);

    /**
     * The Sponge provided data pack (plugin_worldgen_biome)
     */
    public static final DataPack<BiomeTemplate> BIOME = Sponge.game().factoryProvider().provide(DataPack.Factory.class).biome();

    /**
     * The Sponge provided data pack (plugin_dimension_type)
     */
    public static final DataPack<WorldTypeTemplate> WORLD_TYPE = Sponge.game().factoryProvider().provide(DataPack.Factory.class).worldType();

    /**
     * The Sponge provided data pack (plugin_dimension)
     */
    public static final DataPack<WorldTemplate> WORLD = Sponge.game().factoryProvider().provide(DataPack.Factory.class).world();

    private DataPacks() {
    }
}
