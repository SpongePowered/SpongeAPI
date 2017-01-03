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

import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.type.GridInventory;
import org.spongepowered.api.item.recipe.RecipeRegistry;

import java.util.Collection;
import java.util.Optional;

/**
 * A CraftingRegistry holds all registered crafting recipes for a given game.
 */
public interface CraftingRegistry extends RecipeRegistry<CraftingRecipe> {
    /**
     * Checks if the given {@link GridInventory} fits the required constraints
     * to craft this Recipe.
     *
     * @param grid The ItemGrid to check for validity
     * @return True if the given input matches this recipe's requirements
     */
    boolean isValid(GridInventory grid);

    /**
     * Returns the results for running this CraftingRegistry over an {@link GridInventory}
     *
     * @param grid An ItemGrid as input
     * @return A list of ItemStacks or {@link Optional#empty()} if the given
     *          {@link GridInventory} does not match any recipes.
     */
    Optional<Collection<ItemStackSnapshot>> getResults(GridInventory grid);
}
