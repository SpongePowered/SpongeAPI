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
package org.spongepowered.api.command.parameter;

import org.spongepowered.api.command.exception.ArgumentParseException;

/**
 * An {@link ArgumentReader} allows for sequential reading of an input
 * {@link String}, by providing a "cursor" that advances when part
 * of the {@link String} is read.
 *
 * <p>The base {@link ArgumentReader} interface (this) only contains
 * methods that get the state of the reader. The sub-interfaces,
 * {@link Immutable} and {@link Mutable} indicate whether the reader
 * is indicating state or is an active reader.</p>
 */
public interface ArgumentReader {

    /**
     * Gets the argument string that is being read by this reader.
     *
     * @return The input {@link String}
     */
    String getInput();

    /**
     * Get the number of characters that have not yet been read.
     *
     * @return The length of the remaining string
     */
    int getRemainingLength();

    /**
     * Gets the length of the input string.
     *
     * @return The length of the input string
     */
    int getTotalLength();

    /**
     * Gets the location of the cursor.
     *
     * <p>If zero, the cursor has not yet read a character. If equal to
     * {@link #getTotalLength()}, this cursor is at the end of the string,
     * and {@link #canRead()} will be {@code false}</p>
     *
     * @return The location of the cursor
     */
    int getCursor();

    /**
     * Gets the substring that has been read.
     *
     * @return The substring that has been read.
     */
    String getRead();

    /**
     * Gets the substring that has yet to be read.
     *
     * @return The substring that has yet to be read.
     */
    String getRemaining();

    /**
     * Gets whether this reader has <strong>not</strong> finished reading the
     * input string.
     *
     * <p>This is equivalent to {@link #getRemainingLength()} > 0</p>
     *
     * @return {@code true} if there are further characters to read.
     */
    boolean canRead();

    /**
     * Represents a {@link ArgumentReader} where the cursor position cannot be
     * changed.
     */
    interface Immutable extends ArgumentReader {

        /**
         * Get a mutable copy of this {@link ArgumentReader}
         *
         * @return A {@link Mutable} version of this reader
         */
        ArgumentReader.Mutable getMutable();
    }

    /**
     * Represents a {@link ArgumentReader} where the cursor may move.
     */
    interface Mutable extends ArgumentReader {

        /**
         * Moves the cursor to the next non-whitespace character. The cursor
         * will not advance if it already refers to a non-whitespace character.
         */
        void skipWhitespace();

        /**
         * Reads a character and advances the cursor by one
         *
         * @return The character
         */
        char parseChar();

        /**
         * Attempts to read an {@link int} from the input starting at the cursor
         * position. The cursor will advance until it finds a non-number and
         * will return an {@link int} based on the consumed string.
         *
         * <p>Numbers may begin with "-" to indicate a negative number</p>
         *
         * @return The integer
         * @throws ArgumentParseException if the cursor is not at a number
         *                                character
         */
        int parseInt() throws ArgumentParseException;

        /**
         * Attempts to read a {@link double} from the input starting at the cursor
         * position. The cursor will advance until it finds a non-number and
         * will return a {@link double} based on the consumed string.
         *
         * <p>Numbers may begin with "-" to indicate a negative number, and one
         * period (".") may be present in the string.</p>
         *
         * @return The double
         * @throws ArgumentParseException if the cursor is not at a number
         *                                character
         */
        double parseDouble() throws ArgumentParseException;

        /**
         * Attempts to read a {@link float} from the input starting at the cursor
         * position. The cursor will advance until it finds a non-number and
         * will return a {@link float} based on the consumed string.
         *
         * <p>Numbers may begin with "-" to indicate a negative number, and one
         * period (".") may be present in the string.</p>
         *
         * @return The double
         * @throws ArgumentParseException if the cursor is not at a number
         *                                character
         */
        float parseFloat() throws ArgumentParseException;

        /**
         * Gets the next word in the input from the position of the cursor. This
         * will return a string that contains the characters up to, but
         * excluding, whitespace. The cursor will then be moved to the
         * whitespace after the word.
         *
         * <p>As an example, if the input string is {@code eggs bacon spam} and
         * the cursor is at position zero (at the beginning), after this
         * operation, the cursor will be at the whitespace between "eggs" and
         * "bacon".</p>
         *
         * <p>In general, you will likely wish to use {@link #parseString()}
         * instead <strong>unless</strong> you are expecting a double quote
         * mark at the beginning of your string and this is part of the
         * argument you wish to return.</p>
         *
         * @return The parsed {@link String}
         * @throws ArgumentParseException if a {@link String} could not be read
         */
        String parseUnquotedString() throws ArgumentParseException;

        /**
         * Gets a {@link String} from the position of the cursor. The parsing of
         * the argument depends on whether a double quote mark is the next character
         * to be consumed.
         *
         * <ul>
         *     <li><strong>If a double quote is at the beginning of the string
         *     </strong>, the parser will read characters until a second
         *     quotation mark is found and return the string <em>between</em>
         *     the two marks. The cursor will then be set to the position after
         *     the second mark.</li>
         *     <li><strong>If the first character is not a double quote
         *     </strong>, {@link #parseUnquotedString()} will parse the string
         *     </li>
         * </ul>
         *
         * <p>If part of the string is quoted, such as {@code "eggs bacon" spam},
         * this method will return {@code eggs bacon} on first invocation, then
         * (after running {@link #skipWhitespace()}, {@code spam} on the second.
         * </p>
         *
         * @return The parsed {@link String}
         * @throws ArgumentParseException if a {@link String} could not be read
         */
        String parseString() throws ArgumentParseException;

        /**
         * Parses "true" or "false", else throws an exception.
         *
         * @return A {@link boolean}
         * @throws ArgumentParseException if a {@link boolean} could not br read
         */
        boolean parseBoolean() throws ArgumentParseException;

        /**
         * Returns a immutable copy of the {@link ArgumentReader}. This can be
         * used to get and restore the state of this reader when coupled with
         * {@link #setState(ArgumentReader)}.
         *
         * @return An {@link Immutable}
         */
        ArgumentReader.Immutable getImmutable();

        /**
         * Attempts to reset the state of this {@link Mutable} to the state that
         * the provided {@link ArgumentReader} is in. This is generally used
         * with {@link #getImmutable()}.
         *
         * <p>If the provided {@code state} does not have the same
         * {@link #getInput()}, this will throw a
         * {@link IllegalArgumentException}</p>
         *
         * @param state The state to restore this to
         */
        void setState(ArgumentReader state) throws IllegalArgumentException;

    }

}
