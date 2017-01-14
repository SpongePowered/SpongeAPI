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
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Nullable;

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
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the ingredient predicates for this ShapelessCraftingRecipe.
     *
     * @return An unmodifiable list of the ingredient predicates
     */
    List<Predicate<ItemStackSnapshot>> getIngredientPredicates();

    interface Builder extends ResettableBuilder<ShapelessCraftingRecipe, Builder> {

        /**
         * Adds an ingredient predicate to the requirements of this
         * {@link ShapelessCraftingRecipe}.
         *
         * @param ingredient The ingredient predicate
         * @return This builder, for chaining
         */
        Builder addIngredientPredicate(@Nullable Predicate<ItemStackSnapshot> ingredient);

        /**
         * Adds an ingredient predicate to the requirements of this
         * {@link ShapelessCraftingRecipe}. This mimics the vanilla equality
         * checking behavior.
         *
         * @param ingredient The ingredient
         * @return This builder, for chaining
         */
        Builder addIngredientPredicate(ItemStackSnapshot ingredient);

        /**
         * Adds an ingredient predicate to the requirements of this
         * {@link ShapelessCraftingRecipe}. This mimics the vanilla equality
         * checking behavior.
         *
         * @param ingredient The ingredient
         * @return This builder, for chaining
         */
        @SuppressWarnings("ConstantConditions")
        default Builder addIngredientPredicate(@Nullable ItemStack ingredient) {
            return addIngredientPredicate(ingredient != null ? ingredient.createSnapshot() : ItemStackSnapshot.NONE);
        }

        /**
         * Changes the result and returns this builder. The result is the
         * {@link ItemStack} created when the recipe is fulfilled.
         *
         * @param result The result
         * @return This builder, for chaining
         */
        Builder result(ItemStackSnapshot result);

        /**
         * Changes the result and returns this builder. The result is the
         * {@link ItemStack} created when the recipe is fulfilled.
         *
         * @param result The result
         * @return This builder, for chaining
         */
        @SuppressWarnings("ConstantConditions")
        default Builder result(@Nullable ItemStack result) {
            return result(result != null ? result.createSnapshot() : ItemStackSnapshot.NONE);
        }

        /**
         * Builds a new {@link ShapelessCraftingRecipe} from this builder.
         *
         * @return A new {@link ShapelessCraftingRecipe}
         */
        ShapelessCraftingRecipe build();

    }

}
