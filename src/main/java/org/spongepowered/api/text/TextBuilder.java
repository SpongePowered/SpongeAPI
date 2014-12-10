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
import org.spongepowered.api.text.translation.Translatable;
import org.spongepowered.api.text.translation.Translation;

import javax.annotation.Nullable;

/**
 * Represents a builder interface to create immutable {@link Text} instances.
 *
 * @param <T> The type of the text builder
 */
public interface TextBuilder<T extends TextBuilder<T>> {

    /**
     * Appends the specified messages to the end of this message.
     *
     * @param children The messages to append
     * @return This message builder
     */
    T append(Text... children);

    /**
     * Appends the specified messages to the end of this message.
     *
     * @param children The messages to append
     * @return This message builder
     */
    T append(Iterable<Text> children);

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
     * @return An immutable {@link Text} with the current properties of this
     *         builder
     */
    Text build();

    interface Plain extends TextBuilder<Plain> {
        Plain text(String text);

        @Override
        Text.Plain build();
    }

    interface Translatable extends TextBuilder<Translatable> {
        Translatable translation(Translation translation, Object... args);
        Translatable translation(org.spongepowered.api.text.translation.Translatable translatable, Object... args);

        @Override
        Text.Translatable build();
    }

    interface Selector extends TextBuilder<Selector> {
        Selector selector(String selector);

        @Override
        Text.Selector build();
    }

    interface Score extends TextBuilder<Score> {
        Score score(Object score); // TODO
        Score override(@Nullable String override);

        @Override
        Text.Score build();
    }

}
