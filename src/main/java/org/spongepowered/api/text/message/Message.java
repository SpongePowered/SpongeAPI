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

import com.google.common.base.Optional;
import org.spongepowered.api.text.action.ClickAction;
import org.spongepowered.api.text.action.HoverAction;
import org.spongepowered.api.text.action.ShiftClickAction;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextStyle;
import org.spongepowered.api.text.translation.Translation;

import java.util.List;

/**
 * Represents an immutable instance of formatted text that can be displayed on
 * the client. Each instance consists of content and a list of children messages
 * appended after the content of this message. The content of the message is
 * available through one of the subinterfaces.
 * <p>
 * Messages are primarily used for sending formatted chat messages to players,
 * but also in other places like books or signs.
 * </p>
 * <p>
 * Message instances can be created using the {@link MessageBuilder} available
 * through one of the {@link Messages#builder()} methods.
 * </p>
 *
 * @see Messages#builder()
 * @see Message.Text
 * @see Translatable
 * @see Selector
 * @see Score
 */
public interface Message {

    /**
     * Returns the content of this {@link Message}.
     *
     * @return The content of this message
     */
    Object getContent();

    /**
     * Returns the color of this {@link Message}.
     *
     * @return The color of this message
     */
    TextColor getColor();

    /**
     * Returns the style of this {@link Message}. This will return a compound
     * {@link TextStyle} if multiple different styles have been set.
     *
     * @return The style of this message
     */
    TextStyle getStyle();

    /**
     * Returns the list of children appended after the content of this
     * {@link Message}.
     *
     * @return The list of children
     */
    List<Message> getChildren();

    /**
     * Returns an {@link Iterable} over this message and all of its children. This is
     * recursive, the children of the children will be also included.
     *
     * @return An iterable over this message and the children messages
     */
    Iterable<Message> withChildren();

    /**
     * Returns the {@link ClickAction} executed on the client when this
     * {@link Message} gets clicked.
     *
     * @return The click action of this message, or {@link Optional#absent()} if
     *         not set
     */
    Optional<ClickAction<?>> getClickAction();

    /**
     * Returns the {@link HoverAction} executed on the client when this
     * {@link Message} gets hovered.
     *
     * @return The hover action of this message, or {@link Optional#absent()} if
     *         not set
     */
    Optional<HoverAction<?>> getHoverAction();

    /**
     * Returns the {@link ShiftClickAction} executed on the client when this
     * {@link Message} gets shift-clicked.
     *
     * @return The shift-click action of this message, or
     *         {@link Optional#absent()} if not set
     */
    Optional<ShiftClickAction<?>> getShiftClickAction();

    /**
     * Returns a new {@link MessageBuilder} with the content of this message.
     * This can be used to edit an immutable {@link Message} instance.
     *
     * @return A new message builder with the content of this message
     */
    MessageBuilder builder();

    /**
     * Returns a representation of this {@link Message} using the legacy color codes.
     *
     * @return This message converted to the old color codes
     * @deprecated Legacy formatting codes are being phased out of Minecraft
     */
    @Deprecated
    String toLegacy();

    /**
     * Returns a representation of this {@link Message} using the legacy color codes.
     *
     * @param code The legacy char to use for the message
     * @return This message converted to the old color codes
     * @deprecated Legacy formatting codes are being phased out of Minecraft
     */
    @Deprecated
    String toLegacy(char code);

    /**
     * Represents a {@link Message} containing a plain text {@link String}.
     */
    interface Text extends Message {

        /**
         * Returns the plain text content of this {@link Message}.
         *
         * @return The content of this message
         */
        @Override
        String getContent();

        @Override
        MessageBuilder.Text builder();

    }

    /**
     * Represents a {@link Message} containing a {@link Translation} identifier
     * that gets translated into the current locale on the client.
     */
    interface Translatable extends Message {

        /**
         * Returns the translation of this {@link Message}.
         *
         * @return The translation of this message
         */
        @Override
        Translation getContent();

        /**
         * Returns the list of {@link Translation} arguments used to format this
         * {@link Message}.
         *
         * @return The list of translation arguments
         */
        List<Object> getArguments();

        @Override
        MessageBuilder.Translatable builder();

    }

    /**
     * Represents a {@link Message} containing a selector that will be replaced
     * by the names of the matching entities on the client.
     *
     * @see <a
     *      href="http://minecraft.gamepedia.com/Commands#Target_selectors">Selectors
     *      on the Minecraft Wiki</a>
     */
    interface Selector extends Message {

        // TODO use Selector

        /**
         * Returns the selector used in this {@link Message}.
         *
         * @return The selector of this message
         */
        @Override
        String getContent();

        @Override
        MessageBuilder.Selector builder();
    }

    /**
     * Represents a {@link Message} displaying the current player's score in an
     * objective.
     */
    interface Score extends Message {

        // TODO use Score

        /**
         * Returns the score displayed by this {@link Message}.
         *
         * @return The score in this message
         */
        @Override
        Object getContent();

        /**
         * Returns a value that is displayed instead of the real score.
         *
         * @return The value displayed instead of the real score, or
         *         {@link Optional#absent()} if the real score will be displayed
         *         instead
         */
        Optional<String> getOverride();

        @Override
        MessageBuilder.Score builder();
    }

}
