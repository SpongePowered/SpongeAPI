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
package org.spongepowered.api.scoreboard;

import javax.annotation.Nullable;

/**
 * <p>This interface defines an entire scoreboard,
 * that is a collection of objectives at different positions.</p>
 */
public interface Scoreboard extends Iterable<Objective> {

    /**
     * Adds a new objective to this scoreboard.
     *
     * @param objective The objective to add.
     * @param position The position to add this objective to.
     * @return True if the objective was added successfully, false otherwise.
     */
    boolean addObjective(Objective objective, ObjectivePosition position);

    /**
     * Gets if this scoreboard already contains the specified objective.
     *
     * @param objective The objective to check.
     * @return True if this objective is already present, false otherwise.
     */
    boolean hasObjective(Objective objective);

    /**
     * Gets if there is an objective present at the specified position.
     *
     * @param position The position to check.
     * @return True if there is a objective at the specified position, false otherwise.
     */
    boolean hasObjective(ObjectivePosition position);

    /**
     * <p>Gets the objective at the specified position,
     * or null if there isn't any objective at the position.</p>
     *
     * @param position The position to get the objective from.
     * @return The objective at the specified position.
     */
    @Nullable
    Objective getObjective(ObjectivePosition position);

    /**
     * Removes the specified objective from this scoreboard.
     *
     * @param objective The objective to remove.
     */
    void removeObjective(Objective objective);

    /**
     * Removes the objective currently at the specified position.
     *
     * @param position The position to remove the objective from.
     */
    void removeObjective(ObjectivePosition position);

    /**
     * Gets the count of objectives this scoreboard currently holds.
     *
     * @return The count of objectives.
     */
    int getObjectiveCount();

    /**
     * Removes all objectives from this scoreboard.
     */
    void clearObjectives();
}
