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
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.map.color.MapShade;
import org.spongepowered.api.map.cursor.MapCursorType;
import org.spongepowered.api.map.cursor.MapCursorTypes;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.util.ResettableBuilder;

/**
 * A representation of a specific map's properties.
 */
public interface MapSettings extends DataSerializable {

    /**
     * Gets a new {@link Builder} instance for MapSettings.
     * 
     * @return A new builder instance
     */
    static MapSettings.Builder builder() {
        return Sponge.getGame().getRegistry().createBuilder(Builder.class);
    }

    /**
     * Returns if vanilla Minecraft's default handling of cursors with item frames and
     * players should be used, if disabled all vanilla cursors are removed and
     * plugins must manually update cursor positions.
     *
     * @return True when using vanilla Minecraft handling, false otherwise
     */
    boolean usesDefaultCursors();

    /**
     * Sets if vanilla's default handling should be used, see {@link #usesDefaultCursors()}
     * for a description of what the default handling does. When this is set to true, plugin
     * cursors are still functional, they just coexist with vanilla Minecraft's default cursors too.
     *
     * @param useDefaultCursors True to enable vanilla Minecraft default cursors, false to disable
     */
    void setUsesDefaultCursors(boolean useDefaultCursors);

    /**
     * Sets the {@link MapCursorType} used for players on the map when
     * {@link #usesDefaultCursors()} is true. By default this is a
     * {@link MapCursorTypes#WHITE_POINTER}.
     *
     * @param cursorType The new cursor for player positions
     */
    void setPlayerCursor(MapCursorType cursorType);

    /**
     * Sets the {@link MapCursorType} used for item frame locations on the map when
     * {@link #usesDefaultCursors()} is true. By default this is a
     * {@link MapCursorTypes#GREEN_POINTER}.
     *
     * @param cursorType The new cursor for item frame positions
     */
    void setItemFrameCursor(MapCursorType cursorType);

    /**
     * Sets the {@link MapCursorType} used for player locations on the edge
     * when players go out of bounds when  {@link #usesDefaultCursors()} is
     * true. By default this is a {@link MapCursorTypes#WHITE_CIRCLE}.
     *
     * @param cursorType The new cursor for edge positions
     */
    void setEdgeCursor(MapCursorType cursorType);

    /**
     * Gets the current scaling ratio of the map.
     *
     * @return The scaling ratio for the map
     */
    MapScale getScale();

    /**
     * Sets the current scaling ratio of the map.
     *
     * @param scale The new scaling ratio for the map
     */
    void setScale(MapScale scale);

    /**
     * Returns if the vanilla behavior for map updates (slowly updating a few
     * rows) at a time is being used.
     *
     * @return True if vanilla behavior is being used, false otherwise
     */
    boolean doesAutomaticUpdates();

    /**
     * Sets if vanilla behavior for map updates (slowing updating a few rows
     * at a time) is being used. The only way a map will update if set to false
     * is if plugins call on of the {@link MapView#sendUpdate} methods manually, which
     * could be useful for maps that should constantly update.
     *
     * @param doAutomaticUpdates True if vanilla behavior should be used,
     *        false otherwise
     */
    void setDoesAutomaticUpdates(boolean doAutomaticUpdates);

    /**
     * Returns if before using any {@link MapRenderer}s the {@link MapView} should
     * have the vanilla map copied into it so plugins can do overlay rendering on maps
     * without implementing vanilla map behavior themselves.
     *
     * @return True if vanilla rendering is used as a base, false otherwise
     */
    boolean usesDefaultRenderer();

    /**
     * Sets if vanilla's map rendering should be added to the {@link MapView} before
     * plugin {@link MapRenderer}s are run to allow overlaying.
     *
     * @param useDefaultRenderer True to enable vanilla rendering as a base, false
     *        otherwise
     */
    void setUsesDefaultRenderer(boolean useDefaultRenderer);

    /**
     * Sets the world x and z coordinates that the vanilla map renderer uses
     * as its center position.
     *
     * <p>Note: The vector's X and Y components represent the X and Z
     * center components respectively.</p>
     *
     * @param center The center position
     */
    default void setCenter(Vector2i center) {
        setCenter(center.getX(), center.getY());
    }

    /**
     * Sets the world x and z coordinates that the vanilla map renderer uses
     * as its center position.
     *
     * @param centerX X coordinate of the center
     * @param centerZ Z coordinate of the center
     */
    void setCenter(int centerX, int centerZ);

    /**
     * Gets the world x and z coordinates that the vanilla map renderer uses
     * as its center position.
     *
     * <p>Note: The vector's X and Y components represent the X and Z
     * center components respectively.</p>
     *
     * @return The center position
     */
    Vector2i getCenter();

    interface Builder extends ResettableBuilder<MapSettings, Builder> {

        /**
         * Fills this {@link MapSettings} for creating {@link MapView}s or
         * {@link MapSettings}s, the builder is then seeded with the values
         * from the given {@link MapSettings} object.
         *
         * @param settings The seed settings
         * @return A newly seeded builder for chaining
         */
        Builder fill(MapSettings settings);

        /**
         * Sets the world x and z coordinates that the vanilla map renderer uses
         * as its center position.
         *
         * <p>Note: The vector's X and Y components represent the X and Z
         * center components respectively.</p>
         *
         * @param center The center position
         * @return The builder for chaining
         */
        default Builder center(Vector2i center) {
            return center(center.getX(), center.getY());
        }

        /**
         * Sets the world x and z coordinates that the vanilla map renderer uses
         * as its center position.
         *
         * @param centerX X coordinate of the center
         * @param centerZ Z coordinate of the center
         * @return The builder for chaining
         */
        Builder center(int centerX, int centerZ);

        /**
         * Sets if vanilla's default handling should be used, see {@link #usesDefaultCursors()}
         * for a description of what the default handling does. When this is set to true, plugin
         * cursors are still functional, they just coexist with vanilla Minecraft's default cursors too.
         *
         * @param useDefaultCursors True to enable vanilla Minecraft default cursors, false to disable
         * @return The builder for chaining
         */
        Builder usesDefaultCursors(boolean useDefaultCursors);

        /**
         * Sets the {@link MapCursorType} used for players on the map when
         * {@link #usesDefaultCursors()} is true. By default this is a
         * {@link MapCursorTypes#WHITE_POINTER}.
         *
         * @param cursorType The new cursor for player positions
         * @return The builder for chaining
         */
        Builder playerCursor(MapCursorType cursorType);

        /**
         * Sets the {@link MapCursorType} used for item frame locations on the map when
         * {@link #usesDefaultCursors()} is true. By default this is a
         * {@link MapCursorTypes#GREEN_POINTER}.
         *
         * @param cursorType The new cursor for item frame positions
         * @return The builder for chaining
         */
        Builder itemFrameCursor(MapCursorType cursorType);

        /**
         * Sets the {@link MapCursorType} used for player locations on the edge
         * when players go out of bounds when  {@link #usesDefaultCursors()} is
         * true. By default this is a {@link MapCursorTypes#WHITE_CIRCLE}.
         *
         * @param cursorType The new cursor for edge positions
         * @return The builder for chaining
         */
        Builder edgeCursor(MapCursorType cursorType);

        /**
         * Sets the scaling ratio for the map.
         *
         * @param scale The scaling ratio for the map
         * @return The builder for chaining
         */
        Builder scale(MapShade scale);

        /**
         * Sets if vanilla behavior for map updates (slowing updating a few rows
         * at a time) is being used. The only way a map will update if set to false
         * is if plugins call on of the {@link MapView#sendUpdate} methods manually, which
         * could be useful for maps that should constantly update.
         *
         * @param doAutomaticUpdates True if vanilla behavior should be used,
         *        false otherwise
         * @return The builder for chaining
         */
        Builder doesAutomaticUpdates(boolean doAutomaticUpdates);

        /**
         * Sets if vanilla's map rendering should be added to the {@link MapView} before
         * plugin {@link MapRenderer}s are run to allow overlaying.
         *
         * @param useDefaultRenderer True to enable vanilla rendering as a base, false
         *        otherwise
         * @return The builder for chaining
         */
        Builder usesDefaultRenderer(boolean useDefaultRenderer);

        /**
         * Builds the {@link MapSettings} which can be used to create
         * a {@link MapView} in {@link MapViewStorage#createMap(MapSettings)}.
         *
         * @return The settings
         */
        MapSettings build();
    }
    
}
