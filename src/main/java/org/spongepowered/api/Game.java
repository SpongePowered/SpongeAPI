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

import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.api.config.ConfigManager;
import org.spongepowered.api.data.DataManager;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.network.channel.ChannelManager;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.api.registry.BuilderProvider;
import org.spongepowered.api.registry.FactoryProvider;
import org.spongepowered.api.registry.RegistryHolder;
import org.spongepowered.api.scheduler.Scheduler;
import org.spongepowered.api.service.ServiceProvider;
import org.spongepowered.api.sql.SqlManager;
import org.spongepowered.api.util.metric.MetricsConfigManager;

import java.nio.file.Path;
import java.util.Locale;

/**
 * The core accessor of the API. The implementation uses this to pass
 * constructed objects.
 */
public interface Game extends RegistryHolder {

    /**
     * Gets the async {@link Scheduler}.
     *
     * @return The async scheduler
     */
    Scheduler asyncScheduler();

    /**
     * Gets the directory where the game's files are located.
     *
     * @return The game directory
     */
    Path gameDirectory();

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
    Server server();

    /**
     * Gets the {@link SystemSubject}. Depending on the implementation, this
     * may also represent the game console.
     *
     * @return The {@link SystemSubject}
     */
    SystemSubject systemSubject();

    /**
     * Gets a locale for the specified locale code, e.g. {@code en_US}.
     *
     * @param locale The locale to lookup (e.g. {@code en_US}.
     * @return The locale
     */
    Locale locale(@NonNull String locale);

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
    default Client client() {
        throw new UnsupportedEngineException("The client engine is not supported.");
    }

    /**
     * Returns the current platform, or implementation, this {@link Game} is running on.
     *
     * @return The current implementation
     */
    Platform platform();

    /**
     * Retrieves the {@link BuilderProvider}.
     *
     * @return The builder provider
     */
    BuilderProvider builderProvider();

    /**
     * Retrieves the {@link FactoryProvider}.
     *
     * @return The factory provider
     */
    FactoryProvider factoryProvider();

    /**
     * Gets the {@link DataManager} instance to register
     * {@link DataSerializable}s, and get the related {@link DataBuilder}s.
     *
     * @return The serialization service
     */
    DataManager dataManager();

    /**
     * Gets the {@link PluginManager}.
     *
     * @return The plugin manager
     */
    PluginManager pluginManager();

    /**
     * Gets the {@link EventManager}.
     *
     * @return The event manager
     */
    EventManager eventManager();

    /**
     * Gets the {@link ConfigManager} used to load and manage configuration files
     * for plugins.
     *
     * @return The configuration manager
     */
    ConfigManager configManager();

    /**
     * Gets the {@link ChannelManager} for creating network channels.
     *
     * @return The channel manager
     */
    ChannelManager channelManager();

    /**
     * Gets the {@link MetricsConfigManager} instance, allowing data/metric gathering
     * systems to determine whether they have permission to gather server
     * metrics.
     *
     * @return The {@link MetricsConfigManager} instance
     */
    MetricsConfigManager metricsConfigManager();

    /**
     * Gets the {@link SqlManager} for grabbing sql data sources.
     *
     * @return The {@link SqlManager} instance.
     */
    SqlManager sqlManager();

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
    ServiceProvider.GameScoped serviceProvider();
}
