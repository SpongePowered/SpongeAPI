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
package org.spongepowered.api.entity.ai.task.builtin.creature.tameable;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskBuilder;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.animal.Tameable;

/**
 * An {@link AITask} for {@link Tameable}s to sit down.
 */
public interface SitAITask extends AITask<Tameable> {

    /**
     * Creates a new {@link Builder} to build an {@link SitAITask}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Get the sitting state of the executor.
     *
     * @return True if the executor is sitting
     */
    boolean isSitting();

    /**
     * Set the sitting state of the executor.
     *
     * @param sitting True if the executor is sitting
     * @return The task for chaining
     */
    SitAITask setSitting(boolean sitting);

    /**
     * Get the maximum distance between the executor and its owner. Within that
     * distance, when the owner was attacked or attacked some {@link Living},
     * the executor will no longer sit and come to help the owner. Default to
     * {@code 144.0D}.
     *
     * @return The maximum distance
     */
    double getHelpingDistance();

    /**
     * Set the maximum distance between the executor and its owner. Within that
     * distance, when the owner was attacked or attacked some {@link Living},
     * the executor will no longer sit and come to help the owner. Default to
     * {@code 144.0D}.
     *
     * @param helpingDistance The maximum distance
     * @return The task for chaining
     */
    SitAITask setHelpingDistance(double helpingDistance);

    /**
     * Utility builder for {@link SitAITask}.
     */
    interface Builder extends AITaskBuilder<Tameable, SitAITask, Builder> {

        /**
         * Set the maximum distance between the executor and its owner. Within
         * that distance, when the owner was attacked or attacked some
         * {@link Living},  the executor will no longer sit and come to help the
         * owner. Default to {@code 144.0D}.
         *
         * @param helpingDistance The maximum distance
         * @return The builder for chaining
         */
        Builder helpingDistance(double helpingDistance);

    }

}
