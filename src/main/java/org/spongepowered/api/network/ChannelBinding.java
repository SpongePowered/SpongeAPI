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
package org.spongepowered.api.network;

import org.spongepowered.api.Platform;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.plugin.PluginContainer;

import java.util.function.Consumer;

/**
 * Represents a network channel bound to a {@link ChannelRegistrar}. The channel
 * can be used to send and receive data. If this binding is removed by
 * {@link ChannelRegistrar#unbindChannel}, all methods will throw
 * {@link IllegalStateException}.
 */
public interface ChannelBinding {

    /**
     * Gets the registrar that this channel is bound to.
     *
     * @return The registrar
     */
    ChannelRegistrar getRegistrar();

    /**
     * Gets this channel's bound name.
     *
     * @return The channel name
     */
    String getName();

    /**
     * Gets the plugin that created this binding.
     *
     * @return The owning plugin
     */
    PluginContainer getOwner();

    /**
     * Represents a channel binding that sends and receives messages.
     */
    interface IndexedMessageChannel extends ChannelBinding {

        /**
         * Register a message class to this channel without a receiving handler.
         * This will only allow the message to be sent, this channel binding
         * will <strong>not</strong> be able to receive the message.
         *
         * <p>The message ID is used to identify this message class as it is
         * sent and received across the network, it is a single byte and thus
         * has a range of 0 to 255.</p>
         *
         * @param messageClass The class of the message being registered. Note:
         *        the class must have a publicly accessible no-args constructor
         * @param messageId A unique ID for this message
         */
        void registerMessage(Class<? extends Message> messageClass, int messageId);

        /**
         * Register a message class to this channel and a handler for receiving
         * the message. The handler is invoked every time the message is sent to
         * <strong>either</strong> side.
         *
         * @param messageClass The class of the message being registered
         * @param messageId A unique ID for this message
         * @param handler The handler that acts upon the message being received
         */
        <M extends Message> void registerMessage(Class<M> messageClass, int messageId, MessageHandler<M> handler);

        /**
         * Register a message class to this channel and a handler for receiving
         * the message. The handler is invoked every time the message is sent to
         * the given side.
         *
         * @param messageClass The class of the message being registered
         * @param messageId A unique ID for this message
         * @param side The side to listen to messages on
         * @param handler The handler that acts upon the message being received
         */
        <M extends Message> void registerMessage(Class<M> messageClass, int messageId, Platform.Type side, MessageHandler<M> handler);

        /**
         * Register a {@link MessageHandler} for a {@link Message}.
         * @param messageClass The class to handle
         * @param side The side being handled
         * @param handler The handler
         * @param <M> The type of message
         */
        <M extends Message> void addHandler(Class<M> messageClass, Platform.Type side, MessageHandler<M> handler);

        /**
         * Register a {@link MessageHandler} for a {@link Message}
         * @param messageClass The class to handle
         * @param handler The handler
         * @param <M> The type of message
         */
        <M extends Message> void addHandler(Class<M> messageClass, MessageHandler<M> handler);

        /**
         * Sends the message to the player across this channel. The message may
         * not be sent if the player doesn't have a registered handler.
         *
         * @param player The player to send the message to
         * @param message The message to send
         */
        void sendTo(Player player, Message message);

        /**
         * Sends the message to the server. The message may not be sent if there
         * is no registered handler. This <strong>must</strong> be called from
         * the client side.
         *
         * @param message The message to send
         */
        void sendToServer(Message message);

        /**
         * Sends the message to all players on the server.
         *
         * @param message The message to send
         */
        void sendToAll(Message message);
    }

    /**
     * Represents a channel that sends and receives raw data.
     */
    interface RawDataChannel extends ChannelBinding {

        /**
         * Adds a listener to this channel that is invoked every time data is
         * sent to it on <strong>either</strong> side.
         *
         * @param listener The listener
         */
        void addListener(RawDataListener listener);

        /**
         * Adds a listener to this channel that is invoked every time data is
         * sent to it on the given side.
         *
         * @param side The side to listen to data on
         * @param listener The listener
         */
        void addListener(Platform.Type side, RawDataListener listener);

        /**
         * Removes the listener from handling data.
         *
         * @param listener The listener
         */
        void removeListener(RawDataListener listener);

        /**
         * Sends the raw payload to the player across this channel. The data may
         * not be sent if the player doesn't have a registered handler.
         *
         * @param player The player to send the message to
         * @param payload A consumer to write the data to
         */
        void sendTo(Player player, Consumer<ChannelBuf> payload);

        /**
         * Sends the raw payload to the server. The data may not be sent if
         * there is no registered handler. This <strong>must</strong> be called
         * from the client side.
         *
         * @param payload A consumer to write the data to
         */
        void sendToServer(Consumer<ChannelBuf> payload);

        /**
         * Sends the raw payload to all players on the server.
         *
         * @param payload A consumer to write the data to
         */
        void sendToAll(Consumer<ChannelBuf> payload);

    }

}
