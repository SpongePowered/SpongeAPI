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

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.Player;
import org.spongepowered.api.inventory.view.InventoryViewPlayer;

import javax.annotation.Nullable;

/**
 * Manage all {@link org.spongepowered.api.inventory.InventoryView}
 */
public interface InventorySystem {

    /**
     * @param entity a entity
     *
     * @return the Inventory or null
     */
    @Nullable
    InventoryView getInventory(Entity entity);

    /**
     * Try to get a vanilla Player Inventory from the player
     *
     * @param player to fetch a vanilla inventory
     *
     * @return vanilla player inventory or null if failed
     */
    // TODO: maybe throw exception?
    @Nullable
    InventoryViewPlayer getInventory(Player player);

    /**
     * @param component Inventory Part
     * @param slot      abstract slot
     *
     * @return item (if empty air)
     */
    ItemStack getItem(InventoryComponent component, SlotType slot);

    /**
     * @param component Inventory Part
     * @param slot      abstract slot
     * @param stack     Item for replacement
     *
     * @return item was set
     */
    boolean setItem(InventoryComponent component, SlotType slot, ItemStack stack);

    /**
     * @param component Inventory Part
     * @param slot      raw slot index
     *
     * @return item (if empty air)
     */
    ItemStack getItem(InventoryComponent component, int slot);

    /**
     * @param component Inventory Part
     * @param slot      raw slot index
     * @param stack     item for replacement
     *
     * @return item was set
     */
    boolean setItem(InventoryComponent component, int slot, ItemStack stack);

    /**
     * clear the content of the component.
     *
     * @param component Inventory Part
     */
    void clear(InventoryComponent component);

}
