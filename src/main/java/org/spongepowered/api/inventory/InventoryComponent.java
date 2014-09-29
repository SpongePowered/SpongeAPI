/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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
package org.spongepowered.api.inventory;

import com.google.common.base.Optional;

/**
 * Describes a logic subpart of an inventory, e.g. CrafingGrid.
 */
public interface InventoryComponent extends Iterable<ItemStack> {

    /**
     * @return Amount of slots.
     */
    int getSlotCount();

    /**
     * Calls {@link InventorySystem#getItem(InventoryComponent, SlotType)}.
     * Try to fetch an item from a part of an inventory and a specific slot.
     *
     * @param type Abstraction for the slot index
     *
     * @return Optional an item stack for a {@link SlotType}
     */
    Optional<ItemStack> getItem(SlotType type);

    /**
     * Calls {@link InventorySystem#setItem(InventoryComponent, SlotType, ItemStack)}.
     * Replaces the item at the slot.
     *
     * @param slot Abstract slot
     * @param stack Item for replacement
     */
    boolean setItem(SlotType slot, ItemStack stack);

    /**
     * Calls {@link InventorySystem#getItem(InventoryComponent, int)}.
     * Tries to fetch an item from a part of an inventory and a specific slot.
     *
     * @param slot Raw slot count for the component
     *
     * @return Optional an item stack for the raw slot index
     */
    Optional<ItemStack> getItem(int slot);

    /**
     * Calls {@link InventorySystem#setItem(InventoryComponent, int, ItemStack)}.
     * Replaces the item at the slot.
     *
     * @param slot Raw slot index
     * @param stack Item for replacement
     *
     * @return item was set
     */
    boolean setItem(int slot, ItemStack stack);

    /**
     * Calls {@link InventorySystem#clear(InventoryComponent)}.
     * Clears the content of a component.
     */
    void clear();

    /**
     * @return Gets first free slot.
     */
    SlotType getFirstFreeSlot();

    /**
     * @return Entity/Parent/Inventory
     */
    InventoryView getInventory();
}
