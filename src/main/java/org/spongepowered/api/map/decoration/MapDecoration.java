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
import org.spongepowered.api.util.Direction;

/**
 * A MapDecoration that represents a Decoration on a map,
 * e.g player marker, monument marker etc.
 * All coordinates are relative to the map, and centred at 0,0
 * Valid coordinates range from {@value java.lang.Byte#MIN_VALUE}-{@value java.lang.Byte#MAX_VALUE}. AKA any valid byte value
 */
public interface MapDecoration extends DataSerializable {

    static Builder builder() {return Sponge.getRegistry().createBuilder(Builder.class);}

    static MapDecoration of(MapDecorationType type, int x, int y, Direction rotation) {return builder().type(type).x(x).y(y).rotation(rotation).build();}

    /**
     * Gets the {@link MapDecorationType} of this MapDecoration
     * @return MapDecorationType The type of the MapDecoration
     */
    MapDecorationType getType();

    /**
     * Gets the position of this MapDecoration, where it is right
     * now, or where it would be if applied to a {@link org.spongepowered.api.map.MapInfo}.
     * 0,0 is the centre of a map.
     * Ranges from {@value java.lang.Byte#MIN_VALUE}-{@value java.lang.Byte#MAX_VALUE}. AKA any valid byte value
     * @return Vector2i Co-ordinate position in world
     */
    Vector2i getPosition();

    /**
     * Gets the X position on a map, or where it will be when applied
     * Ranges from {@value java.lang.Byte#MIN_VALUE}-{@value java.lang.Byte#MAX_VALUE}. AKA any valid byte value
     * @return int Y world coordinate
     */
    int getX();

    /**
     * Gets the Y position on a map. 0 is the center of the map.
     * Ranges from {@value java.lang.Byte#MIN_VALUE}-{@value java.lang.Byte#MAX_VALUE}. AKA any valid byte value
     * @return int Y world coordinate
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

    interface Builder extends DataBuilder<MapDecoration> {
        /**
         * Sets the MapDecorationType
         * @param type MapDecoration to set
         * @return this Builder, for chaining
         */
        Builder type(MapDecorationType type);

        /**
         * Sets the X position of the MapDecoration
         * (for when it is applied to a {@link org.spongepowered.api.map.MapInfo})
         * @param x map coordinate where 0 is the centre of the map.
         * Ranges from {@value java.lang.Byte#MIN_VALUE}-{@value java.lang.Byte#MAX_VALUE}. AKA any valid byte value
         * @return this Builder, for chaining
         */
        Builder x(int x) throws IllegalArgumentException;

        /**
         * Sets the Y position of the MapDecoration
         *
         * (for when it is applied to a {@link org.spongepowered.api.map.MapInfo})
         * @param y map coordinate where 0 is the centre of the map.
         * Ranges from {@value java.lang.Byte#MIN_VALUE}-{@value java.lang.Byte#MAX_VALUE}. AKA any valid byte value
         * @return this Builder, for chaining
         */
        Builder y(int y) throws IllegalArgumentException;

        /**
         * Sets the rotation in degrees for this builder
         * (for when it is applied to a {@link org.spongepowered.api.map.MapInfo})
         * @param rot Direction, any cardinal/ordinal/secondary ordinal direction. (Not up/down)
         * @return this Builder, for chaining
         */
        Builder rotation(Direction rot) throws IllegalArgumentException;

        /**
         * Sets the X and Y position of the MapDecoration
         * (for when it is applied to a {@link org.spongepowered.api.map.MapInfo})
         * @param position Vector2i, X and Y position, where 0,0 is
         *                 the center of the map.
         * Map coordinates range from {@value java.lang.Byte#MIN_VALUE}-{@value java.lang.Byte#MAX_VALUE}. AKA any valid byte value
         * @return this Builder, for chaining
         */
        Builder position(Vector2i position) throws IllegalArgumentException;

        /**
         * Builds an instance of MapDecoration.
         *
         * @return A new instance of an MapDecoration
         * @throws IllegalStateException If the MapDecoration is not complete
         */
        MapDecoration build() throws IllegalStateException;
    }
}
