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
package org.spongepowered.api.text.serializer;

import org.spongepowered.api.text.Text;

/**
 * Represents a serializer for {@link Text} instances that converts an input
 * string into a formatted {@link Text} instance, or a {@link Text} instance
 * into the string representation.
 */
public interface TextSerializer {

    /**
     * Returns a string representation of the provided {@link Text} in a format
     * that will be accepted by this {@link TextSerializer}'s
     * {@link #deserialize(String)} method.
     *
     * @param text The text to serialize
     * @return The string representation of this text
     */
    String serialize(Text text);

    /**
     * Returns a {@link Text} instance from an appropriately formatted string.
     *
     * @param input The raw input to parse into a text
     * @return The parsed text for the input string
     * @throws TextParseException If an error occurs while parsing the text
     */
    Text deserialize(String input) throws TextParseException;

    /**
     * Tries to return a {@link Text} instance from the provided input string.
     * However, if the input string is not of a valid format, the returned
     * {@link Text} object will be of the raw input, rather than throwing an
     * exception.
     *
     * @param input The raw input to try to parse into a text
     * @return The parsed text for the input string, or the raw input
     */
    default Text deserializeUnchecked(String input) {
        try {
            return deserialize(input);
        } catch (TextParseException e) {
            return Text.of(input);
        }
    }

}
