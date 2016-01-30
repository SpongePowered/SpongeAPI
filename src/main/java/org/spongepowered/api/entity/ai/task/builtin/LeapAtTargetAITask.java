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

import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.Agent;

/**
 * An {@link AITask} which the executor jumps at the target in a specific range
 * at a fixed chance while attacking.
 */
public interface LeapAtTargetAITask extends AITask<Agent> {

    /**
     * Get the executor's leaping height at task execution.
     *
     * @return The executor's leaping height
     */
    float getJumpHeight();

    /**
     * Set the executor's leaping height at task execution.
     *
     * @param jumpHeight The executor's leaping height
     * @return The task for chaining
     */
    LeapAtTargetAITask setJumpHeight(float jumpHeight);

    /**
     * Set the minimum distance for the executor to execute this task. Default
     * to {@code 4.0D}.
     *
     * @return The minimum distance
     */
    double getMinExecutionDistance();

    /**
     * Get the minimum distance for the executor to execute this task. Default
     * to {@code 4.0D}.
     *
     * @param minExecutionDistance The minimum distance
     * @return The task for chaining
     */
    LeapAtTargetAITask setMinExecutionDistance(double minExecutionDistance);

    /**
     * Set the maximum distance for the executor to execute this task. Default
     * to {@code 16.0D}.
     *
     * @return The maximum distance
     */
    double getMaxExecutionDistance();

    /**
     * Get the maximum distance for the executor to execute this task. Default
     * to {@code 16.0D}.
     *
     * @param maxExecutionDistance The maximum distance
     * @return The task for chaining
     */
    LeapAtTargetAITask setMaxExecutionDistance(double maxExecutionDistance);

    /**
     * Get the chance for the task to be executed when the condition matches.
     * Default rate is 1 in 5.
     *
     * @return The chance
     */
    float getChance();

    /**
     * Set the chance for the task to be executed when the condition matches.
     * Default rate is 1 in 5.
     *
     * @param chance The chance
     * @return The task for chaining
     */
    LeapAtTargetAITask setChance(float chance);

    interface Builder extends AITaskBuilder<Agent, LeapAtTargetAITask, Builder> {

        /**
         * Set the executor's leaping height at task execution.
         *
         * @param jumpHeight The executor's leaping height
         * @return The builder for chaining
         */
        Builder jumpHeight(float jumpHeight);

        /**
         * Get the minimum distance for the executor to execute this task. Default
         * to {@code 4.0D}.
         *
         * @param minExecutionDistance The minimum distance
         * @return The builder for chaining
         */
        Builder minExecutionDistance(double minExecutionDistance);

        /**
         * Get the maximum distance for the executor to execute this task.
         * Default to {@code 16.0D}.
         *
         * @param maxExecutionDistance The maximum distance
         * @return The builder for chaining
         */
        Builder maxExecutionDistance(double maxExecutionDistance);

        /**
         * Set the chance for the task to be executed when the condition
         * matches. Default rate is 1 in 5.
         *
         * @param chance The chance
         * @return The builder for chaining
         */
        Builder chance(float chance);

    }

}
