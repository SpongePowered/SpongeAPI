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

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.action.ClickAction;
import org.spongepowered.api.text.action.HoverAction;
import org.spongepowered.api.text.action.ShiftClickAction;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextFormat;
import org.spongepowered.api.text.format.TextStyle;
import org.spongepowered.api.text.translation.Translation;

import java.util.Collection;
import java.util.Iterator;

import javax.annotation.Nullable;

/**
 * Represents a {@link Text} containing a {@link Translation} identifier that
 * gets translated into the current locale on the client.
 *
 * @see Builder
 */
public interface TranslatableText extends Text {

    /**
     * Creates a {@link Builder}.
     *
     * @return A new text builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Returns the translation of this {@link Text}.
     *
     * @return The translation of this text
     */
    Translation getTranslation();

    /**
     * Returns the list of {@link Translation} arguments used to format this
     * {@link Text}.
     *
     * @return The list of translation arguments
     */
    ImmutableList<Object> getArguments();

    @Override
    Builder toBuilder();

    /**
     * Represents a {@link Text.Builder} creating immutable
     * {@link TranslatableText} instances.
     *
     * @see TranslatableText
     */
    interface Builder extends Text.Builder {

        /**
         * Returns the current translation of this builder.
         *
         * @return The current content
         * @see TranslatableText#getTranslation()
         */
        Translation getTranslation();

        /**
         * Returns the current translation arguments of this builder.
         *
         * @return The current translation arguments
         * @see TranslatableText#getArguments()
         */
        ImmutableList<Object> getArguments();

        /**
         * Sets the translation of the text.
         *
         * @param translation The translation to use for this builder
         * @param args The arguments for the translation
         * @return This text builder
         */
        Builder translation(Translation translation, Object... args);

        /**
         * Sets the translation of the text.
         *
         * @param translatable The translatable object to use for this builder
         * @param args The arguments for the translation
         * @return This text builder
         */
        Builder translation(org.spongepowered.api.text.translation.Translatable translatable, Object... args);

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
        TranslatableText build();

        @Override
        Builder from(Text value);
    }
}
