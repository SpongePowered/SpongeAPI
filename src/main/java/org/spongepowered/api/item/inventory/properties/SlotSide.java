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

import org.spongepowered.api.item.inventory.InventoryProperty;
import org.spongepowered.api.util.Coerce;
import org.spongepowered.api.util.Direction;

/**
 * Property which represents a "side" for a particular slot, for use in querying
 * "sided inventories".
 */
public class SlotSide extends AbstractInventoryProperty<String, Direction> {

    /**
     * Create a new SlotSide property for matching the specified value.
     * 
     * @param value the value to match
     */
    public SlotSide(Direction value) {
        super(value);
    }

    /**
     * Create a new SlotSide property for matching the specified value with the
     * specified operator.
     * 
     * @param value the value to match
     * @param operator the operator to use when comparing with other properties
     */
    public SlotSide(Direction value, Operator operator) {
        super(value, operator);
    }

    /**
     * Create a new SlotSide property for matching the specified value with the
     * specified operator.
     * 
     * @param value the value to match
     * @param operator the operator to use when comparing with other properties
     */
    public SlotSide(Object value, Operator operator) {
        super(Coerce.<Direction>toEnum(value, Direction.class, Direction.NONE), operator);
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(InventoryProperty<?, ?> other) {
        if (other == null) {
            return 1;
        }

        return this.getValue().compareTo(Coerce.<Direction>toEnum(other.getValue(), Direction.class, Direction.NONE));
    }

    /**
     * Create a SlotSide property which matches SlotSide properties with equal
     * value.
     * 
     * @param value the value to match
     * @return new property
     */
    public static SlotSide of(Object value) {
        return new SlotSide(value, Operator.EQUAL);
    }

    /**
     * Create a SlotSide property which matches SlotSide properties with unequal
     * value.
     * 
     * @param value the value to match
     * @return new property
     */
    public static SlotSide not(Object value) {
        return new SlotSide(value, Operator.NOTEQUAL);
    }

}
