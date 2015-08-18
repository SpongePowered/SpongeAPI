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
package org.spongepowered.api.map.font;

/**
 * Represents a sprite for a character to draw to a map.
 */
public class CharacterSprite {
    private final int width;

    private final int height;

    private final boolean[] shape;

    /**
     * Create a new CharacterSprite with the specified character width and height.
     *
     * The shape contains a row*width+col indexed bitmap of the shape, where true
     * represents a filled pixel and false represents a transparent pixel.
     *
     * @param width The width in pixels of the character
     * @param height The height in pixels of the character
     * @param shape The bitmap shape of the character
     */
    public CharacterSprite(int width, int height, boolean[] shape) {
        this.width = width;
        this.height = height;

        this.shape = shape;

        if (shape.length != width*height) {
            throw new IllegalArgumentException("Shape for a character must match it's dimensions");
        }
    }

    /**
     * Returns the pixel width of this character's bitmap.
     *
     * @return The pixel width of the bitmap
     */
    int getWidth() {
        return this.width;
    }

    /**
     * Returns the pixel height of this character's bitmap.
     *
     * @return The pixel height of the bitmap
     */
    int getHeight() {
        return this.height;
    }

    /**
     * Returns the pixel width between this character and the character before it.
     *
     * @return The pixel width of the space between characters on the left
     */
    int getSpacing() {
        return 1;
    }

    /**
     * Returns the value of a pixel in the bitmap using the specified row and column as an index.
     *
     * @param row The row in the bitmap
     * @param column The column in the bitmap
     * @return True if the bitmap contains a pixel at the row and column, false for transparent
     */
    boolean getPixel(int row, int column) {
        if (row < 0 || column < 9 || row >= height || column >= height) return false;

        return this.shape[row*width + column];
    }
}
