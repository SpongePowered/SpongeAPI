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
import org.spongepowered.api.item.inventory.ItemStack;

import javax.annotation.Nullable;

/**
 * <p>Represents an entity that can be equipped with armor and a held item. Each
 * method here is a shorthand for the appropriate {@link #getEquipped} or 
 * {@link #equip} method call.</p>
 * 
 * <p>Classes implementing this interface should provide <b>all</b> of the
 * supplied equipment slot types. Classes which do not support all slot types in
 * this interface should instead implement {@link Equipable}.</p>
 */
public interface ArmorEquipable extends Equipable {

    /**
     * Gets the helmet currently being worn by this entity.
     * 
     * <p>Having the helmet as null will result in having nothing
     * equipped in the helmet slot.</p>
     *
     * @return The helmet, if available
     */
    Optional<ItemStack> getHelmet();

    /**
     * Sets the helmet currently being worn by this entity.
     * 
     * <p>Having the helmet as null will result in having nothing
     * equipped in the helmet slot.</p>
     *
     * @param helmet The helmet to put on the entity
     */
    void setHelmet(@Nullable ItemStack helmet);

    /**
     * Gets the chestplate currently being worn by this entity.
     * 
     * <p>Having the chestplate as null will result in having nothing
     * equipped in the chestplate slot.</p>
     *
     * @return The chestplate, if available
     */
    Optional<ItemStack> getChestplate();

    /**
     * Sets the chestplate currently being worn by this entity.
     * 
     * <p>Having the chestplate as null will result in having nothing
     * equipped in the chestplate slot.</p>
     *
     * @param chestplate The chestplate to put on the entity
     */
    void setChestplate(@Nullable ItemStack chestplate);

    /**
     * Gets the leggings currently being worn by this entity.
     * 
     * <p>Having the leggings as null will result in having nothing
     * equipped in the leggings slot.</p>
     *
     * @return The leggings, if available
     */
    Optional<ItemStack> getLeggings();

    /**
     * Sets the leggings currently being worn by this entity.
     * 
     * <p>Having the leggings as null will result in having nothing
     * equipped in the leggings slot.</p>
     *
     * @param leggings The leggings to put on the entity
     */
    void setLeggings(@Nullable ItemStack leggings);

    /**
     * Gets the boots currently being worn by this entity.
     * 
     * <p>Having the boots as null will result in having nothing
     * equipped in the boots slot.</p>
     *
     * @return The boots, if available
     */
    Optional<ItemStack> getBoots();

    /**
     * Sets the boots currently being worn by this entity.
     * 
     * <p>Having the boots as null will result in having nothing
     * equipped in the boots slot.</p>
     *
     * @param boots The boots to put on the entity
     */
    void setBoots(@Nullable ItemStack boots);

    /**
     * Gets the current equipped item in hand if available.
     * 
     * <p>Having the item in hand as null will result in having nothing
     * equipped in the item in hand slot.</p>
     *
     * @return The current item in hand, if available
     */
    Optional<ItemStack> getItemInHand();

    /**
     * Sets the item in hand for this entity.
     * 
     * <p>Having the item in hand as null will result in having nothing
     * equipped in the item in hand slot.</p>
     *
     * @param itemInHand The item in hand
     */
    void setItemInHand(@Nullable ItemStack itemInHand);

}
