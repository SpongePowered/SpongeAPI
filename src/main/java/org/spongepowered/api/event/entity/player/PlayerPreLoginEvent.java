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
package org.spongepowered.api.event.entity.player;


import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.network.RemoteConnection;

import java.util.UUID;

/**
 * This event is called asynchronously immediately after a player has been authenticated. This event is primarily useful for performing
 * asynchronous caching of player data, since it is primarily immutable
 *
 * <p>Because a {@link Player} object has not been constructed yet at this point in the login process, this event only contains some relevant
 * information
 *
 */
public interface PlayerPreLoginEvent extends UserEvent {

    /**
     * The name of the player connecting.
     *
     * @return The name of the player connecting.
     */
    String getName();

    /**
     * Thee {@link UUID} of the player connecting. This is determined by Mojang unless the server is in offline mode.
     *
     * @return The unique id
     */
    UUID getUniqueId();

    /**
     * Get the connection information related to the player in the process of connecting.
     *
     * @return The player's connection
     */
    RemoteConnection getConnection();
}
