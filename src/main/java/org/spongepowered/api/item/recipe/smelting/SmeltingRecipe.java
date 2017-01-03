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
package org.spongepowered.api.item.recipe.smelting;

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.recipe.Recipe;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Collection;

/**
 * This represents a {@link Recipe} to be used in a Furnace.
 * @see Recipe
 */
public interface SmeltingRecipe extends Recipe {

    /**
     * Creates a new {@link Builder} to build a {@link SmeltingRecipe}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the experience given when this recipe is made.
     *
     * @return the experience given when this recipe is made
     */
    double getExperience();

    /**
     * Gets the item needed to make this recipe.
     * (Minecraft codes it so that it only takes one item)
     *
     * @return item needed to make this recipe
     */
    ItemStackSnapshot getIngredient();

    /**
     * Gets the result of this {@link Recipe}.
     *
     * @return the result of this {@link Recipe}
     */
    ItemStackSnapshot getResult();

    default Collection<ItemStackSnapshot> getResults() {
        return ImmutableList.of(getResult());
    }

    interface Builder extends ResettableBuilder<SmeltingRecipe, Builder> {
        /**
         * Sets the ingredient for the requirements of this {@link SmeltingRecipe}.
         * (Minecraft codes it so that it only takes one item)
         *
         * @param ingredient The ingredient
         * @return This builder, for chaining
         */
        Builder ingredient(ItemStackSnapshot ingredient);

        /**
         * Sets the ingredient for the requirements of this {@link SmeltingRecipe}.
         * This ignores the metadata of the item (e.g damage).
         *
         * @param type The ingredient type
         * @return This builder, for chaining
         */
        Builder ingredient(ItemType type);

        /**
         * Sets the resultant ItemStackSnapshot for when this {@link SmeltingRecipe} is
         * correctly crafted.
         *
         * @param result The result
         * @return This builder, for chaining
         */
        Builder result(ItemStackSnapshot result);

        /**
         * Sets the experience given when this {@link SmeltingRecipe} is crafted.
         *
         * @param exp the experience
         * @return This builder, for chaining
         */
        Builder experience(float exp);

        /**
         * Builds a new {@link SmeltingRecipe} from this builder.
         *
         * @return A new {@link SmeltingRecipe}
         */
        SmeltingRecipe build();
    }

}
