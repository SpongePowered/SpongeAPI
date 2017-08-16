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
package org.spongepowered.api.entity.living.player;

import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.network.ServerConnection;

/**
 * Player controller for the client's player
 */
public interface ClientPlayerController extends PlayerController {

    /**
     * Gets the {@link Humanoid} player entity.
     *
     * @return The player entity
     */
    Humanoid getPlayer();

    /**
     * Gets the {@link ServerConnection} to which the player is connected.
     * @return The connection
     */
    @Override
    ServerConnection getConnection();

    /**
     * Sends a chat message in plain text to the server.
     *
     * <p>Messages longer than the max allowed will be truncated. As of 1.11.2,
     * the maximum length is 256.</p>
     *
     * <p>Messages which contain forbidden characters will throw an Exception.
     * Currently, characters must not be a control character or the section
     * sign (&#x00a7)</p>
     *
     * <p>Note: Calling this method too often may result in being kicked for
     * chat spam. Different server implementations have different thresholds
     * and cooldown times for chat messages.</p>
     *
     * @param message The message to send.
     * @throws IllegalArgumentException If the message has illegal characters
     */
    void sendChatMessage(String message) throws IllegalArgumentException;

}
