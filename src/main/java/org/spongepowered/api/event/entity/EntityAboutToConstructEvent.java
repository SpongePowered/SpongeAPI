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
package org.spongepowered.api.event.entity;

import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.util.event.Cancellable;
import org.spongepowered.api.world.Location;

/**
 * Represents an event where an entity is about to be constructed and
 * may be spawned in a world.
 *
 * <p>This event allows plugins to cancel the creation of entities
 * purely based on the {@link EntityType} and {@link Location}. This
 * aids in massive object churning that would otherwise occur in
 * massive cancellation of {@link EntitySpawnEvent}s due to the
 * instantiation of entities and subsequently killing said entities.</p>
 */
public interface EntityAboutToConstructEvent extends GameEvent, CauseTracked, Cancellable {

    /**
     * Gets the {@link EntityType} that is going to be constructed.
     *
     * @return The entity type
     */
    EntityType getEntityType();

    /**
     * Gets the {@link Location} of the entity that is going to be constructed.
     *
     * @return The location that the entity would spawn at
     */
    Location getLocation();

}
