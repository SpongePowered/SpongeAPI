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
import org.spongepowered.api.event.action.InteractEvent;
import org.spongepowered.math.vector.Vector3d;

/**
 * Base event for all interactions targeting an {@link Entity}.
 */
public interface InteractEntityEvent extends InteractEvent, Cancellable {

    /**
     * Gets the {@link Entity}.
     *
     * @return The entity
     */
    Entity getEntity();

    /**
     * An event where the targeted entity is being interacted with the client's
     * "primary" button.
     *
     * <p>This is usually left-click.</p>
     */
    interface Primary extends InteractEntityEvent {}

    /**
     * An event where the targeted entity is being interacted with the client's
     * "secondary" button.
     *
     * <p>This is usually right-click.</p>
     */
    interface Secondary extends InteractEntityEvent {

        /**
         * An entity is interacted with at an {@link #getInteractionPoint() interactionpoint}.
         *
         * <p>This is used for interactions targeting specific parts of an entity.</p>
         */
        interface At extends Secondary {
            /**
             * Gets the point of interaction where the interaction occurred as a {@link Vector3d}.
             *
             * @return The interaction point
             */
            Vector3d getInteractionPoint();
        }

        /**
         * An entity is interacted on.
         *
         * <p>This is used for interactions targeting the entity as a whole.</p>
         */
        interface On extends Secondary {

        }

    }

}
