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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.advancement.AdvancementTemplate;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.fluid.FluidType;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.recipe.RecipeRegistration;
import org.spongepowered.api.registry.RegistryType;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.tag.TagTemplate;
import org.spongepowered.api.world.WorldTypeTemplate;
import org.spongepowered.api.world.biome.BiomeTemplate;
import org.spongepowered.api.world.generation.carver.CarverTemplate;
import org.spongepowered.api.world.generation.feature.FeatureTemplate;
import org.spongepowered.api.world.generation.feature.PlacedFeatureTemplate;
import org.spongepowered.api.world.server.WorldTemplate;

public final class DataPackTypes {

    public static final DataPackType<AdvancementTemplate> ADVANCEMENT = Sponge.game().factoryProvider().provide(DataPackType.Factory.class).advancement();

    public static final DataPackType<RecipeRegistration> RECIPE = Sponge.game().factoryProvider().provide(DataPackType.Factory.class).recipe();

    public static final DataPackType<TagTemplate<BlockType>> BLOCK_TAG = Sponge.game().factoryProvider().provide(DataPackType.Factory.class).tag(RegistryTypes.BLOCK_TYPE);

    public static final DataPackType<TagTemplate<FluidType>> FLUID_TAG = Sponge.game().factoryProvider().provide(DataPackType.Factory.class).tag(RegistryTypes.FLUID_TYPE);

    public static final DataPackType<TagTemplate<ItemType>> ITEM_TAG = Sponge.game().factoryProvider().provide(DataPackType.Factory.class).tag(RegistryTypes.ITEM_TYPE);

    public static final DataPackType<TagTemplate<EntityType<?>>> ENTITY_TAG = Sponge.game().factoryProvider().provide(DataPackType.Factory.class).tag((RegistryType<EntityType<?>>) RegistryTypes.ENTITY_TYPE);

    public static final DataPackType<BiomeTemplate> BIOME = Sponge.game().factoryProvider().provide(DataPackType.Factory.class).biome();

    public static final DataPackType<CarverTemplate> CARVER = Sponge.game().factoryProvider().provide(DataPackType.Factory.class).carver();

    public static final DataPackType<FeatureTemplate> FEATURE = Sponge.game().factoryProvider().provide(DataPackType.Factory.class).feature();

    public static final DataPackType<PlacedFeatureTemplate> PLACED_FEATURE = Sponge.game().factoryProvider().provide(DataPackType.Factory.class).placedFeature();

    public static final DataPackType<WorldTypeTemplate> WORLD_TYPE = Sponge.game().factoryProvider().provide(DataPackType.Factory.class).worldType();

    public static final DataPackType<WorldTemplate> WORLD = Sponge.game().factoryProvider().provide(DataPackType.Factory.class).world();

    private DataPackTypes() {
    }
}
