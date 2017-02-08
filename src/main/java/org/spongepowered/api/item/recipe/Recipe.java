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

import com.google.common.collect.ImmutableCollection;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

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
     * Gets the result of this {@link Recipe}.
     *
     * @return the results of this {@link Recipe}
     */
    ImmutableCollection<ItemStackSnapshot> getResults();

    /**
     * Gets the {@link RecipeRegistry} that
     * corresponds with this Recipe.
     *
     * @return the {@link RecipeRegistry} that corresponds with this Recipe
     */
    RecipeRegistry<?> getRegistry();

}
