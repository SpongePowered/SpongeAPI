/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

/**
 * Represents an AI goal entry for a {@link GoalBasedAIHandler} specifying an
 * goal and a priority for the goal.
 */
public final class AIGoalEntry {

    private final AIGoal aiGoal;
    private final int priority;

    /**
     * Creates a new AI goal entry for the given goal with the given priority.
     *
     * @param aiGoal The goal for this goal entry
     * @param priority The priority for the goal
     */
    public AIGoalEntry(final AIGoal aiGoal, final int priority) {
        super();
        this.aiGoal = aiGoal;
        this.priority = priority;
    }

    /**
     * Gets the AI goal associated with this goal entry.
     *
     * @return The AI goal associated with this goal entry
     */
    public AIGoal getAiGoal() {
        return aiGoal;
    }

    /**
     * Gets the priority associated with this goal entry.
     * <p>
     * High values means low priority.
     * </p>
     *
     * @return The priority associated with this goal entry
     */
    public int getPriority() {
        return priority;
    }
}
