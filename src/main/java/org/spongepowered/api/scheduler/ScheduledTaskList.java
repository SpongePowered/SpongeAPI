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

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.fluid.FluidType;

import java.util.Collection;

/**
 * A tick based priority scheduled list targeting speicifc types of
 * objects that need to be ticked. In common cases, there's either
 * a {@link BlockType} or {@link FluidType} being ticked.
 * @param <T>
 */
public interface ScheduledTaskList<T> {

    default ScheduledTaskEntry<T> scheduleUpdate(Vector3i pos, T itemIn, int scheduledTime) {
        return scheduleUpdate(pos.getX(), pos.getY(), pos.getZ(), itemIn, scheduledTime, TaskPriorities.NORMAL);
    }

    default ScheduledTaskEntry<T> scheduleUpdate(int x, int y, int z, T itemIn, int scheduledTime) {
        return scheduleUpdate(x, y, z, itemIn, scheduledTime, TaskPriorities.NORMAL);
    }

    default ScheduledTaskEntry<T> scheduleUpdate(Vector3i pos, T itemIn, int scheduledTime, TaskPriority priority) {
        return scheduleUpdate(pos.getX(), pos.getY(), pos.getZ(), itemIn, scheduledTime, priority);
    }

    ScheduledTaskEntry<T> scheduleUpdate(int x, int y, int z, T itemIn, int scheduledTime, TaskPriority priority);

    default boolean isUpdateScheduled(Vector3i pos, T itemIn) {
        return isUpdateScheduled(pos.getX(), pos.getY(), pos.getZ(), itemIn);
    }

    boolean isUpdateScheduled(int x, int y, int z, T itemIn);

    Collection<ScheduledTaskEntry<T>> getScheduledUpdates(int x, int y, int z);
    void removeUpdate(Vector3i blockPosition, ScheduledTaskEntry<T> update);

    default Collection<ScheduledTaskEntry<T>> getScheduledUpdates(Vector3i pos) {
        return getScheduledUpdates(pos.getX(), pos.getY(), pos.getZ());
    }
}
