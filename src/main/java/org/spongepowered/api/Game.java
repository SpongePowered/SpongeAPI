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
import org.spongepowered.api.entity.Player;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.api.service.scheduler.Scheduler;
import org.spongepowered.api.text.message.Message;
import org.spongepowered.api.text.title.Title;
import org.spongepowered.api.world.World;

import java.util.Collection;
import java.util.UUID;

/**
 * The core accessor of the API. The implementation uses this to pass
 * constructed objects.
 */
public interface Game {

    /**
     * Returns the {@link Platform} the implementation
     * is executing from.
     *
     * @return The platform
     */
    Platform getPlatform();

    /**
     * Gets the {@link PluginManager}.
     *
     * @return The plugin manager
     */
    PluginManager getPluginManager();

    /**
     * Gets the {@link EventManager}.
     *
     * @return The event manager
     */
    EventManager getEventManager();

    /**
     * Gets the {@link GameRegistry}.
     *
     * @return The game registry
     */
    GameRegistry getRegistry();

    /**
     * Gets the {@link Scheduler}.
     *
     * @return The scheduler
     */
    Scheduler getScheduler();

    /**
     * Gets the {@link Player}s currently online
     *
     * @return a {@link Collection} of online players
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
     * @return {@link Player} if available
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
     * @return {@link Player} if available
     */
    Optional<Player> getPlayer(String name);

    /**
     * Gets all currently loaded {@link World}s.
     *
     * @return Collection of loaded worlds
     */
    Collection<World> getWorlds();

    /**
     * Gets a loaded {@link World} by its unique id ({@link UUID}).
     *
     * @param uniqueId UUID to lookup
     * @return The world or null if not found
     */
    World getWorld(UUID uniqueId);

    /**
     * Gets a loaded {@link World} by name
     *
     * @param worldName Name to lookup
     * @return The world or null if not found
     */
    World getWorld(String worldName);

    /**
     * Sends the given message to all online players
     *
     * @param message The message to send
     */
    void broadcastMessage(Message<?> message);

    /**
     * Creates a new clean {@link Title} configuration that will reset the
     * currently displayed title before displaying the new one.
     *
     * @return A new clean {@link Title} configuration.
     */
    Title createTitle();

    /**
     * Creates a new empty {@link Title} configuration that will just update
     * the currently displayed title on the client.
     *
     * @return A new empty {@link Title} configuration.
     */
    Title updateTitle();

    /**
     * Gets the API version.
     *
     * @return The API version
     */
    String getAPIVersion();

    /**
     * Gets the implementation version.
     *
     * @return The implementation version
     */
    String getImplementationVersion();

}
