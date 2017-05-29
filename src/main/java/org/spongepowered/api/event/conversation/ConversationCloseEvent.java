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
import org.spongepowered.api.command.conversation.Question;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.cause.conversation.ConversationEndType;

import java.util.Optional;

/**
 * An event called when a conversation is either ending or has already ended.
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
     *
     * <p>If you cancel this event, the conversation does not have its
     * conversants removed, its ending handlers called, and depending on
     * the {@link ConversationEndType} there may be no more questions so
     * the conversation may end up in a sort of limbo. To remedy this
     * you can set the next question if you so desire.</p>
     */
    interface Ending extends ConversationCloseEvent, Cancellable {

        /**
         * Sets the next question to be asked if the event ends
         * up cancelled.
         *
         * <p>This does not need to be called, as the conversation
         * may still have a question depending on the {@link ConversationEndType}
         * of the event.</p>
         *
         * <p><b>Note:</b> This will override the current question if there
         * is one once the event has completed.</p>
         *
         * @param question The question to set
         */
        void setPostQuestion(Question question);

        /**
         * Gets the question set in the event, to be set
         * once the event has completed.
         *
         * @return The question to be set, if available
         */
        Optional<Question> getPostQuestion();

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
