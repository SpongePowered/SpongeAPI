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
interface TextFactory {

    /**
     * Creates a new {@link TextBuilder}.
     *
     * @param content The content of the Message
     * @param <T> The type parameter of the Message
     * @return A new MessageBuilder
     *
     * @throws UnsupportedOperationException If the specified content type is
     *             not supported by this server
     */
    <T> TextBuilder<T> createBuilder(T content);

    /**
     * Creates a new {@link TextBuilder} that builds {@link Translation}
     * messages.
     *
     * @param translation The translation of the Message
     * @param args The arguments to the translation
     * @return A new MessageBuilder
     */
    TextBuilder<Translation> createTranslationBuilder(Translation translation, Object[] args);

    // TODO: Score API

    /**
     * Creates a new {@link TextBuilder} that builds {@link Text.Score}
     * messages.
     *
     * @param score The score of the Message
     * @param override The override of the score
     * @return A
     */
    TextBuilder<Object> createScoreBuilder(Object score, String override);

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
    Text.Plain parseLegacyMessage(String text, char color);

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
