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
package org.spongepowered.api.advancement.criteria;

import java.time.Instant;
import java.util.Optional;

/**
 * Represents the progress of a {@link ScoreAdvancementCriterion}.
 */
public interface ScoreCriterionProgress extends CriterionProgress {

    @Override
    ScoreAdvancementCriterion getCriterion();

    /**
     * Gets the goal value.
     *
     * @return The goal value
     */
    default int getGoal() {
        return getCriterion().getGoal();
    }

    /**
     * Gets the score value.
     *
     * @return The score value
     */
    int getScore();

    /**
     * Adds the target score value, the score cannot exceed
     * the goal value ({@link #getGoal()}) or be under zero.
     * The achieved time will be returned if the goal is met.
     *
     * @param score The score to set
     * @return The achieving time, if achieved
     */
    Optional<Instant> set(int score);

    /**
     * Adds the target score value, the score cannot exceed
     * the goal value ({@link #getGoal()}). The achieved time
     * will be returned if the goal is met.
     *
     * @param score The score to add
     * @return The achieving time, if achieved
     */
    Optional<Instant> add(int score);

    /**
     * Removes the target score value, the score cannot go under zero.
     * The achieved time will be returned if the goal is met before.
     *
     * @param score The score to remove
     * @return The old achieving time, if achieved before
     */
    Optional<Instant> remove(int score);

}
