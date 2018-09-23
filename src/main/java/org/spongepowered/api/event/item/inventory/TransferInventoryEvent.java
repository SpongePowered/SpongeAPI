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
package org.spongepowered.api.event.item.inventory;

import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.Slot;

/**
 * Fired when an {@link Inventory} transfers items into another.
 */
public interface TransferInventoryEvent extends Event {

    /**
     * Gets the source {@link Inventory} of this {@link Event}.
     *
     * @return The source {@link Inventory}
     */
    Inventory getSourceInventory();

    /**
     * Gets the target {@link Inventory} of this {@link Event}.
     *
     * @return The target {@link Inventory}
     */
    Inventory getTargetInventory();

    /**
     * Fired before an {@link Inventory} attempts to transfer any items.
     */
    interface Pre extends TransferInventoryEvent, Cancellable {

    }

    /**
     * Fires after an {@link Inventory} transferred an item into an other inventory.
     */
    interface Post extends TransferInventoryEvent {

        /**
         * The item getting transferred.
         *
         * @return The item getting transferred
         */
        ItemStackSnapshot getTransferredItem();

        /**
         * Returns the source slot of this item transfer.
         *
         * @return The source slot of this item transfer
         */
        Slot getSourceSlot();

        /**
         * Returns the target slot of this item transfer.
         *
         * @return The target slot of this item transfer
         */
        Slot getTargetSlot();
    }

}
