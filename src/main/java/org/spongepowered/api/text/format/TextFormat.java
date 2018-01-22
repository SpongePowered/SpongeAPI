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
package org.spongepowered.api.text.format;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextElement;

/**
 * Represents a pair of {@link TextStyle} and {@link TextColor}.
 */
public interface TextFormat extends TextElement {

    /**
     * Gets the {@link TextFormat} with the default style and color.
     *
     * @return The empty text format
     */
    static TextFormat of() {
        return Sponge.getRegistry().getTextFactory().emptyFormat();
    }

    /**
     * Constructs a new {@link TextFormat} with the specific style.
     *
     * @param style The style
     * @return The new text format
     */
    @SuppressWarnings("deprecation")
    static TextFormat of(TextStyle style) {
        return Sponge.getRegistry().getTextFactory().format(TextColors.NONE, style);
    }

    /**
     * Constructs a new {@link TextFormat} with the specific color.
     *
     * @param color The color
     * @return The new text format
     */
    @SuppressWarnings("deprecation")
    static TextFormat of(TextColor color) {
        return Sponge.getRegistry().getTextFactory().format(color, TextStyles.NONE);
    }

    /**
     * Constructs a new {@link TextFormat} with the specific color and style.
     *
     * @param color The color
     * @param style The style
     * @return The new text format
     */
    @SuppressWarnings("deprecation")
    static TextFormat of(TextColor color, TextStyle style) {
        return Sponge.getRegistry().getTextFactory().format(color, style);
    }

    /**
     * Returns the {@link TextColor} in this format.
     *
     * @return The color
     */
    TextColor getColor();

    /**
     * Returns the {@link TextStyle} in this format.
     *
     * @return The style
     */
    TextStyle getStyle();

    /**
     * Returns a new {@link TextFormat} with the given color.
     *
     * @param color The color
     * @return The new text format
     */
    TextFormat color(TextColor color);

    /**
     * Returns a new {@link TextFormat} with the given style.
     *
     * @param style The style
     * @return The new text format
     */
    TextFormat style(TextStyle style);

    /**
     * Returns a new {@link TextFormat} that combines this and the given format.
     * The given format takes higher priority than this one. Due to this the
     * color will only fallback to this one if the given format's color is
     * {@link TextColors#NONE}. If the given format's color is
     * {@link TextColors#RESET} then {@link TextColors#NONE} will be used.
     * Styles are combined using {@link TextStyle#and(TextStyle...)}.
     *
     * @param format The format to merge
     * @return The new text format
     */
    TextFormat merge(TextFormat format);

    /**
     * Returns whether this {@link TextFormat} has no color and format
     * specified.
     *
     * @return If the format does not contain a color or any styles
     */
    boolean isEmpty();

    @Override
    default void applyTo(Text.Builder builder) {
        builder.format(this);
    }
}
