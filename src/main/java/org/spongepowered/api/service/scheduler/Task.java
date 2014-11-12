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

import org.spongepowered.api.plugin.PluginContainer;

import java.util.concurrent.Future;

/**
 * Represents a task that has been scheduled.
 */
public interface Task extends Future {

    /**
     * Gets the name of this task.
     *
     * @return the name of the task
     */
    String getName();

    /**
     * Returns the plugin that scheduled this task.
     *
     * @return the plugin that scheduled the task
     */
    PluginContainer getOwner();

    /**
     * Gets the delay that the task was scheduled to run after.
     *
     * @return the delay
     */
    long getDelay();

    /**
     * Cancels the task, if it has not already run.
     *
     * @return if the task was cancelled
     */
    boolean cancel();

    /**
     * Gets the {@link Runnable} that this task is running.
     *
     * @return The runnable.
     */
    Runnable getRunnable();
}
