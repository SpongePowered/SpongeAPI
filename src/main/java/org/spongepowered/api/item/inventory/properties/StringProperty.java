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

/**
 * A generic String property for an inventory.
 */
public class StringProperty extends AbstractInventoryProperty<String, String> {

    /**
     * Create a new String property for matching the specified value.
     * 
     * @param value the value to match
     */
    public StringProperty(String value) {
        super(value);
    }

    /**
     * Create a new String property for matching the specified value with the
     * specified operator.
     * 
     * @param value the value to match
     * @param operator the operator to use when comparing with other properties
     */
    public StringProperty(String value, Operator operator) {
        super(value, operator);
    }

    /**
     * Create a new String property for matching the specified value with the
     * specified operator.
     * 
     * @param value the value to match
     * @param operator the operator to use when comparing with other properties
     */
    public StringProperty(Object value, Operator operator) {
        super(Coerce.toString(value), operator);
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(InventoryProperty<?, ?> other) {
        if (other == null) {
            return 1;
        }

        return this.getValue().compareTo(Coerce.toString(other.getValue()));
    }

    /**
     * Create a StringProperty property which matches StringProperty properties
     * with equal value.
     * 
     * @param value the value to match
     * @return new property
     */
    public static StringProperty of(Object value) {
        return new StringProperty(value, Operator.EQUAL);
    }

    /**
     * Create a StringProperty property which matches StringProperty properties
     * with unequal value.
     * 
     * @param value the value to match
     * @return new property
     */
    public static StringProperty not(Object value) {
        return new StringProperty(value, Operator.NOTEQUAL);
    }

    /**
     * Create a StringProperty property which matches StringProperty properties
     * with value greater than this value.
     * 
     * @param value the value to match
     * @return new property
     */
    public static StringProperty greaterThan(Object value) {
        return new StringProperty(value, Operator.GREATER);
    }

    /**
     * Create a StringProperty property which matches StringProperty properties
     * with value greater than or equal to this value.
     * 
     * @param value the value to match
     * @return new property
     */
    public static StringProperty greaterThanOrEqual(Object value) {
        return new StringProperty(value, Operator.GEQUAL);
    }

    /**
     * Create a StringProperty property which matches StringProperty properties
     * with value less than this value.
     * 
     * @param value the value to match
     * @return new property
     */
    public static StringProperty lessThan(Object value) {
        return new StringProperty(value, Operator.LESS);
    }

    /**
     * Create a StringProperty property which matches StringProperty properties
     * with value less than or equal to this value.
     * 
     * @param value the value to match
     * @return new property
     */
    public static StringProperty lessThanOrEqual(Object value) {
        return new StringProperty(value, Operator.LEQUAL);
    }

}
