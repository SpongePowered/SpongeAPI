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
package org.spongepowered.api.entity.attribute.type;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.entity.attribute.AttributeModifier;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Optional;

/**
 * Represents an attribute type that can apply effects or modify traits related to an entity.
 */
@CatalogedBy(AttributeTypes.class)
public interface AttributeType extends CatalogType {

    /**
     * Gets the parent attribute type of this attribute type.
     *
     * @return The parent type if present.
     */
    Optional<AttributeType> getParent();

    /**
     * Gets the default value of this attribute type before any {@link AttributeModifier}s are applied.
     *
     * @return The default value of this attribute type.
     */
    double getDefaultValue();

    /**
     * Clamps a value to be within the bounds of this attribute type.
     *
     * @param value The value to clamp
     * @return A value within this attribute type's bounds.
     */
    double clampValue(double value);
}
