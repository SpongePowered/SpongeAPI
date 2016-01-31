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
package org.spongepowered.api.entity.ai.task.builtin.doorinteract;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.living.Agent;

/**
 * An {@link AITask} which the executor breaks a door that is in its path.
 */
public interface BreakDoorAITask extends DoorInteractAITask<BreakDoorAITask, Agent> {

    /**
     * Creates a new {@link Builder} to build an {@link BreakDoorAITask}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Get the time needed for the executor to break the door in ticks. Default
     * to 240 ticks.
     *
     * @return The time needed
     */
    int getBreakingTime();

    /**
     * Set the time needed for the executor to break the door in ticks. Default
     * to 240 ticks.
     *
     * @param breakingTime The time needed
     * @return The task for chaining
     */
    BreakDoorAITask setBreakingTime(int breakingTime);

    /**
     * Utility builder for {@link BreakDoorAITask}.
     */
    interface Builder extends DoorInteractAITask.Builder<Agent, BreakDoorAITask, Builder> {

        /**
         * Set the time needed for the executor to break the door in ticks.
         * Default to 240 ticks.
         *
         * @param breakingTime The time needed
         * @return The builder for chaining
         */
        Builder breakingTime(int breakingTime);

    }

}
