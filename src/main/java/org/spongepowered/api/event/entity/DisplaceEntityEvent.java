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
import org.spongepowered.api.entity.Transform;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.event.entity.living.TargetLivingEvent;
import org.spongepowered.api.event.entity.living.humanoid.TargetHumanoidEvent;
import org.spongepowered.api.event.entity.living.humanoid.player.TargetPlayerEvent;
import org.spongepowered.api.world.TeleporterAgent;
import org.spongepowered.api.world.World;

/**
 * Called when an {@link Entity} changes position
 * (also known as undergoing displacement).
 *
 * <p>This encapsulates both continuous
 * ({@link DisplaceEntityEvent.Move}) and discrete
 * ({@link DisplaceEntityEvent.Teleport}) movement.
 * </p>
 */
public interface DisplaceEntityEvent extends TargetEntityEvent, Cancellable {

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
     * An event where the {@link #getTargetEntity()} is moving. This can
     * either be due to AI or client control
     */
    interface Move extends DisplaceEntityEvent {

        /**
         * A {@link Move} event where the target entity is a {@link Living}
         * entity.
         */
        interface TargetLiving extends Move, DisplaceEntityEvent.TargetLiving { }

        /**
         * A {@link Move} event where the target entity is a {@link Humanoid}
         * entity.
         */
        interface TargetHumanoid extends TargetLiving, TargetHumanoid { }

        /**
         * A {@link Move} event where the target entity is a {@link Player}
         * entity.
         */
        interface TargetPlayer extends TargetHumanoid, DisplaceEntityEvent.TargetPlayer { }
    }

    interface Teleport extends DisplaceEntityEvent, CauseTracked {

        /// TODO review teleporter stuff.

        /**
         * Gets the {@link TeleporterAgent} that was used to calculate the
         * teleport locations.
         *
         * @return The teleporter agent
         */
        TeleporterAgent getTeleporterAgent();

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
         * An event where the target entity is a {@link Living} entity.
         */
        interface TargetLiving extends Teleport, DisplaceEntityEvent.TargetLiving { }

        /**
         * An event where the target entity is a {@link Humanoid} entity.
         */
        interface TargetHumanoid extends TargetLiving, TargetHumanoid { }

        /**
         * An event where the target entity is a {@link Player} entity.
         */
        interface TargetPlayer extends TargetHumanoid, DisplaceEntityEvent.TargetPlayer { }
    }

    /**
     * An event where the target entity is a {@link Living} entity.
     */
    interface TargetLiving extends DisplaceEntityEvent, TargetLivingEvent { }

    /**
     * An event where the target entity is a {@link Humanoid} entity.
     */
    interface TargetHumanoid extends TargetLiving, TargetHumanoidEvent { }

    /**
     * An event where the target entity is a {@link Player} entity.
     */
    interface TargetPlayer extends TargetHumanoid, TargetPlayerEvent { }

}
