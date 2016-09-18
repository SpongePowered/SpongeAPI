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

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.item.inventory.crafting.CraftingInventory;
import org.spongepowered.api.item.inventory.equipment.EquipmentInventory;
import org.spongepowered.api.item.inventory.type.CarriedInventory;
import org.spongepowered.api.item.inventory.type.GridInventory;

/**
 * Represents the inventory of a Humanoid or Player. Implementors of this interface
 * guarantee that (at a minimum) the following subinventory types can be queried
 * for:
 *
 * <ul><li>
 *   {@link CraftingInventory}
 * </li></ul>
 */
public interface PlayerInventory extends CarriedInventory<Player> {

    /**
     * Gets the hotbar inventory.
     *
     * @return the hotbar
     */
    Hotbar getHotbar();

    /**
     * Gets the main inventory.
     *
     * @return the hotbar
     */
    GridInventory getMain();

    /**
     * Gets the equipment inventory.
     *
     * @return the hotbar
     */
    EquipmentInventory getEquipment();

    /**
     * Gets the offhand inventory.
     *
     * @return the hotbar
     */
    Slot getOffhand();

}
