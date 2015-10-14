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

import java.util.Set;

/**
 * A registrar handling custom payloads via {@link ChannelBinding}s to and from
 * {@link PlayerConnection}s and the server.
 */
public interface ChannelRegistrar {

    /**
     * Creates a new channel binding for the given channel name. The channel can
     * be used to send and receive messages.
     *
     * @param plugin The plugin registering the channel
     * @param channel The channel to register
     * @return A new {@link ChannelBinding} instance bound to the channel name
     * @throws ChannelRegistrationException The channel name is too long
     * @throws ChannelRegistrationException The channel name is reserved
     */
    ChannelBinding.IndexedMessageChannel createChannel(Object plugin, String channel) throws ChannelRegistrationException;

    /**
     * Creates a new raw channel binding. The channel can be used to send and
     * Receive data from {@link ChannelBuf} objects.
     *
     * @param plugin The plugin registering the channel
     * @param channel The channel to register
     * @return A new {@link ChannelBinding} instance bound to the channel name
     * @throws ChannelRegistrationException The channel name is too long
     * @throws ChannelRegistrationException The channel name is reserved
     * @see #createChannel
     */
    ChannelBinding.RawDataChannel createRawChannel(Object plugin, String channel) throws ChannelRegistrationException;

    /**
     * Remove the channel binding from this registrar, freeing up the channel
     * name. All method calls on the channel binding instance will now throw
     * {@link IllegalStateException}.
     *
     * @param channel The channel to unbind
     */
    void unbindChannel(ChannelBinding channel);

    /**
     * Gets the set of registered channels.
     *
     * @param side The side to get the registered channels from
     * @return A copy of the list of channels
     */
    Set<String> getRegisteredChannels(Platform.Type side);

    /**
     * Returns whether the given channel name is available for creating with
     * {@link #createChannel}.
     *
     * @param channelName The channel name to test
     * @return True if available
     */
    boolean isChannelAvailable(String channelName);

}
