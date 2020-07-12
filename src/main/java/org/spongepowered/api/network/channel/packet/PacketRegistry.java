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

import java.util.Collection;
import java.util.Optional;

/**
 * A registry for packets and their bindings.
 *
 * <p>Used opcodes should always be positive values.</p>
 */
public interface PacketRegistry {

    /**
     * Register a packet class to this channel without a receiving handler.
     * This will only allow the packet to be sent, this channel binding
     * will <strong>not</strong> be able to receive the packet.
     *
     * <p>{@link RequestPacket} types may not be registered using this method,
     * they are only supported by
     * {@link TransactionalPacketRegistry#registerTransactional}.</p>
     *
     * @param packetClass The class of the packet being registered. Note:
     *        the class must have a no-args constructor
     * @param packetOpcode A unique opcode for this packet
     * @return The created packet binding
     */
    <P extends Packet> HandlerPacketBinding<P> register(Class<P> packetClass, int packetOpcode);

    /**
     * Gets the {@link PacketBinding} for the given packet class, if the packet
     * type is registered to this channel.
     *
     * @param packetClass The packet class
     * @param <P> The type of the packet
     * @return The packet binding, if found
     */
    <P extends Packet> Optional<PacketBinding<P>> getBinding(Class<P> packetClass);

    /**
     * Gets a collection with all the {@link PacketBinding}s.
     *
     * @return The opcode bindings
     */
    Collection<PacketBinding<?>> getBindings();

    /**
     * Gets the {@link PacketBinding} for the given packet class, if the packet
     * type is registered to this channel.
     *
     * @param opcode The opcode
     * @return The opcode binding, if found
     */
    Optional<PacketBinding<?>> getBinding(int opcode);
}
