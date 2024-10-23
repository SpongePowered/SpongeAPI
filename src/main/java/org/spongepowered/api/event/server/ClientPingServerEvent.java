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
package org.spongepowered.api.event.server;

import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.MinecraftVersion;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.network.status.Favicon;
import org.spongepowered.api.network.status.StatusClient;
import org.spongepowered.api.network.status.StatusResponse;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.eventgen.annotations.GenerateFactoryMethod;
import org.spongepowered.eventgen.annotations.NoFactoryMethod;

import java.util.List;
import java.util.Optional;

/**
 * Called when a client pings the server from the server list.
 * <p>
 * If this event gets cancelled, it will close the client connection without
 * sending any response.
 * </p>
 */
@GenerateFactoryMethod
public interface ClientPingServerEvent extends Event, Cancellable {

    /**
     * Gets the client pinging the server.
     *
     * @return The client of the status request
     */
    StatusClient client();

    /**
     * Gets the response that is about to be sent to the client.
     *
     * @return The response to the status request
     */
    Response response();

    /**
     * Represents a mutable response to a status request.
     */
    interface Response extends StatusResponse {

        /**
         * Sets the description (MOTD) of the status response.
         *
         * @param description The description to display
         */
        void setDescription(Component description);

        @Override
        Optional<Players> players();

        /**
         * Sets whether the player count and the list of players on this server
         * is hidden and doesn't get sent to the client. This will restore
         * {@link #players()} if the players were previously hidden.
         *
         * <p>Use {@link #players()}.{@link Optional#isPresent() isPresent()} to
         * check if the players are already hidden.</p>
         *
         * <p>In Vanilla, this will display {@code ???} instead of the player
         * count in the server list.</p>
         *
         * @param hide {@code True} if the players should be hidden
         */
        void setHidePlayers(boolean hide);

        @Override
        Version version();

        /**
         * Sets the {@link Favicon} to display on the client.
         *
         * @param favicon The favicon, or {@code null} for none
         */
        void setFavicon(@Nullable Favicon favicon);

        /**
         * Represents the information about the players on the server, sent
         * after the {@link ClientPingServerEvent}.
         */
        @NoFactoryMethod
        interface Players extends StatusResponse.Players {

            /**
             * Sets the amount of online players to display on the client.
             *
             * @param online The amount of online players
             */
            void setOnline(int online);

            /**
             * Sets the maximum amount of allowed players to display on the
             * client.
             *
             * @param max The maximum amount of players
             */
            void setMax(int max);

            /**
             * Gets an mutable list of online players on the server to display
             * on the client.
             *
             * @return A mutable list of online players
             */
            @Override
            List<GameProfile> profiles();
        }

        /**
         * Represents the information about the version of the server, sent
         * after the {@link ClientPingServerEvent}.
         */
        @NoFactoryMethod
        interface Version extends MinecraftVersion {

            /**
             * Sets the name of the version of the server. This is usually
             * displayed on the client if the server is using an incompatible
             * protocol version.
             *
             * @param name The new display name of the server version
             */
            void setName(String name);

            /**
             * Sets the server protocol version reported to the client.
             * Modifying this will change if the client sees the server as
             * incompatible or not, forcing it to display the {@link #name()}.
             *
             * @param protocolVersion The new server protocol version
             * @see <a href="https://minecraft.wiki/w/Protocol_version">Protocol version (Minecraft Wiki)</a>
             */
            void setProtocolVersion(int protocolVersion);
        }
    }

}
