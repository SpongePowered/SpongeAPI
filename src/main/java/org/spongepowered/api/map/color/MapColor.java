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
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.util.annotation.CatalogedBy;

/**
 * An instance of MapColor represents the combination of a {@link MapColor.Base}
 * which holds the palette
 */
public interface MapColor extends DataSerializable {

    /**
     * Returns the corresponding {@link Color} for this {@link MapColor}.
     *
     * @return The RGB color of this map color
     */
    Color getColor();

    /**
     * Creates a shaded representation of this color's <b>base color</b>.
     *
     * @param newShading The shading to use on the new variant of this color
     * @return The new map color with the specified shading
     */
    MapColor shade(MapShade newShading);

    /**
     * Returns the shading of this color.
     *
     * @return The shade of this color
     */
    MapShade getShade();

    /**
     * Returns the {@link MapColor.Base} color that this MapColor is based on. The
     * same as creating a {@link MapShades#BASE} shaded instance.
     *
     * @return The {@link MapColor.Base} of this map color
     */
    MapColor.Base base();

    /**
     * Create a new instance of {@link MapColor} with this instance's base color
     * and the shade set to {@link MapShades#DARK}.
     *
     * @return A {@link MapShades#DARK} shaded version of this color
     */
    default MapColor dark() {
        return shade(MapShades.DARK);
    }

    /**
     * Create a new instance of {@link MapColor} with this instance's base color
     * and the shade set to {@link MapShades#DARKER}.
     *
     * @return A {@link MapShades#DARKER} shaded version of this color
     */
    default MapColor darker() {
        return shade(MapShades.DARKER);
    }

    /**
     * Create a new instance of {@link MapColor} with this instance's base color
     * and the shade set to {@link MapShades#DARKEST}.
     *
     * @return A {@link MapShades#DARKEST} shaded version of this color
     */
    default MapColor darkest() {
        return shade(MapShades.DARKEST);
    }

    /**
     * A MapColor.Base represents the singleton instances that refer to the non-shaded
     * palette available. These colors
     */
    @CatalogedBy(MapColors.class)
    interface Base extends MapColor, CatalogType {

        /**
         * A base color entry is always unshaded, so the shade is by definition is
         * {@link MapShades#BASE}
         *
         * @return {@link MapShades#BASE}
         */
        @Override
        default MapShade getShade() {
            return MapShades.BASE;
        }

        /**
         * A base color entry is always its own MapColor.Base
         */
        @Override
        default MapColor.Base base() {
            return this;
        }
    }

}
