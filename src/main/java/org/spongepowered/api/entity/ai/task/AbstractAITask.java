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
 * <p>It is required for anyone wanting to write their own logic that a Goal can
 * run to utilize this class. If you desire to use the builtin AI included with
 * Minecraft, use {@link GameRegistry#createBuilder(Class)} and pass a builder to
 * it instead.</p>
 *
 * <p>At the beginning of every "AI" tick, all {@link AITask}s that are added to
 * the parent {@link Goal} are iterated through. If an {@link AITask} is already
 * marked as "in use", that task's {@link #continueUpdating()} is checked for
 * {@code true}. If {@link #continueUpdating()} is {@code false}, {@link #reset()}
 * is invoked, and the {@link AITask} is "flagged" as unused for the parent {@link Goal}.
 * If {@link #continueUpdating()} is {@code true}, {@link #update()} is invoked
 * to perform any major logic.</p>
 *
 * <p>If an {@link AITask} is not currently flagged as "in use", then {@link #shouldUpdate()}
 * is invoked. If {@link #shouldUpdate()} is {@code true}, the {@link AITask} is
 * marked as "in use", and {@link #start()} is invoked. After {@link #start()}
 * is called, {@link #update()} will be invoked to be used for the first time
 * in this "AI tick".</p>
 *
 * <p>Regardless whether the {@link AITask} was "in use" or not, if the {@link AITask}
 * is now "in use", {@link #continueUpdating()} is called to verify the validity of the
 * task. If {@link #continueUpdating()} is {@code false}, {@link #reset()} is called
 * to clean up the {@link AITask}.</p>
 *
 * @param <O> The type of Agent
 */
public abstract class AbstractAITask<O extends Agent> implements AITask<O> {

    private final AITaskType type;

    /**
     * Creates a new {@link AbstractAITask} with the provided
     * {@link AITask}.
     *
     * @param type The type
     */
    public AbstractAITask(AITaskType type) {
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
     * Invoked when the task is "started". A "start" of a task occurs at the
     * "start" of the "AI" is "ticking". Depending on the case where
     * {@link #shouldUpdate()} returns {@code false}, an {@link AITask} is
     * <strong>NOT</strong> going to be called, so this method would not be
     * called at the "start" of the tick to "prepare" for {@link #update()}.
     */
    public abstract void start();

    /**
     * Determines whether this {@link AITask} should be considered for "ticking"
     * or {@link #start()}, {@link #update()}, and {@link #reset()} are called
     * for that "AI" tick.
     *
     * @return Whether this task should be marked for use in the current tick
     */
    public abstract boolean shouldUpdate();

    /**
     * Performs any customary logic for this "task" to modify the parent
     * {@link Agent} in any way, including navigation, health, potion effects,
     * etc. Only called when {@link #shouldUpdate()} returns {@code true},
     * and after {@link #start()} has completed. Likewise, if
     * {@link #continueUpdating()}
     */
    public abstract void update();

    /**
     * Called to verify that this {@link AITask} needs to {@link #update()}
     * in this tick. If this returns {@code false}, this {@link AITask}
     * is removed from use and {@link #reset()} is called.
     *
     * @return Whether this task should update this "tick" or not
     */
    public abstract boolean continueUpdating();

    /**
     * Performs any reset necessary for this task during the current tick.
     *
     * <p>Note that this may be called during any state during {@link #start()}
     * or {@link #update()} such that the task is removed from use for the
     * current "AI" tick.</p>
     */
    public abstract void reset();
}
