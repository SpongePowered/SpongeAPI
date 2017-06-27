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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.reflect.TypeToken;
import ninja.leaping.configurate.objectmapping.serialize.TypeSerializers;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextElement;
import org.spongepowered.api.text.serializer.TextFormatConfigSerializer;

/**
 * Represents a pair of {@link TextStyle} and {@link TextColor}.
 */
public final class TextFormat implements TextElement {

    static {
        TypeSerializers.getDefaultSerializers().registerType(TypeToken.of(TextFormat.class), new TextFormatConfigSerializer());
    }

    /**
     * An empty {@link TextFormat} with no {@link TextColor} and no {@link TextStyle}.
     */
    public static final TextFormat NONE = new TextFormat(TextColors.NONE, TextStyles.NONE);

    /**
     * The text color.
     */
    private final TextColor color;

    /**
     * The text style.
     */
    private final TextStyle style;

    /**
     * Gets the {@link TextFormat} with the default style and color.
     *
     * @return The empty text format
     */
    public static TextFormat of() {
        return NONE;
    }

    /**
     * Constructs a new {@link TextFormat} with the specific style.
     *
     * @param style The style
     * @return The new text format
     */
    public static TextFormat of(TextStyle style) {
        return new TextFormat(TextColors.NONE, style);
    }

    /**
     * Constructs a new {@link TextFormat} with the specific color.
     *
     * @param color The color
     * @return The new text format
     */
    public static TextFormat of(TextColor color) {
        return new TextFormat(color, TextStyles.NONE);
    }

    /**
     * Constructs a new {@link TextFormat} with the specific color and style.
     *
     * @param color The color
     * @param style The style
     * @return The new text format
     */
    public static TextFormat of(TextColor color, TextStyle style) {
        return new TextFormat(color, style);
    }

    /**
     * Constructs a new {@link TextFormat}.
     *
     * @param color The color
     * @param style The style
     */
    private TextFormat(TextColor color, TextStyle style) {
        this.color = checkNotNull(color, "color");
        this.style = checkNotNull(style, "style");
    }

    /**
     * Returns the {@link TextColor} in this format.
     *
     * @return The color
     */
    public TextColor getColor() {
        return this.color;
    }


    /**
     * Returns the {@link TextStyle} in this format.
     *
     * @return The style
     */
    public TextStyle getStyle() {
        return this.style;
    }

    /**
     * Returns a new {@link TextFormat} with the given color.
     *
     * @param color The color
     * @return The new text format
     */
    public TextFormat color(TextColor color) {
        return new TextFormat(color, this.style);
    }

    /**
     * Returns a new {@link TextFormat} with the given style.
     *
     * @param style The style
     * @return The new text format
     */
    public TextFormat style(TextStyle style) {
        return new TextFormat(this.color, style);
    }

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
    public TextFormat merge(TextFormat format) {
        TextColor color = format.color;
        // If the given format's color is NONE use this ones
        if (color == TextColors.NONE) {
            color = this.color;
            // If the given format's color is RESET use NONE
        } else if (color == TextColors.RESET) {
            color = TextColors.NONE;
        }
        return new TextFormat(color, this.style.and(format.style));
    }

    /**
     * Returns whether this {@link TextFormat} has no color and format
     * specified.
     *
     * @return If the format does not contain a color or any styles
     */
    public boolean isEmpty() {
        return this.color == TextColors.NONE && this.style.isEmpty();
    }

    @Override
    public void applyTo(Text.Builder builder) {
        builder.format(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TextFormat)) {
            return false;
        }

        TextFormat that = (TextFormat) o;
        return this.color.equals(that.color) && this.style.equals(that.style);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.color, this.style);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("color", this.color)
                .add("style", this.style)
                .toString();
    }

}
