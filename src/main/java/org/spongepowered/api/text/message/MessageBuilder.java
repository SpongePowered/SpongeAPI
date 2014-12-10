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
package org.spongepowered.api.text.message;

import org.spongepowered.api.text.action.ClickAction;
import org.spongepowered.api.text.action.HoverAction;
import org.spongepowered.api.text.action.ShiftClickAction;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextStyle;
import org.spongepowered.api.text.translation.Translation;

import javax.annotation.Nullable;

/**
 * Represents a builder interface to create immutable {@link Message} instances.
 *
 * @param <T> The type of the message builder
 */
public interface MessageBuilder<T extends MessageBuilder<T>> {

    /**
     * Sets the contents of this message.
     *
     * @param content The content of the message.
     * @return This message builder
     */
    T content(Object content);

    /**
     * Appends the specified messages to the end of this message.
     *
     * @param children The messages to append
     * @return This message builder
     */
    T append(Message... children);

    /**
     * Appends the specified messages to the end of this message.
     *
     * @param children The messages to append
     * @return This message builder
     */
    T append(Iterable<Message> children);

    /**
     * Sets the {@link TextColor} of this message.
     *
     * @param color The new text color for this message
     * @return This message builder
     */
    T color(@Nullable TextColor color);

    /**
     * Sets the text styles of this message. This will construct a composite
     * {@link TextStyle} of the current style and the specified styles first and
     * set it to the message.
     *
     * @param styles The text styles to apply
     * @return This message builder
     */
    T style(TextStyle... styles);

    /**
     * Sets the {@link ClickAction} that will be executed if this message is
     * clicked in the chat.
     *
     * @param action The new click action for this message
     * @return This message builder
     */
    T onClick(@Nullable ClickAction<?> action);

    /**
     * Sets the {@link HoverAction} that will be executed if this message is
     * hovered in the chat.
     *
     * @param action The new hover action for this message
     * @return This message builder
     */
    T onHover(@Nullable HoverAction<?> action);

    /**
     * Sets the {@link ShiftClickAction} that will be executed if this message
     * is shift-clicked in the chat.
     *
     * @param action The new shift click action for this message
     * @return This message builder
     */
    T onShiftClick(@Nullable ShiftClickAction<?> action);

    /**
     * Builds an immutable instance of the current message.
     *
     * @return An immutable {@link Message} with the current properties of this
     *         builder
     */
    Message build();

    /**
     * A MessageBuilder that can build Text messages.
     */
    interface Text extends MessageBuilder<Text> {

        /**
         * Sets the content of this message.
         *
         * @param content The content of this message as a String
         * @return This message builder
         */
        Text content(String content);

        /**
         * {@inheritDoc}
         */
        @Override
        Message.Text build();
    }

    /**
     * A MessageBuilder that can build Translatable messages.
     */
    interface Translatable extends MessageBuilder<Translatable> {

        /**
         * Sets the content of this message.
         *
         * @param content The content of this message as a Translation
         * @param args The arguments to the translation
         * @return This message builder
         */
        Translatable content(Translation content, Object... args);

        /**
         * Sets the content of this message.
         *
         * @param content The content of this message as a Translation
         * @param args The arguments to the translation
         * @return This message builder
         */
        Translatable content(org.spongepowered.api.text.translation.Translatable content, Object... args);

        /**
         * {@inheritDoc}
         */
        @Override
        Message.Translatable build();

    }

    /**
     * A MessageBuilder that can build Selector messages.
     */
    interface Selector extends MessageBuilder<Selector> {

        /**
         * Sets the content of this message.
         *
         * @param content The content of this message as a Selector
         * @return This message builder
         */
        Selector content(String content);

        /**
         * {@inheritDoc}
         */
        @Override
        Message.Selector build();

    }

    /**
     * A MessageBuilder that can build Score messages.
     */
    interface Score extends MessageBuilder<Score> {

        /**
         * Sets the score of this message.
         *
         * @param content The content of the message as a Score.
         * @return This message builder
         */
        Score content(Object content); // TODO

        /**
         * Sets the override to the score in this message.
         *
         * @param override The override of the score
         * @return This message builder
         */
        Score override(@Nullable String override);

        /**
         * {@inheritDoc}
         */
        @Override
        Message.Score build();

    }

}
