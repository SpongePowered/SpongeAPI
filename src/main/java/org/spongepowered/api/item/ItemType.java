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

package org.spongepowered.api.item;

import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.translation.Translatable;

/**
 * A type of item.
 */
public interface ItemType extends Translatable {

    /**
     * Gets the id of this item.
     *
     * <p>Ex. Minecraft registers a golden carrot as
     * "minecraft:golden_carrot".</p>
     *
     * @return The id
     */
    String getId();

    /**
     * Get the default maximum quantity for
     * {@link ItemStack}s of this item.
     *
     * @return Max stack quantity
     */
    int getMaxStackQuantity();

    /**
     * Gets if the item can be damaged.
     *
     * <p>Ex. Tools, weapons and armor can all be damaged.</p>
     *
     * @return If it can be damaged
     */
    boolean isDamageable();

    /**
     * Returns the maximum damage an item can take.
     *
     * @return The max damage
     */
    int getMaxDamage();

}
