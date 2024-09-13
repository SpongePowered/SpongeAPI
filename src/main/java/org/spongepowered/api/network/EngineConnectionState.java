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

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.profile.GameProfile;

/**
 * Represents the current state of the connection
 * on the server or client engine.
 */
public interface EngineConnectionState {

    /**
     * Gets whatever the connection was established because
     * the client was transferred.
     *
     * @return {@code true} if the client was transferred.
     */
    boolean transferred();

    /**
     * Represents the intent state of the connection
     * on the server or client engine.
     */
    interface Intent extends EngineConnectionState {
    }

    /**
     * Represents the authenticated state of the connection
     * on the server or client engine.
     */
    interface Authenticated extends EngineConnectionState {

        /**
         * Gets the associated {@link GameProfile profile} for this connection state.
         *
         * @return The associated profile
         */
        GameProfile profile();
    }

    /**
     * Represents the login state of the connection
     * on the server or client engine.
     */
    interface Login extends Authenticated {
    }

    /**
     * Represents the connection state of the connection
     * on the server or client engine.
     */
    interface Configuration extends Authenticated {
    }

    /**
     * Represents the game state of the connection
     * on the server or client engine.
     */
    interface Game extends Authenticated {

        /**
         * Gets the associated {@link Player player} for this connection state.
         *
         * @return The associated player
         */
        Player player();
    }
}
