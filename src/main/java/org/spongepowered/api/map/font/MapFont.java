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

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

/**
 * Represents a font on a map that can be used for drawing characters.
 */
public final class MapFont {

    private final ImmutableMap<Character, CharacterSprite> characters;

    public MapFont(Map<Character, CharacterSprite> characters, int spaceSize) {
        ImmutableMap.Builder<Character, CharacterSprite> builder =
                new ImmutableMap.Builder<Character, CharacterSprite>();

        if (!characters.containsKey(' ')) {
            builder.put(' ', new CharacterSprite(spaceSize, 8, new boolean[16]));
        }

        builder.putAll(characters);

        this.characters = builder.build();
    }

    /**
     * Returns the {@link CharacterSprite} data for the specified character.
     *
     * @param ch The character to retrieve a sprite for
     * @return The sprite version of the character
     */
    public Optional<CharacterSprite> getChar(char ch) {
        return Optional.fromNullable(characters.get(ch));
    }

    /**
     * Returns the pixel width of a string of text accounting for the
     * {@link CharacterSprite} sizes and a spacing between characters.
     *
     * @param text The string of text to analyze the width of
     * @return The width of the text in pixels
     * @throws IllegalArgumentException If the text provided contains a
     *         character not provided in the character sprites
     */
    public int getWidth(String text) {
        checkNotNull(text);

        if (text.length() == 0) return 0;

        int width = 0;
        // Avoids copying the inner character array by indexing
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            CharacterSprite value = characters.get(ch);
            if (value == null) {
                throw new IllegalArgumentException("Character '" + ch +
                        "' was not provided as a CharacterSprite.");
            }
            width += value.getWidth();

            // Only add spacing from the left after first character.
            if (i > 1) {
                width += value.getSpacing();
            }
        }
        return width;
    }

    /**
     * Returns the maximum pixel height of a string of text.
     *
     * @param text The text to return the height of
     * @return The maximum number of pixels in height this text will take up
     */
    public int getHeight(String text) {
        checkNotNull(text);

        if (text.length() == 0) {
            return 0;
        }

        int maxHeight = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // Skip whitespace
            if (!Character.isWhitespace(ch)) {
                CharacterSprite sprite = characters.get(ch);
                if (sprite == null) {
                    throw new IllegalArgumentException("Charcter '" + ch +
                            "' was not provided as a CharacterSprite.");
                }
                if (sprite.getHeight() > maxHeight) {
                    maxHeight = sprite.getHeight();
                }
            }
        }
        return maxHeight;
    }
}
