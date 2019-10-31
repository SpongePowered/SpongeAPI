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
package org.spongepowered.api.item.inventory.type;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.Carrier;
import org.spongepowered.api.item.inventory.ContainerType;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.InventoryKeys;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.item.inventory.menu.InventoryMenu;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.math.vector.Vector2i;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Interface for inventories which may be interacted with by Players.
 */
public interface ViewableInventory extends Inventory {

    /**
     * Gets the current viewers looking at this Inventory.
     *
     * @return The current viewers of this inventory
     */
    Set<Player> getViewers();

    /**
     * Checks for whether this Inventory currently has viewers.
     *
     * @return True if viewers are currently looking at this inventory
     */
    boolean hasViewers();

    /**
     * Gets whether the specified player can interact with this object.
     *
     * @param player the Player wishing to interact with this Inventory
     * @return true if the Entity is able to interact with this Inventory
     */
    boolean canInteractWith(Player player);

    /**
     * Returns the {@link ContainerType} of this viewable inventory.
     *
     * @return the ContainerType of this viewable inventory.
     */
    ContainerType getType();

    /**
     * Create a new {@link InventoryMenu} based on this ViewableInventory which allows for lightweight callbacks on inventory clicks and changes.
     * To receive callbacks the inventory must be opened from {@link InventoryMenu#open(Player)}
     *
     * @return The new InventoryMenu
     */
    InventoryMenu asMenu();

    /**
     * Creates a new {@link Builder} to build an {@link ViewableInventory}.
     *
     * @return The builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * A builder for inventories conforming to a ContainerType
     */
    interface Builder extends ResettableBuilder<Inventory, Builder> {

        /**
         * Specifies the type of inventory you want to build.
         * <p>You must define all slots of the given type.</p>
         *
         * @param type The ContainerType
         * @return The building step.
         */
        BuildingStep type(ContainerType type);

        /**
         * Specifies the type of inventory you want to build based on an existing Inventory
         *
         * @param inventory the viewable inventory
         *
         * @return The building step
         */
        default BuildingStep typeFrom(ViewableInventory inventory) {
            return this.type(inventory.getType());
        }

        /**
         * The building step. Define all slots needed for the chosen {@link ContainerType}.
         * <p>When done use {@link #completeStructure()} to finalize the inventory.</p>
         */
        interface BuildingStep {

            /**
             * Adds dummy-slots to the inventory.
             *
             * @param count the amount of slots to add
             * @param offset the offset for adding the slots
             *
             * @return the dummy building step
             */
            DummyStep dummySlots(int count, int offset);

            /**
             * Adds dummy-slots to the inventory.
             *
             * @param count the amount of slots to add
             * @param offset the offset for adding the slots
             *
             * @return the dummy building step
             */
            DummyStep dummySlots(int count, Vector2i offset);

            /**
             * Adds a grid of dummy-slots to the inventory.
             *
             * @param size the size of the grid
             * @param offset the offset for adding the slots
             *
             * @return the dummy building step
             */
            DummyStep dummyGrid(Vector2i size, int offset);

            /**
             * Adds a grid of dummy-slots to the inventory.
             *
             * @param size the size of the grid
             * @param offset the offset for adding the slots
             *
             * @return the dummy building step
             */
            DummyStep dummyGrid(Vector2i size, Vector2i offset);

            /**
             * Adds given slots to the inventory.
             *
             * @param source the source slots.
             * @param offset the offset for adding the slots
             *
             * @return the building step
             */
            BuildingStep slots(List<Slot> source, int offset);

            /**
             * Adds given slots to the inventory.
             *
             * @param source the source slots.
             * @param offset the offset for adding the slots
             *
             * @return the building step
             */
            BuildingStep slots(List<Slot> source, Vector2i offset);

            /**
             * Adds given slots to the inventory in a grid.
             *
             * @param source the source slots.
             * @param size the size if the grid
             * @param offset the offset for adding the slots.
             *
             * @return the building step
             */
            BuildingStep grid(List<Slot> source, Vector2i size, int offset);

            /**
             * Adds given slots to the inventory in a grid.
             *
             * @param source the source slots.
             * @param size the size if the grid
             * @param offset the offset for adding the slots.
             *
             * @return the building step
             */
            BuildingStep grid(List<Slot> source, Vector2i size, Vector2i offset);
            // provide target slot index/position

            /**
             * Adds given slots to the inventory at given indizes.
             *
             * @param source the source slots
             * @param at the indizes
             *
             * @return the building step
             */
            BuildingStep slotsAtIndizes(List<Slot>source, List<Integer> at);

            /**
             * Adds given slots to the inventory at given positions
             *
             * @param source the source slots
             * @param at the indizes
             *
             * @return the building step
             */
            BuildingStep slotsAtPositions(List<Slot>source, List<Vector2i> at);

            /**
             * Adds all undefined slots as dummy slots.
             *
             * @return the building step.
             */
            DummyStep fillDummy();

            /**
             * Completes the inventory structure.
             * <p>If no slots are defined this will create the structure mirroring the vanilla type.</p>
             * <p>If some but not all slots are defined undefined slots will be defined using {@link #fillDummy()}</p>
             *
             * @return the end step
             */
            EndStep completeStructure();
        }

        interface DummyStep extends BuildingStep {

            /**
             * Sets the default item for the dummy-slots.
             *
             * @param item the default item
             *
             * @return the building step
             */
            BuildingStep item(ItemStackSnapshot item);
        }

        interface EndStep extends Builder {

            /**
             * Sets a unique identifier. Can be retrieved later using. {@link Inventory#get(Key)} with {@link InventoryKeys#UNIQUE_ID}
             *
             * @param uuid the UUID.
             *
             * @return this step
             */
            EndStep identity(UUID uuid);

            /**
             * Sets a carrier.
             *
             * @param carrier the carrier.
             *
             * @return this step
             */
            EndStep carrier(Carrier carrier);

            /**
             * Builds the inventory.
             *
             * @return the new inventory.
             */
            ViewableInventory build();
        }

    }

}
