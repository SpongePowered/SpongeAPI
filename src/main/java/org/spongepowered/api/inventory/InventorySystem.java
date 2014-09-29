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
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.Player;
import org.spongepowered.api.inventory.view.InventoryViewPlayer;

/**
 * Manage all {@link InventoryView}. Main class for the inventory system.
 * All Components used this class to change values.
 */
public interface InventorySystem {

    /**
     * @param entity Minecraft Entity, in the future it can be ANY GameObject
     *
     * @return Optional an inventory view
     */
    Optional<InventoryView> getInventory(Entity entity);

    /**
     * Tries to get a vanilla player inventory from the player.
     *
     * @param player Player for vanilla inventory fetching
     *
     * @return Optional a vanilla player inventory
     */
    Optional<InventoryViewPlayer> getInventory(Player player);

    /**
     * Tries to fetch an item from a part of an inventory and a specific slot.
     *
     * @param component Inventory Part
     * @param slot Abstract slot
     *
     * @return Optional item stack for the given slot
     */
    Optional<ItemStack> getItem(InventoryComponent component, SlotType slot);

    /**
     * Replaces the item at the slot.
     *
     * @param component Inventory Part
     * @param slot Abstract slot
     * @param stack Item for replacement
     */
    void setItem(InventoryComponent component, SlotType slot, ItemStack stack);

    /**
     * Tries to fetch an item from a part of an inventory and a specific slot.
     *
     * @param component Inventory Part
     * @param slot Raw slot index
     *
     * @return Optional item stack for the given slot
     */
    Optional<ItemStack> getItem(InventoryComponent component, int slot);

    /**
     * Replaces the item at the slot index.
     *
     * @param component Inventory Part
     * @param slot Raw slot index
     * @param stack Item for replacement
     *
     * @return item was set
     */
    boolean setItem(InventoryComponent component, int slot, ItemStack stack);

    /**
     * Clears the content of a component.
     *
     * @param component Inventory Part
     */
    void clear(InventoryComponent component);

}
