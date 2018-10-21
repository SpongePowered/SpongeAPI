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
package org.spongepowered.api.network.channel.packet.basic;

import org.spongepowered.api.network.EngineConnection;
import org.spongepowered.api.network.channel.packet.Packet;
import org.spongepowered.api.network.channel.packet.RequestPacket;
import org.spongepowered.api.network.channel.packet.TransactionalPacketDispatcher;

import java.util.concurrent.CompletableFuture;

/**
 * Represents the packet dispatcher of the
 * {@link org.spongepowered.api.event.network.ServerSideConnectionEvent.Handshake} phase.
 */
public interface BasicHandshakePacketDispatcher extends TransactionalPacketDispatcher {

    /**
     * {@inheritDoc}
     *
     * <p>The basic packet channel is currently not aware whether it's supported
     * during the handshake phase. The dispatcher assumes that a basic channel is always
     * supported during the handshake phase.</p>
     *
     * @deprecated Is currently not supported by the basic packet channel during the handshake phase
     */
    @Deprecated
    @Override
    default boolean isSupportedBy(EngineConnection connection) {
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The basic packet channel doesn't currently support packets to be send
     * to the server during the handshake phase. Only responses to requests by the
     * server are possible.</p>
     *
     * @deprecated Is currently not supported by the basic packet channel
     */
    @Deprecated
    @Override
    <R extends Packet> CompletableFuture<R> sendToServer(RequestPacket<R> packet);

    /**
     * {@inheritDoc}
     *
     * <p>The basic packet channel currently doesn't support packets to be send
     * to the server during the handshake phase. Only responses to requests by the
     * server are possible.</p>
     *
     * @deprecated Is currently not supported by the basic packet channel
     */
    @Deprecated
    @Override
    CompletableFuture<Void> sendToServer(Packet packet);
}
