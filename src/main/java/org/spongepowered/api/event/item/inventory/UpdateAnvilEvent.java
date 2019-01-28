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

import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.item.inventory.AnvilCost;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.util.annotation.eventgen.GenerateFactoryMethod;

/**
 * Fires whenever the left and right slots of an anvil are filled and a new result is computed.
 */
@GenerateFactoryMethod
public interface UpdateAnvilEvent extends Event, Cancellable {

    /**
     * Gets the {@link Inventory}.
     *
     * @return The inventory
     */
    Inventory getInventory();

    /**
     * Returns the new item name.
     *
     * @return The new item name
     */
    String getItemName();

    /**
     * Returns the left input item.
     *
     * @return The left input item
     */
    ItemStackSnapshot getLeft();

    /**
     * Returns the right input item.
     *
     * @return The right input item
     */
    ItemStackSnapshot getRight();

    /**
     * Returns the transaction for the resulting item.
     *
     * @return The transaction for the resulting item.
     */
    Transaction<ItemStackSnapshot> getResult();

    /**
     * Returns the transaction for the repair costs.
     *
     * @return The transaction for the repair costs.
     */
    Transaction<AnvilCost> getCosts();

}
