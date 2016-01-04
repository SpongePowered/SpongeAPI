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
 * An {@link AITask} which the executor goes through a door in a village.
 * (MCP name: EntityAIMoveThroughVillage)
 */
public interface MoveThroughVillageAITask extends AITask<Creature> {

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
    MoveThroughVillageAITask setSpeed(double speed);

    /**
     * Get the behavior that whether the executor only executes at night.
     *
     * @return The boolean that represents the behavior
     */
    boolean getAtNightOnly();

    /**
     * Set the behavior that whether the executor only executes at night.
     *
     * @param atNightOnly The boolean that represents the behavior
     * @return The task for chaining
     */
    MoveThroughVillageAITask setAtNightOnly(boolean atNightOnly);

    /**
     * Utility builder for {@link MoveThroughVillageAITask}.
     */
    interface Builder extends AITaskBuilder<Creature, MoveThroughVillageAITask, Builder> {

        /**
         * Set the moving speed of the executor.
         *
         * @param speed The moving speed
         * @return The builder for chaining
         */
        Builder speed(double speed);

        /**
         * Set the behavior that whether the executor only executes at night.
         *
         * @param atNightOnly The boolean that represents the behavior
         * @return The builder for chaining
         */
        Builder atNightOnly(boolean atNightOnly);

    }

}
