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

import com.google.common.collect.ImmutableCollection;
import org.spongepowered.api.map.util.MapColorFactory;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

import java.util.function.Function;

/**
 * An enumeration of all the possible instances given {@link MapColor.Base}
 */
public final class MapColors {

    private static final MapColorFactory factory = null;

    // SORTFIELDS:ON

    public static final MapColor.Base ADOBE = DummyObjectProvider.createFor(MapColor.Base.class, "ADOBE");

    public static final MapColor.Base AIR = DummyObjectProvider.createFor(MapColor.Base.class, "AIR");

    public static final MapColor.Base BLACK = DummyObjectProvider.createFor(MapColor.Base.class, "BLACK");

    public static final MapColor.Base BLUE = DummyObjectProvider.createFor(MapColor.Base.class, "BLUE");

    public static final MapColor.Base BROWN = DummyObjectProvider.createFor(MapColor.Base.class, "BROWN");

    public static final MapColor.Base CLAY = DummyObjectProvider.createFor(MapColor.Base.class, "CLAY");

    public static final MapColor.Base CLOTH = DummyObjectProvider.createFor(MapColor.Base.class, "CLOTH");

    public static final MapColor.Base CYAN = DummyObjectProvider.createFor(MapColor.Base.class, "CYAN");

    public static final MapColor.Base DIAMOND = DummyObjectProvider.createFor(MapColor.Base.class, "DIAMOND");

    public static final MapColor.Base DIRT = DummyObjectProvider.createFor(MapColor.Base.class, "DIRT");

    public static final MapColor.Base EMERALD = DummyObjectProvider.createFor(MapColor.Base.class, "EMERALD");

    public static final MapColor.Base FOLIAGE = DummyObjectProvider.createFor(MapColor.Base.class, "FOLIAGE");

    public static final MapColor.Base GOLD = DummyObjectProvider.createFor(MapColor.Base.class, "GOLD");

    public static final MapColor.Base GRASS = DummyObjectProvider.createFor(MapColor.Base.class, "GRASS");

    public static final MapColor.Base GRAY = DummyObjectProvider.createFor(MapColor.Base.class, "GRAY");

    public static final MapColor.Base GREEN = DummyObjectProvider.createFor(MapColor.Base.class, "GREEN");

    public static final MapColor.Base ICE = DummyObjectProvider.createFor(MapColor.Base.class, "ICE");

    public static final MapColor.Base IRON = DummyObjectProvider.createFor(MapColor.Base.class, "IRON");

    public static final MapColor.Base LAPIS = DummyObjectProvider.createFor(MapColor.Base.class, "LAPIS");

    public static final MapColor.Base LIGHT_BLUE = DummyObjectProvider.createFor(MapColor.Base.class, "LIGHT_BLUE");

    public static final MapColor.Base LIME = DummyObjectProvider.createFor(MapColor.Base.class, "LIME");

    public static final MapColor.Base MAGENTA = DummyObjectProvider.createFor(MapColor.Base.class, "MAGENTA");

    public static final MapColor.Base NETHERRACK = DummyObjectProvider.createFor(MapColor.Base.class, "NETHERRACK");

    public static final MapColor.Base OBSIDIAN = DummyObjectProvider.createFor(MapColor.Base.class, "OBSIDIAN");

    public static final MapColor.Base PINK = DummyObjectProvider.createFor(MapColor.Base.class, "PINK");

    public static final MapColor.Base PURPLE = DummyObjectProvider.createFor(MapColor.Base.class, "PURPLE");

    public static final MapColor.Base QUARTZ = DummyObjectProvider.createFor(MapColor.Base.class, "QUARTZ");

    public static final MapColor.Base RED = DummyObjectProvider.createFor(MapColor.Base.class, "RED");

    public static final MapColor.Base SAND = DummyObjectProvider.createFor(MapColor.Base.class, "SAND");

    public static final MapColor.Base SILVER = DummyObjectProvider.createFor(MapColor.Base.class, "SILVER");

    public static final MapColor.Base SNOW = DummyObjectProvider.createFor(MapColor.Base.class, "SNOW");

    public static final MapColor.Base STONE = DummyObjectProvider.createFor(MapColor.Base.class, "STONE");

    public static final MapColor.Base TNT = DummyObjectProvider.createFor(MapColor.Base.class, "TNT");

    public static final MapColor.Base WATER = DummyObjectProvider.createFor(MapColor.Base.class, "WATER");

    public static final MapColor.Base WOOD = DummyObjectProvider.createFor(MapColor.Base.class, "WOOD");

    public static final MapColor.Base YELLOW = DummyObjectProvider.createFor(MapColor.Base.class, "YELLOW");

    // SORTFIELDS:OFF

    /**
     * Returns all the possible {@link MapColor}s available, including the
     * shaded colors.
     *
     * @return All the map colors including shades
     */
    public static ImmutableCollection<MapColor> getAll() {
        return factory.getAll();
    }


    /**
     * Returns a {@link MapColor} that is closest matching to the given
     * {@link Color} applying the provided {@link Function} to perform
     * the match.
     *
     * @param color The color to match
     * @return The closest {@link MapColor} to the provided color
     */
    public static MapColor of(Color color) {
        return factory.of(color);
    }

    /**
     * Returns a {@link MapColor} that is closest matching to the given
     * {@link Color} applying the provided {@link Function} to perform
     * the match.
     *
     * @param color The color to match
     * @param matcher The {@link Function} used to perform the match
     * @return The closest {@link MapColor} to the provided color
     */
    public static MapColor of(Color color, Function<Color, MapColor> matcher) {
        return factory.of(color, matcher);
    }

    private MapColors() {
    }

}
