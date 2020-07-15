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

import org.spongepowered.api.network.channel.ChannelBuf;
import org.spongepowered.api.network.EngineConnection;
import org.spongepowered.api.network.channel.NoResponseException;
import org.spongepowered.api.network.channel.packet.RequestPacketResponse;

/**
 * Handles a raw handshake data request.
 */
@FunctionalInterface
public interface RawHandshakeDataRequestHandler<C extends EngineConnection> {

    /**
     * Handles the request data {@link ChannelBuf} for the given
     * {@link EngineConnection} and returns a response.
     *
     * <p>Throwing a {@link NoResponseException} will result in
     * a {@link NoResponseException} on the other side of
     * the connection.</p>
     *
     * <p>Every handled request should apply the proper response to
     * {@link RawHandshakeDataRequestResponse}. Responding doesn't have to be
     * instantly and can be from a concurrent context, but it shouldn't
     * take minutes.</p>
     *
     * @param request The request channel buf
     * @param connection The connection that received the request data
     * @param response The response which should be completed
     */
    void handleRequest(ChannelBuf request, C connection, RawHandshakeDataRequestResponse response);
}
