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
package org.spongepowered.api.network.channel.packet;

import org.spongepowered.api.network.channel.ChannelException;
import org.spongepowered.api.network.EngineConnection;
import org.spongepowered.api.network.channel.NoResponseException;

/**
 * A specialized {@link PacketHandler} to handle response {@link Packet}s.
 *
 * @param <P> The type of the request packet
 * @param <R> The type of the response packet
 */
@FunctionalInterface
public interface ResponsePacketHandler<P extends Packet, R extends Packet, C extends EngineConnection> {

    /**
     * Handles the response {@link Packet} sent by a client connection.
     *
     * @param responsePacket The response packet that was received
     * @param requestPacket The packet that was send to request the response
     * @param connection The connection that sent the packet
     */
    void handleResponse(R responsePacket, P requestPacket, C connection);

    /**
     * Handles the failure of a response {@link Packet}. The {@link ChannelException} which
     * causes the failure will usually be a {@link NoResponseException}, this is caused
     * by the other side ignoring the request or failing to send a response.
     *
     * @param exception The exception that caused the failure
     * @param requestPacket The packet that was send to request the response
     * @param connection The remote connection that received the failure
     */
    default void handleFailure(ChannelException exception, P requestPacket, C connection) {
    }
}
