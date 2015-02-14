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
package org.spongepowered.api.item.inventory.properties;

import com.flowpowered.math.vector.Vector2i;
import org.spongepowered.api.item.inventory.InventoryProperty;
import org.spongepowered.api.util.inventory.Coerce;

/**
 * Property for inventories of a particular size. For example to allow querying
 * for InventoryRows of length 9 or GridInventories of size 3x3
 */
public class InventorySize extends AbstractInventoryProperty<String, Vector2i> {

    public InventorySize(Vector2i value) {
        super(value);
    }

    public InventorySize(int x, int y) {
        super(new Vector2i(x, y));
    }

    public InventorySize(Vector2i value, Operator operator) {
        super(value, operator);
    }

    public InventorySize(int x, int y, Operator operator) {
        super(new Vector2i(x, y), operator);
    }

    public InventorySize(Object value, Operator operator) {
        super(Coerce.toVector2i(value), operator);
    }

    /**
     * Get the number of columns in this inventory
     */
    public int getColumns() {
        return this.getValue().getX();
    }

    /**
     * Get the number of rows in this inventory
     */
    public int getRows() {
        return this.getValue().getY();
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(InventoryProperty<?, ?> other) {
        if (other == null) {
            return 1;
        }

        return this.getValue().compareTo(Coerce.toVector2i(other.getValue()));
    }

    /**
     * Create an InventorySize property which matches InventorySize properties
     * with equal value
     */
    public static InventorySize of(Object value) {
        return new InventorySize(value, Operator.EQUAL);
    }

    /**
     * Create an InventorySize property which matches InventorySize properties
     * with equal value
     */
    public static InventorySize of(int x, int y) {
        return new InventorySize(new Vector2i(x, y), Operator.EQUAL);
    }

    /**
     * Create an InventorySize property which matches InventorySize properties
     * with unequal value
     */
    public static InventorySize not(Object value) {
        return new InventorySize(value, Operator.NOTEQUAL);
    }

    /**
     * Create an InventorySize property which matches InventorySize properties
     * with value greater than this value
     */
    public static InventorySize greaterThan(Object value) {
        return new InventorySize(value, Operator.GREATER);
    }

    /**
     * Create an InventorySize property which matches InventorySize properties
     * with value greater than or equal to this value
     */
    public static InventorySize greaterThanOrEqual(Object value) {
        return new InventorySize(value, Operator.GEQUAL);
    }

    /**
     * Create an InventorySize property which matches InventorySize properties
     * with value less than this value
     */
    public static InventorySize lessThan(Object value) {
        return new InventorySize(value, Operator.LESS);
    }

    /**
     * Create an InventorySize property which matches InventorySize properties
     * with value less than or equal to this value
     */
    public static InventorySize lessThanOrEqual(Object value) {
        return new InventorySize(value, Operator.LEQUAL);
    }

}
