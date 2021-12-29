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
package org.spongepowered.api.event.world;

import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.entity.AffectEntityEvent;
import org.spongepowered.api.event.impl.world.AbstractDetonateEvent;
import org.spongepowered.api.util.annotation.eventgen.ImplementedBy;
import org.spongepowered.api.util.annotation.eventgen.PropertySettings;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.explosion.Explosion;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.api.world.server.ServerWorld;

import java.util.List;
import java.util.function.Predicate;

/**
 * Called when an {@link Explosion} occurs in a {@link World}.
 */
public interface ExplosionEvent extends Event, Cancellable {

    /**
     * Gets the {@link Explosion}.
     *
     * @return The explosion
     */
    Explosion explosion();

    /**
     * An event that is fired before the explosion occurs.
     */
    interface Pre extends ExplosionEvent {

        /**
         * Gets the {@link ServerWorld world}.
         *
         * @return The world
         */
        ServerWorld world();

        /**
         * Sets the {@link Explosion} involved for this event. This will
         * override the explosion used before calculations take place with
         * regards to the blocks and entities affected.
         *
         * @param explosion The new explosion
         */
        void setExplosion(Explosion explosion);

    }

    /**
     * An event that is fired as the explosion is going to start affecting
     * multiple blocks and entities. Note that none of the locations have
     * been affected yet as this is mainly an event when an explosion has
     * already calculated all the blocks and entities the explosion should
     * affect.
     */
    @ImplementedBy(value = AbstractDetonateEvent.class, priority = 2)
    interface Detonate extends ExplosionEvent, AffectEntityEvent {

        /**
         * Gets the {@link ServerWorld world}.
         *
         * @return The world
         */
        ServerWorld world();

        /**
         * Gets the list of calculated affected locations for blocks that will
         * be removed due to the explosion.
         * This list can only be modified using {@link #filterAffectedLocations(Predicate)}.
         *
         * @return The list of blocks that will be affected by the explosion
         */
        @PropertySettings(requiredParameter = true, generateMethods = false)
        List<ServerLocation> affectedLocations();

        /**
         * Filters out {@link ServerLocation}'s from
         * {@link #affectedLocations()} to be affected by this event.
         *
         * <p>Locations for which the predicate returns <code>false</code> will
         * be removed from {@link #affectedLocations()}.</p>
         *
         * @param predicate The predicate to use for filtering
         */
        void filterAffectedLocations(Predicate<ServerLocation> predicate);
    }

}
