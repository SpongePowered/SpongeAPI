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

import org.spongepowered.api.event.item.inventory.container.ClickContainerEvent;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.item.inventory.crafting.CraftingInventory;
import org.spongepowered.api.item.inventory.transaction.SlotTransaction;
import org.spongepowered.api.item.recipe.Recipe;
import org.spongepowered.api.item.recipe.crafting.CraftingRecipe;

import java.util.Optional;

public interface CraftItemEvent extends ChangeInventoryEvent {

    /**
     * Returns the crafting inventory.
     * <p>This includes the crafting grid and one output slot</p>
     *
     * @return The crafting inventory
     */
    CraftingInventory getCraftingInventory();

    /**
     * Returns the {@link Recipe} used for crafting
     *
     * @return The recipe
     */
    Optional<CraftingRecipe> getRecipe();

    /**
     * This event is fired before the item is taken out of the
     * output slot but after completing the recipe in the grid.
     */
    interface Preview extends CraftItemEvent {

        /**
         * The SlotTransaction on the output slot.
         * <p>Setting a custom Item here changes the result of the recipe replacing the default result</p>
         *
         * @return The output SlotTransaction
         */
        SlotTransaction getPreview();
    }

    /**
     * This event is fired after the item is taken out of the output slot.
     */
    interface Craft extends CraftItemEvent, ClickContainerEvent {

        /**
         * The item crafted with this event.
         *
         * @return The crafting transaction
         */
        ItemStackSnapshot getCrafted();

        /**
         * Returns the crafting output Slot.
         *
         * @return The crafting output Slot
         */
        @Override
        Optional<Slot> getSlot();
    }
}
