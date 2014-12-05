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
import org.spongepowered.api.plugin.PluginContainer;

import java.util.Collection;

/**
 * The base scheduler that schedules tasks.
 */
public interface Scheduler {

    /**
     * Runs the task immediately.
     *
     * @param plugin The plugin requesting the task
     * @param task The task to run
     *
     * @return The scheduled task, if successful
     */
    Optional<Task> runTask(PluginContainer plugin, Runnable task);

    /**
     * Runs the task after a delay in ticks.
     *
     * @param plugin The plugin requesting the task
     * @param task The task to run
     * @param delay The delay in ticks
     *
     * @return The scheduled task, if successful
     */
    Optional<Task> runTaskAfter(PluginContainer plugin, Runnable task, long delay);

    /**
     * Runs the task immediately, then repeats at an
     * interval.
     *
     * @param plugin The plugin requesting the task
     * @param task The task to run
     * @param interval The interval between runs
     *
     * @return The scheduled task, if successful
     */
    Optional<RepeatingTask> runRepeatingTask(PluginContainer plugin, Runnable task, long interval);

    /**
     * Runs the task after a delay in ticks, then repeats
     * at an interval.
     *
     * @param plugin The plugin requesting the task
     * @param task The task to run
     * @param interval The interval between runs
     * @param delay The delay in ticks
     *
     * @return The scheduled task, if successful
     */
    Optional<RepeatingTask> runRepeatingTaskAfter(PluginContainer plugin, Runnable task, long interval, long delay);

    /**
     * Returns a {@link Collection} of all currently scheduled tasks
     *
     * @return A collection of scheduled tasks
     */
    Collection<Task> getScheduledTasks();

    /**
     * Returns a {@link Collection} of all currently scheduled tasks owned by a
     * certain plugin.
     *
     * @param plugin The plugin to return tasks created by
     *
     * @return A collection of scheduled tasks
     */
    Collection<Task> getScheduledTasks(PluginContainer plugin);
}
