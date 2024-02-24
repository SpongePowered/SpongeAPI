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
package org.spongepowered.api.scoreboard.objective;

import net.kyori.adventure.text.Component;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.scoreboard.Score;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.scoreboard.criteria.Criterion;
import org.spongepowered.api.scoreboard.objective.displaymode.ObjectiveDisplayMode;
import org.spongepowered.api.util.CopyableBuilder;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

/**
 * An objective tracks an integer score for each entry it contains.
 *
 * <p>Entries can be updated by plugins, by in-game commands, or automatically
 * by the game, depending on their {@link Criterion}.</p>
 */
public interface Objective {

    /**
     * Creates a new {@link Builder} to build a {@link Objective}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * Gets the name of this Objective.
     *
     * @return The objective's name
     */
    String name();

    /**
     * Gets the name displayed to players.
     *
     * @return The objective's display name
     */
    Component displayName();

    /**
     * Sets the name displayed to players.
     *
     * @param displayName Display name to set
     * @throws IllegalArgumentException if displayName is longer than 32
     *     characters (in its legacy representation)
     */
    void setDisplayName(Component displayName) throws IllegalArgumentException;

    /**
     * Gets the criterion for this objective.
     *
     * @return This objective's criterion
     */
    Criterion criterion();

    /**
     * Gets the {@link ObjectiveDisplayMode} used to display this objective.
     *
     * @return The {@link ObjectiveDisplayMode} used to display this objective
     */
    ObjectiveDisplayMode displayMode();

    /**
     * Sets the {@link ObjectiveDisplayMode} used to display this objective.
     *
     * @param displayMode The {@link ObjectiveDisplayMode} used to display this objective
     */
    void setDisplayMode(ObjectiveDisplayMode displayMode);

    /**
     * Gets the set of {@link Score}s for this objective.
     *
     * @return The set of {@link Score}s for this objective
     */
    Map<String, Score> scores();

    /**
     * Returns whether this objective has a {@link Score} with the given name.
     *
     * @param name The name of the {@link Score} to check for.
     * @return Whether this objective has a {@link Score} with the given name.
     */
    boolean hasScore(String name);


    /**
     * Returns whether this objective has a {@link Score} with the given entity.
     *
     * @param entity The entity of the {@link Score} to check for.
     * @return Whether this objective has a {@link Score} with the given entity.
     */
    boolean hasScore(Entity entity);


    /**
     * Returns whether this objective has a {@link Score} with the given profile.
     *
     * @param profile The profile of the {@link Score} to check for.
     * @return Whether this objective has a {@link Score} with the given profile.
     */
    boolean hasScore(GameProfile profile);

    /**
     * Adds the specified {@link Score} to this objective.
     *
     * @param score The {@link Score} to add
     * @throws IllegalArgumentException If a {@link Score} with the same name exists, or the specified {@link Score} has already been added
     */
    void addScore(Score score) throws IllegalArgumentException;

    /**
     * Gets an entry's {@link Score} for this objective, if it exists.
     *
     * @param name The name of the {@link Score} to get.
     * @return The {@link Score} for the specified name, if it exists.
     */
    default Optional<Score> findScore(final String name) {
        if (!this.hasScore(name)) {
            return Optional.empty();
        }
        return Optional.of(this.findOrCreateScore(name));
    }

    /**
     * Gets an entry's {@link Score} for this objective.
     *
     * <p>If the {@link Score} does not exist, it will be created.</p>
     *
     * @param name The name of the {@link Score} to get
     * @return The {@link Score} for the specified name
     */
    Score findOrCreateScore(String name);

    /**
     * Removes the {@link Score} with the specified name from this objective, if present.
     *
     * @param name The name of the {@link Score} to remove.
     * @return Whether the score existed on this objective
     */
    boolean removeScore(String name);

    /**
     * Gets an entry's {@link Score} for this objective, if it exists.
     *
     * @param entity The entity of the {@link Score} to get.
     * @return The {@link Score} for the specified entity, if it exists.
     */
    default Optional<Score> findScore(final Entity entity) {
        if (!this.hasScore(entity)) {
            return Optional.empty();
        }
        return Optional.of(this.findOrCreateScore(entity));
    }

    /**
     * Gets an entry's {@link Score} for this objective.
     *
     * <p>If the {@link Score} does not exist, it will be created.</p>
     *
     * @param entity The name of the {@link Score} to get
     * @return The {@link Score} for the specified entity
     */
    Score findOrCreateScore(Entity entity);

    /**
     * Removes the {@link Score} with the specified entity from this objective, if present.
     *
     * @param entity The entity of the {@link Score} to remove.
     * @return Whether the score existed on this objective
     */
    boolean removeScore(Entity entity);

    /**
     * Gets an entry's {@link Score} for this objective, if it exists.
     *
     * @param profile The profile of the {@link Score} to get.
     * @return The {@link Score} for the specified profile, if it exists.
     */
    default Optional<Score> findScore(final GameProfile profile) {
        if (!this.hasScore(profile)) {
            return Optional.empty();
        }
        return Optional.of(this.findOrCreateScore(profile));
    }

    /**
     * Gets an entry's {@link Score} for this objective.
     *
     * <p>If the {@link Score} does not exist, it will be created.</p>
     *
     * @param profile The profile of the {@link Score} to get
     * @return The {@link Score} for the specified profile
     */
    Score findOrCreateScore(GameProfile profile);

    /**
     * Removes the {@link Score} with the specified profile from this objective, if present.
     *
     * @param profile The profile of the {@link Score} to remove.
     * @return Whether the score existed on this objective
     */
    boolean removeScore(GameProfile profile);

    /**
     * Removes the specified {@link Score} from this objective, if present.
     *
     * @param score The {@link Score} to remove
     * @return Whether the score existed on this objective
     */
    boolean removeScore(Score score);

    /**
     * Returns a {@link Set} of parent {@link Scoreboard}s this
     * {@link Objective} is registered to.
     *
     * @return A {@link Set} of parent {@link Scoreboard}s this
     *         {@link Objective} is registered to
     */
    Set<Scoreboard> scoreboards();

    /**
     * Represents a builder to create {@link Objective} instances.
     */
    interface Builder extends org.spongepowered.api.util.Builder<Objective, Builder>, CopyableBuilder<Objective, Builder> {

        /**
         * Sets the name of the {@link Objective}.
         *
         * @param name The name to set
         * @return This builder
         */
        Builder name(String name);

        /**
         * Sets the display name of the {@link Objective}.
         *
         * @param displayName The display name to set
         * @return This builder
         */
        Builder displayName(Component displayName);

        /**
         * Sets the {@link Criterion} of the {@link Objective}.
         *
         * @param criterion The {@link Criterion} to set
         * @return This builder
         */
        default Builder criterion(final Supplier<? extends Criterion> criterion) {
            return this.criterion(criterion.get());
        }

        /**
         * Sets the {@link Criterion} of the {@link Objective}.
         *
         * @param criterion The {@link Criterion} to set
         * @return This builder
         */
        Builder criterion(Criterion criterion);

        /**
         * Sets the {@link ObjectiveDisplayMode} of the {@link Objective}.
         *
         * @param objectiveDisplayMode The {@link ObjectiveDisplayMode} to set
         * @return This builder
         */
        default Builder objectiveDisplayMode(final Supplier<? extends ObjectiveDisplayMode> objectiveDisplayMode) {
            return this.objectiveDisplayMode(objectiveDisplayMode.get());
        }

        /**
         * Sets the {@link ObjectiveDisplayMode} of the {@link Objective}.
         *
         * @param objectiveDisplayMode The {@link ObjectiveDisplayMode} to set
         * @return This builder
         */
        Builder objectiveDisplayMode(ObjectiveDisplayMode objectiveDisplayMode);

        /**
         * Builds an instance of an {@link Objective}.
         *
         * @return A new instance of an {@link Objective}
         * @throws IllegalStateException if the {@link Objective} is not complete
         */
        @Override
        Objective build() throws IllegalStateException;

    }
}
