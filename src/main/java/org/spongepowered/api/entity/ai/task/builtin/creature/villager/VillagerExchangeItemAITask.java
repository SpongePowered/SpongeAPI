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
import org.spongepowered.api.entity.ai.task.builtin.WatchClosestAsInteractingAITask;
import org.spongepowered.api.entity.living.Villager;

/**
 * An {@link AITask} for {@link Villager}s to exchange items.
 */
public interface VillagerExchangeItemAITask extends WatchClosestAsInteractingAITask<Villager, VillagerExchangeItemAITask> {

    /**
     * Creates a new {@link Builder} to build an {@link VillagerExchangeItemAITask}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Get the time delay between the start of execution and the time the
     * villager throws item in ticks.
     *
     * @return The time delay
     */
    int getInteractionDelay();

    /**
     * Set the time delay between the start of execution and the time the
     * villager throws item in ticks.
     *
     * @param interactionDelay The time delay
     * @return The task for chaining
     */
    VillagerExchangeItemAITask setInteractionDelay(int interactionDelay);

    /**
     * Utility builder for {@link VillagerExchangeItemAITask}.
     */
    interface Builder extends WatchClosestAsInteractingAITask.Builder<Villager, VillagerExchangeItemAITask, Builder> {

        /**
         * Set the time delay between the start of execution and the time the
         * villager throws item in ticks.
         *
         * @param interactionDelay The time delay
         * @return The builder for chaining
         */
        Builder interactionDelay(int interactionDelay);

    }

}
