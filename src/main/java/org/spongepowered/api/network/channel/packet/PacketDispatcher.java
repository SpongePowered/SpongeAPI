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
import org.spongepowered.api.world.server.ServerWorld;

import java.util.concurrent.CompletableFuture;

/**
 * Represents a dispatcher of packets.
 */
public interface PacketDispatcher {

    /**
     * Gets whether the packet channel this dispatcher belongs to
     * is supported by the given {@link EngineConnection}.
     *
     * <p>A packet channel is supported if the other side of the connection
     * also supports the channel.</p>
     *
     * @param connection The connection to check
     * @return Whether the packet channel is supported
     */
    boolean isSupportedBy(EngineConnection connection);

    /**
     * Sends the {@link Packet} to all players on the server.
     *
     * <p>A exception will be thrown if the specified packet type
     * isn't registered in the {@link PacketChannel} this dispatcher
     * belongs to.</p>
     *
     * @param packet The packet to send
     */
    default void sendToAllPlayers(final Packet packet) {
        Sponge.getServer().getOnlinePlayers().forEach(player -> this.sendTo(player, packet));
    }

    /**
     * Sends the {@link Packet} to all players in the given world.
     *
     * <p>A exception will be thrown if the specified packet type
     * isn't registered in the {@link PacketChannel} this dispatcher
     * belongs to.</p>
     *
     * @param world The world
     * @param packet The packet to send
     */
    default void sendToAllPlayersIn(final ServerWorld world, final Packet packet) {
        world.getPlayers().forEach(player -> this.sendTo(player, packet));
    }

    /**
     * Sends the packet to the player using this channel. The packet may
     * not be sent if the player doesn't have a registered handler.
     *
     * <p>A exception will be thrown if the specified packet type
     * isn't registered in the {@link PacketChannel} this dispatcher
     * belongs to.</p>
     *
     * @param player The player to send the packet to
     * @param packet The packet to send
     */
    default CompletableFuture<Void> sendTo(final ServerPlayer player, final Packet packet) {
        return this.sendTo(player.getConnection(), packet);
    }

    /**
     * Sends the {@link Packet} to the server.
     *
     * <p>Calling this during the login phase is currently not supported, only
     * responses to {@link RequestPacket}s by {@link RequestPacketHandler}s
     * are. Doing so will result in a {@link IllegalStateException} when attempting
     * to use the method.</p>
     *
     * <p>A exception will be thrown if the specified packet type
     * isn't registered in the {@link PacketChannel} this dispatcher
     * belongs to.</p>
     *
     * @param packet The packet to send
     * @throws IllegalStateException If the server connection isn't in the play phase
     */
    default CompletableFuture<Void> sendToServer(final Packet packet) {
        final EngineConnection connection = Sponge.getClient().getConnection()
                .orElseThrow(() -> new IllegalStateException("The client is currently not connected to a server."));
        return this.sendTo(connection, packet);
    }

    /**
     * Sends the {@link Packet} to the other side of the
     * {@link EngineConnection} using this channel.
     *
     * <p>A exception will be thrown if the specified packet type
     * isn't registered in the {@link PacketChannel} this dispatcher
     * belongs to.</p>
     *
     * @param connection The connection to send the packet to
     * @param packet The packet to send
     */
    CompletableFuture<Void> sendTo(EngineConnection connection, Packet packet);
}
