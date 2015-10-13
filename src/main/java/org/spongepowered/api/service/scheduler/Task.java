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

import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.util.Identifiable;

import java.util.function.Consumer;

/**
 * Represents a task that has been scheduled.
 */
public interface Task extends Identifiable {

    /**
     * Gets the name of this task.
     *
     * @return The name of the task
     */
    String getName();

    /**
     * Returns the plugin that scheduled this task.
     *
     * @return The plugin that scheduled the task
     */
    PluginContainer getOwner();

    /**
     * Gets the delay that the task was scheduled to run after. A delay of 0
     * represents that the task started immediately.
     *
     * @return The delay (offset) in either milliseconds or ticks (ticks are
     *         exclusive to synchronous tasks)
     */
    long getDelay();

    /**
     * Gets the interval for repeating tasks. An interval of 0 represents that
     * the task does not repeat.
     *
     * @return The interval (period) in either milliseconds or ticks (ticks are
     *         exclusive to synchronous tasks)
     */
    long getInterval();

    /**
     * Cancels the task. Cancelling a repeating task will prevent any further
     * repetitions of the task.
     *
     * @return If the task is not running and was cancelled
     */
    boolean cancel();

    /**
     * Gets the {@link Consumer}<{@link Task}> that this task is running.
     *
     * @return The consumer
     */
    Consumer<Task> getConsumer();

    /**
     * Gets whether this task is asynchronous.
     *
     * @return True if asynchronous, false if synchronous
     */
    boolean isAsynchronous();

}
