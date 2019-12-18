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

import java.util.List;

/**
 * Represents a set of goals that will be updated together by an {@link Agent}.
 *
 * <p>In Minecraft, most agents "live" by performing goals of their simulation (while sometimes
 * using specialized "targeting" goals for logic).
 *
 * @param <O> The type of agent
 */
public interface GoalExecutor<O extends Agent> {

    /**
     * The type of this goal.
     *
     * @return The type
     */
    GoalExecutorType getType();

    /**
     * The {@link Agent} that owns this goal.
     *
     * @return The owner
     */
    O getOwner();

    /**
     * Adds a new {@link Goal} to this goal.
     *
     * @param priority The priority this task should run at
     * @param goal The goal to run
     * @return This goal, for chaining
     */
    GoalExecutor<O> addGoal(int priority, Goal<? extends O> goal);

    /**
     * Removes a specific {@link Goal} from this goal.
     *
     * @param goal The goal to remove
     * @return This goal, for chaining
     */
    GoalExecutor<O> removeGoal(Goal<? extends O> goal);

    /**
     * Removes all {@link Goal}s whose {@link GoalType} matches
     * the provided type.
     *
     * @param type The type to remove
     * @return The goal, for chaining
     */
    GoalExecutor<O> removeGoals(GoalType type);

    /**
     * Gets all {@link Goal}s whose {@link GoalType} matches
     * the provided type.
     *
     * @param type The type to look for
     * @return All the tasks found
     */
    List<? super Goal<? extends O>> getTasksByType(GoalType type);

    /**
     * Gets all {@link Goal}s in this goal.
     *
     * @return The tasks
     */
    List<? super Goal<? extends O>> getTasks();

    /**
     * Clears all {@link Goal}s from this goal.
     */
    void clear();
}
