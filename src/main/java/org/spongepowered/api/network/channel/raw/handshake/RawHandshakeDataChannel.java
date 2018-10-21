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
package org.spongepowered.api.network.channel.raw.handshake;

import org.spongepowered.api.network.EngineConnection;
import org.spongepowered.api.network.EngineConnectionSide;
import org.spongepowered.api.network.channel.ChannelBuf;
import org.spongepowered.api.network.channel.NoResponseException;
import org.spongepowered.api.network.channel.raw.RawDataChannel;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Represents a raw login data channel. This channel can only send
 * raw data to a {@link EngineConnection} during its handshake phase.
 */
public interface RawHandshakeDataChannel {

    /**
     * Gets the parent {@link RawDataChannel}.
     *
     * @return The raw data channel
     */
    RawDataChannel parent();

    /**
     * Sets the {@link RawHandshakeDataRequestHandler} on the given connection side.
     *
     * @param side The connection side the handler should be set on
     * @param handler The handler to set
     */
    <C extends EngineConnection> void setRequestHandler(EngineConnectionSide<C> side, RawHandshakeDataRequestHandler<? super C> handler);

    /**
     * Sets the {@link RawHandshakeDataRequestHandler} for the given connection type.
     *
     * @param connectionType The connection type the handler should be used by
     * @param handler The handler to set
     */
    <C extends EngineConnection> void setRequestHandler(Class<C> connectionType, RawHandshakeDataRequestHandler<? super C> handler);

    /**
     * Sets the {@link RawHandshakeDataRequestHandler} on the
     * both the client and server sides.
     *
     * @param handler The handler to set
     */
    void setRequestHandler(RawHandshakeDataRequestHandler<EngineConnection> handler);

    /**
     * Sends a request message {@link ChannelBuf} to
     * the {@link EngineConnection}.
     *
     * <p>The {@link CompletableFuture} may fail exceptionally by a
     * {@link NoResponseException} if there wasn't a valid response
     * received for the given request.</p>
     *
     * @param connection The client connection to send the request to
     * @param payload The payload provider of the request
     * @return The completable future of the response
     */
    CompletableFuture<ChannelBuf> sendTo(EngineConnection connection, Consumer<ChannelBuf> payload);
}
