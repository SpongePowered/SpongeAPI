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
package org.spongepowered.api.event.network;

import org.spongepowered.api.entity.living.player.ClientPlayer;
import org.spongepowered.api.entity.living.player.ClientPlayerController;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.message.MessageEvent;
import org.spongepowered.api.network.RemoteConnection;
import org.spongepowered.api.network.ServerConnection;
import org.spongepowered.api.network.status.StatusResponse;

import java.util.Optional;

/**
 * Represents an event fired during the login process on the client. For server
 * side login events, see {@link ClientConnectionEvent}.
 */
public interface ServerConnectionEvent extends Event {

    /**
     * Called when the client attempts to connect to a server.
     *
     * <p>At this point, there is no world or player entity on the client.</p>
     */
    interface Login extends ServerConnectionEvent, Cancellable {

        /**
         * Gets the remote connection of the server.
         *
         * @return The remote connection
         */
        RemoteConnection getConnection();

        /**
         * Gets the server's status response if it was pinged before joining.
         *
         * @return The status
         */
        Optional<StatusResponse> getStatusResponse();

    }

    /**
     * Called once the client is in the world and has control.
     *
     * <p>The world, player, and controller should exist at this point.</p>
     */
    interface Join extends ServerConnectionEvent {

        /**
         * Gets the client controller.
         *
         * @return The controller
         */
        ClientPlayerController getController();

    }

    /**
     * Fired when the client disconnects from a server for any reason.
     */
    interface Disconnect extends ServerConnectionEvent, MessageEvent {

        ClientPlayer getPlayer();

        ServerConnection getConnection();

    }
}
