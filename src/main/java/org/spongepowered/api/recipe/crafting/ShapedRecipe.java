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
package org.spongepowered.api.recipe.crafting;

import java.util.Arrays;

import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;

import com.google.common.base.Preconditions;

/**
 * A shaped recipe. Locations of ingredients in crafting grid do matter.
 */
public class ShapedRecipe extends CraftingRecipe {
    
    /**
     * Creates a new shaped recipe.  Ingredients are used on crafting table
     * following way (pseudo-code):
     * <pre>
     * new ShapedRecipe(result,
     *         1, 2, 3,
     *         4, 5, 6,
     *         7, 8, 9
     * );
     * </pre>
     * Crafting table:
     * <pre>
     * 1 2 3
     * 4 5 6 => result
     * 7 8 9
     * </pre>
     * @param result Result of recipe
     * @param ingredients Ingredients, from left to right and up to down
     */
    public ShapedRecipe(ItemStack result, ItemType... ingredients) {
        Preconditions.checkNotNull(result, "Result of recipe cannot be null!");
        Preconditions.checkNotNull(result, "Ingredients cannot be null!");
        this.result = result;
        this.ingredients = Arrays.asList(ingredients);
    }
}
