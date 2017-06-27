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
import org.spongepowered.api.data.property.item.FoodRestorationProperty;
import org.spongepowered.api.data.property.item.SaturationProperty;
import org.spongepowered.api.util.Coerce;

/**
 * Represents an item property that has an integer value. Examples may include
 * {@link FoodRestorationProperty}, {@link SaturationProperty} etc.
 */
public class DoubleProperty extends AbstractProperty<String, Double> {

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
    public int compareTo(Property<?, ?> other) {
        return this.getValue().compareTo(other == null ? 1 : Coerce.toDouble(other.getValue()));
    }

}
