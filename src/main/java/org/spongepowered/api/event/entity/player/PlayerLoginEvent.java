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
package org.spongepowered.api.event.entity.player;

import com.google.common.base.Optional;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.text.Text;

/**
 * This event is called after a player object has been created but before it is placed in any sort of location.
 *
 * <p>This is the best event to use when determining if a player should be kicked because of being banned, unwhitelisted, etc, as well as
 * performing player state initialization.
 */
public interface PlayerLoginEvent extends PlayerEvent, Cancellable, CauseTracked {

    /**
     * Get the message that will be sent to the player logging in.
     * @return The
     */
    Optional<Text> getKickMessage();

    /**
     * Set the message to kick this event's player with. If the event is not already cancelled, calling this method will cancel the event.
     *
     * @param message The message to kick the player with
     */
    void setKickMessage(Text message);

    /**
     * Set the cause for this event being cancelled. If the event is not already cancelled, calling this method will cancel the event.
     *
     * @param cause The cause to set
     */
    void setCause(Cause cause);
}
