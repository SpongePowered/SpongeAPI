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
package org.spongepowered.api.status;

import com.google.common.base.Optional;
import org.spongepowered.api.GameProfile;
import org.spongepowered.api.MinecraftVersion;
import org.spongepowered.api.event.server.StatusPingEvent;
import org.spongepowered.api.text.Text;

import java.util.List;

/**
 * Represents the response to a status request. Unlike {@link StatusPingEvent}
 * this is immutable.
 * <p>
 * This interface exists mostly for convenience and can be implemented in a
 * library pinging other servers for example.
 * </p>
 *
 * @see StatusPingEvent
 */
public interface StatusResponse {

    /**
     * Gets the description (MOTD) of the status response.
     *
     * @return The description to display
     */
    Text getDescription();

    /**
     * Gets player count and the list of players currently playing on the
     * server.
     *
     * @return The player information, or {@link Optional#absent()} if not
     *         available
     */
    Optional<? extends Players> getPlayers();

    /**
     * Gets the version of the server displayed when the client or the server
     * are outdated.
     *
     * @return The server version
     */
    MinecraftVersion getVersion();

    /**
     * Gets the {@link Favicon} of the server.
     *
     * @return The favicon, or {@link Optional#absent()} if not available
     */
    Optional<Favicon> getFavicon();

    /**
     * Represents the player count, slots and a list of players current playing
     * on a server.
     */
    interface Players {

        /**
         * Gets the amount of online players on the server.
         *
         * @return The amount of online players
         */
        int getOnline();

        /**
         * Gets the maximum amount of allowed players on the server.
         *
         * @return The maximum amount of allowed players
         */
        int getMax();

        /**
         * Gets an immutable list of online players on the server to display on
         * the client.
         *
         * @return An immutable list of online players
         */
        List<GameProfile> getProfiles();

    }

}
