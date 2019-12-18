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
package org.spongepowered.api.entity.ai.goal.builtin.creature.target;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.Living;

import java.util.function.Predicate;

public interface FindNearestAttackableTargetGoal extends TargetGoal<FindNearestAttackableTargetGoal> {

    /**
     * Creates a new {@link Builder} for building a new {@link FindNearestAttackableTargetGoal}.
     *
     * @return A new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the {@link Class entity class} that can be targeted.
     *
     * @return The entity class that can be targeted
     */
    Class<? extends Living> getTargetClass();

    /**
     * Sets the {@link Class entity class} that can be targeted.
     *
     * @param targetClass The entity class to target
     * @return This task, for chaining
     */
    FindNearestAttackableTargetGoal setTargetClass(Class<? extends Living> targetClass);

    /**
     * Gets the chance that this task will go through and attempt to find a
     * new target.
     *
     * @return The chance that this task will go through and find a target
     */
    int getChance();

    /**
     * Sets the chance that this task will go through and attempt to find a
     * new target.
     *
     * @param chance The chance that this task will attemp to find a new target
     * @return This task, for chaining
     */
    FindNearestAttackableTargetGoal setChance(int chance);

    /**
     * Sets the {@link Predicate} filter to determine whether a {@link Living}
     * entity can be targeted.
     *
     * @param predicate The predicate
     * @return This task, for chaining
     */
    FindNearestAttackableTargetGoal filter(Predicate<Living> predicate);

    /**
     * Gets the {@link Predicate} filter to determine whether a {@link Living living entity}
     * can be targeted.
     *
     * @return The predicate to filter living entities for targeting
     */
    Predicate<Living> getFilter();

    interface Builder extends TargetGoal.Builder<FindNearestAttackableTargetGoal, Builder> {

        Builder target(Class<? extends Living> targetClass);

        Builder chance(int chance);

        Builder filter(Predicate<? extends Living> predicate);

    }
}
