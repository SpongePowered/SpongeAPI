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

import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.api.util.CatalogBuilder;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.List;

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
    List<Ingredient> getIngredientPredicates();

    /**
     * Builder for {@link ShapelessCraftingRecipe}s.
     */
    interface Builder extends ResettableBuilder<ShapelessCraftingRecipe, Builder> {

        /**
         * Adds an ingredient predicate to the requirements of this
         * {@link ShapelessCraftingRecipe}.
         *
         * @param ingredient The ingredient predicate
         * @return This builder, for chaining
         */
        ResultStep addIngredient(Ingredient ingredient);

        /**
         * In this Step set the result of the Recipe.
         */
        interface ResultStep extends Builder {

            /**
             * Changes the result and returns this builder. The result is the
             * {@link ItemStack} created when the recipe is fulfilled.
             *
             * @param result The result
             * @return This builder, for chaining
             */
            EndStep result(ItemStackSnapshot result);

            /**
             * Changes the result and returns this builder. The result is the
             * {@link ItemStack} created when the recipe is fulfilled.
             *
             * @param result The result
             * @return This builder, for chaining
             */
            default EndStep result(ItemStack result) {
                checkNotNull(result, "result");

                return result(result.createSnapshot());
            }
        }

        /**
         * In this Step set the group of the Recipe and/or build it.
         */
        interface EndStep extends Builder, CatalogBuilder<ShapelessCraftingRecipe, Builder> {

            /**
             * Sets the group of the recipe.
             *
             * @param name the group
             * @return This builder, for chaining
             */
            EndStep group(@Nullable String name);

            @Override
            EndStep key(CatalogKey key);

            @Override
            EndStep id(String id);

            @Override
            EndStep name(String name);

            @Override
            EndStep name(Translation name);

            /**
             * Builds the {@link ShapelessCraftingRecipe}.
             *
             * @return The built shapeless crafting recipe
             * @throws IllegalStateException If not all the recipe builder steps are completed
             *                               or the {@link #key(CatalogKey)} isn't set.
             */
            @Override
            ShapelessCraftingRecipe build() throws IllegalStateException;

            /**
             * @deprecated It's not allowed to duplicate shapeless crafting recipes.
             */
            @Deprecated
            @Override
            default Builder from(ShapelessCraftingRecipe value) {
                throw new UnsupportedOperationException("Duplicating shapeless crafting recipes isn't allowed.");
            }
        }

    }

}
