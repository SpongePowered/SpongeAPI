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
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.map.MapCanvas;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.util.ResettableBuilder;

/**
 * Represents a {@link MapColorType} in a given {@link MapShade} that may be
 * used when drawing a {@link MapCanvas}.
 */
public interface MapColor extends DataSerializable {

    /**
     * Creates a {@link Builder} for generating a new {@link MapColor}.
     *
     * @return The builder
     */
    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * Creates a {@link MapColor} that represents the provided
     * {@link MapColorType} with the {@link MapShades#BASE the default shading}.
     *
     * @param mapColorType The {@link MapColorType}
     * @return The {@link MapColor} that represents the provided type
     */
    static MapColor of(final MapColorType mapColorType) {
        return MapColor.builder().baseColor(mapColorType).build();
    }

    /**
     * Creates a {@link MapColor} that represents the provided
     * {@link MapColorType} with the given {@link MapShade}.
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
    MapColorType type();

    /**
     * Gets the {@link MapShade} that this {@link MapColor} was built from.
     *
     * @return The {@link MapShade}
     */
    MapShade shade();

    /**
     * Gets the {@link Color} that this {@link MapColor} represents.
     *
     * @return The {@link Color}
     */
    Color color();

    /**
     * Builds a {@link MapColor}
     */
    interface Builder extends ResettableBuilder<MapColor, Builder> {

        /**
         * Sets the {@link MapShade} of the supplied {@link #color()}.
         *
         * <p>If this method is not called, {@link MapShades#BASE} is used.</p>
         *
         * @param shade The {@link MapShade} to use
         * @return This builder, for chaining
         */
        Builder shade(MapShade shade);

        /**
         * Sets the {@link MapShade} to {@link MapShades#BASE}.
         *
         * @return This builder, for chaining
         */
        Builder base();

        /**
         * Sets the {@link MapShade} to {@link MapShades#DARK}.
         *
         * @return This builder, for chaining
         */
        Builder dark();

        /**
         * Sets the {@link MapShade} to {@link MapShades#DARKER}.
         *
         * @return This builder, for chaining
         */
        Builder darker();

        /**
         * Sets the {@link MapShade} to {@link MapShades#DARKEST}.
         *
         * @return This builder, for chaining
         */
        Builder darkest();

        /**
         * Sets the {@link MapColorType} that will form the basis of the built
         * {@link MapColor}.
         *
         * @param mapColor the MapColorType
         * @return This builder, for chaining
         */
        Builder baseColor(MapColorType mapColor);

        /**
         * Copies all data from the given {@link MapColor} and applies it to this
         * builder. Therefore, if {@link #build()} is called directly after, the
         * result of {@link java.util.Objects#equals(Object, Object)} between them will be {@code true}.
         * Any aspect of this builder could then be modified to produce similar but
         * not identical MapColors.
         *
         * @param mapColor {@link MapColor} to copy data from.
         * @return This builder, for chaining
         */
        Builder from(MapColor mapColor);

        /**
         * Attempts to reconstruct the builder with all of the data from
         * {@link MapColor#toContainer()}.
         *
         * @param container The container to translate
         * @return This builder, for chaining
         */
        Builder fromContainer(DataView container);

        /**
         * Creates a {@link MapColor} that represents the combination of this
         * {@link MapColorType} and {@link MapShade}.
         *
         * @return The {@link MapColor}
         * @throws IllegalStateException if no {@link MapColorType} was provided
         */
        MapColor build() throws IllegalStateException;
    }
}
