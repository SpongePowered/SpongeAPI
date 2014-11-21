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
package org.spongepowered.api.text.format;

import java.util.List;

/**
 * Represents the required implementation for the static methods in
 * {@link TextColors} and {@link TextStyles}.
 */
interface TextFormatFactory {

    /**
     * Gets the {@link TextColor} with the specified name.
     *
     * @param name The identifier of the text colors, for example "DARK_BLUE"
     * @return The {@link TextColor} with the specified name, or null if not
     *         found
     */
    TextColor getColorFromName(String name);

    /**
     * Returns a list of all available {@link TextColor}s on this server.
     *
     * @return An immutable list of all text colors
     */
    List<TextColor> getColors();

    /**
     * Gets the {@link TextStyle} with the specified name.
     *
     * @param name The identifier of the text style, for example "UNDERLINE"
     * @return The {@link TextStyle} with the specified name, or null if not
     *         found
     */
    TextStyle getStyleFromName(String name);

    /**
     * Returns a list of all available {@link TextStyle}s on this server.
     *
     * @return An immutable list of all text styles
     */
    List<TextStyle> getStyles();

    /**
     * Constructs a composite text style from the specified styles. This should
     * result in the same as calling {@link TextStyle#and(TextStyle...)} on all
     * of the text styles.
     *
     * @param styles The styles to combine.
     * @return A composite text style from the specified styles
     */
    TextStyle createStyle(TextStyle[] styles);

}
