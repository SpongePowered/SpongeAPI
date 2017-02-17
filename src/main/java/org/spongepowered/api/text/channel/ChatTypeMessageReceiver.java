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
package org.spongepowered.api.text.channel;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextElement;
import org.spongepowered.api.text.TextTemplate;
import org.spongepowered.api.text.chat.ChatType;

import java.util.Map;

/**
 * Represents something that can receive messages of certain types.
 */
@FunctionalInterface
public interface ChatTypeMessageReceiver {

    /**
     * Sends a message with the specified {@link ChatType} to this receiver.
     *
     * <p>If text formatting is not supported in the implementation
     * it will be displayed as plain text.</p>
     *
     * @param type The chat type to send the messages to
     * @param message The message to send
     */
    void sendMessage(ChatType type, Text message);

    /**
     * Sends a message constructed from the {@link TextTemplate} with the
     * specified {@link ChatType} to this receiver.
     *
     * <p>If text formatting is not supported in the implementation
     * it will be displayed as plain text.</p>
     *
     * @param type The chat type to send the messages to
     * @param template The text template
     */
    default void sendMessage(ChatType type, TextTemplate template) {
        this.sendMessage(type, checkNotNull(template, "template").apply().build());
    }

    /**
     * Sends a message constructed from the {@link TextTemplate} and
     * {@code parameters} with the specified {@link ChatType} to this receiver.
     *
     * <p>If text formatting is not supported in the implementation
     * it will be displayed as plain text.</p>
     *
     * @param type The chat type to send the messages to
     * @param template The text template
     * @param parameters The parameters to apply to the template
     */
    default void sendMessage(ChatType type, TextTemplate template, Map<String, TextElement> parameters) {
        this.sendMessage(type, checkNotNull(template, "template").apply(parameters).build());
    }

    /**
     * Sends the message(s) with the specified {@link ChatType} to this receiver.
     *
     * <p>If text formatting is not supported in the implementation
     * it will be displayed as plain text.</p>
     *
     * @param type The chat type to send the messages to
     * @param messages The message(s) to send
     */
    default void sendMessages(ChatType type, Text... messages) {
        checkNotNull(type, "type");

        for (Text message : checkNotNull(messages, "messages")) {
            this.sendMessage(type, message);
        }
    }

    /**
     * Sends the message(s) with the specified {@link ChatType} to this receiver.
     *
     * <p>If text formatting is not supported in the implementation
     * it will be displayed as plain text.</p>
     *
     * @param type The chat type to send the messages to
     * @param messages The message(s) to send
     */
    default void sendMessages(ChatType type, Iterable<Text> messages) {
        checkNotNull(type, "type");

        for (Text message : checkNotNull(messages, "messages")) {
            this.sendMessage(type, message);
        }
    }

}
