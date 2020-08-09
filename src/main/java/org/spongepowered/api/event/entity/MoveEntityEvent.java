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
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.util.annotation.eventgen.AbsoluteSortPosition;
import org.spongepowered.math.vector.Vector3d;

/**
 * Called when an {@link Entity} performs movement.
 */
public interface MoveEntityEvent extends Event, Cancellable {

    /**
     * Gets the {@link Entity}.
     *
     * @return The entity
     */
    @AbsoluteSortPosition(1)
    Entity getEntity();

    /**
     * Gets the {@link Vector3d position} the {@link Entity} came from.
     *
     * @return The original position
     */
    @AbsoluteSortPosition(2)
    Vector3d getOriginalPosition();

    /**
     * Gets the {@link Vector3d position} the {@link Entity} would have been going to.
     *
     * @return The original destination
     */
    @AbsoluteSortPosition(3)
    Vector3d getOriginalDestinationPosition();

    /**
     * Gets the {@link Vector3d position} the {@link Entity} will go to.
     *
     * @return The new position
     */
    @AbsoluteSortPosition(4)
    Vector3d getDestinationPosition();

    /**
     * Sets the new {@link Vector3d position} the {@link Entity} will go to.
     *
     * @param position The new position
     */
    void setDestinationPosition(Vector3d position);
}
