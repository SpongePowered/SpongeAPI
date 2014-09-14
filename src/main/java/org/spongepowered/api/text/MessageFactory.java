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

import org.spongepowered.api.entity.Player;

/**
 * Factory for creating new chat related objects.
 */
public interface MessageFactory {

    /**
     * Creates a new {@link TextMessage} using the given text. Automatically
     * converts messages using section sign to use a {@link TextStyle}.
     *
     * @param text Contents of the message
     * @return New text message
     */
    TextMessage newTextMessage(String text);

    /**
     * Creates a new translatable {@link TextMessage}.
     * 
     * @param translate The translate string
     * @return New translated message
     */
    TextMessage newTranslatedMessage(String translate);

    /**
     * Creates a new {@link TextMessage} for showing a score.
     * TODO: Create Objective class.
     * 
     * @param player The player
     * @param objective The objective name
     * @return New score message
     */
    TextMessage newScoreMessage(Player player, String objective);

    /**
     * Creates a new {@link TextMessage} using a selector.</br>
     * <p>Ex. <code>@p, @a[team="red"], @e, @r[r=50] </code></p>
     * TODO: Make a class for selectors and arguments
     * 
     * @param selector Selector string
     * @return New selector message
     */
    TextMessage newSelectorMessage(String selector);

    /**
     * Translates the raw text into a {@link TextMessage}.
     * 
     * @param json Json string representing a message.
     * @return The new message.
     */
    TextMessage newMessageFromJson(String json);

    /**
     * Creates a new {@link MessageBuilder}.
     * 
     * @return A new message builder
     */
    MessageBuilder newBuilder();

    /**
     * Creates a new {@link MessageBuilder} with the parameters as a base.
     * 
     * @param text Starting text
     * @param formatting The formatting
     * @return A new message builder
     */
    MessageBuilder newBuilder(String text, TextFormatting... formatting);

    /**
     * Creates a new blank {@link TextStyle}.
     *
     * @return New style
     */
    TextStyle newStyle();

    /**
     * Creates a new {@link TextClientEvent}.
     *
     * @param action The action to perform
     * @param value The value of the event
     * @param type The type of action
     * @return New client event
     */
    TextClientEvent newClientEvent(TextAction action, String value, TextClientEvent.ActionType type);
}
