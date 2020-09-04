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
package org.spongepowered.api.item.inventory;

import org.spongepowered.api.item.inventory.equipment.EquipmentInventory;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Represents the holder of a {@link EquipmentInventory}.
 */
public interface Equipable {

    /**
     * Returns the EquipmentInventory this is holding.
     *
     * @return The EquipmentInventory this is holding
     */
    EquipmentInventory getEquipment();

    /**
     * Gets whether this {@link Equipable} can equip equipment of the specified type (eg.
     * whether calling {@link #equip} will fail because the equipable doesn't
     * have this type of slot.
     *
     * @param type The type of equipment slot to query
     * @return true if this equipable can equip items of the specified type
     */
    boolean canEquip(EquipmentType type);

    default boolean canEquip(final Supplier<? extends EquipmentType> type) {
        return canEquip(type.get());
    }

    /**
     * Gets whether this {@link Equipable} can equip the supplied equipment in its slot of
     * the specified type (eg. whether calling {@link #equip} with the specified
     * slot type and item will succeed)
     *
     * @param type The type of equipment slot to query
     * @param equipment The equipment to check for
     * @return true if can equip the supplied equipment
     */
    boolean canEquip(EquipmentType type, ItemStack equipment);

    default boolean canEquip(final Supplier<? extends EquipmentType> type, final ItemStack equipment) {
        return canEquip(type.get(), equipment);
    }


    /**
     * Gets the item currently equipped by this {@link Equipable} in the specified slot.
     *
     * @param type The type of equipment slot to query
     * @return The item in the equipped slot, if available
     */
    Optional<ItemStack> getEquipped(EquipmentType type);

    default Optional<ItemStack> getEquipped(final Supplier<? extends EquipmentType> type) {
        return getEquipped(type.get());
    }

    /**
     * Sets the item currently equipped by the {@link Equipable} in the specified slot, if
     * the equipable has such a slot.
     *
     * @param type The type of equipment slot to set
     * @param equipment The equipment to set the any equipped item
     * @return true if the item was successfully equipped, false if the item
     *     could not be equipped because the equipable doesn't support the
     *     specified equipment type or because the item was incompatible with
     *     the specified slot.
     */
    boolean equip(EquipmentType type, ItemStack equipment);

    default boolean equip(final Supplier<? extends EquipmentType> type, final ItemStack equipment) {
        return equip(type.get(), equipment);
    }
}
