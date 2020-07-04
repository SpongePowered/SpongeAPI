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

import org.spongepowered.api.util.Identifiable;
import org.spongepowered.plugin.PluginContainer;

/**
 * Represents a {@link Task} that was scheduled through a
 * {@link Scheduler} using {@link Scheduler#submit(Task)}.
 */
public interface ScheduledTask extends Identifiable {

    /**
     * Gets the name of this scheduled task.
     *
     * @return The name
     */
    String getName();

    /**
     * Gets the {@link Task} that was scheduled.
     *
     * @return The task
     */
    Task getTask();

    /**
     * Returns the plugin that scheduled this task.
     *
     * @return The plugin that scheduled the task
     */
    default PluginContainer getOwner() {
        return getTask().getOwner();
    }

    /**
     * Cancels this scheduled task. Cancelling a repeating task
     * will prevent any further repetitions of the task.
     *
     * @return If the task is not running and was cancelled
     */
    boolean cancel();

    /**
     * Gets whether this scheduled task has been cancelled.
     *
     * @return True if cancelled, false otherwise
     */
    boolean isCancelled();
}
