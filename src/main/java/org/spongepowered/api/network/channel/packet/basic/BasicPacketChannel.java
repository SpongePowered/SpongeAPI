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

import org.spongepowered.api.network.channel.Channel;
import org.spongepowered.api.network.channel.packet.PacketChannel;
import org.spongepowered.api.network.channel.packet.PacketDispatcher;
import org.spongepowered.api.network.channel.packet.TransactionalPacketRegistry;

/**
 * Represents a basic channel binding that sends and receives packets. Each
 * packet type is assigned to an opcode. This channel is compatible with the
 * forge opcode based packet channels, unlike {@link PacketChannel}.
 *
 * <p>There are a few limitations with using this channel. Request/response
 * packets may only be used during the handshake phase using {@link #handshake}.
 * Packets can't be send during the configuration phase.
 * Normal packets may only be send during the play phase.</p>
 */
public interface BasicPacketChannel extends Channel, TransactionalPacketRegistry {

    /**
     * Gets the packet dispatcher which can be used during the handshake phase.
     *
     * @return The handshake packet dispatcher
     */
    BasicHandshakePacketDispatcher handshake();

    /**
     * Gets the packet dispatcher which can be used during the play phase.
     *
     * @return The play packet dispatcher
     */
    PacketDispatcher play();
}
