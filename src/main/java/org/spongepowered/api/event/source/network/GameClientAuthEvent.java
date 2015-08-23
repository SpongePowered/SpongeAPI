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
package org.spongepowered.api.event.source.network;

/**
 * Fired when a game client has authenticated with the server.
 *
 * <p>This event is fired asynchronously, i.e. not in the main thread.</p>
 *
 * <p>After the event is fired, the login state switches to
 * {@code READY_TO_ACCEPT} and the thread dies. (The main thread then
 * acknowledges the {@code READY_TO_ACCEPT} state and proceeds to firing
 * {@link GameClientConnectEvent}). The event is triggered after the encryption
 * response is sent from the client, see
 * http://wiki.vg/Protocol#Encryption_Response for more info.</p>
 *
 * <p>Cancelling the event will prevent the client from joining and show
 * {@link #getDisconnectMessage} to the client.</p>
 *
 * @see GameClientConnectEvent
 */
public interface GameClientAuthEvent extends GameClientLoginEvent {
}
