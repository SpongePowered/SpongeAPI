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
import org.spongepowered.api.entity.ai.task.builtin.GroundNavigationOnly;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.entity.living.Villager;

/**
 * An {@link AITask} for villagers to trade with {@link Humanoid}s.
 * (MCP name: EntityAITradePlayer)
 */
public interface TradePlayerAITask extends GroundNavigationOnly<Villager> {

    /**
     * Get the maximum distance between the executor and the {@link Humanoid}
     * it trade with while trading. Default to {@code 16.0D}.
     *
     * @return The maximum distance
     */
    double getMaxDistance();

    /**
     * Set the maximum distance between the executor and the {@link Humanoid}
     * it trade with while trading. Default to {@code 16.0D}.
     *
     * @param maxDistance The maximum distance
     * @return The task for chaining
     */
    TradePlayerAITask setMaxDistance(double maxDistance);

    /**
     * Utility builder for {@link TradePlayerAITask}.
     */
    interface Builder extends GroundNavigationOnly.Builder<Villager, TradePlayerAITask, Builder> {

        /**
         * Set the maximum distance between the executor and the {@link Humanoid}
         * it trade with while trading. Default to {@code 16.0D}.
         *
         * @param maxDistance The maximum distance
         * @return The builder for chaining
         */
        Builder maxDistance(double maxDistance);

    }

}
