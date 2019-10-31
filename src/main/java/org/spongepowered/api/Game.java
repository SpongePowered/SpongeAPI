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
import org.spongepowered.api.config.ConfigManager;
import org.spongepowered.api.data.DataManager;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.event.CauseStackManager;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.network.ChannelRegistrar;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.api.scheduler.Scheduler;
import org.spongepowered.api.service.ServiceManager;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.TeleportHelper;

import java.nio.file.Path;

/**
 * The core accessor of the API. The implementation uses this to pass
 * constructed objects.
 */
public interface Game {

    /**
     * Gets the current {@link GameState} that this game is currently in.
     *
     * @return The game state
     */
    GameState getState();

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
    default Platform getPlatform() {
        return Sponge.getPlatform();
    }

    /**
     * Gets the {@link GameRegistry}.
     *
     * @return The game registry
     */
    default GameRegistry getRegistry() {
        return Sponge.getRegistry();
    }

    /**
     * Gets the {@link DataManager} instance to register
     * {@link DataSerializable}s, and get the related {@link DataBuilder}s.
     *
     * @return The serialization service
     */
    default DataManager getDataManager() {
        return Sponge.getDataManager();
    }

    /**
     * Gets the {@link PluginManager}.
     *
     * @return The plugin manager
     */
    default PluginManager getPluginManager() {
        return Sponge.getPluginManager();
    }

    /**
     * Gets the {@link EventManager}.
     *
     * @return The event manager
     */
    default EventManager getEventManager() {
        return Sponge.getEventManager();
    }

    /**
     * Gets the {@link AssetManager}.
     *
     * @return The asset manager
     */
    default AssetManager getAssetManager() {
        return Sponge.getAssetManager();
    }

    /**
     * Gets the {@link ConfigManager} used to load and manage configuration files
     * for plugins.
     *
     * @return The configuration manager
     */
    default ConfigManager getConfigManager() {
        return Sponge.getConfigManager();
    }

    /**
     * Gets the game's instance of the service manager, which is the gateway
     * to various services provided by Sponge (command registration and so on).
     *
     * <p>Services registered by other plugins may be available too.</p>
     *
     * @return The service manager
     */
    default ServiceManager getServiceManager() {
        return Sponge.getServiceManager();
    }

    /**
     * Gets the {@link ChannelRegistrar} for creating network channels.
     *
     * @return The channel registrar
     */
    default ChannelRegistrar getChannelRegistrar() {
        return Sponge.getChannelRegistrar();
    }


    /**
     * Gets the {@link TeleportHelper}, used to find safe {@link Location}s.
     * @return The teleport helper
     */
    default TeleportHelper getTeleportHelper() {
        return Sponge.getTeleportHelper();
    }

    /**
     * Gets the {@link CauseStackManager} for handling the current event cause
     * stack and context information.
     *
     * @return The cause stack manager
     */
    default CauseStackManager getCauseStackManager() {
        return Sponge.getCauseStackManager();
    }

}
