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
     * Appends the specified {@link Message Messages} to the end of this
     * message.
     *
     * @param children The messages to append
     * @return This message builder
     */
    T append(Message... children);

    /**
     * Appends the specified {@link Message Messages} to the end of this
     * message.
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
     * Builds an immutable instance of the current state of this message
     * builder.
     *
     * @return An immutable {@link Message} with the current properties of this
     *         builder
     */
    Message build();

    /**
     * Represents a {@link MessageBuilder} creating immutable
     * {@link Message.Text} instances.
     */
    interface Text extends MessageBuilder<Text> {

        /**
         * Sets the text of this message.
         *
         * @param text The text of this message
         * @return This message builder
         */
        Text content(String text);

        @Override
        Message.Text build();
    }

    /**
     * Represents a {@link MessageBuilder} creating immutable
     * {@link Message.Translatable} instances.
     */
    interface Translatable extends MessageBuilder<Translatable> {

        /**
         * Sets the translation of this message.
         *
         * @param translation The translation to use for this message
         * @param args The arguments for the translation
         * @return This message builder
         */
        Translatable content(Translation translation, Object... args);

        /**
         * Sets the translation of this message.
         *
         * @param translatable The translatable object to use for this message
         * @param args The arguments for the translation
         * @return This message builder
         */
        Translatable content(org.spongepowered.api.text.translation.Translatable translatable, Object... args);

        @Override
        Message.Translatable build();

    }

    /**
     * Represents a {@link MessageBuilder} creating immutable
     * {@link Message.Selector} instances.
     */
    interface Selector extends MessageBuilder<Selector> {

        /**
         * Sets the selector of this message.
         *
         * @param selector The selector for this message to use
         * @return This message builder
         */
        Selector content(String selector);

        @Override
        Message.Selector build();

    }

    /**
     * Represents a {@link MessageBuilder} creating immutable
     * {@link Message.Score} instances.
     */
    interface Score extends MessageBuilder<Score> {

        /**
         * Sets the score of this message.
         *
         * @param score The score for this message to use
         * @return This message builder
         */
        Score content(Object score); // TODO

        /**
         * Overrides the real score and displays a custom text instead.
         *
         * @param override The text to override the score with
         * @return This message builder
         */
        Score override(@Nullable String override);

        @Override
        Message.Score build();

    }

}
