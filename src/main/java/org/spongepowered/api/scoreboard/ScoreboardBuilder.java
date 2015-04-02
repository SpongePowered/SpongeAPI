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

import org.spongepowered.api.scoreboard.objective.Objective;

import java.util.List;

/**
 * Represents a builder to create {@link Scoreboard} instances.
 */
public interface ScoreboardBuilder {

    /**
     * Sets the list of {@link Objective}s of the {@link Scoreboard}.
     *
     * <p>By default, this is the empty list.</p>
     *
     * @param objectives The list of {@link Objective}s to set
     * @return This builder
     */
    ScoreboardBuilder objectives(List<Objective> objectives);

    /**
     * Sets the list of {@link Team}s of the {@link Scoreboard}.
     *
     * <p>By default, this is the empty list.</p>
     *
     * @param teams The list of {@link Team}s to set
     * @return This builder
     */
    ScoreboardBuilder teams(List<Team> teams);

    /**
     * Resets all information regarding the {@link Scoreboard} to be created.
     *
     * @return This builder
     */
    Scoreboard reset();

    /**
     * Builds an instance of a {@link Scoreboard}.
     *
     * @return A new instance of a {@link Scoreboard}
     * @throws IllegalStateException if the {@link Scoreboard} is not complete
     */
    Scoreboard build() throws IllegalStateException;

}
