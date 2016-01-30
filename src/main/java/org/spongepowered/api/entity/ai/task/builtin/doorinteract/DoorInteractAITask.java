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
package org.spongepowered.api.entity.ai.task.builtin.doorinteract;

import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.ai.task.builtin.GroundNavigationOnly;
import org.spongepowered.api.entity.living.Agent;

/**
 * An {@link AITask} which its executor finds a door with its pathfinder, goes
 * to that door, and interact with it.
 *
 * @param <A> The task type
 * @param <B> The executor type
 */
public interface DoorInteractAITask<A extends DoorInteractAITask<A, B>, B extends Agent> extends GroundNavigationOnly<B> {

    /**
     * Utility builder for {@link DoorInteractAITask}.
     *
     * @param <O> The executor type
     * @param <A> The task type
     * @param <B> The builder type
     */
    interface Builder<O extends Agent, A extends DoorInteractAITask<A, O>, B extends Builder<O, A, B>> extends GroundNavigationOnly.Builder<O, A, B> {

    }

}
