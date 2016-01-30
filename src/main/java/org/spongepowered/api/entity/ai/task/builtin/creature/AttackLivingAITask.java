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

import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.Creature;

/**
 * An {@link AITask} which the executor goes to its target if the target belongs
 * to the target entity type and attacks.
 */
public interface AttackLivingAITask extends AITask<Creature> {

    double getSpeed();

    /**
     * Set the moving speed of the executor when executing the task.
     *
     * @param speed The moving speed
     * @return The task for chaining
     */
    AttackLivingAITask setSpeed(double speed);

    /**
     * Get the behavior that whether the executor will keep trying to attack the
     * target when there is no path or it cannot see the target.
     *
     * @return The behavior
     */
    boolean hasLongMemory();

    /**
     * Set the behavior that whether the executor will keep trying to attack the
     * target when there is no path or it cannot see the target.
     *
     * @param longMemory The behavior
     * @return The task for chaining
     */
    AttackLivingAITask setLongMemory(boolean longMemory);

    /**
     * Utility builder for {@link AttackLivingAITask}.
     */
    interface Builder extends AITaskBuilder<Creature, AttackLivingAITask, Builder> {

        /**
         * Set the moving speed of the executor when executing the task.
         *
         * @param speed The moving speed
         * @return The builder for chaining
         */
        Builder speed(double speed);

        /**
         * Set the behavior that whether the executor will keep trying to attack the
         * target when there is no path or it cannot see the target.
         *
         * @param longMemory The behavior
         * @return The builder for chaining
         */
        Builder longMemory(boolean longMemory);

    }

}
