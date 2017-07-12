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
package org.spongepowered.api.event.server.query;

import org.spongepowered.api.event.Event;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;

/**
 * Called when the server is queried through the Query protocol.
 */
public interface QueryServerEvent extends Event {

    interface Basic extends QueryServerEvent {

        /**
         * Gets the MOTD to respond with.
         *
         * <p>By default, this is the server's current MOTD</p>
         *
         * @return The MOTD to respond with.
         */
        String getMotd();

        /**
         * Sets the MOTD to respond with.
         *
         * <p>If setting the string causes the message to go over the
         * maximum size, the message will be automatically truncated.</p>
         *
         * @param motd The MOTD to respond with
         */
        void setMotd(String motd);

        /**
         * Gets the GameType to respond with.
         *
         * <p>By default, this is <code>SMP</code>.
         *
         * If setting the string causes the message to go over the
         * maximum size, the message will be automatically truncated.</p>
         *
         * @return The GameType to respond with
         */
        String getGameType();

        /**
         * Sets the GameType to respond with.
         *
         * <p>If setting the string causes the message to go over the
         * maximum size, the message will be automatically truncated.</p>
         *
         * @param gameType The GameType to respond with
         */
        void setGameType(String gameType);

        /**
         * Gets the map (world) to respond with.
         *
         * <p>By default, this is the current world on the server.</p>
         *
         * @return The map to respond with
         */
        String getMap();

        /**
         * Sets the map (world) to respond with.
         *
         * <p>If setting the string causes the message to go over the
         * maximum size, the message will be automatically truncated.</p>
         *
         * @param map The map to respond with
         */
        void setMap(String map);

        /**
         * Gets the player count to respond with.
         *
         * <p>By default, this is the number of players present on the server.
         *
         * If setting the string causes the message to go over the
         * maximum size, the message will be automatically truncated.</p>
         *
         * @return The player count to respond with
         */
        int getPlayerCount();

        /**
         * Sets the player count to respond with.
         *
         * <p>If setting the int causes the message to go over the
         * maximum size, the message will be automatically truncated.</p>
         *
         * @param playerCount The player count to respond with
         */
        void setPlayerCount(int playerCount);

        /**
         * Gets the max player count to respond with.
         *
         * <p>By default, this is the maximum number of players allowed on the
         * server.</p>
         *
         * @return The max player count to respond with
         */
        int getMaxPlayerCount();

        /**
         * Sets the max player count to respond with.
         *
         * <p>If setting the int causes the message to go over the
         * maximum size, the message will be automatically truncated.</p>
         *
         * @param maxPlayerCount The max player count to respond with
         */
        void setMaxPlayerCount(int maxPlayerCount);

        /**
         * Gets the address to respond with.
         *
         * <p>By default, this is the address the server is listening on.</p>
         *
         * @return The address to respond with
         */
        InetSocketAddress getAddress();

        /**
         * Sets the address to respond with.
         *
         * @param address The address to respond with
         */
        void setAddress(InetSocketAddress address);

        /**
         * Gets the current size of the data to respond with.
         *
         * <p>This value is implementation-defined - it is only meaningful when
         * compared with {@link #getMaxSize()}.</p>
         *
         * @return The current size of the data to respond with
         */
        int getSize();

        /**
         * Gets the maximum size of the data to respond with.
         *
         * <p>If the size of the data is greater than the returned value,
         * it will be automatically truncated.
         *
         * This value is implementation-defined - it is only meaningful when
         * compared with {@link #getSize()} ()}.</p>
         *
         * @return The maximum size of the data to respond with
         */
        int getMaxSize();
    }

    interface Full extends Basic {

        /**
         * Gets the GameId to respond with.
         *
         * <p>This is currently hardcoded to <code>MINECRAFT</code>.</p>
         *
         * @return The GameId to respond with.
         */
        String getGameId();

        /**
         * Gets the version to respond with.
         *
         * <p>By default, this is the server's Minecraft version (e.g 1.8.1).
         * </p>
         *
         * @return The version to respond with
         */
        String getVersion();

        /**
         * Sets the version to respond with.
         *
         * <p>If setting the string causes the message to go over the
         * maximum size, the message will be automatically truncated.</p>
         *
         * @param version The version to respond with
         */
        void setVersion(String version);

        /**
         * Gets the list of plugins to respond with.
         *
         * @return The list of plugins to respond with
         */
        String getPlugins();

        /**
         * Sets the list of plugins to respond with.
         *
         * <p>If setting the string causes the message to go over the
         * maximum size, the message will be automatically truncated.</p>
         *
         * @param plugins The list of plugins to respond with
         */
        void setPlugins(String plugins);

        /**
         * Gets the map of custom keys and values to respond with.
         *
         * <p>If settings any of the keys or values causes the message
         * to go over the maximum size, the message will be automatically
         * truncated.</p>
         *
         * @return The map of custom keys and values to respond with
         */
        Map<String, String> getCustomValuesMap();

        /**
         * Gets the list of player names to respond with.
         *
         * @return The list of player names to respond with
         */
        List<String> getPlayers();
    }
}
