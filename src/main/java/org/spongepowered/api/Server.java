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
import org.spongepowered.api.world.chunk.ChunkDecorator;
import org.spongepowered.api.world.chunk.ChunkGenerator;
import org.spongepowered.api.world.chunk.ChunkPopulator;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.UUID;

import javax.annotation.Nullable;

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
     * Gets a {@link Player} by their unique id
     *
     * @param uniqueId The UUID to get the player from
     * @return {@link Player} or Optional.absent() if not found
     */
    Optional<Player> getPlayer(UUID uniqueId);

    /**
     * Gets a {@link Player} by their name
     *
     * This only works for online players.
     *
     * <b>Note: Do not use names for persistent storage, the
     * Zidane of today may not be the Zidane of yesterday.</b>
     *
     * @param name The name to get the player from
     * @return {@link Player} or Optional.absent() if not found
     */
    Optional<Player> getPlayer(String name);

    /**
     * Gets all currently loaded {@link World}s.
     *
     * @return Collection of loaded worlds
     */
    Collection<World> getWorlds();

    /**
     * Gets a loaded {@link World} by its unique id ({@link UUID}), if any.
     *
     * @param uniqueId UUID to lookup
     * @return The world or Optional.absent() if not found
     */
    Optional<World> getWorld(UUID uniqueId);

    /**
     * Gets a loaded {@link World} by name, if any.
     *
     * @param worldName Name to lookup
     * @return The world or Optional.absent() if not found
     */
    Optional<World> getWorld(String worldName);

    /**
     * Creates or loads a world with the given name using the given chunk
     * generators.
     * 
     * @param name The name of the world to generate
     * @param generator The generator to generate new chunks.
     * @param populatorm The populator to use. Can be null if no populator
     *            should be used.
     * @param decorator The decorator to use. Can be null if no decorator should
     *            be used.
     * @return The created or loaded world
     * @throws IllegalStateException If the world is already loaded or something
     *             went wrong during the creation process.
     */
    World createOrLoadWorld(String name, ChunkGenerator generator, @Nullable ChunkPopulator populatorm, @Nullable ChunkDecorator decorator) throws IllegalStateException;

    /**
     * Gets the time, in ticks, since this server began running for the current session.
     *
     * <p>This value is not persisted across server restarts, it is set to zero
     * each time the server starts.</p>
     *
     * @return The number of ticks since this server started running
     */
    int getRunningTimeTicks();

    /**
     * Sends the given message to all online players
     *
     * @param message The message to send
     */
    void broadcastMessage(Message message);

    /**
     * Gets the bound {@link InetSocketAddress} this server is accepting connections from.
     * @return The address or Optional.absent() if not found
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
    Message getMOTD();
}
