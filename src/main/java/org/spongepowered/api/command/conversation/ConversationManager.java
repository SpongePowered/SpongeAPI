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

import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.conversation.ConversationEndType;
import org.spongepowered.api.plugin.PluginContainer;

import java.util.Collection;
import java.util.Optional;

/**
 * Handles all active conversations. This is where conversant input is processed
 * as well as where conversations are started by Sponge. There are some methods
 * that can be used for easy retrieval of conversations as well.
 */
public interface ConversationManager {

    /**
     * Gets an active {@link Conversation} with the specified id and creator.
     *
     * @param plugin The plugin who created the conversation
     * @param id The id of the conversation
     * @return The matching conversation, if present
     */
    Collection<Conversation> getConversation(PluginContainer plugin, String id);

    /**
     * Gets all current active conversations.
     *
     * @return A collection of all active conversations
     */
    Collection<Conversation> getConversations();

    /**
     * Processes a {@link Conversant}s incoming chat if they are in
     * a conversation.
     *
     * <p>This should generally only be called by Sponge, but a plugin could
     * utilize this method to essentially act as the conversant in
     * the conversation.</p>
     *
     * @param conversant The conversant to process chat for
     * @param message The conversant's raw message
     * @return Whether or not to catch the conversant's chat for elsewhere
     */
    boolean process(Conversant conversant, String message);

    /**
     * Starts a {@link Conversation} based off of an archetype and the specified
     * {@link Conversant}s.
     *
     * @param archetype The archetype to base the conversation on
     * @param plugin The plugin submitting the conversation
     * @param conversants The conversants to add to the conversation
     * @return The conversation if it was successfully created
     */
    Optional<Conversation> start(ConversationArchetype archetype,
        PluginContainer plugin, Conversant... conversants);

    /**
     * Removes the specified {@link Conversation} from the manager.
     *
     * <p>Generally should only be used by Sponge. Instead use
     * {@link Conversation#end(ConversationEndType, Cause)}.</p>
     *
     * @param conversation The conversation to remove from the manager
     */
    void remove(Conversation conversation);

    /**
     * Ends every conversation. Should generally only be used by Sponge.
     *
     * @param endType The end type
     * @param cause The cause
     */
    void endAll(ConversationEndType endType, Cause cause);

}
