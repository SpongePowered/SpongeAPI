/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.entity;

import org.spongepowered.api.text.message.Message;
import org.spongepowered.api.text.chat.ChatPosition;
import org.spongepowered.api.text.title.Title;
import org.spongepowered.api.util.command.CommandSource;

public interface Player extends HumanEntity, CommandSource {

    /**
     * Gets the players last known username
     *
     * @return The player's last known username
     */
    String getName();

    /**
     * Gets the player's display name. If none set, returns their current username.
     *
     * @return The player's display name
     */
    String getDisplayName();

    /**
     * Sends the plain text message(s) to the specified {@link ChatPosition} on the client.
     * <p>Use {@link #sendMessage(ChatPosition, Message...)} for a formatted message.</p>
     *
     * @param position The chat position to send the messages to
     * @param message The message(s) to send
     */
    void sendMessage(ChatPosition position, String... message);

    /**
     * Sends the message(s) to the specified {@link ChatPosition} on the client.
     *
     * @param position The chat position to send the messages to
     * @param messages The message(s) to send
     */
    void sendMessage(ChatPosition position, Message<?>... messages);

    /**
     * Sends the message(s) to the specified {@link ChatPosition} on the client.
     *
     * @param position The chat position to send the messages to
     * @param messages The message(s) to send
     */
    void sendMessage(ChatPosition position, Iterable<Message<?>> messages);

    /**
     * Sends a {@link Title} to this player. This is the same as calling
     * {@link Title#send(Player...)}.
     *
     * @param title The {@link Title} to send to the player.
     */
    void sendTitle(Title title);

    /**
     * Removes the currently displayed {@link Title} from the player and resets
     * all settings back to default values.
     */
    void resetTitle();

    /**
     * Removes the currently displayed {@link Title} from the player's screen.
     */
    void clearTitle();
}
