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

/**
 * An enumeration of all the possible engine connection states.
 */
public final class EngineConnectionStates {

    /**
     * The supertype of all the known connection states.
     */
    public static final Class<EngineConnectionState> ALL = EngineConnectionState.class;

    public static final Class<EngineConnectionState.Intent> INTENT = EngineConnectionState.Intent.class;

    /**
     * The supertype of all the connection states where the connection is authenticated.
     */
    public static final Class<EngineConnectionState.Authenticated> AUTHENTICATED = EngineConnectionState.Authenticated.class;

    public static final Class<EngineConnectionState.Login> LOGIN = EngineConnectionState.Login.class;

    public static final Class<EngineConnectionState.Configuration> CONFIGURATION = EngineConnectionState.Configuration.class;

    public static final Class<EngineConnectionState.Game> GAME = EngineConnectionState.Game.class;

    /**
     * The supertype of all the known client connection states.
     */
    public static final Class<ClientConnectionState> CLIENT_SIDE = ClientConnectionState.class;

    public static final Class<ClientConnectionState.Intent> CLIENT_INTENT = ClientConnectionState.Intent.class;

    /**
     * The supertype of all the connection states where the client is authenticated.
     */
    public static final Class<ClientConnectionState.Authenticated> CLIENT_AUTHENTICATED = ClientConnectionState.Authenticated.class;

    public static final Class<ClientConnectionState.Login> CLIENT_LOGIN = ClientConnectionState.Login.class;

    public static final Class<ClientConnectionState.Configuration> CLIENT_CONFIGURATION = ClientConnectionState.Configuration.class;

    public static final Class<ClientConnectionState.Game> CLIENT_GAME = ClientConnectionState.Game.class;

    /**
     * The supertype of all the known server connection states.
     */
    public static final Class<ServerConnectionState> SERVER_SIDE = ServerConnectionState.class;

    public static final Class<ServerConnectionState.Intent> SERVER_INTENT = ServerConnectionState.Intent.class;

    /**
     * The supertype of all the connection states where the client is authenticated.
     */
    public static final Class<ServerConnectionState.Authenticated> SERVER_AUTHENTICATED = ServerConnectionState.Authenticated.class;

    public static final Class<ServerConnectionState.Login> SERVER_LOGIN = ServerConnectionState.Login.class;

    public static final Class<ServerConnectionState.Configuration> SERVER_CONFIGURATION = ServerConnectionState.Configuration.class;

    public static final Class<ServerConnectionState.Game> SERVER_GAME = ServerConnectionState.Game.class;
}
