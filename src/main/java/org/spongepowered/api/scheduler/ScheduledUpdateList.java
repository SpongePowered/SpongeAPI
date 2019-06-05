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

/**
 * A tick based priority scheduled list targeting speicifc types of
 * objects that need to be ticked. In common cases, there's either
 * a {@link BlockType} or {@link FluidType} being ticked.
 * @param <T>
 */
public interface ScheduledUpdateList<T> {

    default ScheduledUpdate<T> schedule(Vector3i pos, T target, int delay, TemporalUnit temporalUnit) {
        return schedule(pos.getX(), pos.getY(), pos.getZ(), target, delay, temporalUnit, TaskPriorities.NORMAL);
    }

    default ScheduledUpdate<T> schedule(Vector3i pos, T target, Duration delay) {
        return schedule(pos.getX(), pos.getY(), pos.getZ(), target, delay, TaskPriorities.NORMAL);
    }

    default ScheduledUpdate<T> schedule(int x, int y, int z, T target, int delay, TemporalUnit temporalUnit) {
        return schedule(x, y, z, target, delay, temporalUnit, TaskPriorities.NORMAL);
    }

    default ScheduledUpdate<T> schedule(int x, int y, int z, T target, Duration delay) {
        return schedule(x, y, z, target, delay, TaskPriorities.NORMAL);
    }

    default ScheduledUpdate<T> schedule(Vector3i pos, T target, int delay, TemporalUnit temporalUnit, TaskPriority priority) {
        return schedule(pos.getX(), pos.getY(), pos.getZ(), target, Duration.of(delay, temporalUnit), priority);
    }

    default ScheduledUpdate<T> schedule(Vector3i pos, T target, Duration delay, TaskPriority priority) {
        return schedule(pos.getX(), pos.getY(), pos.getZ(), target, delay, priority);
    }

    default ScheduledUpdate<T> schedule(int x, int y, int z, T target, int delay, TemporalUnit temporalUnit, TaskPriority priority) {
        return schedule(x, y, z, target, Duration.of(delay, temporalUnit), priority);
    }

    ScheduledUpdate<T> schedule(int x, int y, int z, T target, Duration delay, TaskPriority priority);

    default boolean isScheduled(Vector3i pos, T target) {
        return isScheduled(pos.getX(), pos.getY(), pos.getZ(), target);
    }

    boolean isScheduled(int x, int y, int z, T target);

    default Collection<ScheduledUpdate<T>> getScheduledAt(Vector3i pos) {
        return getScheduledAt(pos.getX(), pos.getY(), pos.getZ());
    }

    Collection<ScheduledUpdate<T>> getScheduledAt(int x, int y, int z);
}
