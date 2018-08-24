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
package org.spongepowered.api.item.inventory.crafting;

import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.recipe.crafting.CraftingRecipe;
import org.spongepowered.api.world.World;

import java.util.Optional;

/**
 * A CraftingInventory represents the inventory of something that can craft
 * items.
 */
public interface CraftingInventory extends Inventory {

    /**
     * Gets the crafting matrix of this CraftingInventory.
     *
     * @return The crafting matrix
     */
    CraftingGridInventory getCraftingGrid();

    /**
     * Gets the result slot of this CraftingInventory.
     *
     * @return The result slot
     */
    CraftingOutput getResult();

    /**
     * Retrieves the recipe formed by this CraftingInventory, if any.
     *
     * @param world The world where the item would be crafted in
     * @return The recipe or {@link Optional#empty()} if no recipe is formed
     */
    default Optional<CraftingRecipe> getRecipe(World world) {
        return getCraftingGrid().getRecipe(world);
    }

}
