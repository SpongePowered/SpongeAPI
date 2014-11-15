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

package org.spongepowered.api.event.player;

import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.entity.Player;

/**
 * Called when a {@link Player} dies
 */
public interface PlayerDeathEvent extends PlayerEvent, Cancellable {

    /**
     * Get the cause of the player's death.
     *
     * @return The cause of the player's death
     */
    Cause getCause();

    /**
     * Get the location of the player's death.
     *
     * @return The {@link Location} of the player's death
     */
    Location getLocation();

    /**
     * Get the message that will announce the player's death.
     *
     * @return The message that will announce the player's death
     */
    String getDeathAnnouncement();

    /**
     * Get whether the player keeps their inventory on death.
     *
     * @return {@code True} if the player keeps their inventory on death
     */
    boolean getKeepInventory();

    /**
     * Get whether the player keeps all of their EXP on death.
     *
     * @return {@code True} if the player keeps all of their EXP on death
     */
    boolean getKeepLevel();

    /**
     * Set the message that will announce the player's death.
     *
     * @param message The message to show, or {@code null} for no message
     */
    void setDeathAnnouncement(String message);

    /**
     * Sets if the player keeps their inventory on death.
     *
     * @param keepInventory {@code True} if the player should keep inventory
     */
    void setKeepInventory(boolean keepInventory);

    /**
     * Sets if the player keeps all of their EXP on death.
     *
     * @param keepLevel {@code True} if the player should keep all EXP
     */
    void setKeepLevel(boolean keepLevel);

}
