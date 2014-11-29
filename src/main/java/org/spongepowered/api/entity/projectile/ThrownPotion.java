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
package org.spongepowered.api.entity.projectile;

import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.potion.PotionEffect;

import java.util.List;

/**
 * Represents a thrown potion.
 */
public interface ThrownPotion extends Projectile {

    /**
     * Gets the copy of the current potion in the form of an
     * {@link ItemStack}.
     * <p>Changes made to this ItemStack will not reflect on to
     * this potion.</p>
     *
     * @return A copy of the ItemStack for this potion
     */
    ItemStack getItem();

    /**
     * Sets the given ItemStack for this thrown potion.
     * <p>The given ItemStack mush be a potion.</p>
     *
     * @param item The new ItemStack
     */
    void setItem(ItemStack item);

    /**
     * Gets the list of {@link PotionEffect}s that are in
     * this thrown potion.
     *
     * @return The list of {@link PotionEffect}s.
     */
    List<PotionEffect> getPotionEffects();
}
