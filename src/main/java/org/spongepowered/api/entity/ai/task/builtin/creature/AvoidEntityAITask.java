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
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.entity.living.Creature;

import java.util.function.Predicate;

public interface AvoidEntityAITask extends AITask<Creature> {

    /**
     * Creates a new {@link Builder} for creating a new {@link AvoidEntityAITask}.
     *
     * @return A new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the {@link Predicate} for filtering which {@link Entity} instances
     * are qualified to have the owning {@link Agent} move away from the
     * {@link Entity} of which the {@link Predicate#test(Object)} returns
     * {@code true}.
     *
     * @return The predicate used to filter which entities to avoid
     */
    Predicate<Entity> getTargetSelector();

    /**
     * Sets the {@link Predicate} for filtering which {@link Entity} instances
     * are considered to be "avoided" by the owning {@link Agent}.
     *
     * @param predicate The predicate
     * @return This task, for chaining
     */
    AvoidEntityAITask setTargetSelector(Predicate<Entity> predicate);

    /**
     * Gets the search distance at which any {@link Entity} instances in a
     * radius of the parent {@link Agent} are considered for avoiding.
     *
     * @return The search distance
     */
    float getSearchDistance();

    /**
     * Sets the search distance at which any {@link Entity} instances in a
     * radius of the parent {@link Agent} are considered for avoiding.
     *
     * @param distance The search distance
     * @return This task, for chaining
     */
    AvoidEntityAITask setSearchDistance(float distance);

    /**
     * Gets the speed "modifier" for which the parent {@link Agent} will
     * move away from a found {@link Entity} to "avoid" when in close
     * range. Close range is currently defined as {@code 7} blocks.
     *
     * @return The close range movement speed modifier
     */
    double getCloseRangeSpeed();

    /**
     * Sets the peed "modifier" for which the parent {@link Agent} will
     * move away from a found {@link Entity} to "avoid" when in close
     * range. Close range is currently defined as {@code 7} blocks.
     *
     * @param speed The movement speed modifier
     * @return This task, for chaining
     */
    AvoidEntityAITask setCloseRangeSpeed(double speed);

    /**
     * Gets the close range speed "modifier" for which the parent {@link Agent}
     * will move away from a found {@link Entity} to "avoid" when in
     * a farther range than 7 blocks.
     *
     * @return The close range speed
     */
    double getFarRangeSpeed();

    /**
     * Sets the close range speed "modifier" for which the parent {@link Agent}
     * will move away from a found {@link Entity} to "avoid" when in
     * a farther range than 7 blocks.
     *
     * @param speed The movement speed modifier
     * @return This task, for chaining
     */
    AvoidEntityAITask setFarRangeSpeed(double speed);

    interface Builder extends AITaskBuilder<Creature, AvoidEntityAITask, Builder> {

        /**
         * Sets the {@link Predicate} for filtering which {@link Entity} instances
         * are considered to be "avoided" by the owning {@link Agent}.
         *
         * @param predicate The predicate
         * @return This builder, for chaining
         */
        Builder targetSelector(Predicate<Entity> predicate);

        /**
         * Sets the search distance at which any {@link Entity} instances in a
         * radius of the parent {@link Agent} are considered for avoiding.
         *
         * @param distance The search distance
         * @return This builder, for chaining
         */
        Builder searchDistance(float distance);

        /**
         * Sets the peed "modifier" for which the parent {@link Agent} will
         * move away from a found {@link Entity} to "avoid" when in close
         * range. Close range is currently defined as {@code 7} blocks.
         *
         * @param speed The movement speed modifier
         * @return This builder, for chaining
         */
        Builder closeRangeSpeed(double speed);

        /**
         * Sets the close range speed "modifier" for which the parent {@link Agent}
         * will move away from a found {@link Entity} to "avoid" when in
         * a farther range than 7 blocks.
         *
         * @param speed The movement speed modifier
         * @return This builder, for chaining
         */
        Builder farRangeSpeed(double speed);

    }
}
