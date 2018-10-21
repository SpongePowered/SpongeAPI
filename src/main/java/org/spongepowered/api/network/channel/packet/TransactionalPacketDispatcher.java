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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.network.EngineConnection;
import org.spongepowered.api.network.channel.NoResponseException;

import java.util.concurrent.CompletableFuture;

/**
 * A packet dispatcher which supports transactional packets.
 */
public interface TransactionalPacketDispatcher extends PacketDispatcher {

    /**
     * Sends the {@link Packet} to the player using this channel. This method returns a
     * {@link CompletableFuture} that will be accepted once the response is received.
     *
     * <p>The {@link CompletableFuture} may fail exceptionally by a
     * {@link NoResponseException} if there wasn't a valid response
     * received for the given request.</p>
     *
     * <p>A exception will be thrown if the specified packet type
     * isn't registered in this {@link PacketChannel}.</p>
     *
     * @param player The player to send the packet to
     * @param packet The request packet to send
     * @return The completable future to handle the response packet and exceptions
     * @throws IllegalArgumentException If the given packet type isn't registered in this channel binding
     */
    default <R extends Packet> CompletableFuture<R> sendTo(final ServerPlayer player, final RequestPacket<R> packet) {
        return this.sendTo(player.getConnection(), packet);
    }

    /**
     * Sends the {@link Packet} to the client using this channel. This method returns a
     * {@link CompletableFuture} that will be accepted once the response is received.
     *
     * <p>The {@link CompletableFuture} may fail exceptionally by a
     * {@link NoResponseException} if there wasn't a valid response
     * received for the given request.</p>
     *
     * <p>A exception will be thrown if the specified packet type
     * isn't registered in this {@link PacketChannel}.</p>
     *
     * @param connection The player connection to send the packet to
     * @param packet The request packet to send
     * @return The completable future to handle the response packet and exceptions
     * @throws IllegalArgumentException If the given packet type isn't registered in this channel binding
     */
    <R extends Packet> CompletableFuture<R> sendTo(EngineConnection connection, RequestPacket<R> packet);

    /**
     * Sends the {@link Packet} to the server using this channel. This method returns a
     * {@link CompletableFuture} that will be accepted once the response is received.
     *
     * <p>The {@link CompletableFuture} may fail exceptionally by a
     * {@link NoResponseException} if there wasn't a valid response
     * received for the given request.</p>
     *
     * <p>A exception will be thrown if the specified packet type
     * isn't registered in this {@link PacketChannel}.</p>
     *
     * @param packet The packet to send to the server
     * @return The completable future to handle the response packet and exceptions
     */
    default <R extends Packet> CompletableFuture<R> sendToServer(final RequestPacket<R> packet) {
        final EngineConnection connection = Sponge.getClient().getConnection()
                .orElseThrow(() -> new IllegalStateException("The client is currently not connected to a server."));
        return this.sendTo(connection, packet);
    }
}
