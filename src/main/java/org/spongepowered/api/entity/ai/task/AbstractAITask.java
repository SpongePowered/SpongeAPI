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
 * Minecraft, use {@link GameRegistry#createBuilder(Class)} and pass a builder to
 * it instead.
 *
 * @param <O> The type of Agent
 */
public abstract class AbstractAITask<O extends Agent> implements AITask<O> {

    private final AITaskType type;

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

    public abstract void start();

    public abstract boolean shouldUpdate();

    public abstract void update();

    public abstract boolean continueUpdating();

    @Override
    public abstract void reset();
}
