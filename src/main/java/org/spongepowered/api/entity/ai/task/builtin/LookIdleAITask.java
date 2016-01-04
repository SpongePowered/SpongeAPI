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
 * An {@link AITask} which the executor looks around at a random offset at for
 * a ranged random time span. (MCP name: EntityAILookIdle)
 */
public interface LookIdleAITask extends AITask<Agent> {

    /**
     * Get the minimum time span of the executor looking around. Default to 20
     * ticks.
     *
     * @return The minimum time span
     */
    int getMinIdleTime();

    /**
     * Set the minimum time span of the executor looking around. Default to 20
     * ticks.
     *
     * @param minIdleTime The minimum time span
     * @return The task for chaining
     */
    LookIdleAITask setMinIdleTime(int minIdleTime);

    /**
     * Get the maximum time span of the executor looking around. Default to 40
     * ticks.
     *
     * @return The maximum time span
     */
    int getMaxIdleTime();

    /**
     * Set the maximum time span of the executor looking around. Default to 40
     * ticks.
     *
     * @param maxIdleTime The maximum time span
     * @return The task for chaining
     */
    LookIdleAITask setMaxIdleTime(int maxIdleTime);

    /**
     * Get the chance of the executor looking around as a fraction. Default to
     * {@code 0.02F}.
     *
     * @return The chance as a fraction
     */
    float getChance();

    /**
     * Set the chance of the executor looking around as a fraction. Default to
     * {@code 0.02F}.
     *
     * @param chance The chance as a fraction
     * @return The task for chaining
     */
    LookIdleAITask setChance(float chance);

    /**
     * Utility builder for {@link LookIdleAITask}.
     */
    interface Builder extends AITaskBuilder<Agent, LookIdleAITask, Builder> {

        /**
         * Set the minimum time span of the executor looking around. Default to
         * 20 ticks.
         *
         * @param minIdleTime The minimum time span
         * @return The builder for chaining
         */
        Builder minIdleTime(int minIdleTime);

        /**
         * Set the maximum time span of the executor looking around. Default to
         * 40 ticks.
         *
         * @param maxIdleTime The maximum time span
         * @return The builder for chaining
         */
        Builder maxIdleTime(int maxIdleTime);

        /**
         * Set the chance of the executor looking around as a fraction. Default
         * to {@code 0.02F}.
         *
         * @param chance The chance as a fraction
         * @return The builder for chaining
         */
        Builder chance(float chance);

    }

}
