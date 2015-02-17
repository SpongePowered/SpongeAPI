/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

import com.google.common.base.Optional;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.types.GridInventory;

import java.util.List;

/**
 * <p>A Recipe represents some craftable recipe in the game.</p>
 *
 * <p>It is essentially a Predicate that checks for if a recipe is valid as well
 * as a function from a crafting matrix to a list of {@link ItemStack}
 * (the crafting result), therefore making it an immutable interface.</p>
 *
 * <p>The passed in ItemGrid is usually a crafting inventory, e.g.
 * a 2x2 or 3x3 crafting matrix.</p>
 *
 * <p>The requirements of a Recipe can be general, they just have to
 * eventually return a boolean given an itemgrid.</p>
 */
public interface Recipe {

    /**
     * Returns the list of item types that result when successful crafting of
     * this Recipe is completed.
     *
     * @return The resultant list of item types
     */
    List<ItemType> getResultTypes();

    /**
     * Checks if the given {@link GridInventory} fits the required constraints 
     * to craft this Recipe.
     *
     * @param grid The ItemGrid to check for validity
     * @return True if the given input matches this recipe's requirements
     */
    boolean isValid(GridInventory grid);

    /**
     * Returns the results for running this Recipe over an {@link GridInventory}
     *
     * @param grid An ItemGrid as input
     * @return A list of ItemStacks or {@link Optional#absent()} if the given
     *          ItemGrid does not match this recipe's requirements.
     */
    Optional<List<ItemStack>> getResults(GridInventory grid);

}
