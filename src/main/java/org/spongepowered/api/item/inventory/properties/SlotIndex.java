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

/**
 * An inventory property which represents an index within an ordered inventory.
 */
public class SlotIndex extends IntProperty {

    /**
     * Creates a new SlotIndex property for the specified value.
     * 
     * @param value value to match
     */
    public SlotIndex(int value) {
        super(value);
    }

    /**
     * Creates a new SlotIndex property for the specified value and operator.
     * 
     * @param value value to match
     * @param operator the operator to use when comparing with other properties
     */
    public SlotIndex(int value, Operator operator) {
        super(value, operator);
    }

    /**
     * Creates a new SlotIndex property for the specified value and operator.
     * 
     * @param value value to match
     * @param operator the operator to use when comparing with other properties
     */
    public SlotIndex(Object value, Operator operator) {
        super(value, operator);
    }

    /**
     * Create a SlotIndex property which matches SlotIndex properties with
     * equal value.
     * 
     * @param value the value to match
     * @return new property
     */
    public static SlotIndex of(Object value) {
        return new SlotIndex(value, Operator.EQUAL);
    }

    /**
     * Create a SlotIndex property which matches SlotIndex properties with
     * unequal value.
     * 
     * @param value the value to match
     * @return new property
     */
    public static SlotIndex not(Object value) {
        return new SlotIndex(value, Operator.NOTEQUAL);
    }

    /**
     * Create a SlotIndex property which matches SlotIndex properties with
     * value greater than this value.
     * 
     * @param value the value to match
     * @return new property
     */
    public static SlotIndex greaterThan(Object value) {
        return new SlotIndex(value, Operator.GREATER);
    }

    /**
     * Create a SlotIndex property which matches SlotIndex properties with
     * value greater than or equal to this value.
     * 
     * @param value the value to match
     * @return new property
     */
    public static SlotIndex greaterThanOrEqual(Object value) {
        return new SlotIndex(value, Operator.GEQUAL);
    }

    /**
     * Create a SlotIndex property which matches SlotIndex properties with
     * value less than this value.
     * 
     * @param value the value to match
     * @return new property
     */
    public static SlotIndex lessThan(Object value) {
        return new SlotIndex(value, Operator.LESS);
    }

    /**
     * Create a SlotIndex property which matches SlotIndex properties with
     * value less than or equal to this value.
     * 
     * @param value the value to match
     * @return new property
     */
    public static SlotIndex lessThanOrEqual(Object value) {
        return new SlotIndex(value, Operator.LEQUAL);
    }

}
