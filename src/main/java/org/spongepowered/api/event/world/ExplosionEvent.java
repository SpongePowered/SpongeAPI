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
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.event.entity.AffectEntityEvent;
import org.spongepowered.api.world.ServerLocation;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.explosion.Explosion;
import org.spongepowered.api.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.Iterator;
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
    Explosion getExplosion();

    /**
     * An event that is fired before the explosion occurs.
     */
    interface Pre extends ExplosionEvent {

        /**
         * Gets the {@link ServerWorld world}.
         *
         * @return The world
         */
        ServerWorld getWorld();

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
    interface Detonate extends ExplosionEvent, AffectEntityEvent {

        /**
         * Gets the {@link ServerWorld world}.
         *
         * @return The world
         */
        ServerWorld getWorld();

        /**
         * Gets the list of calculated affected locations for blocks that will
         * be removed due to the explosion. Note that the list is mutable.
         * However, adding new locations may cause unknown effects.
         *
         * @return The list of blocks that will be affected by the explosion
         */
        List<ServerLocation> getAffectedLocations();

        /**
         * Filters out {@link ServerLocation}'s from
         * {@link #getAffectedLocations()} to be affected by this event.
         *
         * <p>Locations for which the predicate returns <code>false</code> will
         * be removed from {@link #getAffectedLocations()}.</p>
         *
         * @param predicate The predicate to use for filtering
         * @return The locations removed from {@link #getAffectedLocations()}
         */
        default List<ServerLocation> filterAffectedLocations(Predicate<ServerLocation> predicate) {
            final List<ServerLocation> removedLocations = new ArrayList<>();

            final Iterator<ServerLocation> iter = this.getAffectedLocations().iterator();
            while (iter.hasNext()) {
                final ServerLocation location = iter.next();

                if (!predicate.test(location)) {
                    iter.remove();
                    removedLocations.add(location);
                }
            }

            return removedLocations;
        }
    }

    /**
     * An event that is fired after the completion of an explosion such that all
     * block changes that took place due to the explosion (including side
     * affected blocks) will be included. This is where the block changes can be
     * updated and/or changed.
     */
    interface Post extends ExplosionEvent, ChangeBlockEvent.Post {}
}
