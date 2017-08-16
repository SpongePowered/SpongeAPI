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
import org.spongepowered.api.data.Property;
import org.spongepowered.api.item.inventory.type.GridInventory;
import org.spongepowered.api.item.inventory.type.InventoryRow;
import org.spongepowered.api.util.Coerce;

/**
 * Property for inventories of a particular size. For example to allow querying
 * for {@link InventoryRow} of length 9 or {@link GridInventory} of size 3x3.
 */
public class InventoryDimension extends AbstractInventoryProperty<String, Vector2i> {

    public static final String PROPERTY_NAME = "inventorydimension";

    /**
     * Create a new InventoryDimension property with the specified value.
     *
     * @param value size to match
     */
    public InventoryDimension(Vector2i value) {
        super(value);
    }

    /**
     * Create a new InventoryDimension property with the specified dimensions.
     *
     * @param width width of the inventory to match
     * @param height height of the inventory to match
     */
    public InventoryDimension(int width, int height) {
        super(new Vector2i(width, height));
    }

    /**
     * Create a new InventoryDimension property with the specified value.
     *
     * @param value size to match
     * @param operator logical operator to use when comparing this property with
     *      other properties
     */
    public InventoryDimension(Vector2i value, Operator operator) {
        super(value, operator);
    }

    /**
     * Create a new InventoryDimension property with the specified dimensions.
     *
     * @param width width of the inventory to match
     * @param height height of the inventory to match
     * @param operator logical operator to use when comparing this property with
     *      other properties
     */
    public InventoryDimension(int width, int height, Operator operator) {
        super(new Vector2i(width, height), operator);
    }

    /**
     * Create a new InventoryDimension property with the specified value.
     *
     * @param value size to match
     * @param operator logical operator to use when comparing this property with
     *      other properties
     */
    public InventoryDimension(Object value, Operator operator) {
        super(Coerce.toVector2i(value), operator);
    }

    /**
     * Gets the number of columns in this inventory.
     *
     * @return column count
     */
    public int getColumns() {
        return this.getValue().getX();
    }

    /**
     * Gets the number of rows in this inventory.
     *
     * @return row count
     */
    public int getRows() {
        return this.getValue().getY();
    }

    @Override
    public int compareTo(Property<?, ?> other) {
        if (other == null) {
            return 1;
        }

        return this.getValue().compareTo(Coerce.toVector2i(other.getValue()));
    }

    /**
     * Create an InventoryDimension property which matches InventoryDimension
     * properties with equal value.
     *
     * @param value value to match
     * @return new property
     */
    public static InventoryDimension of(Object value) {
        return new InventoryDimension(value, Operator.EQUAL);
    }

    /**
     * Create an InventoryDimension property which matches InventoryDimension
     * properties with equal value.
     *
     * @param width x coordinate to match
     * @param height y coordinate to match
     * @return new property
     */
    public static InventoryDimension of(int width, int height) {
        return new InventoryDimension(new Vector2i(width, height), Operator.EQUAL);
    }

    /**
     * Create an InventoryDimension property which matches InventoryDimension
     * properties with unequal value.
     *
     * @param value value to match
     * @return new property
     */
    public static InventoryDimension not(Object value) {
        return new InventoryDimension(value, Operator.NOTEQUAL);
    }

    /**
     * Create an InventoryDimension property which matches InventoryDimension
     * properties with value greater than this value.
     *
     * @param value value to match
     * @return new property
     */
    public static InventoryDimension greaterThan(Object value) {
        return new InventoryDimension(value, Operator.GREATER);
    }

    /**
     * Create an InventoryDimension property which matches InventoryDimension
     * properties with value greater than or equal to this value.
     *
     * @param value value to match
     * @return new property
     */
    public static InventoryDimension greaterThanOrEqual(Object value) {
        return new InventoryDimension(value, Operator.GEQUAL);
    }

    /**
     * Create an InventoryDimension property which matches InventoryDimension
     * properties with value less than this value.
     *
     * @param value value to match
     * @return new property
     */
    public static InventoryDimension lessThan(Object value) {
        return new InventoryDimension(value, Operator.LESS);
    }

    /**
     * Create an InventoryDimension property which matches InventoryDimension
     * properties with value less than or equal to this value.
     *
     * @param value value to match
     * @return new property
     */
    public static InventoryDimension lessThanOrEqual(Object value) {
        return new InventoryDimension(value, Operator.LEQUAL);
    }

}
