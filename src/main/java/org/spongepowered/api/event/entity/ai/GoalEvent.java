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
package org.spongepowered.api.event.entity.ai;

import org.spongepowered.api.ai.goal.GoalSelector;
import org.spongepowered.api.ai.goal.Goal;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.impl.AbstractGoalEvent;
import org.spongepowered.api.util.annotation.eventgen.ImplementedBy;

@ImplementedBy(AbstractGoalEvent.class)
public interface GoalEvent extends Event, Cancellable {

    /**
     * Gets the {@link Agent}.
     *
     * @return The agent
     */
    Agent getAgent();

    /**
     * Gets the {@link GoalSelector} the {@link Goal} will be assigned to.
     *
     * @return The goal selector
     */
    GoalSelector getSelector();

    /**
     * Gets the {@link Goal} to be assigned.
     *
     * @return The goal
     */
    Goal<Agent> getGoal();

    /**
     * Gets the priority the goal will be assigned to. Lower numbers mean
     * higher priority.
     *
     * @return The priority
     */
    int getPriority();

    /**
     * Fired when a {@link Goal} is added to an {@link Agent}'s {@link GoalSelector}.
     */
    interface Add extends GoalEvent {
        /**
         * Gets the original priority that {@link GoalEvent#getGoal()} will
         * be assigned to. See {@link GoalEvent#getPriority()}.
         *
         * @return The original priority
         */
        int getOriginalPriority();

        /**
         * Sets the priority the goal will be assigned to. See
         * {@link GoalEvent#getPriority()}.
         *
         * @param priority The new priority
         */
        void setPriority(int priority);
    }

    /**
     * Fired when a {@link Goal} is removed from an {@link Agent}'s
     * {@link GoalSelector}.
     */
    interface Remove extends GoalEvent {

    }
}
