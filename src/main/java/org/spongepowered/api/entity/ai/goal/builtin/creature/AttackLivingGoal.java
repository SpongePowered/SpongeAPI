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
package org.spongepowered.api.entity.ai.goal.builtin.creature;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.ai.goal.Goal;
import org.spongepowered.api.entity.ai.goal.GoalBuilder;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.entity.living.Creature;

public interface AttackLivingGoal extends Goal<Creature> {

    /**
     * Creates a new {@link Builder} to build a new
     * {@link AttackLivingGoal}.
     *
     * @return A new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the "movement" speed modifier when targeting towards a
     * targeted {@link Entity}.
     *
     * @return The movement speed modifier when targeting an entity
     */
    double getSpeed();

    /**
     * Sets the movement speed modifier when the parent {@link Creature}
     * is targeting an {@link Entity}.
     *
     * @param speed The speed
     * @return This goal, for chaining
     */
    AttackLivingGoal setSpeed(double speed);

    /**
     * Gets whether the navigator will attempt to continue to "target"
     * an {@link Entity} after certain circumstances have been met,
     * sometimes whether a targeted {@link Entity} has moved too far away,
     * moved to where there is an obstacle between the parent and the
     * targeted entity, etc.
     *
     * @return Whether the task will continue targeting the entity after
     *      certain conditions prevent a direct navigation path is not
     *      available
     */
    boolean hasLongMemory();

    /**
     * Sets whether the task will continue to navigate the parent
     * {@link Agent} to continue targeting an {@link Entity} after the
     * entity has moved to where a direct navigation path is no longer
     * available.
     *
     * @param longMemory Whether to continue targeting an entity
     * @return This goal, for chaining
     */
    AttackLivingGoal setLongMemory(boolean longMemory);

    interface Builder extends GoalBuilder<Creature, AttackLivingGoal, Builder> {

        /**
         * Sets the speed modifier at which the owning {@link Agent} will be
         * moving towards a targeted {@link Entity}.
         *
         * @param speed The speed modifier
         * @return This builder, for chaining
         */
        Builder speed(double speed);

        /**
         * Sets whether the task will force the owning {@link Agent} to
         * persist targeting an {@link Entity} after a direct path is
         * no longer available.
         *
         * @return This builder, for chaining
         */
        Builder longMemory();

    }
}
