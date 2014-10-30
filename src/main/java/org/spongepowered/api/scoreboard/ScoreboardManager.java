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

/**
 * <p>This class manages all scoreboards on this server and can be used
 * to create diverse scoreboard components.</p>
 */
public interface ScoreboardManager {

    /**
     * <p>Returns a new {@link Scoreboard}
     * that can then be filled and assigned to a player.</p>
     *
     * @return a new {@link Scoreboard} instance
     */
    Scoreboard createScoreboard();

    /**
     * Creates a new {@link Objective}.
     *
     * @param name The new objective's name.</p>
     *             Must be unique, one word and not longer than 16 characters.
     * @param displayName The new objective's initial display name.</p>
     *                    <p>This is the name shown to the user,
     *                    it should not be longer than 16 characters.</p>
     * @return A new {@link Objective}
     */
    Objective createObjective(String name, String displayName);

    /**
     * Creates a new dummy score provider.</p>
     * It will be an instance of {@link SettableScoreProvider} so the values can be changed.
     *
     * @return A new dummy score provider.
     */
    SettableScoreProvider createDummyScoreProvider();

    /**
     * Creates a new {@link Team}.
     *
     * @param name The new team's name. Must be unique, one word</p>
     *             and not longer than 16 characters.
     * @param displayName The new team's display name.</p>
     *                    <p>This is the name shown to the user,
     *                    it should not be longer than 16 characters.</p>
     * @return A new {@link Team} instance
     */
    Team createTeam(String name, String displayName);

    /**
     * Returns a factory used for retrieving the default objective positions.
     *
     * @return the {@link ObjectivePositionFactory}
     */
    ObjectivePositionFactory getObjectivePositionFactory();
}
