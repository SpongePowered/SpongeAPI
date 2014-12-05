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
package org.spongepowered.api;

import com.google.common.base.Optional;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.text.message.Message;
import org.spongepowered.api.world.World;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.UUID;

/**
 * Represents a typical Minecraft Server.
 */
public interface Server {
    /**
     * Gets the {@link Player}s currently online
     *
     * @return A {@link Collection} of online players
     */
    Collection<Player> getOnlinePlayers();

    /**
     * Gets the max players allowed on this server
     *
     * @return Maximum number of connected players
     */
    int getMaxPlayers();

    /**
     * Gets a {@link Player} by their unique id, if available
     *
     * @param uniqueId The UUID to get the player from
     * @return The player
     */
    Optional<Player> getPlayer(UUID uniqueId);

    /**
     * Gets a {@link Player} by their name, if available
     *
     * This only works for online players.
     *
     * <b>Note: Do not use names for persistent storage, the
     * Zidane of today may not be the Zidane of yesterday.</b>
     *
     * @param name The name to get the player from
     * @return The player
     */
    Optional<Player> getPlayer(String name);

    /**
     * Gets all currently loaded {@link World}s.
     *
     * @return Collection of loaded worlds
     */
    Collection<World> getWorlds();

    /**
     * Gets a loaded {@link World} by its unique id ({@link UUID}), if available
     *
     * @param uniqueId UUID to lookup
     * @return The world
     */
    Optional<World> getWorld(UUID uniqueId);

    /**
     * Gets a loaded {@link World} by name, if available
     *
     * @param worldName Name to lookup
     * @return The world
     */
    Optional<World> getWorld(String worldName);

    /**
     * Sends the given message to all online players
     *
     * @param message The message to send
     */
    void broadcastMessage(Message<?> message);

    /**
     * Gets the bound {@link InetSocketAddress} this server is accepting connections from, if available
     * @return The link
     */
    Optional<InetSocketAddress> getBoundAddress();

    /**
     * Tests if the server has a whitelist enabled.
     * @return True if enabled, false if not
     */
    boolean hasWhitelist();

    /**
     * Sets whether the server is utilizing a whitelist.
     * @param enabled True to enable the whitelist, false to disable
     */
    void setHasWhitelist(boolean enabled);

    /**
     * Tests if this server is set to online mode.
     *
     * <b>Online mode authenticates users against Minecraft's servers, false performs
     * no validity checks.</b>
     * @return True if enabled, false if not
     */
    boolean getOnlineMode();

    /**
     * Gets the message that is displayed in the server list of the client.
     * @return The servers MOTD
     */
    Message.Text getMOTD();
}
