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

import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.api.text.translation.Translatable;

/**
 * Represents a stack of a specific {@link ItemType}. Supports serialization and
 * can be compared using the comparators listed in {@link ItemStackComparators}.
 *
 * <p>{@link ItemStack}s have varying properties and data, it is adviseable to
 * use {@link DataHolder#get(Class)} to retrieve different information
 * regarding this item stack.</p>
 */
public interface ItemStack extends DataHolder, DataSerializable, TextRepresentable, Translatable {

    /**
     * Gets the {@link ItemType} of this {@link ItemStack}.
     *
     * @return The item type
     */
    ItemType getItem();

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
     * {@link ItemType#getMaxStackQuantity()}, unless a
     * different value has been set for this specific stack.
     *
     * @return Max stack quantity
     */
    int getMaxStackQuantity();

    @Override
    ItemStack copy();
}
