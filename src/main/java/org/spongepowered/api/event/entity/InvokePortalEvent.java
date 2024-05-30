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
import org.spongepowered.api.util.annotation.eventgen.NoFactoryMethod;
import org.spongepowered.api.world.portal.PortalLogic;
import org.spongepowered.math.vector.Vector3d;

import java.util.Optional;

/**
 * Called when an {@link Entity} is using a {@link PortalLogic portal}.
 */
@NoFactoryMethod
public interface InvokePortalEvent extends Event {

    /**
     * Gets the {@link Entity}.
     *
     * @return The entity
     */
    @AbsoluteSortPosition(1)
    Entity entity();

    /**
     * Gets the {@link PortalLogic}.
     *
     * @return The portal logic
     */
    PortalLogic portalLogic();

    /**
     * Called when entering a portal.
     * Cancel to prevent portal effects.
     */
    interface Enter extends InvokePortalEvent, Cancellable {

        /**
         * Gets the portal transition time in ticks.
         *
         * @return The portal transition time
         */
        int portalTransitionTime();

        /**
         * Gets the custom portal transition time in ticks.
         *
         * @return The custom portal transition time
         */
        Optional<Integer> customPortalTransitionTime();

        /**
         * Sets the custom portal transition time in ticks.
         *
         * @param ticks The custom portal transition time
         */
        void setCustomPortalTransitionTime(Integer ticks);
    }

    /**
     * Called before calculating and finding or generating the portal exit.
     * Canceling resets the portal transition time
     * Setting custom portal logic can change the teleport behaviour.
     */
    interface Prepare extends InvokePortalEvent, Cancellable {

        /**
         * Sets the {@link PortalLogic} to use.
         *
         * @param portal The portal logic
         */
        void setPortalLogic(PortalLogic portal);
    }

    /**
     * Called after a {@link PortalLogic} calculated and found or generated the portal exit.
     * Note that {@link ChangeEntityWorldEvent} still fire after this.
     */
    interface Execute extends InvokePortalEvent, ChangeEntityWorldEvent.Reposition, RotateEntityEvent {

        /**
         * Gets the exit speed.
         *
         * @return The exit speed
         */
        Vector3d exitSpeed();

        /**
         * Sets the exit speed.
         *
         * @param speed The exit speed
         */
        void setExitSpeed(Vector3d speed);

    }


}
