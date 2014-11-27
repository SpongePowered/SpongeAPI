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
package org.spongepowered.api.item.list;

import com.flowpowered.math.vector.Vector2i;

import org.spongepowered.api.item.inventory.ItemStack;

/**
 * An ItemGrid is an ItemList that is ordered into a coherent grid format,
 * meaning that its slots can be referred to by xy coordinates
 * as well as single indices.
 *
 * <p>The indices of an ItemGrid should progress left-to-right and
 * top-to-bottom, and so should the iterator.</p>
 */
public interface ItemGrid extends ItemList {

    /**
     * Gets the width of this ItemGrid.
     *
     * @return The width of this ItemGrid.
     */
    int getWidth();

    /**
     * Gets the height of this ItemGrid.
     *
     * @return The height of this ItemGrid.
     */
    int getHeight();

    /**
     * Returns the dimensions of this ItemGrid as a {@link Vector2i}.
     *
     * @return The dimensions of this ItemGrid.
     */
    Vector2i getDimensions();

    /**
     * Retrieves an item in this ItemGrid from the given position.
     *
     * @param pos The position
     * @return The item in the given position
     */
    ItemStack getItem(Vector2i pos);

    /**
     * Retrieves an item in this ItemGrid from the given coordinates.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @return THe item in the given coordinates
     */
    ItemStack getItem(int x, int y);

    /**
     * Sets the slot in the given position to the given ItemStack.
     *
     * @param pos The position
     * @param stack The stack to set
     */
    void setItem(Vector2i pos, ItemStack stack);

    /**
     * Sets the slot in the given coordinates to the given ItemStack.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param stack The stack to set
     */
    void setItem(int x, int y, ItemStack stack);

    /**
     * Takes {@code count} items away from the ItemStack in the given
     * coordinates and returns them as a new ItemStack.
     *
     * @param pos The position
     * @param count The number of items to remove from the ItemStack
     * @return The items that have been taken out as a new ItemStack
     */
    ItemStack splitItem(Vector2i pos, int count);

    /**
     * Takes {@code count} items away from the ItemStack in the given
     * coordinates and returns them as a new ItemStack.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param count The number of items to remove from the ItemStack
     * @return The items that have been taken out as a new ItemStack
     */
    ItemStack splitItem(int x, int y, int count);

    /**
     * Gets the corresponding index for a position in this ItemGrid.
     *
     * @param pos The position
     * @return The corresponding index as an integer
     */
    int getIndex(Vector2i pos);

    /**
     * Gets the corresponding index for a coordinate pair in this ItemGrid.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @return The corresponding index as an integer
     */
    int getIndex(int x, int y);

    /**
     * Gets the corresponding position for an index in this ItemGrid.
     *
     * @param index The index
     * @return The corresponding position as a {@link Vector2i}
     */
    Vector2i getPosition(int index);

}
