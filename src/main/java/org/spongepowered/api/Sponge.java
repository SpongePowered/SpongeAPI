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

import static com.google.common.base.Preconditions.checkState;

import org.spongepowered.api.asset.AssetManager;
import org.spongepowered.api.command.CommandManager;
import org.spongepowered.api.data.DataManager;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.network.ChannelRegistrar;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.api.scheduler.Scheduler;
import org.spongepowered.api.service.ServiceManager;

/**
 * A static all access class granting static access to various systems
 * for the API. At the root of all the accessors is {@link Sponge#getGame()},
 * which is only available once the game has been constructed.
 */
public final class Sponge {

    private static final Game game = null;

    /**
     * Gets the {@link Game} instance. There is ever only going
     * to be a single game instance at any given time, except during
     * the various extraneous {@link GameState}s that the game instance
     * is otherwise unavailable.
     *
     * @return The game instance
     */
    public static Game getGame() {
        checkState(game != null, "Sponge has not been initialized!");
        return game;
    }

    /**
     * Gets the current {@link GameRegistry} instance from the
     * {@link Game} instance.
     *
     * @see Game#getRegistry()
     * @return The game registry instance
     */
    public static GameRegistry getRegistry() {
        return getGame().getRegistry();
    }

    /**
     * Gets the {@link ServiceManager} instance from the
     * {@link Game} instance.
     *
     * @see Game#getServiceManager()
     * @return The service manager instance
     */
    public static ServiceManager getServiceManager() {
        return getGame().getServiceManager();
    }

    /**
     * Gets the {@link EventManager} instance from the
     * {@link Game} instance.
     *
     * @see Game#getEventManager()
     * @return The event manager instance
     */
    public static EventManager getEventManager() {
        return getGame().getEventManager();
    }

    /**
     * Gets the {@link AssetManager} instance from the
     * {@link Game} instance.
     *
     * @see Game#getAssetManager()
     * @return The asset manager instance
     */
    public static AssetManager getAssetManager() {
        return getGame().getAssetManager();
    }

    /**
     * Gets the {@link Scheduler} instance from the
     * {@link Game} instance.
     *
     * @see Game#getScheduler()
     * @return The scheduler instance
     */
    public static Scheduler getScheduler() {
        return getGame().getScheduler();
    }

    /**
     * Gets the {@link DataManager} instance from the
     * {@link Game} instance.
     *
     * @see Game#getDataManager()
     * @return The data manager instance
     */
    public static DataManager getDataManager() {
        return getGame().getDataManager();
    }

    /**
     * Gets the {@link PluginManager} instance from the
     * {@link Game} instance.
     *
     * @see Game#getPluginManager()
     * @return The plugin manager instance
     */
    public static PluginManager getPluginManager() {
        return getGame().getPluginManager();
    }

    /**
     * Gets the {@link Platform} instance from the
     * {@link Game} instance.
     *
     * @see Game#getPlatform()
     * @return The platform
     */
    public static Platform getPlatform() {
        return getGame().getPlatform();
    }

    /**
     * Gets whether a {@link Server} instance is available without throwing an
     * exception from calling {@link #getServer()}.
     *
     * @see Game#isServerAvailable()
     * @return True if the server instance is available
     */
    public static boolean isServerAvailable() {
        return getGame().isServerAvailable();
    }

    /**
     * Gets the {@link Server} instance from the
     * {@link Game} instance.
     *
     * <p>Note: During various {@link GameState}s, a {@link Server} instance
     * may <strong>NOT</strong> be available. During these specific states,
     * calling {@link Game#getServer()} will throw an exception. To double
     * check, call {@link #isServerAvailable()}</p>
     *
     * @see Game#getServer()
     * @see Game#isServerAvailable()
     * @return The server instance
     */
    public static Server getServer() {
        return getGame().getServer();
    }

    /**
     * Gets the {@link GameDictionary} instance from the
     * {@link Game} instance.
     *
     * @see Game#getGameDictionary()
     * @return The game dictionary instance
     */
    public static GameDictionary getDictionary() {
        return getGame().getGameDictionary();
    }

    /**
     * Gets the {@link CommandManager} instance from the
     * {@link Game} instance.
     *
     * @see Game#getCommandManager()
     * @return The command manager instance
     */
    public static CommandManager getCommandManager() {
        return getGame().getCommandManager();
    }

    /**
     * Gets the {@link ChannelRegistrar} instance from the
     * {@link Game} instance.
     *
     * @see Game#getChannelRegistrar()
     * @return The channel registrar instance
     */
    public static ChannelRegistrar getChannelRegistrar() {
        return getGame().getChannelRegistrar();
    }

}
