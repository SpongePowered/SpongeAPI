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

package org.spongepowered.api.data.properties;

/**
 * Represents a limit on the number of uses on an item. Whether the uses are
 * defined as durability or another item data value, usually, when the uses
 * exceed this use limit, the item is removed or consumed.
 */
public class UseLimitProperty extends IntProperty {

    /**
     * Creates a new {@link UseLimitProperty}.
     *
     * @param value The maximum use limit
     */
    public UseLimitProperty(int value) {
        super(value);
    }

    /**
     * Creates a new {@link UseLimitProperty}.
     *
     * @param value The maximum use limit
     * @param operator The operator to use to compare to other properties
     */
    public UseLimitProperty(int value, Operator operator) {
        super(value, operator);
    }

    /**
     * Creates a new {@link UseLimitProperty}.
     *
     * @param value The maximum use limit
     * @param operator The operator to use to compare to other properties
     */
    public UseLimitProperty(Object value, Operator operator) {
        super(value, operator);
    }
}
