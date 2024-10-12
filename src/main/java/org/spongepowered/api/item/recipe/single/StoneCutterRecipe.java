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
package org.spongepowered.api.item.recipe.single;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.datapack.DataPack;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStackLike;
import org.spongepowered.api.item.recipe.Recipe;
import org.spongepowered.api.item.recipe.RecipeRegistration;
import org.spongepowered.api.item.recipe.RecipeType;
import org.spongepowered.api.item.recipe.crafting.Ingredient;
import org.spongepowered.api.item.recipe.crafting.RecipeInput;
import org.spongepowered.api.util.ResourceKeyedBuilder;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * A StoneCutter Recipe.
 */
public interface StoneCutterRecipe extends Recipe<RecipeInput.Single> {

    static StoneCutterRecipe.Builder builder() {
        return Sponge.game().builderProvider().provide(StoneCutterRecipe.Builder.class);
    }

    @Override
    RecipeType<? extends StoneCutterRecipe> type();

    /**
     * Builds a simple stonecutter recipe
     */
    interface Builder extends ResourceKeyedBuilder<RecipeRegistration, Builder> {

        /**
         * Sets the ingredient and returns this builder.
         *
         * @param ingredient The ingredient
         *
         * @return This builder, for chaining
         */
        ResultStep ingredient(ItemType ingredient);

        /**
         * Sets the ingredient and returns this builder.
         *
         * @param ingredient The ingredient
         *
         * @return This builder, for chaining
         */
        default ResultStep ingredient(Supplier<? extends ItemType> ingredient) {
            return this.ingredient(ingredient.get());
        }

        /**
         * Sets the ingredient and returns this builder.
         *
         * @param ingredient The ingredient
         *
         * @return This builder, for chaining
         */
        ResultStep ingredient(Ingredient ingredient);

        interface ResultStep extends StoneCutterRecipe.Builder {

            /**
             * Changes the result and returns this builder. The result is the
             * {@link ItemStackLike} created when the recipe is fulfilled.
             *
             * @param result The output of this recipe
             *
             * @return This builder, for chaining
             */
            EndStep result(ItemStackLike result);

            /**
             * Changes the result and returns this builder. The result is the
             * {@link ItemStackLike} created when the recipe is fulfilled.
             *
             * @param resultFunction The result function
             * @param exemplaryResult The exemplary output of this recipe
             *
             * @return This builder, for chaining
             */
            EndStep result(Function<RecipeInput.Single, ? extends ItemStackLike> resultFunction, ItemStackLike exemplaryResult);

        }

        interface EndStep extends StoneCutterRecipe.Builder,
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
             * Builds the {@link StoneCutterRecipe}.
             *
             * @return The built stone cutter recipe
             * @throws IllegalStateException If not all the recipe builder steps are completed
             *                               or the {@link #key(ResourceKey)} isn't set.
             */
            @Override
            RecipeRegistration build() throws IllegalStateException;
        }
    }
}
