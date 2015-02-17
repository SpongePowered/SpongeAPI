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

import com.google.common.base.Optional;
import org.spongepowered.api.item.inventory.Carrier;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.api.util.Identifiable;

import javax.annotation.Nullable;

/**
 * Represents an entity that has an EquipmentInventory.
 */
public interface Equipable extends Identifiable, Carrier {
    
    /**
     * Get whether this entity can equip equipment of the specified type (eg.
     * whether calling {@link #equip} will fail because the entity doesn't
     * have this type of slot. 
     * 
     * @param type The type of equipment slot to query
     * @return true if this entity can equip items of the specified type
     */
    boolean canEquip(EquipmentType type);
    
    /**
     * Get whether this entity can equip the supplied equipment in its slot of
     * the specified type (eg. whether calling {@link #equip} with the specified
     * slot type and item will succeed)
     * 
     * @param type The type of equipment slot to query
     * @param equipment The equipment to check for
     * @return true if can equip the supplied equipment
     */
    boolean canEquip(EquipmentType type, @Nullable ItemStack equipment);
    
    /**
     * Gets the item currently equipped by this entity in the specified slot.
     *
     * @param type The type of equipment slot to query
     * @return The item in the equipped slot, if available
     */
    Optional<ItemStack> getEquipped(EquipmentType type);

    /**
     * Sets the item currently equipped by the entity in the specified slot, if
     * the entity has such a slot.
     * 
     * <p>Supplying null will unequip any currently equipped item.</p>
     *
     * @param type The type of equipment slot to set
     * @param equipment The equipment to set or null to remove any equipped item
     * @return true if the item was successfully equipped, false if the item
     *      could not be equipped because the entity doesn't support the
     *      specified equipment type or because the item was incompatible with
     *      the specified slot. 
     */
    boolean equip(EquipmentType type, @Nullable ItemStack equipment);

}
