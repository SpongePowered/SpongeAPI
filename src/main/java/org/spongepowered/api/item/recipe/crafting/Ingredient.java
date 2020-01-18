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
import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

import java.util.List;
import java.util.function.Predicate;

/**
 * An Ingredient for a crafting recipe.
 *
 * <p>Crafting recipes can only be crafted when all of the ingredients match
 * the items in the input grid.</p>
 */
// TODO Ingredients for normal (recipe book supporting) crafting recipes MUST be a stream of mc Ingredient.IItemList
// which is either based on ItemStacks/IItemProvider actually serialized to ItemType only (Ingredient.SingleItemList)
// or one Tag<Item> (Ingredient.TagList) see ItemTags
public interface Ingredient extends Predicate<ItemStack> {

    /**
     * An empty ingredient.
     */
    Ingredient NONE = DummyObjectProvider.createFor(Ingredient.class, "NONE");

    @Override
    boolean test(ItemStack itemStack);

    /**
     * Returns the list of {@link ItemStack}s used to display the ingredient in a recipe.
     * These are not necessarily all the items that this Ingredient can match.
     *
     * @return The list of items to display the Ingredient in a recipe.
     */
    List<ItemStackSnapshot> displayedItems();

    /**
     * Creates a new {@link Builder} to build an {@link Ingredient}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Creates a new {@link Ingredient} for the provided {@link ItemType}s.
     *
     * @param itemTypes The items
     * @return The new ingredient
     */
    static Ingredient of(@Nullable ItemType... itemTypes) {
        if (itemTypes == null || itemTypes.length == 0) {
            return NONE;
        }
        return builder().with(itemTypes).build();
    }

    /**
     * Creates a new {@link Ingredient} for the provided item tag.
     *
     * @param itemTag The item tag
     *
     * @return The new ingredient
     */
    static Ingredient of(CatalogKey itemTag) {
        return builder().with(itemTag).build();
    }

    /**
     * Builder for {@link Ingredient}s.
     */
    interface Builder extends ResettableBuilder<Ingredient, Builder> {

        /**
         * Sets one or more ItemTypes for matching the ingredient.
         *
         * @param types The items
         * @return This Builder, for chaining
         */
        Builder with(ItemType... types);

        /**
         * Sets the item tag for matching the ingredient.
         *
         * @param itemTag The item tag
         * @return This Builder, for chaining
         */
        Builder with(CatalogKey itemTag);

        /**
         * Builds the {@link Ingredient} with the specified items and or predicates.
         *
         * @return The new Ingredient
         */
        Ingredient build();
    }
}
