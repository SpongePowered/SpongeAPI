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

/**
 * Represents the required implementation for the static methods in
 * {@link Texts}.
 */
public interface TextFactory {

    /**
     * Parses the specified JSON text and returns the parsed result.
     *
     * @param json The valid JSON text
     * @return The parsed text
     * @throws IllegalArgumentException If the JSON is invalid
     */
    Text parseJson(String json) throws IllegalArgumentException;

    /**
     * Parses the specified JSON text leniently and returns the parsed result.
     *
     * @param json The JSON text
     * @return The parsed text
     * @throws IllegalArgumentException If the JSON couldn't be parsed
     */
    Text parseJsonLenient(String json) throws IllegalArgumentException;

    /**
     * Returns a plain text representation of the {@link Text} without any
     * formattings.
     *
     * @param text The text to convert
     * @return The text converted to plain text
     */
    String toPlain(Text text);

    /**
     * Returns a JSON representation of the {@link Text} as used in commands.
     *
     * @param text The text to convert
     * @return The text converted to JSON
     */
    String toJson(Text text);

    /**
     * Returns the default legacy formatting character.
     *
     * @return The legacy formatting character
     */
    char getLegacyChar();

    /**
     * Creates a Message from a legacy string, given a color character.
     *
     * @param text The text to be converted as a String
     * @param code The color character to be replaced
     * @return The converted Message
     */
    Text.Literal parseLegacyMessage(String text, char code);

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

    /**
     * Returns a representation of the {@link Text} using the legacy color
     * codes.
     *
     * @param text The text to convert
     * @param code The legacy char to use for the message
     * @return The text converted to the old color codes
     */
    String toLegacy(Text text, char code);

}
