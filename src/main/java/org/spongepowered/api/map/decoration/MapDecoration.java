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
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.hanging.ItemFrame;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.map.MapCanvas;
import org.spongepowered.api.map.decoration.orientation.MapDecorationOrientation;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.ResettableBuilder;

/**
 * A MapDecoration that represents a Decoration on a map,
 * e.g player marker, monument marker etc.
 * All coordinates are relative to the map, and centred at 0,0
 * Valid coordinates range from {@value java.lang.Byte#MIN_VALUE}-{@value java.lang.Byte#MAX_VALUE}. AKA any valid byte value
 */
public interface MapDecoration extends DataSerializable {

    static Builder builder() {return Sponge.getRegistry().createBuilder(Builder.class);}

    static MapDecoration of(MapDecorationType type, Vector2i position, MapDecorationOrientation rotation) {return builder().type(type).position(position).rotation(rotation).build();}

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
     * Sets the position of where the MapDecoration is on Maps,
     * or where it would be if applied to a {@link org.spongepowered.api.map.MapInfo}
     * 0,0 is the center of the map
     * Ranges from {@value java.lang.Byte#MIN_VALUE}-{@value java.lang.Byte#MAX_VALUE}. AKA any valid byte value
     * @param position Vector2i world x and y cords
     */
    void setPosition(Vector2i position);

    /**
     * Sets rotation with a {@link MapDecorationOrientation}
     * @param rot MapDecorationOrientation
     */
    void setRotation(MapDecorationOrientation rot);

    /**
     * Gets the {@link MapDecorationOrientation} the Map Decoration is pointing in
     * @return MapDecorationOrientation
     */
    MapDecorationOrientation getRotation();

    /**
     * Gets whether this {@link MapDecoration} is persistent
     * <p>A {@link MapDecoration} being persistent means it cannot be changed
     * apart from by a plugin.</p>
     *
     * <p>Examples of persistent MapDecorations:</p>
     * <ul>
     * <p>  - Plugin added MapDecorations</p>
     * <p>  - Structures located on the map, i.e Guardian Temple</p>
     * </ul>
     * <p>Examples of non-persistent MapDecorations:</p>
     * <ul>
     * <p>  - MapDecorations marking a {@link Player}'s current location,
     *          (if {@link Keys#MAP_TRACKS_PLAYERS} is true and if they are in range).</p>
     * <p>  - MapDecorations marking a {@link ItemFrame}'s position.</p>
     * </ul>
     *
     * <p>This affects whether this will be serialized in {@link MapCanvas#toContainer()}.
     * Go there if you want more details</p>
     *
     * <p>This does <b>not</b> affect {@link #toContainer()}, which will serialize fine.</p>
     *
     * @return true if this {@link MapDecoration} is persistent
     */
    boolean isPersistent();

    interface Builder extends ResettableBuilder<MapDecoration, Builder> {
        /**
         * Sets the MapDecorationType
         * @param type MapDecoration to set
         * @return this Builder, for chaining
         */
        Builder type(MapDecorationType type);

        /**
         * Sets the rotation for this builder
         * (for when it is applied to a {@link org.spongepowered.api.map.MapInfo})
         * @param rot a {@link MapDecorationOrientation}
         * @return this Builder, for chaining
         */
        Builder rotation(MapDecorationOrientation rot) throws IllegalArgumentException;

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
         * Attempts to reconstruct the builder with all of the data from
         * {@link MapDecoration#toContainer()}.
         *
         * <p>If the given DataView was from a persistent
         * {@link MapDecoration}, i.e,
         * {@link MapDecoration#isPersistent()} returned true,
         * it will create a custom MapDecoration that mimics it,
         * which will be persistent</p>
         *
         * @param container The container to translate
         * @return This builder, for chaining
         */
        Builder fromContainer(DataView container);

        /**
         * Builds an instance of MapDecoration.
         *
         * @return A new instance of an MapDecoration
         * @throws IllegalStateException If the MapDecoration is not complete
         */
        MapDecoration build() throws IllegalStateException;
    }
}
