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

/**
 * An {@link AITask} which the executor walks around. (MCP name: EntityAIWander)
 */
public interface WanderAITask extends AITask<Creature> {

    /**
     * Get the executor's walking speed when executing the task.
     *
     * @return The walking speed
     */
    double getSpeed();

    /**
     * Set the executor's walking speed when executing the task.
     *
     * @param speed The walking speed
     * @return The task for chaining
     */
    WanderAITask setSpeed(double speed);

    /**
     * Get the chance of execution represented as a fraction of one divided by
     * the execution chance. Default to 120.
     *
     * @return The execution chance
     */
    int getExecutionChance();

    /**
     * Set the chance of execution represented as a fraction of one divided by
     * the execution chance. Default to 120.
     *
     * @param executionChance The execution chance
     * @return The task for chaining
     */
    WanderAITask setExecutionChance(int executionChance);

    /**
     * Utility builder for {@link WanderAITask}.
     */
    interface Builder extends AITaskBuilder<Creature, WanderAITask, Builder> {

        /**
         * Set the executor's walking speed when executing the task.
         *
         * @param speed The walking speed
         * @return The builder for chaining
         */
        Builder speed(double speed);

        /**
         * Set the chance of execution represented as a fraction of one divided
         * by the execution chance. Default to 120.
         *
         * @param executionChance The execution chance
         * @return The builder for chaining
         */
        Builder executionChance(int executionChance);

    }

}
