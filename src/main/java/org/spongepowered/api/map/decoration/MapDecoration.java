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
package org.spongepowered.api.map.decoration;

import com.flowpowered.math.vector.Vector2i;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.map.MapCanvas;
import org.spongepowered.api.map.MapInfo;
import org.spongepowered.api.util.Direction;

/**
 * A {@code MapDecoration} represents a symbol that may be placed at a specific
 * point on a {@link MapInfo map}, which exists as a separate layer on top of a
 * {@link MapCanvas}. A common example of a Decoration is the player marker.
 *
 * <p>Unlike a {@link MapCanvas} which is a relatively static feature of a
 * {@link MapInfo}, the position and rotation of decorations can be updated
 * more easily.</p>
 *
 * <p>The co-ordinate system used when getting or setting a decoration's
 * location on a map is independent of any world a map may be based on.
 * Instead, valid co-ordinates range from {@link Byte#MIN_VALUE -128} to
 * {@link Byte#MAX_VALUE 127}. The bottom left corner of the map is given by the
 * co-ordinates (-128, -128).</p>
 */
public interface MapDecoration extends DataSerializable {

    /**
     * Creates a {@link Builder} for generating {@link MapDecoration}s.
     *
     * @return A {@link Builder}
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Creates a new {@link MapDecoration} given a
     * {@link MapDecorationType}, position and {@link Direction} which
     * represents the rotation of the decoration on the map.
     *
     * @param type The {@link MapDecorationType} symbol
     * @param x The x co-ordinate of this decoration
     * @param y The y co-ordinate of this decoration
     * @param rotation The {@link Direction} that represents the rotation of the
     *                 decoration
     * @return The {@link MapDecoration}
     */
    static MapDecoration of(final MapDecorationType type, final int x, final int y, final Direction rotation) {
        return builder().type(type).x(x).y(y).rotation(rotation).build();
    }

    /**
     * Gets the {@link MapDecorationType} this decoration is displaying
     *
     * @return The {@link MapDecorationType}
     */
    MapDecorationType getType();

    /**
     * Gets the position on a {@link MapInfo} that this decoration will be
     * placed.
     *
     * @return Vector2i Co-ordinate position in world
     */
    Vector2i getPosition();

    /**
     * Gets the x co-ordinate of this decoration
     *
     * @return The x co-ordinate
     */
    int getX();

    /**
     * Gets the y co-ordinate of this decoration
     *
     * @return The y co-ordinate
     */
    int getY();

    /**
     * Sets the position of where the MapDecoration is on Maps,
     * or where it would be if applied to a {@link org.spongepowered.api.map.MapInfo}
     * 0,0 is the center of the map
     * Ranges from {@value java.lang.Byte#MIN_VALUE}-{@value java.lang.Byte#MAX_VALUE}. AKA any valid byte value
     * @param position Vector2i world x and y cords
     */
    void setPosition(Vector2i position);

    /**
     * Sets the X position of where this MapDecoration is on a map
     * or where it will be when applied
     * Ranges from {@value java.lang.Byte#MIN_VALUE}-{@value java.lang.Byte#MAX_VALUE}. AKA any valid byte value
     * @param x world cordinate
     */
    void setX(int x);

    /**
     * Sets the X position of where this MapDecoration is on a map.
     * 0 is the center of the map.
     * Ranges from {@value java.lang.Byte#MIN_VALUE}-{@value java.lang.Byte#MAX_VALUE}. AKA any valid byte value
     * @param y pos
     */
    void setY(int y);

    /**
     * Sets rotation with a Direction. Must be a cardinal/ordinal/secondary ordinal
     * @param rot Direction, a, secondary ordinal
     */
    void setRotation(Direction rot);

    /**
     * Gets the direction the Map Decoration is pointing
     * @return Direction, a cardinal/ordinal/secondary
     */
    Direction getRotation();

    /**
     * A builder that creates {@link MapDecoration}
     */
    interface Builder extends DataBuilder<MapDecoration> {

        /**
         * Sets the {@link MapDecorationType} that the built
         * {@link MapDecoration} will display.
         *
         * @param type The {@link MapDecorationType}
         * @return This builder, for chaining
         */
        Builder type(MapDecorationType type);

        /**
         * Sets the X position of the MapDecoration
         * (for when it is applied to a {@link org.spongepowered.api.map.MapInfo})
         * @param x map coordinate where 0 is the centre of the map.
         * Ranges from {@value java.lang.Byte#MIN_VALUE}-{@value java.lang.Byte#MAX_VALUE}. AKA any valid byte value
         * @return This builder, for chaining
         */
        Builder x(int x) throws IllegalArgumentException;

        /**
         * Sets the Y position of the MapDecoration
         *
         * (for when it is applied to a {@link org.spongepowered.api.map.MapInfo})
         * @param y map coordinate where 0 is the centre of the map.
         * Ranges from {@value java.lang.Byte#MIN_VALUE}-{@value java.lang.Byte#MAX_VALUE}. AKA any valid byte value
         * @return This builder, for chaining
         */
        Builder y(int y) throws IllegalArgumentException;

        /**
         * Sets the orientation of the symbol when displayed on a {@link MapInfo}.
         *
         * <p>The supplied {@link Direction} can only be any of the cardinal or
         * sub-cardinal directions.</p>
         *
         * @param direction The {@link Direction} the
         * @return This builder, for chaining
         * @throws IllegalArgumentException if an invalid {@link Direction} is
         *      provided
         */
        Builder rotation(Direction direction) throws IllegalArgumentException;

        /**
         * Sets the position of the decoration. Valid co-ordinates are between
         * {@link Byte#MIN_VALUE -128} and {@link Byte#MAX_VALUE 127}, with
         * (-128, -128) being the bottom left corner of a map.
         *
         * @see MapDecoration for further descrption of the co-ordinate system
         *
         * @return This builder, for chaining
         * @throws IllegalArgumentException if a position outside of the map
         *      is specified.
         */
        Builder position(Vector2i position) throws IllegalArgumentException;

        /**
         * Creates a new {@link MapDecoration} based on the current builder
         * state.
         *
         * @return A {@link MapDecoration}
         * @throws IllegalStateException if a {@link MapDecorationType} has not
         *      been supplied
         */
        MapDecoration build() throws IllegalStateException;

    }

}
