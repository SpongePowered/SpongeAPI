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
package org.spongepowered.api.map.cursor;

import com.flowpowered.math.vector.Vector2i;
import org.spongepowered.api.map.MapView;

/**
 * Holds a link between a {@link MapView} and the {@link MapCursorType} stored in it.
 *
 * <p>This is needed to allow easy repositioning of cursors and to allow
 * removing specific cursors, as multiple cursors could be overlaid in the
 * same position.</p>
 */
public interface MapCursor {

    /**
     * Returns the type of {@link MapCursorType} this handle represents.
     *
     * @return The type of cursor
     */
    MapCursorType getType();

    /**
     * Returns the center position of the cursor on the map. Relative to the
     * map's pixels.
     *
     * @return The center position
     */
    Vector2i getCenter();

    /**
     * Updates the position of the cursor on the map. Relative to the map's
     * pixels.
     *
     * @param center The new center position
     * @throws IndexOutOfBoundsException If the center position provided is not within the map
     */
    default void update(Vector2i center) {
        update(center.getX(), center.getY());
    }

    /**
     * Updates the position of the cursor on the map. Relative to the map's
     * pixels.
     *
     * @param centerX The new center x position
     * @param centerY The new center y position
     * @throws IndexOutOfBoundsException If the center position provided is not within the map
     */
    void update(int centerX, int centerY);

    /**
     * Removes this cursor from the map.
     *
     * @return True if the removal was successful, false otherwise
     */
    boolean remove();

}
