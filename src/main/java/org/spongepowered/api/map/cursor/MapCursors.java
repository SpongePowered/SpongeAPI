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

import org.spongepowered.api.map.cursor.MapCursor;

/**
 * An enumeration of all the possible vanilla {@link MapCursor}s. The rendering
 * code does allow the texture of the cursors (also known as decorations or icons)
 * to be modified by the resource packs including adding more, however this is unusual
 * and can fairly easily be added if eventually needed.
 */
public final class MapCursors {

    private MapCursors() {
    }

    /**
     * The white player pointer, in vanilla this is used to indicate other
     * players currently holding the same map and their directions.
     */
    public static final MapCursor WHITE_POINTER = null;

    /**
     * The green version of the pointer, in vanilla this is used to indicate
     * the positions and directions of ItemFrames containing the same map
     * the player is holding.
     */
    public static final MapCursor GREEN_POINTER = null;

    /**
     * Not used by vanilla but looks exactly like the white and green pointers
     * except it's red in color.
     */
    public static final MapCursor RED_POINTER = null;

    /**
     * Not used by vanilla but looks exactly like the white and green pointers
     * except it's blue in color.
     */
    public static final MapCursor BLUE_POINTER = null;

    /**
     * Not used by vanilla, looks like a white colored square X, centered on
     * the position of the cursor.
     */
    public static final MapCursor WHITE_X = null;

    /**
     * Note used by vanilla, looks like a red wedge, centered on the middle of
     * the wedge not the tip.
     */
    public static final MapCursor RED_WEDGE = null;

    /**
     * A white circle with the circle centered on cursor position. In vanilla
     * this is used for out of bound position indication.
     */
    public static final MapCursor WHITE_CIRCLE = null;

}
