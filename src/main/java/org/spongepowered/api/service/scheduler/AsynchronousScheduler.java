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

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Allows plugins to setup and run Tasks (Runnable)
 * targets on specific timing parameters. All AsynchronousScheduler tasks are free running
 * Tasks that run in their own Threads.
 *
 * <p>The basic model of the AsynchronousScheduler is that
 * when the Game starts and the Sponge core mod is loaded then:</p>
 *
 * <ul>
 *     <li>a new Thread is started which owns the job of managing new Tasks that are submitted to the
 *     AsynchronousScheduler interface.</li>
 *     <li>when new Tasks are ready to be executed, the thread in the AsynchronousScheduler calls upon
 *     the {@link java.util.concurrent.ExecutorService} to submit that individual user Task.  At that point the user's Task
 *     is running in it's own thread separate from the rest of the threads in the game. Most notably, this
 *     thread is <b>not thread safe</b> with the game data.  Care must be taken by the Plugin to ensure
 *     coherency with the game data if the user Task is working with game data.</li>
 *     <li>Tasks created by this interface can be queried and canceled the same way as with the
 *     {@link SynchronousScheduler} interface.  Those parts of the two interfaces are the same.</li>
 * </ul>
 *
 * <p>The interface for the AsynchronousScheduler has the feature to allow the Plugin to specify the
 * time unit the delay and/or interval of the pending Task.  In other words, if the {@link TimeUnit}
 * scale of the Task is in seconds, the scale argument to the method would be {@link java.util.concurrent.TimeUnit}</p>
 *
 * <p>Plugins may <b>not</b> safely manipulate game data in the Tasks created by the AsynchronousScheduler.</p>
 *
 * <p>The difference between this SynchronousScheduler and the {@link AsynchronousScheduler} is that
 * the Tasks created by the AsynchronousScheduler are each running in their own thread.  The concurrency
 * model of the AsynchronousScheduler does not allow for safe interaction with game data.  Care must be taken
 * by the Plugin to ensure that execution within the AsynchronousScheduler is safe</p>
 *
 * <p>In contrast the SynchronousScheduler does operate such that the Runnable targets of each Task
 * are executed in series and executed in sync with the TickEvent.ServerTickEvent on the Phase.START.</p>
 *
 * <p>Examples of how to setup the use of the Scheduler are included in the API descriptions in this interface.</p>
 *
 * @see AsynchronousScheduler#runTask(Object, Runnable)
 * @see AsynchronousScheduler#runTaskAfter(Object, Runnable, TimeUnit, long)
 * @see AsynchronousScheduler#runRepeatingTask(Object, Runnable, TimeUnit, long)
 * @see AsynchronousScheduler#runRepeatingTaskAfter(Object, Runnable, TimeUnit, long, long)
 *
 * <p>Utility methods are in the interface to query the Scheduler for Tasks</p>
 *
 * @see SchedulerQuery#getTaskById(UUID)
 * @see SchedulerQuery#getScheduledTasks()
 * @see SchedulerQuery#getScheduledTasks(Object)
 * @see SchedulerQuery#getUuidOfTaskByName(String)
 * @see SchedulerQuery#getTasksByName(String)
 *
 */

public interface AsynchronousScheduler extends SchedulerQuery {

    /**
     * Runs a Task once immediately.
     *
     * <p>
     * The runTask method is used to run a single Task just once.  The Task
     * may persist for the life of the server, however the Task itself will never
     * be restarted.  It has no delay offset.  This Asynchronous Scheduler will not wait before
     * running the Task.</p>
     *
     * <p>Example code to obtain plugin container argument from User code:</p>
     *
     * <p>
     * <code>
     *     Optional&lt;PluginContainer&gt; result;
     *     result = evt.getGame().getPluginManager().getPlugin("YOUR_PLUGIN");
     *     PluginContainer pluginContainer = result.get();
     * </code>
     * </p>
     *
     * @param plugin The plugin container of the Plugin that initiated the Task
     * @param task  The Runnable object that implements a run() method to execute the Task desired
     * @return Optional&lt;Task&gt; Either Optional.absent() if invalid or a reference to the new Task
     */
    Optional<Task> runTask(Object plugin, Runnable task);

    /**
     * Runs a Task once after a specific delay offset.
     *
     * <p>
     * The runTask() method is used to run a single Task just once.  The Task
     * may persist for the life of the server, however the Task itself will never
     * be restarted.  This Asynchronous Scheduler will not wait before running the Task.
     * <b>The Task will be delayed artificially for delay in the time unit scale.</b>  </p>
     *
     * <p>Because the time unit is in milliseconds, this scheduled Task is asynchronous with the game.
     * The timing of when to run a Task is based on wall-clock time.
     * Overhead, network and system latency not
     * withstanding the event will fire after the delay expires.</p>
     *
     * <p>Example code to obtain plugin container argument from User code:</p>
     *
     * <p>
     * <code>
     *     Optional&lt;PluginContainer&gt; result;
     *     result = evt.getGame().getPluginManager().getPlugin("YOUR_PLUGIN");
     *     PluginContainer pluginContainer = result.get();
     * </code>
     * </p>
     *
     * <p>Example for specifying a certain time unit scale:</p>
     *
     * <p>
     *     <code>
     *         // The task will run with a delay of 500 seconds.
     *         runTaskAfter(somePlugin, someRunnableTarget, TimeUnit.MILLISECONDS, 500);
     *     </code>
     * </p>
     *
     * @param plugin The plugin container of the Plugin that initiated the Task
     * @param task  The Runnable object that implements a run() method to execute the Task desired
     * @param scale The time unit of the delay.
     * @param delay  The offset in scale units before running the task.
     * @return Optional&lt;Task&gt; Either Optional.absent() if invalid or a reference to the new Task
     */
    Optional<Task> runTaskAfter(Object plugin, Runnable task, TimeUnit scale, long delay);

    /**
     * Starts a repeating Task with a period in specified time unit  The first occurrence will start immediately.
     *
     * <p>
     * The runRepeatingTask() method is used to run a Task that repeats.  The Task
     * may persist for the life of the server. This Asynchronous Scheduler will not wait before running
     * the first occurrence of the Task. This Scheduler will not allow a second occurrence of
     * the task to start if the preceding occurrence is is still alive.  Be sure to end
     * the Runnable Thread of the Task before anticipating the recurrence of the Task.</p>
     *
     * <p>
     * If this Scheduler detects that two tasks will overlap as such, the 2nd Task will not
     * be started.  The next time the Task is due to run, the test will be made again to determine
     * if the previous occurrence of the Task is still alive (running).  As long as a previous occurrence
     * is running no new occurrences of that specific Task will start, although this Scheduler will
     * never cease in trying to start it a 2nd time.</p>
     *
     * <p>Because the time unit is in the scale provided, this scheduled Task is asynchronous with the game.
     * The timing of when to run a Task is based on wall-clock time.
     * Overhead, network and system latency not
     * withstanding the event will fire after the delay expires.</p>
     *
     * <p>Example code to obtain plugin container argument from User code:</p>
     *
     * <p>
     * <code>
     *     Optional&lt;PluginContainer&gt; result;
     *     result = evt.getGame().getPluginManager().getPlugin("YOUR_PLUGIN");
     *     PluginContainer pluginContainer = result.get();
     * </code>
     * </p>
     *
     * <p>Example for specifying a certain time unit scale:</p>
     *
     * <p>
     *     <code>
     *         // The task will run with a period of 15 seconds.
     *         runRepeatingTask(somePlugin, someRunnableTarget, TimeUnit.SECONDS, 15);
     *     </code>
     * </p>
     *
     * <p>Example for specifying a certain time unit scale:</p>
     *
     * <p>
     *     <code>
     *         // The task will run with a period of 30 seconds
     *         runTaskAfter(somePlugin, someRunnableTarget, TimeUnit.SECONDS, 30);
     *     </code>
     * </p>
     *
     * @param plugin The plugin container of the Plugin that initiated the Task
     * @param task  The Runnable object that implements a run() method to execute the Task desired
     * @param scale The TimeUnit scale of the interval argument.
     * @param interval The period in scale time units of the repeating Task.
     * @return Optional&lt;Task&gt; Either Optional.absent() if invalid or a reference to the new Task
     */
    Optional<Task> runRepeatingTask(Object plugin, Runnable task, TimeUnit scale, long interval);

    /**
     * Starts a repeating Task with a period (interval) of time unit scale.
     * The first occurrence will start after an initial delay in time unit scale.
     *
     * <p>
     * The runRepeatingTask method is used to run a Task that repeats.  The Task
     * may persist for the life of the server. This Asynchronous Scheduler <b>will wait</b> before running
     * the first occurrence of the Task. This Scheduler will not allow a second occurrence of
     * the task to start if the preceding occurrence is is still alive.  Be sure to end
     * the Runnable Thread of the Task before anticipating the recurrence of the Task.</p>
     *
     * <p>
     * If this Scheduler detects that two tasks will overlap as such, the 2nd Task will not
     * be started.  The next time the Task is due to run, the test will be made again to determine
     * if the previous occurrence of the Task is still alive (running).  As long as a previous occurrence
     * is running no new occurrences of that specific Task will start, although this Scheduler will
     * never cease in trying to start it a 2nd time.</p>
     *
     * <p>Because the time unit is in milliseconds, this scheduled Task is asynchronous with the game.
     * The timing of when to run a Task is based on wall-clock time.
     * Overhead, network and system latency not
     * withstanding the event will fire after the delay expires.</p>
     *
     * <p>Example code to obtain plugin container argument from User code:</p>
     *
     * <p>
     * <code>
     *     Optional&lt;PluginContainer&gt; result;
     *     result = evt.getGame().getPluginManager().getPlugin("YOUR_PLUGIN");
     *     PluginContainer pluginContainer = result.get();
     * </code>
     * </p>
     *
     * <p>Example for specifying a certain time unit scale:</p>
     *
     * <p>
     *     <code>
     *         // The task will run with a period of 15 seconds.
     *         runRepeatingTask(somePlugin, someRunnableTarget, TimeUnit.SECONDS, 15);
     *     </code>
     * </p>
     *
     * <p>Example for specifying a certain time unit scale:</p>
     *
     * <p>
     *     <code>
     *         // The task will run with a period of 120 milliseconds and delay of 302 milliseconds
     *         // (If the scales are the same for both arguments)
     *         runRepeatingTaskAfter(somePlugin, someRunnableTarget, TimeUnit.MILLISECONDS, 120, 302);
     *
     *         // If the two units are in different scales:
     *
     *         // The task will run with a period of 20 seconds and delay of 500 milliseconds:
     *         Either:
     *         runRepeatingTaskAfter(somePlugin, someRunnableTarget, TimeUnit.MILLISECONDS, TimeUnit.SECOND.toMillis(20), 500);
     *         // OR
     *         runRepeatingTaskAfter(somePlugin, someRunnableTarget, TimeUnit.SECONDS, 20, TimeUnit.MILLISECONDS.toSeconds(500));
     *
     *     </code>
     * </p>
     *
     * @param plugin The plugin container of the Plugin that initiated the Task
     * @param task  The Runnable object that implements a run() method to execute the Task desired
     * @param scale The time unit of the parameters delay and interval. {@link TimeUnit#SECONDS} means delay and interval are in seconds.
     * @param delay  The offset in time unit scale before running the task.
     * @param interval The offset in time unit scale before running the task.
     * @return Optional&lt;Task&gt; Either Optional.absent() if invalid or a reference to the new Task
     */
    Optional<Task> runRepeatingTaskAfter(Object plugin, Runnable task, TimeUnit scale, long interval, long delay);

}
