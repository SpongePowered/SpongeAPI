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

import org.spongepowered.api.data.Property;
import org.spongepowered.api.data.property.AbstractProperty;
import org.spongepowered.api.data.type.ToolType;

import javax.annotation.Nullable;

public class ToolTypeProperty extends AbstractProperty<String, ToolType> {

    /**
     * Creates a new {@link ToolTypeProperty} with the provided
     * {@link ToolType} value.
     *
     * @param value The value
     */
    public ToolTypeProperty(@Nullable ToolType value) {
        super(value);
    }

    /**
     * Creates a new {@link ToolTypeProperty} with the provided
     * {@link ToolType} value and
     * {@link org.spongepowered.api.data.Property.Operator}
     * for comparisons.
     *
     * @param value The value
     * @param op The operator for comparisons
     */
    public ToolTypeProperty(@Nullable ToolType value, @Nullable Operator op) {
        super(value, op);
    }

    @Override
    public int compareTo(Property<?, ?> o) {
        if (o instanceof ToolTypeProperty) {
            ToolTypeProperty property = (ToolTypeProperty) o;
            return this.getValue().getName().compareTo(property.getValue().getName());
        }
        return this.getClass().getName().compareTo(o.getClass().getName());
    }
}
