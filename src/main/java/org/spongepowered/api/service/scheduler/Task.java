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
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.util.Identifiable;

/**
 * Represents a task that has been scheduled.
 */
public interface Task extends Identifiable {

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
     * @return The delay (offset) in the scale of the time unit applied if asynchronous, otherwise raw synchronous ticks
     */
    Optional<Long> getDelay();

    /**
     * Gets the interval for repeating tasks.
     *
     * @return The interval (period) in the scale of the time unit applied if asynchronous, otherwise raw synchronous ticks
     */
    Optional<Long> getInterval();

    /**
     * Cancels the task, if it has not already run.
     *
     * @return If the task was cancelled
     */
    boolean cancel();

    /**
     * Gets the {@link Runnable} that this task is running.
     *
     * @return The runnable
     */
    Optional<Runnable> getRunnable();

    /**
     * Gets the truth if the Task is Synchronous.
     *
     * @return The truth if the task is synchronous
     */
    boolean isSynchronous();

    /**
     * Sets the name of the Task.
     *
     * <p>If the name is not set by the user, by default, the name of
     * the task will be the form:<br>
     * <tt>PLUGIN_ID "-" ( "A-" | "S-" ) SERIAL_ID</tt>
     * </p>
     *
     * <p>The default name of the task is set when the Task is created by the Scheduler.</p>
     *
     * <p>If the <tt>PLUGIN_ID</tt> is not known, the string
     * <tt>Unknown</tt> will be used.</p>
     *
     * <p>
     * Examples of default Task names:<br>
     *
     * <tt>FooPlugin-A12"</tt><br>
     * <tt>"BarPlugin-S4322"</tt><br>
     * </p>
     *
     * <p>No two active Synchronous Tasks will have the same Sequence number.
     * No two active Asynchronous Tasks will have the same Sequence number.</p>
     *
     * <p>There is no check made on the requested Task name.   It can be any String
     * that is not null.  If the requested name is null, the name of the task is
     * not changed.</p>
     *
     * @param name  The name of the task requested.
     * @return The current name of the Task after trying to set the name of the task.
     */
    String setName(String name);

}
