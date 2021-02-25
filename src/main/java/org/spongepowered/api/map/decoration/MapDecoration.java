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

import net.kyori.adventure.text.TextComponent;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.entity.hanging.ItemFrame;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.map.MapCanvas;
import org.spongepowered.api.map.MapInfo;
import org.spongepowered.api.map.decoration.orientation.MapDecorationOrientation;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.math.vector.Vector2i;

import java.util.function.Supplier;

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
        return Sponge.getGame().getBuilderProvider().provide(Builder.class);
    }

    /**
     * Creates a new {@link MapDecoration} given a
     * {@link MapDecorationType}, position and {@link Direction} which
     * represents the rotation of the decoration on the map.
     *
     * @param type The {@link MapDecorationType} symbol
     * @param x The x co-ordinate of this decoration
     * @param y The y co-ordinate of this decoration
     * @param rotation The {@link MapDecorationOrientation} that represents the rotation of the
     *                 decoration
     * @return The {@link MapDecoration}
     */
    static MapDecoration of(final MapDecorationType type, final int x, final int y, final MapDecorationOrientation rotation) {
        return builder().type(type).position(Vector2i.from(x, y)).rotation(rotation).build();
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
     * Sets the position of where the MapDecoration is on Maps,
     * or where it would be if applied to a {@link MapInfo}
     * 0,0 is the center of the map
     * Ranges from {@value Byte#MIN_VALUE}-{@value Byte#MAX_VALUE}. AKA any valid byte value
     * @param position Vector2i world x and y cords
     */
    void setPosition(Vector2i position);

    /**
     * Sets rotation with a {@link MapDecorationOrientation}
     * @param rot MapDecorationOrientation
     */
    void setRotation(MapDecorationOrientation rot);

    default void setRotation(Supplier<MapDecorationOrientation> rotSupplier) {
        this.setRotation(rotSupplier.get());
    }

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

    /**
     * A builder that creates {@link MapDecoration}
     */
    interface Builder extends ResettableBuilder<MapDecoration, Builder> {

        /**
         * Sets the {@link MapDecorationType} that the built
         * {@link MapDecoration} will display.
         *
         * @param type The {@link MapDecorationType}
         * @return This builder, for chaining
         */
        Builder type(MapDecorationType type);

        default Builder type(Supplier<MapDecorationType> type) {
            return this.type(type.get());
        }

        /**
         * Sets the orientation of the symbol when displayed on a {@link MapInfo}.
         *
         * @param rot The {@link MapDecorationOrientation} the
         * @return This builder, for chaining
         */
        Builder rotation(MapDecorationOrientation rot);

        default Builder rotation(Supplier<MapDecorationOrientation> rotSupplier) {
            return this.rotation(rotSupplier.get());
        }

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

        Builder customName(TextComponent customName);

        Builder from(MapDecoration mapDecoration);

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
