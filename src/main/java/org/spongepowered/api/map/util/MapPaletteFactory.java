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
import org.spongepowered.api.map.color.MapPalette;
import org.spongepowered.api.map.color.MapColor;
import org.spongepowered.api.map.color.MapShade;

/**
 * Represents the required implementation for the static methods in
 * {@link MapPalette}.
 */
public interface MapPaletteFactory {

    /**
     * Returns all the possible {@link MapColor}s available, including the
     * shaded colors.
     *
     * @return All the map colors including shades
     */
    ImmutableCollection<MapColor> getAll();

    /**
     * Returns all the possible named {@link MapColor}s available, this is
     * basically just all the static entries in {@link MapPalette} but in an
     * {@link ImmutableCollection<MapColor>}.
     *
     * @return All the named map colors
     */
    ImmutableCollection<MapColor> getAllNamed();

    /**
     * Returns a {@link MapColor} from all the colors (including shades) based
     * on the palette index. This allows easy lookup of colors from a raw map.
     *
     * @param colorIndex The index of the color in the map palette
     * @return The object represented by that color
     */
    MapColor getByIndex(int colorIndex);

    /**
     * Takes a palette color and a shade to create a new {@link MapColor} with the
     * shaded color value. If the value has already been created it will load a
     * cached entry. This is not based on the color itself but rather the unshaded
     * version of the color provided, this helps ensure consistency.
     *
     * @param base The base color, not required to be an actual base color
     * @param shade The shade to apply
     * @return The shaded color
     */
    MapColor getShade(MapColor base, MapShade shade);
}
