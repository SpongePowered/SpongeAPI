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

import org.spongepowered.api.event.source.entity.living.human.player.PlayerJoinEvent;

/**
 * Fired when a game client attempts to connect to the server.
 *
 * <p>This event is fired after {@link GameClientAuthEvent}, and in the main
 * thread.</p>
 *
 * <p>This event fires during the login process when the login state is
 * {@code READY_TO_ACCEPT} - after the token has been verified but before the
 * connection state switches to 'play'. See
 * http://wiki.vg/Protocol#Login_Success for the protocol info.</p>
 *
 * <p>The server may have cancelled the event if the client's profile or IP is
 * banned or not on the whitelist (if these features are enabled). Be sure to
 * set {@code ignoreCancelled = false} in the {@code @Subscribe} annotation to
 * receive the event in this case.</p>
 *
 * <p>Cancelling the event will prevent the client from joining and show
 * {@link #getDisconnectMessage} to the client.</p>
 *
 * @see GameClientAuthEvent
 * @see PlayerJoinEvent
 */
public interface GameClientConnectEvent extends GameClientLoginEvent {
}
