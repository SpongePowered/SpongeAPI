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
package org.spongepowered.api.item;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * Represents all possible {@link ItemTag}s that are known to exist in
 * vanilla minecraft.
 */
public final class ItemTags {

    // SORTFIELDS:ON

    public static final ItemTag ACACIA_LOGS = DummyObjectProvider.createFor(ItemTag.class, "ACACIA_LOGS");

    public static final ItemTag ANVIL = DummyObjectProvider.createFor(ItemTag.class, "ANVIL");

    public static final ItemTag BANNERS = DummyObjectProvider.createFor(ItemTag.class, "BANNERS");

    public static final ItemTag BIRCH_LOGS = DummyObjectProvider.createFor(ItemTag.class, "BIRCH_LOGS");

    public static final ItemTag BOATS = DummyObjectProvider.createFor(ItemTag.class, "BOATS");

    public static final ItemTag BUTTONS = DummyObjectProvider.createFor(ItemTag.class, "BUTTONS");

    public static final ItemTag CARPETS = DummyObjectProvider.createFor(ItemTag.class, "CARPETS");

    public static final ItemTag DARK_OAK_LOGS = DummyObjectProvider.createFor(ItemTag.class, "DARK_OAK_LOGS");

    public static final ItemTag DOORS = DummyObjectProvider.createFor(ItemTag.class, "DOORS");

    public static final ItemTag FISHES = DummyObjectProvider.createFor(ItemTag.class, "FISHES");

    public static final ItemTag JUNGLE_LOGS = DummyObjectProvider.createFor(ItemTag.class, "JUNGLE_LOGS");

    public static final ItemTag LEAVES = DummyObjectProvider.createFor(ItemTag.class, "LEAVES");

    public static final ItemTag LOGS = DummyObjectProvider.createFor(ItemTag.class, "LOGS");

    public static final ItemTag OAK_LOGS = DummyObjectProvider.createFor(ItemTag.class, "OAK_LOGS");

    public static final ItemTag PLANKS = DummyObjectProvider.createFor(ItemTag.class, "PLANKS");

    public static final ItemTag RAILS = DummyObjectProvider.createFor(ItemTag.class, "RAILS");

    public static final ItemTag SAND = DummyObjectProvider.createFor(ItemTag.class, "SAND");

    public static final ItemTag SAPLINGS = DummyObjectProvider.createFor(ItemTag.class, "SAPLINGS");

    public static final ItemTag SLABS = DummyObjectProvider.createFor(ItemTag.class, "SLABS");

    public static final ItemTag SPRUCE_LOGS = DummyObjectProvider.createFor(ItemTag.class, "SPRUCE_LOGS");

    public static final ItemTag STAIRS = DummyObjectProvider.createFor(ItemTag.class, "STAIRS");

    public static final ItemTag STONE_BRICKS = DummyObjectProvider.createFor(ItemTag.class, "STONE_BRICKS");

    public static final ItemTag TRAPDOORS = DummyObjectProvider.createFor(ItemTag.class, "TRAPDOORS");

    public static final ItemTag WOODEN_BUTTONS = DummyObjectProvider.createFor(ItemTag.class, "WOODEN_BUTTONS");

    public static final ItemTag WOODEN_DOORS = DummyObjectProvider.createFor(ItemTag.class, "WOODEN_DOORS");

    public static final ItemTag WOODEN_PRESSURE_PLATES = DummyObjectProvider.createFor(ItemTag.class, "WOODEN_PRESSURE_PLATES");

    public static final ItemTag WOODEN_SLABS = DummyObjectProvider.createFor(ItemTag.class, "WOODEN_SLABS");

    public static final ItemTag WOODEN_STAIRS = DummyObjectProvider.createFor(ItemTag.class, "WOODEN_STAIRS");

    public static final ItemTag WOODEN_TRAPDOORS = DummyObjectProvider.createFor(ItemTag.class, "WOODEN_TRAPDOORS");

    public static final ItemTag WOOL = DummyObjectProvider.createFor(ItemTag.class, "WOOL");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private ItemTags() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
