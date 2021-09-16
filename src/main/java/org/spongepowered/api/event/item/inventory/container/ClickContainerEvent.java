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
package org.spongepowered.api.event.item.inventory.container;

import org.spongepowered.api.event.item.inventory.ChangeInventoryEvent;
import org.spongepowered.api.event.item.inventory.CraftItemEvent;
import org.spongepowered.api.event.item.inventory.DropItemEvent;
import org.spongepowered.api.item.inventory.Container;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.item.merchant.TradeOffer;

import java.util.Optional;

/**
 * A click interaction in an open container.
 */
public interface ClickContainerEvent extends ChangeInventoryEvent, InteractContainerEvent {

    @Override
    default Container inventory() {
        return this.container();
    }

    /**
     * A click with the primary mouse button.
     */
    interface Primary extends ClickContainerEvent {}

    /**
     * A click with the middle mouse button.
     */
    interface Middle extends ClickContainerEvent {}

    /**
     * A click with the secondary mouse button.
     */
    interface Secondary extends ClickContainerEvent {}

    /**
     * An interaction with a creative inventory.
     * <p>The cursor transaction is not known to the server</p>
     */
    interface Creative extends ClickContainerEvent {

        /**
         * A click in a creative inventory causing an item to drop.
         */
        interface Drop extends Creative, DropItemEvent.Dispense {

            /**
             * Returns the stack to be dropped in creative mode.
             *
             * @return The stack to be dropped.
             */
            ItemStackSnapshot droppedStack();
        }

        /**
         * A click in a creative inventory setting a slot.
         */
        interface Set extends Creative {

        }
    }

    /**
     * A click with the <code>shift</code> modifier active
     */
    interface Shift extends ClickContainerEvent {

        /**
         * A click with the primary mouse button and the <code>shift</code> modifier active
         */
        interface Primary extends Shift, ClickContainerEvent.Primary {}

        /**
         * A click with the secondary mouse button and the <code>shift</code> modifier active
         */
        interface Secondary extends Shift, ClickContainerEvent.Secondary {}
    }

    /**
     * A double-click with the primary mouse button
     */
    @SuppressWarnings("JavaLangClash")
    interface Double extends ClickContainerEvent.Primary {}

    /**
     * An interaction resulting in dropping an item.
     * <p>Note this is for dropping items with a container open.</p>
     * <p>See {@link ChangeInventoryEvent.Drop} for events with no container open.</p>
     */
    interface Drop extends ClickContainerEvent, DropItemEvent.Dispense {

        /**
         * An interaction dropping a single item. (Q)
         */
        interface Single extends ClickContainerEvent.Drop {}

        /**
         * An interaction dropping an entire stack. (shift-Q)
         */
        interface Full extends ClickContainerEvent.Drop {}

        /**
         * A click outside of the inventory resulting in dropping the item on cursor.
         */
        interface Outside extends ClickContainerEvent.Drop {

            /**
             * A click with the primary mouse button dropping the entire stack on the cursor.
             */
            interface Primary extends Outside, ClickContainerEvent.Primary {}

            /**
             * A click with the secondary mouse button dropping a single item from the cursor.
             */
            interface Secondary extends Outside, ClickContainerEvent.Secondary {}

        }
    }

    /**
     * A completed drag Interaction.
     */
    interface Drag extends ClickContainerEvent {

        /**
         * A completed drag Interaction distributing the cursor stack evenly among the slots.
         */
        interface Primary extends Drag, ClickContainerEvent.Primary {}

        /**
         * A completed drag Interaction distributing a single item from the cursor stack on each slot.
         */
        interface Secondary extends Drag, ClickContainerEvent.Secondary {}

        /**
         * A completed drag Interaction cloning the cursor stack on each slot.
         * <p>Only changes slots in creative mode</p>
         */
        interface Middle extends Drag, ClickContainerEvent.Middle {}
    }

    /**
     * Fires when the client requests a recipe to be crafted.
     */
    interface Recipe extends CraftItemEvent.Preview {

        /**
         * Fires when the Client requests a recipe to be crafted once.
         */
        interface Single extends Recipe {}

        /**
         * Fires when the client requests a recipe to be crafted as much as possible.
         */
        interface All extends Recipe {}
    }

    /**
     * Fies when the client requests to select a trade from a {@link org.spongepowered.api.entity.living.trader.Trader}
     */
    interface SelectTrade extends ClickContainerEvent {

        /**
         * Returns the selected trade offer index.
         *
         * @return The selected trade offer index
         */
        int selected();

        /**
         * Returns the selected trade offer.
         *
         * @return The selected trade offer
         */
        TradeOffer tradeOffer();
    }

    /**
     * A number press swapping the hotbar slot with the slot the mouse hovers over.
     */
    interface NumberPress extends ClickContainerEvent {
        int number();
    }

    /**
     * Returns the primary interaction Slot.
     *
     * <p>May return {@link Optional#empty()} for events that do not directly interact with a Slot</p>
     *
     * @return The primary interaction Slot
     */
    Optional<Slot> slot();
}
