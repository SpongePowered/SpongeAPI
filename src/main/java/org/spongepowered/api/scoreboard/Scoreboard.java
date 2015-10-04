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

import java.util.Optional;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.scoreboard.critieria.Criterion;
import org.spongepowered.api.scoreboard.displayslot.DisplaySlot;
import org.spongepowered.api.scoreboard.objective.Objective;
import org.spongepowered.api.text.Text;

import java.util.Set;

import javax.annotation.Nullable;

/**
 * Represents a scoreboard, which contains {@link Team}s and {@link Objective}s.
 * The server has a default scoreboard, but each {@link Player}
 * can have their own scoreboard.
 *
 * @see <a href="http://minecraft.gamepedia.com/Scoreboard">Scoreboards on the Minecraft Wiki</a>
 */
public interface Scoreboard {

    /**
     * Gets an {@link Objective} on this scoreboard by name, if it exists.
     *
     * @param name Name of the {@link Objective}
     * @return The {@link Objective}, if it exists
     */
    Optional<Objective> getObjective(String name);

    /**
     * Gets the {@link Objective} currently displayed in a {@link DisplaySlot} on this
     * scoreboard, if one is present.
     *
     * @param slot The {@link DisplaySlot}
     * @return the {@link Objective} currently displayed, if present
     */
    Optional<Objective> getObjective(DisplaySlot slot);

    /**
     * Sets the specified {@link Objective} in the specified {@link DisplaySlot}.
     *
     * <p>If the {@link Objective} is <code>null</code>, then the specified
     * {@link DisplaySlot} will be cleared.</p>
     *
     * @param objective The {@link Objective} to set
     * @param displaySlot The {@link DisplaySlot} to the specified {@link Objective} in
     * @throws IllegalStateException if the specified {@link Objective} does not exist
     *                               on this scoreboard
     */
    void addObjective(@Nullable Objective objective, DisplaySlot displaySlot) throws IllegalStateException;

    /**
     * Adds the specified {@link Objective} to this scoreboard.
     *
     * @param objective The {@link Objective} add
     * @throws IllegalArgumentException if an {@link Objective} with the same
     *             {@link Objective#getName() name} already exists, or if the
     *             specified {@link Objective} has already been added.
     */
    void addObjective(Objective objective) throws IllegalArgumentException;

    /**
     * Gets all {@link Objective}s of a Criteria on this scoreboard.
     *
     * @param criteria {@link Criterion} to search by
     * @return A set of {@link Objective}s using the specified Criteria
     */
    Set<Objective> getObjectivesByCriteria(Criterion criteria);

    /**
     * Gets all {@link Objective}s on this scoreboard.
     *
     * @return A set of all {@link Objective}s on this scoreboard
     */
    Set<Objective> getObjectives();

    /**
     * Removes the specified {@link Objective} from this scoreboard.
     *
     * @param objective The {@link Objective} to remove
     */
    void removeObjective(Objective objective);

    /**
     * Gets all scores with the specified name on this scoreboard,
     * across all objectives.
     *
     * @param name The name whose scores are being retrieved
     * @return A set of all scores for the name
     */
    Set<Score> getScores(Text name);

    /**
     * Removes all scores with the specified name on this scoreboard,
     * across all objectives.
     *
     * @param name The name to remove all scores for
     */
    void removeScores(Text name);

    /**
     * Gets a {@link Text} member's {@link Team} on this scoreboard.
     *
     * @param member The {@link Text} to search for
     * @return The {@link Text} member's {@link Team}, or Optional.empty()
     *     if the member has no team
     */
    Optional<Team> getMemberTeam(Text member);

    /**
     * Gets a {@link Team} by name on this scoreboard.
     *
     * @param teamName The name of the {@link Team}
     * @return The matching {@link Team}, if it exists
     */
    Optional<Team> getTeam(String teamName);

    /**
     * Removes the specified {@link Team} to this scoreboard.
     *
     * @param team The {@link Team} to remove
     */
    void removeTeam(Team team);

    /**
     * Adds the specified {@link Team} to this scoreboard.
     *
     * @param team The {@link Team} to add
     * @throws IllegalArgumentException if a team with the same
     *             {@link Team#getName() name} already exists, or the specified
     *             {@link Team} has been added
     */
    void addTeam(Team team) throws IllegalArgumentException;

    /**
     * Gets all the {@link Team}s on this scoreboard.
     *
     * @return The set of {@link Team}s
     */
    Set<Team> getTeams();

    /**
     * Clears any {@link Objective} in the specified slot.
     *
     * @param slot The {@link DisplaySlot} to remove any {@link Objective} for
     */
    void clearSlot(DisplaySlot slot);

}
