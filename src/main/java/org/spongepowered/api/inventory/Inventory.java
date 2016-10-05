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

import java.util.Collection;
import java.util.List;

/**
 * Represents any inventory:
 *
 * <ul>
 * <li>Block-based inventory (i.e. chest, furnace, anvil...)</li>
 * <li>Player inventory</li>
 * <li>Mob inventory (i.e. mule)</li>
 * </ul>
 */
public interface Inventory {

    /**
     * Add one or more {@link ItemStack}s to the inventory.
     *
     * @param items {@link ItemStack}(s) to add to the contents.
     * @return {@link Collection} of remaining {@link ItemStack}s that couldn't fit
     * @throws IllegalArgumentException When empty varargs array given
     */
    Collection<ItemStack> addItem(ItemStack... items) throws IllegalArgumentException;

    /**
     * Gets a {@link List} of {@link ItemStack}s in the inventory.
     *
     * @return {@link List} of items
     */
    List<ItemStack> getContents();

    /**
     * Checks whether the inventory contains.
     *
     * @param item {@link ItemStack} to match
     * @return Quantity of matching items found
     */
    int contains(ItemStack item);

    /**
     * Remove a specific quantity and type of item.
     *
     * <p>If given an {@link ItemStack} with ID minecraft:stone, quantity: 128, we'll
     * remove as many stone items as found, up to 128. The quantity
     * returned may not match the quantity desired.</p>
     *
     * @param item {@link ItemStack} to match
     * @return {@link ItemStack} of matched items or null if none
     */
    ItemStack remove(ItemStack item);

    /**
     * Remove a specific {@link ItemStack} at a given index.
     *
     * @param index Index of contents {@link List}
     * @return {@link ItemStack} currently at index, or null if empty
     */
    ItemStack remove(int index);

    /**
     * Clear the entire inventory.
     */
    void clear();

    /**
     * Get the number of available slots in this inventory.
     *
     * @return Number of all available slots no matter their contents
     */
    int getSize();

}