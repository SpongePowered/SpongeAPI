package org.spongepowered.api.entity;

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

import com.google.common.base.Optional;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.slots.EquipmentSlot;

import javax.annotation.Nullable;

/**
 * <p>Represents an entity that can be equipped with armor and a held item. Each
 * method here is a shorthand for the appropriate {@link #getEquipped} method call.
 * 
 * <p>Classes implementing this interface should provide <b>all</b> of the
 * supplied equipment slot types. Classes which do not support all slot types in
 * this interface should instead implement {@link Equipable}.</p>
 */
public interface ArmorEquipable extends Equipable {

    /**
     * Gets the helmet currently being worn by this entity.
     * 
     * <p>In Vanilla, the returned {@link Inventory} can be queried for {@link EquipmentSlot}.</p>
     *
     * @return The helmet, if available
     */
    Inventory getHelmet();

    /**
     * Gets the chestplate currently being worn by this entity.
     * 
     * <p>In Vanilla, the returned {@link Inventory} can be queried for {@link EquipmentSlot}.</p>
     *
     * @return The chestplate, if available
     */
    Inventory getChestplate();

    /**
     * Gets the leggings currently being worn by this entity.
     * 
     * <p>In Vanilla, the returned {@link Inventory} can be queried for {@link EquipmentSlot}.</p>>
     *
     * @return The leggings, if available
     */
    Inventory getLeggings();

    /**
     * Gets the boots currently being worn by this entity.
     * 
     * <p>Having the boots as null will result in having nothing
     * equipped in the boots slot.</p>
     *
     * @return The boots, if available
     */
    Inventory getBoots();

    /**
     * Gets the current equipped item in hand if available.
     * 
     * <p>Having the item in hand as null will result in having nothing
     * equipped in the item in hand slot.</p>
     *
     * @return The current item in hand, if available
     */
    Inventory getItemInHand();

}
