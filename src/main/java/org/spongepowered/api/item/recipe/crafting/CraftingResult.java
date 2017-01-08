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

import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.type.GridInventory;

import java.util.List;
import java.util.Optional;

/**
 * Contains specific {@link ItemStack}s created as the result of
 * {@link CraftingRecipe}s under specific conditions.
 */
public interface CraftingResult {

    /**
     * This method is preferred over the
     * {@link CraftingRecipe#getExemplaryResult()} method, as it customizes
     * the result further depending on the context.
     *
     * <p>It is advised to use the output of
     * {@link CraftingRecipe#getExemplaryResult()}, modify it accordingly,
     * and {@code return} it.</p>
     *
     * @return An {@link ItemStack} or {@link Optional#empty()} if the given
     *         {@link GridInventory} does not match this recipe's requirements.
     */
    ItemStack getMainItem();

    /**
     * A list of items to be added to the inventory of the player when they
     * craft the result. For example, if a player crafts a
     * {@link ItemTypes#CAKE}, the empty buckets are returned to their
     * inventory.
     *
     * @return The list of items to be added to the inventory of the player
     *         when the recipe has been fulfilled (possibly empty),
     *         or {@link Optional#empty()} if the given
     *         {@link GridInventory} does not match this recipe's requirements.
     */
    List<ItemStack> getRemainingItems();

}
