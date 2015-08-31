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
package org.spongepowered.api.data.value.mutable;

import org.spongepowered.api.attribute.Attribute;
import org.spongepowered.api.attribute.AttributeModifier;
import org.spongepowered.api.data.value.immutable.ImmutableAttributeMapValue;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * A customized {@link MapValue} that handles the intricacies of
 * {@link Attribute}s and the {@link List} of {@link AttributeModifier}s.
 * // todo probably rewrite attributes to work...
 */
public interface AttributeMapValue extends MapValue<Attribute, List<AttributeModifier>> {

    @Override
    AttributeMapValue put(Attribute key, List<AttributeModifier> value);

    @Override
    AttributeMapValue putAll(Map<Attribute, List<AttributeModifier>> map);

    @Override
    AttributeMapValue remove(Attribute key);

    @Override
    AttributeMapValue removeAll(Iterable<Attribute> keys);

    @Override
    AttributeMapValue removeAll(Predicate<Map.Entry<Attribute, List<AttributeModifier>>> predicate);

    @Override
    ImmutableAttributeMapValue asImmutable();

    /**
     * Gets the finalized {@link Attribute}'s actual value after all associated
     * {@link AttributeModifier}s are applied.
     *
     * @param attribute The attribute to retrieve the final value for
     * @return The final attribute value, after all modifiers are applied
     */
    Value<Double> attributeValue(Attribute attribute);

    /**
     * Gets the base attribute value before any {@link AttributeModifier}s are
     * applied.
     *
     * @param attribute The attribute
     * @return The base attribute value
     */
    Value<Double> base(Attribute attribute);

}
