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
package org.spongepowered.api.entity.ai.task.builtin.creature.villager;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.Villager;

import java.util.Optional;

/**
 * An {@link AITask} for {@link Villager}s which they mate and spawn a baby
 * villager.
 */
public interface VillagerMateAITask extends AITask<Villager> {

    /**
     * Creates a new {@link Builder} to build an {@link Villager}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Get the chance of the task execution as a fraction of 1 divided by
     * chance. Default to 500.
     *
     * @return The chance
     */
    int getChance();

    /**
     * Set the chance of the task execution as a fraction of 1 divided by
     * chance. Default to 500.
     *
     * @param chance The chance
     * @return The task for chaining
     */
    VillagerMateAITask setChance(int chance);

    /**
     * Get the time it took for villagers to mate in ticks. Default to 300
     * ticks.
     *
     * @return The time for villagers to mate
     */
    int getTimeSpan();

    /**
     * Set the time it took for villagers to mate in ticks. Default to 300
     * ticks.
     *
     * @param timeSpan The time for villagers to mate
     * @return The task for chaining
     */
    VillagerMateAITask setTimeSpan(int timeSpan);

    /**
     * Utility builder for {@link VillagerMateAITask}.
     */
    interface Builder extends AITaskBuilder<Villager, VillagerMateAITask, Builder> {

        /**
         * Set the chance of the task execution as a fraction of 1 divided by
         * chance. Default to 500.
         *
         * @param chance The chance
         * @return The builder for chaining
         */
        Builder chance(int chance);

        /**
         * Set the time it took for villagers to mate in ticks. Default to 300
         * ticks.
         *
         * @param timeSpan The time for villagers to mate
         * @return The builder for chaining
         */
        Builder timeSpan(int timeSpan);

    }

}
