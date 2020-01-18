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

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.block.entity.carrier.Campfire;
import org.spongepowered.api.block.entity.carrier.furnace.BlastFurnace;
import org.spongepowered.api.block.entity.carrier.furnace.Furnace;
import org.spongepowered.api.block.entity.carrier.furnace.Smoker;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.crafting.CraftingInventory;
import org.spongepowered.api.item.recipe.crafting.CraftingRecipe;
import org.spongepowered.api.item.recipe.crafting.Ingredient;
import org.spongepowered.api.item.recipe.crafting.RecipeResult;
import org.spongepowered.api.item.recipe.crafting.ShapedCraftingRecipe;
import org.spongepowered.api.item.recipe.crafting.ShapelessCraftingRecipe;
import org.spongepowered.api.item.recipe.crafting.SpecialCraftingRecipe;
import org.spongepowered.api.item.recipe.single.StoneCutterRecipe;
import org.spongepowered.api.item.recipe.smelting.SmeltingRecipe;
import org.spongepowered.api.world.World;

import java.util.List;
import java.util.Optional;

/**
 * A general interface for recipes.
 * <p>Currently supported recipe types are:</p>
 * <p>{@link ShapelessCraftingRecipe} for recipes with simple ingredients/result without pattern in a {@link CraftingInventory}</p>
 * <p>{@link ShapedCraftingRecipe} for recipes with simple ingredients/result in a pattern in a {@link CraftingInventory}</p>
 * <p>{@link SpecialCraftingRecipe} for recipes with complex ingredients and result in a {@link CraftingInventory}</p>
 * <p>{@link SmeltingRecipe} for recipes in {@link Furnace}, {@link BlastFurnace}, {@link Smoker} and {@link Campfire}</p>
 * <p>{@link StoneCutterRecipe} for recipes in a {@link BlockTypes#STONECUTTER} block</p>
 */
public interface Recipe extends CatalogType {

    /**
     * Checks if the given inventory fits the required constraints to make a valid recipe
     *
     * @param inventory The inventory to check for validity
     * @param world The world this recipe would be used in
     *
     * @return True if the given input matches this recipe's requirements
     */
    boolean isValid(Inventory inventory, World world);

    /**
     * This method should only be called if {@link #isValid(Inventory, World)} returns {@code true}.
     *
     * <p>This method is preferred over the
     * {@link CraftingRecipe#getExemplaryResult()} method, as it customizes
     * the result further depending on the context.</p>
     *
     * <p>Implementing classes are advised to use the output of
     * {@link CraftingRecipe#getExemplaryResult()}, modify it accordingly,
     * and {@code return} it.</p>
     *
     * @param inventory The input inventory
     *
     * @return An {@link ItemStackSnapshot}
     */
    ItemStackSnapshot getResult(Inventory inventory);

    /**
     * A general result of this recipe. This result may be customized depending
     * on the context.
     *
     * @return The exemplary result of this recipe
     */
    ItemStackSnapshot getExemplaryResult();

    /**
     * This method should only be called if {@link #isValid(Inventory, World)} returns {@code true}.
     *
     * <p>A list of items to be added to the inventory of the player when they
     * craft the result. For example, if a player crafts a
     * {@link ItemTypes#CAKE}, the empty buckets are returned to their
     * inventory.</p>
     *
     * @param inventory The input inventory
     * @return The list of items to be added to the inventory of the player
     *         when the recipe has been fulfilled (possibly empty)
     */
    List<ItemStackSnapshot> getRemainingItems(Inventory inventory);

    /**
     * Returns the {@link RecipeResult} for the given inventory and world.
     *
     * <p>Returns
     * {@link Optional#empty()} if the arguments do not satisfy
     * {@link #isValid(Inventory, World)}.</p>
     *
     * @param inventory The input inventory
     * @param world The world this recipe would be used in
     *
     * @return A {@link RecipeResult} if the arguments satisfy
     *     {@link #isValid(Inventory, World)}, or
     *     {@link Optional#empty()} if not
     */
    default Optional<RecipeResult> getResult(Inventory inventory, World world) {
        if (this.isValid(inventory, world)) {
            return Optional.of(new RecipeResult(this.getResult(inventory), this.getRemainingItems(inventory)));
        }
        return Optional.empty();
    }

    /**
     * Gets the ingredients for this recipe.
     *
     * @return An unmodifiable list of the ingredients.
     */
    List<Ingredient> getIngredients();

    /**
     * Returns true if the recipe is dynamic.
     * <p>Dynamic recipes are not displayed in the recipe book.</p>
     *
     * @return Whether this recipe is dynamic.
     */
    boolean isDynamic();

    /**
     * Gets the type of recipe
     *
     * @return The recipe type.
     */
    RecipeType getType();

}
