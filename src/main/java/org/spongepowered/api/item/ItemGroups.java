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
 * An enumeration of all possible {@link ItemGroup}s in vanilla minecraft.
 */
public final class ItemGroups {

    // SORTFIELDS:ON

    public static final ItemGroup BREWING = DummyObjectProvider.createFor(ItemGroup.class, "BREWING");

    public static final ItemGroup BUILDING_BLOCKS = DummyObjectProvider.createFor(ItemGroup.class, "BUILDING_BLOCKS");

    public static final ItemGroup COMBAT = DummyObjectProvider.createFor(ItemGroup.class, "COMBAT");

    public static final ItemGroup DECORATIONS = DummyObjectProvider.createFor(ItemGroup.class, "DECORATIONS");

    public static final ItemGroup FOOD = DummyObjectProvider.createFor(ItemGroup.class, "FOOD");

    public static final ItemGroup MATERIALS = DummyObjectProvider.createFor(ItemGroup.class, "MATERIALS");

    public static final ItemGroup MISC = DummyObjectProvider.createFor(ItemGroup.class, "MISC");

    public static final ItemGroup REDSTONE = DummyObjectProvider.createFor(ItemGroup.class, "REDSTONE");

    public static final ItemGroup TOOLS = DummyObjectProvider.createFor(ItemGroup.class, "TOOLS");

    public static final ItemGroup TRANSPORTATION = DummyObjectProvider.createFor(ItemGroup.class, "TRANSPORTATION");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private ItemGroups() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
