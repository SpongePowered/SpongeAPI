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
package org.spongepowered.api.entity.ai.goal.builtin;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.ai.goal.Goal;
import org.spongepowered.api.entity.ai.goal.GoalBuilder;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.entity.living.Living;

public interface LookAtGoal extends Goal<Agent> {

    /**
     * Creates a new {@link Builder} to build a new
     * {@link LookAtGoal}.
     *
     * @return A new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the {@link Class} of the {@link Living} type to "stare" or
     * "watch" when that type of entity is nearby.
     *
     * @return The class of entity to "watch"
     */
    Class<? extends Living> getWatchedClass();

    /**
     * Sets the {@link Class} of the {@link Living} type to "stare" or
     * "watch" when that type of entity is nearby.
     *
     * @param watchedClass The class of entity to "watch"
     * @return This goal, for chaining
     */
    LookAtGoal setWatchedClass(Class<? extends Living> watchedClass);

    /**
     * Gets the maximum distance to "watch" a targeted {@link Living}.
     *
     * @return The distance to watch a targeted entity
     */
    float getMaxDistance();

    /**
     * Sets the maximum distance to "watch" a targeted {@link Living}.
     *
     * @param maxDistance The maximum distance to watch an entity
     * @return This goal, for chaining
     */
    LookAtGoal setMaxDistance(float maxDistance);

    /**
     * Gets the chance that an {@link Entity} will "watch" a targeted
     * {@link Living}.
     *
     * @return The chance to watch
     */
    float getChance();

    /**
     * SEts the chance to "watch" a targeted {@link Living}.
     *
     * @param chance The chance to "watch"
     * @return This goal, for chaining
     */
    LookAtGoal setChance(float chance);

    interface Builder extends GoalBuilder<Agent, LookAtGoal, Builder> {

        Builder watch(Class<? extends Living> watchClass);

        Builder maxDistance(float maxDistance);

        Builder chance(float chance);
    }
}
