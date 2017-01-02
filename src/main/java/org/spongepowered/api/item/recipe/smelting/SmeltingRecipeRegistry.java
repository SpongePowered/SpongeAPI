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
package org.spongepowered.api.item.recipe.smelting;

import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.recipe.RecipeRegistry;

import java.util.Optional;

/**
 * A registry for Crafting Table recipes.
 */
public interface SmeltingRecipeRegistry extends RecipeRegistry<SmeltingRecipe> {

    /**
     * Retrieves the recipe used when smelting the given ingredient.
     *
     * @param ingredient The ingredient to check against
     * @return The found {@link SmeltingRecipe}, or {@link Optional#empty()}
     *         if no recipe was found for this {@link ItemStackSnapshot}
     */
    Optional<SmeltingRecipe> findMatchingRecipe(ItemStackSnapshot ingredient);

    /**
     * Finds the matching recipe and creates the {@link SmeltingResult},
     * which is then returned.
     *
     * @param ingredient The ingredient to check against
     * @return The {@link SmeltingResult} if a recipe was found, or
     *         {@link Optional#empty()} if not
     */
    default Optional<SmeltingResult> getResult(ItemStackSnapshot ingredient) {
        return findMatchingRecipe(ingredient)
                .flatMap(recipe -> recipe.getResult(ingredient));
    }
}
