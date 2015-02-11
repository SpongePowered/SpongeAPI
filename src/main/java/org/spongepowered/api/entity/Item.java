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

package org.spongepowered.api.entity;

import org.spongepowered.api.item.inventory.ItemStack;

/**
 * Represents an Item entity.
 */
public interface Item extends Entity, TimedDespawnable, Owned {

    /**
     * Get the {@link ItemStack} that this item represents.
     *
     * @return The represented {@link ItemStack}
     */
    ItemStack getItemStack();

    /**
     * Gets the number of ticks remaining until this item can be picked up,
     * or -1 if this item has an infinite pickup delay.
     *
     * @return The number of ticks remaining, or -1
     */
    int getPickupDelay();

    /**
     * Sets the number of ticks remaining until this item can be picked up.
     *
     * <p>If this item currently has an infinite pickup delay, the infinite
     * pickup delay will be removed, and delay will be set instead.</p>
     *
     * @param delay The number of ticks remaining
     */
    void setPickupDelay(int delay);

}
