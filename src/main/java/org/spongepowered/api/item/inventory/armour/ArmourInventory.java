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
package org.spongepowered.api.item.inventory.armour;

import org.spongepowered.api.entity.ArmorEquipable;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.item.inventory.properties.ArmourSlotType;
import org.spongepowered.api.item.inventory.types.CarriedInventory;
import org.spongepowered.api.item.inventory.types.OrderedInventory;

import com.google.common.base.Optional;


/**
 * Armour inventory for {@link org.spongepowered.api.item.inventory.Carrier}s
 * that can wear armour.
 */
public interface ArmourInventory extends OrderedInventory, CarriedInventory<ArmorEquipable> {

    /**
     * Get and remove the stack for the specified armour type in this Inventory
     */
    public abstract Optional<ItemStack> get(ArmourSlotType armourType);

    /**
     * Get and remove the stack for the specified armour type in this Inventory
     */
    public abstract Optional<ItemStack> get(ArmourType armourType);
    
    /**
     * Get without removing the stack for the specified armour type in this
     * Inventory
     */
    public abstract Optional<ItemStack> peek(ArmourSlotType armourType);
    
    /**
     * Get without removing the stack for the specified armour type in this
     * Inventory
     */
    public abstract Optional<ItemStack> peek(ArmourType armourType);

    /**
     * Set the item for the specified armour type 
     */
    public abstract void set(ArmourSlotType armourType, ItemStack stack);

    /**
     * Set the item for the specified armour type 
     */
    public abstract void set(ArmourType armourType, ItemStack stack);
    
    /**
     * Get the {@link Slot} for the specified armour type
     */
    public abstract Optional<Slot> getSlot(ArmourSlotType armourType);
    
    /**
     * Get the {@link Slot} for the specified armour type
     */
    public abstract Optional<Slot> getSlot(ArmourType armourType);

}
