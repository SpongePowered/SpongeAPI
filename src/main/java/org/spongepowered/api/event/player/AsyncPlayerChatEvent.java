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

package org.spongepowered.api.event.player;

import org.spongepowered.api.entity.Player;

import java.util.Set;

/**
 * Called when a {@link Player} sends a chat message.
 */
public interface AsyncPlayerChatEvent extends PlayerEvent {

    /**
     * Gets the message which is sent to the recipients
     * if no player-specific message is defined.
     *
     * @return The fallback message.
     */
    String getMessage();

    /**
     * Sets the message which is sent to the recipients
     * if no player-specific message is defined.
     *
     * @param message The new fallback message.
     */
    void setMessage(String message);
    
    /**
    * Gets the recipients of this chat event.
    *
    * @return The recipients of this chat event.
    */
    Set<Player> getRecipients();

    /**
    * Gets the message for a specific player.
    * If the player is a recipient of this chat event
    * but doesn't have a specific message set this returns
    * the fallback message.
    *
    * @param player The player whose message is requested.
    * @return The message for the given player.
    */
    String getMessage(Player player);

    /**
    * Sets the message for a specific player.
    * 
    * @param player The player to set the message for.
    */
    void setMessage(Player player);

}
