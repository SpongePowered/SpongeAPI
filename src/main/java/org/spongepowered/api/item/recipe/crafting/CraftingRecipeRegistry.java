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

import org.spongepowered.api.item.recipe.Recipe;

import java.util.Collection;

/**
 * A CraftingRecipeRegistry holds all registered recipes for a given game.
 */
public interface CraftingRecipeRegistry {

    /**
     * Adds the given {@link Recipe} to the recipe registrar, making
     * it available to craft.
     *
     * @param recipe The recipe to add to the registry
     */
    void add(CraftingRecipe recipe);

    /**
     * Removes the given Recipe from registration in this registry.
     *
     * @param recipe The recipe to remove from the registry
     * @return {@code true} if the recipe was successfully removed
     */
    boolean remove(CraftingRecipe recipe);

    /**
     * Gets a {@link Collection} of all recipes this registry is aware of.
     *
     * @return An unmodifiable collection of all registered recipes
     */
    Collection<CraftingRecipe> getRecipes();

}
