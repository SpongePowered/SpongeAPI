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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.function.Predicate;

import javax.annotation.Nullable;

/**
 * A ShapedCraftingRecipe is a CraftingRecipe that has shape and fits into
 * a grid.
 */
public interface ShapedCraftingRecipe extends CraftingRecipe {

    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
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
    Predicate<ItemStackSnapshot> getIngredientPredicate(int x, int y);

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

    interface Builder extends ResettableBuilder<ShapedCraftingRecipe, Builder> {

        /**
         * Sets the aisle pattern for the shaped recipe and resets the
         * registered ingredient predicates.
         * <p>An aisle represents a single row of the crafting inventory
         * input. Use the {@link #where(char, Predicate)} to assign ingredient
         * predicates to characters of the aisles.</p>
         *
         * @param aisle A string array of ingredients
         * @return The builder
         */
        Builder aisle(@Nullable String... aisle);

        /**
         * Sets an ingredient predicate based on the aisle pattern for the
         * shaped recipe. Removes the ingredient predicate if {@code null} is
         * specified.
         *
         * @param symbol The ingredient symbol
         * @param ingredient The ingredient predicate to set, or remove if null
         * @return The builder
         * @throws IllegalArgumentException If the aisle does not contain
         *     the specified character symbol
         */
        Builder where(char symbol, @Nullable Predicate<ItemStackSnapshot> ingredient) throws IllegalArgumentException;

        /**
         * Sets an ingredient predicate based on the aisle pattern for the
         * shaped recipe. This mimics the vanilla checking behavior.
         *
         * @param symbol The ingredient symbol
         * @param ingredient The ingredient to set, or remove if {@code null} or
         *                   {@link ItemStackSnapshot#NONE}
         * @return The builder
         * @throws IllegalArgumentException If the aisle does not contain
         *     the specified character symbol
         */
        Builder where(char symbol, @Nullable ItemStackSnapshot ingredient) throws IllegalArgumentException;

        /**
         * Sets an ingredient predicate based on the aisle pattern for the
         * shaped recipe. This mimics the vanilla equality checking behavior.
         *
         * @param symbol The ingredient symbol
         * @param ingredient The ingredient to set, or remove if {@code null}
         * @return The builder
         * @throws IllegalArgumentException If the aisle does not contain
         *     the specified character symbol
         */
        default Builder where(char symbol, @Nullable ItemStack ingredient) throws IllegalArgumentException {
            return where(symbol, ingredient != null ? ingredient.createSnapshot() : null);
        }

        /**
         * Sets an ingredient predicate based on the aisle pattern for the
         * shaped recipe. This mimics the vanilla equality checking behavior.
         *
         * @param symbol The ingredient symbol
         * @param ingredient The ingredient type to set, or remove if null
         * @return The builder
         * @throws IllegalArgumentException If the aisle does not contain
         *     the specified character symbol
         */
        default Builder where(char symbol, @Nullable ItemType ingredient) throws IllegalArgumentException {
            return where(symbol, ingredient != null ? (itemStackSnapshot -> itemStackSnapshot.getType() == ingredient) : null);
        }

        /**
         * Sets the resultant {@link ItemStackSnapshot} for when this shaped
         * recipe is correctly crafted.
         *
         * @param result The resultant snapshot
         * @return The builder
         */
        Builder result(ItemStackSnapshot result);

        /**
         * Sets the resultant {@link ItemStack} for when this shaped recipe
         * is correctly crafted.
         *
         * @param result The resultant stack
         * @return The builder
         */
        default Builder result(ItemStack result) {
            checkNotNull(result, "result");

            return result(result.createSnapshot());
        }

        /**
         * Builds a {@link ShapedCraftingRecipe} from this builder.
         *
         * @return A new {@link ShapedCraftingRecipe}
         * @throws IllegalStateException If not all required options were specified
         */
        ShapedCraftingRecipe build();

    }

}
