/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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
package org.spongepowered.api.service.scheduler;

import com.google.common.base.Optional;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * The base scheduler that schedules tasks.
 */
public interface Scheduler {

    /**
     * Returns a {@link ListeningScheduledExecutorService} that wraps the scheduler.
     *
     * @param plugin The plugin requesting the execution of the tasks
     *
     * @return The executor service
     */
    ListeningScheduledExecutorService getExecutorService(Object plugin);

    /**
     * Converts a duration to ticks.
     *
     * <p>Note that the accuracy of this method is not guaranteed due to server latencies.</p>
     *
     * @param duration The duration of time
     * @param unit The time unit of the duration
     *
     * @return The duration in ticks.
     */
    long toTicks(long duration, TimeUnit unit);

    /**
     * Converts a duration in ticks to the specified unit.
     *
     * @param ticks The tick count
     * @param unit The time unit to convert to
     *
     * @return The duration in the specified unit
     */
    long fromTicks(long ticks, TimeUnit unit);

    /**
     * Retrieves a scheduled or running task by its unique ID.
     *
     * @param id The id of the task
     *
     * @return The scheduled or running task, or {@link Optional#absent()}
     */
    Optional<? extends Task<?>> getTaskById(UUID id);

    /**
     * Returns a collection of all currently scheduled tasks.
     *
     * @return A collection of scheduled tasks
     */
    Collection<? extends Task<?>> getScheduledTasks();

    /**
     * Returns a collection of all currently scheduled tasks owned by a
     * certain plugin.
     *
     * @param plugin The plugin to return tasks created by
     *
     * @return A collection of scheduled tasks
     */
    Collection<? extends Task<?>> getScheduledTasks(Object plugin);

}
