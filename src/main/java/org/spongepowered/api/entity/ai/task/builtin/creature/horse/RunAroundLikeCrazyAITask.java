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
package org.spongepowered.api.entity.ai.task.builtin.creature.horse;

import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.animal.Horse;

/**
 * An {@link AITask} for {@link Horse} to try to get rid of the rider when
 * it is untamed. (MCP name: EntityAIRunAroundLikeCrazy)
 */
public interface RunAroundLikeCrazyAITask extends AITask<Horse> {

    /**
     * Get the moving speed of the executor.
     *
     * @return The moving speed
     */
    double getSpeed();

    /**
     * Set the moving speed of the executor.
     *
     * @param speed The moving speed
     * @return The task for chaining
     */
    RunAroundLikeCrazyAITask setSpeed(double speed);

    /**
     * Get the chance of reaction as a fraction of 1 over rate. Once the
     * executor reacts, the rider will be thrown off the horse or can tame the
     * horse.
     *
     * @return The rate
     */
    int getReactRate();

    /**
     * Set the chance of reaction as a fraction of 1 over rate. Once the
     * executor reacts, the rider will be thrown off the horse or can tame the
     * horse.
     *
     * @param reactRate The rate
     * @return The task for chaining
     */
    RunAroundLikeCrazyAITask setReactRate(int reactRate);

    /**
     * Utility builder for {@link RunAroundLikeCrazyAITask}.
     */
    interface Builder extends AITaskBuilder<Horse, RunAroundLikeCrazyAITask, Builder> {

        /**
         * Set the moving speed of the executor.
         *
         * @param speed The moving speed
         * @return The builder for chaining
         */
        Builder speed(double speed);

        /**
         * Set the chance of reaction as a fraction of 1 over rate. Once the
         * executor reacts, the rider will be thrown off the horse or can tame the
         * horse.
         *
         * @param reactRate The rate
         * @return The builder for chaining
         */
        Builder reactRate(int reactRate);

    }

}
