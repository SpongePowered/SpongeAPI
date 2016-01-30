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
package org.spongepowered.api.entity.ai.task.builtin;

import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.ai.task.builtin.creature.target.FindNearestAttackableTargetAITask;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.entity.living.Creature;
import org.spongepowered.api.entity.living.Living;

import java.util.function.Predicate;

/**
 * <p>An {@link AITask} which the executor finds the closest {@link Living} to
 * attack.</p>
 *
 * <p>It is not supposed to be used on a {@link Creature}. For creatures, please
 * use {@link FindNearestAttackableTargetAITask}.</p>
 *
 * @see FindNearestPlayerAITask
 * @see FindNearestAttackableTargetAITask
 */
public interface FindNearestEntityAITask extends AITask<Agent> {

    /**
     * Set the target entity type.
     *
     * @return The target entity type
     */
    Class<? extends Living> getTargetClass();

    /**
     * Get the target entity type.
     *
     * @param targetClass The target entity type
     * @return The task for chaining
     */
    FindNearestEntityAITask setTargetClass(Class<? extends Living> targetClass);

    /**
     * Get the predicate of living used by this task.
     *
     * @return The predicate of living
     */
    Predicate<? extends Living> getFilter();

    /**
     * Set the predicate of living used by this task.
     *
     * <p>Note that you still need to set the target class for the task in order
     * to make the correct entity types included.</p>
     *
     * @param filter The predicate of living
     * @return The task for chaining
     */
    FindNearestEntityAITask setFilter(Predicate<Living> filter);


    /**
     * Utility builder for {@link FindNearestEntityAITask}.
     */
    interface Builder extends AITaskBuilder<Agent, FindNearestEntityAITask, Builder> {

        /**
         * Get the target entity type.
         *
         * @param targetClass The target entity type
         * @return The builder for chaining
         */
        Builder targetClass(Class<? extends Living> targetClass);

        /**
         * Set the predicate of living used by this task.
         *
         * <p>Note that you still need to set the target class for the task in
         * order to make the correct entity types included.</p>
         *
         * @param filter The predicate of living
         * @return The builder for chaining
         */
        Builder filter(Predicate<Living> filter);

    }

}
