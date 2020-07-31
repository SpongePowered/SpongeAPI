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
package org.spongepowered.api.command.selector;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.advancement.Advancement;
import org.spongepowered.api.advancement.criteria.AdvancementCriterion;
import org.spongepowered.api.command.CommandCause;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.scoreboard.Score;
import org.spongepowered.api.scoreboard.Team;
import org.spongepowered.api.util.Range;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.ServerLocation;
import org.spongepowered.math.vector.Vector3d;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Allows for the selection of {@link Entity entities} in a world based on given
 * criteria.
 */
public interface Selector {

    /**
     * Attempts to parse the given string into a selector. It must start with an
     * @ symbol.
     *
     * @param string The string to parse
     * @return The {@link Selector}
     * @throws IllegalArgumentException if the string could not be parsed.
     */
    static Selector parse(final String string) throws IllegalArgumentException {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).parse(string);
    }

    /**
     * Provides a {@link Builder} to build a {@link Selector}.
     *
     * <p>If you wish to create a selector based on a provided string, use
     * {@link Selector#parse(String)} instead.
     *
     * @return The builder
     */
    static Selector.Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Select entities based on the criteria of this selector and a given
     * {@link ServerLocation}
     *
     * @param location The {@link ServerLocation}
     * @return A {@link Collection} of selected {@link Entity entities}
     * @throws IllegalStateException if this selector cannot select based on a
     *                               {@link ServerLocation}
     */
    Collection<Entity> select(ServerLocation location) throws IllegalStateException;

    /**
     * Select entities based on the criteria of this selector and a given
     * {@link Entity}
     *
     * @param entity The {@link Entity}
     * @return A {@link Collection} of selected {@link Entity entities}
     * @throws IllegalStateException if this selector cannot select based on a
     *                               {@link Entity}
     */
    Collection<Entity> select(Entity entity) throws IllegalStateException;

    /**
     * Select entities based on the criteria of this selector and a given
     * {@link CommandCause}
     *
     * @param cause The {@link CommandCause}
     * @return A {@link Collection} of selected {@link Entity entities}
     */
    Collection<Entity> select(CommandCause cause);

    /**
     * Creates a {@link Selector} based on the provided criteria.
     */
    interface Builder extends ResettableBuilder<Selector, Builder> {

        /**
         * Applies the defaults associated with a given {@link SelectorType}
         *
         * @param selectorType The {@link SelectorType}
         * @return This builder, for chaining
         */
        Builder applySelectorType(Supplier<SelectorType> selectorType);

        /**
         * Applies the defaults associated with a given {@link SelectorType}
         *
         * @param selectorType The {@link SelectorType}
         * @return This builder, for chaining
         */
        Builder applySelectorType(SelectorType selectorType);

        /**
         * If the selector's source is an {@link Entity} and this is called,
         * the source is eligible to be selected if all other criteria are
         * met.
         *
         * @return This builder, for chaining.
         */
        Builder includeSelf();

        /**
         * Limits the number of {@link Entity entities} returned by the
         * selector.
         *
         * @param limit The maximum number of entities to return
         * @return This builder, for chaining
         */
        Builder setLimit(int limit);

        /**
         * Sets the minimum and/or maximum distance from the target location
         * that this selector will look.
         *
         * @param range The range
         * @return This builder, for chaining
         */
        Builder setDistance(Range<Double> range);

        /**
         * Sets the volume that entities can be selected from. Entities that
         * have any part of their hitbox within this two specified corners
         * will be eligible to be selected.
         *
         * @param corner1 The first corner
         * @param corner2 The second corner (may be equal to the first to select
         *                entities at a specific point instead)
         * @return This builder, for chaining
         */
        Builder setVolume(Vector3d corner1, Vector3d corner2);

        /**
         * Sets the sorting algorithm to use when returning entities from the
         * selector.
         *
         * @param algorithm The {@link SelectorSortAlgorithm}
         * @return This builder, for chaining
         */
        Builder setSortAlgorithm(Supplier<SelectorSortAlgorithm> algorithm);

        /**
         * Sets the sorting algorithm to use when returning entities from the
         * selector.
         *
         * @param algorithm The {@link SelectorSortAlgorithm}
         * @return This builder, for chaining
         */
        Builder setSortAlgorithm(SelectorSortAlgorithm algorithm);

        /**
         * Adds an {@link Advancement} constraint to this selector, requiring
         * that the advancement must be granted to be selected.
         *
         * @param advancement The advancement that players must have.
         * @return This builder, for chaining
         */
        Builder advancement(Advancement advancement);

        /**
         * Adds an {@link Advancement} constraint to this selector, requiring
         * that the advancement must NOT be granted to be selected.
         *
         * @param advancement The advancement that players must not have.
         * @return This builder, for chaining
         */
        Builder notAdvancement(Advancement advancement);

        /**
         * Adds an {@link AdvancementCriterion} constraint to this selector,
         * requiring that the criterion on the given {@link Advancement} must
         * be granted to be selected.
         *
         * @param advancement The advancement
         * @param criterion The criterion the player must have
         * @return This builder, for chaining
         */
        Builder advancementCriterion(Advancement advancement, AdvancementCriterion criterion);

        /**
         * Adds an {@link AdvancementCriterion} constraint to this selector,
         * requiring that the criterion on the given {@link Advancement} must
         * not be granted to be selected.
         *
         * @param advancement The advancement
         * @param criterion The criterion the player must not have
         * @return This builder, for chaining
         */
        Builder notAdvancementCriterion(Advancement advancement, AdvancementCriterion criterion);

        /**
         * Adds an {@link DataView} as an NBT style constraint.
         *
         * @param view The data view
         * @return This builder, for chaining
         */
        Builder setDataView(DataView view);

        /**
         * Adds an {@link EntityType} constraint to this selector, requiring
         * that all selected entities must be of the given type.
         *
         * <p>If {@code inherit} is true, entities may also be a subtype of the
         * given type.</p>
         *
         * @param type The type
         * @param inherit Whether subtypes will also be selected
         * @return This builder, for chaining
         */
        Builder entityType(Supplier<EntityType<?>> type, boolean inherit);

        /**
         * Adds an {@link EntityType} constraint to this selector, requiring
         * that all selected entities must be of the given type.
         *
         * <p>If {@code inherit} is true, entities may also be a subtype of the
         * given type.</p>
         *
         * @param type The type
         * @param inherit Whether subtypes will also be selected
         * @return This builder, for chaining
         */
        Builder entityType(EntityType<?> type, boolean inherit);

        /**
         * Adds an {@link EntityType} constraint to this selector, requiring
         * that all selected entities must not be of the given type.
         *
         * @param type The type
         * @return This builder, for chaining
         */
        Builder notEntityType(Supplier<EntityType<?>> type);

        /**
         * Adds an {@link EntityType} constraint to this selector, requiring
         * that all selected entities must not be of the given type.
         *
         * @param type The type
         * @return This builder, for chaining
         */
        Builder notEntityType(EntityType<?> type);

        /**
         * Adds an experience level constraint to the selector, specifying that
         * a player's level must be in the provided range (inclusive).
         *
         * @param range The range
         * @return This builder, for chaining
         */
        Builder setExperienceLevel(Range<Integer> range);

        /**
         * Adds a {@link GameMode} constraint to the selector, requiring players
         * be in the given game mode.
         *
         * <p>Cannot be used with {@link #notGameMode(GameMode)}.</p>
         *
         * @param mode The gamemode
         * @return This builder, for chaining
         */
        Builder gameMode(Supplier<GameMode> mode);

        /**
         * Adds a {@link GameMode} constraint to the selector, requiring players
         * be in the given game mode
         *
         * <p>Cannot be used with {@link #notGameMode(GameMode)}.</p>
         *
         * @param mode The gamemode
         * @return This builder, for chaining
         */
        Builder gameMode(GameMode mode);

        /**
         * Adds a {@link GameMode} constraint to the selector, requiring that
         * players are not in the given game mode
         *
         * <p>Cannot be used with {@link #gameMode(GameMode)}.</p>
         *
         * @param mode The gamemode
         * @return This builder, for chaining
         */
        Builder notGameMode(Supplier<GameMode> mode);

        /**
         * Adds a {@link GameMode} constraint to the selector, requiring that
         * players are not in the given game mode
         *
         * <p>Cannot be used with {@link #gameMode(GameMode)}.</p>
         *
         * @param mode The gamemode
         * @return This builder, for chaining
         */
        Builder notGameMode(GameMode mode);

        /**
         * Adds a {@link Team} constraint to the selector, requiring that
         * players are in any team
         *
         * @return This builder, for chaining
         */
        Builder anyTeam();

        /**
         * Adds a {@link Team} constraint to the selector, requiring that
         * players are not in any team
         *
         * @return This builder, for chaining
         */
        Builder noTeam();

        /**
         * Adds a {@link Team} constraint to the selector, requiring that
         * players are in a specific team
         *
         * <p>Cannot be used with {@link #notTeam(Team)}</p>
         *
         * @param team The specific team
         * @return This builder, for chaining
         */
        Builder team(Team team);

        /**
         * Adds a {@link Team} constraint to the selector, requiring that
         * players are not in a specific team
         *
         * <p>Cannot be used with {@link #team(Team)}</p>
         *
         * @param team The specific team
         * @return This builder, for chaining
         */
        Builder notTeam(Team team);

        /**
         * Adds a name constraint to the selector, requiring that entities have
         * a specific name.
         *
         * <p>Cannot be used with {@link #notName(String)}.</p>
         *
         * @param name The name
         * @return This builder, for chaining
         */
        Builder name(String name);

        /**
         * Adds a name constraint to the selector, requiring that entities do
         * not have a specific name.
         *
         * <p>Cannot be used with {@link #name(String)}.</p>
         *
         * @param name The name
         * @return This builder, for chaining
         */
        Builder notName(String name);

        /**
         * Adds a {@link Score} constraint to the selector, requiring that
         * players have a given score in a given range (inclusive).
         *
         * @param score The score
         * @param range The range
         * @return This builder, for chaining
         */
        Builder score(Score score, Range<Integer> range);

        /**
         * Adds a tag constrain to the selector, requiring that
         * entities have a given tag.
         *
         * <p>Cannot be used with {@link #notTag(String)}.</p>
         *
         * @param tag The tag
         * @return This builder, for chaining
         */
        Builder tag(String tag);

        /**
         * Adds a tag constraint to the selector, requiring that
         * entities do not have a given tag.
         *
         * <p>Cannot be used with {@link #tag(String)}.</p>
         *
         * @param tag The tag
         * @return This builder, for chaining
         */
        Builder notTag(String tag);

        /**
         * Adds a pitch constraint to the selector, requiring that entities
         * have a pitch (x_rotation) within the given range, inclusive.
         *
         * <p>The pitch is in degrees, where 0 is considered parallel to the
         * ground, -90 is straight up, and 90 is straight down.</p>
         *
         * @param range The range
         * @return This builder, for chaining
         */
        Builder setPitch(Range<Double> range);

        /**
         * Adds a yaw constraint to the selector, requiring that entities
         * have a yaw (y_rotation) within the given range, inclusive.
         *
         * <p>The yaw is in degrees, where 0 is considered due south. The
         * angle is measured clockwise, so 90 is west, 180 is north and
         * 270 is east.</p>
         *
         * @param range The range
         * @return This builder, for chaining
         */
        Builder setYaw(Range<Double> range);

        /**
         * Applies a custom filter to the selector that must also be met by any
         * {@link Entity entities} that may otherwise be selected by this
         * selector.
         *
         * @param filter A {@link Predicate} used for filtering
         * @return This builder, for chaining
         */
        Builder filter(Predicate<Entity> filter);

        /**
         * Creates a {@link Selector} based on this builder.
         *
         * @return A {@link Selector}
         * @throws IllegalStateException if the builder could not create a
         *                               selector
         */
        Selector build() throws IllegalStateException;

    }

    interface Factory {

        Selector parse(String string) throws IllegalArgumentException;

    }

}
