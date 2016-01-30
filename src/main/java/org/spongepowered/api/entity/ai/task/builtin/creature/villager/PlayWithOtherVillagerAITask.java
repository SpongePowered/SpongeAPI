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

import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.Villager;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * An {@link AITask} for {@link Villager}s to play with other villagers.
 */
public interface PlayWithOtherVillagerAITask extends AITask<Villager> {

    /**
     * Get the moving speed of the executor.
     *
     * @return The moving speed
     */
    double getSpeed();

    /**
     * Set the moving speed of the executor.
     *
     * @param speed The moving speed
     * @return The task for chaining
     */
    PlayWithOtherVillagerAITask setSpeed(double speed);

    /**
     * Get the chance of task execution. It is represented as a fraction of 1
     * divided by chance.
     *
     * @return The chance
     */
    int getChance();

    /**
     * Set the chance of task execution. It is represented as a fraction of 1
     * divided by chance.
     *
     * @param chance The chance
     * @return The task for chaining
     */
    PlayWithOtherVillagerAITask setChance(int chance);

    /**
     * Get the time duration of the playing task.
     *
     * @return The duration
     */
    int getDuration();

    /**
     * Set the time duration of the playing task.
     *
     * @param duration The duration
     * @return The task for chaining
     */
    PlayWithOtherVillagerAITask setDuration(int duration);

    /**
     * Get the current {@link Villager} the executor is playing with. Might be
     * null
     *
     * @return The playmate in optional, or empty
     */
    Optional<Villager> getPlayMate();

    /**
     * Utility builder for {@link PlayWithOtherVillagerAITask}.
     */
    interface Builder extends AITaskBuilder<Villager, PlayWithOtherVillagerAITask, Builder> {

        /**
         * Set the moving speed of the executor.
         *
         * @param speed The moving speed
         * @return The builder for chaining
         */
        Builder speed(double speed);

        /**
         * Set the chance of task execution. It is represented as a fraction of
         * 1 divided by chance.
         *
         * @param chance The chance
         * @return The builder for chaining
         */
        Builder chance(int chance);

        /**
         * Set the time duration of the playing task.
         *
         * @param duration The duration
         * @return The builder for chaining
         */
        Builder duration(int duration);

    }

}
