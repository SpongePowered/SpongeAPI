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
package org.spongepowered.api.event.entity;

import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.util.annotation.eventgen.GenerateFactoryMethod;

/**
 * Called when an entity changes an equipped item. This can occur whenever
 * a {@link Slot} belonging to an {@link Inventory} of an {@link Entity}
 * is filled with an {@link ItemStack}, emptied of an {@link ItemStack},
 * or swapped with an {@link ItemStack}. In the event that a change to the
 * {@link ItemStack}, the use of the {@link Transaction} is recommended.
 */
@GenerateFactoryMethod
public interface ChangeEntityEquipmentEvent extends Event, Cancellable {

    /**
     * Gets the {@link Entity}.
     *
     * @return The entity
     */
    Entity getEntity();

    /**
     * Gets the {@link Slot}.
     *
     * @return The slot
     */
    Slot getSlot();

    /**
     * Gets the {@link Transaction} of {@link ItemStackSnapshot}s for this event.
     *
     * @return The transaction of the item
     */
    Transaction<ItemStackSnapshot> getTransaction();

    /**
     * Called when the players equipment is broken or otherwise replaced by an empty item-stack.
     */
    interface Break extends ChangeEntityEquipmentEvent { }

}
