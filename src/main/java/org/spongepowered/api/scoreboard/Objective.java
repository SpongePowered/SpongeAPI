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

import java.util.Collection;

/**
 * This interface represents a single scoreboard objective.
 */
public interface Objective {

    /**
     * Gets the name of this objective.</p>
     * The name must be one word, and not longer than 16 characters.
     *
     * @return The objective's name
     */
    String getName();

    /**
     * Sets the name of this objective.</p>
     * The name must be one word, and not longer than 16 characters.</p>
     * Note that calling this method will recreate the objective on the client.
     *
     * @param name The objective's name
     */
    void setName(String name);

    /**
     * Gets the objective's position.
     *
     * @return The objective's position.
     */
    ObjectivePosition getPosition();

    /**
     * Gets the display name of this objective.</p>
     * This is what's shown to the player.
     *
     * @return The objective's display name
     */
    String getDisplayName();

    /**
     * Sets the display name of this objective, maximum 16 characters.
     *
     * @param displayName The objective's new display name
     */
    void setDisplayName(String displayName);

    /**
     * Gets the current score provider.</p>
     * It provides the player's score to this objective.
     *
     * @return The objective's score provider
     */
    ScoreProvider getScoreProvider();

    /**
     * Refreshes the objective's values from the score provider.
     */
    void refresh();

    /**
     * Adds a new string scoreboard entry to this objective.
     *
     * @param entry The entry's name.
     */
    void addStringEntry(String entry);

    /**
     * Checks if this objective contains the specified scoreboard entry.
     *
     * @param entry The entry's name.
     * @return True if this objective contains the entry, false otherwise.
     */
    boolean hasStringEntry(String entry);

    /**
     * Removes the specified scoreboard entry from this objective.
     *
     * @param entry The entry's name.
     */
    void removeStringEntry(String entry);

    /**
     * Gets this objective's string entries.
     *
     * @return A collection containing all string entries in this objective.
     */
    Collection<String> getStringEntries();

    /**
     * Adds a new team scoreboard entry to this objective.
     *
     * @param entry The team.
     */
    void addTeamEntry(Team entry);

    /**
     * Checks if this objective contains the specified scoreboard entry.
     *
     * @param entry The team.
     * @return True if this objective contains the entry, false otherwise.
     */
    boolean hasTeamEntry(Team entry);

    /**
     * Removes the specified scoreboard entry from this objective.
     *
     * @param entry The team.
     */
    void removeTeamEntry(Team entry);

    /**
     * Gets this objective's team entries.
     *
     * @return A collection containing all team entries in this objective.
     */
    Collection<Team> getTeamEntries();

    /**
     * Gets the objective's scoreboard entry count.
     *
     * @return The scoreboard entry count.
     */
    int getEntryCount();

    /**
     * Removes all entries from this objective.
     */
    void clearEntries();
}
