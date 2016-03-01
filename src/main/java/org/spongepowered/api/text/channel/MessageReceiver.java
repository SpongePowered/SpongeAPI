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

import java.util.Map;

/**
 * Represents something that can receive (and send) messages.
 */
public interface MessageReceiver {

    /**
     * Sends the formatted text message to source when possible. If text formatting
     * is not supported in the implementation it will be displayed as plain text.
     *
     * @param message The message
     */
    void sendMessage(Text message);

    /**
     * Sends the formatted text message(s) to source when possible. If text formatting
     * is not supported in the implementation it will be displayed as plain text.
     *
     * @param messages The message(s)
     */
    default void sendMessages(Text... messages) {
        checkNotNull(messages, "messages");

        for (Text message : messages) {
            this.sendMessage(message);
        }
    }

    /**
     * Sends the formatted text message(s) to source when possible. If text formatting
     * is not supported in the implementation it will be displayed as plain text.
     *
     * @param messages The messages
     */
    default void sendMessages(Iterable<Text> messages) {
        for (Text message : checkNotNull(messages, "messages")) {
            this.sendMessage(message);
        }
    }

    /**
     * Sends the result of the specified {@link TextTemplate} with the
     * specified parameters to the receiver.
     *
     * @param template TextTemplate to apply
     * @param params Parameters to apply to template
     */
    default void sendMessage(TextTemplate template, Map<String, TextElement> params) {
        this.sendMessage(template.apply(params).build());
    }

    /**
     * Sends the result of the specified {@link TextTemplate} with an empty
     * parameter map.
     *
     * @param template TextTemplate to apply
     */
    default void sendMessage(TextTemplate template) {
        this.sendMessage(template.apply().build());
    }

    /**
     * Return the message channel that messages from this source should be sent to.
     *
     * @return This source's active message channel
     */
    MessageChannel getMessageChannel();

    /**
     * Set the message channel that messages sent by this source should be sent to.
     *
     * @param channel The message channel to send messages to
     */
    void setMessageChannel(MessageChannel channel);

}
