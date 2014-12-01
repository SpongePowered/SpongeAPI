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

package org.spongepowered.api.entity.player;

import org.spongepowered.api.effect.Viewer;
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.text.chat.ChatType;
import org.spongepowered.api.text.message.Message;
import org.spongepowered.api.text.title.Title;
import org.spongepowered.api.text.translation.locale.Locales;
import org.spongepowered.api.util.command.CommandSource;

import java.util.Locale;

/**
 * A Player represents the in-game entity of a human playing on a server.
 * This is in contrast to User which represents the storage and data
 * associated with a Player.
 *
 * <p>Any methods called on Player that are not on User do not store any data
 * that persists across server restarts.</p>
 */
public interface Player extends Human, User, CommandSource, Viewer {

    /**
     * Gets the player's display name. If none set, returns their current
     * username.
     * 
     * @return The player's display name
     */
    String getDisplayName();

    /**
     * Returns whether the {@link Player} can fly via the fly key.
     *
     * @return {@code True} if the {@link Player} is allowed to fly
     */
    boolean getAllowFlight();

    /**
     * Sets if the {@link Player} can fly via the fly key.
     *
     * @param allowFlight {@code True} if the player is allowed to fly
     */
    void setAllowFlight(boolean allowFlight);

    /**
     * Gets the locale used by the player.
     *
     * @return The player's locale
     * @see Locales
     */
    Locale getLocale();

    /**
     * Sends the plain text message(s) with the specified {@link ChatType} on the client.
     * <p>Use {@link #sendMessage(ChatType, Message...)} for a formatted message.</p>
     *
     * @param type The chat type to send the messages to
     * @param message The message(s) to send
     */
    void sendMessage(ChatType type, String... message);

    /**
     * Sends the message(s) with the specified {@link ChatType} on the client.
     *
     * @param type The chat type to send the messages to
     * @param messages The message(s) to send
     */
    void sendMessage(ChatType type, Message<?>... messages);

    /**
     * Sends the message(s) with the specified {@link ChatType} on the client.
     *
     * @param type The chat type to send the messages to
     * @param messages The message(s) to send
     */
    void sendMessage(ChatType type, Iterable<Message<?>> messages);

    /**
     * Sends a {@link Title} to this player.
     *
     * @param title The {@link Title} to send to the player
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
