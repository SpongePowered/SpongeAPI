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

import java.util.EventObject;

public class ConversationAbandonedEvent extends EventObject {

    private ConversationContext context;
    private ConversationCanceller canceller;

    public ConversationAbandonedEvent(Conversation conversation) {
        this(conversation, null);
    }

    public ConversationAbandonedEvent(Conversation conversation, ConversationCanceller canceller) {
        super(conversation);
        this.context = conversation.getContext();
        this.canceller = canceller;
    }

    /**
     * Gets the object that caused the conversation to be abandoned.
     *
     * @return The object that abandoned the conversation.
     */
    public ConversationCanceller getCanceller() {
        return canceller;
    }

    /**
     * Gets the abandoned conversation's conversation context.
     *
     * @return The abandoned conversation's conversation context.
     */
    public ConversationContext getContext() {
        return context;
    }

    /**
     * Indicates how the conversation was abandoned - naturally as part of the
     * prompt chain or prematurely via a {@link ConversationCanceller}.
     *
     * @return True if the conversation is abandoned gracefully by a {@link
     *     Prompt} returning null or the next prompt. False of the
     *     conversations is abandoned prematurely by a ConversationCanceller.
     */
    public boolean gracefulExit() {
        return canceller == null;
    }
}
