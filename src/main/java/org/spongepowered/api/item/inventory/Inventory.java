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

package org.spongepowered.api.item.inventory;

import java.util.HashMap;
import java.util.List;

import org.spongepowered.api.entity.HumanEntity;
import org.spongepowered.api.item.ItemType;

/**
 * Represents some type of inventories.
 */
public interface Inventory extends Iterable<ItemStack> {

    /**
     * Gets the Inventory title.
     * 
     * @return The inventory title
     */
    String getTitle();

    /**
     * Get the inventory type.
     * 
     * @return The type
     */
    InventoryType getType();

    /**
     * Check for item matching given ItemStack.
     * 
     * @param ItemStack
     * @return true if item exist in inventory
     */
    boolean hasItem(ItemStack itemStack);
    
    /**
     * Check for item matching given {@link ItemType}.
     * 
     * @param ItemStack
     * @return true if item exist in inventory
     */
    boolean hasItem(ItemType type);

    /**
     * Check for particular amount of items matching given ItemStack.
     * 
     * @param ItemStack
     * @param amount of required item
     * @return true if item exist in inventory
     */
    boolean hasItem(ItemStack itemStack, int amount);

    /**
     * Check for particular amount of items matching given {@link ItemType}.
     * 
     * @param ItemStack
     * @param Item requested amount
     * @return true if item exist in inventory
     */
    boolean hasItem(ItemType type, int amount);

    /**
     * Returns all ItemStacks.
     * 
     * @return ItemStack array
     */
    ItemStack[] getContents();

    /**
     * Sets inventory content.
     * 
     * @param items array
     */
    void setContents(ItemStack[] contents);

    /**
     * Gets {@link ItemStack} from particular slot.
     * 
     * @param The index of the slot ItemStack
     * @return the ItemStack
     */
    ItemStack getItem(int slot);

    /**
     * Add the given ItemStacks to the inventory. This will fill
     * existing stacks and empty slots as much as it's possible.
     * 
     * <p>The returned HashMap contains items which it couldn't store.</p>
     * 
     * @param itemStack
     */
    HashMap<Integer, ItemStack> addItem(ItemStack... items);

    /**
     * Set the {@link ItemStack} in particular slot.
     * 
     * @param Slot index
     * @param ItemStack
     */
    void setItem(ItemStack itemStack, int slot);

    /**
     * Removes all stacks in the inventory matching the given stack.
     * 
     * @param ItemStack
     */
    void remove(ItemStack itemStack);

    /**
     * Removes all stacks in the inventory matching the given {@link ItemType}.
     * 
     * @param The id
     */
    void remove(ItemType type);

    /**
     * Clears out whole Inventory.
     */
    void clear();

    /**
     * Clears out a particular slot.
     * 
     * @param Slot index
     */
    void clear(int slot);
    
    /**
     * Returns the first free slot
     * 
     * @return The first free slot id, or -1 if there is no empty slots.
     */
    int getFirstFree();

    /**
     * Gets a list of viewers.
     * 
     * @return The list of viewers
     */
    List<HumanEntity> getViewers();

    /**
     * Returns HashMap with slots and ItemStacks with given ItemType.
     * 
     * @param Item Type
     * @return HashMap with found items 
     */
    HashMap<Integer, ItemStack> search(ItemType type);

    /**
     * Returns HashMap with slots and ItemStacks matching given ItemStack.
     * 
     * @param Item Type
     * @return HashMap with found items 
     */
    HashMap<Integer, ItemStack> search(ItemStack itemStack);

}
