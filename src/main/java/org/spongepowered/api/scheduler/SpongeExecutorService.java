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

import java.time.temporal.TemporalUnit;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

/**
 * A delegating {@link ExecutorService} that schedules all its tasks on
 * Sponge's {@link Scheduler}.
 *
 * <p>This class can be used to allow any libraries that support the
 * standard concurrency interface to schedule their asynchronous
 * tasks through Sponge.</p>
 */
public interface SpongeExecutorService extends ScheduledExecutorService {

    Future<?> schedule(Runnable command, long delay, TemporalUnit unit);

    @Override
    Future<?> schedule(Runnable command, long delay, TimeUnit unit);

    @Override
    <T> Future<T> submit(Callable<T> task);

    @Override
    Future<?> submit(Runnable task);

    @Override
    <T> Future<T> submit(Runnable task, @Nullable T result);

    <V> RunnableScheduledFuture<V> schedule(Callable<V> callable, long delay, TemporalUnit unit);

    @Override
    <V> RunnableScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit);

    RunnableScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TemporalUnit unit);

    @Override
    RunnableScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit);

    RunnableScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TemporalUnit unit);

    @Override
    RunnableScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit);

    interface Future<V> extends java.util.concurrent.RunnableScheduledFuture<V> {

        /**
         * Retrieves the {@link Scheduler} {@link ScheduledTask} instance that
         * is responsible for the execution of this future.
         *
         * @return The backing task
         */
        ScheduledTask getTask();
    }

    interface RunnableScheduledFuture<V> extends java.util.concurrent.RunnableScheduledFuture<V>, Future<V> {
    }
}
