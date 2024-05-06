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
    public static final Class<EngineConnectionStates> ALL = EngineConnectionStates.class;

    public static final Class<EngineConnectionIntentState> INTENT = EngineConnectionIntentState.class;

    public static final Class<EngineConnectionLoginState> LOGIN = EngineConnectionLoginState.class;

    public static final Class<EngineConnectionConfigurationState> CONFIGURATION = EngineConnectionConfigurationState.class;

    public static final Class<EngineConnectionGameState> GAME = EngineConnectionGameState.class;

    /**
     * The supertype of all the known client connection states.
     */
    public static final Class<ClientConnectionState> CLIENT_SIDE = ClientConnectionState.class;

    public static final Class<ClientConnectionIntentState> CLIENT_INTENT = ClientConnectionIntentState.class;

    public static final Class<ClientConnectionLoginState> CLIENT_LOGIN = ClientConnectionLoginState.class;

    public static final Class<ClientConnectionConfigurationState> CLIENT_CONFIGURATION = ClientConnectionConfigurationState.class;

    public static final Class<ClientConnectionGameState> CLIENT_GAME = ClientConnectionGameState.class;

    /**
     * The supertype of all the known server connection states.
     */
    public static final Class<ServerConnectionState> SERVER_SIDE = ServerConnectionState.class;

    public static final Class<ServerConnectionIntentState> SERVER_INTENT = ServerConnectionIntentState.class;

    public static final Class<ServerConnectionLoginState> SERVER_LOGIN = ServerConnectionLoginState.class;

    public static final Class<ServerConnectionConfigurationState> SERVER_CONFIGURATION = ServerConnectionConfigurationState.class;

    public static final Class<ServerConnectionGameState> SERVER_GAME = ServerConnectionGameState.class;
}
