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

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Arrays;
import java.util.Optional;

import javax.annotation.Nullable;

/**
 * A ShapedCraftingRecipe is a Recipe that has shape and fits into a grid.
 */
public interface ShapedCraftingRecipe extends CraftingRecipe {

    /**
     * Creates a new {@link Builder} to build a {@link ShapedCraftingRecipe}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the shape of the recipe.
     *
     * <p>This returns an unmodifiable copy of the original aisle.</p>
     *
     * @return The aisle
     */
    ImmutableCollection<String> getShape();

    /**
     * Gets the ingredients.
     *
     * @return The ingredients
     */
    ImmutableMap<Character, ItemStackSnapshot> getIngredients();

    /**
     * Gets the ingredient represented by the given symbol.
     *
     * @param symbol The ingredient's symbol
     * @return The ingredient if present, otherwise {@link Optional#empty()}
     */
    Optional<ItemStackSnapshot> getIngredient(char symbol);

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
     * Represents a builder class to create {@link ShapedCraftingRecipe}s.
     *
     * @see ShapedCraftingRecipe
     */
    interface Builder extends ResettableBuilder<ShapedCraftingRecipe, Builder> {

        /**
         * Sets the pattern for the shaped recipe.
         *
         * @param aisle A string array of ingredients
         * @return The builder
         */
        Builder shape(String... aisle);

        /**
         * Sets an ingredient based on the pattern for the shaped recipe.
         * (Minecraft codes it so that it only takes one item)
         *
         * @param symbol The ingredient symbol
         * @param ingredient The ingredient to set, or remove if null
         * @return The builder
         * @throws IllegalArgumentException If the shape does not contain
         *     the specified character symbol
         */
        default Builder where(char symbol, ItemType ingredient) throws IllegalArgumentException {
            return where(symbol, ingredient.getTemplate().createStack());
        }

        /**
         * Sets an ingredient based on the pattern for the shaped recipe.
         * (Minecraft codes it so that it only takes one item)
         *
         * @param symbol The ingredient symbol
         * @param ingredient The ingredient to set, or remove if null
         * @return The builder
         * @throws IllegalArgumentException If the shape does not contain
         *     the specified character symbol
         */
        Builder where(char symbol, @Nullable ItemStack ingredient) throws IllegalArgumentException;

        /**
         * Sets the resultant {@link ItemStackSnapshot}s for when this shaped recipe
         * is correctly crafted.
         *
         * @param result The resultant stacks
         * @return The builder
         */
        default Builder results(ItemStack... result) {
            return results(Arrays.asList(result));
        }

        /**
         * Sets the resultant {@link ItemStackSnapshot}s for when this shaped recipe
         * is correctly crafted.
         *
         * @param result The resultant stacks
         * @return The builder
         */
        Builder results(Iterable<ItemStack> result);

        /**
         * Builds a ShapedCraftingRecipe from this builder.
         *
         * @return A new {@link ShapedCraftingRecipe}
         */
        ShapedCraftingRecipe build();
    }

}
