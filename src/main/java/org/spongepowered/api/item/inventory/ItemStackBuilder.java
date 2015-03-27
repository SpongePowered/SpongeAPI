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

import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.data.ItemData;

/**
 * Represents a builder interface to create an {@link ItemStack}.
 */
public interface ItemStackBuilder {

    /**
     * Sets the {@link ItemType} of the item stack.
     *
     * @param itemType The type of item
     * @return This builder, for chaining
     */
    ItemStackBuilder itemType(ItemType itemType);

    /**
     * Sets the quantity of the item stack.
     *
     * @param quantity The quantity of the item stack
     * @return This builder, for chaining
     * @throws IllegalArgumentException If the quantity is outside the allowed bounds
     */
    ItemStackBuilder quantity(int quantity) throws IllegalArgumentException;

    /**
     * Sets the maximum quantity of the specific item stack.
     *
     * @param quantity The maximum quantity of the item stack
     * @return This builder, for chaining
     */
    ItemStackBuilder maxQuantity(int quantity);

    /**
     * Sets the {@link ItemData} to add to the item stack.
     *
     * @param itemData The item data to set
     * @param <T> The type of item data
     * @return This builder, for chaining
     * @throws IllegalArgumentException If the item data is incompatible with the item
     */
    <T extends ItemData<T>> ItemStackBuilder itemData(T itemData) throws IllegalArgumentException;

    /**
     * Creates a new builder with the given ItemStack as a blueprint with
     * all the defaults.
     *
     * @param itemStack The item stack to copy
     * @return This builder, for chaining
     */
    ItemStackBuilder fromItemStack(ItemStack itemStack);

    /**
     * Resets all information regarding the item stack to be created.
     *
     * @return This builder, for chaining
     */
    ItemStackBuilder reset();

    /**
     * Builds an instance of an ItemStack.
     *
     * @return A new instance of an ItemStack
     * @throws IllegalStateException If the item stack is not completed
     */
    ItemStack build() throws IllegalStateException;
    
}
