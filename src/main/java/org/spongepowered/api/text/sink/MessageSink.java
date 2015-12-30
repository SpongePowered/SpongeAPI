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
package org.spongepowered.api.text.sink;

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.text.Text;

/**
 * Represents a function that takes a message and transforms it for distribution
 * to the given targets.
 */
public abstract class MessageSink {

    /**
     * Process a message using this sink, transforming and sending it to the
     * appropriate recipients.
     *
     * @param text The text to send
     */
    public final void sendMessage(Text text) {
        for (CommandSource recipient : getRecipients()) {
            Text transformed = transformMessage(recipient, text);
            recipient.sendMessage(transformed == null ? text : transformed);
        }
    }

    /**
     * Handle transforming the input message appropriately.
     *
     * @param target The target to transform the message for
     * @param text The message to send
     * @return The transformed text. May be input.
     */
    public Text transformMessage(CommandSource target, Text text) {
        return text;
    }

    /**
     * Return all command sources that will receive messages sent through to
     * this sink.
     *
     * @return An iterable of all possible receivers of messages
     */
    public abstract Iterable<CommandSource> getRecipients();

}
