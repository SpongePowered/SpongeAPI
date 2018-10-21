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
package org.spongepowered.api.network.channel.raw;

import org.spongepowered.api.network.channel.Channel;
import org.spongepowered.api.network.EngineConnection;
import org.spongepowered.api.network.channel.raw.handshake.RawHandshakeDataChannel;
import org.spongepowered.api.network.channel.raw.play.RawPlayDataChannel;

/**
 * Represents a channel that sends and receives raw data. This
 * channel has two sub-channels, {@link RawHandshakeDataChannel} which
 * can be used during the handshake phase and {@link RawPlayDataChannel}
 * which can be used during the play phase.
 */
public interface RawDataChannel extends Channel {

    /**
     * Gets the {@link RawHandshakeDataChannel} which can be used during
     * the handshake phase of a {@link EngineConnection}.
     *
     * @return The raw handshake data channel
     */
    RawHandshakeDataChannel handshake();

    /**
     * Gets the {@link RawPlayDataChannel} which can be used during
     * the play phase of a {@link EngineConnection}.
     *
     * @return The raw play data channel
     */
    RawPlayDataChannel play();
}
