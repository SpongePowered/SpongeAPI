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
package org.spongepowered.api.entity.ai.task;

import org.spongepowered.api.entity.ai.Goal;
import org.spongepowered.api.entity.living.Agent;

import java.util.Optional;

/**
 * Represents a task performed by {@link Agent}s. If you desire to create your own, see
 * {@link AbstractAITask}.
 *
 * @param <O> The type of agent
 */
public interface AITask<O extends Agent> {

    /**
     * Gets the {@link AITaskType} of this task.
     *
     * @return The type
     */
    AITaskType getType();

    /**
     * Gets the {@link Goal} that is updating this task, if any.
     *
     * @return The goal or {@link Optional#empty()} if not present
     */
    Optional<Goal<O>> getGoal();

    /**
     * Gets the {@link Agent} that owns this task, if any.
     *
     * @return The owner or {@link Optional#empty()} if not present
     */
    default Optional<O> getOwner() {
        return getGoal().map(Goal::getOwner);
    }

    /**
     * Tests if the provided {@link AITask} is allowed to be ran concurrently
     * with this task.
     *
     * <p>This plays a role in determining if tasks should be updated or not.
     * If this method
     * is being called on this task, that means:</p>
     *
     * <ol>
     *   <li>This task has higher priority than the provided task for our
     *   {@link AITask#getGoal()}.</li>
     *   <li>Returning "false" will remove the provided task from the list of
     *   updated tasks, if not
     *   there already.</li>
     *   <li>Returning "true" will add the provided task to the list of updated
     *   tasks, if not there
     *   already.</li>
     * </ol>
     *
     * @param other The other task
     * @return True if it can be, false if not
     */
    boolean canRunConcurrentWith(AITask<O> other);

    /**
     * Returns if this task can be interrupted. This determines if this task
     * can be added to the list of updated tasks as well as if it should
     * continue updating.
     *
     * <p>Thought should be made before blindly returning true or false here.
     * In Minecraft, all tasks can be interrupted by higher priority tasks
     * (tasks added with lower numerical values in
     * {@link Goal#addTask(int, AITask)}) but a task being created by a plugin
     * might be deemed critical and as such should return false.</p>
     *
     * <p>Due note that the meaning of "true" changes based on the state of the
     * {@link Goal}.  To put it simply, this value can mean "Should I be added
     * as an updating task or "Should I continue updating?". Regardless of the
     * question, the next step that happens is transferring from this method to
     * {@link AITask#canRunConcurrentWith(AITask)} in the next AI tick loop.</p>
     *
     * @return True if can be interrupted, false if not
     */
    boolean canBeInterrupted();
}
