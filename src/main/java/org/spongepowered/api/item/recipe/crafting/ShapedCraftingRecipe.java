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

import static com.google.common.base.Preconditions.checkNotNull;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.util.CatalogBuilder;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Map;

/**
 * A ShapedCraftingRecipe is a CraftingRecipe that has shape and fits into
 * a grid.
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
     * Returns the ingredient predicate at the specified location in this
     * recipe.
     *
     * @param x The x coordinate counted from the left side
     * @param y The y coordinate counted from the top
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
     * The builder which you create {@link ShapedCraftingRecipe}s through.
     *
     * <p>First decide how you want to build your recipe. Either by defining
     * the pattern with {@link #aisle} and then setting {@link AisleStep#where}
     * the ingredients are, or by defining the pattern using {@link #rows}
     * adding each {@link RowsStep#row} of ingredients after the other. When the
     * ingredients are set define the {@link ResultStep#result} of the recipe.
     * Next you can define its {@link EndStep#group}. And
     * finally {@link EndStep#build} your recipe.</p>
     *
     * <p>Here is an example, where the two resulting recipes are identical:</p>

     * <pre>
     * {@code
     *     Ingredient log = Ingredient.of(LOG);
     *     ShapedCraftingRecipe.builder()
     *         .aisle("sss")
     *         .where('s', log)
     *         .result(ItemStack.of(WOODEN_PRESSURE_PLATE, 1))
     *         .build("mypressureplate", plugin);
     *
     *     ShapedCraftingRecipe.builder()
     *         .rows()
     *         .row(log, log, log)
     *         .result(ItemStack.of(WOODEN_PRESSURE_PLATE, 1))
     *         .build("mypressureplate", plugin);
     * }
     * </pre>
     */
    interface Builder extends ResettableBuilder<ShapedCraftingRecipe, Builder> {

        /**
         * Start building a new recipe based on the aisle pattern.
         *
         * <p>Use {@link AisleStep#where} to assign ingredients to characters
         * of the aisles.</p>
         *
         * <p>The space character will be defaulted to {@link Ingredient#NONE}
         * if not specified.</p>
         *
         * <p>Any other not assigned characters will cause an Exception
         * when {@link EndStep#build}ing the Recipe.</p>
         *
         * @param aisle A string array of ingredients
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
             * <p>Sets the ingredient to {@link Ingredient#NONE} if
             * {@code null} is specified.</p>
             *
             * @param symbol The ingredient symbol
             * @param ingredient The ingredient to set
             * @return The builder
             * @throws IllegalArgumentException If the aisle does not contain
             *     the specified character symbol
             */
            AisleStep.ResultStep where(char symbol, @Nullable Ingredient ingredient) throws IllegalArgumentException;

            /**
             * Sets multiple ingredients based on the aisle pattern.
             *
             * @param ingredientMap The ingredients to set
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
             * @return This builder
             */
            default RowsStep.ResultStep row(Ingredient... ingredients) {
                return this.row(0, ingredients);
            }

            /**
             * Adds a row of ingredients filling the skipped
             * columns with {@link Ingredient#NONE}.
             *
             * @param skip The amount of columns to skip.
             * @param ingredients The row of ingredients.
             * @return This builder
             */
            RowsStep.ResultStep row(int skip, Ingredient... ingredients);

        }

        /**
         * Copies the ingredients and shape from given recipe.
         * <p>Registering this recipe will override the original recipe</p>TODO does it?
         *
         * @param recipe the original recipe
         *
         * @return This builder
         */
        ResultStep shapedLike(ShapedCraftingRecipe recipe);

        /**
         * In this Step set the result of the recipe.
         */
        interface ResultStep extends Builder {

            /**
             * Sets the resultant {@link ItemStackSnapshot} for when this shaped
             * recipe is correctly crafted.
             *
             * @param result The resultant snapshot
             * @return The builder
             */
            default EndStep result(ItemStackSnapshot result) {
                checkNotNull(result, "result");
                return this.result(result.createStack());
            }

            /**
             * Sets the resultant {@link ItemStack} for when this shaped recipe
             * is correctly crafted.
             *
             * @param result The resultant stack
             * @return The builder
             */
            EndStep result(ItemStack result);
        }

        /**
         * In this Step set the group of the Recipe and/or build it.
         */
        interface EndStep extends Builder, CatalogBuilder<ShapedCraftingRecipe, Builder> {

            /**
             * Sets the group of the recipe.
             *
             * @param name the group
             * @return This builder, for chaining
             */
            EndStep group(@Nullable String name);

            @Override
            EndStep key(CatalogKey key);

            /**
             * Builds the {@link ShapedCraftingRecipe}.
             *
             * @return The built shaped crafting recipe
             * @throws IllegalStateException If not all the recipe builder steps are completed
             *                               or the {@link #key(CatalogKey)} isn't set.
             */
            @Override
            ShapedCraftingRecipe build() throws IllegalStateException;
        }
    }

}
