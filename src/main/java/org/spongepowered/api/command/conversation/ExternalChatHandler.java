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
package org.spongepowered.api.command.conversation;

import org.spongepowered.api.text.Text;

import java.util.function.Consumer;

/**
 * Each {@link Conversant} has one of these to handle the chat messages being
 * sent to them.
 */
public interface ExternalChatHandler extends Consumer<Text> {

    /**
     * Gets the type of this chat handler.
     *
     * @return This chat handler's type
     */
    ExternalChatHandlerType getType();

    /**
     * Processes the specified incoming text for this {@link Conversation}.
     * Returns whether or not to send the message normally.
     *
     * @param text The text to process
     * @return Whether or not to send the message normally to the player
     */
    boolean process(Text text);

    /**
     * Notify this handler that the conversation has come to an end.
     */
    void finish();

    /**
     * Drains all messages to the {@link ExternalChatHandler} the
     * {@link Conversant} is being switched to.
     *
     * <p>Can also choose to not send these to the consumer, instead
     * process them however they'd like.</p>
     *
     * @param consumer The consumer for the messages, generally the new
     *     {@link ExternalChatHandler}
     */
    void drainTo(Consumer<Text> consumer);

    /**
     * Accepts the incoming text from a previous {@link ExternalChatHandler}.
     *
     * <p>Implementations should override to provide their desired
     * functionality if this does not match.</p>
     *
     * @param text The text to add/process
     */
    @Override
    default void accept(Text text) {
        process(text);
    }

}
