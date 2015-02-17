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
package org.spongepowered.api.item.inventory.equipment;

import com.google.common.base.Optional;
import org.spongepowered.api.entity.ArmorEquipable;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.item.inventory.properties.EquipmentSlotType;
import org.spongepowered.api.item.inventory.transaction.InventoryOperationResult;
import org.spongepowered.api.item.inventory.types.CarriedInventory;
import org.spongepowered.api.item.inventory.types.OrderedInventory;

/**
 * Equipment inventory for {@link org.spongepowered.api.item.inventory.Carrier}s
 * that can carry equipment.
 */
public interface EquipmentInventory extends OrderedInventory, CarriedInventory<ArmorEquipable> {

    /**
     * Get and remove the stack for the specified equipment type in this
     * Inventory.
     * 
     * @see Inventory#poll()
     * @param equipmentType Type of equipment slot to query for
     * @return removed ItemStack, per the semantics of {@link Inventory#poll()}
     */
    Optional<ItemStack> poll(EquipmentSlotType equipmentType);

    /**
     * Get and remove the items from the stack for the specified equipment type
     * in this Inventory.
     * 
     * @see Inventory#poll()
     * @param equipmentType Type of equipment slot to query for
     * @param limit item limit
     * @return removed ItemStack, per the semantics of {@link Inventory#poll()}
     */
    Optional<ItemStack> poll(EquipmentSlotType equipmentType, int limit);

    /**
     * Get and remove the stack for the specified equipment type in this
     * Inventory.
     * 
     * @see Inventory#poll()
     * @param equipmentType Type of equipment slot to query for
     * @return removed ItemStack, per the semantics of {@link Inventory#poll()}
     */
    Optional<ItemStack> poll(EquipmentType equipmentType);

    /**
     * Get and remove the items from the stack for the specified equipment type
     * in this Inventory.
     * 
     * @see Inventory#poll()
     * @param equipmentType Type of equipment slot to query for
     * @param limit item limit
     * @return removed ItemStack, per the semantics of {@link Inventory#poll()}
     */
    Optional<ItemStack> poll(EquipmentType equipmentType, int limit);

    /**
     * Get without removing the stack for the specified equipment type in this
     * Inventory.
     * 
     * @see Inventory#peek()
     * @param equipmentType Type of equipment slot to query for
     * @return removed ItemStack, per the semantics of {@link Inventory#peek()}
     */
    Optional<ItemStack> peek(EquipmentSlotType equipmentType);

    /**
     * Get without removing the items from the stack for the specified equipment
     * type in this Inventory.
     * 
     * @see Inventory#peek()
     * @param equipmentType Type of equipment slot to query for
     * @param limit item limit
     * @return removed ItemStack, per the semantics of {@link Inventory#peek()}
     */
    Optional<ItemStack> peek(EquipmentSlotType equipmentType, int limit);

    /**
     * Get without removing the stack for the specified equipment type in this
     * Inventory.
     * 
     * @see Inventory#peek()
     * @param equipmentType Type of equipment slot to query for
     * @return removed ItemStack, per the semantics of {@link Inventory#peek()}
     */
    Optional<ItemStack> peek(EquipmentType equipmentType);

    /**
     * Get without removing the items from the stack for the specified equipment
     * type in this Inventory.
     * 
     * @see Inventory#peek()
     * @param equipmentType Type of equipment slot to query for
     * @param limit item limit
     * @return removed ItemStack, per the semantics of {@link Inventory#peek()}
     */
    Optional<ItemStack> peek(EquipmentType equipmentType, int limit);

    /**
     * Set the item for the specified equipment type.
     * 
     * @see Inventory#set(ItemStack)
     * @param equipmentType Type of equipment slot to set
     * @param stack stack to insert
     * @return operation result, for details see {@link Inventory#set}
     */
    InventoryOperationResult set(EquipmentSlotType equipmentType, ItemStack stack);

    /**
     * Set the item for the specified equipment type.
     * 
     * @see Inventory#set(ItemStack)
     * @param equipmentType Type of equipment slot to set
     * @param stack stack to insert
     * @return operation result, for details see {@link Inventory#set}
     */
    InventoryOperationResult set(EquipmentType equipmentType, ItemStack stack);

    /**
     * Get the {@link Slot} for the specified equipment type.
     * 
     * @param equipmentType Type of equipment slot to set
     * @return matching slot or {@link Optional#absent()} if no matching slot
     */
    Optional<Slot> getSlot(EquipmentSlotType equipmentType);

    /**
     * Get the {@link Slot} for the specified equipment type.
     * 
     * @param equipmentType Type of equipment slot to set
     * @return matching slot or {@link Optional#absent()} if no matching slot
     */
    Optional<Slot> getSlot(EquipmentType equipmentType);

}
