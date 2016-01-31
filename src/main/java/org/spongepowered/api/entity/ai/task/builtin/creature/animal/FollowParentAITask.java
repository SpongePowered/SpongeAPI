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
package org.spongepowered.api.entity.ai.task.builtin.creature.animal;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.animal.Animal;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * An {@link AITask} for child {@link Animal}s to follow an adult animal.
 */
public interface FollowParentAITask extends AITask<Animal> {

    /**
     * Creates a new {@link Builder} to build an {@link FollowParentAITask}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

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
    FollowParentAITask setSpeed(double speed);

    /**
     * Get the range of the executor finding an adult animal as parent. Default
     * to {@code 8.0D}.
     *
     * @return The range
     */
    double getFindingRange();

    /**
     * Set the range of the executor finding an adult animal as parent. Default
     * to {@code 8.0D}.
     *
     * @param findingRange The range
     * @return The task for chaining
     */
    FollowParentAITask setFindingRange(double findingRange);

    /**
     * Get the ticks between twice of followings of the child animal.
     *
     * @return The ticks
     */
    int getFollowingFrequency();

    /**
     * Set the ticks between twice of followings of the child animal.
     *
     * @param followingFrequency The ticks
     * @return The task for chaining
     */
    FollowParentAITask setFollowingFrequency(int followingFrequency);

    /**
     * Get the minimum distance for the executor to follow the adult. If the
     * distance is smaller than this limit, then the task will not execute.
     * Default to {@code 3.0D}.
     *
     * @return The minimum distance
     */
    double getMinFollowingDistance();

    /**
     * Set the minimum distance for the executor to follow the adult. If the
     * distance is smaller than this limit, then the task will not execute.
     * Default to {@code 3.0D}.
     *
     * @param minFollowingDistance The minimum distance
     * @return The task for chaining
     */
    FollowParentAITask setMinFollowingDistance(double minFollowingDistance);

    /**
     * Get the maximum distance for the executor to follow the adult. If the
     * distance is larger than this limit, then the task will not execute.
     * Default to {@code 16.0D}.
     *
     * @return The maximum distance
     */
    double getMaxFollowingDistance();

    /**
     * Set the maximum distance for the executor to follow the adult. If the
     * distance is larger than this limit, then the task will not execute.
     * Default to {@code 16.0D}.
     *
     * @param maxFollowingDistance The maximum distance
     * @return The task for chaining
     */
    FollowParentAITask setMaxFollowingDistance(double maxFollowingDistance);

    /**
     * Get the parent animal that the child is following. May or may not exist.
     *
     * @return The parent animal in optional, or empty
     */
    Optional<Animal> getParent();

    /**
     * Utility builder for {@link FollowParentAITask}.
     */
    interface Builder extends AITaskBuilder<Animal, FollowParentAITask, Builder> {

        /**
         * Set the moving speed of the executor.
         *
         * @param speed The moving speed
         * @return The builder for chaining
         */
        Builder speed(double speed);

        /**
         * Set the range of the executor finding an adult animal as parent. Default
         * to {@code 8.0D}.
         *
         * @param findingRange The range
         * @return The builder for chaining
         */
        Builder findingRange(double findingRange);

        /**
         * Set the ticks between twice of followings of the child animal.
         *
         * @param followingFrequency The ticks
         * @return The builder for chaining
         */
        Builder followingFrequency(int followingFrequency);

        /**
         * Set the minimum distance for the executor to follow the adult. If the
         * distance is smaller than this limit, then the task will not execute.
         * Default to {@code 3.0D}.
         *
         * @param minFollowingDistance The minimum distance
         * @return The builder for chaining
         */
        Builder minFollowingDistance(double minFollowingDistance);

        /**
         * Set the maximum distance for the executor to follow the adult. If the
         * distance is larger than this limit, then the task will not execute.
         * Default to {@code 16.0D}.
         *
         * @param maxFollowingDistance The maximum distance
         * @return The builder for chaining
         */
        Builder maxFollowingDistance(double maxFollowingDistance);

    }

}
