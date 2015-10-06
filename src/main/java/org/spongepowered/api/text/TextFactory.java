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
package org.spongepowered.api.text;

import java.util.Locale;

/**
 * Represents the required implementation for the static methods in
 * {@link Texts}.
 */
public interface TextFactory {

    /**
     * Returns a plain text representation of the {@link Text} without any
     * formatting.
     *
     * @param text The text to convert
     * @return The text converted to plain text
     */
    String toPlain(Text text);

    /**
     * Returns a plain text representation of the {@link Text} without any
     * formatting in the provided Locale.
     *
     * @param text The text to convert
     * @param locale The language to get the plain string in
     * @return The text converted to plain text
     */
    String toPlain(Text text, Locale locale);

    /**
     * Get a {@link TextRepresentation} for the Mojangson representation of a {@link Text} object.
     *
     * @return The json serializer
     */
    TextRepresentation json();

    /**
     * Get a {@link TextRepresentation} for the TextXML representation of a {@link Text} object.
     *
     * @return The xml text serializer
     */
    TextRepresentation xml();
    /**
     * Returns the default legacy formatting character.
     *
     * @return The legacy formatting character
     */
    char getLegacyChar();

    /**
     * Return a representation that accepts and outputs legacy color codes, using the provided legacy character.
     *
     * @param legacyChar The legacy character to parse and output using
     * @return The appropriate legacy representation handler
     */
    TextRepresentation legacy(char legacyChar);


    /**
     * Removes the legacy formatting character from a legacy string.
     *
     * @param text The legacy text as a String
     * @param code The color character to be replaced
     * @return The stripped text
     */
    String stripLegacyCodes(String text, char code);

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
