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
package org.spongepowered.api.event.entity.living.player;

import net.kyori.adventure.resource.ResourcePackInfo;
import net.kyori.adventure.resource.ResourcePackStatus;
import org.spongepowered.api.Server;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.network.ServerSideConnection;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.eventgen.annotations.GenerateFactoryMethod;

import java.util.Optional;

/**
 * Called when a {@link ServerSideConnection connection} notifies the {@link Server} of the
 * status of a resource pack change request.
 */
@GenerateFactoryMethod
public interface ResourcePackStatusEvent extends Event {

    /**
     * Gets the {@link ServerSideConnection connection}.
     *
     * @return The connection
     */
    ServerSideConnection connection();

    /**
     * Gets the {@link GameProfile profile} associated
     * with this connection.
     *
     * @return The profile
     */
    GameProfile profile();

    /**
     * Gets the {@link ServerPlayer player}.
     *
     * @return The player, or {@link Optional#empty()} if the
     * player is in the configuration state.
     */
    Optional<ServerPlayer> player();

    /**
     * Gets the pack that this status corresponds to.
     *
     * @return The pack that this status corresponds to.
     */
    ResourcePackInfo pack();

    /**
     * Gets the status of the sent pack.
     *
     * @return The status of the sent pack.
     */
    ResourcePackStatus status();
}
