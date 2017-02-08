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
import org.spongepowered.api.entity.living.Ranger;

/**
 * An {@link AITask} which uses the ranging aspect of the {@link Ranger} to
 * attack the target.
 */
public interface RangeAgentAITask extends AITask<Ranger> {

    /**
     * Creates a new {@link Builder} to build a {@link RangeAgentAITask}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the moving speed of this {@link Ranger}.
     *
     * @return The moving speed
     */
    double getMoveSpeed();

    /**
     * Sets the moving speed of this {@link Ranger}.
     *
     * @param speed The moving speed
     * @return This task, for chaining
     */
    RangeAgentAITask setMoveSpeed(double speed);

    /**
     * Gets the time, in ticks, this {@link Ranger} will wait before attacking
     * again.
     *
     * @return The delay, in ticks
     */
    int getDelayBetweenAttacks();

    /**
     * Sets the time, in ticks, this {@link Ranger} will wait before attacking
     * again.
     *
     * @param delay The delay, in ticks
     * @return This task, for chaining
     */
    RangeAgentAITask setDelayBetweenAttacks(int delay);

    /**
     * Gets the attack radius of this {@link Ranger}.
     *
     * @return The attack radius
     */
    float getAttackRadius();

    /**
     * Sets the attack radius of this {@link Ranger}.
     *
     * @param radius The attack radius
     * @return This task, for chaining
     */
    RangeAgentAITask setAttackRadius(float radius);

    interface Builder extends AITaskBuilder<Ranger, RangeAgentAITask, RangeAgentAITask.Builder> {

        /**
         * Sets the moving speed of the task owner.
         *
         * @param speed The moving speed
         * @return This builder, for chaining
         */
        Builder moveSpeed(double speed);

        /**
         * Sets the time, in ticks, the task owner will wait before attacking
         * again.
         *
         * @param delay The delay, in ticks
         * @return This builder, for chaining
         */
        Builder delayBetweenAttacks(int delay);

        /**
         * Sets the attack radius of the task owner.
         *
         * @param radius The attack radius
         * @return This builder, for chaining
         */
        Builder attackRadius(float radius);

    }

}
