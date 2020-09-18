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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.crafting.CraftingGridInventory;
import org.spongepowered.api.item.recipe.RecipeRegistration;
import org.spongepowered.api.util.CatalogBuilder;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.server.ServerWorld;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * Recipes with custom matching/result logic.
 * <p>Special recipes cannot be displayed in a recipe book.</p>
 */
public interface SpecialCraftingRecipe extends CraftingRecipe {

    /**
     * Creates a new {@link SpecialCraftingRecipe.Builder} to build a {@link SpecialCraftingRecipe}.
     *
     * @return The new builder
     */
    static SpecialCraftingRecipe.Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(SpecialCraftingRecipe.Builder.class);
    }

    interface Builder extends ResettableBuilder<RecipeRegistration, SpecialCraftingRecipe.Builder> {

        /**
         * Sets the recipe matcher.
         *
         * @param biPredicate The matching predicate
         *
         * @return This builder, for chaining
         */
        SpecialCraftingRecipe.Builder.ResultStep matching(BiPredicate<CraftingGridInventory, ServerWorld> biPredicate);

        /**
         * In this Step set the result of the Recipe.
         * <p>Optionally configure the remaining items.</p>
         */
        interface ResultStep extends SpecialCraftingRecipe.Builder {

            /**
             * Sets the remainingItems function. The function must return a list of the same size as the input CraftingGridInventory.
             *
             * @param remainingItemsFunction the remaining items function
             *
             * @return This builder, for chaining
             */
            ResultStep remainingItems(Function<CraftingGridInventory, List<ItemStack>> remainingItemsFunction);

            /**
             * Sets the result function.
             *
             * @param resultFunction The result function
             *
             * @return This builder, for chaining
             */
            EndStep result(Function<CraftingGridInventory, ItemStack> resultFunction);

            /**
             * Sets the result
             *
             * @param result The result
             *
             * @return This builder, for chaining
             */
            EndStep result(ItemStack result);
        }

        interface EndStep extends SpecialCraftingRecipe.Builder, CatalogBuilder<RecipeRegistration, SpecialCraftingRecipe.Builder> {

            @Override
            EndStep key(ResourceKey key);

            /**
             * Builds the {@link SpecialCraftingRecipe}.
             *
             * @return The built special crafting recipe
             * @throws IllegalStateException If not all the recipe builder steps are completed
             *                               or the {@link #key(ResourceKey)} isn't set.
             */
            @Override
            RecipeRegistration build() throws IllegalStateException;
        }

    }

}
