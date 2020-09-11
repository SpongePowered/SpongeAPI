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

import org.spongepowered.api.asset.AssetManager;
import org.spongepowered.api.command.manager.CommandManager;
import org.spongepowered.api.config.ConfigManager;
import org.spongepowered.api.data.DataManager;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.network.channel.ChannelRegistry;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.api.registry.GameRegistry;
import org.spongepowered.api.scheduler.Scheduler;
import org.spongepowered.api.sql.SqlManager;
import org.spongepowered.api.util.metric.MetricsConfigManager;
import org.spongepowered.api.service.ServiceProvider;

import java.nio.file.Path;
import java.util.Locale;

/**
 * The core accessor of the API. The implementation uses this to pass
 * constructed objects.
 */
public interface Game {

    /**
     * Gets the async {@link Scheduler}.
     *
     * @return The async scheduler
     */
    Scheduler getAsyncScheduler();

    /**
     * Gets the directory where the game's files are located.
     *
     * @return The game directory
     */
    Path getGameDirectory();

    /**
     * Returns if the {@link Server} is available for use. The result of this method is entirely
     * dependent on the implementation.
     *
     * @return True if the Server is available, false if not
     */
    boolean isServerAvailable();

    /**
     * Gets the {@link Server}.
     *
     * @return The server
     * @throws IllegalStateException If the Server isn't currently available
     */
    Server getServer();

    /**
     * Gets the {@link SystemSubject}. Depending on the implementation, this
     * may also represent the game console.
     *
     * @return The {@link SystemSubject}
     */
    SystemSubject getSystemSubject();

    /**
     * Gets a locale for the specified locale code, e.g. {@code en_US}.
     *
     * @param locale The locale to lookup (e.g. {@code en_US}.
     * @return The locale
     */
    Locale getLocale(String locale);

    /**
     * Returns if the {@link Client} is available for use. The result of this method is entirely
     * dependent on the implementation.
     *
     * @return True if the Client is available, false if not
     */
    default boolean isClientAvailable() {
        return false;
    }

    /**
     * Gets the {@link Client}.
     *
     * @return The client
     * @throws UnsupportedEngineException If the client engine is not supported
     * @throws IllegalStateException If the Client isn't currently available
     */
    default Client getClient() {
        throw new UnsupportedEngineException("The client engine is not supported.");
    }

    /**
     * Returns the current platform, or implementation, this {@link Game} is running on.
     *
     * @return The current implementation
     */
    Platform getPlatform();

    /**
     * Gets the {@link GameRegistry}.
     *
     * @return The game registry
     */
    GameRegistry getRegistry();

    /**
     * Gets the {@link DataManager} instance to register
     * {@link DataSerializable}s, and get the related {@link DataBuilder}s.
     *
     * @return The serialization service
     */
    DataManager getDataManager();

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
     * Gets the {@link AssetManager}.
     *
     * @return The asset manager
     */
    AssetManager getAssetManager();

    /**
     * Gets the {@link ConfigManager} used to load and manage configuration files
     * for plugins.
     *
     * @return The configuration manager
     */
    ConfigManager getConfigManager();

    /**
     * Gets the {@link ChannelRegistry} for creating network channels.
     *
     * @return The channel registry
     */
    ChannelRegistry getChannelRegistry();

    /**
     * Gets the {@link MetricsConfigManager} instance, allowing data/metric gathering
     * systems to determine whether they have permission to gather server
     * metrics.
     *
     * @return The {@link MetricsConfigManager} instance
     */
    MetricsConfigManager getMetricsConfigManager();

    /**
     * Gets the {@link CommandManager} for registering and executing commands.
     *
     * @return The {@link CommandManager} instance.
     */
    CommandManager getCommandManager();

    /**
     * Gets the {@link SqlManager} for grabbing sql data sources.
     *
     * @return The {@link SqlManager} instance.
     */
    SqlManager getSqlManager();

    /**
     * Gets the {@link ServiceProvider.GameScoped}, used to provide Sponge
     * services that plugins may provide. Services provided here are
     * scoped to the lifetime of the Game.
     *
     * <p>The provider will not be available during plugin construction and will
     * throw an {@link IllegalStateException} if there is an attempt to access
     * this before the provider is ready.</p>
     *
     * @return The service manager
     */
    ServiceProvider.GameScoped getServiceProvider();
}
