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
package org.spongepowered.api.item.recipe.crafting;

import org.spongepowered.api.item.inventory.crafting.CraftingGridInventory;
import org.spongepowered.api.item.recipe.RecipeRegistry;
import org.spongepowered.api.world.World;

import java.util.Optional;

/**
 * A registry for Crafting Table recipes.
 */
public interface CraftingRecipeRegistry extends RecipeRegistry<CraftingRecipe> {

    /**
     * Retrieves the recipe which would be crafted when the player clicks
     * the output slot.
     *
     * @param grid The crafting grid
     * @param world The world the player is in
     * @return The found {@link CraftingRecipe}, or {@link Optional#empty()}
     *         if no recipe was found for this configuration
     */
    Optional<CraftingRecipe> findMatchingRecipe(CraftingGridInventory grid, World world);

    /**
     * Finds the matching recipe and creates the {@link CraftingResult},
     * which is then returned.
     *
     * @param grid The crafting grid
     * @param world The world the player is in
     * @return The {@link CraftingResult} if a recipe was found, or
     *         {@link Optional#empty()} if not
     */
    default Optional<CraftingResult> getResult(CraftingGridInventory grid, World world) {
        return findMatchingRecipe(grid, world)
                .flatMap(recipe -> recipe.getResult(grid, world));
    }
}
