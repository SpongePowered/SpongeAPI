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

package org.spongepowered.api.event.block;

import org.spongepowered.api.entity.Item;
import org.spongepowered.api.event.inventory.ItemDropEvent;
import org.spongepowered.api.util.event.Cancellable;
import org.spongepowered.api.world.Location;

import java.util.Collection;

/**
 * Dispatched when a {@link Location} is about to drop it's items.
 */
public interface BlockHarvestEvent extends BlockEvent, ItemDropEvent, Cancellable {

    /**
     * Sets the items that are to be dropped.
     *
     * @param items The collection of item entities to drop
     */
    void setDroppedItems(Collection<Item> items);

    /**
     * Gets the chance the items are being dropped. A chance of 1 means all the
     * items are dropped.
     *
     * @return The chance, between 0 and 1
     */
    float getDropChance();

    /**
     * Sets the chance the items will be dropped.
     *
     * <p>Setting the chance to 0 may stop the items from dropping, to guarantee
     * no items are dropped, use {@link #setCancelled(boolean)}.</p>
     *
     * @param chance The chance, must be between 0 and 1
     */
    void setDropChance(float chance);

}
