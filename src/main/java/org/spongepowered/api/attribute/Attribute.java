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

package org.spongepowered.api.attribute;

import com.google.common.base.Predicate;
import org.spongepowered.api.util.annotation.CatalogedBy;

/**
 * Represents a type of attribute that can be applied to an {@link
 * AttributeHolder}.
 */
@CatalogedBy(Attributes.class)
public interface Attribute {

    /**
     * Gets the name of this attribute as a string.
     *
     * @return The name of this attribute as a string
     */
    String getName();

    /**
     * Gets the minimum value for this attribute.
     *
     * @return The minimum value for this attribute
     */
    double getMinimum();

    /**
     * Gets the maximum value for this attribute.
     *
     * @return The maximum value for this attribute
     */
    double getMaximum();

    /**
     * Gets the default value for this attribute.
     *
     * @return The default value for this attribute
     */
    double getDefaultValue();

    /**
     * Gets a predicate to decide if a given {@link AttributeHolder} can have
     * this attribute applied to it.
     *
     * @return A predicate to decide if this attribute can be applied
     */
    Predicate<AttributeHolder> getTargets();

}
