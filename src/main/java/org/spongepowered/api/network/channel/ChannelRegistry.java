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
package org.spongepowered.api.network.channel;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.network.EngineConnection;

import java.util.Collection;
import java.util.Optional;

/**
 * A registry handling custom payloads via {@link Channel}s to and from
 * {@link EngineConnection}s.
 */
public interface ChannelRegistry {

    /**
     * Gets a channel binding if a channel exists for the given key.
     *
     * @param channelKey The channel key
     * @return The channel if it exists
     */
    Optional<Channel> get(ResourceKey channelKey);

    /**
     * Gets a {@link Channel} by the given channel key. If the channel exists
     * and it matches the given channel type, it is returned. If the channel
     * doesn't match a {@link IllegalStateException} is thrown.
     *
     * @param channelKey The channel key
     * @param channelType The channel type
     * @return A new or existing channel binding
     * @throws IllegalStateException if the existing channel is not of the given type
     */
    <C extends Channel> C getOfType(ResourceKey channelKey, Class<C> channelType);

    /**
     * Gets an immutable collection of all the channels that are registered.
     *
     * @return The channels
     */
    Collection<Channel> getChannels();
}
