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

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.network.ServerConnection;
import org.spongepowered.api.util.ThreadContext;
import org.spongepowered.api.world.World;

import java.net.InetSocketAddress;
import java.nio.file.Path;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * Represents the Minecraft client.
 */
public interface Client extends ThreadContext {

    /**
     * Gets the currently loaded world, if any.
     *
     * @return The current world
     */
    Optional<World> getLoadedWorld();

    /**
     * Gets the current client player entity, if it exists.
     *
     * @return The client player
     */
    Optional<Player> getClientPlayer();

    /**
     * Gets the current integrated server instance if it is running.
     *
     * @return The integrated server
     */
    Optional<LocalServer> getIntegratedServer();

    /**
     * Loads a world save with the given name.
     *
     * @param saveLocation The location of the save
     * @return A future containing the Server object.
     */
    CompletableFuture<LocalServer> loadWorldSave(Path saveLocation);

    /**
     * Joins a server.
     *
     * @param server The server to join
     * @return A future containing the server connection object
     */
    CompletableFuture<ServerConnection> joinServer(InetSocketAddress server);

    /**
     * Gets the {@link ServerConnection} to the current server.
     *
     * @return The server connection
     */
    Optional<ServerConnection> getServerConnection();

    /**
     * Gets the directory resource packs are stored in.
     *
     * @return The directory for resource packs
     */
    Path getResourcePacksDirectory();

    /**
     * Gets the directory game assets are located and should be stored in.
     *
     * @return The directory for assets
     */
    Path getAssetsDirectory();

}
