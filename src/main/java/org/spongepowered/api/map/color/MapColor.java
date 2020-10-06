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
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.map.MapCanvas;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.util.ResettableBuilder;

/**
 * Represents a color that may be used when drawing a {@link MapCanvas}.
 */
public interface MapColor extends DataSerializable {

    /**
     * Creates a {@link Builder} for generating a new {@link MapColor}.
     *
     * @return The builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Creates a {@link MapColor} that represents the provided
     * {@link MapColorType} without any shading adjustments.
     *
     * @param mapColorType The {@link MapColorType}
     * @return The {@link MapColor} that represents the provided type
     */
    static MapColor of(final MapColorType mapColorType) {
        return MapColor.builder().baseColor(mapColorType).build();
    }

    /**
     * Creates a {@link MapColor} that represents the provided
     * {@link MapColorType} with the given shade.
     *
     * @param mapColorType The {@link MapColorType}
     * @param mapShade The {@link MapShade}
     * @return The {@link MapColor} that represents the provided type
     */
    static MapColor of(final MapColorType mapColorType, final MapShade mapShade) {
        return MapColor.builder().baseColor(mapColorType).shade(mapShade).build();
    }

    /**
     * Gets the {@link MapColorType} that this {@link MapColor} was built from.
     *
     * @return The {@link MapColorType}
     */
    MapColorType getType();

    /**
     * Gets the {@link MapShade} that this {@link MapColor} was built from.
     *
     * @return The {@link MapShade}
     */
    MapShade getShade();

    /**
     * Gets the {@link Color} that this {@code MapColor} represents.
     *
     * @return The {@link Color}
     */
    Color getColor();

    /**
     * Builds a {@link MapColor}
     */
    interface Builder extends ResettableBuilder<MapColor, Builder> {

        /**
         * Sets the shade to the given shade
         * @param shade The shade to set this builder to
         * @return Builder, for chaining
         */
        Builder shade(MapShade shade);

        /**
         * Sets the shade to the lightest shade
         * Shorthand for calling {@link #shade(MapShade)} with {@link MapShades#DARKER}
         * @return Builder, for chaining
         */
        Builder darker();

        /**
         * Sets the shade to the light shade
         * Shorthand for calling {@link #shade(MapShade)} with {@link MapShades#DARK}
         * @return Builder, for chaining
         */
        Builder dark();

        /**
         * Sets the shade to the base shade
         * Shorthand for calling {@link #shade(MapShade)} with {@link MapShades#BASE}
         * The color given is the same as {@link MapColorType#getColor()}
         * This is the default shade.
         * @return Builder, for chaining
         */
        Builder base();

        /**
         * Sets the shade to the dark shade
         * Shorthand for calling {@link #shade(MapShade)} with {@link MapShades#DARKEST}
         * @return Builder, for chaining
         */
        Builder darkest();

        /**
         * Sets the base color to the color given
         * @return Builder, for chaining
         */
        Builder baseColor(MapColorType mapColor);

        /**
         * Attempts to reconstruct the builder with all of the data from
         * {@link MapColor#toContainer()}.
         *
         * @param container The container to translate
         * @return This builder, for chaining
         */
        Builder fromContainer(DataView container);

        /**
         * Builds an instance of an MapColor.
         *
         * @return A new instance of an MapColor
         * @throws IllegalStateException If the MapColor is not complete
         */
        MapColor build() throws IllegalStateException;
    }
}
