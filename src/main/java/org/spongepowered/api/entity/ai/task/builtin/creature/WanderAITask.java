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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.Creature;

/**
 * An {@link AITask} in which the owner wanders around.
 */
public interface WanderAITask extends AITask<Creature> {

    /**
     * Creates a new {@link Builder} to build a {@link WanderAITask}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the moving speed of the task owner.
     *
     * @return The moving speed
     */
    double getSpeed();

    /**
     * Sets the moving speed of the task owner.
     *
     * @param speed The moving speed
     * @return This task, for chaining
     */
    WanderAITask setSpeed(double speed);

    /**
     * Gets the chance of execution of the task.
     *
     * @return The chance of execution
     */
    int getExecutionChance();

    /**
     * Sets the chance of execution of the task.
     *
     * @param executionChance The chance of execution
     * @return This task, for chaining
     */
    WanderAITask setExecutionChance(int executionChance);

    interface Builder extends AITaskBuilder<Creature, WanderAITask, Builder> {

        /**
         * Sets the moving speed of the task owner.
         *
         * @param speed The moving speed
         * @return This builder, for chaining
         */
        Builder speed(double speed);

        /**
         * Sets the chance of execution of the task.
         *
         * @param executionChance The chance of execution
         * @return This builder, for chaining
         */
        Builder executionChance(int executionChance);

    }
}
