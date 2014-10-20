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

package org.spongepowered.api.util.scheduler;

/**
 * The base scheduler that schedules tasks.
 */
public interface Scheduler {

    /**
     * Runs the task immediately.
     *
     * @param task The task to run
     *
     * @return The scheduled task, or null if failed to schedule
     */
    public Task runTask(Runnable task);

    /**
     * Runs the task after a delay in ticks.
     *
     * @param task The task to run
     * @param delay The delay in ticks
     *
     * @return The scheduled task, or null if failed to schedule
     */
    public Task runTaskAfter(Runnable task, long delay);

    /**
     * Runs the task immediately, then repeats at an
     * interval.
     *
     * @param task The task to run
     * @param interval The interval between runs
     *
     * @return The scheduled task, or null if failed to schedule
     */
    public Task runRepeatingTask(Runnable task, long interval);

    /**
     * Runs the task after a delay in ticks, then repeats
     * at an interval.
     *
     * @param task The task to run
     * @param interval The interval between runs
     * @param delay The delay in ticks
     *
     * @return The scheduled task, or null if failed to schedule
     */
    public Task runRepeatingTaskAfter(Runnable task, long interval, long delay);
}
