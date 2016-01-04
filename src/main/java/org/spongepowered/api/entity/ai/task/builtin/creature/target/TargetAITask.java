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
package org.spongepowered.api.entity.ai.task.builtin.creature.target;

import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.Creature;

/**
 * An {@link AITask} which the executor tries to approach and attack its target.
 * (MCP name: EntityAITarget)
 *
 * @param <A> The task type
 * @param <B> The executor type
 */
public interface TargetAITask<A extends TargetAITask<A, B>, B extends Creature> extends AITask<B> {

    /**
     * Get whether the target should be seen by the executor to execute the
     * task.
     *
     * @return Whether the target should be seen
     */
    boolean shouldCheckSight();

    /**
     * Set whether the target should be seen by the executor to execute the
     * task.
     *
     * @param checkSight Whether the target should be seen
     * @return The task for chaining
     */
    A setCheckSight(boolean checkSight);

    /**
     * Get whether the executor only finds "simple ways" to approach the target.
     *
     * @return Whether the executor only finds "simple ways"
     */
    boolean onlyNearby();

    /**
     * Set whether the executor only finds "simple ways" to approach the target.
     *
     * @param onlyNearby Whether the executor only finds "simple ways"
     * @return The task for chaining
     */
    A setOnlyNearby(boolean onlyNearby);

    /**
     * Get the search status of the "simple ways" of this task. Has no effect
     * when {@link TargetAITask#onlyNearby()} is {@code false}.
     *
     * <p>Different cases: </p>
     *
     * <p>0: Has not yet started a search;</p>
     *
     * <p>1: Has an "easy way" to approach the target;</p>
     *
     * <p>2: Does not have an "easy way" to approach the target.</p>
     *
     * @return The search status
     */
    int getSearchStatus();

    /**
     * Set the search status of the "simple ways" of this task. Has no effect
     * when {@link TargetAITask#onlyNearby()} is {@code false}.
     *
     * <p>Different cases: </p>
     *
     * <p>0: Has not yet started a search;</p>
     *
     * <p>1: Has an "easy way" to approach the target;</p>
     *
     * <p>2: Does not have an "easy way" to approach the target.</p>
     *
     * @param searchStatus The search status
     * @return The task for chaining
     */
    A setSearchStatus(int searchStatus);

    /**
     * Get the minimum time delay between two searches for targets. Has no
     * effect when {@link TargetAITask#onlyNearby()} is {@code false}.
     *
     * @return The minimum time
     */
    int getMinSearchDelay();

    /**
     * Set the minimum time delay between two searches for targets. Has no
     * effect when {@link TargetAITask#onlyNearby()} is {@code false}.
     *
     * @param minSearchDelay The minimum time
     * @return The task for chaining
     */
    A setMinSearchDelay(int minSearchDelay);

    /**
     * Get the maximum time delay between two searches for targets. Has no
     * effect when {@link TargetAITask#onlyNearby()} is {@code false}.
     *
     * @return The maximum time
     */
    int getMaxSearchDelay();

    /**
     * Set the maximum time delay between two searches for targets. Has no
     * effect when {@link TargetAITask#onlyNearby()} is {@code false}.
     *
     * @param maxSearchDelay The maximum time
     * @return The task for chaining
     */
    A setMaxSearchDelay(int maxSearchDelay);

    /**
     * Get the maximum time of task hanging when the executor cannot find its
     * target. Once the time exceeds the task will pause execution. Has no
     * effect when {@link TargetAITask#shouldCheckSight()} is {@code false}.
     *
     * @return The maximum time
     */
    int getMaxTimeWithTargetUnseen();

    /**
     * Set the maximum time of task hanging when the executor cannot find its
     * target. Once the time exceeds the task will pause execution. Has no
     * effect when {@link TargetAITask#shouldCheckSight()} is {@code false}.
     *
     * @param maxTimeWithTargetUnseen The maximum time
     * @return The task for chaining
     */
    A setMaxTimeWithTargetUnseen(int maxTimeWithTargetUnseen);

    /**
     * Utility builder for {@link TargetAITask}.
     *
     * @param <O> The executor type
     * @param <A> The task type
     * @param <B> The builder type
     */
    interface Builder<O extends Creature, A extends TargetAITask<A, O>, B extends Builder<O, A, B>>
            extends AITaskBuilder<O, A, B> {

        /**
         * Set whether the target should be seen by the executor to execute the
         * task.
         *
         * @param checkSight Whether the target should be seen
         * @return The builder for chaining
         */
        B checkSight(boolean checkSight);

        /**
         * Set whether the executor only finds "simple ways" to approach the
         * target.
         *
         * @param onlyNearby Whether the executor only finds "simple ways"
         * @return The builder for chaining
         */
        B onlyNearby(boolean onlyNearby);

        /**
         * Set the minimum time delay between two searches for targets. Has no
         * effect when {@link TargetAITask#onlyNearby()} is {@code false}.
         *
         * @param minSearchDelay The minimum time
         * @return The builder for chaining
         */
        B minSearchDelay(int minSearchDelay);

        /**
         * Set the maximum time delay between two searches for targets. Has no
         * effect when {@link TargetAITask#onlyNearby()} is {@code false}.
         *
         * @param maxSearchDelay The maximum time
         * @return The builder for chaining
         */
        B maxSearchDelay(int maxSearchDelay);

        /**
         * Set the maximum time of task hanging when the executor cannot find
         * its target. Once the time exceeds the task will pause execution. Has
         * no effect when {@link TargetAITask#shouldCheckSight()} is
         * {@code false}.
         *
         * @param maxTimeWithTargetUnseen The maximum time
         * @return The builder for chaining
         */
        B maxTimeWithTargetUnseen(int maxTimeWithTargetUnseen);

    }

}
