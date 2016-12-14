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

import com.google.common.base.Preconditions;
import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.entity.ai.Goal;
import org.spongepowered.api.entity.living.Agent;

import java.util.Optional;

/**
 * An abstract implementation of a {@link AITask} that a {@link Goal} can run.
 *
 * It is required for anyone wanting to write their own logic that a Goal can
 * run to utilize this class. If you desire to use the builtin AI included with
 * Minecraft, use {@link GameRegistry#createBuilder(Class)} and pass a builder
 * to it instead.
 *
 * @param <O> The type of Agent
 */
public abstract class AbstractAITask<O extends Agent> implements AITask<O> {

    private final AITaskType type;

    /**
     * Constructs a new instance of a custom AI task. This constructor is
     * designed to be used by subclasses.
     *
     * <p>Note: The type passed in as the argument should be a custom {@link
     * AITaskType} instance representing this type of task.</p>
     *
     * @param type The type of this task
     */
    protected AbstractAITask(AITaskType type) {
        Preconditions.checkNotNull(type);
        this.type = type;
    }

    @Override
    public final AITaskType getType() {
        return this.type;
    }

    @Override
    public final Optional<Goal<O>> getGoal() {
        // Assigned by implementation
        return Optional.empty();
    }

    /**
     * Called immediately after a call to {@link #shouldUpdate()} returns
     * {@code true}. This allows the task to set up for the current state
     * of the task owner.
     */
    public abstract void start();

    /**
     * Called every time when this AI task gets ticked and the task is not
     * currently updating. This tells whether the task should start execute.
     *
     * @return True if this task should start to update, false otherwise
     */
    public abstract boolean shouldUpdate();

    /**
     * Called every time when {@link #continueUpdating()} returns {@code true}.
     * This controls the owner to execute this AI task.
     */
    public abstract void update();

    /**
     * Called every time when this AI task gets ticked and the task is updating.
     * This tells whether the task should start execute.
     *
     * @return True if this task should continue to update, false otherwise
     */
    public abstract boolean continueUpdating();

    /**
     * Called immediately after {@link #continueUpdating()} returns {@code
     * false}. This allows the task to reset to a clean beginning state.
     */
    public abstract void reset();

}
