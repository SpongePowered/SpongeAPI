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
package org.spongepowered.api.item.recipe.smithing;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.datapack.DataPack;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackLike;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.recipe.Recipe;
import org.spongepowered.api.item.recipe.RecipeRegistration;
import org.spongepowered.api.item.recipe.RecipeType;
import org.spongepowered.api.item.recipe.crafting.Ingredient;
import org.spongepowered.api.item.recipe.crafting.RecipeInput;
import org.spongepowered.api.util.ResourceKeyedBuilder;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * A Smithing Recipe.
 */
public interface SmithingRecipe extends Recipe<RecipeInput.Smithing> {

    static SmithingRecipe.Builder builder() {
        return Sponge.game().builderProvider().provide(SmithingRecipe.Builder.class);
    }

    @Override
    RecipeType<? extends SmithingRecipe> type();

    /**
     * Builds a simple smithing recipe
     */
    interface Builder extends ResourceKeyedBuilder<RecipeRegistration, Builder> {

        // TODO Trim recipe?

        /**
         * Sets the template ingredient and returns this builder.
         *
         * @param ingredient The ingredient
         *
         * @return This builder, for chaining
         */
        BaseStep template(ItemType ingredient);

        /**
         * Sets the template ingredient and returns this builder.
         *
         * @param ingredient The ingredient
         *
         * @return This builder, for chaining
         */
        default BaseStep template(Supplier<? extends ItemType> ingredient) {
            return this.template(ingredient.get());
        }

        /**
         * Sets the template ingredient and returns this builder.
         *
         * @param ingredient The ingredient
         *
         * @return This builder, for chaining
         */
        BaseStep template(Ingredient ingredient);

        interface BaseStep extends SmithingRecipe.Builder {
            /**
             * Sets the base ingredient and returns this builder.
             *
             * @param ingredient The ingredient
             *
             * @return This builder, for chaining
             */
            AdditionStep base(ItemType ingredient);

            /**
             * Sets the base ingredient and returns this builder.
             *
             * @param ingredient The ingredient
             *
             * @return This builder, for chaining
             */
            default AdditionStep base(Supplier<? extends ItemType> ingredient) {
                return this.base(ingredient.get());
            }

            /**
             * Sets the base ingredient and returns this builder.
             *
             * @param ingredient The ingredient
             *
             * @return This builder, for chaining
             */
            AdditionStep base(Ingredient ingredient);
        }

        interface AdditionStep extends SmithingRecipe.Builder {
            /**
             * Sets the additional ingredient and returns this builder.
             *
             * @param ingredient The ingredient
             *
             * @return This builder, for chaining
             */
            ResultStep addition(ItemType ingredient);

            /**
             * Sets the additional ingredient and returns this builder.
             *
             * @param ingredient The ingredient
             *
             * @return This builder, for chaining
             */
            default ResultStep addition(Supplier<? extends ItemType> ingredient) {
                return this.addition(ingredient.get());
            }

            /**
             * Sets the additional ingredient and returns this builder.
             *
             * @param ingredient The ingredient
             *
             * @return This builder, for chaining
             */
            ResultStep addition(Ingredient ingredient);
        }


        interface ResultStep extends SmithingRecipe.Builder {

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
             * Changes the result and returns this builder. The result is the
             * {@link ItemStackLike} created when the recipe is fulfilled.
             *
             * @param result The output of this recipe
             *
             * @return This builder, for chaining
             */
            EndStep result(ItemStackLike result);

            /**
             * @deprecated Use {@link #result(Function, ItemStackLike)} instead.
             */
            @Deprecated(forRemoval = true)
            default EndStep result(Function<RecipeInput.Smithing, ItemStack> resultFunction, ItemStack exemplaryResult) {
                return this.result(resultFunction, (ItemStackLike) exemplaryResult);
            }

            /**
             * Changes the result and returns this builder. The result is the
             * {@link ItemStackLike} created when the recipe is fulfilled.
             *
             * @param resultFunction The result function
             * @param exemplaryResult The exemplary output of this recipe
             *
             * @return This builder, for chaining
             */
            EndStep result(Function<RecipeInput.Smithing, ? extends ItemStackLike> resultFunction, ItemStackLike exemplaryResult);

        }

        interface EndStep extends SmithingRecipe.Builder, org.spongepowered.api.util.Builder<RecipeRegistration, Builder> {

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
             * Builds the {@link SmithingRecipe}.
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
