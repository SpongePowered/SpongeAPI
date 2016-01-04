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
package org.spongepowered.api.entity.ai.task.builtin.creature.movetolocation;

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.Creature;

/**
 * An {@link AITask} that the executor moves to its target. (MCP name:
 * EntityAIMoveTowardsTarget)
 */
public interface MoveToLivingAITask extends AITask<Creature> {

    /**
     * Get the destination the executor is going to.
     *
     * @return The destination of the task
     */
    Vector3d getDestinationAsLocation();

    /**
     * Get the moving speed of the executor.
     *
     * @return The moving speed
     */
    double getSpeed();


    MoveToLivingAITask setSpeed(double speed);

    /**
     * Get the maximum distance allowed from the executor to the target, once
     * exceeded the task will stop executing.
     *
     * @return The maximum distance
     */
    float getMaxDistance();

    /**
     * Set the maximum distance allowed from the executor to the target, once
     * exceeded the task will stop executing.
     *
     * @param maxDistance The maximum distance
     * @return The task for chaining
     */
    MoveToLivingAITask setMaxDistance(float maxDistance);

    /**
     * Utility builder for {@link MoveToHomeAITask}.
     */
    interface Builder extends AITaskBuilder<Creature, MoveToLivingAITask, Builder> {

        /**
         * Set the moving speed of the executor.
         *
         * @param speed The moving speed
         * @return The builder for chaining
         */
        Builder speed(double speed);

        /**
         * Set the maximum distance allowed from the executor to the target, once
         * exceeded the task will stop executing.
         *
         * @param maxDistance The maximum distance
         * @return The builder for chaining
         */
        Builder maxDistance(double maxDistance);

    }

}
