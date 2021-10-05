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

import org.spongepowered.plugin.PluginContainer;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

/**
 * Represents a scheduler for running {@link Task tasks}.
 */
public interface Scheduler {

    /**
     * Retrieves a scheduled or running task by its unique ID.
     *
     * @param id The id of the task
     * @return The scheduled or running task, or {@link Optional#empty()}
     */
    Optional<ScheduledTask> findTask(UUID id);

    /**
     * Returns a set of {@link Task}s that match the Regular Expression pattern.
     *
     * @param pattern The regular expression pattern applied to the name of tasks
     * @return A set of {@link Task}s that have names that match the pattern, the
     * set will be empty if no names match
     */
    Set<ScheduledTask> findTasks(String pattern);

    /**
     * Returns a set of all currently scheduled tasks owned by the given plugin.
     *
     * @param plugin The plugin that created the tasks
     * @return A set of scheduled tasks
     */
    Set<ScheduledTask> tasks(PluginContainer plugin);

    /**
     * Returns a set of all currently scheduled tasks.
     *
     * @return A set of scheduled tasks
     */
    Set<ScheduledTask> tasks();

    /**
     * Gets an {@link ExecutorService executor} that can be used to schedule
     * tasks through the standard Java concurrency interfaces.
     *
     * @param plugin The plugin that will own the created tasks
     * @return An executor that can be used to execute tasks
     */
    TaskExecutorService executor(PluginContainer plugin);

    /**
     * Submit a {@link Task} to this scheduler and returns the task
     * as a {@link ScheduledTask}.
     * <p>
     * The name of the task will be the form:<br> {@code PLUGIN_ID "-" ( "A-" | "S-" ) SERIAL_ID}
     * <p>
     * Examples of default Task names:<br>
     *
     * {@code "FooPlugin-A-12"}<br>{@code "BarPlugin-S-4322"}
     * <p>
     * No two active tasks will have the same serial ID for the same
     * synchronisation type.<br>i.e {@code APlugin-A-15} and
     * {@code BPlugin-A-15} is not possible but {@code BPlugin-S-15}
     * is.
     * @param task The task
     * @return The scheduled task
     */
    ScheduledTask submit(Task task);

    /**
     * Submit a {@link Task} with a specified {@link String name} to this scheduler and returns the task
     * as a {@link ScheduledTask}.
     *
     * @param task The task
     * @param name The name
     * @return The scheduled task
     */
    ScheduledTask submit(Task task, String name);
}
