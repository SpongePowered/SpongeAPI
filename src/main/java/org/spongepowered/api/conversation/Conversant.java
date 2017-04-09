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

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.text.Text;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * Represents someone that can take part in a {@link Conversation}.
 */
public interface Conversant extends CommandSource {

    /**
     * Gets the {@link Conversation} this conversant is currently in,
     * if they are in one.
     *
     * @return This conversant's current {@link Conversation}, if available
     */
    Optional<Conversation> getConversation();

    /**
     * A convenience method to see if the player is currently in a conversation.
     *
     * @return Whether or not they are a conversation
     */
    default boolean isConversing() {
        return getConversation().isPresent();
    }

    /**
     * Sets this conversant's current {@link Conversation}. If they are in a
     * current conversation, it will not override it and just log a message
     * to the console instead.
     *
     * <p>Never pass null into this method. To remove them from a
     * {@link Conversation} use the
     * {@link Conversation#removeConversant(Conversant)} method.</p>
     *
     * @param conversation The conversation to add them to
     * @return The conversation they end up in, whether it's the new one or the
     * one they were originally in
     */
    Conversation setConversation(Conversation conversation);

    /**
     * Sets their conversation to null. Should only be used by Sponge as it does
     * not remove them from the conversation. Instead use the
     * {@link Conversation#removeConversant(Conversant)} method.
     */
    void removeFromConversation();

    /**
     * Due to conversations often catching messages, this allows messages while
     * they're in a conversation to go through to them no matter what
     * and bypass their {@link ExternalChatHandler}.
     *
     * @param message The message to send
     */
    void sendThroughMessage(Text message);

}
