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
package org.spongepowered.api.entity.ai.task.builtin.creature.villager;

import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.Villager;
import org.spongepowered.api.entity.living.golem.IronGolem;

import java.util.Optional;

/**
 * An {@link AITask} for {@link Villager}s to accept poppies from
 * {@link IronGolem}s when they gave poppies. (MCP name: EntityAIFollowGolem)
 */
public interface AcceptPoppyAITask extends AITask<Villager> {

    /**
     * Get the minimum time required for {@link IronGolem}s to hold the poppies
     * before the executor accepts it in ticks. Default to 0 tick.
     *
     * @return The minimum time
     */
    int getMinPoppyHoldingTimeRequired();

    /**
     * Set the minimum time required for {@link IronGolem}s to hold the poppies
     * before the executor accepts it in ticks. Default to 0 tick.
     *
     * @param minPoppyHoldingTimeRequired The minimum time
     * @return The task for chaining
     */
    AcceptPoppyAITask setMinPoppyHoldingTimeRequired(int minPoppyHoldingTimeRequired);

    /**
     * Get the maximum time required for {@link IronGolem}s to hold the poppies
     * before the executor accepts it in ticks. Default to 319 ticks.
     *
     * @return The maximum time
     */
    int getMaxPoppyHoldingTimeRequired();

    /**
     * Set the maximum time required for {@link IronGolem}s to hold the poppies
     * before the executor accepts it in ticks. Default to 319 ticks.
     *
     * @param maxPoppyHoldingTimeRequired The maximum time
     * @return The task for chaining
     */
    AcceptPoppyAITask setMaxPoppyHoldingTimeRequired(int maxPoppyHoldingTimeRequired);

    /**
     * Get the moving speed of the executor when going to the {@link IronGolem}
     * to accept the poppy. Default to {@code 0.5D}.
     *
     * @return The moving speed
     */
    double getSpeed();

    /**
     * Set the moving speed of the executor when going to the {@link IronGolem}
     * to accept the poppy. Default to {@code 0.5D}.
     *
     * @param speed The moving speed
     * @return The task for chaining
     */
    AcceptPoppyAITask setSpeed(double speed);

    /**
     * Get the minimum distance for the executor to pick up the poppy from the
     * {@link IronGolem}. Default to {@code 4.0D}.
     *
     * @return The minimum distance
     */
    double getMinDistance();

    /**
     * Set the minimum distance for the executor to pick up the poppy from the
     * {@link IronGolem}. Default to {@code 4.0D}.
     *
     * @param minDistance The minimum distance
     * @return The task for chaining
     */
    AcceptPoppyAITask setMinDistance(double minDistance);

    /**
     * Get the current {@link IronGolem} that the executor is interacting with.
     * May not exist when task is not active.
     *
     * @return The iron golem in optional, or empty
     */
    Optional<IronGolem> getPoppySource();

    /**
     * Utility builder for {@link AcceptPoppyAITask}.
     */
    interface Builder extends AITaskBuilder<Villager, AcceptPoppyAITask, Builder> {

        /**
         * Set the minimum time required for {@link IronGolem}s to hold the
         * poppies before the executor accepts it in ticks. Default to 0 tick.
         *
         * @param minPoppyHoldingTimeRequired The minimum time
         * @return The task for chaining
         */
        Builder minPoppyHoldingTimeRequired(int minPoppyHoldingTimeRequired);

        /**
         * Set the maximum time required for {@link IronGolem}s to hold the
         * poppies before the executor accepts it in ticks. Default to 319
         * ticks.
         *
         * @param maxPoppyHoldingTimeRequired The maximum time
         * @return The task for chaining
         */
        Builder maxPoppyHoldingTimeRequired(int maxPoppyHoldingTimeRequired);

        /**
         * Set the moving speed of the executor when going to the
         * {@link IronGolem} to accept the poppy. Default to {@code 0.5D}.
         *
         * @param speed The moving speed
         * @return The task for chaining
         */
        Builder speed(double speed);

        /**
         * Set the minimum distance for the executor to pick up the poppy from
         * the {@link IronGolem}. Default to {@code 4.0D}.
         *
         * @param minDistance The minimum distance
         * @return The task for chaining
         */
        Builder minDistance(double minDistance);

    }

}
