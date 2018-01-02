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
package org.spongepowered.api.map.color;

import org.spongepowered.api.map.util.MapColorMatcher;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

import java.util.function.Function;

/**
 * An enumeration of all the built-in {@link MapColorMatcher}
 */
public final class MapColorMatchers {

    //SORTFIELDS:ON

    /**
     * A matcher that matches to the {@link MapColor} with the smallest overall
     * CIELab distance. This tends to be a much more accurate overall match, but
     * the conversion is slightly more computationally intensive.
     */
    public static final MapColorMatcher CIELAB = DummyObjectProvider.createFor(MapColorMatcher.class,"CIELAB");

    /**
     * This is the default color matcher and simply minimizes the distance in RGB
     * colorspace, this method is quite simple, but offers a fairly accurate match.
     */
    public static final MapColorMatcher RGB_UNWEIGHTED = DummyObjectProvider.createFor(MapColorMatcher.class,"RGB_UNWEIGHTED");

    //SORTFIELDS:OFF

}
