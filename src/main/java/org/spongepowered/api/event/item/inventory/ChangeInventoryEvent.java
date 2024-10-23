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

import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.eventgen.annotations.GenerateFactoryMethod;
import org.spongepowered.eventgen.annotations.PropertySettings;

import java.util.List;
import java.util.Optional;

@GenerateFactoryMethod
public interface ChangeInventoryEvent extends Event, AffectSlotEvent {

    /**
     * Gets the {@link Inventory}.
     *
     * @return The inventory
     */
    Inventory inventory();

    /**
     * Fired when a {@link Living} changes it's held {@link Slot}.
     *
     * <p>This can happen by either scrolling or pressing the number key for the slot.</p>
     */
    interface Held extends ChangeInventoryEvent {

        /**
         * The previously selected slot.
         *
         * @return The previously selected slot.
         */
        Slot originalSlot();

        /**
         * The new selected slot.
         *
         * @return The new selected slot.
         */
        Slot finalSlot();
    }

    /**
     * Fired when a {@link Player} swaps it's hands.
     */
    interface SwapHand extends ChangeInventoryEvent {

    }

    /**
     * An interaction resulting in dropping an item.
     * <p>Note this is for dropping items with no container open.</p>
     * <p>See {@link org.spongepowered.api.event.item.inventory.container.ClickContainerEvent.Drop} for events with a container open.</p>
     */
    interface Drop extends ChangeInventoryEvent, DropItemEvent.Dispense {

        /**
         * The current active hand slot
         *
         * @return the current active hand slot.
         */
        Slot slot();

        /**
         * An interaction dropping a single item. (Q)
         */
        interface Single extends Drop {}

        /**
         * An interaction dropping an entire stack. (ctrl-Q)
         */
        interface Full extends Drop {}

    }

    /**
     * Fires after an {@link Item} has been picked up.
     */
    @GenerateFactoryMethod
    interface Pickup extends ChangeInventoryEvent {

        /**
         * Fires before an {@link Item} is picked up.
         *
         * <p>Modifying the picked up items causes this event to be
         * automatically canceled if the inventory does not
         * fit the entire list.</p>
         */
        interface Pre extends Event, Cancellable {

            /**
             * Gets the {@link Inventory}.
             *
             * @return The inventory.
             */
            Inventory inventory();

            /**
             * Gets the {@link Item}.
             *
             * @return The item
             */
            Item item();

            /**
             * Returns the original picked up {@link ItemStackSnapshot}
             * to add to the inventory.
             *
             * @return The original picked up item
             */
            @PropertySettings(requiredParameter = true, generateMethods = true)
            default ItemStackSnapshot originalStack() {
                return this.item().item().get();
            }

            /**
             * Returns the custom set list of items to add to the inventory or {@link Optional#empty()} if not set.
             *
             * @return The custom set list
             */
            Optional<List<ItemStackSnapshot>> custom();

            /**
             * Sets the items to add to the inventory.
             *
             * <p>If all items do not fit the inventory this event will be
             * automatically canceled.</p>
             *
             * @param items The items to add to the inventory
             */
            void setCustom(List<ItemStackSnapshot> items);

            /**
             * Returns the proposed final list of items to add to the inventory.
             *
             * <p>If a custom list was set all items have to fit the inventory
             * or this event will be automatically canceled.</p>
             *
             * @return The proposed final list
             */
            List<ItemStackSnapshot> finalStacks();

        }
    }
}
