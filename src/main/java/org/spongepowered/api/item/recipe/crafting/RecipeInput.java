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

import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.type.GridInventory;
import org.spongepowered.api.item.recipe.cooking.CookingRecipe;
import org.spongepowered.api.item.recipe.single.StoneCutterRecipe;
import org.spongepowered.api.item.recipe.smithing.SmithingRecipe;

/**
 * A special inventory used as an input for a {@link org.spongepowered.api.item.recipe.Recipe}.
 */
public interface RecipeInput extends Inventory {


    /**
     * A recipe input with a single {@link ItemStack} e.g.
     * for {@link CookingRecipe}
     * and {@link StoneCutterRecipe}
     */
    interface Single extends RecipeInput {

    }

    /**
     * A recipe input with the 3 input stacks for the template, base item and additional item.
     * Used in {@link SmithingRecipe}
     */
    interface Smithing extends RecipeInput {

    }

    /**
     * A recipe input with a crafting grid used for {@link CraftingRecipe}
     */
    interface Crafting extends RecipeInput {

        GridInventory asGrid();
    }


    interface Factory {

        /**
         * Creates a recipe input for
         * {@link CookingRecipe} and
         * {@link StoneCutterRecipe}
         *
         * @param stack the single input stack
         *
         * @return the recipe input
         */
        RecipeInput.Single single(ItemStack stack);

        /**
         * Creates a recipe input for {@link SmithingRecipe}
         *
         * @param templateStack the template item to use
         * @param baseStack the base item to use
         * @param additionStack the additional item to use
         *
         * @return the recipe input
         */
        RecipeInput.Smithing smithing(ItemStack templateStack, ItemStack baseStack, ItemStack additionStack);

        /**
         * Creates a recipe input for {@link CraftingRecipe}
         *
         * @param grid the grid inventory
         *
         * @return the recipe input
         */
        RecipeInput.Crafting crafting(GridInventory grid);

        // TODO get from stonecutter menu?
        // TODO get from smithing menu?
    }

}
