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
 * An {@link AITask} which the executor attacks its target in a fixed range and
 * accelerates when getting close.
 */
public interface OcelotStyleAttackAITask extends AITask<Agent> {

    /**
     * Gets the maximum distance between the executor and the victim that the
     * executor will execute this task. Default to 225D.
     *
     * @return The maximum distance
     */
    double getMaxRange();

    /**
     * Sets the maximum distance between the executor and the victim that the
     * executor will execute this task. Default to 225D.
     *
     * @param maxRange The maximum distance
     * @return The task for chaining
     */
    OcelotStyleAttackAITask setMaxRange(double maxRange);

    /**
     * Gets the ticks between two attacks. Default to 20 ticks.
     *
     * @return The ticks between two attacks
     */
    int getDefaultAttackCountDown();

    /**
     * Sets the ticks between two attacks. Default to 20 ticks.
     *
     * @param attackCountDown The ticks between two attacks
     * @return The task for chaining
     */
    OcelotStyleAttackAITask setDefaultAttackCountDown(int attackCountDown);

    /**
     * Utility builder for {@link OcelotStyleAttackAITask}.
     */
    interface Builder extends AITaskBuilder<Agent, OcelotStyleAttackAITask, Builder> {

        /**
         * Sets the maximum distance between the executor and the victim that
         * the executor will execute this task. Default to 225D.
         *
         * @param maxRange The maximum distance
         * @return The builder for chaining
         */
        Builder maxRange(double maxRange);

        /**
         * Sets the ticks between two attacks. Default to 20 ticks.
         *
         * @param attackCountDown The ticks between two attacks
         * @return The builder for chaining
         */
        Builder attackCountDown(int attackCountDown);

    }

}
