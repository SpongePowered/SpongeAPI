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
import org.spongepowered.api.util.Coerce;

/**
 * An inventory property which represents a position within a grid. Bear in mind
 * that this property should be queried against the relevant parent, since a
 * slot may have multiple parent inventories. 
 */
public class SlotPos extends AbstractInventoryProperty<String, Vector2i> {

    /**
     * Create a new SlotPos property for matching the specified value.
     * 
     * @param value the value to match
     */
    public SlotPos(Vector2i value) {
        super(value);
    }

    /**
     * Create a new SlotPos property for matching the specified value.
     * 
     * @param x slot x position
     * @param y slot y position
     */
    public SlotPos(int x, int y) {
        super(new Vector2i(x, y));
    }

    /**
     * Create a new SlotPos property for matching the specified value with the
     * specified operator.
     * 
     * @param value the value to match
     * @param operator the operator to use when comparing with other properties
     */
    public SlotPos(Vector2i value, Operator operator) {
        super(value, operator);
    }

    /**
     * Create a new SlotPos property for matching the specified value with the
     * specified operator.
     * 
     * @param x slot x position
     * @param y slot y position
     * @param operator the operator to use when comparing with other properties
     */
    public SlotPos(int x, int y, Operator operator) {
        super(new Vector2i(x, y), operator);
    }

    /**
     * Create a new SlotPos property for matching the specified value with the
     * specified operator.
     * 
     * @param value the value to match
     * @param operator the operator to use when comparing with other properties
     */
    public SlotPos(Object value, Operator operator) {
        super(Coerce.toVector2i(value), operator);
    }

    /**
     * Get the X position of this slot within the queried parent.
     * 
     * @return slot x coordinate
     */
    public int getX() {
        return this.getValue().getX();
    }

    /**
     * Get the Y position of this slot within the queried parent.
     * 
     * @return slot y coordinate
     */
    public int getY() {
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
     * Create an SlotPos property which matches SlotPos properties with equal
     * value.
     * 
     * @param value the value to match
     * @return new property
     */
    public static SlotPos of(Object value) {
        return new SlotPos(value, Operator.EQUAL);
    }

    /**
     * Create an SlotPos property which matches SlotPos properties with equal
     * value.
     * 
     * @param x the x position of the slot to match
     * @param y the y position of the slot to match
     * @return new property
     */
    public static SlotPos of(int x, int y) {
        return new SlotPos(new Vector2i(x, y), Operator.EQUAL);
    }

    /**
     * Create an SlotPos property which matches SlotPos properties with unequal
     * value.
     * 
     * @param value the value to match
     * @return new property
     */
    public static SlotPos not(Object value) {
        return new SlotPos(value, Operator.NOTEQUAL);
    }

    /**
     * Create an SlotPos property which matches SlotPos properties with value
     * greater than this value.
     * 
     * @param value the value to match
     * @return new property
     */
    public static SlotPos greaterThan(Object value) {
        return new SlotPos(value, Operator.GREATER);
    }

    /**
     * Create an SlotPos property which matches SlotPos properties with value
     * greater than or equal to this value.
     * 
     * @param value the value to match
     * @return new property
     */
    public static SlotPos greaterThanOrEqual(Object value) {
        return new SlotPos(value, Operator.GEQUAL);
    }

    /**
     * Create an SlotPos property which matches SlotPos properties with value
     * less than this value.
     * 
     * @param value the value to match
     * @return new property
     */
    public static SlotPos lessThan(Object value) {
        return new SlotPos(value, Operator.LESS);
    }

    /**
     * Create an SlotPos property which matches SlotPos properties with value
     * less than or equal to this value.
     * 
     * @param value the value to match
     * @return new property
     */
    public static SlotPos lessThanOrEqual(Object value) {
        return new SlotPos(value, Operator.LEQUAL);
    }

}
