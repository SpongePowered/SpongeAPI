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
import org.spongepowered.api.event.lifecycle.RegisterCatalogEvent;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.recipe.crafting.RecipeResult;
import org.spongepowered.api.item.recipe.cooking.CookingRecipe;
import org.spongepowered.api.world.server.ServerWorld;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * A registry holds all registered recipes for a given game.
 * Register new Recipes during {@link RegisterCatalogEvent<Recipe>}.
 * To disable a recipe override it with an empty result.
 */
public interface RecipeRegistry {

    /**
     * Gets a recipe by its {@link ResourceKey key}.
     *
     * @param key the recipe key
     *
     * @return The recipe if available
     */
    Optional<Recipe> getByKey(ResourceKey key);

    /**
     * Gets all registered recipes.
     *
     * @return All registered recipes.
     */
    Collection<Recipe> getAll();

    /**
     * Returns all registered recipes of given type
     * @param type The recipe type
     *
     * @return All recipes of given type
     */
    <T extends Recipe> Collection<T> getAllOfType(RecipeType<T> type);

    /**
     * Returns all registered recipes of given type
     * @param supplier The recipe type
     *
     * @return All recipes of given type
     */
    default <T extends Recipe> Collection<T> getAllOfType(Supplier<? extends RecipeType<T>> supplier) {
        return this.getAllOfType(supplier.get());
    }

    /**
     * Returns all registered recipes of given type and with given item as a result.
     *
     * @param type The recipe type
     * @param result The recipe result to match
     *
     * @return The recipes resulting in given item.
     */
    <T extends Recipe> Collection<T> findByResult(RecipeType<T> type, ItemStackSnapshot result);

    /**
     * Gets all recipes with given item as a result.
     *
     * @param result the recipe result to match
     *
     * @return All recipes resulting in given item.
     */
    default <T extends Recipe> Collection<T> findByResult(Supplier<? extends RecipeType<T>> supplier, ItemStackSnapshot result) {
        return this.findByResult(supplier.get(), result);
    }

    /**
     * Finds a matching recipe for given inventory and world.
     *
     * @param inventory The input inventory
     * @param world The world
     *
     * @return The found {@link Recipe}, or {@link Optional#empty()}
     *         if no recipe was found for this configuration
     */
    Optional<Recipe> findMatchingRecipe(Inventory inventory, ServerWorld world);

    /**
     * Finds a matching recipe for given type, inventory and world
     *
     * @param type The recipe type
     * @param inventory The input inventory
     * @param world The world
     *
     * @return The matching recipes.
     */
    <T extends Recipe> Optional<T> findMatchingRecipe(RecipeType<T> type, Inventory inventory, ServerWorld world);

    /**
     * Finds a matching recipe for given type, inventory and world
     *
     * @param supplier The recipe type
     * @param inventory The input inventory
     * @param world The world
     *
     * @return The matching recipes.
     */
    default <T extends Recipe> Optional<T> findMatchingRecipe(Supplier<? extends RecipeType<T>> supplier, Inventory inventory, ServerWorld world) {
        return this.findMatchingRecipe(supplier.get(), inventory, world);
    }

    /**
     * Finds a matching cooking recipe for given type and ingredient
     *
     * @param type The recipe type
     * @param ingredient The ingredient
     *
     * @return The matching recipe.
     */
    <T extends CookingRecipe> Optional<T> findCookingRecipe(RecipeType<T> type, ItemStackSnapshot ingredient);

    /**
     * Finds a matching cooking recipe for given type and ingredient
     *
     * @param supplier The recipe type
     * @param ingredient The ingredient
     *
     * @return The matching recipe.
     */
    default <T extends CookingRecipe> Optional<T> findCookingRecipe(Supplier<? extends RecipeType<T>> supplier, ItemStackSnapshot ingredient) {
        return this.findCookingRecipe(supplier.get(), ingredient);
    }

    /**
     * Finds the matching recipe and creates the {@link RecipeResult},
     * which is then returned.
     *
     * @param inventory The crafting grid
     * @param world The world
     * @return The {@link RecipeResult} if a recipe was found, or
     *         {@link Optional#empty()} if not
     */
    default Optional<RecipeResult> getResult(Inventory inventory, ServerWorld world) {
        return this.findMatchingRecipe(inventory, world)
                .flatMap(recipe -> recipe.getResult(inventory, world));
    }
}
