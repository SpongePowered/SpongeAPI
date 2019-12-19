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

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.fluid.FluidType;
import org.spongepowered.math.vector.Vector3i;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.Collection;
import java.util.function.Supplier;

/**
 * A tick based priority scheduled list targeting speicifc types of
 * objects that need to be ticked. In common cases, there's either
 * a {@link BlockType} or {@link FluidType} being ticked.
 * @param <T> The type of update objects that are being scheduled
 */
public interface ScheduledUpdateList<T> {

    /**
     * Schedules a new update at the desired position with the provided delay.
     *
     * @param pos The position
     * @param target The target
     * @param delay The delay
     * @param temporalUnit The unit of the delay
     * @return The scheduled update
     */
    default ScheduledUpdate<T> schedule(Vector3i pos, T target, int delay, TemporalUnit temporalUnit) {
        return schedule(pos.getX(), pos.getY(), pos.getZ(), target, delay, temporalUnit, TaskPriorities.NORMAL);
    }

    /**
     * Schedules a new update with the given {@code T object} for a desired {@link Duration}
     * @param pos The position
     * @param target The target
     * @param delay The delay with a duration
     * @return The scheduled update
     */
    default ScheduledUpdate<T> schedule(Vector3i pos, T target, Duration delay) {
        return schedule(pos.getX(), pos.getY(), pos.getZ(), target, delay, TaskPriorities.NORMAL);
    }

    /**
     * Schedules a new update for the desired target
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @param target The target object
     * @param delay The delay
     * @param temporalUnit The unit of time
     * @return The scheduled update
     */
    default ScheduledUpdate<T> schedule(int x, int y, int z, T target, int delay, TemporalUnit temporalUnit) {
        return schedule(x, y, z, target, delay, temporalUnit, TaskPriorities.NORMAL);
    }

    /**
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @param target The target
     * @param delay The delay
     * @return The scheduled update
     */
    default ScheduledUpdate<T> schedule(int x, int y, int z, T target, Duration delay) {
        return schedule(x, y, z, target, delay, TaskPriorities.NORMAL);
    }

    /**
     *
     * @param pos The position
     * @param target The target
     * @param delay The delay
     * @param temporalUnit The unit of time
     * @param priority The priority of the scheduled update
     * @return The scheduled update
     */
    default ScheduledUpdate<T> schedule(Vector3i pos, T target, int delay, TemporalUnit temporalUnit, TaskPriority priority) {
        return schedule(pos.getX(), pos.getY(), pos.getZ(), target, Duration.of(delay, temporalUnit), priority);
    }

    /**
     *
     * @param pos The position
     * @param target The target
     * @param delay The delay
     * @param temporalUnit The unit of time
     * @param priority The priority of the scheduled update
     * @return The scheduled update
     */
    default ScheduledUpdate<T> schedule(Vector3i pos, T target, int delay, TemporalUnit temporalUnit, Supplier<? extends TaskPriority> priority) {
        return schedule(pos.getX(), pos.getY(), pos.getZ(), target, Duration.of(delay, temporalUnit), priority.get());
    }

    /**
     *
     * @param pos The position
     * @param target The target
     * @param delay The delay
     * @param priority The priority of the scheduled update
     * @return The scheduled update
     */
    default ScheduledUpdate<T> schedule(Vector3i pos, T target, Duration delay, TaskPriority priority) {
        return schedule(pos.getX(), pos.getY(), pos.getZ(), target, delay, priority);
    }

    /**
     *
     * @param pos The position
     * @param target The target
     * @param delay The delay
     * @param priority The priority of the scheduled update
     * @return The scheduled update
     */
    default ScheduledUpdate<T> schedule(Vector3i pos, T target, Duration delay, Supplier<? extends TaskPriority> priority) {
        return schedule(pos.getX(), pos.getY(), pos.getZ(), target, delay, priority.get());
    }

    /**
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @param target The target
     * @param delay The delay
     * @param temporalUnit The unit of time
     * @param priority The priority of the scheduled update
     * @return The scheduled update
     */
    default ScheduledUpdate<T> schedule(int x, int y, int z, T target, int delay, TemporalUnit temporalUnit, TaskPriority priority) {
        return schedule(x, y, z, target, Duration.of(delay, temporalUnit), priority);
    }

    /**
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @param target The target
     * @param delay The delay
     * @param temporalUnit The unit of time
     * @param priority The priority of the scheduled update
     * @return The scheduled update
     */
    default ScheduledUpdate<T> schedule(int x, int y, int z, T target, int delay, TemporalUnit temporalUnit, Supplier<? extends TaskPriority> priority) {
        return schedule(x, y, z, target, Duration.of(delay, temporalUnit), priority.get());
    }

    /**
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @param target The target
     * @param delay The delay
     * @param priority The priority of the scheduled update
     * @return The scheduled update
     */
    ScheduledUpdate<T> schedule(int x, int y, int z, T target, Duration delay, TaskPriority priority);

    /**
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @param target The target
     * @param delay The delay
     * @param priority The priority of the scheduled update
     * @return The scheduled update
     */
    default ScheduledUpdate<T> schedule(int x, int y, int z, T target, Duration delay, Supplier<? extends TaskPriority> priority) {
        return schedule(x, y, z, target, delay, priority.get());
    }

    /**
     * Gets whether there's a scheduled update at the desired position with the provided target.
     *
     * @param pos The position
     * @param target The target
     * @return True if there's an update scheduled
     */
    default boolean isScheduled(Vector3i pos, T target) {
        return isScheduled(pos.getX(), pos.getY(), pos.getZ(), target);
    }

    /**
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @param target The target
     * @return True if there's an update scheduled
     */
    boolean isScheduled(int x, int y, int z, T target);

    /**
     *
     * @param pos The position
     * @return The collection of scheduled updates at the desired position
     */
    default Collection<? extends ScheduledUpdate<T>> getScheduledAt(Vector3i pos) {
        return getScheduledAt(pos.getX(), pos.getY(), pos.getZ());
    }

    /**
     * Gets a collection of scheduled updates at the desired position. There is
     * no guarantee
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @return The collection of scheduled updates at the desired position
     */
    Collection<? extends ScheduledUpdate<T>> getScheduledAt(int x, int y, int z);
}
