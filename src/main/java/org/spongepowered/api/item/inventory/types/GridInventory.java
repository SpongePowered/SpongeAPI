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
package org.spongepowered.api.item.inventory.types;

import com.flowpowered.math.vector.Vector2i;
import com.google.common.base.Optional;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.item.inventory.transaction.InventoryOperationResult;

/**
 * An GridInventory is an {@link org.spongepowered.api.item.inventory.Inventory}
 * which is ordered into a coherent grid format, meaning that its slots can be
 * referred to by X-Y coordinates as well as single indices.
 */
public interface GridInventory extends Inventory2D {

    /**
     * Gets the number of columns in the inventory.
     *
     * @return The width of this ItemGrid.
     */
    int getColumns();

    /**
     * Gets the number of rows in the inventory.
     *
     * @return The height of this ItemGrid.
     */
    int getRows();

    /**
     * Returns the dimensions of this GridInventory as a {@link Vector2i}.
     *
     * @return The dimensions of this GridInventory.
     */
    Vector2i getDimensions();

    /**
     * Get and remove the stack at the supplied position in this Inventory.
     * 
     * @see org.spongepowered.api.item.inventory.Inventory#poll()
     * @param x x coordinate
     * @param y y coordinate
     * @return ItemStack at the specified position or {@link Optional#absent()}
     *      if the slot is empty or out of bounds
     */
    Optional<ItemStack> poll(int x, int y);

    /**
     * Get and remove the stack at the supplied position in this Inventory.
     * 
     * @see org.spongepowered.api.item.inventory.Inventory#poll()
     * @param x x coordinate
     * @param y y coordinate
     * @param limit item limit
     * @return ItemStack at the specified position or {@link Optional#absent()}
     *      if the slot is empty or out of bounds
     */
    Optional<ItemStack> poll(int x, int y, int limit);

    /**
     * Get without removing the stack at the supplied position in this
     * Inventory.
     * 
     * @see org.spongepowered.api.item.inventory.Inventory#peek()
     * @param x x coordinate
     * @param y y coordinate
     * @return ItemStack at the specified position or {@link Optional#absent()}
     *      if the slot is empty or out of bounds
     */
    Optional<ItemStack> peek(int x, int y);

    /**
     * Get without removing the stack at the supplied position in this
     * Inventory.
     * 
     * @see org.spongepowered.api.item.inventory.Inventory#peek()
     * @param x x coordinate
     * @param y y coordinate
     * @param limit item limit
     * @return ItemStack at the specified position or {@link Optional#absent()}
     *      if the slot is empty or out of bounds
     */
    Optional<ItemStack> peek(int x, int y, int limit);

    /**
     * Set the item in the specified slot.
     * 
     * @see org.spongepowered.api.item.inventory.Inventory#set(ItemStack)
     * @param x x coordinate
     * @param y y coordinate
     * @param stack Item stack to insert
     * @return operation result
     */
    InventoryOperationResult set(int x, int y, ItemStack stack);

    /**
     * Get the {@link Slot} at the specified position.
     * 
     * @param x x coordinate
     * @param y y coordinate
     * @return {@link Slot} at the specified position or
     *      {@link Optional#absent()} if the coordinates are out of bounds
     */
    Optional<Slot> getSlot(int x, int y);

    /**
     * Get the row at the specified index.
     * 
     * @param y y coordinate
     * @return {@link InventoryRow} at the specified position or
     *      {@link Optional#absent()} if the specified row is out of bounds
     */
    Optional<InventoryRow> getRow(int y);

    /**
     * Get the column at the specified index.
     * 
     * @param x x coordinate
     * @return {@link InventoryColumn} at the specified position or
     *      {@link Optional#absent()} if the specified column is out of bounds
     */
    Optional<InventoryColumn> getColumn(int x);
    
}
