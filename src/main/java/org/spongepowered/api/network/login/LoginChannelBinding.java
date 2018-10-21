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
package org.spongepowered.api.network.login;

import org.spongepowered.api.network.ChannelBinding;
import org.spongepowered.api.network.ChannelBuf;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * A base class for {@link ChannelBinding}s that are
 * applicable during the login phase.
 */
public interface LoginChannelBinding extends ChannelBinding {

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
         * @param messageId A unique ID for this message
         * @param requestMessageClass The class of the request message being registered
         */
        void registerMessage(Class<? extends LoginMessage.Request<LoginMessage.Response>> requestMessageClass, int messageId);

        /**
         * Register a message class to this channel without a receiving handler.
         * This will only allow the message to be sent, this channel binding
         * will <strong>not</strong> be able to receive the message.
         *
         * <p>The message ID is used to identify this message class as it is
         * sent and received across the network, it is a single byte and thus
         * has a range of 0 to 255.</p>
         *
         * @param messageId A unique ID for this message
         * @param requestMessageClass The class of the request message being registered
         * @param responseMessageClass The class of the response message being registered
         */
        <L extends LoginMessage.Request<R>, R extends LoginMessage.Response> void registerMessage(
                Class<L> requestMessageClass, Class<R> responseMessageClass, int messageId);

        /**
         * Sends the message to the player across this channel. The message may
         * not be sent if the player doesn't have a registered handler.
         *
         * @param loginConnectionContext The login connection context to send the message to
         * @param message The request message to send
         */
        <R extends LoginMessage.Response> CompletableFuture<Optional<R>> sendTo(
                LoginChannelContext loginConnectionContext, LoginMessage.Request<R> message);
    }

    /**
     * Represents a login channel that sends and receives raw data.
     */
    interface RawDataChannel extends LoginChannelBinding {

        /**
         * Sends the payload {@link ChannelBuf} to the client for the
         * {@link LoginChannelContext}. The client will respond
         * with a {@link ChannelBuf} if the payload got handled or
         * {@link Optional#empty()} if the channel didn't get handled.
         *
         * @param loginConnectionContext The login connection context
         * @param payload The payload of the context
         * @return A completable future to handle the response of the payload message
         */
        CompletableFuture<Optional<ChannelBuf>> sendTo(LoginChannelContext loginConnectionContext, ChannelBuf payload);
    }
}
