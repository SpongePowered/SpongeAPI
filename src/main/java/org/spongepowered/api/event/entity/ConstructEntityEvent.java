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

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.world.ServerLocation;
import org.spongepowered.math.vector.Vector3d;

/**
 * Base event during the construction of an {@link Entity}.
 */
public interface ConstructEntityEvent extends Event {

    /**
     * Gets the {@link ServerLocation location} the {@link Entity} will construct at.
     *
     * @return The location
     */
    ServerLocation getLocation();

    /**
     * Gets the {@link Vector3d rotation} the {@link Entity} will construct to.
     *
     * @return The rotation
     */
    Vector3d getRotation();

    /**
     * Gets the {@link EntityType} of the target {@link Entity} that is going to be
     * constructed.
     *
     * @return The target entity type
     */
    EntityType<?> getTargetType();

    /**
     * Called before the construction of an {@link Entity}. Usually, this will
     * occur whenever an {@link Entity} is going to be instantiated. The only thing known
     * for the event is the {@link EntityType}.
     *
     * <p>Note: This does not cover all Entity construction. A best effort is
     * made to capture as many as we can.</p>
     */
    interface Pre extends ConstructEntityEvent, Cancellable {}

    /**
     * Called after the construction of an {@link Entity}.
     *
     * <p>Note: This takes before spawning.</p>
     */
    interface Post extends ConstructEntityEvent {

        /**
         * Gets the {@link Entity}.
         *
         * @return The entity
         */
        Entity getEntity();
    }

}
