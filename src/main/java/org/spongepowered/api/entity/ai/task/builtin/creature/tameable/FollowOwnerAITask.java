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
package org.spongepowered.api.entity.ai.task.builtin.creature.tameable;

import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.builtin.GroundNavigationOnly;
import org.spongepowered.api.entity.living.animal.Tameable;

/**
 * An {@link AITask} for {@link Tameable}s to follow their owners. (MCP name:
 * EntityAIFollowOwner)
 */
public interface FollowOwnerAITask extends GroundNavigationOnly<Tameable> {

    /**
     * Get the moving speed of the executor.
     *
     * @return The moving speed
     */
    double getFollowingSpeed();

    /**
     * Set the moving speed of the executor.
     *
     * @param followingSpeed The moving speed
     * @return The task for chaining
     */
    FollowOwnerAITask setFollowingSpeed(double followingSpeed);

    /**
     * Get the maximum distance between the executor and its owner. Once the
     * distance exceeded this value, the pet will follow.
     *
     * @return The maximum distance
     */
    double getMaxDistance();

    /**
     * Set the maximum distance between the executor and its owner. Once the
     * distance exceeded this value, the pet will follow.
     *
     * @param maxDistance The maximum distance
     * @return The task for chaining
     */
    FollowOwnerAITask setMaxDistance(double maxDistance);

    /**
     * Get the minimum distance between the executor and its owner. If the
     * distance is smaller than this value, the task will not be executed.
     *
     * @return The minimum distance
     */
    double getMinDistance();

    /**
     * Set the minimum distance between the executor and its owner. If the
     * distance is smaller than this value, the task will not be executed.
     *
     * @param minDistance The minimum distance
     * @return The task for chaining
     */
    FollowOwnerAITask setMinDistance(double minDistance);

    /**
     * Get the frequency of the task update. It means that how many ticks will
     * there be an update.
     *
     * @return The frequency
     */
    int getUpdateFrequency();

    /**
     * Set the frequency of the task update. It means that how many ticks will
     * there be an update.
     *
     * @param updateFrequency The frequency
     * @return The task for chaining
     */
    FollowOwnerAITask setUpdateFrequency(int updateFrequency);

    /**
     * Utility builder for {@link FollowOwnerAITask}.
     */
    interface Builder extends GroundNavigationOnly.Builder<Tameable, FollowOwnerAITask, Builder> {

        /**
         * Set the moving speed of the executor.
         *
         * @param followingSpeed The moving speed
         * @return The task for chaining
         */
        Builder followingSpeed(double followingSpeed);

        /**
         * Set the maximum distance between the executor and its owner. Once the
         * distance exceeded this value, the pet will follow.
         *
         * @param maxDistance The maximum distance
         * @return The task for chaining
         */
        Builder maxDistance(double maxDistance);

        /**
         * Set the minimum distance between the executor and its owner. If the
         * distance is smaller than this value, the task will not be executed.
         *
         * @param minDistance The minimum distance
         * @return The task for chaining
         */
        Builder minDistance(double minDistance);

        /**
         * Set the frequency of the task update. It means that how many ticks will
         * there be an update.
         *
         * @param updateFrequency The frequency
         * @return The task for chaining
         */
        Builder updateFrequency(int updateFrequency);

    }

}
