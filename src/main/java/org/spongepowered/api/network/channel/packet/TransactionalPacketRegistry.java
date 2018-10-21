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

import java.util.Optional;

/**
 * A registry for packets and their bindings. Also supports transactional packets.
 */
public interface TransactionalPacketRegistry extends PacketRegistry {

    /**
     * Register a request/response packet class pair to this channel. A receiving handler
     * isn't required when sending the request using
     * {@link TransactionalPacketDispatcher#sendTo(EngineConnection, RequestPacket)}.
     *
     * <p>The response packet type may be reused by multiple request types.</p>
     *
     * @param packetOpcode A unique opcode for this request/response packet type pair
     * @param requestPacketType The type of the request packet being registered
     * @param responsePacketType The type of the response packet being registered
     * @return The created transactional packet binding
     */
    <P extends RequestPacket<R>, R extends Packet> FixedTransactionalPacketBinding<P, R> registerTransactional(
            Class<P> requestPacketType, Class<R> responsePacketType, int packetOpcode);

    /**
     * Register a request packet class pair to this channel. A receiving handler
     * isn't required when sending the request using
     * {@link TransactionalPacketDispatcher#sendTo(EngineConnection, RequestPacket)}.
     *
     * <p>Unlike packets registered using {@link #registerTransactional(Class, Class, int)}, multiple response
     * packet types are allowed for the request type. But they need to be registered using
     * {@link #register(Class, int)}.</p>
     *
     * @param packetOpcode A unique opcode for this request packet type
     * @param requestPacketType The type of the request packet being registered
     * @return The created transactional packet binding
     */
    <P extends RequestPacket<R>, R extends Packet> TransactionalPacketBinding<P, R> registerTransactional(
            Class<P> requestPacketType, int packetOpcode);

    /**
     * Gets the {@link TransactionalPacketBinding} for the given {@link RequestPacket} class, if
     * the type is registered to this channel as a transactional binding.
     *
     * @param requestPacketType The request packet type
     * @param <P> The type of the request packet
     * @param <R> The type of the response packet
     * @return The transactional packet binding, if found
     */
    <P extends RequestPacket<R>, R extends Packet> Optional<TransactionalPacketBinding<P, R>> getTransactionalBinding(
            Class<P> requestPacketType);
}
