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
import org.spongepowered.api.entity.Transform;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.entity.TargetEntityEvent;
import org.spongepowered.api.world.World;

import java.util.Optional;

/**
 * Called when a {@link Humanoid} enters a bed to sleep in.
 */
public interface SleepingEvent extends TargetEntityEvent {

    /**
     * Gets the {@link BlockSnapshot} of the bed being used to sleep.
     *
     * @return The location of the bed
     */
    BlockSnapshot getBed();

    interface Pre extends SleepingEvent, Cancellable {}

    interface Tick extends SleepingEvent, Cancellable {}

    interface Post extends SleepingEvent, Cancellable {

        /**
         * Gets whether the spawn transform for the human was set.
         *
         * <p>The case that spawn may have not been set includes:</p>
         * <ul><li>A player attempting to sleep in a bed in the nether</li></ul>
         *
         * @return Whether the spawn transform for the human was set
         */
        boolean isSpawnSet();

        /**
         * Gets a copy of the spawn transform of the human when leaving the bed.
         *
         * <p>This may have not been set by the event, so checking
         * {@link #isSpawnSet()} is advisable. If spawn has not been set,
         * it will return {@link Optional#empty()}.</p>
         *
         * @return The humans new spawn transform, if available
         */
        Optional<Transform<World>> getSpawnTransform();

        /**
         * Sets the new spawn transform of the human leaving the bed.
         *
         * <p>If spawn {@link #isSpawnSet()} was not in fact set by this event,
         * this does not override the return value. The given spawn should be
         * a valid location.</p>
         *
         * @param transform The new spawn transform for the human
         */
        void setSpawnTransform(Transform<World> transform);
    }

    interface Finish extends SleepingEvent {}
}
