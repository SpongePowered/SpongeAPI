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

import org.spongepowered.api.GameDictionary;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Nullable;

/**
 * An Ingredient for a crafting recipe.
 *
 * <p>Crafting recipes can only be crafted when all of the ingredients match
 * the items in the input grid.</p>
 */
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
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Creates a new {@link Ingredient} for the provided {@link ItemStackSnapshot}s.
     *
     * @param snapshots The snapshots
     * @return The new ingredient
     */
    static Ingredient of(@Nullable ItemStackSnapshot... snapshots) {
        if (snapshots == null || snapshots.length == 0) {
            return NONE;
        }
        return builder().with(snapshots).build();
    }

    /**
     * Creates a new {@link Ingredient} for the provided {@link ItemStack}s.
     *
     * @param itemStacks The itemStacks
     * @return The new ingredient
     */
    static Ingredient of(@Nullable ItemStack... itemStacks) {
        if (itemStacks == null || itemStacks.length == 0) {
            return NONE;
        }
        return builder().with(itemStacks).build();
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
     * Creates a new {@link Ingredient} for the provided
     * {@link org.spongepowered.api.GameDictionary.Entry}s.
     *
     * @param entries The GameDictionary Entries
     * @return The new ingredient
     */
    static Ingredient of(@Nullable GameDictionary.Entry... entries) {
        if (entries == null || entries.length == 0) {
            return NONE;
        }
        return builder().with(i -> Arrays.stream(entries).anyMatch(e -> e.matches(i))).build();
    }

    /**
     * Builder for {@link Ingredient}s.
     */
    interface Builder extends ResettableBuilder<Ingredient, Builder> {

        /**
         * Adds a predicate for matching the ingredient.
         *
         * <p>Also clears all previously set {@link #withDisplay} items.</p>
         *
         * <p>All predicates and items are ORed together.</p>
         *
         * <p>Use {@link #from} to create an ingredient from another one.</p>
         *
         * @param predicate The predicate.
         * @return This Builder, for chaining
         */
        Builder with(Predicate<ItemStack> predicate);

        /**
         * Adds a GameDictionary Entry as Predicate for matching the ingredient.
         * Also clears all previously set {@link #withDisplay} items and then
         * adds {@link org.spongepowered.api.GameDictionary.Entry#getTemplate()}
         * to it.
         *
         * <p>All predicates and items are ORed together.</p>
         *
         * @param entry The GameDictionary entry.
         * @return This Builder, for chaining
         */
        default Builder with(GameDictionary.Entry entry) {
            return this.with(entry::matches).withDisplay(entry.getTemplate());
        }

        /**
         * Adds one or more ItemTypes for matching the ingredient.
         * The ItemTypes are also used as display items.
         * All predicates and items are ORed together.
         *
         * @param types The items
         * @return This Builder, for chaining
         */
        Builder with(ItemType... types);

        /**
         * Adds one or more ItemStacks for matching the ingredient.
         * The ItemStacks are also used as display items.
         * All predicates and items are ORed together.
         *
         * @param items The items
         * @return This Builder, for chaining
         */
        Builder with(ItemStack... items);

        /**
         * Adds one or more ItemStackSnapshots for matching the ingredient.
         * The Snapshots are also used as display items.
         * All predicates and items are ORed together.
         *
         * @param items The items
         * @return This Builder, for chaining
         */
        Builder with(ItemStackSnapshot... items);

        /**
         * Adds ItemTypes used to display this Ingredient in a recipe.
         * These are not used for matching the recipe.
         *
         * @param types The list of itemTypes.
         * @return This Builder, for chaining
         */
        Builder withDisplay(ItemType... types);

        /**
         * Adds ItemStacks used to display this Ingredient in a recipe.
         * These are not used for matching the recipe.
         *
         * @param items The list of items.
         * @return This Builder, for chaining
         */
        Builder withDisplay(ItemStack... items);

        /**
         * Adds ItemStackSnasphots used to display this Ingredient in a recipe.
         * These are not used for matching the recipe.
         *
         * @param items The list of snapshots.
         * @return This Builder, for chaining
         */
        Builder withDisplay(ItemStackSnapshot... items);

        /**
         * Builds the {@link Ingredient} with the specified items and or predicates.
         *
         * @return The new Ingredient
         */
        Ingredient build();
    }
}
