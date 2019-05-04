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
import org.spongepowered.api.entity.living.monster.Monster;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Represents a set of tasks that will be updated together by an {@link Agent}.
 *
 * <p>In Minecraft, most agents have just one goal which is living or
 * simulating, or whichever term you want to call it. Other agents, such as
 * {@link Monster}s, use a "target" goal which serves to seek out potential
 * victims and execute a series of attack tasks.</p>
 *
 * @param <O> The type of agent
 */
public interface GoalSelector<O extends Agent> {

    /**
     * The type of this goal.
     *
     * @return The type
     */
    GoalSelectorType getType();

    /**
     * The {@link Agent} that owns this goal.
     *
     * @return The owner
     */
    O getOwner();

    /**
     * Adds a new {@link org.spongepowered.api.ai.goal.Goal} to this {@link GoalSelector}.
     *
     * @param priority The priority this goal should run at
     * @param task The goal to run
     * @return This goal, for chaining
     */
    GoalSelector addTask(int priority, org.spongepowered.api.ai.goal.Goal<O> task);

    /**
     * Removes a specific {@link org.spongepowered.api.ai.goal.Goal} from this {@link GoalSelector}.
     *
     * @param task The goal to remove
     * @return An optional containing the goal entry removed or {@link Optional#empty()} if none found
     */
    Optional<GoalEntry<O>> removeTask(org.spongepowered.api.ai.goal.Goal<O> task);

    /**
     * Removes all {@link org.spongepowered.api.ai.goal.Goal}s whose {@link GoalType} matches
     * the provided type in this {@link GoalSelector}.
     *
     * @param type The type to remove
     * @return The removed goal entries as a {@link Collection}
     */
    Collection<GoalEntry<O>> removeTasks(GoalType type);

    /**
     * Gets all {@link org.spongepowered.api.ai.goal.Goal}s whose {@link GoalType} matches
     * the provided type in this {@link GoalSelector}.
     *
     * @param type The type to look for
     * @return The tasks
     */
    List<GoalEntry<O>> getTasksByType(GoalType type);

    /**
     * Gets all {@link org.spongepowered.api.ai.goal.Goal}s in this {@link GoalSelector}.
     *
     * @return The tasks
     */
    List<GoalEntry<O>> getTasks();

    /**
     * Clears all {@link org.spongepowered.api.ai.goal.Goal}s from this goal.
     */
    void clear();

    interface GoalEntry <O extends Agent> extends Comparable<GoalEntry<O>> {

        GoalSelector getSelector();

        Goal<O> getGoal();

        int getPriority();
    }
}
