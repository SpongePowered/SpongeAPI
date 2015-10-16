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
package org.spongepowered.api.event.entity;

import com.google.common.collect.Lists;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.event.world.TargetWorldEvent;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.explosion.Explosion;

import java.util.List;
import java.util.function.Predicate;

/**
 * An event that affects multiple {@link Entity} instances as a bulk action.
 * The constraint is that if an action can be deemed as necessary for selective
 * individualized processing, such as {@link InteractEntityEvent.Attack},
 * the actioned {@link Event} is handled individually. If a bulk of
 * {@link Entity} instances are being affected, for example by an
 * {@link Explosion} "damaging" a varying amount of {@link Entity} instances.
 * Other cases will be included as necessary.
 */
public interface AffectEntityEvent extends TargetWorldEvent, Cancellable, CauseTracked {

    /**
     * Gets an {@link List<EntitySnapshot>} of the entity data
     * un-affected by event changes.
     *
     * @return The ImmutableList
     */
    List<EntitySnapshot> getEntitySnapshots();

    /**
     * Gets the {@link List<Entity>} who will be affected after event
     * resolution.
     *
     * @return The List
     */
    List<Entity> getEntities();

    /**
     * Filters out {@link Location<World>}'s from
     * {@link AffectEntityEvent#getEntities()} to be affected by this event.
     *
     * <p>Locations for which the predicate returns <code>false</code> will
     * be removed from {@link #getEntities()}.</p>
     *
     * @param predicate The predicate to use for filtering
     * @return The entities removed from {@link #getEntities()}
     */
    default List<Entity> filterEntityLocations(Predicate<Location<World>> predicate) {
        List<Entity> removedEntites = Lists.newArrayList();
        for (Entity entity: this.getEntities()) {
            if (!predicate.test(entity.getLocation())) {
                removedEntites.add(entity);
            }
        }
        this.getEntities().removeAll(removedEntites);
        return removedEntites;
    }

    /**
     * Filters out {@link Entity}'s from {@link AffectEntityEvent#getEntities()}
     * to be affected by this event.
     *
     * <p>Entities for which the predicate returns <code>false</code> will
     * be removed from {@link #getEntities()}.</p>
     *
     * @param predicate The predicate to use for filtering
     * @return The entities removed from {@link #getEntities()}
     */
    default List<? extends Entity> filterEntities(Predicate<Entity> predicate) {
        List<Entity> removedEntites = Lists.newArrayList();
        for (Entity entity: this.getEntities()) {
            if (!predicate.test(entity)) {
                removedEntites.add(entity);
            }
        }
        this.getEntities().removeAll(removedEntites);
        return removedEntites;
    }
}
