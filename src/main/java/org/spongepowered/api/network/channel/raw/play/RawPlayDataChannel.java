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
package org.spongepowered.api.network.channel.raw.play;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.network.EngineConnection;
import org.spongepowered.api.network.EngineConnectionSide;
import org.spongepowered.api.network.channel.ChannelBuf;
import org.spongepowered.api.network.channel.packet.Packet;
import org.spongepowered.api.network.channel.packet.PacketChannel;
import org.spongepowered.api.network.channel.raw.RawDataChannel;
import org.spongepowered.api.network.channel.raw.handshake.RawHandshakeDataChannel;
import org.spongepowered.api.world.server.ServerWorld;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Represents a channel that sends and receives raw data. This
 * channel cannot be used during the handshake phase of a
 * {@link EngineConnection}, use {@link RawHandshakeDataChannel}
 * instead.
 */
public interface RawPlayDataChannel {

    /**
     * Gets the parent {@link RawDataChannel}.
     *
     * @return The raw data channel
     */
    RawDataChannel parent();

    /**
     * Gets whether the data channel this sub-channel belongs to
     * is supported by the given {@link EngineConnection}.
     *
     * <p>A data channel is supported if the other side of the connection
     * also supports the channel.</p>
     *
     * @param connection The connection to check
     * @return Whether the packet channel is supported
     */
    boolean isSupportedBy(EngineConnection connection);

    /**
     * Adds a handler to this channel that is invoked every time data is
     * sent to it on <strong>either</strong> side.
     *
     * @param handler The handler
     */
    void addHandler(RawPlayDataHandler<EngineConnection> handler);

    /**
     * Adds a listener to this channel that is invoked every time data is
     * sent to it on the given connection side.
     *
     * @param side The connection side the data will be handled for
     * @param handler The handler
     */
    <C extends EngineConnection> void addHandler(EngineConnectionSide<C> side, RawPlayDataHandler<? super C> handler);

    /**
     * Adds a listener to this channel that is invoked every time data is
     * sent to it on the given connection side.
     *
     * @param connectionType The connection type the data will be handled for
     * @param handler The handler
     */
    <C extends EngineConnection> void addHandler(Class<C> connectionType, RawPlayDataHandler<? super C> handler);

    /**
     * Removes the handler from handling data.
     *
     * @param side The side to remove the handler from
     * @param handler The handler
     */
    <C extends EngineConnection> void removeHandler(EngineConnectionSide<C> side, RawPlayDataHandler<? super C> handler);

    /**
     * Removes the handler from handling data.
     *
     * @param connectionType The connection type to remove the handler from
     * @param handler The handler
     */
    <C extends EngineConnection> void removeHandler(Class<C> connectionType, RawPlayDataHandler<? super C> handler);

    /**
     * Removes the handler from handling data.
     *
     * @param handler The handler
     */
    void removeHandler(RawPlayDataHandler<?> handler);

    /**
     * Sends the raw payload to all players on the server.
     *
     * @param payload A consumer to write the data to
     */
    default void sendToAllPlayers(final Consumer<ChannelBuf> payload) {
        Sponge.getServer().getOnlinePlayers().forEach(player -> this.sendTo(player, payload));
    }

    /**
     * Sends the {@link Packet} to all players in the given world.
     *
     * <p>A exception will be thrown if the specified packet type
     * isn't registered in the {@link PacketChannel} this dispatcher
     * belongs to.</p>
     *
     * @param world The world
     * @param payload A consumer to write the data to
     */
    default void sendToAllPlayersIn(final ServerWorld world, final Consumer<ChannelBuf> payload) {
        world.getPlayers().forEach(player -> this.sendTo(player, payload));
    }

    /**
     * Sends the raw payload to the player across this channel. The data may
     * not be sent if the player doesn't have a registered handler.
     *
     * @param player The player to send the message to
     * @param payload A consumer to write the data to
     */
    default CompletableFuture<Void> sendTo(final ServerPlayer player, final Consumer<ChannelBuf> payload) {
        return this.sendTo(player.getConnection(), payload);
    }

    /**
     * Sends the raw payload to the server. The data may not be sent if
     * there is no registered handler. This <strong>must</strong> be called
     * from the client side.
     *
     * @param payload A consumer to write the data to
     */
    default CompletableFuture<Void> sendToServer(final Consumer<ChannelBuf> payload) {
        final EngineConnection connection = Sponge.getClient().getConnection()
                .orElseThrow(() -> new IllegalStateException("The client is currently not connected to a server."));
        return this.sendTo(connection, payload);
    }

    /**
     * Sends the raw payload to the player across this channel. The data may
     * not be sent if the player doesn't have a registered handler.
     *
     * @param connection The client connection to send the message to
     * @param payload A consumer to write the data to
     */
    CompletableFuture<Void> sendTo(EngineConnection connection, Consumer<ChannelBuf> payload);
}
