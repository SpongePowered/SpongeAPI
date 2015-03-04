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

/**
 * Represents a property on an item that has an efficiency qualifier applied
 * when mining harvestable blocks. For determining whether a block can be
 * harvested, use {@link HarvestingProperty}.
 */
public class EfficiencyProperty extends IntProperty {

    /**
     * Creates a new EfficiencyProperty property for the specified value.
     *
     * @param value value to match
     */
    public EfficiencyProperty(int value) {
        super(value);
    }

    /**
     * Creates a new EfficiencyProperty property for the specified value
     * and operator.
     *
     * @param value value to match
     * @param operator the operator to use when comparing with other properties
     */
    public EfficiencyProperty(int value, Operator operator) {
        super(value, operator);
    }

    /**
     * Creates a new EfficiencyProperty property for the specified value
     * and operator.
     *
     * @param value value to match
     * @param operator the operator to use when comparing with other properties
     */
    public EfficiencyProperty(Object value, Operator operator) {
        super(value, operator);
    }
}
