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
package org.spongepowered.api.entity.ai.task.builtin.creature.irongolem;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.Villager;
import org.spongepowered.api.entity.living.golem.IronGolem;

import java.util.Optional;

/**
 * An {@link AITask} for {@link IronGolem}s to look at a {@link Villager} and give the
 * villager a flower.
 */
public interface LookAtVillagerAITask extends AITask<IronGolem> {

    /**
     * Creates a new {@link Builder} to build an {@link LookAtVillagerAITask}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Get the chance of the task execution as a fraction of 1 over chance.
     * Default to 5000.
     *
     * @return The chance
     */
    int getChance();

    /**
     * Set the chance of the task execution as a fraction of 1 over chance.
     * Default to 5000.
     *
     * @param chance The chance
     * @return The task for chaining
     */
    LookAtVillagerAITask setChance(int chance);

    /**
     * Get the time that the executor will look at the villager in ticks.
     * Default to 400 ticks.
     *
     * @return The time
     */
    int getLookTime();

    /**
     * Set the time that the executor will look at the villager in ticks.
     * Default to 400 ticks.
     *
     * @param lookTime The time
     * @return The task for chaining
     */
    LookAtVillagerAITask setLookTime(int lookTime);

    /**
     * Get the distance of the executor finding a villager. Default to
     * {@code 6.0D}.
     *
     * @return The distance
     */
    double getVillagerFindingRange();

    /**
     * Set the distance of the executor finding a villager. Default to
     * {@code 6.0D}.
     *
     * @param villagerFindingRange The distance
     * @return The task for chaining
     */
    LookAtVillagerAITask setVillagerFindingRange(double villagerFindingRange);

    /**
     * Get the villager that the executor looks at. May or may not exist.
     *
     * @return The villager in optional, or empty
     */
    Optional<Villager> getVillagerLookedAt();

    /**
     * Utility builder for {@link LookAtVillagerAITask}.
     */
    interface Builder extends AITaskBuilder<IronGolem, LookAtVillagerAITask, Builder> {

        /**
         * Set the chance of the task execution as a fraction of 1 over chance.
         * Default to 5000.
         *
         * @param chance The chance
         * @return The builder for chaining
         */
        Builder chance(int chance);

        /**
         * Set the time that the executor will look at the villager in ticks.
         * Default to 400 ticks.
         *
         * @param lookTime The time
         * @return The builder for chaining
         */
        Builder lookTime(int lookTime);

        /**
         * Set the distance of the executor finding a villager. Default to
         * {@code 6.0D}.
         *
         * @param villagerFindingRange The distance
         * @return The builder for chaining
         */
        Builder villagerFindingRange(double villagerFindingRange);

    }

}
