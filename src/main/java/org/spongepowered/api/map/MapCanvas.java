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

import com.google.common.base.Function;
import org.spongepowered.api.map.color.MapColor;
import org.spongepowered.api.map.font.MapFont;
import org.spongepowered.api.text.Text;

import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * A representation of the canvas (pixel surface) of a map.
 */
public interface MapCanvas {

    /**
     * Returns the width of the map's canvas.
     *
     * @return The map canvas's width
     */
    int getWidth();

    /**
     * Returns the height of the map's canvas.
     *
     * @return The map canvas's height
     */
    int getHeight();

    /**
     * Sets the specified pixel.
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
    void setPixel(int x, int y, MapColor color);

    /**
     * Returns the {@link MapColor} at the specified pixel.
     *
     * The coordinates start with 0,0 as the top left corner moving right and
     * down.
     *
     * @param x The x coordinate of the pixel to get
     * @param y The y coordinate of the pixel to get
     * @return The color of the pixel at the specified coordinates
     * @throws IndexOutOfBoundsException If the coordinates are greater than
     *         the width and height of the map's canvas
     */
    MapColor getPixel(int x, int y);

    /**
     * Create an {@link Image} out of the map allowing it to be viewed outside
     * the game in conventional image viewers and shared on the web. Simply
     * converts indexes in the map's canvas to the RGB values they represent.
     *
     * @return The rendered image
     */
    Image toImage();

    /**
     * Draws an image to the map, clipping it if it goes out of bounds.
     *
     * @param x The top left x coordinate on the map
     * @param y The top left y coordinate on the map
     * @param image The image to draw
     */
    void drawImage(int x, int y, Image image);

    /**
     * Draws text to the map, handling colors but not formatting. Clips text
     * that goes out of bounds at the character before it's out of bounds.
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

}
