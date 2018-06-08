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

import org.spongepowered.api.data.meta.PatternLayer;
import org.spongepowered.api.data.type.BannerPatternShape;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.value.immutable.ImmutablePatternListValue;
import org.spongepowered.api.data.value.meta.PatternListValue;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Represents a customized {@link MutableListValue} handling {@link PatternLayer}s.
 * Virtually, this is the same as a {@link MutableListValue}; however, the core
 * difference is the ability to add a {@link BannerPatternShape} and
 * {@link DyeColor} to create a new {@link PatternLayer}.
 */
public interface PatternMutableListValue extends PatternListValue, MutableListValue<PatternLayer> {

    @Override
    PatternMutableListValue add(PatternLayer element);

    /**
     * Creates and adds a new {@link PatternLayer} based on the provided
     * {@link BannerPatternShape} and {@link DyeColor}.
     *
     * @param patternShape The pattern shape
     * @param color The color
     * @return This value, for chaining
     */
    PatternMutableListValue add(BannerPatternShape patternShape, DyeColor color);

    @Override
    PatternMutableListValue add(int index, PatternLayer value);

    /**
     * Creates and adds a {@link PatternLayer} based on the
     * {@link BannerPatternShape} and {@link DyeColor} at the desired index
     * such that the element at the provided index is shifted to the left.
     *
     * @param index The index to add the element at
     * @param patternShape The pattern shape
     * @param color The color of the pattern
     * @return This value, for chaining
     */
    PatternMutableListValue add(int index, BannerPatternShape patternShape, DyeColor color);

    @Override
    PatternMutableListValue add(int index, Iterable<PatternLayer> values);

    @Override
    PatternMutableListValue set(int index, PatternLayer element);

    @Override
    PatternMutableListValue set(List<PatternLayer> value);

    @Override
    PatternMutableListValue transform(Function<List<PatternLayer>, List<PatternLayer>> function);

    @Override
    PatternMutableListValue addAll(Iterable<PatternLayer> elements);

    @Override
    PatternMutableListValue remove(int index);

    @Override
    PatternMutableListValue remove(PatternLayer element);

    @Override
    PatternMutableListValue removeAll(Iterable<PatternLayer> elements);

    @Override
    PatternMutableListValue removeAll(Predicate<PatternLayer> predicate);

    @Override
    PatternMutableListValue filter(Predicate<? super PatternLayer> predicate);

    @Override
    ImmutablePatternListValue asImmutable();
}
