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
package org.spongepowered.api.data.property.block;

import org.spongepowered.api.data.property.BooleanProperty;

public class StatisticsTrackedProperty extends BooleanProperty {

    /**
     * Creates a new {@link StatisticsTrackedProperty} for the provided
     * {@code value}. Usually applicable to blocks, whether those blocks
     * are statistically tracked.
     *
     * @param value The value whether statistics are tracked
     */
    public StatisticsTrackedProperty(boolean value) {
        super(value);
    }

    /**
     * Creates a new {@link StatisticsTrackedProperty} for the provided
     * {@code value} and {@link org.spongepowered.api.data.Property.Operator}.
     * Usually applicable to blocks, whether those blocks are statistically
     * tracked.
     *
     * @param value The value
     * @param operator The operator, for comparisons
     */
    public StatisticsTrackedProperty(boolean value, Operator operator) {
        super(value, operator);
    }
}
