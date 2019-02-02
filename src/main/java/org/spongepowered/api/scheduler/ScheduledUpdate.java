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
package org.spongepowered.api.scheduler;

import org.spongepowered.api.world.Locatable;

import java.time.Duration;

/**
 * Represents a scheduled block update. SBUs with higher priorities are
 * processed first.
 */
public interface ScheduledUpdate<T> extends Locatable {

    /**
     * Gets the target of this scheduled update.
     *
     * @return The target
     */
    T getTarget();

    /**
     * Gets the {@link Duration delay} until this update
     * should cause the block to update.
     *
     * @return The delay until this SBU should cause the block to update
     */
    Duration getDelay();

    /**
     * Gets the priority of this scheduled block update.
     *
     * @return The priority of this scheduled block update
     */
    TaskPriority getPriority();

    /**
     * Gets the {@link State} of this scheduled update.
     *
     * @return The state
     */
    State getState();

    /**
     * Cancels this scheduled update.
     *
     * @return Returns if the scheduled update was successfully cancelled
     */
    boolean cancel();

    /**
     * Represents the state of a {@link ScheduledUpdate}.
     */
    enum State {
        /**
         * The scheduled update is waiting to be performed.
         */
        WAITING,
        /**
         * The scheduled update was cancelled.
         */
        CANCELLED,
        /**
         * The scheduled update is performed.
         */
        FINISHED,
    }
}
