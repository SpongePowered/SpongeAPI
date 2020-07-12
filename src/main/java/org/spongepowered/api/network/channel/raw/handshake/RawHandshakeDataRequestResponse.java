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
import org.spongepowered.api.network.channel.ChannelException;
import org.spongepowered.api.network.channel.NoResponseException;
import org.spongepowered.api.network.channel.packet.Packet;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Represents a callback for the response of a request payload.
 */
public interface RawHandshakeDataRequestResponse {

    /**
     * Sets the response of the request payload as failed
     * with the given {@link ChannelException}.
     *
     * <p>If this response fails, then will other side of the
     * connection end up with a {@link NoResponseException}.</p>
     *
     * @param exception The exception
     */
    void fail(ChannelException exception);

    /**
     * Sets the response of the request payload as success
     * with the given response payload.
     *
     * @param response The response payload
     */
    void success(Consumer<ChannelBuf> response);
}
