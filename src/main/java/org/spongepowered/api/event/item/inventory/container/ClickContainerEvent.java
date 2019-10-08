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
import org.spongepowered.api.event.item.inventory.DropItemEvent;
import org.spongepowered.api.item.inventory.Container;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.util.annotation.eventgen.PropertySettings;

import java.util.Optional;

/**
 * A click interaction in an open container.
 */
public interface ClickContainerEvent extends ChangeInventoryEvent, InteractContainerEvent {

    @PropertySettings(requiredParameter = false, generateMethods = false)
    @Override
    default Container getInventory() {
        return getContainer();
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
     * A click in a creative inventory.
     * <p>The client can dictate what stack is in a Slot</p>
     */
    interface Creative extends ClickContainerEvent {}

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
    interface Double extends ClickContainerEvent.Primary {}

    /**
     * An interaction resulting in dropping an item.
     */
    interface Drop extends ClickContainerEvent, DropItemEvent.Dispense {

        /**
         * An interaction dropping a single item. (Q)
         */
        interface Single extends Drop {}

        /**
         * An interaction dropping an entire stack. (shift-Q)
         */
        interface Full extends Drop {}

        /**
         * A click outside of the inventory resulting in dropping the item on cursor.
         */
        interface Outside extends Drop {

            /**
             * A click with the primary mouse button dropping the entire stack on the cursor.
             */
            interface Primary extends Outside, ClickContainerEvent.Primary {}

            /**
             * A click with the secondary mouse button dropping a single item from the cursor.
             */
            interface Secondary extends Outside, ClickContainerEvent.Secondary {}

            /**
             * A click outside of the creative inventory. The cursor transaction is unknown.
             */
            interface Creative extends Outside, ClickContainerEvent.Creative {}
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
    interface Recipe extends ClickContainerEvent {

        /**
         * Returns the requested recipe.
         *
         * @return The requested recipe.
         */
        org.spongepowered.api.item.recipe.Recipe getRecipe();

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
     * A number press swapping the hotbar slot with the slot the mouse hovers over.
     */
    interface NumberPress extends ClickContainerEvent {
        int getNumber();
    }

    /**
     * Returns the primary interaction Slot.
     *
     * <p>May return {@link Optional#empty()} for events that do not directly interact with a Slot</p>
     *
     * @return The primary interaction Slot
     */
    Optional<Slot> getSlot();
}
