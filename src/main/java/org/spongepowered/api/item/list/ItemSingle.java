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

import org.spongepowered.api.item.inventory.ItemStack;

/**
 * An ItemSingle is a single-item slot; therefore it has methods to modify
 * the single item in its slot.
 */
public interface ItemSingle extends ItemList {

    /**
     * Gets the item in this ItemSingle.
     *
     * @return The item in this slot
     */
    ItemStack getItem();

    /**
     * Sets the item in this ItemSingle.
     *
     * @param stack The new stack to set in this slot
     */
    void setItem(ItemStack stack);

    /**
     * Takes {@code count} items away from the ItemStack in this ItemSingle
     * and returns them as a new ItemStack.
     *
     * @param count The number of items to remove from the ItemStack
     * @return The items that have been taken out as a new ItemStack
     */
    ItemStack splitItem( int count);

}
