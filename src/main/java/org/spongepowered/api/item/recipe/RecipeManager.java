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
package org.spongepowered.api.item.recipe;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.item.inventory.ItemStackLike;
import org.spongepowered.api.item.recipe.cooking.CookingRecipe;
import org.spongepowered.api.item.recipe.crafting.RecipeInput;
import org.spongepowered.api.world.server.ServerWorld;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Manages registered recipes.
 * Register new Recipes during {@link org.spongepowered.api.event.lifecycle.RegisterDataPackValueEvent}
 * using {@link RecipeRegistration}s.
 * To disable a recipe override it with an empty result.
 */
public interface RecipeManager {

    /**
     * Gets a recipe by its {@link ResourceKey key}.
     *
     * @param key the recipe key
     *
     * @return The recipe if available
     */
    Optional<Recipe<?>> byKey(ResourceKey key);

    /**
     * Gets all registered recipes.
     *
     * @return All registered recipes.
     */
    Collection<Recipe<?>> all();

    /**
     * Returns all registered recipes of given type
     * @param type The recipe type
     *
     * @return All recipes of given type
     */
    <T extends Recipe<?>> Collection<T> allOfType(RecipeType<T> type);

    /**
     * Returns all registered recipes of given type
     * @param supplier The recipe type
     *
     * @return All recipes of given type
     */
    default <T extends Recipe<?>> Collection<T> allOfType(Supplier<? extends RecipeType<T>> supplier) {
        return this.allOfType(supplier.get());
    }

    /**
     * Returns all registered recipes of given type and with given item as a result.
     *
     * @param type The recipe type
     * @param result The recipe result to match
     *
     * @return The recipes resulting in given item.
     */
    <T extends Recipe<?>> Collection<T> findByResult(RecipeType<T> type, ItemStackLike result);

    /**
     * Gets all recipes with given item as a result.
     *
     * @param result the recipe result to match
     *
     * @return All recipes resulting in given item.
     */
    default <T extends Recipe<?>> Collection<T> findByResult(Supplier<? extends RecipeType<T>> supplier, ItemStackLike result) {
        return this.findByResult(supplier.get(), result);
    }

    /**
     * Finds a matching recipe for given type, recipe input and world
     *
     * @param type The recipe type
     * @param input The recipe input
     * @param world The world
     *
     * @return The matching recipes.
     */
    <I extends RecipeInput, T extends Recipe<I>> Optional<T> findMatchingRecipe(RecipeType<T> type, I input, ServerWorld world);

    /**
     * Finds a matching recipe for given type, recipe input and world
     *
     * @param supplier The recipe type
     * @param input The recipe input
     * @param world The world
     *
     * @return The matching recipes.
     */
    default <I extends RecipeInput, T extends Recipe<I>> Optional<T> findMatchingRecipe(Supplier<? extends RecipeType<T>> supplier, I input, ServerWorld world) {
        return this.findMatchingRecipe(supplier.get(), input, world);
    }

    /**
     * Finds a matching cooking recipe for given type and ingredient
     *
     * @param type The recipe type
     * @param ingredient The ingredient
     *
     * @return The matching recipe.
     */
    <T extends CookingRecipe> Optional<T> findCookingRecipe(RecipeType<T> type, ItemStackLike ingredient);

    /**
     * Finds a matching cooking recipe for given type and ingredient
     *
     * @param supplier The recipe type
     * @param ingredient The ingredient
     *
     * @return The matching recipe.
     */
    default <T extends CookingRecipe> Optional<T> findCookingRecipe(Supplier<? extends RecipeType<T>> supplier, ItemStackLike ingredient) {
        return this.findCookingRecipe(supplier.get(), ingredient);
    }

}
