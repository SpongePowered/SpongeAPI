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
package org.spongepowered.api.event.entity;

import com.google.common.base.Optional;
import org.spongepowered.api.event.inventory.InventoryEvent;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.event.Cancellable;

/**
 * Called when an entity changes an equipped item.
 * <p>Examples include: A zombie picking up a weapon, a Player switching
 * their current item in hand, etc.</p>
 */
public interface EntityEquipmentChangeEvent extends EntityEvent, InventoryEvent, Cancellable {

    /**
     * Gets the previously equipped item stack.
     *
     * <p>The previously equipped item may have been empty.</p>
     *
     * @return The original itemstack, if available
     */
    Optional<ItemStack> getOriginalItem();

    /**
     * Gets the {@link ItemStack} that is being equipped in the relative
     * armor slot.
     *
     * <p>The itemstack may not exist or the slot is being emptied.</p>
     *
     * @return The item stack, if available
     */
    Optional<ItemStack> getNewItemStack();

    /**
     * Gets the slot index of the equipment being changed.
     *
     * @return The slot index of the equipment item
     */
    int getSlot();

}
