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
package org.spongepowered.api.util.mapitem;

import com.flowpowered.math.vector.Vector2i;
import org.spongepowered.api.util.ResettableBuilder;

import java.awt.Color;
import java.awt.Image;
import java.util.List;
import java.util.UUID;

/**
 * Represents a map.
 */
public interface MapItem {

    /**
     * Gets this map's width.
     *
     * @return The width of the map
     */
    int getWidth();
    
    /**
     * Gets this map's height.
     *
     * @return The height of the map
     */
    int getHeight();
    
    /**
     * Gets this map's center.
     *
     * @return The center of the map
     */
    Vector2i getCenter();

    /*
     * Gets this map's world.
     *
     * @return The world UUID of the map
     */
    UUID getWorldUuid();

    /**
     * Gets this map's scale.
     *
     * @return The scale of the map
     */
    int getScale();

    /**
     * Gets the visible players by name on this map.
     *
     * @return The list of players visible
     */
    List<UUID> getVisiblePlayers();
    
    /**
     * Gets the color on this map at specific pixel.
     * 
     * @param pixel The pixel from which to get the color.
     * @return The color
     */
    Color getColor(Vector2i pixel);
    
    interface Builder extends ResettableBuilder<Builder> {

        /**
         * Sets the world uuid of a MapItem.
         *
         * @param worldUuid The world uuid of the map
         * @return This builder
         */
        MapItem.Builder worldUuid(UUID worldUuid);

        /**
         * Sets the visible players on this MapItem.
         *
         * @param visiblePlayers The visible players on this map.
         * @return This builder
         */
        MapItem.Builder visiblePlayers(List<UUID> visiblePlayers);
        
        /**
         * Sets the scale of a MapItem.
         *
         * @param scale The scale of the map
         * @return This builder
         */
        MapItem.Builder scale(int scale);

        /**
         * Sets the center of a MapItem.
         *
         * @param center The center of the map
         * @return This builder
         */
        MapItem.Builder center(Vector2i center);
        
        /**
         * Sets the MapItem to display an image
         *
         * @param image The image to display
         * @return This builder
         */
        MapItem.Builder image(Image image);
        
        /**
         * Sets the width of a MapItem.
         *
         * @param width The display width of the map
         * @return This builder
         */
        MapItem.Builder width(int width);
        
        /**
         * Sets the height of a MapItem.
         *
         * @param height The display height of the map
         * @return This builder
         */
        MapItem.Builder height(int height);

        /**
         * Creates a new MapItem from this builder.
         *
         * @return A new MapItem
         */
        MapItem build();

    }

}
