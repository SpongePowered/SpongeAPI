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
package org.spongepowered.api.event.inventory;

import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.crafting.CraftingInventory;
import org.spongepowered.api.item.recipe.Recipe;
import org.spongepowered.api.util.event.Cancellable;

import java.util.List;

/**
 * A CraftItemEvent is fired when an item is crafted from a
 * player inventory or workbench inventory, or any other crafting inventory.
 */
public interface CraftItemEvent extends ViewerEvent, Cancellable {

    /**
     * Retrieves the CraftingInventory involved with this event.
     *
     * @return The crafting inventory
     */
    CraftingInventory getInventory();

    /**
     * Retrieves the recipe that has been crafted as a result of this event.
     *
     * @return The recipe
     */
    Recipe getRecipe();

    /**
     * Gets the ItemStacks that are a result of this crafting event.
     *
     * @return The results
     */
    List<ItemStack> getResults();

    /**
     * Gets the types of the results of this crafting event.
     *
     * @return The result types
     */
    List<ItemType> getResultTypes();

}
