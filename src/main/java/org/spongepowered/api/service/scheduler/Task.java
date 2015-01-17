
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
import com.google.common.util.concurrent.ListenableFuture;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.util.Identifiable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Represents a task that has been scheduled.
 *
 * @param <V> The type returned by the computation of this task
 */
public interface Task<V> extends Identifiable {

    /**
     * Gets the name of this task.
     *
     * @return The name of the task
     */
    Optional<String> getName();

    /**
     * Returns the plugin that scheduled this task.
     *
     * @return The plugin that scheduled the task
     */
    PluginContainer getOwner();

    /**
     * Gets the delay that the task was scheduled to run after.
     *
     * @return The delay
     */
    Optional<Long> getDelay();

    /**
     * Gets the interval for repeating tasks.
     *
     * @return The interval (period)
     */
    Optional<Long> getInterval();

    /**
     * Gets the {@link TimeUnit} of the interval and delay.
     *
     * <p>If {@link Optional#isPresent() isPresent()} returns false, the unit is ticks.</p>
     *
     * @return The time unit
     */
    Optional<TimeUnit> getTimeUnit();

    /**
     * Cancels the task, if it has not already run.
     *
     * @return If the task was cancelled
     */
    boolean cancel();

    /**
     * Gets the {@link Runnable} that this task may be running.
     *
     * @return The runnable
     */
    Optional<Runnable> getRunnable();

    /**
     * Gets the {@link Callable} that this task may be running.
     *
     * @return The callable
     */
    Optional<Callable<V>> getCallable();

    /**
     * Gets the {@link ListenableFuture} that represents the result of the computation of this task.
     *
     * @return The future
     */
    ListenableFuture<V> getFuture();

    /**
     * Gets the method of execution of this task.
     *
     * @return True if this task was executed asynchronously, false if synchronously
     */
    boolean isAsynchronous();

}