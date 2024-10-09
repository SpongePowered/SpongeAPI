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
import org.spongepowered.api.datapack.DataPack;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackLike;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.recipe.RecipeRegistration;
import org.spongepowered.api.util.ResourceKeyedBuilder;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * A ShapelessCraftingRecipe is a CraftingRecipe that does not have shape and
 * just has a list of ingredients.
 */
public interface ShapelessCraftingRecipe extends CraftingRecipe {

    /**
     * Gets the ingredients for this recipe.
     *
     * @return An unmodifiable list of the ingredients.
     */
    List<Ingredient> ingredients();

    /**
     * Creates a new {@link Builder} to build a {@link ShapelessCraftingRecipe}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * The Builder for {@link ShapelessCraftingRecipe}s.
     */
    interface Builder extends ResourceKeyedBuilder<RecipeRegistration, Builder> {

        /**
         * Adds ingredients for this recipe.
         *
         * @param ingredients The ingredients to add
         *
         * @return This builder, for chaining
         */
        ResultStep addIngredients(ItemType... ingredients);

        /**
         * Adds ingredients for this recipe.
         *
         * @param ingredients The ingredients to add
         *
         * @return This builder, for chaining
         */
        @SuppressWarnings("unchecked")
        ResultStep addIngredients(Supplier<? extends ItemType>... ingredients);

        /**
         * Adds ingredients for this recipe.
         *
         * @param ingredients The ingredients to add
         *
         * @return This builder, for chaining
         */
        ResultStep addIngredients(Ingredient... ingredients);

        /**
         * In this Step set the result of the Recipe.
         */
        interface ResultStep extends Builder {

            /**
             * Sets the remainingItems function. The function must return a list of the same size as the input CraftingGridInventory.
             *
             * @param remainingItemsFunction the remaining items function
             *
             * @return This builder, for chaining
             */
            ResultStep remainingItems(Function<RecipeInput.Crafting, ? extends List<? extends ItemStackLike>> remainingItemsFunction);

            /**
             * @deprecated Use {@link #result(ItemStackLike)} instead.
             */
            @Deprecated(forRemoval = true)
            default EndStep result(ItemStackSnapshot result) {
                return this.result((ItemStackLike) result);
            }

            /**
             * @deprecated Use {@link #result(ItemStackLike)} instead.
             */
            @Deprecated(forRemoval = true)
            default EndStep result(ItemStack result) {
                return this.result((ItemStackLike) result);
            }

            /**
             * Sets the result and returns this builder. The result is the
             * {@link ItemStackLike} created when the recipe is fulfilled.
             *
             * @param result The result
             *
             * @return This builder, for chaining
             */
            EndStep result(ItemStackLike result);

            /**
             * @deprecated Use {@link #result(Function, ItemStackLike)} instead.
             */
            @Deprecated(forRemoval = true)
            default EndStep result(Function<RecipeInput.Crafting, ItemStack> resultFunction, ItemStack exemplaryResult) {
                return this.result(resultFunction, (ItemStackLike) exemplaryResult);
            }

            /**
             * Sets the result function and an exemplary result.
             * <p>The exemplary result is used for the recipe book.</p>
             *
             * @param resultFunction The result function
             * @param exemplaryResult The exemplary result stack
             *
             * @return This builder, for chaining
             */
            EndStep result(Function<RecipeInput.Crafting, ? extends ItemStackLike> resultFunction, ItemStackLike exemplaryResult);

        }

        /**
         * In this Step set the group of the Recipe and/or build it.
         */
        interface EndStep extends Builder,
                org.spongepowered.api.util.Builder<RecipeRegistration, Builder> {

            /**
             * Sets the group of the recipe.
             *
             * @param name the group
             *
             * @return This builder, for chaining
             */
            EndStep group(@Nullable String name);

            /**
             * Sets the data pack for the recipe.
             *
             * @param pack The data pack
             *
             * @return This builder, for chaining
             */
            EndStep pack(DataPack<RecipeRegistration> pack);

            /**
             * Builds the {@link ShapelessCraftingRecipe}.
             *
             * @return The built shapeless crafting recipe
             * @throws IllegalStateException If not all the recipe builder steps are completed
             *                               or the {@link #key(ResourceKey)} isn't set.
             */
            @Override
            RecipeRegistration build() throws IllegalStateException;
        }

    }

}
