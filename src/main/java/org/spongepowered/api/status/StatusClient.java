/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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
package org.spongepowered.api.status;

import com.google.common.base.Optional;
import org.spongepowered.api.MinecraftVersion;

import java.net.InetSocketAddress;

/**
 * Represents a client requesting a {@link StatusResponse}. Unlike normal player
 * connections, it may not have the same version as the server.
 */
public interface StatusClient {

    /**
     * Gets the address of the client.
     *
     * @return The address of the client
     */
    InetSocketAddress getAddress();

    /**
     * Gets the game version of the client.
     *
     * @return The version of the client
     */
    MinecraftVersion getVersion();

    /**
     * Gets the address the player is connecting to.
     *
     * @return The address the player is connecting to, or
     *         {@link Optional#absent()} if not available (for example because
     *         of {@link MinecraftVersion#isLegacy()}).
     */
    Optional<InetSocketAddress> getVirtualHost();

}
