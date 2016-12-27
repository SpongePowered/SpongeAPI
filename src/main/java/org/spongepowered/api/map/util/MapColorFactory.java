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
package org.spongepowered.api.map.util;

import com.google.common.collect.ImmutableCollection;
import org.spongepowered.api.map.color.MapColor;
import org.spongepowered.api.map.color.MapColorMatchers;
import org.spongepowered.api.map.color.MapColors;
import org.spongepowered.api.util.Color;

import java.util.function.Function;

/**
 * Represents the required implementation for the static methods in
 * {@link MapColors}.
 */
public interface MapColorFactory {

    /**
     * Returns all the possible {@link MapColor}s available, including the
     * shaded colors.
     *
     * @return All the map colors including shades
     */
    ImmutableCollection<MapColor> getAll();

    /**
     * Returns a {@link MapColor} that is closest matching to the given
     * {@link Color} using the {@link MapColorMatchers#RGB_UNWEIGHTED}
     * match type.
     *
     * @param color The color to match
     * @return The closest {@link MapColor} to the provided color
     */
    default MapColor of(Color color) {
        return of(color, MapColorMatchers.RGB_UNWEIGHTED);
    }

    /**
     * Returns a {@link MapColor} that is closest matching to the given
     * {@link Color} applying the provided {@link Function} to perform
     * the match.
     *
     * @param color The color to match
     * @param matcher The function applied to perform the match
     * @return The closest {@link MapColor} to the provided color
     */
    MapColor of(Color color, Function<Color, MapColor> matcher);

}
