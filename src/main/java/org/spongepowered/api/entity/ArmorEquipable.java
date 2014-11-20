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

/**
 * Represents an entity that can be equipped with armour.
 */
public interface ArmorEquipable {

    /**
     * Gets the helmet currently being worn by this entity.
     *
     * @return The helmet, if available.
     */
    Optional<ItemStack> getHelmet();

    /**
     * Sets the helmet currently being worn by this entity.
     *
     * @param helmet The helmet to put on the entity.
     */
    void setHelmet(ItemStack helmet);

    /**
     * Gets the chestplate currently being worn by this entity.
     *
     * @return The chestplate, if available.
     */
    Optional<ItemStack> getChestplate();

    /**
     * Sets the chestplate currently being worn by this entity.
     *
     * @param chestplate The chestplate to put on the entity.
     */
    void setChestplate(ItemStack chestplate);

    /**
     * Gets the leggings currently being worn by this entity.
     *
     * @return The leggings, if available.
     */
    Optional<ItemStack> getLeggings();

    /**
     * Sets the leggings currently being worn by this entity.
     *
     * @param leggings The leggings to put on the entity.
     */
    void setLeggings(ItemStack leggings);

    /**
     * Gets the boots currently being worn by this entity.
     *
     * @return The boots, if available.
     */
    Optional<ItemStack> getBoots();

    /**
     * Sets the boots currently being worn by this entity.
     *
     * @param boots The boots to put on the entity.
     */
    void setBoots(ItemStack boots);

}