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

import com.google.inject.Inject;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.asset.AssetManager;
import org.spongepowered.api.command.manager.CommandManager;
import org.spongepowered.api.config.ConfigManager;
import org.spongepowered.api.data.DataManager;
import org.spongepowered.api.event.CauseStackManager;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.network.ChannelRegistrar;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.api.scheduler.Scheduler;
import org.spongepowered.api.service.ServiceManager;
import org.spongepowered.api.util.metric.MetricsConfigManager;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.TeleportHelper;

/**
 * A static all access class granting static access to various systems
 * for the API.
 */
@SuppressWarnings("NullableProblems")
public final class Sponge {

    @Inject private static Game game;
    @Inject private static Platform platform;
    @Inject private static GameRegistry registry;
    @Inject private static DataManager dataManager;
    @Inject private static PluginManager pluginManager;
    @Inject private static EventManager eventManager;
    @Inject private static AssetManager assetManager;
    @Inject private static ConfigManager configManager;
    @Inject private static ServiceManager serviceManager;
    @Inject private static ChannelRegistrar channelRegistrar;
    @Inject private static TeleportHelper teleportHelper;
    @Inject private static CauseStackManager causeStackManager;
    @Inject private static MetricsConfigManager metricsConfigManager;
    @Inject private static CommandManager commandManager;

    private static <T> T check(@Nullable T instance) {
        checkState(instance != null, "Sponge has not been initialized!");
        return instance;
    }

    /**
     * Gets the {@link Game} instance. There is ever only going
     * to be a single game instance at any given time, except during
     * the various extraneous {@link GameState}s that the game instance
     * is otherwise unavailable.
     *
     * @return The game instance
     */
    public static Game getGame() {
        return check(game);
    }

    /**
     * Returns the current platform, or implementation, this {@link Game}
     * is running on.
     *
     * @return The current implementation
     */
    public static Platform getPlatform() {
        return check(platform);
    }

    /**
     * Gets the {@link GameRegistry} instance.
     *
     * @return The game registry instance
     */
    public static GameRegistry getRegistry() {
        return check(registry);
    }

    /**
     * Gets the {@link DataManager} instance.
     *
     * @return The data manager instance
     */
    public static DataManager getDataManager() {
        return check(dataManager);
    }

    /**
     * Gets the {@link PluginManager} instance.
     *
     * @return The plugin manager instance
     */
    public static PluginManager getPluginManager() {
        return check(pluginManager);
    }

    /**
     * Gets the {@link EventManager} instance.
     *
     * @return The event manager instance
     */
    public static EventManager getEventManager() {
        return check(eventManager);
    }

    /**
     * Gets the {@link AssetManager} instance.
     *
     * @return The asset manager instance
     */
    public static AssetManager getAssetManager() {
        return check(assetManager);
    }

    /**
     * Gets the {@link ConfigManager} used to load and manage configuration files
     * for plugins.
     *
     * @return The configuration manager
     */
    public static ConfigManager getConfigManager() {
        return check(configManager);
    }

    /**
     * Gets the game's instance of the service manager, which is the gateway
     * to various services provided by Sponge (command registration and so on).
     *
     * <p>Services registered by other plugins may be available too.</p>
     *
     * @return The service manager
     */
    public static ServiceManager getServiceManager() {
        return check(serviceManager);
    }

    /**
     * Gets the {@link ChannelRegistrar} for creating network channels.
     *
     * @return The channel registrar
     */
    public static ChannelRegistrar getChannelRegistrar() {
        return check(channelRegistrar);
    }

    /**
     * Gets the {@link TeleportHelper}, used to find safe {@link Location}s.
     *
     * @return The teleport helper
     */
    public static TeleportHelper getTeleportHelper() {
        return check(teleportHelper);
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
     * Gets the {@link SystemSubject} instance from the {@link Game} instance.
     *
     * @see Game#getSystemSubject() ()
     * @return The system subject
     */
    public static SystemSubject getSystemSubject() {
        return getGame().getSystemSubject();
    }

    /**
     * Gets the {@link CauseStackManager} instance from the
     * {@link Game} instance.
     *
     * @see Game#getCauseStackManager()
     * @return The cause stack manager instance
     */
    public static CauseStackManager getCauseStackManager() {
        return check(causeStackManager);
    }

    /**
     * Gets the {@link MetricsConfigManager} instance, allowing data/metric gathering
     * systems to determine whether they have permission to gather server
     * metrics.
     *
     * @return The {@link MetricsConfigManager} instance
     */
    public static MetricsConfigManager getMetricsConfigManager() {
        return check(metricsConfigManager);
    }

    /**
     * Gets the {@link Scheduler} used to schedule async tasks.
     *
     * @return The async scheduler
     */
    public static Scheduler getAsyncScheduler() {
        return getGame().getAsyncScheduler();
    }

    /**
     * Gets the {@link CommandManager} for registering and executing commands.
     *
     * @return The {@link CommandManager} instance.
     */
    public static CommandManager getCommandManager() {
        return check(commandManager);
    }
}
