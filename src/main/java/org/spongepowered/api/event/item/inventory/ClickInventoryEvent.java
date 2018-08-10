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

/**
 * A click interaction in an open container.
 */
public interface ClickInventoryEvent extends ChangeInventoryEvent, InteractInventoryEvent {

    /**
     * A click with the primary mouse button.
     */
    interface Primary extends ClickInventoryEvent {}

    /**
     * A click with the middle mouse button.
     */
    interface Middle extends ClickInventoryEvent {}

    /**
     * A click with the secondary mouse button.
     */
    interface Secondary extends ClickInventoryEvent {}

    /**
     * A click in a creative inventory.
     * <p>The client can dictate what stack is in a Slot</p>
     */
    interface Creative extends ClickInventoryEvent {}

    /**
     * A click with the <code>shift</code> modifier active
     */
    interface Shift extends ClickInventoryEvent {

        /**
         * A click with the primary mouse button and the <code>shift</code> modifier active
         */
        interface Primary extends Shift, ClickInventoryEvent.Primary {}

        /**
         * A click with the secondary mouse button and the <code>shift</code> modifier active
         */
        interface Secondary extends Shift, ClickInventoryEvent.Secondary {}
    }

    /**
     * A double-click with the primary mouse button
     */
    interface Double extends ClickInventoryEvent.Primary {}

    /**
     * An interaction resulting in dropping an item.
     */
    interface Drop extends ClickInventoryEvent, DropItemEvent.Dispense {

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
            interface Primary extends Outside, ClickInventoryEvent.Primary {}

            /**
             * A click with the secondary mouse button dropping a single item from the cursor.
             */
            interface Secondary extends Outside, ClickInventoryEvent.Secondary {}
        }
    }

    /**
     * A completed drag Interaction.
     */
    interface Drag extends ClickInventoryEvent {

        /**
         * A completed drag Interaction distributing the cursor stack evenly among the slots.
         */
        interface Primary extends Drag, ClickInventoryEvent.Primary {}

        /**
         * A completed drag Interaction distributing a single item from the cursor stack on each slot.
         */
        interface Secondary extends Drag, ClickInventoryEvent.Secondary {}

        /**
         * A completed drag Interaction cloning the cursor stack on each slot.
         * <p>Only changes slots in creative mode</p>
         */
        interface Middle extends Drag, ClickInventoryEvent.Middle {}
    }

    /**
     * Fires when the client requests a recipe to be crafted.
     */
    interface Recipe extends ClickInventoryEvent {

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
    interface NumberPress extends ClickInventoryEvent {
        int getNumber();
    }
}
