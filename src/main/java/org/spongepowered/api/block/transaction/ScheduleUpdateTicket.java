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
package org.spongepowered.api.block.transaction;

import org.spongepowered.api.scheduler.ScheduledUpdate;
import org.spongepowered.api.scheduler.TaskPriority;
import org.spongepowered.api.world.LocatableBlock;

import java.time.Duration;

/**
 * Represents a {@link ScheduledUpdate scheduled block update} that
 * is being proposed to the engine.
 */
public interface ScheduleUpdateTicket<T> {

    /**
     * Gets the target block of this scheduled update.
     *
     * @return The target block
     */
    LocatableBlock block();

    /**
     * Gets the target of this scheduled update.
     *
     * @return The target
     */
    T target();

    /**
     * Gets the {@link Duration delay} until this update
     * should cause the block to update.
     *
     * @return The delay until this SBU should cause the block to update
     */
    Duration delay();

    /**
     * Gets the priority of this scheduled block update.
     *
     * @return The priority of this scheduled block update
     */
    TaskPriority priority();

    /**
     * Gets whether this ticket is marked as valid.
     *
     * @return The valid state of this ticket
     */
    boolean valid();

    /**
     * Sets whether this ticket is valid or not.
     *
     * @param valid The valid state of this ticket
     */
    void setValid(boolean valid);

    /**
     * Invalidates this ticket.
     */
    default void invalidate() {
        this.setValid(false);
    }
}
