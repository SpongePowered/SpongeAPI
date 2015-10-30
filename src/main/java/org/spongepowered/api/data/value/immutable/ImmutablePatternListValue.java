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

import org.spongepowered.api.data.meta.PatternLayer;
import org.spongepowered.api.data.type.BannerPatternShape;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.value.mutable.PatternListValue;

import java.util.List;
import java.util.function.Predicate;

public interface ImmutablePatternListValue extends ImmutableListValue<PatternLayer> {

    /**
     * Creates and adds a {@link PatternLayer} based on the
     * {@link BannerPatternShape} and {@link DyeColor} at the desired index
     * such that the element at the provided index is shifted to the left. This
     * returns a new {@link ImmutablePatternListValue}.
     *
     * @param patternShape The pattern shape
     * @param color The color of the pattern
     * @return The new value, for chaining
     */
    ImmutablePatternListValue with(BannerPatternShape patternShape, DyeColor color);

    @Override
    ImmutablePatternListValue with(int index, PatternLayer value);

    @Override
    ImmutablePatternListValue with(int index, Iterable<PatternLayer> values);

    /**
     * Creates and adds a {@link PatternLayer} based on the
     * {@link BannerPatternShape} and {@link DyeColor} at the desired index
     * such that the element at the provided index is shifted to the left.
     *
     * @param index The index to add the element at
     * @param patternShape The pattern shape
     * @param color The color of the pattern
     * @return The new value, for chaining
     */
    ImmutablePatternListValue with(int index, BannerPatternShape patternShape, DyeColor color);

    @Override
    ImmutablePatternListValue with(List<PatternLayer> collection);

    @Override
    ImmutablePatternListValue withElement(PatternLayer elements);

    @Override
    ImmutablePatternListValue withAll(Iterable<PatternLayer> elements);

    /**
     * Creates and adds a {@link PatternLayer} based on the
     * {@link BannerPatternShape} and {@link DyeColor} at the desired index
     * such that the element at the provided index is shifted to the left.
     *
     * @param index The index to add the element at
     * @param patternShape The pattern shape
     * @param color The color of the pattern
     * @return The new value, for chaining
     */
    ImmutablePatternListValue set(int index, BannerPatternShape patternShape, DyeColor color);

    @Override
    ImmutablePatternListValue set(int index, PatternLayer element);

    @Override
    ImmutablePatternListValue without(PatternLayer element);

    @Override
    ImmutablePatternListValue without(int index);

    @Override
    ImmutablePatternListValue withoutAll(Iterable<PatternLayer> elements);

    @Override
    ImmutablePatternListValue withoutAll(Predicate<PatternLayer> predicate);

    @Override
    PatternListValue asMutable();
}
