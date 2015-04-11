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
package org.spongepowered.api.util;

import org.spongepowered.api.item.inventory.ItemStack;

/**
 * Represents an item stack with a range of possible quantities and a numerical weight used for random selection
 * from a collection of weighted types.
 */
public interface WeightedRandomItemStack {

    /**
     * Gets the {@link ItemStack}. The quantity of the item will be ignored and
     * instead set to a value randomly selected from between
     * {@link #getMinimumQuantity()} (inclusive) and
     * {@link #getMaximumQuantity()} (exclusive).
     *
     * @return The item stack
     */
    ItemStack getItemStack();

    /**
     * Gets the minimum quantity of the item to spawn.
     * 
     * @return The minimum quantity
     */
    int getMinimumQuantity();

    /**
     * Gets the maximum quantity of the item to spawn.
     * 
     * @return The maximum quantity
     */
    int getMaximumQuantity();

    /**
     * Gets the weight of this item.
     *
     * @return The weight
     */
    int getWeight();

}
