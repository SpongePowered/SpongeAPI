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
package org.spongepowered.api.data.value.meta;

import org.spongepowered.api.data.meta.PatternLayer;
import org.spongepowered.api.data.type.BannerPatternShape;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.value.ListValue;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface PatternListValue extends ListValue<PatternLayer> {

    default boolean contains(BannerPatternShape shape) {
        return getAll()
            .stream()
            .anyMatch(patternLayer -> patternLayer.getShape().equals(shape));
    }

    default boolean contains(DyeColor color) {
        return getAll()
            .stream()
            .anyMatch(patternLayer -> patternLayer.getColor().equals(color));
    }

    @Override
    PatternListValue.Mutable asMutable();
    @Override
    PatternListValue.Immutable asImmutable();

    interface Immutable extends ListValue.Immutable<PatternLayer>, PatternListValue {

        /**
         * Creates and adds a {@link PatternLayer} based on the
         * {@link BannerPatternShape} and {@link DyeColor} at the desired index
         * such that the element at the provided index is shifted to the left. This
         * returns a new {@link PatternListValue.Immutable}.
         *
         * @param patternShape The pattern shape
         * @param color The color of the pattern
         * @return The new value, for chaining
         */
        PatternListValue.Immutable with(BannerPatternShape patternShape, DyeColor color);

        @Override
        PatternListValue.Immutable with(int index, PatternLayer value);

        @Override
        PatternListValue.Immutable with(int index, Iterable<PatternLayer> values);

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
        PatternListValue.Immutable with(int index, BannerPatternShape patternShape, DyeColor color);

        @Override
        PatternListValue.Immutable with(List<PatternLayer> collection);

        @Override
        PatternListValue.Immutable withElement(PatternLayer elements);

        @Override
        PatternListValue.Immutable withAll(Iterable<PatternLayer> elements);

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
        PatternListValue.Immutable set(int index, BannerPatternShape patternShape, DyeColor color);

        @Override
        PatternListValue.Immutable set(int index, PatternLayer element);

        @Override
        PatternListValue.Immutable without(PatternLayer element);

        @Override
        PatternListValue.Immutable without(int index);

        @Override
        PatternListValue.Immutable withoutAll(Iterable<PatternLayer> elements);

        @Override
        PatternListValue.Immutable withoutAll(Predicate<PatternLayer> predicate);

        @Override
        PatternListValue.Mutable asMutable();

        @Override
        PatternListValue.Immutable asImmutable();
    }

    /**
     * Represents a customized {@link ListValue.Mutable} handling {@link PatternLayer}s.
     * Virtually, this is the same as a {@link ListValue.Mutable}; however, the core
     * difference is the ability to add a {@link BannerPatternShape} and
     * {@link DyeColor} to create a new {@link PatternLayer}.
     */
    interface Mutable extends PatternListValue, ListValue.Mutable<PatternLayer> {

        @Override
        PatternListValue.Mutable add(PatternLayer element);

        /**
         * Creates and adds a new {@link PatternLayer} based on the provided
         * {@link BannerPatternShape} and {@link DyeColor}.
         *
         * @param patternShape The pattern shape
         * @param color The color
         * @return This value, for chaining
         */
        PatternListValue.Mutable add(BannerPatternShape patternShape, DyeColor color);

        @Override
        PatternListValue.Mutable add(int index, PatternLayer value);

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
        PatternListValue.Mutable add(int index, BannerPatternShape patternShape, DyeColor color);

        @Override
        PatternListValue.Mutable add(int index, Iterable<PatternLayer> values);

        @Override
        PatternListValue.Mutable set(int index, PatternLayer element);

        @Override
        PatternListValue.Mutable set(List<PatternLayer> value);

        @Override
        PatternListValue.Mutable transform(Function<List<PatternLayer>, List<PatternLayer>> function);

        @Override
        PatternListValue.Mutable addAll(Iterable<PatternLayer> elements);

        @Override
        PatternListValue.Mutable remove(int index);

        @Override
        PatternListValue.Mutable remove(PatternLayer element);

        @Override
        PatternListValue.Mutable removeAll(Iterable<PatternLayer> elements);

        @Override
        PatternListValue.Mutable removeAll(Predicate<PatternLayer> predicate);

        @Override
        PatternListValue.Mutable filter(Predicate<? super PatternLayer> predicate);

        @Override
        PatternListValue.Mutable asMutable();

        @Override
        PatternListValue.Immutable asImmutable();
    }
}
