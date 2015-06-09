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
package org.spongepowered.api.data.value.immutable;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import org.spongepowered.api.attribute.Attribute;
import org.spongepowered.api.attribute.AttributeModifier;
import org.spongepowered.api.data.value.mutable.AttributeMapValue;

import java.util.List;
import java.util.Map;

/**
 * A customized {@link ImmutableMapValue} specifically handling
 * {@link Attribute}s and the {@link AttributeModifier}s that modify the
 * final value. The underlying list as well is not mutable once offered to an
 * {@link ImmutableAttributeMapValue}.
 */
public interface ImmutableAttributeMapValue extends ImmutableMapValue<Attribute, List<AttributeModifier>> {

    @Override
    ImmutableAttributeMapValue with(Attribute key, List<AttributeModifier> value);

    @Override
    ImmutableAttributeMapValue with(Map<Attribute, List<AttributeModifier>> value);

    @Override
    ImmutableAttributeMapValue withAll(Map<Attribute, List<AttributeModifier>> value);

    @Override
    ImmutableAttributeMapValue without(Attribute key);

    @Override
    ImmutableAttributeMapValue withoutAll(Iterable<Attribute> keys);

    @Override
    ImmutableAttributeMapValue withoutAll(Predicate<Map.Entry<Attribute, List<AttributeModifier>>> predicate);

    @Override
    ImmutableAttributeMapValue transform(Function<Map<Attribute, List<AttributeModifier>>, Map<Attribute, List<AttributeModifier>>> function);

    @Override
    AttributeMapValue asMutable();

    /**
     * Gets the finalized {@link Attribute}'s actual value after all associated
     * {@link AttributeModifier}s are applied.
     *
     * @param attribute The attribute to retrieve
     * @return The value
     */
    ImmutableValue<Double> attributeValue(Attribute attribute);

    /**
     * Gets the base {@link Attribute} value.
     *
     * @param attribute The base attribute
     * @return The base attribute value
     */
    ImmutableValue<Double> base(Attribute attribute);
}
