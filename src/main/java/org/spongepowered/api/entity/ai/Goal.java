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
package org.spongepowered.api.entity.ai;

import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.AITaskType;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.entity.living.monster.Monster;

import java.util.List;

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
public interface Goal<O extends Agent> {

    /**
     * The type of this goal.
     *
     * @return The type
     */
    GoalType getType();

    /**
     * The {@link Agent} that owns this goal.
     *
     * @return The owner
     */
    O getOwner();

    /**
     * Adds a new {@link AITask} to this goal.
     *
     * @param priority The priority this task should run at
     * @param task The task to run
     * @return This goal, for chaining
     */
    Goal<O> addTask(int priority, AITask<? extends O> task);

    /**
     * Removes a specific {@link AITask} from this goal.
     *
     * @param task The task to remove
     * @return This goal, for chaining
     */
    Goal<O> removeTask(AITask<? extends O> task);

    /**
     * Removes all {@link AITask}s whose {@link AITaskType} matches
     * the provided type.
     *
     * @param type The type to remove
     * @return The goal, for chaining
     */
    Goal<O> removeTasks(AITaskType type);

    /**
     * Gets all {@link AITask}s whose {@link AITaskType} matches
     * the provided type.
     *
     * @param type The type to look for
     * @return All the tasks found
     */
    List<? super AITask<? extends O>> getTasksByType(AITaskType type);

    /**
     * Gets all {@link AITask}s in this goal.
     *
     * @return The tasks
     */
    List<? super AITask<? extends O>> getTasks();

    /**
     * Clears all {@link AITask}s from this goal.
     */
    void clear();
}
