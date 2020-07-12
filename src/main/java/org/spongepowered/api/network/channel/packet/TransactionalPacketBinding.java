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
import org.spongepowered.api.network.EngineConnectionSide;

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
    int getOpcode();

    /**
     * Gets the type of the {@link RequestPacket}.
     *
     * @return The request packet type
     */
    @Override
    Class<P> getPacketType();

    /**
     * Sets the {@link RequestPacketHandler} to handle a {@link RequestPacket}
     * on a specific connection side. The difference with a normal {@link PacketHandler}
     * is that it requires a response {@link Packet} as return value.
     *
     * @param side The side the request packet should be handled on
     * @param handler The handler of the request packet
     * @return This packet binding, for chaining
     */
    <C extends EngineConnection> TransactionalPacketBinding<P, R> setRequestHandler(
            EngineConnectionSide<C> side, RequestPacketHandler<? super P, ? extends R, ? super C> handler);

    /**
     * Sets the {@link RequestPacketHandler} to handle a {@link RequestPacket}
     * for a specific connection type. The difference with a normal {@link PacketHandler}
     * is that it requires a response {@link Packet} as return value.
     *
     * @param connectionType The connection type the request packet should be handled by
     * @param handler The handler of the request packet
     * @return This packet binding, for chaining
     */
    <C extends EngineConnection> TransactionalPacketBinding<P, R> setRequestHandler(
            Class<C> connectionType, RequestPacketHandler<? super P, ? extends R, ? super C> handler);

    /**
     * Sets the {@link RequestPacketHandler} to handle a {@link RequestPacket}
     * on both connection sides. The difference with a normal {@link PacketHandler}
     * is that it requires a response {@link Packet} as return value.
     *
     * @param handler The handler of the request packet
     * @return This packet binding, for chaining
     */
    TransactionalPacketBinding<P, R> setRequestHandler(RequestPacketHandler<? super P, ? extends R, EngineConnection> handler);

    /**
     * Adds a {@link PacketHandler} to handle a response {@link Packet}
     * on a specific connection side.
     *
     * <p>Binding a response {@link PacketHandler} is completely optional. It is also
     * possible to append a handler to the {@link CompletableFuture} returned by
     * {@link PacketChannel#sendTo(EngineConnection, RequestPacket)}.</p>
     *
     * @param side The side the response packet should be handled on
     * @param handler The handler of the response packet
     * @return This packet binding, for chaining
     */
    <C extends EngineConnection> TransactionalPacketBinding<P, R> addResponseHandler(
            EngineConnectionSide<C> side, PacketHandler<? super R, ? super C> handler);

    /**
     * Adds a {@link PacketHandler} to handle a response {@link Packet}
     * on for a specific connection type.
     *
     * <p>Binding a response {@link PacketHandler} is completely optional. It is also
     * possible to append a handler to the {@link CompletableFuture} returned by
     * {@link PacketChannel#sendTo(EngineConnection, RequestPacket)}.</p>
     *
     * @param connectionType The connection type the response packet should be handled by
     * @param responseHandler The handler of the response packet
     * @return This packet binding, for chaining
     */
    <C extends EngineConnection> TransactionalPacketBinding<P, R> addResponseHandler(
            Class<C> connectionType, PacketHandler<? super R, ? super C> responseHandler);

    /**
     * Adds a {@link ResponsePacketHandler} to handle a response {@link Packet}
     * on a specific connection side.
     *
     * <p>Binding a response {@link PacketHandler} is completely optional. It is also
     * possible to append a handler to the {@link CompletableFuture} returned by
     * {@link PacketChannel#sendTo(EngineConnection, RequestPacket)}.</p>
     *
     * @param side The side the response packet should be handled on
     * @param handler The handler of the response packet
     * @return This packet binding, for chaining
     */
    <C extends EngineConnection> TransactionalPacketBinding<P, R> addResponseHandler(
            EngineConnectionSide<C> side, ResponsePacketHandler<? super P, ? super R, ? super C> handler);

    /**
     * Adds a {@link ResponsePacketHandler} to handle a response {@link Packet}
     * for a specific connection type.
     *
     * <p>Binding a response {@link PacketHandler} is completely optional. It is also
     * possible to append a handler to the {@link CompletableFuture} returned by
     * {@link PacketChannel#sendTo(EngineConnection, RequestPacket)}.</p>
     *
     * @param connectionType The connection type the response packet should be handled by
     * @param handler The handler of the response packet
     * @return This packet binding, for chaining
     */
    <C extends EngineConnection> TransactionalPacketBinding<P, R> addResponseHandler(
            Class<C> connectionType, ResponsePacketHandler<? super P, ? super R, ? super C> handler);

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
    TransactionalPacketBinding<P, R> addResponseHandler(PacketHandler<? super R, EngineConnection> handler);

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
    TransactionalPacketBinding<P, R> addResponseHandler(ResponsePacketHandler<? super P, ? super R, EngineConnection> handler);
}
