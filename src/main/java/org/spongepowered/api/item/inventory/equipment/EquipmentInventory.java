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
package org.spongepowered.api.item.inventory.equipment;

import org.spongepowered.api.item.inventory.Equipable;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.item.inventory.transaction.InventoryTransactionResult;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Equipment inventory for {@link Equipable}s that can carry equipment.
 */
public interface EquipmentInventory extends Inventory {

    /**
     * Returns the holder of this Inventory. It can be an entity, block, or other object.
     *
     * @return This inventory's carrier
     */
    Optional<Equipable> getCarrier();

    /**
     * Gets and remove the stack for the specified equipment type in this
     * Inventory.
     *
     * @see Inventory#poll()
     * @param equipmentType Type of equipment slot to query for
     * @return removed ItemStack, per the semantics of {@link Inventory#poll()}
     */
     InventoryTransactionResult.Poll poll(EquipmentType equipmentType);

     default InventoryTransactionResult.Poll poll(final Supplier<? extends EquipmentType> equipmentType) {
         return poll(equipmentType.get());
     }

    /**
     * Gets and remove the items from the stack for the specified equipment type
     * in this Inventory.
     *
     * @see Inventory#poll()
     * @param equipmentType Type of equipment slot to query for
     * @param limit item limit
     * @return removed ItemStack, per the semantics of {@link Inventory#poll()}
     */
    InventoryTransactionResult.Poll poll(EquipmentType equipmentType, int limit);

    default InventoryTransactionResult.Poll poll(final Supplier<? extends EquipmentType> equipmentType, final int limit) {
        return poll(equipmentType.get(), limit);
    }

    /**
     * Gets without removing the stack for the specified equipment type in this
     * Inventory.
     *
     * @see Inventory#peek()
     * @param equipmentType Type of equipment slot to query for
     * @return removed ItemStack, per the semantics of {@link Inventory#peek()}
     */
    Optional<ItemStack> peek(EquipmentType equipmentType);

    default Optional<ItemStack> peek(final Supplier<? extends EquipmentType> equipmentType) {
        return peek(equipmentType.get());
    }

    /**
     * Sets the item for the specified equipment type.
     *
     * @see Slot#set(ItemStack)
     * @param equipmentType Type of equipment slot to set
     * @param stack stack to insert
     * @return operation result, for details see {@link Inventory#set}
     */
    InventoryTransactionResult set(EquipmentType equipmentType, ItemStack stack);

    default InventoryTransactionResult set(final Supplier<? extends EquipmentType> equipmentType, final ItemStack stack) {
        return set(equipmentType.get(), stack);
    }

    /**
     * Gets the {@link Slot} for the specified equipment type.
     *
     * @param equipmentType Type of equipment slot to set
     * @return matching slot or {@link Optional#empty()} if no matching slot
     */
    Optional<Slot> getSlot(EquipmentType equipmentType);

    default Optional<Slot> getSlot(final Supplier<? extends EquipmentType> equipmentType) {
        return getSlot(equipmentType.get());
    }

}
