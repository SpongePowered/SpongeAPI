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

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

/**
 * Called when an {@link Entity} performs movement.
 */
public interface MoveEntityEvent extends TargetEntityEvent, Cancellable {

    /**
     * Fired when an {@link Entity} is changing position.
     */
    interface Position extends MoveEntityEvent {

        /**
         * Gets the location that the {@link Entity} came from.
         *
         * @return The previous location
         */
        Location<World> getFromLocation();

        /**
         * Gets the location that the {@link Entity} is going to.
         *
         * @return The new location
         */
        Location<World> getToLocation();

        /**
         * Sets the new location that the {@link Entity} will go to.
         *
         * @param location The new location
         */
        void setToLocation(Location<World> location);

        /**
         * Fired when an {@link Entity}'s position ends up changing {@link World}s.
         */
        interface Teleport extends Position {

            /**
             * Gets whether the entity teleporting will maintain its velocity
             * after teleport.
             *
             * @return Whether the entity will maintain momentum after teleport
             */
            boolean getKeepsVelocity();

            /**
             * Sets whether the entity teleporting will maintain its velocity
             * after teleport.
             *
             * @param keepsVelocity Whether the entity will maintain velocity
             */
            void setKeepsVelocity(boolean keepsVelocity);
        }
    }

    /**
     * Fired when an {@link Entity} is rotating.
     */
    interface Rotation extends MoveEntityEvent {

        /**
         * Gets the vector representing the rotation the Entity had.
         *
         * @return The rotation
         */
        Vector3d getFromRotation();

        /**
         * Gets the vector representing the rotation the Entity will have.
         *
         * @return The new rotation
         */
        Vector3d getToRotation();

        /**
         * Sets the vector representing the rotation for the Entity to have.
         *
         * @param rotation The new rotation
         */
        void setToRotation(Vector3d rotation);

        /**
         * Fired when a {@link Living}'s head is rotating.
         */
        interface Head extends Rotation {}
    }
}
