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
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.map.color.MapColor;
import org.spongepowered.api.map.color.MapColors;
import org.spongepowered.api.map.cursor.MapCursor;
import org.spongepowered.api.map.cursor.MapCursorType;
import org.spongepowered.api.map.font.MapFont;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.Color;

import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.List;

/**
 * A representation of the map data as well as the canvas (pixel surface) of a
 * map.
 *
 * <p>Any changes to the canvas cause the map to update immediately in-game,
 * these modifications will not be persisted back to the disk until the next
 * level save by dimension 0 (the overworld).</p>
 */
public interface MapView {

    /**
     * Returns the width and height of the map's canvas.
     *
     * <p>The x value is the width and the y value is the height.</p>
     *
     * @return The map canvas's size
     */
    Vector2i getSize();

    /**
     * Sets the specified pixel to the exact {@link MapColor} given.
     *
     * <p>The coordinates start with 0,0 as the top left corner moving right
     * and down.</p>
     *
     * @param position The coordinates of the pixel to set
     * @param color The color to set the pixel to
     * @throws IndexOutOfBoundsException If the coordinates are greater than
     *         the width and height of the map's canvas
     */
    default void setPixelExact(Vector2i position, MapColor color) {
        setPixelExact(position.getX(), position.getY(), color);
    }

    /**
     * Sets the specified pixel to the exact {@link MapColor} given.
     *
     * <p>The coordinates start with 0,0 as the top left corner moving right
     * and down.</p>
     *
     * @param x The x coordinate of the pixel
     * @param y The y coordinate of the pixel
     * @param color The color to set the pixel to
     * @throws IndexOutOfBoundsException If the coordinates are greater than
     *         the width and height of the map's canvas
     */
    void setPixelExact(int x, int y, MapColor color);

    /**
     * Sets the specified pixel to the {@link MapColor} that is most similar to the {@link Color} provided.
     *
     * <p>The coordinates start with 0,0 as the top left corner moving right
     * and down.</p>
     *
     * @param position The coordinates of the pixel to set
     * @param color The color to be matched before setting the pixel to the closest {@link MapColor}
     * @throws IndexOutOfBoundsException If the coordinates are greater than
     *         the width and height of the map's canvas
     */
    default void setPixelSimilar(Vector2i position, Color color) {
        setPixelSimilar(position.getX(), position.getY(), color);
    }

    /**
     * Sets the specified pixel to the {@link MapColor} that is most similar to the {@link Color} provided.
     *
     * <p>The coordinates start with 0,0 as the top left corner moving right
     * and down.</p>
     *
     * @param x The x coordinate of the pixel
     * @param y The y coordinate of the pixel
     * @param color The color to be matched before setting the pixel to the closest {@link MapColor}
     * @throws IndexOutOfBoundsException If the coordinates are greater than
     *         the width and height of the map's canvas
     */
    void setPixelSimilar(int x, int y, Color color);

    /**
     * Returns the {@link MapColor} at the specified pixel. An unset pixel will be returned as
     * {@link MapColors#AIR}
     *
     * The coordinates start with 0,0 as the top left corner moving right and
     * down.
     *
     * @param position The coordinates of the pixel to get
     * @return The color of the pixel at the specified coordinates
     * @throws IndexOutOfBoundsException If the coordinates are greater than or equal to
     * the width and height of the map's canvas
     */
    default MapColor getPixel(Vector2i position) {
        return getPixel(position.getX(), position.getY());
    }

    /**
     * Returns the {@link MapColor} at the specified pixel. An unset pixel will be returned as
     * {@link MapColors#AIR}
     *
     * The coordinates start with 0,0 as the top left corner moving right and
     * down.
     *
     * @param x The x coordinate of the pixel to get
     * @param y The y coordinate of the pixel to get
     * @return The color of the pixel at the specified coordinates
     * @throws IndexOutOfBoundsException If the coordinates are greater than or equal to
     * the width and height of the map's canvas
     */
    MapColor getPixel(int x, int y);

    /**
     * Create an {@link BufferedImage} out of the map allowing it to be viewed outside
     * the game in conventional image viewers and shared on the web. Simply
     * converts indexes in the map's canvas to the RGB values they represent.
     *
     * @return The rendered image
     */
    BufferedImage toImage();

    /**
     * Draws an image to the map, starting at the top left corner,
     * clipping it if it goes out of bounds.
     *
     * @param image The image to draw
     */
    default void drawImage(BufferedImage image) {
        drawImage(0, 0, image);
    }

    /**
     * Draws an image to the map, clipping it if it goes out of bounds.
     *
     * @param position The top left coordinate on the map
     * @param image The image to draw
     */
    default void drawImage(Vector2i position, BufferedImage image) {
        drawImage(position.getX(), position.getY(), image);
    }

    /**
     * Draws an image to the map, clipping it if it goes out of bounds.
     *
     * @param x The top left x coordinate on the map
     * @param y The top left y coordinate on the map
     * @param image The image to draw
     */
    void drawImage(int x, int y, BufferedImage image);

    /**
     * Draws text to the map, handling colors but not formatting.
     *
     * <p>Clips text that goes out of bounds at the character before it's out of bounds.</p>
     *
     * @param position The top left coordinate of the drawn text
     * @param text The text to draw
     * @param font The font to use when drawing the text
     *
     * @throws IllegalArgumentException If the font is missing a character used
     *         by the Text provided
     */
    default void drawText(Vector2i position, Text text, MapFont font) {
        drawText(position.getX(), position.getY(), text, font);
    }

    /**
     * Draws text to the map, handling colors but not formatting.
     *
     * <p>Clips text that goes out of bounds at the character before it's out of bounds.</p>
     *
     * @param x The top left x coordinate of the drawn text
     * @param y The top left y coordinate of the drawn text
     * @param text The text to draw
     * @param font The font to use when drawing the text
     *
     * @throws IllegalArgumentException If the font is missing a character used
     *         by the Text provided
     */
    void drawText(int x, int y, Text text, MapFont font);

    /**
     * Returns all the currently active cursors as {@link MapCursor}s,
     * including the ones used by vanilla. Removing a cursor handle from the
     * collection will handle removing the cursor from the map as well.
     *
     * @return All the cursor handles
     */
    Collection<MapCursor> getAllCursors();

    /**
     * Adds a new cursor to the map of the specified type, the position is pixel
     * relative and refers to the center position of the cursor.
     *
     * @param type The type of cursor to add
     * @param position The map pixel relative center position of the cursor
     * @return A handle to the cursor that can be used for updating, removal and
     *         changing the type of cursor
     */
    MapCursor addCursor(MapCursorType type, Vector2i position);

    /**
     * Sends a forced update of the map to a player. This will send only the
     * region of the canvas between min x,y and max x,y to the player. Allowing
     * custom trickle loading, or forced immediate updating of the map.
     *
     * @param player The player to send the update to
     * @param min The upper left corner of the region to send
     * @param max The bottom right corner of the region to send
     * @throws IndexOutOfBoundsException If the update region is not within the boundaries of the map
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
     * @throws IndexOutOfBoundsException If the update region is not within the boundaries of the map
     */
    void sendUpdate(Iterable<Player> players, Vector2i min, Vector2i max);

    /**
     * Adds a renderer to this map as the top layer.
     *
     * @param renderer The renderer to add
     */
    void addRenderer(MapRenderer renderer);

    /**
     * Adds a renderer to this map as the base layer.
     *
     * @param renderer The renderer to add
     */
    void addRendererBase(MapRenderer renderer);

    /**
     * Inserts a renderer in the map at the specific index, shifting existing
     * renderers around it.
     *
     * <p>The ordering is the layering of rendering with 0 being the bottom
     * most layer rendered first, and the {@link List#size()}-1 entry being the
     * latest rendered layer.</p>
     *
     * @param index The index to insert the renderer at
     * @param renderer The renderer to insert
     * @throws IndexOutOfBoundsException If the provided index is out of bounds
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
     * @return True The renderer removed
     * @throws IndexOutOfBoundsException If the provided index is out of bounds
     */
    MapRenderer removeRenderer(int index);

    /**
     * Removes all renderers from this map.
     */
    void clearRenderers();

    /**
     * Returns the id for this MapView to allow it to be attached to
     * compatible items.
     *
     * @return The id for this map
     */
    String getId();

    /**
     * Gets the settings for this map. These settings are mutable and will
     * cause the map to update in-game immediately. The changes are persisted
     * back to disk during level saving by dimension 0 (the overworld).
     *
     * @return This map's settings
     */
    MapSettings getSettings();
}
