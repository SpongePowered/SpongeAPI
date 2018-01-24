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
package org.spongepowered.api.item.inventory.property;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of all possible {@link GuiId}s in vanilla minecraft.
 */
public final class GuiIds {

    // SORTFIELDS:ON

    /**
     * Size only multiple of 9 up to 6x9.
     */
    public static final GuiId CHEST = DummyObjectProvider.createFor(GuiId.class, "chest"); // "minecraft:chest"
    /**
     * Size only 3.
     */
    public static final GuiId FURNACE = DummyObjectProvider.createFor(GuiId.class, "furnace"); // "minecraft:furnace"
    /**
     * Size only 9.
     */
    public static final GuiId DISPENSER = DummyObjectProvider.createFor(GuiId.class, "dispenser"); // "minecraft:dispenser"
    /**
     * Size only 10.
     */
    public static final GuiId CRAFTING_TABLE = DummyObjectProvider.createFor(GuiId.class, "crafting_table"); // "minecraft:crafting_table"
    /**
     * Size only 5.
     */
    public static final GuiId BREWING_STAND = DummyObjectProvider.createFor(GuiId.class, "brewing_stand"); // "minecraft:brewing_stand"
    /**
     * Size only 5.
     */
    public static final GuiId HOPPER = DummyObjectProvider.createFor(GuiId.class, "hopper"); // "minecraft:hopper"
    /**
     * Size only 1.
     */
    public static final GuiId BEACON = DummyObjectProvider.createFor(GuiId.class, "beacon"); // "minecraft:beacon"
    /**
     * Size only 2.
     */
    public static final GuiId ENCHANTING_TABLE = DummyObjectProvider.createFor(GuiId.class, "enchanting_table"); // "minecraft:enchanting_table"
    /**
     * Size only 3.
     */
    public static final GuiId ANVIL = DummyObjectProvider.createFor(GuiId.class, "anvil"); // "minecraft:anvil"
    /**
     * Size only 3.
     */
    public static final GuiId VILLAGER = DummyObjectProvider.createFor(GuiId.class, "villager"); // "minecraft:villager"
    /**
     * Sizes 2 and more depending on the Horse Carrier.
     */
    public static final GuiId HORSE = DummyObjectProvider.createFor(GuiId.class, "horse"); // "minecraft:horse" internally "EntityHorse"
    /**
     * Size only 27 (3x9).
     */
    public static final GuiId SHULKER_BOX = DummyObjectProvider.createFor(GuiId.class, "shulker_box"); // "minecraft:shulker_box"

    // SORTFIELDS:OFF
}


