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
package org.spongepowered.api.item.properties;

import org.spongepowered.api.util.Coerce;

/**
 * Represents an item property that has an integer value. Examples may include
 * {@link FoodRestorationProperty}, {@link SaturationProperty} etc.
 */
public class DoubleProperty  extends AbstractItemProperty<String, Double> {


    /**
     * Create a new integer property with the specified value.
     *
     * @param value value to match
     */
    public DoubleProperty(double value) {
        super(Coerce.toDouble(value));
    }

    /**
     * Create a new integer property with the specified value and logical
     * operator.
     *
     * @param value value to match
     * @param operator logical operator to use when comparing to other
     *      properties
     */
    public DoubleProperty(double value, Operator operator) {
        super(value, operator);
    }

    /**
     * Create a new integer property with the specified value and logical
     * operator.
     *
     * @param value value to match
     * @param operator logical operator to use when comparing to other
     *      properties
     */
    public DoubleProperty(Object value, Operator operator) {
        super(Coerce.toDouble(value), operator);
    }

    @Override
    public int compareTo(ItemProperty<?, ?> other) {
        return this.getValue().compareTo(other == null ? 1 : Coerce.toDouble(other.getValue()));
    }

    /**
     * Create an DoubleProperty property which matches DoubleProperty properties with
     * equal value.
     *
     * @param value value to match
     * @return new property
     */
    public static DoubleProperty of(Object value) {
        return new DoubleProperty(value, Operator.EQUAL);
    }

    /**
     * Create an DoubleProperty property which matches DoubleProperty properties with
     * unequal value.
     *
     * @param value value to match
     * @return new property
     */
    public static DoubleProperty not(Object value) {
        return new DoubleProperty(value, Operator.NOTEQUAL);
    }

    /**
     * Create an DoubleProperty property which matches DoubleProperty properties with
     * value greater than this value.
     *
     * @param value value to match
     * @return new property
     */
    public static DoubleProperty greaterThan(Object value) {
        return new DoubleProperty(value, Operator.GREATER);
    }

    /**
     * Create an DoubleProperty property which matches DoubleProperty properties with
     * value greater than or equal to this value.
     *
     * @param value value to match
     * @return new property
     */
    public static DoubleProperty greaterThanOrEqual(Object value) {
        return new DoubleProperty(value, Operator.GEQUAL);
    }

    /**
     * Create an DoubleProperty property which matches DoubleProperty properties with
     * value less than this value.
     *
     * @param value value to match
     * @return new property
     */
    public static DoubleProperty lessThan(Object value) {
        return new DoubleProperty(value, Operator.LESS);
    }

    /**
     * Create an DoubleProperty property which matches DoubleProperty properties with
     * value less than or equal to this value.
     *
     * @param value value to match
     * @return new property
     */
    public static DoubleProperty lessThanOrEqual(Object value) {
        return new DoubleProperty(value, Operator.LEQUAL);
    }


}
