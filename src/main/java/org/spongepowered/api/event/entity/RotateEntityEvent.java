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
import org.spongepowered.api.util.annotation.eventgen.GenerateFactoryMethod;
import org.spongepowered.math.vector.Vector3d;

/**
 * Called when an {@link Entity} performs rotation of their body or, if
 * applicable, head without moving their position.
 */
@GenerateFactoryMethod
public interface RotateEntityEvent extends Event, Cancellable {

    /**
     * Gets the {@link Entity}.
     *
     * @return The entity
     */
    @AbsoluteSortPosition(1)
    Entity getEntity();

    /**
     * Gets the rotation the {@link Entity} was performing.
     *
     * @return The rotation
     */
    @AbsoluteSortPosition(2)
    Vector3d getFromRotation();

    /**
     * Gets the {@link Vector3d rotation} the {@link Entity} will perform.
     *
     * @return The new rotation
     */
    @AbsoluteSortPosition(3)
    Vector3d getToRotation();

    /**
     * Sets the new {@link Vector3d rotation} that the {@link Entity} will perform.
     *
     * @param rotation The new rotation
     */
    void setToRotation(Vector3d rotation);
}
