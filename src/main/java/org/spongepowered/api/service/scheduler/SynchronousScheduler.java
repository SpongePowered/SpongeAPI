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

/**
 * Allows plugins to setup and run Tasks (Runnable)
 * targets on specific timing parameters.  All SynchronousScheduler tasks are in sync with the
 * Server Tick Event on the Phase.START of the event.
 *
 * <p>Each Task that is created and run by this Scheduler is running in the same thread as
 * the server (technically the same thread that the TickEvent.ServerTickEvent is fired).</p>
 *
 * <p>Plugins may safely manipulate game data in the Tasks created by the SynchronousScheduler.</p>
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
 * @see SynchronousScheduler#runTask(Object, Runnable)
 * @see SynchronousScheduler#runTaskAfter(Object, Runnable, long)
 * @see SynchronousScheduler#runRepeatingTask(Object, Runnable, long)
 * @see SynchronousScheduler#runRepeatingTaskAfter(Object, Runnable, long, long)
 *
 * <p>Utility methods are in the interface to query the Scheduler for Tasks</p>
 *
 * @see SchedulerQuery#getTaskById(UUID)
 * @see SchedulerQuery#getScheduledTasks()
 * @see SchedulerQuery#getScheduledTasks(Object)
 * @see SchedulerQuery#getUuidOfTaskByName(String)
 * @see SchedulerQuery#getTasksByName(String)
 */

public interface SynchronousScheduler extends SchedulerQuery {

    /**
     * <p>Runs a Task once immediately.</p>
     *
     * <p>
     * The runTask method is used to run a single Task just once.  The Task
     * may persist for the life of the server, however the Task itself will never
     * be restarted.  It has no delay offset.  The Scheduler will not wait before
     * running the Task.</p>
     *
     * <p>Example code to obtain plugin container argument from User code:</p>
     *
     * <p>
     * <code>
     *     Optional&lt;PluginContainer&gt;&nbsp; result;
     *     result = evt.getGame().getPluginManager().getPlugin("YOUR_PLUGIN");
     *     PluginContainer pluginContainer = result.get();
     * </code>
     * </p>
     * <p>Example usage:</p>
     * <p>
     *     <code>
     *         // The task will run now.
     *         runTask(somePlugin, someRunnableTarget);
     *     </code>
     * </p>
     * @param plugin The plugin container of the Plugin that initiated the Task
     * @param task  The Runnable object that implements a run() method to execute the Task desired
     * @return Optional&lt;Task&gt;&nbsp; Either Optional.absent() if invalid or a reference to the new Task
     */
    Optional<Task> runTask(Object plugin, Runnable task);

    /**
     * <p>Runs a Task once after a specific delay offset.</p>
     *
     * <p>
     * The runTask method is used to run a single Task just once.  The Task
     * may persist for the life of the server, however the Task itself will never
     * be restarted.  The Scheduler will not wait before running the Task.
     * <b>The Task will be delayed artificially for delay Ticks.</b>  Because the time
     * unit is in Ticks, this scheduled Task is synchronous (as possible) with the
     * event of the Tick from the game.  Overhead, network and system latency not
     * withstanding the event will fire after the delay expires.</p>
     *
     * <p>Example code to obtain plugin container argument from User code:</p>
     *
     * <p>
     * <code>
     *     Optional&lt;PluginContainer&gt;&nbsp; result;
     *     result = evt.getGame().getPluginManager().getPlugin("YOUR_PLUGIN");
     *     PluginContainer pluginContainer = result.get();
     * </code>
     * </p>
     * <p>Example usage:</p>
     * <p>
     *     <code>
     *         // The task will run after the delay of 160 Ticks
     *         runRepeatingTaskAfter(somePlugin, someRunnableTarget, 160);
     *     </code>
     * </p>
     * @param plugin The plugin container of the Plugin that initiated the Task
     * @param task  The Runnable object that implements a run() method to execute the Task desired
     * @param delay  The offset in ticks before running the task.
     * @return Optional&lt;Task&gt;&nbsp; Either Optional.absent() if invalid or a reference to the new Task
     */
    Optional<Task> runTaskAfter(Object plugin, Runnable task, long delay);

    /**
     * <p>Start a repeating Task with a period (interval) of Ticks.  The first occurrence will start immediately.</p>
     *
     * <p>
     * The runRepeatingTask method is used to run a Task that repeats.  The Task
     * may persist for the life of the server. The Scheduler will not wait before running
     * the first occurrence of the Task. The Scheduler will not allow a second occurrence of
     * the task to start if the preceding occurrence is is still alive.  Be sure to end
     * the Runnable Thread of the Task before anticipating the recurrence of the Task.</p>
     *
     * <p>
     * If the Scheduler detects that two tasks will overlap as such, the 2nd Task will not
     * be started.  The next time the Task is due to run, the test will be made again to determine
     * if the previous occurrence of the Task is still alive (running).  As long as a previous occurrence
     * is running no new occurrences of that specific Task will start, although the Scheduler will
     * never cease in trying to start it a 2nd time.</p>
     *
     * <p>
     * Because the time unit is in Ticks, this scheduled Task is synchronous (as possible) with the
     * event of the Tick from the game.  Overhead, network and system latency not
     * withstanding the Task will run (and re-run) after the delay expires.</p>
     *
     * <p>Example code to obtain plugin container argument from User code:</p>
     *
     * <p>
     * <code>
     *     Optional&lt;PluginContainer&gt;&nbsp; result;
     *     result = evt.getGame().getPluginManager().getPlugin("YOUR_PLUGIN");
     *     PluginContainer pluginContainer = result.get();
     * </code>
     * </p>
     * <p>Example usage:</p>
     * <p>
     *     <code>
     *         // The task will run with a period of 200 Ticks
     *         runRepeatingTaskAfter(somePlugin, someRunnableTarget, 200);
     *     </code>
     * </p>
     *
     * @param plugin The plugin container of the Plugin that initiated the Task
     * @param task  The Runnable object that implements a run() method to execute the Task desired
     * @param interval The period in ticks of the repeating Task.
     * @return Optional&lt;Task&gt;&nbsp; Either Optional.absent() if invalid or a reference to the new Task
     */
    Optional<Task> runRepeatingTask(Object plugin, Runnable task, long interval);

    /**
     * <p>
     * Start a repeating Task with a period (interval) in Ticks.
     * The first occurrence will start after an initial delay in Ticks.</p>
     *
     * <p>
     * The runRepeatingTask method is used to run a Task that repeats.  The Task
     * may persist for the life of the server. This Synchronous Scheduler <b>will wait</b> before running
     * the first occurrence of the Task. This Scheduler will not allow a second occurrence of
     * the task to start if the preceding occurrence is is still alive.  Be sure to end
     * the Runnable of the Task before anticipating the recurrence of the Task.</p>
     *
     * <p>
     * If this Scheduler detects that two tasks will overlap as such, the 2nd Task will not
     * be started.  The next time the Task is due to run, the test will be made again to determine
     * if the previous occurrence of the Task is still alive (running).  As long as a previous occurrence
     * is running no new occurrences of that specific Task will start, although this Scheduler will
     * never cease in trying to start it a 2nd time.</p>
     *
     * <p>Because the time unit is in Server Ticks (Phase.START) the task runs in sync with the Server Tick event.
     * Overhead, network and system latency not withstanding the event will fire after the delay expires.</p>
     *
     * <p>Example code to obtain plugin container argument from User code:</p>
     *
     * <p>
     * <code>
     *     Optional&lt;PluginContainer&gt;&nbsp; result;
     *     result = evt.getGame().getPluginManager().getPlugin("YOUR_PLUGIN");
     *     PluginContainer pluginContainer = result.get();
     * </code>
     * </p>
     *
     * <p>Example usage:</p>
     * <p>
     *     <code>
     *         // The task will run with a period of 120 Ticks and delay of 300 Ticks
     *         runRepeatingTaskAfter(somePlugin, someRunnableTarget,  120, 300);
     *     </code>
     * </p>
     *
     * @param plugin The plugin container of the Plugin that initiated the Task
     * @param task  The Runnable object that implements a run() method to execute the Task desired
     * @param delay  The offset in Ticks before running the task.
     * @param interval The offset in Ticks before running the task.
     * @return Optional&lt;Task&gt;&nbsp; Either Optional.absent() if invalid or a reference to the new Task
     */
    Optional<Task> runRepeatingTaskAfter(Object plugin, Runnable task, long interval, long delay);

}
