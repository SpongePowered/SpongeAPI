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

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * Represents a scheduler for running {@link Task}s.
 */
public interface SchedulerService {

    /**
     * Gets a new instance of a {@link TaskBuilder}.
     *
     * @return A new task builder
     */
    TaskBuilder createTaskBuilder();

    /**
     * Retrieves a scheduled or running task by its unique ID.
     *
     * @param id The id of the task
     * @return The scheduled or running task, or {@link Optional#empty()}
     */
    Optional<Task> getTaskById(UUID id);

    /**
     * Returns a set of {@link Task}s that match the Regular Expression pattern.
     *
     * @param pattern The regular expression pattern applied to the name of
     *        tasks
     * @return A set of {@link Task}s that have names that match the pattern,
     *         the set will be empty if no names match
     */
    Set<Task> getTasksByName(String pattern);

    /**
     * Returns a set of all currently scheduled tasks.
     *
     * @return A set of scheduled tasks
     */
    Set<Task> getScheduledTasks();

    /**
     * Returns a set of all currently scheduled tasks for either asynchronous or
     * synchronous execution.
     *
     * @param async True to get all async tasks, false to get all sync tasks
     * @return A set of scheduled tasks for the given sync type
     */
    Set<Task> getScheduledTasks(boolean async);

    /**
     * Returns a set of all currently scheduled tasks owned by the given plugin.
     *
     * @param plugin The plugin that created the tasks
     * @return A set of scheduled tasks
     */
    Set<Task> getScheduledTasks(Object plugin);
}
