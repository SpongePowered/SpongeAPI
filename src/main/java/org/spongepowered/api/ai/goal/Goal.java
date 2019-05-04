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
package org.spongepowered.api.ai.goal;

import org.spongepowered.api.entity.living.Agent;

import java.util.Optional;
import java.util.Set;

/**
 * Represents a goal performed by {@link Agent}s.
 *
 * @param <O> The type of agent
 */
public interface Goal<O extends Agent> {

    /**
     * Gets the {@link GoalType} of this goal.
     *
     * @return The type
     */
    GoalType getType();

    /**
     * Gets the {@link GoalSelector} that is updating this goal, if any.
     *
     * @return The goal or {@link Optional#empty()} if not present
     */
    Optional<GoalSelector<O>> getSelector();

    /**
     * Gets the {@link Agent} that owns this goal, if any.
     *
     * @return The owner or {@link Optional#empty()} if not present
     */
    default Optional<O> getOwner() {
        return this.getSelector().map(GoalSelector::getOwner);
    }

    /**
     * Returns if this goal can be interrupted. This determines if this goal
     * can be added to the list of updated tasks as well as if it should
     * continue updating.
     *
     * <p>Thought should be made before blindly returning true or false here.
     * In Minecraft, all tasks can be interrupted by higher priority tasks
     * (tasks added with lower numerical values in
     * {@link GoalSelector#addTask(int, Goal)}) but a goal being created by a plugin
     * might be deemed critical and as such should return false.</p>
     *
     * <p>Due note that the meaning of "true" changes based on the state of the
     * {@link GoalSelector}.  To put it simply, this value can mean "Should I be added
     * as an updating goal or "Should I continue updating?".</p>
     *
     * @return True if can be interrupted, false if not
     */
    boolean canBeInterrupted();

    Set<GoalCategoryFlag> getCategoryFlags();
}
