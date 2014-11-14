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

import com.google.common.base.Optional;
import org.spongepowered.api.text.action.ClickAction;
import org.spongepowered.api.text.action.HoverAction;
import org.spongepowered.api.text.action.ShiftClickAction;
import org.spongepowered.api.text.format.TextStyle;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.translation.Translation;

import java.util.List;

/**
 * A Message represents some text in the new raw JSON message format.
 * Message is an immutable class that is created by a {@link org.spongepowered.api.text.MessageBuilder},
 * and each getter method maps to a field or some fields in JSON.
 * Message is also an Iterable whose iterator iterates over its children, children's children, etc. recursively.
 *
 * <p>Among other places, it shows up in books, signs, titles, chat, and the /tellraw command.</p>
 *
 * @param <T> The type of this Message's content
 */
public interface Message<T> extends Iterable<Message<T>> {

    /**
     * Returns the main content of this Message.
     * This maps to the text, translation, selector, or score field in JSON depending on the type of Message.
     *
     * @return The content of this Message
     */
    T getContent();

    /**
     * Returns the color of this Message.
     * This maps to the color field in JSON.
     *
     * @return The color of this Message
     */
    TextColor getColor();

    /**
     * Returns the style of this Message.
     * Depending on which styles are contained, this method maps to the various style fields in JSON.
     *
     * @return The style of this Message
     */
    TextStyle getStyle();

    /**
     * Returns the children of this Message.
     * This maps to the with or extra fields in JSON depending on this Message type.
     *
     * @return This Message's children
     */
    List<Message<?>> getChildren();

    /**
     * Returns the insertion of this Message.
     * In Minecraft, this is what gets inserted into the chat prompt when the text is shift-clicked.
     * This maps to the insertion field in JSON.
     *
     * @return The insertion text of this Message
     */
    Optional<String> getInsertion();

    /**
     * Returns the action for when this text is clicked.
     * This maps to the clickEvent field in JSON.
     *
     * @return The ClickAction of this Message
     */
    Optional<ClickAction<?>> getClickAction();

    /**
     * Returns the action for when this text is hovered over.
     * This maps to the hoverEvent field in JSON.
     *
     * @return The HoverAction of this Message
     */
    Optional<HoverAction<?>> getHoverAction();

    /**
     * Returns the action for when this text is shift-clicked.
     * This maps to the insertion field in JSON, because that is the only possible shift-click action.
     *
     * @return The ShiftClickAction of this Message
     */
    Optional<ShiftClickAction<?>> getShiftClickAction();

    /**
     * A Text Message is a message with a String as content.
     * In JSON, the content getter maps to the text field.
     */
    interface Text extends Message<String> { }

    /**
     * A Translatable Message is a message with a Translation as content.
     * Whatever locale the client is using translates this message using the translation identifier.
     * In JSON, the content getter maps to the translation identifier.
     */
    interface Translatable extends Message<Translation> { }


    /**
     * A Selector Message is a message with a Selector as content.
     * Whatever the selector matches becomes the text of this Message.
     * In JSON, the content getter maps to the translation field.
     */
    interface Selector extends Message<String> {
        // TODO use Selector
    }

    /**
     * A Score Message is a message with a Score as content.
     * this Message does not appear, but changes the score for some objective on the client-side.
     * It can be overriden.
     * In JSON, the content getter maps to the score field.
     */
    interface Score extends Message<Object> {
        // TODO use Score

        Optional<String> getOverride();

    }

}
