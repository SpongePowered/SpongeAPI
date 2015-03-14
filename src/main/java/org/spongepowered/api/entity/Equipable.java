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
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.api.item.inventory.slots.EquipmentSlot;
import org.spongepowered.api.util.Identifiable;

import javax.annotation.Nullable;

/**
 * Represents an entity that has an EquipmentInventory.
 */
public interface Equipable extends Identifiable, Carrier {
    
    /**
     * Get whether this entity can equip equipment of the specified type (eg.
     * whether calling {@link EquipmentSlot#isValidItem(EquipmentType)} will fail because the entity doesn't
     * have this type of slot. 
     * 
     * @param type The type of equipment slot to query
     * @return true if this entity can equip items of the specified type
     */
    boolean canEquip(EquipmentType type);
    
    /**
     * Gets the inventory currently equipped by this entity in the specified slot.
     *
     * <p>In Vanilla, the returned {@link Inventory} can be queried for {@link EquipmentSlot}.</p>
     *
     * @param type The type of equipment slot to query
     * @return The inventory in the equipped slot, if available
     */
    Inventory getEquipped(EquipmentType type);

}
