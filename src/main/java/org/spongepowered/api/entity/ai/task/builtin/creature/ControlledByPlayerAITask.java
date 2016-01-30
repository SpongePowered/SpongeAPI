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
package org.spongepowered.api.entity.ai.task.builtin.creature;

import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.Creature;
import org.spongepowered.api.entity.living.Humanoid;

/**
 * An {@link AITask} which the executor is controlled by the {@link Humanoid}
 * which rides the executor.
 */
public interface ControlledByPlayerAITask extends AITask<Creature> {

    /**
     * Get the maximum moving speed of the executor in the task.
     *
     * @return The maximum moving speed
     */
    float getMaxSpeed();

    /**
     * Set the maximum moving speed of the executor in the task.
     *
     * @param maxSpeed The maximum moving speed
     * @return The task for chaining
     */
    ControlledByPlayerAITask setMaxSpeed(float maxSpeed);

    /**
     * Get whether the executor has its speed boosted.
     *
     * @return Whether the speed boosted
     */
    boolean isSpeedBoosted();

    /**
     * Get the maximum time span of the speed boosting in ticks. default to 980
     * ticks.
     *
     * @return The maximum time span
     */
    int getMaxSpeedBoostTime();

    /**
     * Set the maximum time span of the speed boosting in ticks. default to 980
     * ticks.
     *
     * @param maxSpeedBoostTime The maximum time span
     * @return The task for chaining
     */
    ControlledByPlayerAITask setMaxSpeedBoostTime(int maxSpeedBoostTime);

    /**
     * Get the minimum time span of the speed boosting in ticks. default to 140
     * ticks.
     *
     * @return The minimum time span
     */
    int getMinSpeedBoostTime();

    /**
     * Set the minimum time span of the speed boosting in ticks. default to 140
     * ticks.
     *
     * @param minSpeedBoostTime The minimum time span
     * @return The task for chaining
     */
    ControlledByPlayerAITask setMinSpeedBoostTime(int minSpeedBoostTime);

    /**
     * Utility builder for {@link ControlledByPlayerAITask}.
     */
    interface Builder extends AITaskBuilder<Creature, ControlledByPlayerAITask, Builder> {

        /**
         * Set the maximum moving speed of the executor in the task.
         *
         * @param maxSpeed The maximum moving speed
         * @return The builder for chaining
         */
        Builder maxSpeed(float maxSpeed);

        /**
         * Set the maximum time span of the speed boosting in ticks. default to
         * 980 ticks.
         *
         * @param maxSpeedBoostTime The maximum time span
         * @return The builder for chaining
         */
        Builder maxSpeedBoostTime(int maxSpeedBoostTime);

        /**
         * Set the minimum time span of the speed boosting in ticks. default to
         * 140 ticks.
         *
         * @param minSpeedBoostTime The minimum time span
         * @return The builder for chaining
         */
        Builder minSpeedBoostTime(int minSpeedBoostTime);

    }

}
