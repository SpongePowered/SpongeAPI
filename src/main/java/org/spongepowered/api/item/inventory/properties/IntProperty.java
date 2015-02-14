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
import org.spongepowered.api.util.inventory.Coerce;

/**
 * A generic integer property. 
 */
public class IntProperty extends AbstractInventoryProperty<String, Integer> {

    public IntProperty(int value) {
        super(Coerce.toInteger(value));
    }

    public IntProperty(int value, Operator operator) {
        super(value, operator);
    }

    public IntProperty(Object value, Operator operator) {
        super(Coerce.toInteger(value), operator);
    }

    /**
     * Create an IntProperty property which matches IntProperty properties with
     * equal value
     */
    public static IntProperty of(Object value) {
        return new IntProperty(value, Operator.EQUAL);
    }

    /**
     * Create an IntProperty property which matches IntProperty properties with
     * unequal value
     */
    public static IntProperty not(Object value) {
        return new IntProperty(value, Operator.NOTEQUAL);
    }

    /**
     * Create an IntProperty property which matches IntProperty properties with
     * value greater than this value
     */
    public static IntProperty greaterThan(Object value) {
        return new IntProperty(value, Operator.GREATER);
    }

    /**
     * Create an IntProperty property which matches IntProperty properties with
     * value greater than or equal to this value
     */
    public static IntProperty greaterThanOrEqual(Object value) {
        return new IntProperty(value, Operator.GEQUAL);
    }

    /**
     * Create an IntProperty property which matches IntProperty properties with
     * value less than this value
     */
    public static IntProperty lessThan(Object value) {
        return new IntProperty(value, Operator.LESS);
    }

    /**
     * Create an IntProperty property which matches IntProperty properties with
     * value less than or equal to this value
     */
    public static IntProperty lessThanOrEqual(Object value) {
        return new IntProperty(value, Operator.LEQUAL);
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(InventoryProperty<?, ?> other) {
        return this.getValue().compareTo(other == null ? 1 : Coerce.toInteger(other.getValue()));
    }

}
