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
package org.spongepowered.api.data.property.item;

import org.spongepowered.api.data.property.BooleanProperty;
import org.spongepowered.api.data.property.common.TreeTypeProperty;
import org.spongepowered.api.item.ItemTypes;

/**
 * Represents the state that something is cooked, this is usually
 * food. For example, {@link ItemTypes#BEEF} is uncooked and
 * {@link ItemTypes#COOKED_BEEF} is cooked. This property will
 * only be supported by objects that support both states.
 */
public final class CookedProperty extends BooleanProperty {

    /**
     * Constructs a new {@link CookedProperty} with
     * the specified cooked state.
     *
     * @param value The cooked state
     */
    public CookedProperty(boolean value) {
        super(value);
    }

    /**
     * Constructs a new {@link TreeTypeProperty} with
     * the specified cooked state and {@link Operator}.
     *
     * @param value The cooked state
     * @param operator The operator
     */
    public CookedProperty(boolean value, Operator operator) {
        super(value, operator);
    }
}
