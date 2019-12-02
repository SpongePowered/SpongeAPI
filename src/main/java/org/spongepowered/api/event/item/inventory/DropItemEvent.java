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

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.entity.SpawnEntityEvent;
import org.spongepowered.api.item.inventory.Container;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

import java.util.List;

/**
 * Handles when one or more {@link Item} or {@link ItemStack} are about to be 
 * "dropped" onto the ground. This will happen before they are physically 
 * dropped, let alone spawned.
 */
public interface DropItemEvent extends Event, Cancellable {

    /**
     * Handles {@link ItemStack}s and may be called before an {@link Item}
     * entity is actually constructed.
     *
     * <p>Note: This is not guaranteed to fire due to custom handling within
     * a mod or plugin.</p>
     *
     * <p>Canceling this event only prevents the items from being dropped.
     * Inventories or blocks affected are not rolled back.</p>
     */
    interface Pre extends DropItemEvent {

        /**
         * Gets the original immutable list of {@link ItemStackSnapshot}s to be
         * dropped.
         *
         * @return The original list of dropped items
         */
        List<ItemStackSnapshot> getOriginalDroppedItems();

        /**
         * Gets the mutable list of {@link ItemStackSnapshot}s to be dropped.
         *
         * @return The list of dropped itemstacks
         */
        List<ItemStackSnapshot> getDroppedItems();

    }

    /**
     * Called when one or more {@link Item} drops are triggered by an 
     * object such as an {@link Entity} or {@link BlockType} destruction.
     *
     * <p>Canceling this event only prevents the items from being dropped.
     * Inventories or blocks affected are not rolled back. You might want
     * to listen to {@link org.spongepowered.api.event.block.ChangeBlockEvent.Break} or {@link org.spongepowered.api.event.entity.DestructEntityEvent.Death}.</p>
     */
    interface Destruct extends DropItemEvent, SpawnEntityEvent {}

    /**
     * Called whenever an {@link Item} is dispensed from a type of
     * {@link Inventory} such as a {@link Player} or {@link Container}.
     *
     * <p>This does not include cases where the holder is destroyed resulting in
     * dropped {@link Item}s.</p>
     *
     * <p>Canceling this event does not guarantee that the associated
     * inventory is rolled back when this event is cancelled. You might
     * want to listen to {@link org.spongepowered.api.event.item.inventory.container.ClickContainerEvent.Drop}.</p>
     */
    interface Dispense extends DropItemEvent, SpawnEntityEvent {}

    /**
     * Called whenever an {@link Item} is dispensed by closing a {@link Container}.
     *
     * <p>e.g. The item on the cursor while closing the container or the contents
     * of a crafting table with no free slots in the players inventory.</p>
     *
     * <p>Canceling this event only prevents the items from being dropped.
     * Affected inventories are not rolled back!</p>
     */
    interface Close extends DropItemEvent, SpawnEntityEvent {}

    /**
     * Called whenever an {@link Item} is dropped from another source.
     *
     * <p>Canceling this event only prevents the items from being dropped.
     * Inventories or blocks affected are not rolled back.</p>
     */
    interface Custom extends DropItemEvent, SpawnEntityEvent.Custom {}

}
