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

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

@SuppressWarnings("unchecked")
public final class StatisticCategories {

    // SORTFIELDS:ON

    public static final StatisticCategory.ForCatalogType<BlockType> BLOCKS_BROKEN =
            DummyObjectProvider.createFor(StatisticCategory.ForCatalogType.class, "BLOCKS_BROKEN");

    public static final StatisticCategory CUSTOM = DummyObjectProvider.createFor(StatisticCategory.class, "CUSTOM");

    public static final StatisticCategory.ForCatalogType<EntityType<?>> ENTITIES_KILLED =
            DummyObjectProvider.createFor(StatisticCategory.ForCatalogType.class, "ENTITIES_KILLED");

    public static final StatisticCategory.ForCatalogType<ItemType> ITEMS_BROKEN =
            DummyObjectProvider.createFor(StatisticCategory.ForCatalogType.class, "ITEMS_BROKEN");

    public static final StatisticCategory.ForCatalogType<ItemType> ITEMS_CRAFTED =
            DummyObjectProvider.createFor(StatisticCategory.ForCatalogType.class, "ITEMS_CRAFTED");

    public static final StatisticCategory.ForCatalogType<ItemType> ITEMS_DROPPED =
            DummyObjectProvider.createFor(StatisticCategory.ForCatalogType.class, "ITEMS_DROPPED");

    public static final StatisticCategory.ForCatalogType<ItemType> ITEMS_PICKED_UP =
            DummyObjectProvider.createFor(StatisticCategory.ForCatalogType.class, "ITEMS_PICKED_UP");

    public static final StatisticCategory.ForCatalogType<ItemType> ITEMS_USED =
            DummyObjectProvider.createFor(StatisticCategory.ForCatalogType.class, "ITEMS_USED");

    public static final StatisticCategory.ForCatalogType<EntityType<?>> KILLED_BY_ENTITIES =
            DummyObjectProvider.createFor(StatisticCategory.ForCatalogType.class, "KILLED_BY_ENTITIES");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private StatisticCategories() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
