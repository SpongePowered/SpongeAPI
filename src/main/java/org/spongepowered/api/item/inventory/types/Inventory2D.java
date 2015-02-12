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
package org.spongepowered.api.item.inventory.types;

import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.item.inventory.properties.SlotPos;
import org.spongepowered.api.item.inventory.transaction.InventoryOperationResult;

import com.google.common.base.Optional;


/**
 * Base interface for inventories with slots obtainable via SlotPos queries
 */
public interface Inventory2D extends OrderedInventory {

    /**
     * Get and remove the stack at the supplied position in this Inventory
     */
    Optional<ItemStack> poll(SlotPos pos);

    /**
     * Get and remove the stack at the supplied position in this Inventory
     */
    Optional<ItemStack> poll(SlotPos pos, int limit);
    
    /**
     * Get without removing the stack at the supplied position in this Inventory
     */
    Optional<ItemStack> peek(SlotPos pos);
    
    /**
     * Get without removing the stack at the supplied position in this Inventory
     */
    Optional<ItemStack> peek(SlotPos pos, int limit);

    /**
     * Set the item in the specified slot 
     */
    InventoryOperationResult set(SlotPos pos, ItemStack stack);
    
    /**
     * Get the {@link Slot} at the specified position
     */
    Optional<Slot> getSlot(SlotPos pos);

}
