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
package org.spongepowered.api.entity.hanging;

import com.google.common.base.Optional;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.rotation.Rotation;

import javax.annotation.Nullable;

/**
 * Represents an ItemFrame.
 */
public interface ItemFrame extends Hanging {

    /**
     * Gets the currently displayed Item.
     *
     * @return The currently displayed item, if available
     */
    Optional<ItemStack> getItem();

    /**
     * Sets the item to be displayed.
     *
     * @param item The item to be displayed
     */
    void setItem(@Nullable ItemStack item);

    /**
     * Gets the current {@link Rotation} of the {@link ItemStack}
     * <p>If the itemframe does not have an {@link ItemStack} inside,
     * the rotation value will be used once an item is placed inside it.</p>
     *
     * @return The current item rotation
     */
    Rotation getItemRotation();

    /**
     * Sets the {@link Rotation} of the item hanging in this item frame.
     * <p>If the itemframe does not have an {@link ItemStack} inside, then
     * the rotation setting may be ignored.</p>
     *
     * @param itemRotation The rotation
     */
    void setRotation(Rotation itemRotation);
}
