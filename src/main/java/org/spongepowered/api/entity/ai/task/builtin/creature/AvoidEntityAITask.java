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
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.Creature;

import java.util.function.Predicate;

/**
 * An {@link AITask} in which the owner avoids certain {@link Entity Entities}.
 */
public interface AvoidEntityAITask extends AITask<Creature> {

    /**
     * Creates a new {@link Builder} to build a {@link AvoidEntityAITask}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the target selector of this task.
     *
     * @return The target selector
     */
    Predicate<Entity> getTargetSelector();

    /**
     * Sets the target selector of this task.
     *
     * @param predicate The target selector
     * @return This task, for chaining
     */
    AvoidEntityAITask setTargetSelector(Predicate<Entity> predicate);

    /**
     * Sets the search distance of this task.
     *
     * @return The search distance
     */
    float getSearchDistance();

    /**
     * Sets the search distance of this task.
     *
     * @param distance The search distance
     * @return This task, for chaining
     */
    AvoidEntityAITask setSearchDistance(float distance);

    /**
     * Sets the speed of the task owner when it's close to the entity to avoid.
     *
     * @return The speed
     */
    double getCloseRangeSpeed();

    /**
     * Sets the speed of the task owner when it's close to the entity to avoid.
     *
     * @param speed The speed
     * @return This task, for chaining
     */
    AvoidEntityAITask setCloseRangeSpeed(double speed);

    /**
     * Sets the speed of the task owner when it's far from the entity to avoid.
     *
     * @return The speed
     */
    double getFarRangeSpeed();

    /**
     * Sets the speed of the task owner when it's far from the entity to avoid.
     *
     * @param speed The speed
     * @return This task, for chaining
     */
    AvoidEntityAITask setFarRangeSpeed(double speed);

    interface Builder extends AITaskBuilder<Creature, AvoidEntityAITask, Builder> {

        /**
         * Sets the target selector of this task.
         *
         * @param predicate The target selector
         * @return This builder, for chaining
         */
        Builder targetSelector(Predicate<Entity> predicate);

        /**
         * Sets the search distance of this task.
         *
         * @param distance The search distance
         * @return This builder, for chaining
         */
        Builder searchDistance(float distance);

        /**
         * Sets the speed of the task owner when it's close to the entity to
         * avoid.
         *
         * @param speed The speed
         * @return This builder, for chaining
         */
        Builder closeRangeSpeed(double speed);

        /**
         * Sets the speed of the task owner when it's far from the entity to
         * avoid.
         *
         * @param speed The speed
         * @return This builder, for chaining
         */
        Builder farRangeSpeed(double speed);

    }
}
