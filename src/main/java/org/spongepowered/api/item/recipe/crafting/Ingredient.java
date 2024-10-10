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
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackLike;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.registry.DefaultedRegistryReference;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * An Ingredient for a crafting recipe.
 *
 * <p>Crafting recipes can only be crafted when all of the ingredients match
 * the items in the input grid.</p>
 */
public interface Ingredient extends Predicate<ItemStack> {

    /**
     * An empty ingredient.
     *
     * @return The empty ingredient
     */
    static Ingredient empty() {
        return Sponge.game().factoryProvider().provide(Factory.class).empty();
    }

    boolean test(ItemStackLike item);

    /**
     * Returns the list of {@link ItemStackSnapshot}s used to display the ingredient in a recipe.
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
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * Creates a new {@link Ingredient} for the provided {@link ItemType}s.
     *
     * @param itemTypes The items
     * @return The new ingredient
     */
    static Ingredient of(ItemType @Nullable ... itemTypes) {
        if (itemTypes == null || itemTypes.length == 0) {
            return Ingredient.empty();
        }
        return Ingredient.builder().with(itemTypes).build();
    }

    /**
     * Creates a new {@link Ingredient} for the provided {@link ItemType}s.
     *
     * @param itemTypes The items
     * @return The new ingredient
     */
    @SafeVarargs
    static Ingredient of(DefaultedRegistryReference<? extends ItemType> @Nullable ... itemTypes) {
        if (itemTypes == null || itemTypes.length == 0) {
            return Ingredient.empty();
        }
        return Ingredient.builder().with(itemTypes).build();
    }

    /**
     * Creates a new {@link Ingredient} for the provided {@link ItemStackLike}s.
     *
     * @param items The item
     * @return The new ingredient
     */
    static Ingredient of(ItemStackLike @Nullable ... items) {
        if (items == null) {
            return Ingredient.empty();
        }
        return Ingredient.builder().with(items).build();
    }

    /**
     * Creates a new {@link Ingredient} for the provided {@link Predicate} and exemplary {@link ItemStackLike}s.
     * <p>Note: Predicate ingredients may not be fully supported for all recipe types</p>
     *
     * @param key A unique resource key
     * @param predicate The predicate
     * @param exemplaryStacks The exemplary items
     *
     * @return The new ingredient
     */
    static Ingredient of(ResourceKey key, Predicate<? super ItemStackLike> predicate, ItemStackLike... exemplaryStacks) {
        if (exemplaryStacks.length == 0) {
            throw new IllegalArgumentException("At least exemplary stack is required");
        }
        return Ingredient.builder().with(key, predicate, exemplaryStacks).build();
    }

    /**
     * Creates a new {@link Ingredient} for the provided {@link ResourceKey key} which
     * should match an {@link ItemType item}.
     *
     * @param key The key
     *
     * @return The new ingredient
     */
    static Ingredient of(ResourceKey key) {
        return Ingredient.builder().with(key).build();
    }

    /**
     * Builder for {@link Ingredient}s.
     */
    interface Builder extends org.spongepowered.api.util.Builder<Ingredient, Builder> {

        /**
         * Sets one or more ItemTypes for matching the ingredient.
         *
         * @param types The items
         * @return This Builder, for chaining
         */
        Builder with(ItemType... types);

        /**
         * Sets one or more ItemTypes for matching the ingredient.
         *
         * @param types The items
         * @return This Builder, for chaining
         */
        @SuppressWarnings("unchecked")
        Builder with(Supplier<? extends ItemType>... types);

        /**
         * Sets one or more ItemStackLike for matching the ingredient.
         *
         * @param types The items
         * @return This Builder, for chaining
         */
        Builder with(ItemStackLike... types);

        /**
         * Sets a Predicate for matching the ingredient.
         * <p>Exemplary types are used for the vanilla recipe book.</p>
         * <p>Note: Predicate ingredients may not be fully supported for all recipe types</p>
         *
         * @param predicate The predicate
         * @param exemplaryTypes The items
         * @return This Builder, for chaining
         */
        Builder with(ResourceKey resourceKey, Predicate<? super ItemStackLike> predicate, ItemStackLike... exemplaryTypes);

        /**
         * Sets the item tag for matching the ingredient.
         *
         * @param itemTag The item tag
         * @return This Builder, for chaining
         */
        Builder with(ResourceKey itemTag);

        /**
         * Builds the {@link Ingredient} with the specified items and or predicates.
         *
         * @return The new Ingredient
         */
        @Override
        Ingredient build();
    }

    interface Factory {

        Ingredient empty();
    }
}
