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

import org.spongepowered.api.ai.goal.GoalCategoryFlag;
import org.spongepowered.api.ai.goal.GoalSelector;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.value.BoundedValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.ai.goal.GoalSelectorType;
import org.spongepowered.api.ai.goal.Goal;

import java.util.Optional;
import java.util.Set;

import javax.annotation.Nullable;

/**
 * An Agent represents a {@link Living} that has AI. In the future Sponge will
 * allow for custom AIs, but for now vanilla behavior can only be disabled.
 */
public interface Agent extends Living {

    /**
     * Gets the current target, usually according to the various
     * {@link Goal}s that are acting on this agent.
     *
     * @return The target entity, if available
     */
    Optional<Entity> getTarget();

    /**
     * Sets the current target, usually to bypass what the {@link Goal}s are
     * deciding to be the target.
     *
     * @param target The target entity, or null
     */
    void setTarget(@Nullable Entity target);

    /**
     * Gets the {@link Value.Mutable} for whether AI tasks are enabled or not.
     *
     * @return The value for the current "enabled" state of ai tasks
     */
    default Value.Mutable<Boolean> aiEnabled() {
        return getValue(Keys.AI_ENABLED).get().asMutable();
    }

    default BoundedValue.Mutable<Double> followRange() {
        return this.getValue(Keys.FOLLOW_RANGE).get().asMutable();
    }

    /**
     * Gets a {@link GoalSelector} based on the {@link GoalSelectorType}.
     *
     * @param type GoalSelectorType to lookup
     * @param <T> Inferred agent type
     * @return The goal or {@link Optional#empty()} if not found.
     */
    <T extends Agent> Optional<GoalSelector<T>> getGoal(GoalSelectorType type);

    Set<GoalCategoryFlag> getAvailableGoalCategoryFlags();
}
