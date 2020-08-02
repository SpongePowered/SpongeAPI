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
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.scoreboard.criteria.Criterion;
import org.spongepowered.api.scoreboard.displayslot.DisplaySlot;
import org.spongepowered.api.scoreboard.objective.Objective;
import org.spongepowered.api.util.CopyableBuilder;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Represents a scoreboard, which contains {@link Team}s and {@link Objective}s.
 * The server has a default scoreboard, but each {@link Player}
 * can have their own scoreboard.
 *
 * @see <a href="http://minecraft.gamepedia.com/Scoreboard">Scoreboards on the Minecraft Wiki</a>
 */
public interface Scoreboard {

    /**
     * Creates a new {@link Builder} to build a {@link Scoreboard}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

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
    default Optional<Objective> getObjective(Supplier<? extends DisplaySlot> slot) {
        return this.getObjective(slot.get());
    }

    /**
     * Gets the {@link Objective} currently displayed in a {@link DisplaySlot} on this
     * scoreboard, if one is present.
     *
     * @param slot The {@link DisplaySlot}
     * @return the {@link Objective} currently displayed, if present
     */
    Optional<Objective> getObjective(DisplaySlot slot);

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
    default void updateDisplaySlot(@Nullable Objective objective, Supplier<? extends DisplaySlot> displaySlot) throws IllegalStateException {
        this.updateDisplaySlot(objective, displaySlot.get());
    }

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
    void updateDisplaySlot(@Nullable Objective objective, DisplaySlot displaySlot) throws IllegalStateException;

    /**
     * Clears any {@link Objective} in the specified slot.
     *
     * @param slot The {@link DisplaySlot} to remove any {@link Objective} for
     */
    default void clearSlot(Supplier<? extends DisplaySlot> slot) {
        this.clearSlot(slot.get());
    }

    /**
     * Clears any {@link Objective} in the specified slot.
     *
     * @param slot The {@link DisplaySlot} to remove any {@link Objective} for
     */
    default void clearSlot(DisplaySlot slot) {
        this.updateDisplaySlot(null, slot);
    }

    /**
     * Gets all {@link Objective}s of a Criteria on this scoreboard.
     *
     * @param criterion {@link Criterion} to search by
     * @return A set of {@link Objective}s using the specified criterion
     */
    default Set<Objective> getObjectivesByCriterion(Supplier<? extends Criterion> criterion) {
        return this.getObjectivesByCriterion(criterion.get());
    }

    /**
     * Gets all {@link Objective}s of a Criteria on this scoreboard.
     *
     * @param criterion {@link Criterion} to search by
     * @return A set of {@link Objective}s using the specified criterion
     */
    Set<Objective> getObjectivesByCriterion(Criterion criterion);

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
     * Gets all the scores on this scoreboard, across all objectives.
     *
     * <p>If the same {@link Score} has been added to multiple objectives,
     * it will only appear once in the set.</p>
     *
     * @return A set of all scores
     */
    Set<Score> getScores();

    /**
     * Gets all scores with the specified name on this scoreboard,
     * across all objectives.
     *
     * <p>If the same {@link Score} has been added to multiple objectives,
     * it will only appear once in the set.</p>
     *
     * @param name The name whose scores are being retrieved
     * @return A set of all scores for the name
     */
    Set<Score> getScores(Component name);

    /**
     * Removes all scores with the specified name on this scoreboard,
     * across all objectives.
     *
     * @param name The name to remove all scores for
     */
    void removeScores(Component name);

    /**
     * Gets a {@link Team} by name on this scoreboard.
     *
     * @param teamName The name of the {@link Team}
     * @return The matching {@link Team}, if it exists
     */
    Optional<Team> getTeam(String teamName);

    /**
     * Registers the specified {@link Team} to this scoreboard.
     *
     * @param team The {@link Team} to register
     * @throws IllegalArgumentException if a team with the same
     *             {@link Team#getName() name} already exists on this scoreboard, or if the specified
     *             {@link Team} is already registered to a scoreboard (this scoreboard,
     *             or another one).
     */
    void registerTeam(Team team) throws IllegalArgumentException;

    /**
     * Gets all the {@link Team}s on this scoreboard.
     *
     * @return The set of {@link Team}s
     */
    Set<Team> getTeams();

    /**
     * Gets a {@link Component} member's {@link Team} on this scoreboard.
     *
     * @param member The {@link Component} to search for
     * @return The {@link Component} member's {@link Team}, or Optional.empty()
     *     if the member has no team
     */
    Optional<Team> getMemberTeam(Component member);

    /**
     * Represents a builder to create {@link Scoreboard} instances.
     */
    interface Builder extends CopyableBuilder<Scoreboard, Builder> {

        /**
         * Sets the list of {@link Objective}s of the {@link Scoreboard}.
         *
         * <p>By default, this is the empty list.</p>
         *
         * @param objectives The list of {@link Objective}s to set
         * @return This builder
         */
        Builder objectives(List<Objective> objectives);

        /**
         * Sets the list of {@link Team}s of the {@link Scoreboard}.
         *
         * <p>By default, this is the empty list.</p>
         *
         * @param teams The list of {@link Team}s to set
         * @return This builder
         */
        Builder teams(List<Team> teams);

        /**
         * Builds an instance of a {@link Scoreboard}.
         *
         * @return A new instance of a {@link Scoreboard}
         * @throws IllegalStateException if the {@link Scoreboard} is not complete
         */
        Scoreboard build() throws IllegalStateException;

    }
}
