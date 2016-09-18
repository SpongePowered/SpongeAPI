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
package org.spongepowered.api.entity.ai.task.builtin.creature.creeper;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.monster.Creeper;

/**
 * An {@link AITask} for {@link Creeper}s to move close to its attack target and
 * explode.
 */
public interface SwellAITask extends AITask<Creeper> {

    /**
     * Creates a new {@link Builder} to build an {@link SwellAITask}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Get the distance that the executor starts to swell. Default to
     * {@code 3.0D}.
     *
     * @return The distance
     */
    double getSwellingDistance();

    /**
     * Set the distance that the executor starts to swell. Default to
     * {@code 3.0D}.
     *
     * @param swellingDistance The distance
     * @return The task for chaining
     */
    SwellAITask setSwellingDistance(double swellingDistance);

    /**
     * Get the distance that the executor stops swelling. Default to
     * {@code 7.0D}.
     *
     * @return The distance
     */
    double getSafeDistance();

    /**
     * Set the distance that the executor stops swelling. Default to
     * {@code 7.0D}.
     *
     * @param safeDistance The distance
     * @return The task for chaining
     */
    SwellAITask setSafeDistance(double safeDistance);

    /**
     * Utility builder for {@link SwellAITask}.
     */
    interface Builder extends AITaskBuilder<Creeper, SwellAITask, Builder> {

        /**
         * Set the distance that the executor starts to swell. Default to
         * {@code 3.0D}.
         *
         * @param swellingDistance The distance
         * @return The builder for chaining
         */
        Builder swellingDistance(double swellingDistance);

        /**
         * Set the distance that the executor stops swelling. Default to
         * {@code 7.0D}.
         *
         * @param safeDistance The distance
         * @return The builder for chaining
         */
        Builder safeDistance(double safeDistance);

    }

}
