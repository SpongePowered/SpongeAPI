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
package org.spongepowered.api.item.recipe.cooking;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.recipe.Recipe;
import org.spongepowered.api.item.recipe.RecipeRegistration;
import org.spongepowered.api.item.recipe.RecipeType;
import org.spongepowered.api.item.recipe.crafting.Ingredient;
import org.spongepowered.api.util.CatalogBuilder;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * A general interface for cooking-type/furnace recipes.
 */
public interface CookingRecipe extends Recipe {

    /**
     * Builds a cooking recipe.
     *
     * @return A {@link CookingRecipe} builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Returns the {@link Ingredient} for this {@link CookingRecipe}.
     *
     * @return The {@link Ingredient} for this {@link CookingRecipe}.
     */
    Ingredient getIngredient();

    /**
     * Checks if the given {@link ItemStackSnapshot} fits the required
     * constraints to craft this {@link CookingRecipe}.
     *
     * @param ingredient The ingredient to check against
     *
     * @return Whether this ingredient can be used to craft the result
     */
    boolean isValid(ItemStackSnapshot ingredient);

    /**
     * <p>Returns the {@link CookingResult} containing the resulting
     * {@link ItemStackSnapshot} and the amount of experience released.</p>
     *
     * @param ingredient The {@link ItemStackSnapshot} currently being cooked
     * @return The {@link CookingResult}, or {@link Optional#empty()}
     *         if the recipe is not valid according to
     *         {@link #isValid(ItemStackSnapshot)}.
     */
    Optional<CookingResult> getResult(ItemStackSnapshot ingredient);

    /**
     * Returns the cooking time in ticks.
     *
     * @return The cooking time in ticks.
     */
    int getCookingTime();

    /**
     * Returns the experience of this recipe.
     *
     * @return The experience of this recipe.
     */
    float getExperience();

    /**
     * Builds a simple furnace recipe.
     */
    interface Builder extends CatalogBuilder<RecipeRegistration, Builder> {

        /**
         * Sets the type of recipe
         *
         * @param type the type of recipe
         *
         * @return This builder, for chaining
         */
        IngredientStep type(RecipeType<CookingRecipe> type);

        /**
         * Sets the type of recipe
         *
         * @param type the type of recipe
         *
         * @return This builder, for chaining
         */
        default IngredientStep type(Supplier<RecipeType<CookingRecipe>> type) {
            return this.type(type.get());
        }

        interface IngredientStep extends Builder {

            /**
             * Changes the ingredient and returns this builder.
             * The {@link Ingredient} required in order for the recipe to be fulfilled.
             *
             * @param ingredient The required ingredient
             *
             * @return This builder, for chaining
             */
            ResultStep ingredient(Ingredient ingredient);

            /**
             * Changes the ingredient and returns this builder.
             * The {@link Ingredient} required in order for the recipe to be fulfilled.
             *
             * @param ingredient The required ingredient
             *
             * @return This builder, for chaining
             */
            default ResultStep ingredient(ItemType ingredient) {
                return this.ingredient(Ingredient.of(ingredient));
            }

            /**
             * Changes the ingredient and returns this builder.
             * The {@link Ingredient} required in order for the recipe to be fulfilled.
             *
             * @param ingredient The required ingredient
             *
             * @return This builder, for chaining
             */
            default ResultStep ingredient(Supplier<ItemType> ingredient) {
                return this.ingredient(ingredient.get());
            }
        }

        interface ResultStep extends Builder {

            /**
             * Changes the result and returns this builder. The result is the
             * {@link ItemType} created when the recipe is fulfilled.
             *
             * @param result The output of this recipe
             * @return This builder, for chaining
             */
            EndStep result(ItemType result);

            /**
             * Changes the result and returns this builder. The result is the
             * {@link ItemType} created when the recipe is fulfilled.
             *
             * @param result The output of this recipe
             * @return This builder, for chaining
             */
            default EndStep result(Supplier<ItemType> result) {
                return this.result(result.get());
            }

            /**
             * Changes the result and returns this builder. The result is the
             * {@link ItemStack} created when the recipe is fulfilled.
             *
             * @param result The output of this recipe
             *
             * @return This builder, for chaining
             */
            EndStep result(ItemStack result);

            /**
             * Changes the result and returns this builder. The result is the
             * {@link ItemStack} created when the recipe is fulfilled.
             *
             * @param result The output of this recipe
             *
             * @return This builder, for chaining
             */
            EndStep result(ItemStackSnapshot result);
        }

        interface EndStep extends Builder, CatalogBuilder<RecipeRegistration, Builder> {

            /**
             * Sets the group of the recipe.
             *
             * @param name the group
             * @return This builder, for chaining
             */
            EndStep group(@Nullable String name);

            /**
             * Changes the experience and returns this builder.
             *
             * @param experience The amount of experience released when this recipe is completed
             *
             * @return This builder, for chaining
             */
            EndStep experience(double experience);

            /**
             * Sets the cookingTime for this recipe in ticks.
             *
             * @param ticks the cookingTime
             *
             * @return This builder, for chaining
             */
            EndStep cookingTime(int ticks);

        }
    }
}
