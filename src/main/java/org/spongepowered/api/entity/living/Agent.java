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
package org.spongepowered.api.entity.living;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.entity.AgentData;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.ai.Goal;
import org.spongepowered.api.entity.ai.GoalType;
import org.spongepowered.api.entity.ai.task.AITask;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * An Agent represents a {@link Living} that has AI. In the future Sponge will
 * allow for custom AIs, but for now vanilla behavior can only be disabled.
 */
public interface Agent extends Living {

    /**
     * Gets the current target, usually according to the various
     * {@link AITask}s that are acting on this agent.
     *
     * @return The target entity, if available
     */
    Optional<Entity> getTarget();

    /**
     * Sets the current target, usually to bypass what the {@link AITask}s are
     * deciding to be the target.
     *
     * @param target The target entity, or null
     */
    void setTarget(@Nullable Entity target);

    /**
     * Gets a copy of the {@link AgentData} associated with this {@link Agent}.
     *
     * @return A copy of the agent data
     */
    default AgentData getAgentData() {
        return get(AgentData.class).get();
    }

    /**
     * Gets the {@link Value} for whether AI tasks are enabled or not.
     *
     * @return The value for the current "enabled" state of ai tasks
     */
    default Value<Boolean> aiEnabled() {
        return getValue(Keys.AI_ENABLED).get();
    }

    /**
     * Gets a {@link Goal} based on the {@link GoalType}.
     *
     * @param type GoalType to lookup
     * @param <T> Inferred agent type
     * @return The goal or {@link Optional#empty()} if not found.
     */
    <T extends Agent> Optional<Goal<T>> getGoal(GoalType type);
}
