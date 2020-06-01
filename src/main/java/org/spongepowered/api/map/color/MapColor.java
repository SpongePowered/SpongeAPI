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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.map.MapCanvas;
import org.spongepowered.api.util.Color;

/**
 * A MapColor that represents a color that can be used to
 * paint on a {@link MapCanvas}
 */
public interface MapColor extends DataSerializable {

    /**
     * Creates a new {@link Builder} to build an {@link MapColor}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    static MapColor of(MapColorType mapColorType) {
        return builder().baseColor(mapColorType).build();
    }

    /**
     * Gets the underlying {@link MapColorType} of this Color
     * @return MapColorType type of this color
     */
    MapColorType getType();

    /**
     * Gets an Sponge {@link Color}.
     * Can be converted to RGB
     * @return Color color
     */
    Color getColor();

    interface Builder extends DataBuilder<MapColor> {
        /**
         * Sets the shade to the default shade
         * @return Builder, for chaining
         */
        Builder base();

        /**
         * Sets the shade to the dark shade
         * @return Builder, for chaining
         */
        Builder dark();

        /**
         * Sets the shade to the darker shade
         * @return Builder, for chaining
         */
        Builder darker();

        /**
         * Sets the shade to the darkest shade
         * @return Builder, for chaining
         */
        Builder darkest();

        /**
         * Sets the base color to the color given
         * @return Builder, for chaining
         */
        Builder baseColor(MapColorType mapColor);

        /**
         * Builds an instance of an MapColor.
         *
         * @return A new instance of an MapColor
         * @throws IllegalStateException If the MapColor is not complete
         */
        MapColor build() throws IllegalStateException;
    }
}
