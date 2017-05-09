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
package org.spongepowered.api.event.conversation;

import org.spongepowered.api.command.conversation.Conversation;
import org.spongepowered.api.event.Cancellable;

/**
 * An event called when a conversation is either ending or has already ended.
 *
 * <p>It is highly recommended to utilize the event's sub-interfaces rather
 * as that is how you will know if the event has ended or not yet.</p>
 */
public interface ConversationCloseEvent extends ConversationEvent {

    /**
     * Gets the conversation.
     *
     * @return The conversation
     */
    Conversation getConversation();

    /**
     * Called when the conversation is in the process of ending, so it can
     * still be cancelled.
     */
    interface Ending extends ConversationCloseEvent, Cancellable {

    }

    /**
     * Called when the conversation has come to a close.
     *
     * <p>There are no longer conversants within it, all ending handlers have
     * been called, and there are no more questions to ask.</p>
     */
    interface Ended extends ConversationCloseEvent {

    }

}
