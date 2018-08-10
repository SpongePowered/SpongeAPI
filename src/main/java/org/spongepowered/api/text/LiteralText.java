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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.action.ClickAction;
import org.spongepowered.api.text.action.HoverAction;
import org.spongepowered.api.text.action.ShiftClickAction;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextFormat;
import org.spongepowered.api.text.format.TextStyle;

import java.util.Collection;
import java.util.Iterator;

import javax.annotation.Nullable;

/**
 * Represents a {@link Text} containing a plain text {@link String}.
 *
 * @see Builder
 */
public interface LiteralText extends Text {

    /**
     * Creates a {@link Builder} with empty text.
     *
     * @return A new text builder with empty text
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Returns the plain text content of this {@link Text}.
     *
     * @return The content of this text
     */
    String getContent();

    @Override
    Builder toBuilder();

    /**
     * Represents a {@link Text.Builder} creating immutable {@link LiteralText}
     * instances.
     *
     * @see LiteralText
     */
    interface Builder extends Text.Builder {

        /**
         * Returns the current content of this builder.
         *
         * @return The current content
         * @see LiteralText#getContent()
         */
        String getContent();

        /**
         * Sets the plain text content of this text.
         *
         * @param content The content of this text
         * @return This text builder
         * @see LiteralText#getContent()
         */
        Builder content(String content);

        /**
         * Sets the plain text content of this text to a new line character.
         *
         * @return This text builder
         * @see #content(String)
         */
        default Builder newLine() {
            return this.content("\n");
        }

        @Override
        Builder format(TextFormat format);

        @Override
        Builder color(TextColor color);

        @Override
        Builder style(TextStyle... styles);

        @Override
        Builder onClick(@Nullable ClickAction<?> clickAction);

        @Override
        Builder onHover(@Nullable HoverAction<?> hoverAction);

        @Override
        Builder onShiftClick(@Nullable ShiftClickAction<?> shiftClickAction);

        @Override
        Builder append(Text... children);

        @Override
        Builder append(Collection<? extends Text> children);

        @Override
        Builder append(Iterable<? extends Text> children);

        @Override
        Builder append(Iterator<? extends Text> children);

        @Override
        Builder insert(int pos, Text... children);

        @Override
        Builder insert(int pos, Collection<? extends Text> children);

        @Override
        Builder insert(int pos, Iterable<? extends Text> children);

        @Override
        Builder insert(int pos, Iterator<? extends Text> children);

        @Override
        Builder remove(Text... children);

        @Override
        Builder remove(Collection<? extends Text> children);

        @Override
        Builder remove(Iterable<? extends Text> children);

        @Override
        Builder remove(Iterator<? extends Text> children);

        @Override
        Builder removeAll();

        @Override
        Builder from(Text value);

        @Override
        LiteralText build();
    }
}
