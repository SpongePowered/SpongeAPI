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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.item.inventory.type.GridInventory;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.World;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import javax.annotation.Nullable;

/**
 * A ShapedCraftingRecipe is a CraftingRecipe that has shape and fits into a grid.
 */
public interface ShapedCraftingRecipe extends CraftingRecipe {
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * @return An unmodifiable copy of the original aisle
     */
    List<String> getAisle();

    /**
     * @return All ingredient predicates; if all of these are fulfilled, the recipe can be crafted
     */
    Map<Character, Predicate<ItemStackSnapshot>> getIngredientPredicates();

    /**
     * @param symbol The symbol paired with the ingredient predicate in the aisle
     * @return The paired ingredient predicate
     */
    default Optional<Predicate<ItemStackSnapshot>> getIngredientPredicate(char symbol) {
        return Optional.ofNullable(getIngredientPredicates().get(symbol));
    }

    /**
     * @param x The x coordinate counted from the left side
     * @param y The y coordinate counted from the top
     * @return The ingredient predicate at this position defined by the aisle
     */
    default Optional<Predicate<ItemStackSnapshot>> getIngredientPredicate(int x, int y) {
        if(x < 0 || x >= getWidth() || y < 0 || y >= getHeight())
            return Optional.empty();

        char symbol = getAisle().get(y).charAt(x);

        return getIngredientPredicate(symbol);
    }

    @Override
    default boolean isValid(GridInventory grid, World world) {
        int gapWidth = grid.getColumns() - getWidth();
        int gapHeight = grid.getRows() - getHeight();

        // Shift the aisle along the grid wherever possible
        for(int offsetX = 0; offsetX <= gapWidth; offsetX++) {
            byShiftingTheAisle:
            for(int offsetY = 0; offsetY <= gapHeight; offsetY++) {
                // Test each predicate in the aisle
                for(int aisleX = 0; aisleX < getWidth(); aisleX++) {
                    for(int aisleY = 0; aisleY < getHeight(); aisleY++) {
                        final int finalAisleX = aisleX;
                        final int finalAisleY = aisleY;
                        int gridX = aisleX + offsetX;
                        int gridY = aisleY + offsetY;
                        Slot slot = grid.getSlot(gridX, gridY)
                                .orElseThrow(() -> new IllegalStateException("Could not access the slot," +
                                " even though it was supposed to be in bounds."));
                        ItemStack itemStack = slot.peek()
                                .orElseThrow(() -> new IllegalStateException("Could not access the ItemStack" +
                                " in the slot as it's currently unavailable."));
                        Predicate<ItemStackSnapshot> ingredientPredicate = getIngredientPredicate(aisleX, aisleY)
                                .orElseThrow(() -> new IllegalStateException("The ingredient predicate at [" +
                                        finalAisleX + "; " + finalAisleY + "] is not present. There should be" +
                                        " one for each symbol in the aisle!"));

                        if(!ingredientPredicate.test(itemStack.createSnapshot()))
                            continue byShiftingTheAisle;
                    }
                }

                // Make sure the gap is empty
                for(int gapX = 0; gapX < gapWidth; gapX++) {
                    for(int gapY = 0; gapY < gapHeight; gapY++) {
                        int gridX = gapX + (gapX >= offsetX ? getWidth() : 0);
                        int gridY = gapY + (gapY >= offsetY ? getHeight() : 0);
                        boolean empty = grid.getSlot(gridX, gridY)
                                .flatMap(Slot::peek)
                                .map(itemStack -> itemStack.getItem() == ItemTypes.NONE)
                                .orElse(true);

                        if(!empty)
                            continue byShiftingTheAisle;
                    }
                }

                return true;
            }
        }

        return false;
    }

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

    @Override
    default int getRecipeSize() {
        return getWidth() * getHeight();
    }

    interface Builder extends ResettableBuilder<ShapedCraftingRecipe, Builder> {
        /**
         * Sets the aisle pattern for the shaped recipe.
         *
         * @param aisle A string array of ingredients
         * @return The builder
         */
        Builder aisle(String... aisle);

        /**
         * Sets an ingredient predicate based on the aisle pattern for the shaped recipe.
         *
         * @param symbol The ingredient symbol
         * @param ingredient The ingredient predicate to set, or remove if null
         * @return The builder
         * @throws IllegalArgumentException If the aisle does not contain
         *     the specified character symbol
         */
        Builder where(char symbol, @Nullable Predicate<ItemStackSnapshot> ingredient) throws IllegalArgumentException;

        /**
         * Sets an ingredient predicate based on the aisle pattern for the shaped recipe.
         * This mimics the vanilla checking behavior.
         *
         * @param symbol The ingredient symbol
         * @param ingredient The ingredient to set, or remove if null
         * @return The builder
         * @throws IllegalArgumentException If the aisle does not contain
         *     the specified character symbol
         */
        Builder where(char symbol, @Nullable ItemStackSnapshot ingredient) throws IllegalArgumentException;

        /**
         * Sets an ingredient predicate based on the aisle pattern for the shaped recipe.
         * This mimics the vanilla equality checking behavior.
         *
         * @param symbol The ingredient symbol
         * @param ingredient The predicate to set, or remove if null
         * @return The builder
         * @throws IllegalArgumentException If the aisle does not contain
         *     the specified character symbol
         */
        default Builder where(char symbol, @Nullable ItemStack ingredient) throws IllegalArgumentException {
            return where(symbol, ingredient.createSnapshot());
        }

        /**
         * Sets the resultant {@link ItemStackSnapshot} for when this shaped recipe
         * is correctly crafted.
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
            return result(result.createSnapshot());
        }

        /**
         * Builds a ShapedCraftingRecipe from this builder.
         *
         * @return A new {@link ShapedCraftingRecipe}
         */
        ShapedCraftingRecipe build();
    }
}
