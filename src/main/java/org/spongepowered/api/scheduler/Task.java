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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.util.Ticks;
import org.spongepowered.plugin.PluginContainer;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * Represents a task that has been scheduled.
 */
public interface Task {

    /**
     * Creates a new {@link Builder} to build a {@link Task}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * @return The {@link PluginContainer plugin}
     */
    PluginContainer plugin();

    /**
     * Gets the delay that the task was scheduled to run after. A delay of 0
     * represents that the task started immediately.
     *
     * @return The delay (offset) duration
     */
    Duration delay();

    /**
     * Gets the interval for repeating tasks. An interval of 0 represents that
     * the task does not repeat.
     *
     * @return The interval (period) duration
     */
    Duration interval();

    /**
     * Represents a builder to create a {@link Task}.
     */
    interface Builder extends org.spongepowered.api.util.Builder<Task, Builder>, CopyableBuilder<Task, Builder> {

        /**
         * Sets the {@link Runnable} to run when this task executes.
         *
         * @param runnable The actual task to run
         * @return This builder, for chaining
         */
        default Builder execute(final Runnable runnable) {
            return this.execute(task -> runnable.run());
        }

        /**
         * Sets the consumer that runs when this task executes.
         *
         * @param executor The executor to run
         * @return This builder, for chaining
         */
        Builder execute(Consumer<ScheduledTask> executor);

        /**
         * Sets the delay before the task runs. This delay is an initial offset,
         * subsequent runs (when the interval is not 0) will not be offset. By
         * default, the delay is 0.
         *
         * @param delay The delay in the given {@link TemporalUnit}
         * @param unit The unit the delay is in
         * @return This builder, for chaining
         * @throws IllegalArgumentException If the delay is below 0
         */
        default Builder delay(final long delay, final TemporalUnit unit) {
            return this.delay(Duration.of(delay, unit));
        }

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
        default Builder delay(final long delay, final TimeUnit unit) {
            return this.delay(unit.toNanos(delay), ChronoUnit.NANOS);
        }

        /**
         * Sets the delay before the task runs, in {@link Ticks}.
         *
         * @param ticks The delay in ticks
         * @return This builder, for chaining
         * @throws IllegalArgumentException If the delay is below 0 or infinite
         */
        Builder delay(final Ticks ticks);

        /**
         * Sets the delay before the task runs. This delay is an initial offset,
         * subsequent runs (when the interval is not 0) will not be offset. By
         * default, the delay is 0.
         *
         * @param delay The delay duration
         * @return This builder, for chaining
         * @throws IllegalArgumentException If the delay duration is below 0
         */
        Builder delay(Duration delay);

        /**
         * Sets the interval between repetitions of the task. The task will not
         * repeat if the interval is 0. By default, the interval is 0.
         *
         * <p>If the scheduler detects that two tasks will overlap, the 2nd task
         * will not be started. The next time the task is due to run, the test
         * will be made again to determine if the previous occurrence of the
         * task is still alive (running). As long as a previous occurrence is
         * running no new occurrences of that specific task will start, although
         * the scheduler will never cease in trying to start it a 2nd time.</p>
         *
         * @param interval The interval duration
         * @return This builder, for chaining
         * @throws IllegalArgumentException If the interval is below 0
         */
        Builder interval(Duration interval);

        /**
         * Sets the interval between repetitions of the task. The task will not
         * repeat if the interval is 0. By default, the interval is 0.
         *
         * <p>If the scheduler detects that two tasks will overlap, the 2nd task
         * will not be started. The next time the task is due to run, the test
         * will be made again to determine if the previous occurrence of the
         * task is still alive (running). As long as a previous occurrence is
         * running no new occurrences of that specific task will start, although
         * the scheduler will never cease in trying to start it a 2nd time.</p>
         *
         * @param interval The interval in the given {@link TemporalUnit}
         * @param unit The unit the interval is in
         * @return This builder, for chaining
         * @throws IllegalArgumentException If the interval is below 0
         */
        default Builder interval(final long interval, final TemporalUnit unit) {
            return this.interval(Duration.of(interval, unit));
        }

        /**
         * Sets the interval between repetitions of the task. The task will not
         * repeat if the interval is 0. By default, the interval is 0.
         *
         * <p>If the scheduler detects that two tasks will overlap, the 2nd task
         * will not be started. The next time the task is due to run, the test
         * will be made again to determine if the previous occurrence of the
         * task is still alive (running). As long as a previous occurrence is
         * running no new occurrences of that specific task will start, although
         * the scheduler will never cease in trying to start it a 2nd time.</p>
         *
         * @param interval The interval in the given {@link TimeUnit}
         * @param unit The unit the interval is in
         * @return This builder, for chaining
         * @throws IllegalArgumentException If the interval is below 0
         */
        default Builder interval(final long interval, final TimeUnit unit) {
            return this.interval(unit.toNanos(interval), ChronoUnit.NANOS);
        }

        /**
         * Sets the interval in unit ticks between repetitions of the task.
         *
         * @param ticks The {@link Ticks} between runs.
         * @return This builder, for chaining
         * @throws IllegalArgumentException If the interval is below 0 or infinite
         */
        Builder interval(final Ticks ticks);

        /**
         * Sets the plugin of the task.
         *
         * @param plugin The plugin instance
         * @return This builder, for chaining
         * @throws IllegalArgumentException If the given object isn't a valid plugin
         */
        Builder plugin(PluginContainer plugin);

        /**
         * Builds the task.
         *
         * @return A new instance of a {@link Task}
         * @throws IllegalStateException If the {@link #execute(Runnable)} isn't set or in the
         * case that {@link #plugin(PluginContainer)} isn't set.
         */
        @Override
        Task build();
    }
}
