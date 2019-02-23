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
package org.spongepowered.api.block;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * Represents all possible {@link BlockTag}s that are known to exist in
 * vanilla minecraft.
 */
public final class BlockTags {

    // SORTFIELDS:ON

    public static final BlockTag ACACIA_LOGS = DummyObjectProvider.createFor(BlockTag.class, "ACACIA_LOGS");

    public static final BlockTag ANVIL = DummyObjectProvider.createFor(BlockTag.class, "ANVIL");

    public static final BlockTag BANNERS = DummyObjectProvider.createFor(BlockTag.class, "BANNERS");

    public static final BlockTag BIRCH_LOGS = DummyObjectProvider.createFor(BlockTag.class, "BIRCH_LOGS");

    public static final BlockTag BUTTONS = DummyObjectProvider.createFor(BlockTag.class, "BUTTONS");

    public static final BlockTag CARPETS = DummyObjectProvider.createFor(BlockTag.class, "CARPETS");

    public static final BlockTag CORAL_BLOCKS = DummyObjectProvider.createFor(BlockTag.class, "CORAL_BLOCKS");

    public static final BlockTag CORAL_PLANTS = DummyObjectProvider.createFor(BlockTag.class, "CORAL_PLANTS");

    public static final BlockTag CORALS = DummyObjectProvider.createFor(BlockTag.class, "CORALS");

    public static final BlockTag DARK_OAK_LOGS = DummyObjectProvider.createFor(BlockTag.class, "DARK_OAK_LOGS");

    public static final BlockTag DOORS = DummyObjectProvider.createFor(BlockTag.class, "DOORS");

    public static final BlockTag ENDERMAN_HOLDABLE = DummyObjectProvider.createFor(BlockTag.class, "ENDERMAN_HOLDABLE");

    public static final BlockTag FLOWER_POTS = DummyObjectProvider.createFor(BlockTag.class, "FLOWER_POTS");

    public static final BlockTag ICE = DummyObjectProvider.createFor(BlockTag.class, "ICE");

    public static final BlockTag IMPERMEABLE = DummyObjectProvider.createFor(BlockTag.class, "IMPERMEABLE");

    public static final BlockTag JUNGLE_LOGS = DummyObjectProvider.createFor(BlockTag.class, "JUNGLE_LOGS");

    public static final BlockTag LEAVES = DummyObjectProvider.createFor(BlockTag.class, "LEAVES");

    public static final BlockTag LOGS = DummyObjectProvider.createFor(BlockTag.class, "LOGS");

    public static final BlockTag OAK_LOGS = DummyObjectProvider.createFor(BlockTag.class, "OAK_LOGS");

    public static final BlockTag PLANKS = DummyObjectProvider.createFor(BlockTag.class, "PLANKS");

    public static final BlockTag RAILS = DummyObjectProvider.createFor(BlockTag.class, "RAILS");

    public static final BlockTag SAND = DummyObjectProvider.createFor(BlockTag.class, "SAND");

    public static final BlockTag SAPLINGS = DummyObjectProvider.createFor(BlockTag.class, "SAPLINGS");

    public static final BlockTag SLABS = DummyObjectProvider.createFor(BlockTag.class, "SLABS");

    public static final BlockTag SPRUCE_LOGS = DummyObjectProvider.createFor(BlockTag.class, "SPRUCE_LOGS");

    public static final BlockTag STAIRS = DummyObjectProvider.createFor(BlockTag.class, "STAIRS");

    public static final BlockTag STONE_BRICKS = DummyObjectProvider.createFor(BlockTag.class, "STONE_BRICKS");

    public static final BlockTag TRAPDOORS = DummyObjectProvider.createFor(BlockTag.class, "TRAPDOORS");

    public static final BlockTag UNDERWATER_BONEMEALS = DummyObjectProvider.createFor(BlockTag.class, "UNDERWATER_BONEMEALS");

    public static final BlockTag VALID_SPAWN = DummyObjectProvider.createFor(BlockTag.class, "VALID_SPAWN");

    public static final BlockTag WALL_CORALS = DummyObjectProvider.createFor(BlockTag.class, "WALL_CORALS");

    public static final BlockTag WOODEN_BUTTONS = DummyObjectProvider.createFor(BlockTag.class, "WOODEN_BUTTONS");

    public static final BlockTag WOODEN_DOORS = DummyObjectProvider.createFor(BlockTag.class, "WOODEN_DOORS");

    public static final BlockTag WOODEN_PRESSURE_PLATES = DummyObjectProvider.createFor(BlockTag.class, "WOODEN_PRESSURE_PLATES");

    public static final BlockTag WOODEN_SLABS = DummyObjectProvider.createFor(BlockTag.class, "WOODEN_SLABS");

    public static final BlockTag WOODEN_STAIRS = DummyObjectProvider.createFor(BlockTag.class, "WOODEN_STAIRS");

    public static final BlockTag WOODEN_TRAPDOORS = DummyObjectProvider.createFor(BlockTag.class, "WOODEN_TRAPDOORS");

    public static final BlockTag WOOL = DummyObjectProvider.createFor(BlockTag.class, "WOOL");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private BlockTags() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
