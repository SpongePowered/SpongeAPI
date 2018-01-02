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

import com.google.common.collect.ImmutableMap;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Map;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Represents a font on a map that can be used for drawing characters.
 */
public interface MapFont {

    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }
    /**
     * Returns the {@link CharacterSprite} data for the specified character.
     *
     * @param ch The character to retrieve a sprite for
     * @return The sprite version of the character
     */
    Optional<CharacterSprite> getChar(char ch);

    /**
     * Returns the pixel width of a string of text accounting for the
     * {@link CharacterSprite} sizes and a spacing between characters.
     *
     * @param text The string of text to analyze the width of
     * @return The width of the text in pixels
     * @throws IllegalArgumentException If the text provided contains a
     *         character not provided in the character sprites
     */
    int getWidth(String text);

    /**
     * Returns the maximum pixel height of a string of text.
     *
     * @param text The text to return the height of
     * @return The maximum number of pixels in height this text will take up
     */
    int getHeight(String text);

    interface Builder extends ResettableBuilder<MapFont, Builder> {
        /**
         * Sets the mapping between a character and a {@link CharacterSprite}.
         *
         * @param spriteMap The map of characters to font sprites
         * @return The builder for chaining
         */
        Builder characters(Map<Character, CharacterSprite> spriteMap);

        /**
         * Sets the width of a space character.
         *
         * @param width The width in map pixels
         * @return The builder for chaining
         */
        Builder spaceWidth(int width);

        /**
         * Builds the {@link MapFont} from the provided font details.
         *
         * @return The font
         */
        MapFont build();
    }
}
