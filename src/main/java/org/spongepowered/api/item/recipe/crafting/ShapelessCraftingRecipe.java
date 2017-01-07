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
import com.google.common.collect.Lists;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * A ShapelessCraftingRecipe is a Recipe that does not have shape and just has a
 * list of ingredients.
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
     * Gets the ingredients for this shapeless recipe.
     *
     * @return The ingredients
     */
    ImmutableCollection<ItemStackSnapshot> getIngredients();

    /**
     * Represents a builder class to create {@link ShapelessCraftingRecipe}s.
     *
     * @see ShapelessCraftingRecipe
     */
    interface Builder extends ResettableBuilder<ShapelessCraftingRecipe, Builder> {

        /**
         * Sets the ingredients of this shapeless recipe.
         * (Minecraft codes it so that it only takes one item of a type)
         *
         * @param ingredients The ingredients
         * @return The builder
         */
        default Builder ingredients(ItemType... ingredients) {
            return ingredients(Lists.newArrayList(ingredients).stream().map(
                    type -> type.getTemplate().createStack()).collect(Collectors.toList()));
        }

        /**
         * Sets the ingredients of this shapeless recipe.
         * (Minecraft codes it so that it only takes one item of a type)
         *
         * @param ingredients The ingredients
         * @return The builder
         */
        default Builder ingredients(ItemStack... ingredients) {
            return ingredients(ingredients);
        }

        /**
         * Sets the ingredients of this shapeless recipe.
         * (Minecraft codes it so that it only takes one item of a type)
         *
         * @param ingredients The ingredients
         * @return The builder
         */
        Builder ingredients(Collection<ItemStack> ingredients);

        /**
         * Sets the resultant ItemStackSnapshot for when this shapeless recipe is
         * correctly crafted.
         *
         * @param results The resultant stacks
         * @return The builder
         */
        default Builder results(ItemStack... results) {
            return results(Arrays.asList(results));
        }

        /**
         * Sets the resultant {@link ItemStackSnapshot}s for when this shapeless recipe
         * is correctly crafted.
         *
         * @param result The resultant stacks
         * @return The builder
         */
        Builder results(Collection<ItemStack> result);

        /**
         * Builds a new {@link ShapelessCraftingRecipe} from this builder.
         *
         * @return A new shapeless recipe
         */
        ShapelessCraftingRecipe build();
    }

}
