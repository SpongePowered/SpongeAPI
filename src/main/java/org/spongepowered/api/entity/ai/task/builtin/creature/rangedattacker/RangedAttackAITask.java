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
package org.spongepowered.api.entity.ai.task.builtin.creature.rangedattacker;

import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.RangedAttackingAgent;

/**
 * An {@link AITask} which the executor attacks its target with ranged attacking
 * method. (MCP name: EntityAIArrowAttack)
 */
public interface RangedAttackAITask extends AITask<RangedAttackingAgent> {

    /**
     * Get the maximum time between two attacks.
     *
     * @return The maximum time
     */
    int getMaxCoolDown();

    /**
     * Set the maximum time between two attacks.
     *
     * @param maxCoolDown The maximum time
     * @return The task for chaining
     */
    RangedAttackAITask setMaxCoolDown(int maxCoolDown);

    /**
     * Get the minimum time between two attacks.
     *
     * @return The minimum time
     */
    int getMinCoolDown();

    /**
     * Set the minimum time between two attacks.
     *
     * @param minCoolDown The minimum time
     * @return The task for chaining
     */
    RangedAttackAITask setMinCoolDown(int minCoolDown);

    /**
     * Get the moving speed of the executor.
     *
     * @return The moving speed
     */
    double getMoveSpeed();

    /**
     * Set the moving speed of the executor.
     *
     * @param moveSpeed The moving speed
     * @return The task for chaining
     */
    RangedAttackAITask setMoveSpeed(double moveSpeed);

    /**
     * Get the maximum distance between the executor and the target.
     *
     * @return The maximum distance
     */
    double getMaxAttackDistance();

    /**
     * Set the maximum distance between the executor and the target.
     *
     * @param maxAttackDistance The maximum distance
     * @return The task for chaining
     */
    RangedAttackAITask setMaxAttackDistance(double maxAttackDistance);

    /**
     * Utility builder for {@link RangedAttackAITask}.
     */
    interface Builder extends AITaskBuilder<RangedAttackingAgent, RangedAttackAITask, Builder> {

        /**
         * Set the maximum time between two attacks.
         *
         * @param maxCoolDown The maximum time
         * @return The builder for chaining
         */
        Builder maxCoolDown(double maxCoolDown);

        /**
         * Set the minimum time between two attacks.
         *
         * @param minCoolDown The minimum time
         * @return The builder for chaining
         */
        Builder minCoolDown(double minCoolDown);

        /**
         * Set the moving speed of the executor.
         *
         * @param moveSpeed The moving speed
         * @return The builder for chaining
         */
        Builder moveSpeed(double moveSpeed);

        /**
         * Set the maximum distance between the executor and the target.
         *
         * @param maxAttackDistance The maximum distance
         * @return The builder for chaining
         */
        Builder maxAttackDistance(double maxAttackDistance);

    }

}
