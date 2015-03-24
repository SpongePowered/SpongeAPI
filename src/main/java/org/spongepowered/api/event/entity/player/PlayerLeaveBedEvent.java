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
package org.spongepowered.api.event.entity.player;

import com.google.common.base.Optional;
import org.spongepowered.api.event.entity.living.human.HumanLeaveBedEvent;
import org.spongepowered.api.world.Location;

/**
 * Called when a Player leaves a bed.
 */
public interface PlayerLeaveBedEvent extends HumanLeaveBedEvent, PlayerSleepEvent {

    /**
     * Gets whether the spawn location for the player was set.
     *
     * @return Whether the spawn location for the player was set
     */
    @Override
    boolean wasSpawnSet();

    /**
     * Gets the spawn location of the player when leaving the bed.
     *
     * <p>This may have not been set by the event, so checking
     * {@link #wasSpawnSet()} is advisable. If spawn has not been set,
     * it will return {@link Optional#absent()}.</p>
     *
     * @return The players new spawn location, if available
     */
    @Override
    Optional<Location> getSpawnLocation();

    /**
     * Sets the new spawn location of the player leaving the bed.
     *
     * <p>If spawn {@link #wasSpawnSet} was not infact set by this event,
     * this does not override the return value. The given spawn should be
     * a valid location.</p>
     *
     * @param location The new spawn location for the player
     */
    @Override
    void setSpawnLocation(Location location);

}
