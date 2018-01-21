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
package org.spongepowered.api.extra.fluid.data.property;

import static com.google.common.base.Preconditions.checkArgument;

import org.spongepowered.api.data.property.IntProperty;

/**
 * Temperature of the fluid - completely arbitrary; higher temperature indicates
 * that the fluid is hotter than air. Usually, depending on the implementation,
 * the "hotter" the fluid, the more likely it is to make flammable blocks and
 * entities catch on fire.
 *
 * <p>Default value is approximately the real-life room temperature of water in
 * degrees Kelvin, otherwise known as 300K.</p>
 */
public class FluidTemperatureProperty extends IntProperty {

    /**
     * Creates a new {@link FluidTemperatureProperty} with the desired temperature.
     *
     * @param value The temperature
     */
    public FluidTemperatureProperty(int value) {
        super(value);
        checkArgument(value >= 0, "Temperature of a fluid cannot be less than zero!");
    }

    /**
     * Creates a new {@link FluidTemperatureProperty} with the desired temperature
     * and {@link org.spongepowered.api.data.Property.Operator} for comparisons.
     *
     * @param value The temperature
     * @param operator The operator
     */
    public FluidTemperatureProperty(int value, Operator operator) {
        super(value, operator);
        checkArgument(value >= 0, "Temperature of a fluid cannot be less than zero!");
    }

}
