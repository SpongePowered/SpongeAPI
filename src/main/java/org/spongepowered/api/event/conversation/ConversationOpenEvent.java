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

import org.spongepowered.api.command.conversation.Conversant;
import org.spongepowered.api.command.conversation.Conversation;
import org.spongepowered.api.command.conversation.ConversationArchetype;
import org.spongepowered.api.event.Cancellable;

import java.util.Set;

/**
 * An event called when a {@link Conversation} is either starting or has started.
 */
public interface ConversationOpenEvent extends ConversationEvent {

    /**
     * Called before the {@link Conversation} is created, giving you access to
     * the archetype as well as who will be in the conversation.
     *
     * <p>If you remove all conversants, the implementation will not create
     * the conversation.</p>
     */
    interface Starting extends ConversationOpenEvent, Cancellable {

        /**
         * Gets the conversation archetype. This cannot be changed.
         *
         * @return The conversation archetype
         */
        ConversationArchetype getArchetype();

        /**
         * Gets a copy of all conversants.
         *
         * <p>If you want to add or remove a conversant, use the provided
         * matching methods instead.</p>
         *
         * @return A copy of all conversants
         */
        Set<Conversant> getConversants();

        /**
         * Adds a conversant to the new conversation.
         *
         * @param conversant The conversant to add
         */
        void addConversant(Conversant conversant);

        /**
         * Removes the specified conversant from the new conversation.
         *
         * @param conversant The conversant to remove
         */
        void removeConversant(Conversant conversant);

    }

    /**
     * Called after the {@link Conversation} is created, giving you access to it
     * and all information related to it.
     */
    interface Started extends ConversationOpenEvent {

        /**
         * Gets the created {@link Conversation}.
         *
         * @return The created conversation
         */
        Conversation getConversation();

    }

}
