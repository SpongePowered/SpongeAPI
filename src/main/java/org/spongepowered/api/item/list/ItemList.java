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
package org.spongepowered.api.item.list;

import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;

import java.util.Collection;

/**
 * An ItemList represents a list of ItemStacks.
 */
public interface ItemList extends Iterable<ItemStack> {

    /**
     * Returns the size of this ItemList.
     *
     * @return The size of this list
     */
    int getSize();

    /**
     * Returns whether this ItemList is empty.
     *
     * @return True if this list is empty
     */
    boolean isEmpty();

    /**
     * Checks for whether the given stack is contained in this ItemList.
     *
     * @param stack The stack to check for
     * @return True if the stack is present in this list
     */
    boolean contains(ItemStack stack);

    /**
     * Checks for whether there is a stack in this ItemList with the given
     * ItemType.
     *
     * @param type The type to search for
     * @return True if at least one stack in this list has the given type
     */
    boolean contains(ItemType type);

    /**
     * Returns the maximum size of any stack in this ItemList.
     *
     * @return The maximum stack size of this list
     */
    int getMaxStackSize();

    /**
     * Sets the maximum stack size of any stack in this ItemList.
     *
     * @param size The new maximum stack size
     */
    void setMaxStackSize(int size);

    /**
     * Gets an item at an index in this ItemList.
     *
     * @param index The index to get the item
     * @return The item in that index
     */
    ItemStack getItem(int index);

    /**
     * Sets an item at an index in this ItemList.
     *
     * @param index The index to set the item
     * @param stack The new stack to set into that index
     */
    void setItem(int index, ItemStack stack);

    /**
     * Removes an item from an index in this ItemList.
     *
     * @param index The index to remove the item from
     */
    void remove(int index);

    /**
     * Clears this ItemList.
     */
    void clear();

    /**
     * Takes {@code count} items away from the ItemStack in {@code index}
     * and returns them as a new ItemStack.
     *
     * @param index The index for the item stack to take away from
     * @param count The number of items to remove from the ItemStack
     * @return The items that have been taken out as a new ItemStack
     */
    ItemStack splitItem(int index, int count);

    /**
     * Returns the contents of this ItemList, as a Collection.
     *
     * @return The contents of this ItemList
     */
    Collection<ItemStack> getContents();

}
