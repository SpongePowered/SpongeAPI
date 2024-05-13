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
import org.spongepowered.api.network.EngineConnectionState;

import java.util.concurrent.CompletableFuture;

/**
 * A packet binding that represents a request/response pair. One side of a connection
 * can send a {@link RequestPacket} and the other side will normally respond with a
 * response {@link Packet}.
 *
 * <p>Request/response pairs share an opcode, a additional byte will specify whether it's a
 * request, response or a no-response.</p>
 *
 * @param <P> The type of the request packet
 * @param <R> The type of the response packet
 */
public interface TransactionalPacketBinding<P extends RequestPacket<R>, R extends Packet> extends PacketBinding<P> {

    /**
     * Gets the opcode of the {@link TransactionalPacketBinding}. This opcode
     * will be shared by the request and response {@link Packet}s.
     *
     * @return The opcode
     */
    @Override
    int opcode();

    /**
     * Gets the type of the {@link RequestPacket}.
     *
     * @return The request packet type
     */
    @Override
    Class<P> packetType();

    /**
     * Sets the {@link RequestPacketHandler} to handle a {@link RequestPacket}
     * for a specific connection type. The difference with a normal {@link PacketHandler}
     * is that it requires a response {@link Packet} as return value.
     *
     * @param connectionState The connection state the request packet should be handled by
     * @param handler The handler of the request packet
     * @param <S> The connection state
     * @return This packet binding, for chaining
     */
    <S extends EngineConnectionState> TransactionalPacketBinding<P, R> setRequestHandler(
            Class<S> connectionState, RequestPacketHandler<? super P, ? extends R, ? super S> handler);

    /**
     * Sets the {@link RequestPacketHandler} to handle a {@link RequestPacket}
     * on both connection sides. The difference with a normal {@link PacketHandler}
     * is that it requires a response {@link Packet} as return value.
     *
     * @param handler The handler of the request packet
     * @return This packet binding, for chaining
     */
    TransactionalPacketBinding<P, R> setRequestHandler(RequestPacketHandler<? super P, ? extends R, EngineConnectionState> handler);

    /**
     * Adds a {@link PacketHandler} to handle a response {@link Packet}
     * on for a specific connection type.
     *
     * <p>Binding a response {@link PacketHandler} is completely optional. It is also
     * possible to append a handler to the {@link CompletableFuture} returned by
     * {@link PacketChannel#sendTo(EngineConnection, RequestPacket)}.</p>
     *
     * @param connectionState The connection state the response packet should be handled by
     * @param responseHandler The handler of the response packet
     * @param <S> The connection state
     * @return This packet binding, for chaining
     */
    <S extends EngineConnectionState> TransactionalPacketBinding<P, R> addResponseHandler(
            Class<S> connectionState, PacketHandler<? super R, ? super S> responseHandler);

    /**
     * Adds a {@link ResponsePacketHandler} to handle a response {@link Packet}
     * for a specific connection type.
     *
     * <p>Binding a response {@link PacketHandler} is completely optional. It is also
     * possible to append a handler to the {@link CompletableFuture} returned by
     * {@link PacketChannel#sendTo(EngineConnection, RequestPacket)}.</p>
     *
     * @param connectionState The connection state the response packet should be handled by
     * @param handler The handler of the response packet
     * @param <S> The connection state
     * @return This packet binding, for chaining
     */
    <S extends EngineConnectionState> TransactionalPacketBinding<P, R> addResponseHandler(
            Class<S> connectionState, ResponsePacketHandler<? super P, ? super R, ? super S> handler);

    /**
     * Adds a {@link PacketHandler} to handle a response {@link Packet} on both platform sides.
     *
     * <p>Binding a response {@link PacketHandler} is completely optional. It is also
     * possible to append a handler to the {@link CompletableFuture} returned by
     * {@link PacketChannel#sendTo(EngineConnection, RequestPacket)}.</p>
     *
     * @param handler The handler of the response packet
     * @return This packet binding, for chaining
     */
    TransactionalPacketBinding<P, R> addResponseHandler(PacketHandler<? super R, EngineConnectionState> handler);

    /**
     * Adds a {@link ResponsePacketHandler} to handle a response {@link Packet}
     * on both platform sides.
     *
     * <p>Binding a response {@link PacketHandler} is completely optional. It is also
     * possible to append a handler to the {@link CompletableFuture} returned by
     * {@link PacketChannel#sendTo(EngineConnection, RequestPacket)}.</p>
     *
     * @param handler The handler of the response packet
     * @return This packet binding, for chaining
     */
    TransactionalPacketBinding<P, R> addResponseHandler(ResponsePacketHandler<? super P, ? super R, EngineConnectionState> handler);
}
