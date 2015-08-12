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

import com.google.common.base.Optional;
import org.spongepowered.api.GameProfile;
import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.network.RemoteConnection;
import org.spongepowered.api.text.Text;

import javax.annotation.Nullable;

/**
 * Represents an event fired during the login process.
 *
 * @see GameClientAuthEvent
 * @see GameClientConnectEvent
 */
public interface GameClientLoginEvent extends GameEvent, ConnectEvent {

    /**
     * Gets the {@link RemoteConnection} representing the client connection.
     *
     * @return The remote connection
     */
    RemoteConnection getConnection();

    /**
     * Gets the profile of the client attempting to connect.
     *
     * @return The client's profile
     */
    GameProfile getProfile();

    /**
     * Gets the disconnect message that will show to the client if the event is
     * cancelled.
     *
     * @return The disconnect message
     */
    Optional<Text> getDisconnectMessage();

    /**
     * Sets the disconnect message that will show to the client if the event is
     * cancelled. Passing null will will result in the message being set by the
     * server if the event is cancelled.
     *
     * @param message The disconnect message
     */
    void setDisconnectMessage(@Nullable Text message);

    /**
     * Gets the currently set reason why the client will be disconnected if the
     * event is cancelled.
     *
     * @return The reason for disconnecting, if set
     */
    Optional<Cause> getDisconnectCause();

    /**
     * Sets the cause for disconnecting the client if the event is cancelled.
     * Passing null will result in the cause being set by the server if the
     * event is cancelled.
     *
     * @param cause The cause
     */
    void setDisconnectCause(@Nullable Cause cause);
}
