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
package org.spongepowered.api.service.scheduler;

import java.util.concurrent.TimeUnit;

/**
 * Represents a builder to create a {@link Task}.
 */
public interface TaskBuilder {

    /**
     * Sets whether the task should run asynchronous, outside of the main loop,
     * and in it's own thread. By default, tasks are synchronous.
     *
     * <p>A synchronous task is ran in alignment with the game's main loop, in
     * the same thread. Each synchronous task is ran in series with the tick
     * cycle. It is safe to manipulate game data when running in this mode.</p>
     *
     * <p>In contrast, a task set to run asynchronously will run independently
     * of the tick cycle and in it's own thread. Therefore the task is <b>not
     * thread safe</b> with game data and care must be taken. It is strongly
     * advised to <b>not</b> manipulate game data in asynchronous tasks.</p>
     *
     * <p>It is not possible to schedule a task in unit ticks when running
     * asynchronously. If the delay or interval has been specified in ticks
     * (methods {@link #delay(long)} and {@link #interval(long)}), it will be
     * converted to the equivalent wall clock time by the implementation. After
     * this point, calls to the two methods mentioned will set the time in
     * milliseconds as mentioned in their javadoc.</p>
     *
     * @return This builder, for chaining
     */
    TaskBuilder async();

    /**
     * Sets the {@link Runnable} to run when this task executes.
     *
     * @param runnable The actual task to run
     * @return This builder, for chaining
     */
    TaskBuilder execute(Runnable runnable);

    /**
     * Sets the delay before the task runs. This delay is an initial offset,
     * subsequent runs (when the interval is not 0) will not be offset. By
     * default, the delay is 0.
     *
     * @param delay The delay in the given {@link TimeUnit}
     * @param unit The unit the delay is in
     * @return This builder, for chaining
     * @throws IllegalArgumentException If the delay is below 0
     */
    TaskBuilder delay(long delay, TimeUnit unit);

    /**
     * Sets the delay before the task runs, in the default time unit. If
     * {@link #async()} has <b>not</b> been called this represents the number of
     * ticks. Otherwise this will set the delay in milliseconds.
     *
     * @param delay The delay in the default time unit
     * @return This builder, for chaining
     * @throws IllegalArgumentException If the delay is below 0
     * @see #delay(long, TimeUnit)
     */
    TaskBuilder delay(long delay);

    /**
     * Sets the interval between repetitions of the task. The task will not
     * repeat if the interval is 0. By default, the interval is 0.
     *
     * <p>If the scheduler detects that two tasks will overlap, the 2nd task
     * will not be started. The next time the task is due to run, the test will
     * be made again to determine if the previous occurrence of the task is
     * still alive (running). As long as a previous occurrence is running no new
     * occurrences of that specific task will start, although the scheduler will
     * never cease in trying to start it a 2nd time.</p>
     *
     * @param interval The interval in the given {@link TimeUnit}
     * @param unit The unit the interval is in
     * @return This builder, for chaining
     * @throws IllegalArgumentException If the interval is below 0
     */
    TaskBuilder interval(long interval, TimeUnit unit);

    /**
     * Sets the interval in ticks between repetitions of the task, in the
     * default time unit. If {@link #async()} has <b>not</b> been called this
     * represents the number of ticks. Otherwise this will set the interval in
     * milliseconds.
     *
     * @param ticks The number of ticks between runs
     * @return This builder, for chaining
     * @throws IllegalArgumentException If the interval is below 0
     * @see #interval(long, TimeUnit)
     */
    TaskBuilder interval(long ticks);

    /**
     * Sets the name of the task, the name cannot be blank.
     *
     * <p>If the name is not set in the builder, the name of the task will be
     * the form:<br> <tt>PLUGIN_ID "-" ( "A-" | "S-" ) SERIAL_ID</tt> </p>
     *
     * <p>Examples of default Task names:<br>
     *
     * <tt>"FooPlugin-A-12"</tt><br><tt>"BarPlugin-S-4322"</tt></p>
     *
     * <p>No two active tasks will have the same serial ID for the same
     * synchronisation type.<br>i.e <tt>APlugin-A-15</tt> and
     * <tt>BPlugin-A-15</tt> is not possible but <tt>BPlugin-S-15</tt> is.</p>
     *
     * @param name The task name
     * @return This builder, for chaining
     * @throws IllegalArgumentException If the name is blank
     */
    TaskBuilder name(String name);

    /**
     * Submits the task to the scheduler and returns the task that was created.
     *
     * @param plugin The owner of the task
     * @return A new instance of a {@link Task}
     * @throws IllegalArgumentException If the object passed in is not a plugin
     *         instance
     * @throws IllegalStateException If the builder is incomplete
     */
    Task submit(Object plugin);

}
