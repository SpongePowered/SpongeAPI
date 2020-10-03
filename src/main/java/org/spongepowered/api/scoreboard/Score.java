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
package org.spongepowered.api.scoreboard;

import net.kyori.adventure.text.Component;
import org.spongepowered.api.scoreboard.objective.Objective;

import java.util.Set;

/**
 * A score entry for one or more {@link Objective}s.
 */
public interface Score {

    /**
     * Gets the name of this score.
     *
     * @return The name of this score
     */
    Component getName();

    /**
     * Gets the current score value.
     *
     * @return The current score value
     */
    int getScore();

    /**
     * Sets the current score value.
     *
     * @param score The new score value
     */
    void setScore(int score);

    /**
     * Checks for whether the score is locked.
     *
     * @return True if the score is locked, false otherwise
     */
    boolean isLocked();

    /**
     * Sets this score as locked.
     *
     * @param locked True to lock this score
     */
    void setLocked(boolean locked);

    /**
     * Returns a {@link Set} of parent {@link Objective}s this {@link Score} is
     * registered to.
     *
     * @return A {@link Set} of parent {@link Objective} this {@link Score} is
     *         registered to
     */
    Set<Objective> getObjectives();

}
