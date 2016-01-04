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

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.Creature;

import java.util.function.Predicate;

/**
 * An {@link AITask} which the executor finds an {@link Entity} that it avoids
 * and moves away from that entity. (MCP name: EntityAIAvoidEntity)
 */
public interface AvoidEntityAITask extends AITask<Creature> {

    /**
     * Get the target entity type.
     *
     * @return The target entity type
     */
    Class<? extends Entity> getTargetType();

    /**
     * Set the target entity type.
     *
     * @param targetType The target entity type
     * @return The task for chaining
     */
    AvoidEntityAITask setTargetType(Class<? extends Entity> targetType);

    /**
     * Get the target entity selector.
     *
     * @return The target entity selector
     */
    Predicate<Entity> getTargetSelector();

    /**
     * Set the target entity selector.
     *
     * @param targetSelector The target entity selector
     * @return The task for chaining
     */
    AvoidEntityAITask setTargetSelector(Predicate<Entity> targetSelector);

    /**
     * Get the distance for the executor to find the avoiding target.
     *
     * @return The searching distance
     */
    float getSearchDistance();

    /**
     * Set the distance for the executor to find the avoiding target.
     *
     * @param searchDistance The searching distance
     * @return The task for chaining
     */
    AvoidEntityAITask setSearchDistance(float searchDistance);

    /**
     * Get the speed of the executor when the avoiding entity is close from the
     * executor.
     *
     * @return The speed
     */
    double getCloseRangeSpeed();

    /**
     * Set the speed of the executor when the avoiding entity is close from the
     * executor.
     *
     * @param closeRangeSpeed The speed
     * @return The task for chaining
     */
    AvoidEntityAITask setCloseRangeSpeed(double closeRangeSpeed);

    /**
     * Get the speed of the executor when the avoiding entity is far from the
     * executor.
     *
     * @return The speed
     */
    double getFarRangeSpeed();

    /**
     * Set the speed of the executor when the avoiding entity is far from the
     * executor.
     *
     * @param farRangeSpeed The speed
     * @return The task for chaining
     */
    AvoidEntityAITask setFarRangeSpeed(double farRangeSpeed);

    /**
     * Get the distance which considers that the avoiding entity is far from
     * or close to the executor. Default to {@code 49.0D}.
     *
     * @return The distance
     */
    double getRangeDistance();

    /**
     * Set the distance which considers that the avoiding entity is far from
     * or close to the executor. Default to {@code 49.0D}.
     *
     * @param rangeDistance The distance
     * @return The task for chaining
     */
    AvoidEntityAITask setRangeDistance(double rangeDistance);

    /**
     * Utility builder for {@link AvoidEntityAITask}.
     */
    interface Builder extends AITaskBuilder<Creature, AvoidEntityAITask, Builder> {

        /**
         * Set the target entity type.
         *
         * @param targetType The target entity type
         * @return The builder for chaining
         */
        Builder targetType(Class<? extends Entity> targetType);

        /**
         * Set the target entity selector.
         *
         * @param targetSelector The target entity selector
         * @return The builder for chaining
         */
        Builder targetSelector(Predicate<Entity> targetSelector);

        /**
         * Set the distance for the executor to find the avoiding target.
         *
         * @param searchDistance The searching distance
         * @return The builder for chaining
         */
        Builder searchDistance(float searchDistance);

        /**
         * Set the speed of the executor when the avoiding entity is close from
         * the executor.
         *
         * @param closeRangeSpeed The speed
         * @return The builder for chaining
         */
        Builder closeRangeSpeed(double closeRangeSpeed);

        /**
         * Set the speed of the executor when the avoiding entity is far from
         * the executor.
         *
         * @param farRangeSpeed The speed
         * @return The builder for chaining
         */
        Builder farRangeSpeed(double farRangeSpeed);

        /**
         * Set the distance which considers that the avoiding entity is far from
         * or close to the executor. Default to {@code 49.0D}.
         *
         * @param rangeDistance The distance
         * @return The builder for chaining
         */
        Builder rangeDistance(double rangeDistance);

    }

}
