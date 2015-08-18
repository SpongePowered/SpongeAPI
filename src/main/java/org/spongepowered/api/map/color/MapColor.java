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

import com.google.common.base.Optional;

public interface MapColor {

    /**
     * Returns the color value of this object, can be converted to an
     * instance of {@link java.awt.Color} by plugins easily.
     *
     * <p>Standard RGB packing, (red<<16) | (green << 8) | blue, where each of
     * the channels is masked off to fit in a byte before packing.</p>
     *
     * @return The RGB value of this color
     */
    int getRGB();

    /**
     * Returns the value of the entry in a map palette, this isn't the base
     * color index which needs to be modified before being set, this represents
     * the actual value that can be set in a map.
     *
     * @return The map color index
     */
    int getPaletteIndex();

    /**
     * Creates a shaded representation of this color's <b>base color</b> using
     * {@link MapPalette#getShade(MapColor, MapShade)} which will create a new
     * instance if needed or return a cached instance for previously created
     * shades.
     *
     * @param newShading The shading to use on the new variant of this color
     * @return The new map color with the specified shading
     */
    MapColor createShade(MapShade newShading);

    /**
     * Returns the shading of this color.
     *
     * @return The shade of this color
     */
    MapShade getShade();

    /**
     * Returns the name of this color, only the entries in {@link MapPalette}
     * have names.
     *
     * @return The name of this color, {@link Optional#absent()} otherwise
     */
    Optional<String> getName();
}
