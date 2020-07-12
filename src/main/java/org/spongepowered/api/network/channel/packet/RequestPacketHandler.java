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

import org.spongepowered.api.network.EngineConnection;
import org.spongepowered.api.network.channel.ChannelException;
import org.spongepowered.api.network.RemoteConnection;

/**
 * Represents a packet handler for {@link RequestPacket}s.
 *
 * @param <P> The request packet type
 * @param <R> The response packet type
 */
@FunctionalInterface
public interface RequestPacketHandler<P extends Packet, R extends Packet, C extends EngineConnection> {

    /**
     * Handles the {@link RequestPacket} which was send by a specific
     * {@link RemoteConnection}. A proper response {@link Packet} should
     * be answered with.
     *
     * <p>Throwing a {@link ChannelException} during the execution of
     * this handler will automatically be applied to the
     * {@link RequestPacketResponse}.</p>
     *
     * <p>Every handled request should apply the proper response to
     * {@link RequestPacketResponse}. Responding doesn't have to be
     * instantly and can be from a concurrent context, but it shouldn't
     * take minutes.</p>
     *
     * @param requestPacket The received request packet
     * @param connection The connection that sent the packet
     * @param response The response which should be completed
     */
    void handleRequest(P requestPacket, C connection, RequestPacketResponse<R> response);
}
