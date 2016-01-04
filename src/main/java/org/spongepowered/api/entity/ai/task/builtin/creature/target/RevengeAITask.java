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

import com.google.common.collect.ImmutableSet;
import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.living.Creature;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.monster.ZombiePigman;

import java.util.Set;

/**
 * An {@link AITask} which the executor will calls entities of the same type of
 * the executor to attack all entities the type of {@link Living} which attacked
 * the executor. (MCP name: EntityAIHurtByTarget)
 */
public interface RevengeAITask extends TargetAITask<RevengeAITask, Creature> {

    /**
     * Get whether the executor will call entities of the same type for help.
     * E.g. {@link ZombiePigman} anger.
     *
     * @return Whether the executor will call for help
     */
    boolean hasGroupAnger();

    /**
     * Set whether the executor will call entities of the same type for help.
     * E.g. {@link ZombiePigman} anger.
     *
     * @param groupAnger Whether the executor will call for help
     * @return The task for chaining
     */
    RevengeAITask setGroupAnger(boolean groupAnger);

    /**
     * Get the types of {@link Living} which may be a subclass of the executor
     * type but will not be called into the group anger.
     *
     * @return The excluded types
     */
    ImmutableSet<Class<? extends Living>> getNonHelpingTypes();

    /**
     * Set the types of {@link Living} which may be a subclass of the executor
     * type but will not be called into the group anger.
     *
     * @param nonHelpingTypes The excluded types
     * @return The task for chaining
     */
    RevengeAITask setNonHelpingTypes(Set<Class<? extends Living>> nonHelpingTypes);

    /**
     * Get the range that the executor calls for help. Default to {@code 10.0D}.
     *
     * @return The range of the call
     */
    double getGroupAngerRange();

    /**
     * Set the range that the executor calls for help. Default to {@code 10.0D}.
     *
     * @param groupAngerRange The range of the call
     * @return The task for chaining
     */
    RevengeAITask setGroupAngerRange(double groupAngerRange);

    /**
     * Utility builder for {@link RevengeAITask}.
     */
    interface Builder extends TargetAITask.Builder<Creature, RevengeAITask, Builder> {

        /**
         * Set whether the executor will call entities of the same type for
         * help. E.g. {@link ZombiePigman} anger.
         *
         * @param groupAnger Whether the executor will call for help
         * @return The builder for chaining
         */
        Builder groupAnger(boolean groupAnger);

        /**
         * Set the types of {@link Living} which may be a subclass of the
         * executor type but will not be called into the group anger.
         *
         * @param nonHelpingTypes The excluded types
         * @return The builder for chaining
         */
        Builder nonHelpingTypes(Set<Class<? extends Living>> nonHelpingTypes);

        /**
         * Set the range that the executor calls for help. Default to
         * {@code 10.0D}.
         *
         * @param groupAngerRange The range of the call
         * @return The builder for chaining
         */
        Builder groupAngerRange(double groupAngerRange);

    }

}
