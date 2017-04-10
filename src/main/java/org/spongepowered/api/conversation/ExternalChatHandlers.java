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
package org.spongepowered.api.conversation;

import org.spongepowered.api.text.Text;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * The main external chat handlers you would need.
 */
public final class ExternalChatHandlers {

    private static final ExternalChatHandler letThrough = new LetThroughExternalChatHandler();
    private static final ExternalChatHandler deleteAll = new DeleteAllExternalChatHandler();

    private ExternalChatHandlers() {

    }

    /**
     * Creates an external chat handler which lets through all messages so
     * the {@link Conversant} sees all the messages even within the conversation.
     *
     * @return An external chat handler which lets through all messages
     */
    public static ExternalChatHandler letThrough() {
        return letThrough;
    }

    /**
     * Creates an external chat handler which deletes all incoming messages so
     * the {@link Conversant} never sees them.
     *
     * <p>This is the default external chat handler generally.</p>
     *
     * @return An external chat handler which deletes all incoming messages
     */
    public static ExternalChatHandler deleteAll() {
        return deleteAll;
    }

    /**
     * Creates an external chat handler which stores all incoming messages going
     * to the {@link Conversant} and sends them once the conversation is finished.
     *
     * @return An external chat handler which sends messages on conversation
     *     completion
     */
    public static ExternalChatHandler sendOnFinish() {
        return new SendOnFinishChatHandler();
    }

    /**
     * An external chat handler which lets through all messages so the
     * {@link Conversant} sees all the messages even within the conversation.
     */
    private static class LetThroughExternalChatHandler implements ExternalChatHandler {

        @Override
        public boolean process(Text text) {
            return true;
        }

        @Override
        public void finish(Conversant conversant) {}

    }

    /**
     * An external chat handler which deletes all incoming messages so the
     * {@link Conversant} never sees them.
     */
    private static class DeleteAllExternalChatHandler implements ExternalChatHandler {

        @Override
        public boolean process(Text text) {
            return false;
        }

        @Override
        public void finish(Conversant conversant) {}

    }

    /**
     * An external chat handler which stores all incoming messages going to the
     * {@link Conversant} and sends them once the conversation is finished.
     */
    private static class SendOnFinishChatHandler implements ExternalChatHandler {

        private final Queue<Text> messages = new ArrayDeque<>();

        @Override
        public boolean process(Text text) {
            this.messages.offer(text);
            return false;
        }

        @Override
        public void finish(Conversant conversant) {
            this.messages.forEach(conversant::sendMessage);
        }

    }

}
