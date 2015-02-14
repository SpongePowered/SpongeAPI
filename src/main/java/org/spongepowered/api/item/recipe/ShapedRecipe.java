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

import com.flowpowered.math.vector.Vector2i;
import com.google.common.base.Optional;
import org.spongepowered.api.item.inventory.ItemStack;

/**
 * A ShapedRecipe is a Recipe that has shape and fits into a grid.
 */
public interface ShapedRecipe extends Recipe {

    /**
     * Gets the width of the grid this ShapedRecipe fits into.
     *
     * @return The width of the grid
     */
    int getWidth();

    /**
     * Gets the height of the grid this ShapedRecipe fits into.
     *
     * @return The height of the grid
     */
    int getHeight();

    /**
     * Gets the ingredient required in the given coordinates.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @return The ingredient
     */
    Optional<ItemStack> getIngredient(int x, int y);

    /**
     * Gets the ingredient required in the given position.
     *
     * @param pos The position
     * @return The ingredient
     */
    Optional<ItemStack> getIngredient(Vector2i pos);

}
