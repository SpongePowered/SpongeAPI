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
import org.spongepowered.api.map.util.MapPaletteFactory;

/**
 * A representation of the palette of a map. This provides a set of constants
 * that hold the named based colors in a map, along with methods to retrieve
 * the full listing of all the colors and their shades.
 */
public final class MapPalette {

    private static MapPaletteFactory factory = null;

    private MapPalette() {
    }

    public static final MapColor AIR = null;
    public static final MapColor GRASS = null;
    public static final MapColor SAND = null;
    public static final MapColor CLOTH = null;
    public static final MapColor TNT = null;
    public static final MapColor ICE = null;
    public static final MapColor IRON = null;
    public static final MapColor FOLIAGE = null;
    public static final MapColor SNOW = null;
    public static final MapColor CLAY = null;
    public static final MapColor DIRT = null;
    public static final MapColor STONE = null;
    public static final MapColor WATER = null;
    public static final MapColor WOOD = null;
    public static final MapColor QUARTZ = null;
    public static final MapColor ADOBE = null;
    public static final MapColor MAGENTA = null;
    public static final MapColor LIGHT_BLUE = null;
    public static final MapColor YELLOW = null;
    public static final MapColor LIME = null;
    public static final MapColor PINK = null;
    public static final MapColor GRAY = null;
    public static final MapColor SILVER = null;
    public static final MapColor CYAN = null;
    public static final MapColor PURPLE = null;
    public static final MapColor BLUE = null;
    public static final MapColor BROWN = null;
    public static final MapColor GREEN = null;
    public static final MapColor RED = null;
    public static final MapColor BLACK = null;
    public static final MapColor GOLD = null;
    public static final MapColor DIAMOND = null;
    public static final MapColor LAPIS = null;
    public static final MapColor EMERALD = null;
    public static final MapColor OBSIDIAN = null;
    public static final MapColor NETHERRACK = null;

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
     * Returns all the possible named {@link MapColor}s available, this is
     * basically just all the static entries in {@link MapPalette} but in an
     * {@link ImmutableCollection<MapColor>}.
     *
     * @return All the named map colors
     */
    public static ImmutableCollection<MapColor> getAllNamed() {
        return factory.getAllNamed();
    }

    /**
     * Returns a {@link MapColor} from all the colors (including shades) based
     * on the palette index. This allows easy lookup of colors from a raw map.
     *
     * @param colorIndex The index of the color in the map palette
     * @return The object represented by that color
     */
    public static MapColor getByIndex(int colorIndex) {
        return factory.getByIndex(colorIndex);
    }

    /**
     * Gets a new {@link MapColor} with the specified shaded value from the
     * <b>base color</b> of the color provided.
     *
     * <p>If the value has already been created it will load a cached entry.
     * This is not based on the color itself but rather the unshaded version of
     * the color provided, this helps ensure consistency.</p>
     *
     * @param base The base color, not required to be an actual base color
     * @param shade The shade to apply
     * @return The shaded color
     */
    public static MapColor getShade(MapColor base, MapShade shade) {
        return factory.getShade(base, shade);
    }
}
