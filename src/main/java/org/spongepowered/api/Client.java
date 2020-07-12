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

import org.spongepowered.api.entity.living.player.client.ClientPlayer;
import org.spongepowered.api.entity.living.player.client.LocalPlayer;
import org.spongepowered.api.client.LocalServer;
import org.spongepowered.api.network.ClientSideConnection;
import org.spongepowered.api.world.client.ClientWorld;

import java.util.Optional;

/**
 * Represents a typical Minecraft Client.
 */
public interface Client extends Engine {

    /**
     * Gets the {@link ClientPlayer player} responsible
     * for controlling this client.
     *
     * <p>
     *     A client may not always have a local player if browsing menus prior to joining a
     *     world or server.
     * </p>
     *
     * @return The local player or {@link Optional#empty()} if it is not found
     */
    Optional<LocalPlayer> getPlayer();

    /**
     * Gets the {@link LocalServer server} that powers a local SinglePlayer game instance
     * of a typical Minecraft client.
     *
     * <p>
     *     A client will not have a local server if it is outside of SinglePlayer
     * </p>
     *
     * @return The local server or {@link Optional#empty()} if it is not found
     */
    Optional<LocalServer> getServer();

    /**
     * Gets the {@link ClientWorld world} that a typical Minecraft client will be viewing
     * while in some game instance (local or remote).
     *
     * <p>
     *     A client will not have a client world if it is browsing the main menus
     * </p>
     *
     * @return The client world or {@link Optional#empty()}} if it is not found
     */
    Optional<ClientWorld> getWorld();

    /**
     * Gets the {@link ClientSideConnection} that is currently active, this is only the case
     * if the client is connected to a server.
     *
     * @return The client side connection, if present
     */
    Optional<ClientSideConnection> getConnection();
}
