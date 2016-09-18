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
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.Agent;

import java.util.function.Predicate;

/**
 * An {@link AITask} that the executor nods its head and destroys the grass
 * block, which make players think it may be eating grass.
 */
public interface EatGrassAITask extends AITask<Agent> {

    /**
     * Creates a new {@link Builder} to build an {@link EatGrassAITask}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Get the time that the executor take to eat grass in ticks. Default to 40
     * ticks.
     *
     * @return The time in ticks
     */
    int getGrassEatingTime();

    /**
     * Set the time that the executor take to eat grass in ticks. Default to 40
     * ticks.
     *
     * @param grassEatingTime The time in ticks
     * @return The task for chaining
     */
    EatGrassAITask setGrassEatingTime(int grassEatingTime);

    /**
     * Get the predicate which checks whether a block can be considered as
     * "grass".
     *
     * @return The predicate for grass
     */
    Predicate<BlockState> getGrassFilter();

    /**
     * Set the predicate which checks whether a block can be considered as
     * "grass".
     *
     * @param grassFilter The predicate for grass
     * @return The task for chaining
     */
    EatGrassAITask setGrassFilter(Predicate<BlockState> grassFilter);

    /**
     * Utility builder for {@link EatGrassAITask}.
     */
    interface Builder extends AITaskBuilder<Agent, EatGrassAITask, Builder> {

        /**
         * Set the time that the executor take to eat grass in ticks. Default to
         * 40 ticks.
         *
         * @param grassEatingTime The time in ticks
         * @return The builder for chaining
         */
        Builder grassEatingTime(int grassEatingTime);

        /**
         * Set the predicate which checks whether a block can be considered as
         * "grass".
         *
         * @param grassFilter The predicate for grass
         * @return The builder for chaining
         */
        Builder grassFilter(Predicate<BlockState> grassFilter);

    }

}
