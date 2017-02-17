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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.Agent;

public interface WatchClosestAITask extends AITask<Agent> {

    /**
     * Creates a new {@link Builder} to build a new
     * {@link WatchClosestAITask}.
     *
     * @return A new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the {@link Class} of the {@link Entity} type to "stare" or
     * "watch" when that type of entity is nearby.
     *
     * @return The class of entity to "watch"
     */
    Class<? extends Entity> getWatchedClass();

    /**
     * Sets the {@link Class} of the {@link Entity} type to "stare" or
     * "watch" when that type of entity is nearby.
     *
     * @param watchedClass The class of entity to "watch"
     * @return This task, for chaining
     */
    WatchClosestAITask setWatchedClass(Class<? extends Entity> watchedClass);

    /**
     * Gets the maximum distance to "watch" a targeted {@link Entity}.
     *
     * @return The distance to watch a targeted entity
     */
    float getMaxDistance();

    /**
     * Sets the maximum distance to "watch" a targeted {@link Entity}.
     *
     * @param maxDistance The maximum distance to watch an entity
     * @return This task, for chaining
     */
    WatchClosestAITask setMaxDistance(float maxDistance);

    /**
     * Gets the chance that an {@link Entity} will "watch" a targeted
     * {@link Entity}.
     *
     * @return The chance to watch
     */
    float getChance();

    /**
     * SEts the chance to "watch" a targeted {@link Entity}.
     *
     * @param chance The chance to "watch"
     * @return This task, for chaining
     */
    WatchClosestAITask setChance(float chance);

    interface Builder extends AITaskBuilder<Agent, WatchClosestAITask, Builder> {

        Builder watch(Class<? extends Entity> watchClass);

        Builder maxDistance(float maxDistance);

        Builder chance(float chance);

    }
}
