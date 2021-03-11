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

import com.google.gson.JsonObject;
import net.kyori.adventure.text.Component;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.command.exception.ArgumentParseException;
import org.spongepowered.api.command.parameter.managed.ValueParser;
import org.spongepowered.api.command.parameter.managed.clientcompletion.ClientCompletionTypes;
import org.spongepowered.api.data.persistence.DataContainer;

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
    String input();

    /**
     * Get the number of characters that have not yet been read.
     *
     * @return The length of the remaining string
     */
    int remainingLength();

    /**
     * Gets the length of the input string.
     *
     * @return The length of the input string
     */
    int totalLength();

    /**
     * Gets the location of the cursor.
     *
     * <p>If zero, the cursor has not yet read a character. If equal to
     * {@link #totalLength()}, this cursor is at the end of the string,
     * and {@link #canRead()} will be {@code false}</p>
     *
     * @return The location of the cursor
     */
    int cursor();

    /**
     * Gets the substring that has already been parsed.
     *
     * @return The substring that has been parsed.
     */
    String parsed();

    /**
     * Gets the substring that has yet to be read.
     *
     * @return The substring that has yet to be read.
     */
    String remaining();

    /**
     * Gets whether this reader has <strong>not</strong> finished reading the
     * input string.
     *
     * <p>This is equivalent to {@link #remainingLength()} &gt; 0</p>
     *
     * @return {@code true} if there are further characters to read.
     */
    boolean canRead();

    /**
     * Gets the character after the cursor if {@link #canRead()} is true.
     *
     * @return The next character
     * @throws IllegalStateException if {@link #canRead()} is false
     */
    char peekCharacter();

    /**
     * Creates an {@link ArgumentParseException} with the provided message,
     * based on the current state of this object.
     *
     * <p>Note that the exception will <strong>not</strong> be thrown. It
     * is up to the caller of this method to throw the exception.</p>
     *
     * @param errorMessage The error message to display
     * @return The exception
     */
    ArgumentParseException createException(Component errorMessage);

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
        ArgumentReader.Mutable mutable();
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
         * Attempts to read an {@code int} from the input starting at the cursor
         * position. The cursor will advance until it finds a non-number and
         * will return an {@code int} based on the consumed string.
         *
         * <p>Numbers may begin with "-" to indicate a negative number</p>
         *
         * <p>When using this in your parser, you should set
         * {@link ValueParser#clientCompletionType()} to
         * {@link ClientCompletionTypes#WHOLE_NUMBER} to tell the client that
         * the client completion should be an integer.</p>
         *
         * @return The integer
         * @throws ArgumentParseException if the cursor is not at a number
         *                                character
         */
        int parseInt() throws ArgumentParseException;

        /**
         * Attempts to read a {@code double} from the input starting at the cursor
         * position. The cursor will advance until it finds a non-number and
         * will return a {@code double} based on the consumed string.
         *
         * <p>Numbers may begin with "-" to indicate a negative number, and one
         * period (".") may be present in the string.</p>
         *
         * <p>When using this in your parser, you should set
         * {@link ValueParser#clientCompletionType()} to
         * {@link ClientCompletionTypes#DECIMAL_NUMBER} to tell the client that
         * the client completion should be a floating point number.</p>
         *
         * @return The double
         * @throws ArgumentParseException if the cursor is not at a number
         *                                character
         */
        double parseDouble() throws ArgumentParseException;

        /**
         * Attempts to read a {@code float} from the input starting at the cursor
         * position. The cursor will advance until it finds a non-number and
         * will return a {@code float} based on the consumed string.
         *
         * <p>Numbers may begin with "-" to indicate a negative number, and one
         * period (".") may be present in the string.</p>
         *
         * <p>When using this in your parser, you should set
         * {@link ValueParser#clientCompletionType()} to
         * {@link ClientCompletionTypes#DECIMAL_NUMBER} to tell the client that
         * the client completion should be a floating point number.</p>
         *
         * @return The double
         * @throws ArgumentParseException if the cursor is not at a number
         *                                character
         */
        float parseFloat() throws ArgumentParseException;

        /**
         * Attempts to read a string that is in a {@link ResourceKey} format,
         * which is {@code namespace:identifier}.
         *
         * <p>This parser is a <strong>strict parser</strong>. If the input is
         * not of the format specified above, this will fail. If you are
         * potentially expecting a non-namespaced key, but would like to accept
         * such strings with a default namespace, use
         * {@link #parseResourceKey(String)}</p>
         *
         * <p>When using this in your parser, you should set
         * {@link ValueParser#clientCompletionType()} to
         * {@link ClientCompletionTypes#RESOURCE_KEY} to tell the client that
         * the client completion should be a {@link ResourceKey}, so that your
         * users will not be told to put their argument in quotation marks.</p>
         *
         * @return The {@link ResourceKey}
         * @throws ArgumentParseException if a key could not be parsed
         */
        ResourceKey parseResourceKey() throws ArgumentParseException;

        /**
         * Attempts to read a string that is in a {@link ResourceKey} format,
         * which is {@code namespace:identifier}.
         *
         * <p>If no colon is encountered, the default namespace defined below
         * will be used as the namespace.</p>
         *
         * <p>When using this in your parser, you should set
         * {@link ValueParser#clientCompletionType()} to
         * {@link ClientCompletionTypes#RESOURCE_KEY} to tell the client that
         * the client completion should be a {@link ResourceKey}, so that your
         * users will not be told to put their argument in quotation marks.</p>
         *
         * @return The {@link ResourceKey}
         * @throws ArgumentParseException if a key could not be parsed
         */
        ResourceKey parseResourceKey(String defaultNamespace) throws ArgumentParseException;

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
         * <p>The following characters will be parsed as part of a valid string
         * without the need for quotation marks.</p>
         *
         * <ul>
         * <li>Alphanumeric symbols</li>
         * <li>Underscores (_)</li>
         * <li>Hyphens (-)</li>
         * <li>Periods (.)</li>
         * <li>Plus signs (+)</li>
         * </ul>
         *
         * <p>If you require other symbols, use {@link #parseString()} and ensure
         * that users are aware they need to surround their inputs with double
         * quotation marks. Alternatively, consider whether other parse types are
         * suitable (for example, if you are expecting a {@link ResourceKey}, use
         * {@link #parseResourceKey()} or {@link #parseResourceKey(String)}.</p>
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
         * Returns the next {@link String} but does not advance the reader.
         *
         * <p>This call will return the same result as {@link #parseString()}.
         * Calling this multiple times in succession will return the same result
         * each time until another <code>parse*</code> method or
         * {@link #setState(ArgumentReader)} is called.</p>
         *
         * @return The next string to be read
         * @throws ArgumentParseException if a {@link String} could not be read
         */
        String peekString() throws ArgumentParseException;

        /**
         * Parses "true" or "false", else throws an exception.
         *
         * @return A {@code boolean}
         * @throws ArgumentParseException if a {@code boolean} could not be read
         */
        boolean parseBoolean() throws ArgumentParseException;

        /**
         * Parses a SNBT string, returning that string.
         *
         * <p>When using this in your parser, you should set
         * {@link ValueParser#clientCompletionType()} to
         * {@link ClientCompletionTypes#SNBT} to tell the client that
         * the client completion should be a SNBT string.</p>
         *
         * @return The string
         * @throws ArgumentParseException if a SNBT string could not be read
         */
        String parseNBTString() throws ArgumentParseException;

        /**
         * Parses a {@link DataContainer}, from a SNBT string, else throws an exception.
         *
         * <p>When using this in your parser, you should set
         * {@link ValueParser#clientCompletionType()} to
         * {@link ClientCompletionTypes#SNBT} to tell the client that
         * the client completion should be a string in Mojang's SNBT format.</p>
         *
         * @return A {@link JsonObject}
         * @throws ArgumentParseException if a {@link JsonObject} could not be
         *     read
         */
        DataContainer parseDataContainer() throws ArgumentParseException;

        /**
         * Returns a immutable copy of the {@link ArgumentReader}. This can be
         * used to get and restore the state of this reader when coupled with
         * {@link #setState(ArgumentReader)}.
         *
         * @return An {@link Immutable}
         */
        ArgumentReader.Immutable immutable();

        /**
         * Attempts to reset the state of this {@link Mutable} to the state that
         * the provided {@link ArgumentReader} is in. This is generally used
         * with {@link #immutable()}.
         *
         * <p>If the provided {@code state} does not have the same
         * {@link #input()}, this will throw a
         * {@link IllegalArgumentException}</p>
         *
         * @param state The state to restore this to
         */
        void setState(ArgumentReader state) throws IllegalArgumentException;

    }

}
