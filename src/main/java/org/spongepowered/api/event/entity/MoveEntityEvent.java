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
         * Gets the position that the {@link Entity} came from.
         *
         * @return The previous position
         */
        Vector3d getFromPosition();

        /**
         * Gets the original position that the {@link Entity} is going to.
         *
         * @return The original new position
         */
        default Vector3d getOriginalToPosition() {
            return this.getTargetEntity().getLocation().getPosition();
        }

        /**
         * Gets the position that the {@link Entity} is going to.
         *
         * @return The new position
         */
        Vector3d getToPosition();

        /**
         * Sets the new position that the {@link Entity} will go to.
         *
         * @param position The new position
         */
        void setToPosition(Vector3d position);

        /**
         * Fired when an {@link Entity}'s position ends up changing {@link World}s.
         */
        interface Teleport extends Position {

            /**
             * Gets the {@link World} the entity is coming from.
             *
             * @return The previous world
             */
            World getFromWorld();

            /**
             * Gets the original {@link World} the entity is going to.
             *
             * @return The original new world
             */
            World getOriginalToWorld();

            /**
             * Gets the {@link World} the entity is going to.
             *
             * @return The new world
             */
            World getToWorld();

            /**
             * Sets the {@link World} the entity will go to.
             *
             * @param world The new world
             */
            void setToWorld(World world);

            /**
             * Gets the original value of whether the entity teleporting will maintain its velocity
             * after teleport.
             *
             * @return The origianl value of whether the entity will maintain momentum after teleport
             */
            boolean getOriginalKeppsVelocity();

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
         * Gets the original vector representing the rotation the Entity will have.
         *
         * @return The new rotation
         */
        default Vector3d getOriginalToRotation() {
            return this.getTargetEntity().getRotation();
        }

        /**
         * Gets the vector representing the rotation the Entity will have.
         *
         * @return The new rotation
         */
        Vector3d getToRotation();

        /**
         * Sets the original vector representing the rotation for the Entity to have.
         *
         * @param rotation The new rotation
         */
        void setToRotation(Vector3d rotation);

        /**
         * Fired when a {@link Living}'s head is rotating.
         *
         * <p>The vectors in this event are in the form of {@link Living#getHeadRotation()}.
         * While this event will only be fired for changes in the <code>y</code> component,
         * a change made to the <code>x</code> component of {@link #getToRotation()}
         * will still be used. However, since living entities only have a unique head yaw value,
         * the set pitch value will update the normal {@link Entity#getRotation()} value.</p>
         */
        interface Head extends Rotation {}
    }
}
