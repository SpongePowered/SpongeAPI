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
package org.spongepowered.api.event.entity.living.player;

import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.util.annotation.eventgen.GenerateFactoryMethod;

/**
 * Called when a {@link ServerPlayer player} riding an entity starts or stops steering it.
 */
@GenerateFactoryMethod
public interface SteerVehicleEvent extends Event, Cancellable {

    /**
     * Get the {@link ServerPlayer player}.
     *
     * @return The player
     */
    ServerPlayer player();

    /**
     * Get whether the player is steering left or right.
     *
     * positive number = left
     * negative number = right
     * zero = none
     *
     * @return The sway
     */
    float sway();

    /**
     * Get whether the player is steering forwards or backwards.
     *
     * positive number = forwards
     * negative number = backwards
     * zero = none
     *
     * @return The surge
     */
    float surge();

    /**
     * Get whether the player is attempting to jump.
     *
     * @return Whether the player is attempting to jump.
     */
    boolean jump();

}
