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
package org.spongepowered.api.item.inventory.slots;

import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.util.Direction;

/**
 * A slot which belongs to a particular side of a "sided" inventory.
 */
public interface SidedSlot extends Slot {

    /**
     * Get whether this slot can accept the specified item from the specified
     * direction.
     * 
     * @param stack Stack to check
     * @param from Direction to check for insertion from
     * @return true if this inventory can accept the supplied stack from the
     *      specified direction
     */
    boolean canAccept(ItemStack stack, Direction from);

    /**
     * Attempts to insert the supplied stack into this inventory from the
     * specified direction.
     * 
     * @see org.spongepowered.api.item.inventory.Inventory#offer(ItemStack)
     * @param stack Stack to insert
     * @param from Direction to check for insertion from
     * @return true if this inventory can accept the supplied stack from the
     *      specified direction
     */
    boolean offer(ItemStack stack, Direction from);

    /**
     * Get whether automation can extract the specified item from the specified
     * direction.
     * 
     * @param stack Stack to check
     * @param from Direction to check for retrieval from
     * @return true if automation can retrieve the supplied stack from the
     *      specified direction
     */
    boolean canGet(ItemStack stack, Direction from);
    
}
