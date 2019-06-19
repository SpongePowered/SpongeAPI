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

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.immutable.entity.ImmutableExperienceHolderData;
import org.spongepowered.api.data.manipulator.mutable.entity.ExperienceHolderData;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.Transform;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.SpongeEventFactory;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.util.annotation.eventgen.FactoryMethod;
import org.spongepowered.api.util.annotation.eventgen.GenerateFactoryMethod;
import org.spongepowered.api.util.annotation.eventgen.PropertySettings;
import org.spongepowered.api.world.PortalAgent;
import org.spongepowered.api.world.World;

/**
 * Called when an {@link Entity} performs movement.
 */
@GenerateFactoryMethod
public interface MoveEntityEvent extends TargetEntityEvent, Cancellable {

    /**
     * Gets the transform that the {@link Entity} came from.
     *
     * @return the previous transform
     */
    Transform<World> getFromTransform();

    /**
     * Gets the new transform that the {@link Entity} will change to.
     *
     * @return the new transform
     */
    Transform<World> getToTransform();

    /**
     * Sets the new transform that the {@link Entity} will change to.
     *
     * @param transform The new transform
     */
    void setToTransform(Transform<World> transform);

    /**
     * Fired when an {@link Entity}'s position changes.
     */
    @GenerateFactoryMethod
    interface Position extends MoveEntityEvent {};

    /**
     * Fired when an {@link Entity}'s position changes for reasons other than
     * normal movement.
     */
    @GenerateFactoryMethod
    interface Teleport extends MoveEntityEvent {

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

        /**
         * This method exists solely to provide backwards-compatibility with existing plugins
         * using the old Teleport Event. It should not be called directly - instead,
         * plugins should use {@link SpongeEventFactory#createMoveEntityEventTeleport(Cause, Transform, Transform, Entity, boolean)}
         *
         * @param cause The cause to use
         * @param fromTransform The from transform
         * @param toTransform The target transform
         * @param targetEntity The target entity
         * @return The event
         */
        @FactoryMethod
        @Deprecated
        static MoveEntityEvent.Teleport createMoveEntityEventTeleport(Cause cause, Transform<World> fromTransform, Transform<World> toTransform, Entity targetEntity) {
            return SpongeEventFactory.createMoveEntityEventTeleport(cause, fromTransform, toTransform, targetEntity, false);
        }

        @GenerateFactoryMethod
        interface Portal extends Teleport {

            /**
             * Sets whether the {@link PortalAgent} will be used.
             * <p>
             * If this is set to true, the {@link PortalAgent} will search for a
             * portal at the {@link #getToTransform()} location and will attempt to
             * create one if not found.
             * </p>
             * <p>
             * If this is set to false, the {@link #getTargetEntity()} will only be
             * teleported to the {@link #getToTransform()} location.
             * </p>
             *
             * @param usePortalAgent whether to use the portal agent
             */
            void setUsePortalAgent(boolean usePortalAgent);

            /**
             * Gets whether the {@link PortalAgent} will be used.
             * <p>
             * If this is set to true, the {@link PortalAgent} will search for a
             * Portal at the {@link #getToTransform()} location, and will attempt to
             * create one if not found.
             * </p>
             * <p>
             * If this is set to false, the {@link #getTargetEntity()} will only be
             * teleported to the {@link #getToTransform()} location.
             * </p>
             *
             * @return whether to use the portal agent
             */
            boolean getUsePortalAgent();

            /**
             * Gets the {@link PortalAgent} that will be responsible for teleporting
             * the {@link #getTargetEntity()} through a Portal.
             *
             * @return The portal agent
             */
            PortalAgent getPortalAgent();

            /**
             * Sets the {@link PortalAgent} that will be responsible for teleporting
             * the {@link #getTargetEntity()} through a Portal.
             *
             * @param portalAgent The portal agent
             */
            void setPortalAgent(PortalAgent portalAgent);

            /**
             * This method exists solely to provide backwards-compatibility with existing plugins
             * using the old Teleport event. It should not be called directly - instead,
             * plugins should use {@link SpongeEventFactory#createMoveEntityEventTeleportPortal(Cause, Transform, Transform, PortalAgent, Entity, boolean, boolean)}
             *
             * @param cause The cause to use
             * @param fromTransform The from transform
             * @param toTransform The target transform
             * @param portalAgent The portal agent to use
             * @param targetEntity The entity being teleported
             * @param usePortalAgent Whether to use the portal agent
             * @return The event
             */
            @FactoryMethod
            @Deprecated
            static MoveEntityEvent.Teleport.Portal createMoveEntityEventTeleportPortal(Cause cause, Transform<World> fromTransform, Transform<World> toTransform, PortalAgent portalAgent, Entity targetEntity, boolean usePortalAgent) {
                return SpongeEventFactory.createMoveEntityEventTeleportPortal(cause, fromTransform, toTransform, portalAgent, targetEntity, false, usePortalAgent);
            }

        }
    }
}
