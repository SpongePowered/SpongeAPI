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

import org.spongepowered.api.text.action.ClickAction;
import org.spongepowered.api.text.action.HoverAction;
import org.spongepowered.api.text.action.ShiftClickAction;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextStyle;
import org.spongepowered.api.text.translation.Translation;

import javax.annotation.Nullable;

/**
 * Represents a builder interface to create immutable {@link Text} instances.
 */
public interface TextBuilder {

    /**
     * Sets the {@link TextColor} of this message.
     *
     * @param color The new text color for this message
     * @return This message builder
     */
    TextBuilder color(TextColor color);

    /**
     * Sets the text styles of this message. This will construct a composite
     * {@link TextStyle} of the current style and the specified styles first and
     * set it to the message.
     *
     * @param styles The text styles to apply
     * @return This message builder
     */
    TextBuilder style(TextStyle... styles);

    /**
     * Sets the {@link ClickAction} that will be executed if this message is
     * clicked in the chat.
     *
     * @param action The new click action for this message
     * @return This message builder
     */
    TextBuilder onClick(@Nullable ClickAction<?> action);

    /**
     * Sets the {@link HoverAction} that will be executed if this message is
     * hovered in the chat.
     *
     * @param action The new hover action for this message
     * @return This message builder
     */
    TextBuilder onHover(@Nullable HoverAction<?> action);

    /**
     * Sets the {@link ShiftClickAction} that will be executed if this message
     * is shift-clicked in the chat.
     *
     * @param action The new shift click action for this message
     * @return This message builder
     */
    TextBuilder onShiftClick(@Nullable ShiftClickAction<?> action);

    /**
     * Appends the specified {@link Text Messages} to the end of this
     * message.
     *
     * @param children The messages to append
     * @return This message builder
     */
    TextBuilder append(Text... children);

    /**
     * Appends the specified {@link Text Messages} to the end of this
     * message.
     *
     * @param children The messages to append
     * @return This message builder
     */
    TextBuilder append(Iterable<Text> children);

    TextBuilder remove(Text... children);

    TextBuilder remove(Iterable<Text> children);

    TextBuilder removeAll();

    /**
     * Builds an immutable instance of the current state of this message
     * builder.
     *
     * @return An immutable {@link Text} with the current properties of this
     *         builder
     */
    Text build();

    /**
     * Represents a {@link TextBuilder} creating immutable
     * {@link Text.Literal} instances.
     */
    interface Literal extends TextBuilder {

        /**
         * Sets the text of this message.
         *
         * @param text The text of this message
         * @return This message builder
         */
        Literal literal(String text);

        @Override
        Literal color(@Nullable TextColor color);

        @Override
        Literal style(TextStyle... styles);

        @Override
        Literal onClick(@Nullable ClickAction<?> action);

        @Override
        Literal onHover(@Nullable HoverAction<?> action);

        @Override
        Literal onShiftClick(@Nullable ShiftClickAction<?> action);

        @Override
        Literal append(Text... children);

        @Override
        Literal append(Iterable<Text> children);

        @Override
        Literal remove(Text... children);

        @Override
        Literal remove(Iterable<Text> children);

        @Override
        Literal removeAll();

        @Override
        Text.Literal build();
    }

    /**
     * Represents a {@link TextBuilder} creating immutable
     * {@link Text.Translatable} instances.
     */
    interface Translatable extends TextBuilder {

        /**
         * Sets the translation of this message.
         *
         * @param translation The translation to use for this message
         * @param args The arguments for the translation
         * @return This message builder
         */
        Translatable translation(Translation translation, Object... args);

        /**
         * Sets the translation of this message.
         *
         * @param translatable The translatable object to use for this message
         * @param args The arguments for the translation
         * @return This message builder
         */
        Translatable translation(org.spongepowered.api.text.translation.Translatable translatable, Object... args);

        @Override
        Translatable color(@Nullable TextColor color);

        @Override
        Translatable style(TextStyle... styles);

        @Override
        Translatable onClick(@Nullable ClickAction<?> action);

        @Override
        Translatable onHover(@Nullable HoverAction<?> action);

        @Override
        Translatable onShiftClick(@Nullable ShiftClickAction<?> action);

        @Override
        Translatable append(Text... children);

        @Override
        Translatable append(Iterable<Text> children);

        @Override
        Translatable remove(Text... children);

        @Override
        Translatable remove(Iterable<Text> children);

        @Override
        Translatable removeAll();

        @Override
        Text.Translatable build();
    }

    /**
     * Represents a {@link TextBuilder} creating immutable
     * {@link Text.Selector} instances.
     */
    interface Selector extends TextBuilder {

        /**
         * Sets the selector of this message.
         *
         * @param selector The selector for this message to use
         * @return This message builder
         */
        Selector selector(org.spongepowered.api.text.selector.Selector selector);

        @Override
        Selector color(@Nullable TextColor color);

        @Override
        Selector style(TextStyle... styles);

        @Override
        Selector onClick(@Nullable ClickAction<?> action);

        @Override
        Selector onHover(@Nullable HoverAction<?> action);

        @Override
        Selector onShiftClick(@Nullable ShiftClickAction<?> action);

        @Override
        Selector append(Text... children);

        @Override
        Selector append(Iterable<Text> children);

        @Override
        Selector remove(Text... children);

        @Override
        Selector remove(Iterable<Text> children);

        @Override
        Selector removeAll();

        @Override
        Text.Selector build();
    }

    /**
     * Represents a {@link TextBuilder} creating immutable
     * {@link Text.Score} instances.
     */
    interface Score extends TextBuilder {

        /**
         * Sets the score of this message.
         *
         * @param score The score for this message to use
         * @return This message builder
         */
        Score score(Object score); // TODO

        /**
         * Overrides the real score and displays a custom text instead.
         *
         * @param override The text to override the score with
         * @return This message builder
         */
        Score override(@Nullable String override);

        @Override
        Score color(@Nullable TextColor color);

        @Override
        Score style(TextStyle... styles);

        @Override
        Score onClick(@Nullable ClickAction<?> action);

        @Override
        Score onHover(@Nullable HoverAction<?> action);

        @Override
        Score onShiftClick(@Nullable ShiftClickAction<?> action);

        @Override
        Score append(Text... children);

        @Override
        Score append(Iterable<Text> children);

        @Override
        Score remove(Text... children);

        @Override
        Score remove(Iterable<Text> children);

        @Override
        Score removeAll();

        @Override
        Text.Score build();
    }

}
