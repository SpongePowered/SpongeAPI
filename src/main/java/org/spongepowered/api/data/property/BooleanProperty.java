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
package org.spongepowered.api.data.property;

import org.spongepowered.api.data.Property;
import org.spongepowered.api.util.Coerce;

/**
 * Represents an item property that has an integer value. Examples may include
 * {@link FoodRestorationProperty}, {@link SaturationProperty} etc.
 */
public class BooleanProperty extends AbstractProperty<String, Boolean> {

    /**
     * Create a new integer property with the specified value.
     *
     * @param value value to match
     */
    public BooleanProperty(boolean value) {
        super(Coerce.toBoolean(value));
    }

    /**
     * Create a new integer property with the specified value and logical
     * operator.
     *
     * @param value value to match
     * @param operator logical operator to use when comparing to other
     *      properties
     */
    public BooleanProperty(boolean value, Operator operator) {
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
    public BooleanProperty(Object value, Operator operator) {
        super(Coerce.toBoolean(value), operator);
    }

    @Override
    public int compareTo(Property<?, ?> other) {
        return this.getValue().compareTo(other == null || Coerce.toBoolean(other.getValue()));
    }

    /**
     * Create an DoubleProperty property which matches DoubleProperty properties with
     * equal value.
     *
     * @param value value to match
     * @return new property
     */
    public static BooleanProperty of(Object value) {
        return new BooleanProperty(value, Operator.EQUAL);
    }

    /**
     * Create an DoubleProperty property which matches DoubleProperty properties with
     * unequal value.
     *
     * @param value value to match
     * @return new property
     */
    public static BooleanProperty not(Object value) {
        return new BooleanProperty(value, Operator.NOTEQUAL);
    }

    /**
     * Create an DoubleProperty property which matches DoubleProperty properties with
     * value greater than this value.
     *
     * @param value value to match
     * @return new property
     */
    public static BooleanProperty greaterThan(Object value) {
        return new BooleanProperty(value, Operator.GREATER);
    }

    /**
     * Create an DoubleProperty property which matches DoubleProperty properties with
     * value greater than or equal to this value.
     *
     * @param value value to match
     * @return new property
     */
    public static BooleanProperty greaterThanOrEqual(Object value) {
        return new BooleanProperty(value, Operator.GEQUAL);
    }

    /**
     * Create an DoubleProperty property which matches DoubleProperty properties with
     * value less than this value.
     *
     * @param value value to match
     * @return new property
     */
    public static BooleanProperty lessThan(Object value) {
        return new BooleanProperty(value, Operator.LESS);
    }

    /**
     * Create an DoubleProperty property which matches DoubleProperty properties with
     * value less than or equal to this value.
     *
     * @param value value to match
     * @return new property
     */
    public static BooleanProperty lessThanOrEqual(Object value) {
        return new BooleanProperty(value, Operator.LEQUAL);
    }


}
