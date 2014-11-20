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
package org.spongepowered.api.recipe;

import java.util.List;

import org.spongepowered.api.item.inventory.ItemStack;

/**
 * Service for registering and removing recipes.
 */
public interface RecipeService {
    
    /**
     * Registers a new recipe.
     * @param recipe The new recipe
     */
    void registerRecipe(Recipe recipe);
    
    /**
     * Unregisters given recipe. If it wasn't registered, nothing will happen.
     * @param recipe Recipe to unregister
     */
    void unregisterRecipe(Recipe recipe);
    
    /**
     * Gets all recipes which have given result
     * @param result Result to use
     * @return List of recipes with given result
     */
    List<Recipe> getRecipesByResult(ItemStack result);
    
    /**
     * Gets all recipes.
     * @return All recipes registered.
     */
    List<Recipe> getAllRecipes();
}
