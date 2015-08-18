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
import com.google.common.collect.ImmutableList;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.map.cursor.MapCursor;
import org.spongepowered.api.map.cursor.MapCursorHandle;
import org.spongepowered.api.util.Identifiable;

import java.util.Collection;
import java.util.List;

/**
 * A representation of a specific map and all of it's properties.
 */
public interface MapView extends Identifiable {

    /**
     * Sets the {@link MapCursor} used for players on the map when
     * {@link #isUsingVanillaCursors()} is true.
     *
     * @param cursor The new cursor for player positions
     */
    void setPlayerCursor(MapCursor cursor);

    /**
     * Sets the {@link MapCursor} used for item frame locations on the map when
     * {@link #isUsingVanillaCursors()} is true.
     *
     * @param cursor The new cursor for item frame positions.
     */
    void setItemFrameCursor(MapCursor cursor);

    /**
     * Returns if vanilla's default handling of cursors with item frames and
     * players should be used, if disabled all vanilla cursors are removed and
     * plugins must manually update cursor positions.
     *
     * @return True when using vanilla handling, false otherwise
     */
    boolean isUsingVanillaCursors();

    /**
     * Sets if vanilla's default handling should be used, see {@link #isUsingVanillaCursors()}
     * for a description of what the default handling does. When this is set to true, plugin
     * cursors are still functional, they just coexist with vanilla's default cursors too.
     *
     * @param usingVanillaCursors True to enable vanilla cursors, false to disable
     */
    void setUsingVanillaCursors(boolean usingVanillaCursors);

    /**
     * Returns all the currently active cursors as {@link MapCursorHandle}s,
     * including the ones used by vanilla. Removing a cursor handle from the
     * collection will handle removing the cursor from the map as well.
     *
     * @return All the cursor handles
     */
    Collection<MapCursorHandle> getAllCursors();

    /**
     * Adds a new cursor to the map of the specified type, the position is pixel
     * relative and refers to the center position of the cursor.
     *
     * @param type The type of cursor to add
     * @param position The map pixel relative center position of the cursor
     * @return A handle to the cursor that can be used for updating, removal and
     *         changing the type of cursor
     */
    MapCursorHandle addCursor(MapCursor type, Vector2i position);

    /**
     * Sends a forced update of the map to a player. This will send only the
     * region of the canvas between min x,y and max x,y to the player. Allowing
     * custom trickle loading, or forced immediate updating of the map.
     *
     * @param player The player to send the update to
     * @param min The upper left corner of the region to send
     * @param max The bottom right corner of the region to send
     */
    void sendUpdate(Player player, Vector2i min, Vector2i max);

    /**
     * Sends a forced update of the map to multiple players. This will send only the
     * region of the canvas between min x,y and max x,y to the players. Allowing
     * custom trickle loading, or forced immediate updating of the map.
     *
     * @param players The players to send the updates to
     * @param min The upper left corner of the region to send
     * @param max The bottom right corner of the region to send
     */
    void sendUpdate(Collection<Player> players, Vector2i min, Vector2i max);


    /**
     * Returns if the vanilla behavior for map updates (slowly updating a few
     * rows) at a time is being used.
     *
     * @return True if vanilla behavior is being used, false otherwise
     */
    boolean isDoingAutomaticUpdates();

    /**
     * Sets if vanilla behavior for map updates (slowing updating a few rows
     * at a time) is being used. The only way a map will update if set to false
     * is if plugins call on of the {@link #sendUpdate} methods manually, which
     * could be useful for maps that should constantly update.
     *
     * @param doesAutomaticUpdates True if vanilla behavior should be used,
     *        false otherwise
     */
    void setDoesAutomaticUpdates(boolean doesAutomaticUpdates);

    /**
     * Returns if before using any {@link MapRenderer}s the {@link MapCanvas} should
     * have the vanilla map copied into it so plugins can do overlay rendering on maps
     * without implementing vanilla map behavior themselves.
     *
     * @return True if vanilla rendering is used as a base, false otherwise
     */
    boolean isUsingVanillaRendering();

    /**
     * Sets if vanilla's map rendering should be added to the {@link MapCanvas} before
     * plugin {@link MapRenderer}s are run to allow overlaying.
     *
     * @param usesVanillaRendering True to enable vanilla rendering as a base, false
     *        otherwise
     */
    void setUsingVanillaRendering(boolean usesVanillaRendering);

    /**
     * Adds a renderer to this map as the top layer.
     *
     * @param renderer The renderer to add
     */
    void addRenderer(MapRenderer renderer);

    /**
     * Inserts a renderer in the map at the specific index, shifting existing
     * renderers around it.
     *
     * @param index The index to insert the renderer at
     * @param renderer The renderer to insert
     */
    void insertRenderer(int index, MapRenderer renderer);

    /**
     * Removes the specified renderer from the rendering list.
     *
     * @param renderer The renderer to remove
     * @return True if the renderer was successful to be removed, false
     *         otherwise
     */
    boolean removeRenderer(MapRenderer renderer);

    /**
     * Removes the {@link MapRenderer} at the specified index from the
     * renderers on this map
     *
     * @param index The index of the renderer to remove
     * @return True if the removal was successful, false otherwise
     */
    boolean removeRenderer(int index);

    /**
     * Removes all renderers from this map.
     */
    void clearRenderers();

    /**
     * Returns a {@link List} of all the {@link MapRenderer}s stored on this
     * map. The ordering is the layering of rendering with 0 being the bottom
     * most layer rendered first, and the {@link List#size()}-1 entry being the
     * latest rendered layer.
     *
     * @return An unmodifiable ordered list of all renderers
     */
    ImmutableList<MapRenderer> getAllRenderers();

    /**
     * Returns an {@link ImmutableList} of all the {@link Player}s viewing this
     * map currently.
     *
     * @return The list of players viewing the map
     */
    ImmutableList<Player> getViewers();
}
