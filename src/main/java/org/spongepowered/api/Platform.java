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
package org.spongepowered.api;

import org.spongepowered.plugin.PluginContainer;

import java.util.Map;

/**
 * Represents a possible platform or implementation a {@link Game} could be
 * running on.
 */
public interface Platform {

    String API_ID = "spongeapi";

    /**
     * Retrieves the current {@link Type} this platform is running on.
     *
     * @return The current type
     */
    Type getType();

    /**
     * Retrieves the current {@link Type} the platform is executing on.
     *
     * <p>A Minecraft instance will have a client and server thread. If the
     * server is executing, this will return {@linkplain Type#SERVER} but
     * {@link Platform#getType()} would return {@linkplain Type#CLIENT}.</p>
     *
     * @return The execution type
     */
    Type getExecutionType();

    /**
     * Returns the {@link PluginContainer} for the specified platform
     * {@link Component}.
     *
     * @param component The platform component
     * @return The plugin container for the component
     */
    PluginContainer getContainer(Component component);

    /**
     * Gets the current Minecraft version of this platform.
     *
     * @return The Minecraft version
     */
    MinecraftVersion getMinecraftVersion();

    /**
     * Returns this platform instance, as a key-value map.
     *
     * <p>The returned map instance is connected directly to this platform
     * instance. Existing keys like name and version are not modifiable, but
     * new keys are stored in this instance and are shared between any
     * references to a map obtained through the retrieved map.</p>
     *
     * <p>This mechanism allows for platform-specific information like Forge
     * version.</p>
     *
     * @return This platform as a map
     */
    Map<String, Object> asMap();

    /**
     * The type of the platform, or where the game is currently running.
     *
     * <p>A side is what part of Minecraft this is being run on. The client, or
     * the server. The internal server is also treated like a dedicated server.
     * </p>
     */
    enum Type {

        /**
         * The platform of a Minecraft CLIENT is expected.
         */
        CLIENT,

        /**
         * The platform of a Minecraft SERVER is expected.
         */
        SERVER,

        /**
         * It is unknown what platform the game is running on.
         */
        UNKNOWN;

        /**
         * Checks for whether the platform is {@link #SERVER}.
         *
         * @return True if the platform is {@link #SERVER}, false otherwise
         */
        public boolean isServer() {
            return this == SERVER;
        }

        /**
         * Checks for whether the platform is {@link #CLIENT}.
         *
         * @return True if the platform is {@link #CLIENT}, false otherwise
         */
        public boolean isClient() {
            return this == CLIENT;
        }

        /**
         * Checks for whether the platform is known.
         *
         * @return False if the platform is {@link #UNKNOWN}, true otherwise
         */
        public boolean isKnown() {
            return this != UNKNOWN;
        }

    }

    /**
     * Represents a part of the {@link Platform}.
     */
    enum Component {

        /**
         * The platform the {@link #IMPLEMENTATION} is based on.
         */
        GAME,

        /**
         * The abstraction layer for plugins.
         */
        API,

        /**
         * The implementation of the {@link #API} component.
         */
        IMPLEMENTATION

    }

}
