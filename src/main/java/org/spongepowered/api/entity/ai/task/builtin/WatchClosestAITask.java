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
package org.spongepowered.api.entity.ai.task.builtin;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.Agent;

/**
 * An {@link AITask} which the executor looks at the closest entity of the
 * specific type in a fixed range randomly. It has a different mutex bits from
 * {@link WatchClosestAsInteractingAITask}.
 *
 * @param <O> The executor type
 * @param <A> The task type
 */
public interface WatchClosestAITask<O extends Agent, A extends WatchClosestAITask<O, A>> extends AITask<O> {

    /**
     * Get the type of {@link Entity} that the task executor finds and watch.
     *
     * @return The type of {@link Entity}
     */
    Class<? extends Entity> getWatchedClass();

    /**
     * Set the type of {@link Entity} that the task executor finds and watch.
     *
     * @param watchedClass The type of {@link Entity}
     * @return The task for chaining
     */
    A setWatchedClass(Class<? extends Entity> watchedClass);

    /**
     * Get the maximum distance for the task executor to find entities to watch.
     *
     * @return The maximum distance
     */
    float getMaxDistance();

    /**
     * Set the maximum distance for the task executor to find entities to watch.
     *
     * @param maxDistance The maximum distance
     * @return The task for chaining
     */
    A setMaxDistance(float maxDistance);

    /**
     * Get the chance of the task to be executed. It is {@code 0.02F} by
     * default.
     *
     * @return The chance of task execution as a fraction
     */
    float getChance();

    /**
     * Set the chance of the task to be executed. It is {@code 0.02F} by
     * default.
     *
     * @param chance The chance of task execution as a fraction
     * @return The task for chaining
     */
    A setChance(float chance);

    /**
     * Get the maximum time of looking at the target once the task starts to
     * execute. The maximum time is 80 ticks by default.
     *
     * @return The maximum time of looking once the task executes
     */
    int getMaxLookingTime();

    /**
     * Set the maximum time of looking at the target once the task starts to
     * execute. The maximum time is 80 ticks by default.
     *
     * @param maxLookingTime The maximum time of looking once the task executes
     * @return The task for chaining
     */
    A setMaxLookingTime(int maxLookingTime);

    /**
     * Get the minimum time of looking at the target once the task starts to
     * execute. The minimum time is 40 ticks by default.
     *
     * @return The minimum time of looking once the task executes
     */
    int getMinLookingTime();

    /**
     * Set the minimum time of looking at the target once the task starts to
     * execute. The minimum time is 40 ticks by default.
     *
     * @param minLookingTime The minimum time of looking once the task executes
     * @return The task for chaining
     */
    A setMinLookingTime(int minLookingTime);

    /**
     * Utility builder for {@link WatchClosestAITask}.
     *
     * @param <O> The executor type
     * @param <A> The task type
     * @param <B> The builder type
     */
    interface Builder<O extends Agent, A extends WatchClosestAITask<O, A>, B extends Builder<O, A, B>> extends AITaskBuilder<O, A, B> {

        /**
         * Set the type of {@link Entity} that the task executor is watching.
         *
         * @param watchClass The entity type to be watched
         * @return The builder for chaining
         */
        B watch(Class<? extends Entity> watchClass);

        /**
         * Set the maximum distance for the task executor to find an entity to
         * watch.
         *
         * @param maxDistance The maximum distance in float
         * @return The builder for chaining
         */
        B maxDistance(float maxDistance);

        /**
         * Set the chance of the task to be executed every tick. It is
         * {@code 0.02F} by default.
         *
         * @param chance The chance of executing this task as a fraction
         * @return The builder for chaining
         */
        B chance(float chance);

        /**
         * Set the minimum time of looking at the target once the task starts to
         * execute. The minimum time is 40 ticks by default.
         *
         * @param minLookingTime The minimum time of looking once the task
         *                       executes
         * @return The builder for chaining
         */
        B minLookingTime(int minLookingTime);

        /**
         * Set the maximum time of looking at the target once the task starts to
         * execute. The maximum time is 80 ticks by default.
         *
         * @param maxLookingTime The maximum time of looking once the task
         *                       executes
         * @return The builder for chaining
         */
        B maxLookingTime(int maxLookingTime);

    }

}
