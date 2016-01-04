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
package org.spongepowered.api.entity.ai.task.builtin.creature.wolf;

import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.entity.living.animal.Wolf;

import java.util.Optional;

/**
 * An {@link AITask} that a {@link Wolf} begs a {@link Humanoid} for bones or
 * breeding items (meat). (MCP name: EntityAIBeg)
 */
public interface BegAITask extends AITask<Wolf> {

    /**
     * Get the distance for the executor to find a {@link Humanoid} to beg.
     *
     * @return The distance
     */
    float getMinDistance();

    /**
     * Set the distance for the executor to find a {@link Humanoid} to beg.
     *
     * @param minDistance The distance
     * @return The task for chaining
     */
    BegAITask setMinDistance(float minDistance);

    /**
     * Get the maximum begging time for the executor to beg.
     *
     * @return The maximum begging time
     */
    int getMaxBeggingTime();

    /**
     * Set the maximum begging time for the executor to beg.
     *
     * @param maxBeggingTime The maximum begging time
     * @return The task for chaining
     */
    BegAITask setMaxBeggingTime(int maxBeggingTime);

    /**
     * Get the minimum time for the executor to beg.
     *
     * @return The minimum begging time
     */
    int getMinBeggingTime();

    /**
     * Set the minimum time for the executor to beg.
     *
     * @param minBeggingTime The minimum begging time
     * @return The task for chaining
     */
    BegAITask setMinBeggingTime(int minBeggingTime);

    /**
     * Get the {@link Humanoid} that the executor is begging wrapped in
     * {@link Optional}. Sometimes there's no one who was begged.
     *
     * @return The humanoid or empty wrapped in optional
     */
    Optional<Humanoid> getBeggingTarget();

    /**
     * Utility builder for {@link BegAITask}.
     */
    interface Builder extends AITaskBuilder<Wolf, BegAITask, Builder> {

        /**
         * Set the distance for the executor to find a {@link Humanoid} to beg.
         *
         * @param minDistance The distance
         * @return The builder for chaining
         */
        Builder minDistance(float minDistance);

        /**
         * Set the maximum begging time for the executor to beg.
         *
         * @param maxBeggingTime The maximum begging time
         * @return The builder for chaining
         */
        Builder maxBeggingTime(int maxBeggingTime);

        /**
         * Set the minimum time for the executor to beg.
         *
         * @param minBeggingTime The minimum begging time
         * @return The builder for chaining
         */
        Builder minBeggingTime(int minBeggingTime);

    }

}
