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
package org.spongepowered.api.entity;

import org.spongepowered.api.data.type.HandType;
import org.spongepowered.api.item.inventory.ItemStack;

/**
 * <p>Represents an entity that can be equipped with armor, main hand and off hand items.
 * Each method here is a shorthand for the appropriate {@link #getEquipped}
 * or {@link #equip} method call.</p>
 *
 * <p>Classes implementing this interface should provide <b>all</b> of the
 * supplied equipment slot types. Classes which do not support all slot types in
 * this interface should instead implement {@link Equipable}.</p>
 */
public interface ArmorEquipable extends Equipable {

    /**
     * Gets the helmet currently being worn by this entity.
     *
     * @return The helmet, if available
     */
    ItemStack getHelmet();

    /**
     * Sets the helmet currently being worn by this entity.
     *
     * @param helmet The helmet to put on the entity
     */
    void setHelmet(ItemStack helmet);

    /**
     * Gets the chestplate currently being worn by this entity.
     *
     * @return The chestplate, if available
     */
    ItemStack getChestplate();

    /**
     * Sets the chestplate currently being worn by this entity.
     *
     * @param chestplate The chestplate to put on the entity
     */
    void setChestplate(ItemStack chestplate);

    /**
     * Gets the leggings currently being worn by this entity.
     *
     * @return The leggings, if available
     */
    ItemStack getLeggings();

    /**
     * Sets the leggings currently being worn by this entity.
     *
     * @param leggings The leggings to put on the entity
     */
    void setLeggings(ItemStack leggings);

    /**
     * Gets the boots currently being worn by this entity.
     *
     * @return The boots, if available
     */
    ItemStack getBoots();

    /**
     * Sets the boots currently being worn by this entity.
     *
     * @param boots The boots to put on the entity
     */
    void setBoots(ItemStack boots);

    /**
     * Gets the current equipped item in hand if available.
     *
     * @param handType The hand type to retrieve from
     * @return The current item in hand, if available
     */
    ItemStack getItemInHand(HandType handType);

    /**
     * Sets the item in hand for this entity.
     *
     * @param hand The hand type to set to
     * @param itemInHand The item in hand
     */
    void setItemInHand(HandType hand, ItemStack itemInHand);

}
