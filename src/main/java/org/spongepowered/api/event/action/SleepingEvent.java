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
package org.spongepowered.api.event.action;

import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.world.ServerLocation;
import org.spongepowered.math.vector.Vector3d;

/**
 * Called when a {@link Humanoid} enters a bed to sleep in.
 */
public interface SleepingEvent extends Event {

    /**
     * Gets the {@link Humanoid}.
     *
     * @return The humanoid
     */
    Humanoid getHumanoid();

    /**
     * Gets the {@link BlockSnapshot} of the bed being used to sleep.
     *
     * @return The location of the bed
     */
    BlockSnapshot getBed();

    interface Pre extends SleepingEvent, Cancellable {}

    interface Tick extends SleepingEvent, Cancellable {}

    /**
     * Called when the {@link Humanoid} was sleeping but failed.
     */
    interface Failed extends SleepingEvent, Cancellable {

    }

    interface Finish extends SleepingEvent {

        /**
         * Gets the previous {@link ServerLocation location} the {@link Humanoid} would have woke at.
         *
         * @return The location
         */
        ServerLocation getFromLocation();

        /**
         * Gets the {@link ServerLocation location} the {@link Humanoid} will wake up at.
         *
         * @return The location
         */
        ServerLocation getToLocation();

        /**
         * Sets the {@link ServerLocation location} the {@link Humanoid} will wake up at.
         *
         * @param location The location
         */
        void setToLocation(ServerLocation location);

        /**
         * Gets the {@link Vector3d rotation} the {@link Humanoid} would woke up to.
         *
         * @return The rotation
         */
        Vector3d getFromRotation();

        /**
         * Gets the {@link Vector3d rotation} the {@link Humanoid} will wake up to.
         *
         * @return The rotation
         */
        Vector3d getToRotation();

        /**
         * Sets the {@link Vector3d rotation} the {@link Humanoid} will wake up to.
         *
         * @param rotation The rotation
         */
        void setToRotation(Vector3d rotation);
    }
}
