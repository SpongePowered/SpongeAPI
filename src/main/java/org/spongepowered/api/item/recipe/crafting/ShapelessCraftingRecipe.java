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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.crafting.CraftingGridInventory;
import org.spongepowered.api.item.recipe.RecipeRegistration;
import org.spongepowered.api.util.CatalogBuilder;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * A ShapelessCraftingRecipe is a CraftingRecipe that does not have shape and
 * just has a list of ingredients.
 */
public interface ShapelessCraftingRecipe extends CraftingRecipe {

    /**
     * Creates a new {@link Builder} to build a {@link ShapelessCraftingRecipe}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * The Builder for {@link ShapelessCraftingRecipe}s.
     */
    interface Builder extends CatalogBuilder<RecipeRegistration, Builder> {

        /**
         * Adds ingredients for this recipe.
         *
         * @param ingredients The ingredients to add
         *
         * @return This builder, for chaining
         */
        ResultStep addIngredients(ItemType... ingredients);

        /**
         * Adds ingredients for this recipe.
         *
         * @param ingredients The ingredients to add
         *
         * @return This builder, for chaining
         */
        @SuppressWarnings("unchecked")
        ResultStep addIngredients(Supplier<ItemType>... ingredients);

        /**
         * Adds ingredients for this recipe.
         *
         * @param ingredients The ingredients to add
         *
         * @return This builder, for chaining
         */
        ResultStep addIngredients(Ingredient... ingredients);

        /**
         * In this Step set the result of the Recipe.
         */
        interface ResultStep extends Builder {

            /**
             * Sets the remainingItems function. The function must return a list of the same size as the input CraftingGridInventory.
             *
             * @param remainingItemsFunction the remaining items function
             *
             * @return This builder, for chaining
             */
            ResultStep remainingItems(Function<CraftingGridInventory, List<ItemStack>> remainingItemsFunction);

            /**
             * Sets the result and returns this builder. The result is the
             * {@link ItemStack} created when the recipe is fulfilled.
             *
             * @param result The result
             *
             * @return This builder, for chaining
             */
            EndStep result(ItemStackSnapshot result);

            /**
             * Sets the result and returns this builder. The result is the
             * {@link ItemStack} created when the recipe is fulfilled.
             *
             * @param result The result
             *
             * @return This builder, for chaining
             */
            EndStep result(ItemStack result);

            /**
             * Sets the result function and an exemplary result.
             * <p>The exemplary result is used for the recipe book.</p>
             *
             * @param resultFunction The result function
             * @param exemplaryResult The exemplary result stack
             *
             * @return This builder, for chaining
             */
            EndStep result(Function<CraftingGridInventory, ItemStack> resultFunction, ItemStack exemplaryResult);

        }

        /**
         * In this Step set the group of the Recipe and/or build it.
         */
        interface EndStep extends Builder, CatalogBuilder<RecipeRegistration, Builder> {

            /**
             * Sets the group of the recipe.
             *
             * @param name the group
             *
             * @return This builder, for chaining
             */
            EndStep group(@Nullable String name);

            /**
             * Builds the {@link ShapelessCraftingRecipe}.
             *
             * @return The built shapeless crafting recipe
             * @throws IllegalStateException If not all the recipe builder steps are completed
             *                               or the {@link #key(ResourceKey)} isn't set.
             */
            @Override
            RecipeRegistration build() throws IllegalStateException;
        }

    }

}
