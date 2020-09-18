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
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.crafting.CraftingGridInventory;
import org.spongepowered.api.item.recipe.RecipeRegistration;
import org.spongepowered.api.util.CatalogBuilder;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * A ShapedCraftingRecipe is a CraftingRecipe that has shape and fits into a grid.
 */
public interface ShapedCraftingRecipe extends CraftingRecipe {

    /**
     * Creates a new {@link ShapedCraftingRecipe.Builder} to build a {@link ShapedCraftingRecipe}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Returns the ingredient at the specified location in this recipe.
     *
     * @param x The x coordinate counted from the left side
     * @param y The y coordinate counted from the top
     *
     * @return The ingredient predicate at this position defined by the aisle
     * @throws IndexOutOfBoundsException if the location is invalid
     */
    Ingredient getIngredient(int x, int y);

    /**
     * Gets the width of the grid this ShapedCraftingRecipe fits into.
     *
     * @return The width of the grid
     */
    int getWidth();

    /**
     * Gets the height of the grid this ShapedCraftingRecipe fits into.
     *
     * @return The height of the grid
     */
    int getHeight();

    /**
     * The Builder for {@link ShapedCraftingRecipe}s.
     *
     * <p>The shaped recipe pattern can be built one of two ways:</p>
     * <p>Either by defining the pattern with {@link #aisle} and then setting {@link AisleStep#where} the ingredients are.</p>
     * <p>Or by defining the pattern using {@link #rows} adding each {@link RowsStep#row} of ingredients after the other.</p>

     * <pre>
     * {@code
     *     Ingredient log = Ingredient.of(LOG);
     *     ShapedCraftingRecipe.builder()
     *         .aisle("sss")
     *         .where('s', log)
     *         .result(ItemStack.of(WOODEN_PRESSURE_PLATE, 1))
     *         .key(RessourceKey.of(plugin, "my_pressure_plate))
     *         .build();
     *
     *     ShapedCraftingRecipe.builder()
     *         .rows()
     *         .row(log, log, log)
     *         .result(ItemStack.of(WOODEN_PRESSURE_PLATE, 1))
     *         .key(RessourceKey.of(plugin, "my_pressure_plate))
     *         .build();
     * }
     * </pre>
     */
    interface Builder extends CatalogBuilder<RecipeRegistration, Builder> {

        /**
         * Start building a new recipe based on the aisle pattern.
         *
         * <p>Use {@link AisleStep#where} to assign ingredients to characters
         * of the aisles.</p>
         *
         * <p>Use the space character for {@link Ingredient#empty()}</p>
         *
         * <p>Any other not assigned characters will cause an Exception
         * when {@link EndStep#build}ing the Recipe.</p>
         *
         * @param aisle A string array of ingredients
         *
         * @return The builder
         */
        AisleStep aisle(String... aisle);

        /**
         * In this Step define one or more Ingredients.
         */
        interface AisleStep extends Builder {

            /**
             * In this Step define one or more Ingredients or continue by
             * setting the result.
             */
            interface ResultStep extends AisleStep, Builder.ResultStep {}

            /**
             * Sets an ingredient based on the aisle pattern.
             *
             * <p>Sets the ingredient to {@link Ingredient#empty()} if
             * {@code null} is specified.</p>
             *
             * @param symbol The ingredient symbol
             * @param ingredient The ingredient to set
             *
             * @return The builder
             * @throws IllegalArgumentException If the aisle does not contain
             *     the specified character symbol
             */
            AisleStep.ResultStep where(char symbol, @Nullable Ingredient ingredient) throws IllegalArgumentException;

            /**
             * Sets multiple ingredients based on the aisle pattern.
             *
             * @param ingredientMap The ingredients to set
             *
             * @return The builder
             * @throws IllegalArgumentException If the aisle does not contain
             *     the specified character symbol
             */
            AisleStep.ResultStep where(Map<Character, Ingredient> ingredientMap) throws IllegalArgumentException;

        }

        /**
         * Start building a new recipe with ingredients based on rows.
         * After this call {@link RowsStep#row} for each row of your recipe.
         *
         * @return This builder
         */
        RowsStep rows();

        /**
         * In this Step add one or more rows of Ingredients.
         */
        interface RowsStep extends Builder {

            /**
             * In this Step add one or more rows of Ingredients or continue
             * by setting the result.
             */
            interface ResultStep extends RowsStep, Builder.ResultStep {}

            /**
             * Adds a row of ingredients.
             *
             * @param ingredients The row of ingredients.
             *
             * @return This builder
             */
            default RowsStep.ResultStep row(Ingredient... ingredients) {
                return this.row(0, ingredients);
            }

            /**
             * Adds a row of ingredients filling the skipped
             * columns with {@link Ingredient#empty()}.
             *
             * @param skip The amount of columns to skip.
             * @param ingredients The row of ingredients.
             *
             * @return This builder
             */
            RowsStep.ResultStep row(int skip, Ingredient... ingredients);

        }

        /**
         * In this Step set the result of the recipe.
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
             * Sets the resultant {@link ItemStackSnapshot} for when this shaped
             * recipe is correctly crafted.
             *
             * @param result The resultant snapshot
             *
             * @return The builder
             */
            EndStep result(ItemStackSnapshot result);

            /**
             * Sets the resultant {@link ItemStack} for when this shaped recipe
             * is correctly crafted.
             *
             * @param result The resultant stack
             *
             * @return The builder
             */
            EndStep result(ItemStack result);

            /**
             * Sets the result function and an exemplary result.
             * <p>Use {@link ItemStack#empty()} as exemplary result if the function returns different items.</p>
             *
             * @param resultFunction The result function
             * @param exemplaryResult The exemplary result stack
             *
             * @return The builder
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
             * Builds the {@link ShapedCraftingRecipe}.
             *
             * @return The built shaped crafting recipe
             * @throws IllegalStateException If not all the recipe builder steps are completed
             *                               or the {@link #key(ResourceKey)} isn't set.
             */
            @Override
            RecipeRegistration build() throws IllegalStateException;
        }
    }

}
