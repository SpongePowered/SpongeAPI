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
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.config.ConfigManager;
import org.spongepowered.api.data.DataManager;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.event.lifecycle.LifecycleEvent;
import org.spongepowered.api.network.channel.ChannelManager;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.api.scheduler.Scheduler;
import org.spongepowered.api.service.ServiceProvider;
import org.spongepowered.api.sql.SqlManager;
import org.spongepowered.api.util.metric.MetricsConfigManager;

/**
 * A static all access class granting static access to various systems
 * for the API.
 */
public final class Sponge {

    @Inject private @Nullable static Game game;

    /**
     * Gets the {@link Game} instance. There is ever only going
     * to be a single game instance at any given time.
     *
     * @return The game instance
     */
    public static Game game() {
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
    public static Platform platform() {
        return Sponge.game().platform();
    }

    /**
     * Gets the {@link DataManager} instance.
     *
     * @return The data manager instance
     */
    public static DataManager dataManager() {
        return Sponge.game().dataManager();
    }

    /**
     * Gets the {@link PluginManager} instance.
     *
     * @return The plugin manager instance
     */
    public static PluginManager pluginManager() {
        return Sponge.game().pluginManager();
    }

    /**
     * Gets the {@link EventManager} instance.
     *
     * @return The event manager instance
     */
    public static EventManager eventManager() {
        return Sponge.game().eventManager();
    }

    /**
     * Gets the {@link ConfigManager} used to load and manage configuration files
     * for plugins.
     *
     * @return The configuration manager
     */
    public static ConfigManager configManager() {
        return Sponge.game().configManager();
    }

    /**
     * Gets the {@link ChannelManager} for creating network channels.
     *
     * @return The channel registry
     */
    public static ChannelManager channelManager() {
        return Sponge.game().channelManager();
    }

    /**
     * Gets whether a {@link Server} instance is available without throwing an
     * exception from calling {@link #server()}.
     *
     * @see Game#isServerAvailable()
     * @return True if the server instance is available
     */
    public static boolean isServerAvailable() {
        return Sponge.game().isServerAvailable();
    }

    /**
     * Gets the {@link Server} instance from the {@link Game} instance.
     *
     * <p>Note: During various {@link LifecycleEvent events}, a {@link Server} instance
     * may <strong>NOT</strong> be available. Calling {@link Game#server()} during one
     * will throw an exception. To double check, call {@link #isServerAvailable()}</p>
     *
     * @see Game#server()
     * @see Game#isServerAvailable()
     * @return The server instance
     */
    public static Server server() {
        return Sponge.game().server();
    }

    /**
     * Gets whether a {@link Client} instance is available without throwing an
     * exception from calling {@link #client()}.
     *
     * @see Game#isClientAvailable()
     * @return True if the client instance is available
     */
    public static boolean isClientAvailable() {
        return Sponge.game().isClientAvailable();
    }

    /**
     * Gets the {@link Client} instance from the {@link Game} instance.
     *
     * <p>Note: Not all implementations support a client, consult your
     * vendor for further information.</p>
     *
     * @see Game#client()
     * @see Game#isClientAvailable()
     * @return The client instance
     */
    public static Client client() {
        return Sponge.game().client();
    }

    /**
     * Gets the {@link SystemSubject} instance from the {@link Game} instance.
     *
     * @see Game#systemSubject() ()
     * @return The system subject
     */
    public static SystemSubject systemSubject() {
        return Sponge.game().systemSubject();
    }

    /**
     * Gets the {@link MetricsConfigManager} instance, allowing data/metric gathering
     * systems to determine whether they have permission to gather server
     * metrics.
     *
     * @return The {@link MetricsConfigManager} instance
     */
    public static MetricsConfigManager metricsConfigManager() {
        return Sponge.game().metricsConfigManager();
    }

    /**
     * Gets the {@link Scheduler} used to schedule async tasks.
     *
     * @return The async scheduler
     */
    public static Scheduler asyncScheduler() {
        return Sponge.game().asyncScheduler();
    }

    /**
     * Gets the {@link SqlManager} for grabbing sql data sources.
     *
     * @return The {@link SqlManager} instance.
     */
    public static SqlManager sqlManager() {
        return Sponge.game().sqlManager();
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
    public static ServiceProvider.GameScoped serviceProvider() {
        return Sponge.game().serviceProvider();
    }
}
