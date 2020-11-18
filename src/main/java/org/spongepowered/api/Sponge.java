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

import com.google.inject.Inject;
import org.spongepowered.api.asset.AssetManager;
import org.spongepowered.api.command.manager.CommandManager;
import org.spongepowered.api.config.ConfigManager;
import org.spongepowered.api.data.DataManager;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.event.lifecycle.LifecycleEvent;
import org.spongepowered.api.network.channel.ChannelRegistry;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.api.registry.GameRegistry;
import org.spongepowered.api.scheduler.Scheduler;
import org.spongepowered.api.service.ServiceProvider;
import org.spongepowered.api.sql.SqlManager;
import org.spongepowered.api.util.metric.MetricsConfigManager;

/**
 * A static all access class granting static access to various systems
 * for the API.
 */
public final class Sponge {

    @Inject private static Game game;

    /**
     * Gets the {@link Game} instance. There is ever only going
     * to be a single game instance at any given time.
     *
     * @return The game instance
     */
    public static Game getGame() {
        if (Sponge.game == null) {
            throw new IllegalStateException("Sponge has not been initialized!");
        }
        return Sponge.game;
    }

    /**
     * Returns the current platform, or implementation, this {@link Game}
     * is running on.
     *
     * @return The current implementation
     */
    public static Platform getPlatform() {
        return Sponge.getGame().getPlatform();
    }

    /**
     * Gets the {@link GameRegistry} instance.
     *
     * @return The game registry instance
     */
    public static GameRegistry getRegistry() {
        return Sponge.getGame().getRegistry();
    }

    /**
     * Gets the {@link DataManager} instance.
     *
     * @return The data manager instance
     */
    public static DataManager getDataManager() {
        return Sponge.getGame().getDataManager();
    }

    /**
     * Gets the {@link PluginManager} instance.
     *
     * @return The plugin manager instance
     */
    public static PluginManager getPluginManager() {
        return Sponge.getGame().getPluginManager();
    }

    /**
     * Gets the {@link EventManager} instance.
     *
     * @return The event manager instance
     */
    public static EventManager getEventManager() {
        return Sponge.getGame().getEventManager();
    }

    /**
     * Gets the {@link AssetManager} instance.
     *
     * @return The asset manager instance
     */
    public static AssetManager getAssetManager() {
        return Sponge.getGame().getAssetManager();
    }

    /**
     * Gets the {@link ConfigManager} used to load and manage configuration files
     * for plugins.
     *
     * @return The configuration manager
     */
    public static ConfigManager getConfigManager() {
        return Sponge.getGame().getConfigManager();
    }

    /**
     * Gets the {@link ChannelRegistry} for creating network channels.
     *
     * @return The channel registry
     */
    public static ChannelRegistry getChannelRegistry() {
        return Sponge.getGame().getChannelRegistry();
    }

    /**
     * Gets whether a {@link Server} instance is available without throwing an
     * exception from calling {@link #getServer()}.
     *
     * @see Game#isServerAvailable()
     * @return True if the server instance is available
     */
    public static boolean isServerAvailable() {
        return Sponge.getGame().isServerAvailable();
    }

    /**
     * Gets the {@link Server} instance from the {@link Game} instance.
     *
     * <p>Note: During various {@link LifecycleEvent events}, a {@link Server} instance
     * may <strong>NOT</strong> be available. Calling {@link Game#getServer()} during one
     * will throw an exception. To double check, call {@link #isServerAvailable()}</p>
     *
     * @see Game#getServer()
     * @see Game#isServerAvailable()
     * @return The server instance
     */
    public static Server getServer() {
        return Sponge.getGame().getServer();
    }

    /**
     * Gets whether a {@link Client} instance is available without throwing an
     * exception from calling {@link #getClient()}.
     *
     * @see Game#isClientAvailable()
     * @return True if the client instance is available
     */
    public static boolean isClientAvailable() {
        return Sponge.getGame().isClientAvailable();
    }

    /**
     * Gets the {@link Client} instance from the {@link Game} instance.
     *
     * <p>Note: Not all implementations support a client, consult your
     * vendor for further information.</p>
     *
     * @see Game#getClient()
     * @see Game#isClientAvailable()
     * @return The client instance
     */
    public static Client getClient() {
        return Sponge.getGame().getClient();
    }

    /**
     * Gets the {@link SystemSubject} instance from the {@link Game} instance.
     *
     * @see Game#getSystemSubject() ()
     * @return The system subject
     */
    public static SystemSubject getSystemSubject() {
        return Sponge.getGame().getSystemSubject();
    }

    /**
     * Gets the {@link MetricsConfigManager} instance, allowing data/metric gathering
     * systems to determine whether they have permission to gather server
     * metrics.
     *
     * @return The {@link MetricsConfigManager} instance
     */
    public static MetricsConfigManager getMetricsConfigManager() {
        return Sponge.getGame().getMetricsConfigManager();
    }

    /**
     * Gets the {@link Scheduler} used to schedule async tasks.
     *
     * @return The async scheduler
     */
    public static Scheduler getAsyncScheduler() {
        return Sponge.getGame().getAsyncScheduler();
    }

    /**
     * Gets the {@link CommandManager} for registering and executing commands.
     *
     * @return The {@link CommandManager} instance.
     */
    public static CommandManager getCommandManager() {
        return Sponge.getGame().getCommandManager();
    }

    /**
     * Gets the {@link SqlManager} for grabbing sql data sources.
     *
     * @return The {@link SqlManager} instance.
     */
    public static SqlManager getSqlManager() {
        return Sponge.getGame().getSqlManager();
    }

    /**
     * Gets the {@link Game} scoped {@link ServiceProvider} for providing
     * services.
     *
     * <p>{@link Engine} scoped services, if they exist, can be found on the
     * respective engine.</p>
     *
     * @return The service provider.
     */
    public static ServiceProvider.GameScoped getServiceProvider() {
        return Sponge.getGame().getServiceProvider();
    }
}
