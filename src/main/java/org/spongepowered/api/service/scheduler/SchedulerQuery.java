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

import java.util.Collection;
import java.util.UUID;


/**
 * Examples of how to setup the use of the Scheduler are included in the API descriptions in this interface.
 *
 * @see AsynchronousScheduler#runTask(Object, Runnable)
 * @see AsynchronousScheduler#runTaskAfter(Object, Runnable, java.util.concurrent.TimeUnit, long)
 * @see AsynchronousScheduler#runRepeatingTask(Object, Runnable, java.util.concurrent.TimeUnit, long)
 * @see AsynchronousScheduler#runRepeatingTaskAfter(Object, Runnable, java.util.concurrent.TimeUnit, long, long)
 *
 * <p>Examples of how to setup the use of the Scheduler are included in the API descriptions in this interface.</p>
 *
 * @see SynchronousScheduler#runTask(Object, Runnable)
 * @see SynchronousScheduler#runTaskAfter(Object, Runnable, long)
 * @see SynchronousScheduler#runRepeatingTask(Object, Runnable, long)
 * @see SynchronousScheduler#runRepeatingTaskAfter(Object, Runnable, long, long)
 */

public interface SchedulerQuery {

    /**
     * Retrieves a scheduled or running task by its unique ID.
     *
     * @param id The id of the task
     * @return The scheduled or running task, or {@link com.google.common.base.Optional#absent()}
     */
    Optional<Task> getTaskById(UUID id);

    /**
     * Gets the UUID of the task by name.
     *
     * @param name  The name of the task to search
     * @return The Optional&lt;UUID&gt; result from the search by name.
     */
    Optional<UUID> getUuidOfTaskByName(String name);

    /**
     * Returns a collection of Tasks that match the Regular Expression
     * pattern.
     *
     * <p>If no tasks match the pattern, the collection is Optional.absent()</p>
     * <p>If there are Tasks that match the regular expression pattern, the
     * Collection is not Optional.absent().</p>
     *
     * @param pattern The regular expression pattern applied to the name of tasks.
     * @return Collection of Tasks that have names that match the pattern.
     */
    Collection<Task> getTasksByName(String pattern);

    /**
     * Returns a collection of all currently scheduled tasks.
     *
     * @return A collection of scheduled tasks
     */
    Collection<Task> getScheduledTasks();

    /**
     * Returns a collection of all currently scheduled tasks owned by a
     * certain plugin.
     *
     * @param plugin The plugin to return tasks created by
     * @return A collection of scheduled tasks
     */
    Collection<Task> getScheduledTasks(Object plugin);
}
