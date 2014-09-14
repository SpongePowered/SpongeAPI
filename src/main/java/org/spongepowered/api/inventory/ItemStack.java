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

import org.spongepowered.api.item.Item;

import java.io.Serializable;

/**
 * Represents a stack of a specific {@link Item}. Allows comparison to another
 * ItemStack, and supports serialization.
 */
public interface ItemStack extends Comparable<ItemStack>, Serializable {

    /**
     * Gets the {@link Item} item type.
     *
     * @return The item type
     */
    Item getItem();

    /**
     * Get the damage/durability value.
     *
     * @return The item's damage value
     */
    short getDamage();

    /**
     * Set the damage/durability.
     *
     * @param damage The value that the damage should be set to
     */
    void setDamage(short damage);

    /**
     * Gets the quantity of items in this stack. This may exceed the max stack
     * size of the item, and if added to an inventory will then be divided by
     * the max stack.
     *
     * @return Quantity of items
     */
    int getQuantity();

    /**
     * Sets the quantity in this stack.
     *
     * @param quantity Quantity
     * @throws IllegalArgumentException If quantity set exceeds the
     * {@link ItemStack#getMaxStackQuantity()}
     */
    void setQuantity(int quantity) throws IllegalArgumentException;

    /**
     * Get the maximum quantity per stack. By default, returns
     * {@link Item#getMaxStackQuantity()}, unless a
     * different value has been set for this specific stack.
     *
     * @return Max stack quantity
     */
    int getMaxStackQuantity();

    /**
     * Set the max quantity per stack. This overrides, and is entirely separate
     * from {@link Item#getMaxStackQuantity()}.
     *
     * @param quantity Max stack quantity
     */
    void setMaxStackQuantity(int quantity);

}
