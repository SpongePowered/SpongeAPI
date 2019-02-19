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

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.recipe.Recipe;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.api.util.CatalogBuilder;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * A general interface for furnace recipes. You can implement it manually to
 * suit your creative needs, or you can simply use the
 * {@link SmeltingRecipe.Builder}.
 */
public interface SmeltingRecipe extends Recipe, CatalogType {

    /**
     * Builds a simple furnace recipe. Note, that you can implement the
     * {@link SmeltingRecipe} manually, too.
     *
     * @return A {@link SmeltingRecipe} builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    @Override
    default String getId() {
        return "sponge:" + getClass().getName().toLowerCase().replaceAll("[.$]", "_");
    }

    @Override
    default String getName() {
        return getId();
    }

    /**
     * An exemplary {@link ItemStackSnapshot}, which will always make
     * {@link #isValid(ItemStackSnapshot)} return {@code true}.
     *
     * @return The {@link ItemStackSnapshot} as explained above
     */
    ItemStackSnapshot getExemplaryIngredient();

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
     * <p>This method should be used instead of the {@link #getExemplaryResult()}
     * method, as it customizes the result further depending on the specified
     * ingredient {@link ItemStackSnapshot}. It is advised to use
     * the output of {@link #getExemplaryResult()}, modify it accordingly,
     * and {@code return} it.</p>
     *
     * @param ingredient The {@link ItemStackSnapshot} currently being smelted
     * @return The {@link SmeltingResult}, or {@link Optional#empty()}
     *         if the recipe is not valid according to
     *         {@link #isValid(ItemStackSnapshot)}.
     */
    Optional<SmeltingResult> getResult(ItemStackSnapshot ingredient);

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
            return ingredient(itemStackSnapshot -> itemStackSnapshot.getType() == ingredient, ingredient.getTemplate());
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

            @Override
            EndStep id(String id);

            @Override
            EndStep name(String name);

            @Override
            EndStep name(Translation name);

            @Override
            SmeltingRecipe build();
        }
    }
}
