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
package org.spongepowered.api;

import com.google.common.base.Optional;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.network.ChannelRegistrar;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.command.source.ConsoleSource;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.WorldBuilder;
import org.spongepowered.api.world.WorldCreationSettings;
import org.spongepowered.api.world.storage.ChunkLayout;
import org.spongepowered.api.world.storage.WorldProperties;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.UUID;

/**
 * Represents a typical Minecraft Server.
 */
public interface Server extends ChannelRegistrar {

    /**
     * Gets the {@link Player}s currently online.
     *
     * @return A {@link Collection} of online players
     */
    Collection<Player> getOnlinePlayers();

    /**
     * Gets the max players allowed on this server.
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
     * <p>This only works for online players.</p>
     *
     * <p><b>Note: Do not use names for persistent storage, the
     * Notch of today may not be the Notch of yesterday.</b></p>
     *
     * @param name The name to get the player from
     * @return {@link Player} or Optional.absent() if not found
     */
    Optional<Player> getPlayer(String name);

    /**
     * Gets all currently loaded {@link World}s.
     *
     * @return A collection of loaded worlds
     */
    Collection<World> getWorlds();

    /**
     * Gets the properties of all unloaded worlds.
     *
     * @return A collection of world properties
     */
    Collection<WorldProperties> getUnloadedWorlds();

    /**
     * Gets the properties of all worlds, loaded or otherwise.
     *
     * @return A collection of world properties
     */
    Collection<WorldProperties> getAllWorldProperties();

    /**
     * Gets a loaded {@link World} by its unique id ({@link UUID}), if it
     * exists.
     *
     * @param uniqueId UUID to lookup
     * @return The world, if found
     */
    Optional<World> getWorld(UUID uniqueId);

    /**
     * Gets a loaded {@link World} by name, if it exists.
     *
     * @param worldName Name to lookup
     * @return The world, if found
     */
    Optional<World> getWorld(String worldName);

    /**
     * Loads a {@link World} from the default storage container. If a world with
     * the given name is already loaded then it is returned instead.
     *
     * @param worldName The name to lookup
     * @return The world, if found
     */
    Optional<World> loadWorld(String worldName);

    /**
     * Loads a {@link World} from the default storage container. If a world with
     * the given UUID is already loaded then it is returned instead.
     *
     * @param uniqueId The UUID to lookup
     * @return The world, if found
     */
    Optional<World> loadWorld(UUID uniqueId);

    /**
     * Loads a {@link World} from the default storage container. If the world
     * associated with the given properties is already loaded then it is
     * returned instead.
     *
     * @param properties The properties of the world to load
     * @return The world, if found
     */
    Optional<World> loadWorld(WorldProperties properties);

    /**
     * Gets the {@link WorldProperties} of a world. If a world with the given
     * name is loaded then this is equivalent to calling
     * {@link World#getProperties()}. However, if no loaded world is found then
     * an attempt will be made to match unloaded worlds.
     *
     * @param worldName The name to lookup
     * @return The world properties, if found
     */
    Optional<WorldProperties> getWorldProperties(String worldName);

    /**
     * Gets the {@link WorldProperties} of a world. If a world with the given
     * UUID is loaded then this is equivalent to calling
     * {@link World#getProperties()}. However, if no loaded world is found then
     * an attempt will be made to match unloaded worlds.
     *
     * @param uniqueId The UUID to lookup
     * @return The world properties, if found
     */
    Optional<WorldProperties> getWorldProperties(UUID uniqueId);

    /**
     * Unloads a {@link World}, if there are any connected players in the given
     * world then no operation will occur.
     *
     * <p>A world which is unloaded will be removed from memory. However if it
     * is still enabled according to {@link WorldProperties#isEnabled()} then it
     * will be loaded again if the server is restarted or an attempt is made by
     * a plugin to transfer an entity to the world using
     * {@link Entity#transferToWorld(String, com.flowpowered.math.vector.Vector3d)}
     * </p>
     *
     * @param world The world to unload
     * @return Whether the operation was successful
     */
    boolean unloadWorld(World world);

    /**
     * Creates a new world from the given {@link WorldCreationSettings}. For the
     * creation of the WorldCreationSettings please see
     * {@link WorldBuilder}.
     *
     * <p>If the world already exists then the existing {@link WorldProperties}
     * are returned else a new world is created and the new WorldProperties
     * returned.</p>
     *
     * <p>Although the world is created it is not loaded at this time. Please
     * see one of the following methods for loading the world.</p>
     *
     * <ul> <li>{@link #loadWorld(String)}</li> <li>{@link #loadWorld(UUID)}
     * </li> <li>{@link #loadWorld(WorldProperties)}</li> </ul>
     *
     * @param settings The settings for creation
     * @return The new or existing world properties, if creation was successful
     */
    Optional<WorldProperties> createWorld(WorldCreationSettings settings);

    /**
     * Persists the given {@link WorldProperties} to the world storage for it,
     * updating any modified values.
     *
     * @param properties The world properties to save
     * @return True if the save was successful
     */
    boolean saveWorldProperties(WorldProperties properties);

    /**
     * Returns information about the chunk layout used by this server implementation.
     *
     * @return The chunk layout used by the implementation
     */
    ChunkLayout getChunkLayout();

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
     * Sends the given message to all online players.
     *
     * @param message The message to send
     */
    void broadcastMessage(Text message);

    /**
     * Gets the bound {@link InetSocketAddress} from where this server is accepting connections.
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
     * Gets the default message that is displayed in the server list of the
     * client.
     *
     * @return The server's default description (MOTD)
     */
    Text getMotd();

    /**
     * Shuts down the server, and kicks all players with the default kick
     * message (the translation key {@code disconnect.closed}).
     *
     */
    void shutdown();

    /**
     * Shuts down the server, and kicks all players with the given message.
     *
     * @param kickMessage The message to kick players with
     */
    void shutdown(Text kickMessage);

    /**
     * Gets the command source used for commands coming from this server's console.
     *
     * @return This server's console command source
     */
    ConsoleSource getConsole();

}
