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
package org.spongepowered.api.variant;

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

public final class Varieties {

    // SORTFIELDS:ON

    /**
     * Represent something that has a {@link BlockType}, this has only
     * effect against matching {@link ItemType}s. Matching against {@link BlockType}s
     * will return {@code true} for everything.
     */
    public static final Variety BLOCK = DummyObjectProvider.createFor(Variety.class, "BLOCK");

    public static final Variety STAIRS = DummyObjectProvider.createFor(Variety.class, "STAIRS");

    public static final Variety SLABS = DummyObjectProvider.createFor(Variety.class, "SLABS");

    public static final Variety BUTTON = DummyObjectProvider.createFor(Variety.class, "BUTTON");

    public static final Variety DOOR = DummyObjectProvider.createFor(Variety.class, "DOOR");

    public static final Variety FENCE = DummyObjectProvider.createFor(Variety.class, "FENCE");

    public static final Variety FENCE_GATE = DummyObjectProvider.createFor(Variety.class, "FENCE_GATE");

    public static final Variety PRESSURE_PLATE = DummyObjectProvider.createFor(Variety.class, "PRESSURE_PLATE");

    public static final Variety TRAPDOOR = DummyObjectProvider.createFor(Variety.class, "TRAPDOOR");

    public static final Variety LOG = DummyObjectProvider.createFor(Variety.class, "LOG");

    public static final Variety LEAVES = DummyObjectProvider.createFor(Variety.class, "LEAVES");

    public static final Variety PLANKS = DummyObjectProvider.createFor(Variety.class, "PLANKS");

    public static final Variety BARK = DummyObjectProvider.createFor(Variety.class, "BARK");

    public static final Variety WOOL = DummyObjectProvider.createFor(Variety.class, "WOOL");

    public static final Variety WOOD = DummyObjectProvider.createFor(Variety.class, "WOOD");

    public static final Variety OAK = DummyObjectProvider.createFor(Variety.class, "OAK");

    public static final Variety BIRCH = DummyObjectProvider.createFor(Variety.class, "BIRCH");

    public static final Variety SPRUCE = DummyObjectProvider.createFor(Variety.class, "SPRUCE");

    public static final Variety JUNGLE = DummyObjectProvider.createFor(Variety.class, "JUNGLE");

    public static final Variety DARK_OAK = DummyObjectProvider.createFor(Variety.class, "DARK_OAK");

    public static final Variety ACACIA = DummyObjectProvider.createFor(Variety.class, "ACACIA");

    public static final Variety COAL = DummyObjectProvider.createFor(Variety.class, "COAL");

    public static final Variety GOLDEN_APPLE = DummyObjectProvider.createFor(Variety.class, "GOLDEN_APPLE");

    public static final Variety PUMPKIN = DummyObjectProvider.createFor(Variety.class, "PUMPKIN");

    // TODO: A lot more

    // SORTFIELDS:OFF

    private Varieties() {
    }
}
