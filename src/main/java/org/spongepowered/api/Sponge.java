/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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

import org.apache.logging.log4j.Logger;

import org.spongepowered.api.entity.Player;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.api.world.World;

import java.util.Collection;
import java.util.UUID;

import javax.annotation.Nullable;

/**
 * Represents the Sponge core, for version and Server singleton handling
 */
public final class Sponge {
    private static Game game;

    /**
     * Gets the current {@link Game} singleton
     *
     * @return Game instance being ran
     */
    public static Game getServer() {
        return game;
    }

    /**
     * Attempts to set the {@link Game} singleton.
     * <p>
     * This cannot be done if the Server is already set.
     *
     * @param game Game instance
     */
    public static void setServer(Game game) {
        if (Sponge.game != null) {
            throw new UnsupportedOperationException("Cannot redefine singleton Game");
        }

        Sponge.game = game;
    }

    /**
     * Gets the {@link org.apache.logging.log4j.Logger} of the implementation.
     *
     * @return The logger
     */
    public static Logger getLogger() {
        return game.getLogger();
    }

    /**
     * Returns the {@link org.spongepowered.api.Platform} the implementation is executing from.
     *
     * @return The platform
     */
    public static Platform getPlatform() {
        return game.getPlatform();
    }

    /**
     * Gets the {@link org.spongepowered.api.plugin.PluginManager}.
     *
     * @return The plugin manager
     */
    public static PluginManager getPluginManager() {
        return game.getPluginManager();
    }

    /**
     * Gets the {@link org.spongepowered.api.event.EventManager}.
     *
     * @return The event manager
     */
    public static EventManager getEventManager() {
        return game.getEventManager();
    }

    /**
     * Gets the {@link org.spongepowered.api.GameRegistry}.
     *
     * @return The game registry
     */
    public static GameRegistry getRegistry() {
        return game.getRegistry();
    }

    /**
     * Gets the {@link Player}s currently online
     *
     * @return a {@link Collection} of online players
     */
    public static Collection<Player> getOnlinePlayers() {
        return game.getOnlinePlayers();
    }

    /**
     * Gets the max players allowed on this server
     *
     * @return Maximum number of connected players
     */
    public static int getMaxPlayers() {
        return game.getMaxPlayers();
    }

    /**
     * Gets a {@link Player} by their unique id
     *
     * @param uniqueId The UUID to get the player from
     * 
     * @return {@link Player} or null if none found
     */
    @Nullable
    public static Player getPlayer(UUID uniqueId) {
        return game.getPlayer(uniqueId);
    }

    /**
     * Gets all currently loaded {@link org.spongepowered.api.world.World}s.
     *
     * @return Collection of loaded worlds
     */
    public static Collection<World> getWorlds() {
        return game.getWorlds();
    }

    /**
     * Gets a loaded {@link World} by its unique id ({@link java.util.UUID}.
     *
     * @param uniqueId UUID to lookup
     * @return The world or null if not found
     */
    public static World getWorld(UUID uniqueId) {
        return game.getWorld(uniqueId);
    }

    /**
     * Gets a loaded {@link World} by name
     *
     * @param worldName Name to lookup
     * @return The world or null if not found
     */
    public static World getWorld(String worldName) {
        return game.getWorld(worldName);
    }

    /**
     * Sends the given message to all online players
     *
     * @param message The message to send
     */
    public static void broadcastMessage(String message) {
        game.broadcastMessage(message);
    }

    /**
     * Gets the API version.
     *
     * @return The API version
     */
    public static String getAPIVersion() {
        return game.getAPIVersion();
    }

    /**
     * Gets the implementation version.
     *
     * @return The implementation version
     */
    public static String getImplementationVersion() {
        return game.getImplementationVersion();
    }
}
