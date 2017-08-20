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

import org.spongepowered.api.entity.living.player.ClientPlayerController;
import org.spongepowered.api.network.ServerConnection;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.ChatTypeMessageReceiver;
import org.spongepowered.api.text.chat.ChatType;
import org.spongepowered.api.util.ThreadContext;
import org.spongepowered.api.world.World;

import java.net.InetSocketAddress;
import java.nio.file.Path;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * Represents the Minecraft client.
 */
public interface Client extends ThreadContext, ChatTypeMessageReceiver {

    /**
     * Gets the world the client is currently viewing, if any.
     *
     * @return The world being viewed
     */
    Optional<World> getViewedWorld();

    /**
     * Gets the current client player controller, if it exists.
     *
     * @return The client player
     */
    Optional<ClientPlayerController> getPlayerController();

    /**
     * Displays a message to the player.
     *
     * <p>This delegates to {@link #getPlayerController()} and automatically
     * handles empty.</p>
     */
    @Override
    default void sendMessage(ChatType type, Text message) {
        getPlayerController().ifPresent(p -> p.sendMessage(type, message));
    }

    /**
     * Gets the current local server instance if it is running.
     *
     * @return The local server
     */
    Optional<LocalServer> getLocalServer();

    /**
     * Loads a world save with the given path. It must be inside the saves directory.
     *
     * @param saveLocation The location of the save
     * @return The local server instance in a completable future
     * @see Game#getSavesDirectory()
     */
    CompletableFuture<LocalServer> loadWorldSave(Path saveLocation);

    /**
     * Joins a server.
     *
     * @param server The server to join
     * @return The server connection
     */
    CompletableFuture<ServerConnection> joinServer(InetSocketAddress server);

    /**
     * Gets the {@link ServerConnection} to the current server. This returns
     * for both local and dedicated server connections.
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
     * These assets are shared between game instances.
     *
     * @return The directory for assets
     */
    Path getAssetsDirectory();

}
