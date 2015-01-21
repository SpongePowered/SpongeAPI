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

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * The base scheduler that schedules tasks.
 */

public interface AsynchronousScheduler extends Scheduler {

    /**
     * Runs the task immediately.
     *
     * @param plugin The plugin requesting the task
     * @param task The task to run
     *
     * @return The scheduled task, if successful
     */
    Optional<? extends Task<?>> runTask(Object plugin, Runnable task);

    /**
     * Runs the task immediately.
     *
     * @param plugin The plugin requesting the task
     * @param task The task to run
     * @param <V> The type returned by the computation of this task
     *
     * @return The scheduled task, if successful
     */
    <V> Optional<? extends Task<V>> runTask(Object plugin, Callable<V> task);

    /**
     * Runs the task after a delay in ticks.
     *
     * @param plugin The plugin requesting the task
     * @param task The task to run
     * @param scale The scale units
     * @param delay The delay in scale units
     *
     * @return The scheduled task, if successful
     */
    Optional<? extends Task<?>> runTaskAfter(Object plugin, Runnable task, TimeUnit scale, long delay);

    /**
     * Runs the task after a delay in ticks.
     *
     * @param plugin The plugin requesting the task
     * @param task The task to run
     * @param scale The scale units
     * @param delay The delay in scale units
     * @param <V> The type returned by the computation of this task
     *
     * @return The scheduled task, if successful
     */
    <V> Optional<? extends Task<V>> runTaskAfter(Object plugin, Callable<V> task, TimeUnit scale, long delay);

    /**
     * Runs the task immediately, then repeats at an
     * interval.
     *
     * @param plugin The plugin requesting the task
     * @param task The task to run
     * @param scale The scale units
     * @param interval The interval between runs in scale units
     *
     * @return The scheduled task, if successful
     */
    Optional<? extends Task<?>> runRepeatingTask(Object plugin, Runnable task, TimeUnit scale, long interval);

    /**
     * Runs the task after a delay in ticks, then repeats
     * at an interval.
     *
     * @param plugin The plugin requesting the task
     * @param task The task to run
     * @param scale The scale units
     * @param interval The interval between runs in scale units
     * @param delay The delay in scale units
     *
     * @return The scheduled task, if successful
     */
    Optional<? extends Task<?>> runRepeatingTaskAfter(Object plugin, Runnable task, TimeUnit scale, long interval, long delay);

}
