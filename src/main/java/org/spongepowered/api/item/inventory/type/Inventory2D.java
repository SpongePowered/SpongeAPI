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
package org.spongepowered.api.item.inventory.type;

import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.item.inventory.transaction.InventoryTransactionResult;
import org.spongepowered.math.vector.Vector2i;

import java.util.Optional;

/**
 * Base interface for inventories with slots obtainable via SlotPos queries.
 */
public interface Inventory2D extends Inventory {

    /**
     * Gets and remove the stack at the supplied position in this Inventory.
     *
     * @see Inventory#poll()
     * @param pos Slot position to query
     * @return matching stacks, as per the semantics of {@link Inventory#poll()}
     */
    default InventoryTransactionResult.Poll poll(Vector2i pos) {
        return getSlot(pos).map(Inventory::poll).orElse(InventoryTransactionResult.builder().type(InventoryTransactionResult.Type.NO_SLOT).poll(ItemStackSnapshot.empty()).build());
    }

    /**
     * Gets and remove the stack at the supplied position in this Inventory.
     *
     * @see Inventory#poll()
     * @param pos Slot position to query
     * @param limit item limit
     * @return matching stacks, as per the semantics of {@link Inventory#poll()}
     */
    default InventoryTransactionResult.Poll poll(Vector2i pos, int limit) {
        return getSlot(pos).map(slot -> slot.poll(limit)).orElse(InventoryTransactionResult.builder().type(InventoryTransactionResult.Type.NO_SLOT).poll(ItemStackSnapshot.empty()).build());
    }

    /**
     * Gets without removing the stack at the supplied position in this
     * Inventory.
     *
     * @see Inventory#peek()
     * @param pos Slot position to query
     * @return matching stacks, as per the semantics of {@link Inventory#peek()}
     */
    default Optional<ItemStack> peek(Vector2i pos) {
        return getSlot(pos).map(Inventory::peek);
    }

    /**
     * Sets the item in the specified slot.
     *
     * @see Slot#set(ItemStack)
     * @param pos Slot position to set
     * @param stack Stack to insert
     * @return matching stacks, as per the semantics of {@link Inventory#set}
     */
    default InventoryTransactionResult set(Vector2i pos, ItemStack stack) {
        return getSlot(pos).map(slot -> slot.set(stack)).orElse(InventoryTransactionResult.failNoTransactions());
    }

    /**
     * Gets the {@link Slot} at the specified position.
     *
     * @param pos Slot position to retrieve
     * @return slot at the specified position, or {@link Optional#empty()} if
     *      no matching slot
     */
    Optional<Slot> getSlot(Vector2i pos);

}
