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
package org.spongepowered.api.map;

import com.flowpowered.math.vector.Vector2i;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.map.color.MapColor;
import org.spongepowered.api.map.color.MapColorTypes;
import org.spongepowered.api.map.decoration.MapDecoration;
import org.spongepowered.api.util.ResettableBuilder;

import java.awt.Image;

/**
 * A {@code MapCanvas} represents the image that is drawn on a
 * {@link ItemTypes#FILLED_MAP}.
 *
 * <p>A canvas in vanilla Minecraft is 128x128 pixels.</p>
 */
public interface MapCanvas extends DataSerializable {

    /**
     * Creates a builder for creating a new {@link MapCanvas}.
     *
     * @return A {@link Builder} to generate a new canvas.
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Creates a {@link MapCanvas} where all pixels are set to
     * {@link MapColorTypes#AIR}.
     *
     * @return A blank canvas
     */
    static MapCanvas blank() {
        return MapCanvas.builder().build();
    }

    /**
     * Gets the {@link MapColor} at the given location.
     *
     * @param x The x location
     * @param y The y location
     * @return The {@link MapColor} at the location
     * @throws IllegalArgumentException if either of the requested
     *      co-ordinates are out of bounds.
     */
    MapColor getColor(int x, int y) throws IllegalArgumentException;

    /**
     * Generates an {@link Image} from this {@link MapCanvas}.
     *
     * @return An {@link Image}
     */
    Image toImage();

    /**
     * Generates an {@link Image} from this {@link MapCanvas}, where any pixels
     * that represent {@link MapColorTypes#AIR} will be replaced with the
     * supplied {@link java.awt.Color}.
     *
     * @param color the {@link java.awt.Color} used in place of
     *      {@link MapColorTypes#AIR}
     * @return An {@link Image}
     */
    Image toImage(java.awt.Color color);


    /**
     * Creates a {@link Builder} populated with the state of this {@link MapCanvas}.
     *
     * <p>Changes to the returned builder will not affect this canvas.</p>
     *
     * @return A {@link Builder}
     */
    Builder toBuilder();

    /**
     * A builder that creates a {@link MapCanvas}.
     */
    interface Builder extends ResettableBuilder<MapCanvas, Builder> {

        /**
         * Sets the entire canvas to the supplied {@link MapColor}.
         *
         * @param color The {@link MapColor}
         * @return this builder, for chaining
         */
        Builder paintAll(MapColor color);

        /**
         * Sets the rectangle bounded by the given co-ordinates to the supplied
         * {@link MapColor}.
         *
         * <p>The provided co-ordinates are <strong>included</strong> in the
         * region.</p>
         *
         * @param startX Bottom left corner of region to paint
         * @param startY Bottom left corner of region to paint
         * @param endX Top right corner of region to paint
         * @param endY Top right corner of region to paint
         * @param mapColor The {@link MapColor} to paint the given region
         * @return this builder, for chaining
         */
        Builder paint(int startX, int startY, int endX, int endY, MapColor mapColor);

        /**
         * Sets the rectangle bounded by the given co-ordinates to the supplied
         * {@link MapColor}.
         *
         * <p>The provided co-ordinates are <strong>included</strong> in the
         * region.</p>
         *
         * @param start A {@link Vector2i} that represents one corner of the
         *  rectangle.
         * @param end A {@link Vector2i} that represents the opposite corner of
         *  the rectangle.
         * @param mapColor The {@link MapColor} to paint this region
         * @return this builder, for chaining
         */
        default Builder paint(final Vector2i start, final Vector2i end, final MapColor mapColor) {
            return this.paint(
                    Math.min(start.getX(), end.getX()),
                    Math.max(start.getX(), end.getX()),
                    Math.min(start.getY(), end.getY()),
                    Math.min(start.getY(), end.getY()),
                    mapColor);
        }

        /**
         * Sets up this builder such that calling {@link #build()} will
         * return a copy of the supplied {@link MapCanvas}.
         *
         * @param canvas {@link MapCanvas} to set the state of this builder to
         * @return this builder, for chaining
         */
        Builder from(MapCanvas canvas);

        /**
         * Fills a canvas from an image
         * This given image will be copied and thus changes to the
         * image after this is called will not be reflected.
         * @param image to take from
         * @return This Builder, for chaining
         * @throws IllegalArgumentException if width/height is wrong or not known yet
         * @throws IllegalArgumentException if color found is not in the palette {@link MapColorTypes}
         */
        Builder fromImage(Image image) throws IllegalArgumentException;

        /**
         * Attempts to reconstruct the builder with all of the data from
         * {@link MapCanvas#toContainer()}.
         *
         * @param container The container to translate
         * @return This builder, for chaining
         */
        Builder fromContainer(DataView container);

        /**
         * Creates a {@link MapCanvas} from the state of this builder.
         *
         * @return The {@link MapCanvas}
         */
        MapCanvas build();
    }
}
