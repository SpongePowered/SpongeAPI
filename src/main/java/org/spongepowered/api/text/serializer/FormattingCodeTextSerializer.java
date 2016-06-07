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

/**
 * Represents a {@link TextSerializer} for the old "formatting code" strings. A
 * formatted message consists out of plain text with a special character
 * indicating a formatting follows and a unique character for each formatting.
 *
 * <p><b>Example:</b> {@code &cHello &eSponge!}<br> With the special character
 * {@code &} this would represent a red and yellow message. (With {@code c}, and
 * {@code e} being the formatting characters.)</p>
 *
 * @see <a href="http://minecraft.gamepedia.com/Formatting_codes">
 *     Formatting codes on the Minecraft Wiki</a>
 */
public interface FormattingCodeTextSerializer extends SafeTextSerializer {

    /**
     * Returns the formatting character for this
     * {@link FormattingCodeTextSerializer}.
     *
     * @return The formatting character
     */
    char getCharacter();

    /**
     * Removes the color codes for this {@link FormattingCodeTextSerializer}
     * from a string.
     *
     * @param text The string
     * @return The stripped text
     */
    String stripCodes(String text);

    /**
     * Replaces the formatting codes in the specified string with a different
     * specified character, e.g. {@code &cHello &eSponge! -> $cHello $eSponge!}
     *
     * @param text The string to replace the formatting codes in
     * @param to The special character to replace with
     * @return The replaced text
     */
    String replaceCodes(String text, char to);

    /**
     * Replaces the formatting codes in the specified string with a different
     * character for the specified {@link FormattingCodeTextSerializer},
     * e.g. {@code &cHello &eSponge! -> $cHello $eSponge!}
     *
     * @param text The string to replace the formatting codes in
     * @param serializer The serializer to replace for
     * @return The replaced text
     */
    default String replaceCodes(String text, FormattingCodeTextSerializer serializer) {
        return replaceCodes(text, serializer.getCharacter());
    }

}
