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
package org.spongepowered.api.statistic;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registries;
import org.spongepowered.api.registry.RegistryKey;

public final class StatisticCategories {

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<StatisticCategory.ForCatalog<BlockType>> BLOCKS_BROKEN = StatisticCategories.catalogKey(ResourceKey.minecraft("blocks_broken"));

    public static final DefaultedRegistryReference<StatisticCategory> CUSTOM = StatisticCategories.key(ResourceKey.minecraft("custom"));

    public static final DefaultedRegistryReference<StatisticCategory.ForCatalog<EntityType<?>>> ENTITIES_KILLED = StatisticCategories.catalogKey(ResourceKey.minecraft("entities_killed"));

    public static final DefaultedRegistryReference<StatisticCategory.ForCatalog<ItemType>> ITEMS_BROKEN = StatisticCategories.catalogKey(ResourceKey.minecraft("items_broken"));

    public static final DefaultedRegistryReference<StatisticCategory.ForCatalog<ItemType>> ITEMS_CRAFTED = StatisticCategories.catalogKey(ResourceKey.minecraft("items_crafted"));

    public static final DefaultedRegistryReference<StatisticCategory.ForCatalog<ItemType>> ITEMS_DROPPED = StatisticCategories.catalogKey(ResourceKey.minecraft("items_dropped"));

    public static final DefaultedRegistryReference<StatisticCategory.ForCatalog<ItemType>> ITEMS_PICKED_UP = StatisticCategories.catalogKey(ResourceKey.minecraft("items_picked_up"));

    public static final DefaultedRegistryReference<StatisticCategory.ForCatalog<ItemType>> ITEMS_USED = StatisticCategories.catalogKey(ResourceKey.minecraft("items_used"));

    public static final DefaultedRegistryReference<StatisticCategory.ForCatalog<EntityType<?>>> KILLED_BY_ENTITIES = StatisticCategories.catalogKey(ResourceKey.minecraft("killed_by_entities"));

    // SORTFIELDS:OFF

    private StatisticCategories() {
    }

    private static DefaultedRegistryReference<StatisticCategory> key(final ResourceKey location) {
        return RegistryKey.<StatisticCategory>of(Registries.STATISTIC_CATEGORY.registry(), location).asDefaultedReference(() -> Sponge.getGame().registries());
    }

    private static <T extends CatalogType> DefaultedRegistryReference<StatisticCategory.ForCatalog<T>> catalogKey(final ResourceKey location) {
        return RegistryKey.<StatisticCategory.ForCatalog<T>>of(Registries.STATISTIC_CATEGORY.registry(), location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
