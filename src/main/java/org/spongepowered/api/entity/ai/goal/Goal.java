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
package org.spongepowered.api.entity.ai.goal;

import org.spongepowered.api.entity.living.Agent;

import java.util.Optional;

/**
 * Represents an action performed by {@link Agent}s. If you desire to create your own, see
 * {@link AbstractGoal}.
 *
 * @param <O> The type of agent
 */
public interface Goal<O extends Agent> {

    /**
     * Gets the {@link GoalType}.
     *
     * @return The type
     */
    GoalType getType();

    /**
     * Gets the {@link GoalExecutor} that is updating this goal, if any.
     *
     * @return The goal or {@link Optional#empty()} if not present
     */
    Optional<GoalExecutor<O>> getExecutor();

    /**
     * Gets the {@link Agent} that owns this goal, if any.
     *
     * @return The owner or {@link Optional#empty()} if not present
     */
    default Optional<O> getOwner() {
        return getExecutor().map(GoalExecutor::getOwner);
    }

    /**
     * Tests if the provided {@link Goal} is allowed to be ran concurrently
     * with this goal.
     *
     * <p>This plays a role in determining if goals should be updated or not.
     * If this method is being called on this task, that means:</p>
     *
     * <ol>
     *   <li>This task has higher priority than the provided goal for our
     *   {@link Goal#getExecutor()}.</li>
     *   <li>Returning "false" will remove the provided goal from the list of
     *   updated goals, if not there already.</li>
     *   <li>Returning "true" will add the provided task to the list of updated
     *   goals, if not there already.</li>
     * </ol>
     *
     * @param other The other goal
     * @return True if it can be, false if not
     */
    boolean canRunConcurrentWith(Goal<O> other);

    /**
     * Returns if this goal can be interrupted. This determines if this goal
     * can be added to the list of updated goals as well as if it should
     * continue updating.
     *
     * <p>Thought should be made before blindly returning true or false here.
     * In Minecraft, all goals can be interrupted by higher priority goals
     * (goals added with lower numerical values in {@link GoalExecutor#addGoal(int, Goal)})
     * but a goal being created by a plugin might be deemed critical and as such should
     * return false.</p>
     *
     * <p>Due note that the meaning of "true" changes based on the state of the
     * {@link GoalExecutor}. To put it simply, this value can mean "Should I be added
     * as an updating goal or "Should I continue updating?". Regardless of the
     * question, the next step that happens is transferring from this method to
     * {@link Goal#canRunConcurrentWith(Goal)} in the next AI tick loop.</p>
     *
     * @return True if can be interrupted, false if not
     */
    boolean canBeInterrupted();
}
