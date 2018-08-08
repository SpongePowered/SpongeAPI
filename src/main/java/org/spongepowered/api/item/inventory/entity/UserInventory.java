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
package org.spongepowered.api.item.inventory.entity;

import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.item.inventory.equipment.EquipmentInventory;
import org.spongepowered.api.item.inventory.type.CarriedInventory;
import org.spongepowered.api.item.inventory.type.GridInventory;

/**
 * Represents the inventory of a {@link User}.
 * It consists of a {@link PrimaryPlayerInventory} (containing the main {@link GridInventory}
 * and the {@link Hotbar}) and an {@link EquipmentInventory}
 */
public interface UserInventory<T extends User> extends CarriedInventory<T> {

    /**
     * Gets the main inventory including the Hotbar.
     *
     * @return The main inventory
     */
    PrimaryPlayerInventory getPrimary();

    /**
     * Gets the hotbar inventory.
     *
     * @return The hotbar
     */
    default Hotbar getHotbar() {
        return this.getPrimary().getHotbar();
    }

    /**
     * Gets the main inventory excluding the Hotbar.
     *
     * @return The main inventory grid
     */
    default GridInventory getStorage() {
        return this.getPrimary().getStorage();
    }

    /**
     * Get the armor equipment inventory
     *
     * @return The armor inventory
     */
    EquipmentInventory getArmor();

    /**
     * Gets the offhand inventory.
     *
     * @return The offhand slot
     */
    Slot getOffhand();

    /**
     * Gets the equipment inventory.
     *
     * @return The equipment inventory
     */
    EquipmentInventory getEquipment();
}
