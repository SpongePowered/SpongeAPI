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
package org.spongepowered.api.event.server.query;

import java.util.List;
import java.util.Map;

/**
 * Called when the server is queried through the Query protocol, with more detailed information requested.
 */
public interface FullQueryEvent extends BasicQueryEvent {

    /**
     * Gets the GameId to respond with.
     *
     * <p>This is currently hardcoded to <code>MINECRAFT</code>.</p>
     *
     * @return The GameId to respond with.
     */
    String getGameId();

    /**
     * Gets the version to respond with.
     *
     * <p>By default, this is the server's Minecraft version (e.g 1.8.1).</p>
     *
     * @return The version to respond with
     */
    String getVersion();

    /**
     * Sets the version to respond with.
     *
     * <p>If setting the string causes the message to go over the
     * maximum size, the message will be automatically truncated.</p>
     *
     * @param version The version to respond with
     */
    void setVersion(String version);

    /**
     * Gets the list of plugins to respond with.
     *
     * @return The list of plugins to respond with
     */
    String getPlugins();

    /**
     * Sets the list of plugins to respond with.
     *
     * <p>If setting the string causes the message to go over the
     * maximum size, the message will be automatically truncated.</p>
     *
     * @param plugins The list of plugins to respond with
     */
    void setPlugins(String plugins);

    /**
     * Gets the map of custom keys and values to respond with.
     *
     * <p>If settings any of the keys or values causes the message
     * to go oer the maximum size, the message will be automatically
     * truncated.</p>
     *
     * @return The map of custom keys and values to respond with
     */
    Map<String, String> getCustomValuesMap();

    /**
     * Gets the list of player names to respond with.
     *
     * @return The list of player names to respond with
     */
    List<String> getPlayers();
}
