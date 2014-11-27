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

/**
 * Called when a {@link Player} leave the game.
 */
public interface PlayerQuitEvent extends PlayerEvent {

    /**
     * Reasons that a {@link PlayerQuitEvent} can have.
     */
    public enum QuitReason {

        /**
         * The {@link Player} has disconnected the game.
         */
        DISCONNECT,
        /**
         * The {@link Player} was kicked out of the game.
         */
        KICK,
        /**
         * The quit of the {@link Player} is because of an error.
         */
        ERROR

    }

    /**
     * Gets the message that will be broadcast when a player leave.
     *
     * @return The join message
     */
    String getMessage();

    /**
     * Sets the message that will be displayed when the player leave.
     *
     * @param message The message to be set
     */
    void setMessage(String message);

    /**
     * Gets the reason for the quit.
     *
     * @return The reason for the quit
     */
    QuitReason getReason();

}
