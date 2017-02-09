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
package org.spongepowered.api.item.inventory;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of {@link InventoryArchetype}s.
 */
public class InventoryArchetypes {

    // Base Archetypes

    /**
     * A single Inventory Slot.
     */
    public static final InventoryArchetype SLOT = DummyObjectProvider.createFor(InventoryArchetype.class, "SLOT");

    /**
     * A row of Slots. 9 Slots by default.
     */
    public static final InventoryArchetype MENU_ROW = DummyObjectProvider.createFor(InventoryArchetype.class, "MENU_ROW");

    /**
     * A grid of Slots.
     */
    public static final InventoryArchetype MENU_GRID = DummyObjectProvider.createFor(InventoryArchetype.class, "MENU_GRID");

    /**
     * A column of Slots.
     */
    public static final InventoryArchetype MENU_COLUMN = DummyObjectProvider.createFor(InventoryArchetype.class, "MENU_COLUMN");

    /**
     * A Slot acting like a button.
     */
    public static final InventoryArchetype MENU_BUTTON = DummyObjectProvider.createFor(InventoryArchetype.class, "MENU_BUTTON");

    /**
     * A Slot acting like an icon.
     */
    public static final InventoryArchetype MENU_ICON = DummyObjectProvider.createFor(InventoryArchetype.class, "MENU_ICON");

    /**
     * A Slot that can toggle between two icon states.
     */
    public static final InventoryArchetype MENU_CHECKBOX = DummyObjectProvider.createFor(InventoryArchetype.class, "MENU_CHECKBOX");

    /**
     * An icon Slot that can count up and down.
     */
    public static final InventoryArchetype MENU_SPINNER = DummyObjectProvider.createFor(InventoryArchetype.class, "MENU_SPINNER");

    /**
     * A Players personal crafting area. Output with 2x2 Grid
     */
    public static final InventoryArchetype CRAFTING = DummyObjectProvider.createFor(InventoryArchetype.class, "CRAFTING");

    // Vanilla Archetypes

    // Grid-based

    /**
     * A Chest. By default 9x3.
     */
    public static final InventoryArchetype CHEST = DummyObjectProvider.createFor(InventoryArchetype.class, "CHEST");

    /**
     * A DoubleChest. By default 9x6.
     */
    public static final InventoryArchetype DOUBLE_CHEST = DummyObjectProvider.createFor(InventoryArchetype.class, "DOUBLE_CHEST");

    /**
     * A Hopper. 5x1
     */
    public static final InventoryArchetype HOPPER = DummyObjectProvider.createFor(InventoryArchetype.class, "HOPPER");

    /**
     * A Dispenser or Dropper. 3x3
     */
    public static final InventoryArchetype DISPENSER = DummyObjectProvider.createFor(InventoryArchetype.class, "DISPENSER");

    /**
     * A Workbench. 3x3
     */
    public static final InventoryArchetype WORKBENCH = DummyObjectProvider.createFor(InventoryArchetype.class, "WORKBENCH");

    // Slot-based

    /**
     * A Furnace. 3 Slots
     */
    public static final InventoryArchetype FURNACE = DummyObjectProvider.createFor(InventoryArchetype.class, "FURNACE");

    /**
     * A EnchantingTable. 2 Slots
     */
    public static final InventoryArchetype ENCHANTING_TABLE = DummyObjectProvider.createFor(InventoryArchetype.class, "ENCHANTING_TABLE");

    /**
     * A Anvil. 3 Slots
     */
    public static final InventoryArchetype ANVIL = DummyObjectProvider.createFor(InventoryArchetype.class, "ANVIL");

    /**
     * A BrewingStand. 4 Slots.
     *
     * <p>5 Slots in Minecraft 1.9</p>
     */
    public static final InventoryArchetype BREWING_STAND = DummyObjectProvider.createFor(InventoryArchetype.class, "BREWING_STAND");

    /**
     * A Beacon. 1 Slot
     */
    public static final InventoryArchetype BEACON = DummyObjectProvider.createFor(InventoryArchetype.class, "BEACON");

    // Entity

    /**
     * A Horse, Donkey or Mule 2 Slots.
     */
    public static final InventoryArchetype HORSE = DummyObjectProvider.createFor(InventoryArchetype.class, "HORSE");

    /**
     * A Villager. 3 Slots
     */
    public static final InventoryArchetype VILLAGER = DummyObjectProvider.createFor(InventoryArchetype.class, "VILLAGER");

    /**
     * A Donkey or Mule with Chest. 2 Slots and 5x3 Chest
     * Needs a horse as carrier to show to player in Vanilla.
     */
    public static final InventoryArchetype HORSE_WITH_CHEST = DummyObjectProvider.createFor(InventoryArchetype.class, "HORSE_WITH_CHEST");

    // Player

    /**
     * A Player. Includes 9x3 main inventory, 9x1 Hotbar, 4 Armorslots and 2x2
     * Crafting area.
     *
     * <p>Cannot be opened by the server in Vanilla.</p>
     */
    public static final InventoryArchetype PLAYER = DummyObjectProvider.createFor(InventoryArchetype.class, "PLAYER");

    public static final InventoryArchetype UNKNOWN = DummyObjectProvider.createFor(InventoryArchetype.class, "UNKNOWN");

}
