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

import org.spongepowered.api.entity.living.player.client.LocalPlayer;

/**
 * Represents the state of the connection
 * from the client to the server on the client side.
 */
public interface ClientConnectionState extends EngineConnectionState {

    /**
     * Represents the intent state of the connection
     * from the client to the server on the client side.
     */
    interface Intent extends EngineConnectionState.Intent, ClientConnectionState {
    }

    /**
     * Represents the authenticated state of the connection
     * from the client to the server on the client side.
     */
    interface Authenticated extends EngineConnectionState.Authenticated, ClientConnectionState {
    }

    /**
     * Represents the login state of the connection
     * from the client to the server on the client side.
     */
    interface Login extends EngineConnectionState.Login, Authenticated {
    }

    /**
     * Represents the configuration state of the connection
     * from the client to the server on the client side.
     */
    interface Configuration extends EngineConnectionState.Configuration, Authenticated {
    }

    /**
     * Represents the game state of the connection
     * from the client to the server on the client side.
     */
    interface Game extends EngineConnectionState.Game, Authenticated {

        /**
         * Gets the associated {@link LocalPlayer player} for this connection state.
         *
         * @return The associated player
         */
        @Override
        LocalPlayer player();
    }
}
