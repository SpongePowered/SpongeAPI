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
package org.spongepowered.api.entity.ai.task.builtin.creature.animal;

import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.animal.Animal;

import java.util.Optional;

/**
 * An {@link AITask} for {@link Animal}s to mate and spawn a child animal.
 * (MCP name: EntityAIMate)
 */
public interface MateAITask extends AITask<Animal> {

    /**
     * Get the moving speed of the executor.
     *
     * @return The moving speed
     */
    double getSpeed();

    /**
     * Get the moving speed of the executor.
     *
     * @param speed The moving speed
     * @return The task for chaining
     */
    MateAITask setSpeed(double speed);

    /**
     * Get the minimum experience loot from the spawning of baby. Default to 1.
     *
     * @return The minimum experience loot
     */
    int getMinXpLoot();

    /**
     * Set the minimum experience loot from the spawning of baby. Default to 1.
     *
     * @param minXpLoot The minimum experience loot
     * @return The task for chaining
     */
    MateAITask setMinXpLoot(int minXpLoot);

    /**
     * Get the maximum experience loot from the spawning of baby. Default to 8.
     *
     * @return The maximum experience loot
     */
    int getMaxXpLoot();

    /**
     * Set the maximum experience loot from the spawning of baby. Default to 8.
     *
     * @param maxXpLoot The minimum experience loot
     * @return The task for chaining
     */
    MateAITask setMaxXpLoot(int maxXpLoot);

    /**
     * Get the time delay to spawn a baby animal in ticks. Default to 60 ticks.
     *
     * @return The time delay in ticks
     */
    int getBabySpawnTime();

    /**
     * Set the time delay to spawn a baby animal in ticks. Default to 60 ticks.
     *
     * @param babySpawnTime The time delay in ticks
     * @return The task for chaining
     */
    MateAITask setBabySpawnTime(int babySpawnTime);

    /**
     * Get the maximum distance between the executor and the mate allowed when
     * spawning the child animal. Once exceeds, the child animal will not spawn.
     * Default to {@code 3.0D}.
     *
     * @return The maximum distance
     */
    double getBabySpawnMaxDistance();

    /**
     * Set the maximum distance between the executor and the mate allowed when
     * spawning the child animal. Once exceeds, the child animal will not spawn.
     * Default to {@code 3.0D}.
     *
     * @param babySpawnMaxDistance The maximum distance
     * @return The task for chaining
     */
    MateAITask setBabySpawnMaxDistance(double babySpawnMaxDistance);

    /**
     * Get the range of the executor finding a mate. Default to {@code 4.0D}.
     *
     * @return The range
     */
    double getMateFindingRange();

    /**
     * Set the range of the executor finding a mate. Default to {@code 4.0D}.
     *
     * @param mateFindingRange The range
     * @return The task for chaining
     */
    MateAITask setMateFindingRange(double mateFindingRange);

    /**
     * Get the mate of the executor. May or may not exist.
     *
     * @return The mate in optional, or empty
     */
    Optional<Animal> getMate();

    /**
     * Utility builder for {@link MateAITask}.
     */
    interface Builder extends AITaskBuilder<Animal, MateAITask, Builder> {

        /**
         * Get the moving speed of the executor.
         *
         * @param speed The moving speed
         * @return The builder for chaining
         */
        Builder speed(double speed);

        /**
         * Set the minimum experience loot from the spawning of baby. Default to
         * 1.
         *
         * @param minXpLoot The minimum experience loot
         * @return The builder for chaining
         */
        Builder minXpLoot(int minXpLoot);

        /**
         * Set the maximum experience loot from the spawning of baby. Default to
         * 8.
         *
         * @param maxXpLoot The minimum experience loot
         * @return The builder for chaining
         */
        Builder maxXpLoot(int maxXpLoot);

        /**
         * Set the time delay to spawn a baby animal in ticks. Default to 60
         * ticks.
         *
         * @param babySpawnTime The time delay in ticks
         * @return The builder for chaining
         */
        Builder babySpawnTime(int babySpawnTime);

        /**
         * Set the maximum distance between the executor and the mate allowed
         * when spawning the child animal. Once exceeds, the child animal will
         * not spawn. Default to {@code 3.0D}.
         *
         * @param babySpawnMaxDistance The maximum distance
         * @return The builder for chaining
         */
        Builder babySpawnMaxDistance(double babySpawnMaxDistance);

        /**
         * Set the range of the executor finding a mate. Default to
         * {@code 4.0D}.
         *
         * @param mateFindingRange The range
         * @return The builder for chaining
         */
        Builder mateFindingRange(double mateFindingRange);

    }

}
