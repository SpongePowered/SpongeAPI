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
package org.spongepowered.api.text.dialogue;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

/**
 * Contains several commonly used {@link DialogueChatHandler}s.
 */
public class DialogueChatHandlers {

    private DialogueChatHandlers() {} //nope

    /**
     * Creates a new {@link DialogueChatHandler} to discard all messages.
     *
     * @return The new handler
     */
    public static DialogueChatHandler discardAll() {
        return new DiscardAllChatHandler();
    }

    /**
     * Creates a new {@link DialogueChatHandler} to queue all messages, and
     * send them all at the {@link Dialogue}'s conclusion.
     *
     * @return The new handler
     */
    public static DialogueChatHandler queue() {
        return new QueueingChatHandler();
    }

    /**
     * Creates a new {@link DialogueChatHandler} to queue all messages up to a
     * specified maximum, and send them all at the {@link Dialogue}'s
     * conclusion.
     *
     * @param max The maximum number of messages to queue
     * @return The new handler
     */
    public static DialogueChatHandler queue(int max) {
        checkArgument(max > 0, "max must be greater than 0");
        return new QueueingChatHandler(max);
    }

    public static class DiscardAllChatHandler implements DialogueChatHandler {

        @Override
        public boolean process(Dialogue dialogue, ChatDetails details) {
            return false;
        }

        @Override
        public void notifyEnd(Dialogue dialogue) {}

    }

    public static class QueueingChatHandler implements DialogueChatHandler {

        protected final ListMultimap<Dialogue, ChatDetails> map = ArrayListMultimap.create();
        protected final int max;
        protected final boolean hasLimit;

        public QueueingChatHandler() {
            this.max = 0;
            this.hasLimit = false;
        }

        public QueueingChatHandler(int max) {
            this.max = max;
            this.hasLimit = true;
        }

        @Override
        public boolean process(Dialogue dialogue, ChatDetails details) {
            if (this.hasLimit && this.map.get(dialogue).size() > this.max) {
                this.map.get(dialogue).remove(0);
            }
            this.map.put(dialogue, details);
            return false;
        }

        @Override
        public void notifyEnd(Dialogue dialogue) {
            this.map.removeAll(dialogue).forEach(details -> details.getChannel().send(details.getSender().orElse(null), details.getMessage(),
                    details.getType()));
        }

    }

}
