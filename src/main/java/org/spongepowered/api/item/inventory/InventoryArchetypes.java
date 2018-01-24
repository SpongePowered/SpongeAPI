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
    public static final InventoryArchetype SLOT = DummyObjectProvider.createFor(InventoryArchetype.class, "slot");

    /**
     * A row of Slots. 9 Slots by default.
     */
    public static final InventoryArchetype MENU_ROW = DummyObjectProvider.createFor(InventoryArchetype.class, "menu_row");

    /**
     * A grid of Slots.
     */
    public static final InventoryArchetype MENU_GRID = DummyObjectProvider.createFor(InventoryArchetype.class, "menu_grid");

    /**
     * A column of Slots.
     */
    public static final InventoryArchetype MENU_COLUMN = DummyObjectProvider.createFor(InventoryArchetype.class, "menu_column");

    /**
     * A Slot acting like a button.
     */
    public static final InventoryArchetype MENU_BUTTON = DummyObjectProvider.createFor(InventoryArchetype.class, "menu_button");

    /**
     * A Slot acting like an icon.
     */
    public static final InventoryArchetype MENU_ICON = DummyObjectProvider.createFor(InventoryArchetype.class, "menu_icon");

    /**
     * A Slot that can toggle between two icon states.
     */
    public static final InventoryArchetype MENU_CHECKBOX = DummyObjectProvider.createFor(InventoryArchetype.class, "menu_checkbox");

    /**
     * An icon Slot that can count up and down.
     */
    public static final InventoryArchetype MENU_SPINNER = DummyObjectProvider.createFor(InventoryArchetype.class, "menu_spinner");

    /**
     * A Players personal crafting area. Output with 2x2 Grid
     */
    public static final InventoryArchetype CRAFTING = DummyObjectProvider.createFor(InventoryArchetype.class, "crafting");

    // Vanilla Archetypes
    // These archetypes represent vanilla inventories. Generally these inventories can be shown to a player.
    // Changing the size of the inventory is possible but will almost always prevent displaying it to a player.

    // Grid-based

    /**
     * A Chest. Sizes from 9x1 to 9x6 are allowed. The default is 9x3.
     *
     * <p>When displaying the inventory the actual arrangement of slot
     * does not matter. This means, that when creating a 3x3 CHEST inventory it
     * will still be displayed as 9x1 to the player.</p>
     */
    public static final InventoryArchetype CHEST = DummyObjectProvider.createFor(InventoryArchetype.class, "chest");

    /**
     * A DoubleChest. Sizes 9x1 to 9x6 are allowed. The default is 9x6.
     */
    public static final InventoryArchetype DOUBLE_CHEST = DummyObjectProvider.createFor(InventoryArchetype.class, "double_chest");

    /**
     * A Hopper. The size is always 5x1
     */
    public static final InventoryArchetype HOPPER = DummyObjectProvider.createFor(InventoryArchetype.class, "hopper");

    /**
     * A Dispenser or Dropper. The size is always 3x3
     */
    public static final InventoryArchetype DISPENSER = DummyObjectProvider.createFor(InventoryArchetype.class, "dispenser");

    /**
     * A Workbench. The size is always 3x3 + 1 OutputSlot
     */
    public static final InventoryArchetype WORKBENCH = DummyObjectProvider.createFor(InventoryArchetype.class, "workbench");

    // Slot-based

    /**
     * A Furnace. The size is always 3 slots
     */
    public static final InventoryArchetype FURNACE = DummyObjectProvider.createFor(InventoryArchetype.class, "furnace");

    /**
     * A EnchantingTable. The size is always 2 slots.
     */
    public static final InventoryArchetype ENCHANTING_TABLE = DummyObjectProvider.createFor(InventoryArchetype.class, "enchanting_table");

    /**
     * A Anvil. The size is always 3 slots.
     */
    public static final InventoryArchetype ANVIL = DummyObjectProvider.createFor(InventoryArchetype.class, "anvil");

    /**
     * A BrewingStand. 5 Slots.
     */
    public static final InventoryArchetype BREWING_STAND = DummyObjectProvider.createFor(InventoryArchetype.class, "brewing_stand");

    /**
     * A Beacon. The size is always one slot.
     */
    public static final InventoryArchetype BEACON = DummyObjectProvider.createFor(InventoryArchetype.class, "beacon");

    // Entity

    /**
     * A RideableHorse, Donkey or Mule usually 2 Slots.
     */
    public static final InventoryArchetype HORSE = DummyObjectProvider.createFor(InventoryArchetype.class, "horse");

    /**
     * A Villager. The size is always 3 slots.
     */
    public static final InventoryArchetype VILLAGER = DummyObjectProvider.createFor(InventoryArchetype.class, "villager");

    /**
     * A Donkey or Mule with Chest. 2 Slots and 5x3 Chest
     * Needs a horse as carrier to show to player in Vanilla.
     */
    public static final InventoryArchetype HORSE_WITH_CHEST = DummyObjectProvider.createFor(InventoryArchetype.class, "horse_with_chest");

    // Player

    /**
     * A Player. Includes 9x3 main inventory, 9x1 Hotbar, 4 Armorslots and 2x2
     * Crafting area.
     *
     * <p>Cannot be opened by the server in Vanilla.</p>
     */
    public static final InventoryArchetype PLAYER = DummyObjectProvider.createFor(InventoryArchetype.class, "player");

    public static final InventoryArchetype UNKNOWN = DummyObjectProvider.createFor(InventoryArchetype.class, "unknown");

    /**
     * You should not be using this constructor, it will be made private in
     * API 8.
     *
     * @deprecated Will be made private in API 8
     */
    @Deprecated
    public InventoryArchetypes() throws AssertionError {
        //throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
