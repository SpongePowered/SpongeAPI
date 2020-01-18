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

import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.recipe.Recipe;
import org.spongepowered.api.item.recipe.RecipeType;
import org.spongepowered.api.item.recipe.crafting.Ingredient;
import org.spongepowered.api.util.CatalogBuilder;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * A general interface for furnace-type recipes.
 */
public interface SmeltingRecipe extends Recipe {

    /**
     * Builds a simple furnace recipe. Note, that you can implement the
     * {@link SmeltingRecipe} manually, too.
     *
     * @return A {@link SmeltingRecipe} builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Returns the {@link Ingredient} for this {@link SmeltingRecipe}.
     *
     * @return The {@link Ingredient} for this {@link SmeltingRecipe}.
     */
    Ingredient getIngredient();

    /**
     * Checks if the given {@link ItemStackSnapshot} fits the required
     * constraints to craft this {@link SmeltingRecipe}.
     *
     * @param ingredient The ingredient to check against
     * @return Whether this ingredient can be used to craft the result
     */
    boolean isValid(ItemStackSnapshot ingredient);

    /**
     * <p>Returns the {@link SmeltingResult} containing the resulting
     * {@link ItemStackSnapshot} and the amount of experience released.</p>
     *
     * @param ingredient The {@link ItemStackSnapshot} currently being smelted
     * @return The {@link SmeltingResult}, or {@link Optional#empty()}
     *         if the recipe is not valid according to
     *         {@link #isValid(ItemStackSnapshot)}.
     */
    Optional<SmeltingResult> getResult(ItemStackSnapshot ingredient);

    /**
     * Returns the smelting time in ticks.
     *
     * @return The smelting time in ticks.
     */
    int getSmeltTime();

    /**
     * Returns the experience of this recipe.
     *
     * @return The experience of this recipe.
     */
    float getExperience();

    /**
     * Builds a simple furnace recipe.
     */
    interface Builder extends ResettableBuilder<SmeltingRecipe, Builder> {

        /**
         * Changes the ingredient predicate and returns this builder.
         * The ingredient predicate is the predicate which must return
         * {@code true} in order for this recipe to be fulfilled.
         *
         * @param ingredientPredicate The ingredient predicate
         * @param exemplaryIngredient An exemplary ingredient
         * @return This builder, for chaining
         */
        ResultStep ingredient(Predicate<ItemStackSnapshot> ingredientPredicate, ItemStackSnapshot exemplaryIngredient);

        /**
         * Changes the ingredient predicate and returns this builder.
         * The ingredient predicate is the predicate which must return
         * {@code true} in order for this recipe to be fulfilled.
         *
         * <p>The vanilla {@link ItemStack} matching behavior is used as the
         * ingredient predicate.</p>
         *
         * @param ingredient The required ingredient
         * @return This builder, for chaining
         */
        ResultStep ingredient(ItemStackSnapshot ingredient);

        /**
         * Changes the ingredient and returns this builder. The ingredient is
         * the {@link ItemStack} required in order for the recipe to be
         * fulfilled.
         *
         * @param ingredient The required ingredient
         * @return This builder, for chaining
         */
        default ResultStep ingredient(ItemStack ingredient) {
            return ingredient(ingredient.createSnapshot());
        }

        /**
         * Changes the ingredient and returns this builder. The ingredient is
         * the {@link ItemStack} required in order for the recipe to be
         * fulfilled.
         *
         * @param ingredient The required ingredient
         * @return This builder, for chaining
         */
        default ResultStep ingredient(ItemType ingredient) {
            return ingredient(itemStackSnapshot -> itemStackSnapshot.getType() == ingredient, ItemStack.of(ingredient).createSnapshot());
        }

        interface ResultStep extends Builder {

            /**
             * Changes the result and returns this builder. The result is the
             * {@link ItemStack} created when the recipe is fulfilled.
             *
             * @param result The output of this recipe
             * @return This builder, for chaining
             */
            EndStep result(ItemStackSnapshot result);

            /**
             * Changes the result and returns this builder. The result is the
             * {@link ItemStack} created when the recipe is fulfilled.
             *
             * @param result The output of this recipe
             * @return This builder, for chaining
             */
            default EndStep result(ItemStack result) {
                return result(result.createSnapshot());
            }

        }

        interface EndStep extends Builder, CatalogBuilder<SmeltingRecipe, Builder> {

            /**
             * Changes the experience and returns this builder. It is the
             * required amount of experience the user must possess in order to
             * be able to fulfill the recipe.
             *
             * @param experience The amount of experience released when this
             *     recipe is completed
             * @return This builder, for chaining
             */
            EndStep experience(double experience);

            // in ticks
            EndStep cookTime(double time);

            // TODO required
            EndStep type(RecipeType<SmeltingRecipe> type);

            @Override
            EndStep key(CatalogKey key);


            /**
             * Builds the {@link SmeltingRecipe}.
             *
             * @return The built smelting recipe
             * @throws IllegalStateException If not all the recipe builder steps are completed
             *                               or the {@link #key(CatalogKey)} isn't set.
             */
            @Override
            SmeltingRecipe build() throws IllegalStateException;
        }
    }
}
