/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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
package org.spongepowered.api.item.meta;

import com.flowpowered.math.vector.Vector2i;

/**
 * 
 * Represents a decoration on a map.
 *
 */
public interface MapDecoration {

    /**
     * Gets the {@link MapDecorationType} of this decoration.
     * 
     * @return The MapDecorationType of this decoration
     */
    MapDecorationType getType();
    
    /**
     * Sets the {@link MapDecorationType} of this decoration.
     * 
     * @param type The new MapDecorationType of this decoration
     */
    void setType(MapDecorationType type);

    /**
     * Gets the position of this decoration on the map.
     * 
     * @return The position of this decoration on the map
     */
    Vector2i getPosition();

    /**
     * Sets the position of this decoration on the map.
     * 
     * @param position The new position of this decoration on the map
     */
    void setPosition(Vector2i position);

    /**
     * Gets the rotation of this decoration on the map.
     * 
     * @return The rotation of this decoration on the map
     */
    int getRotation();

    /**
     * Sets the rotation of this decoration on the map.
     * 
     * @param rotation The new rotation of this decoration on the map
     */
    void setRotation(int rotation);
    
}
