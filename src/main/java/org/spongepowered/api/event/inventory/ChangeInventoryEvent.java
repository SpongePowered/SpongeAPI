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
package org.spongepowered.api.event.inventory;

import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.item.inventory.*;

import java.util.Optional;

/**
 * Fired when an {@link Inventory} is being changed due to a {@link Cause}.
 */
public interface ChangeInventoryEvent extends InteractInventoryEvent {
    /**
     * Gets the previously equipped {@link ItemStack} as an
     * {@link ItemStackSnapshot}.
     *
     * <p>The previously equipped item may have been empty.</p>
     *
     * @return The original itemstack, if available
     */
    Optional<ItemStackSnapshot> getOriginalItemStack();

    /**
     * Gets the new {@link ItemStack} that is being equipped in the relative
     * armor slot.
     *
     * <p>The itemstack may not exist or the slot is being emptied.</p>
     *
     * @return The new item stack, if available
     */
    ItemStackTransaction getItemStackTransaction();

    interface Click extends ChangeInventoryEvent {}

    interface Move extends ChangeInventoryEvent {}

    interface Drag extends ChangeInventoryEvent {}

    interface Equipment extends ChangeInventoryEvent {
        @Override
        Slot getTargetInventory();
    }

    interface Held extends ChangeInventoryEvent {
        @Override
        Slot getTargetInventory();
    }
}
