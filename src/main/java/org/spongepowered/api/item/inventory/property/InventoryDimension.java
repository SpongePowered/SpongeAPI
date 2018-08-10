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
package org.spongepowered.api.item.inventory.property;

import com.flowpowered.math.vector.Vector2i;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.inventory.InventoryProperty;
import org.spongepowered.api.item.inventory.type.GridInventory;
import org.spongepowered.api.item.inventory.type.InventoryRow;

/**
 * Property for inventories of a particular size. For example to allow querying
 * for {@link InventoryRow} of length 9 or {@link GridInventory} of size 3x3.
 */
public interface InventoryDimension extends InventoryProperty<String, Vector2i> {

    /**
     * Gets the number of columns in this inventory.
     *
     * @return column count
     */
    default int getColumns() {
        return this.getValue().getX();
    }

    /**
     * Gets the number of rows in this inventory.
     *
     * @return row count
     */
    default int getRows() {
        return this.getValue().getY();
    }

    /**
     * Create an InventoryDimension property which matches InventoryDimension
     * properties with equal value.
     *
     * @param value value to match
     * @return new property
     */
    static InventoryDimension of(Vector2i value) {
        return of(value, Operator.EQUAL);
    }

    /**
     * Create an InventoryDimension property which matches InventoryDimension
     * properties with equal value.
     *
     * @param width x coordinate to match
     * @param height y coordinate to match
     * @return new property
     */
    static InventoryDimension of(int width, int height) {
        return of(new Vector2i(width, height));
    }

    static InventoryDimension of(Vector2i value, Operator operator) {
        return builder().value(value).operator(operator).build();
    }

    static InventoryDimension of(int width, int height, Operator operator) {
        return of(new Vector2i(width, height), operator);
    }

    static InventoryDimension delegate(Vector2i value) {
        return builder().value(value).operator(Operator.DELEGATE).build();
    }

    /**
     * Creates a new {@link Builder} to create {@link InventoryDimension}s.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Represents a builder class to create {@link InventoryDimension}s.
     */
    interface Builder extends InventoryProperty.Builder<Vector2i, InventoryDimension, Builder> {
    }

}
