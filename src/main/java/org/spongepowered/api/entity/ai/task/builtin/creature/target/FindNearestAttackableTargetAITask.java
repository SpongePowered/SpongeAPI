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
package org.spongepowered.api.entity.ai.task.builtin.creature.target;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.living.Creature;
import org.spongepowered.api.entity.living.Living;

import java.util.function.Predicate;

/**
 * An {@link AITask} which the executor finds entities of a type and tries to
 * attack the closest one.
 *
 * @param <A> The task type
 * @param <B> The executor type
 */
public interface FindNearestAttackableTargetAITask<A extends FindNearestAttackableTargetAITask<A, B>, B extends Creature> extends TargetAITask<A, B> {

    /**
     * Creates a new {@link Builder} to build an {@link FindNearestAttackableTargetAITask}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Get the target type of the task.
     *
     * @return The target type
     */
    Class<? extends Living> getTargetClass();

    /**
     * Set the target type of the task.
     *
     * @param targetClass The target type
     * @return The task for chaining
     */
    A setTargetClass(Class<? extends Living> targetClass);

    /**
     * Get the chance of task execution as a fraction of 1 divided by chance.
     * If the chance is non-positive, then the task always executes.
     *
     * @return The chance
     */
    int getChance();

    /**
     * Set the chance of task execution as a fraction of 1 divided by chance.
     * If the chance is non-positive, then the task always executes.
     *
     * @param chance The chance
     * @return The task for chaining
     */
    A setChance(int chance);

    /**
     * Get the filter of targets of the task.
     *
     * @return The filter
     */
    Predicate<Living> getFilter();

    /**
     * Set the filter of targets of the task.
     *
     * @param filter The filter
     * @return The task for chaining
     */
    A setFilter(Predicate<Living> filter);

    /**
     * Utility builder for {@link FindNearestAttackableTargetAITask}.
     *
     * @param <O> The executor type
     * @param <A> The task type
     * @param <B> The builder type
     */
    interface Builder<O extends Creature, A extends FindNearestAttackableTargetAITask<A, O>, B extends Builder<O, A, B>>
            extends TargetAITask.Builder<O, A, B> {

        /**
         * Set the target type of the task.
         *
         * @param targetClass The target type
         * @return The builder for chaining
         */
        B targetClass(Class<? extends Living> targetClass);

        /**
         * Set the chance of task execution as a fraction of 1 divided by
         * chance. If the chance is non-positive, then the task always executes.
         *
         * @param chance The chance
         * @return The builder for chaining
         */
        B chance(int chance);

        /**
         * Set the filter of targets of the task.
         *
         * @param filter The filter
         * @return The builder for chaining
         */
        B filter(Predicate<? extends Living> filter);

    }

}
