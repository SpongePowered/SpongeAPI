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
package org.spongepowered.api.text;

import org.spongepowered.api.text.translation.Translation;

/**
 * Represents the required implementation for the static methods in
 * {@link Texts}.
 */
public interface TextFactory {

    /**
     * Creates a {@link TextBuilder} with empty text.
     *
     * @return A new message builder with empty text
     */
    TextBuilder createEmptyBuilder();

    /**
     * Creates a {@link TextBuilder.Literal} with the specified text.
     *
     * @param text The text for the message
     * @return A new message builder with the specified text
     * @see Text.Literal
     */
    TextBuilder.Literal createTextBuilder(String text);

    /**
     * Creates a {@link TextBuilder.Translatable} with the specified
     * translation and arguments.
     *
     * @param translation The translation to use for the message
     * @param args The arguments for the translation, can be empty
     * @return A new message builder with the specified translation and
     *         arguments
     * @see Text.Translatable
     */
    TextBuilder.Translatable createTranslatableBuilder(Translation translation, Object[] args);

    /**
     * Creates a new {@link TextBuilder.Selector} with the specified
     * selector.
     *
     * @param selector The selector for the message
     * @return A new message builder with the specified selector
     * @see Text.Selector
     */
    TextBuilder.Selector createSelectorBuilder(String selector);

    /**
     * Creates a new {@link TextBuilder.Score} with the specified score.
     *
     * @param score The score for the message
     * @return A new message builder with the specified score
     * @see Text.Score
     */
    TextBuilder.Score createScoreBuilder(Object score); // TODO

    /**
     * Creates a {@link Text} with the specified plain text. The created
     * message won't have any formatting or events configured.
     *
     * @param text The content of the Message
     * @return The created {@link Text}
     */
    Text.Literal createPlain(String text);

    /**
     * Returns the default legacy formatting character.
     *
     * @return The legacy formatting character
     */
    char getColorChar();

    /**
     * Creates a Message from a legacy string, given a color character.
     *
     * @param text The text to be converted as a String
     * @param color The color character to be replaced
     * @return The converted Message
     */
    Text.Literal parseLegacyMessage(String text, char color);

    /**
     * Removes the legacy formatting character from a legacy string.
     *
     * @param text The legacy text as a String
     * @param color The color character to be replaced
     * @return The stripped text
     */
    String stripLegacyCodes(String text, char color);

    /**
     * Replaces the given formatting character with another given formatting
     * character from a legacy string.
     *
     * @param text The legacy text as a String
     * @param from The color character to be replaced
     * @param to The color character to replace with
     * @return The replaced text
     */
    String replaceLegacyCodes(String text, char from, char to);

}
