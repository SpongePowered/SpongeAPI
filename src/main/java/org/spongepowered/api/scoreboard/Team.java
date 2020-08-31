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
import net.kyori.adventure.text.format.NamedTextColor;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.util.CopyableBuilder;

import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

/**
 * A team on a scoreboard that has a common display theme and other
 * properties.
 *
 * <p>A team is comprised of different members, represented by {@link Component} objects.
 * While any {@link Component} can be added to a team, certain {@link Component}s convey a special
 * meaning.</p>
 *
 * <p>Examples of this include players, whose names gain the prefix and suffix
 * of the team they are on.</p>
 *
 * <p>With the exception of {@link #getNameTagVisibility()} (which is handled client-side),
 * all of the team options require players to have the same team object (and by
 * extension, the same scoreboard).
 *
 * For example, consider two players who each have different scoreboards set.
 * Each scoreboard has a team registered with identical names, each containing
 * the same players. Both players would always be able to attack each other,
 * regardless of the value of {@link #allowFriendlyFire()}.
 *
 * For it to work, both players must have the same scoreboard, and be on a team
 * registered to said scoreboard.</p>
 */
public interface Team {

    /**
     * Creates a new {@link Builder} to build a {@link Team}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the name of this team.
     *
     * @return The name of this team
     */
    String getName();

    /**
     * Gets the name displayed to users for this team.
     *
     * @return The display name for this team
     */
    Component getDisplayName();

    /**
     * Sets the name displayed to users for this team.
     *
     * @param displayName The {@link Component} to use
     * @throws IllegalArgumentException If displayName is longer than 32
     *     characters (in its legacy representation)
     */
    void setDisplayName(Component displayName) throws IllegalArgumentException;

    /**
     * Gets the color of this team.
     *
     * <p>The team's color is a distinct concept from its prefix or suffix.
     * It is only used for colored sidebar display slots, and certain statistic
     * criteria.</p>
     *
     * @return The team color
     */
    NamedTextColor getColor();

    /**
     * Sets the color of this team.
     *
     * <p>The team's color is a distinct concept from its prefix or suffix.
     * It is only used for colored sidebar display slots, and certain statistic
     * criteria.</p>
     *
     * @param color The team color
     */
    void setColor(NamedTextColor color);

    /**
     * Gets the prefix prepended to the display name of users on this team.
     *
     * @return The prefix for this team
     */
    Component getPrefix();

    /**
     * Sets the prefix prepended to the display name of users on this team.
     *
     * @param prefix The new prefix for this team
     * @throws IllegalArgumentException If prefix is longer than 16
     *     characters
     */
    void setPrefix(Component prefix) throws IllegalArgumentException;

    /**
     * Gets the suffix appended to the display name of users on this team.
     *
     * @return The team's current suffix
     */
    Component getSuffix();

    /**
     * Sets the suffix appended to the display name of users on this team.
     *
     * @param suffix The new suffix for this team.
     * @throws IllegalArgumentException If suffix is longer than 16
     *     characters (in its legacy representation)
     */
    void setSuffix(Component suffix) throws IllegalArgumentException;

    /**
     * Gets whether friendly fire is enabled.
     *
     * <p>This option only controls players attacking other players. It has no
     * affect other entities attacking other entities, or players attacking
     * other entities (or vice-versa).</p>
     *
     * @return Whether friendly fire is enabled
     */
    boolean allowFriendlyFire();

    /**
     * Sets whether friendly fire is enabled.
     *
     * @param enabled Whether friendly fire is enabled
     */
    void setAllowFriendlyFire(boolean enabled);

    /**
     * Gets whether invisible team members are shown.
     *
     * @return Whether to show invisible team members
     */
    boolean canSeeFriendlyInvisibles();

    /**
     * Sets whether invisible team members are shown.
     *
     * @param enabled Whether to show invisible teammates
     */
    void setCanSeeFriendlyInvisibles(boolean enabled);

    /**
     * Gets the {@link Visibility} which controls to who nametags
     * of players on this team are visible to.
     *
     * @return The {@link Visibility} for this team's nametags
     */
    Visibility getNameTagVisibility();

    /**
     * Sets the {@link Visibility} which controls to who nametags
     * of players on this team are visible to.
     *
     * @param visibility The {@link Visibility} for this team's nametags
     */
    default void setNameTagVisibility(Supplier<? extends Visibility> visibility) {
        this.setNameTagVisibility(visibility.get());
    }

    /**
     * Sets the {@link Visibility} which controls to who nametags
     * of players on this team are visible to.
     *
     * @param visibility The {@link Visibility} for this team's nametags
     */
    void setNameTagVisibility(Visibility visibility);

    /**
     * Gets the {@link Visibility} which controls who death Texts
     * for players on this team are visible to.
     *
     * @return The {@link Visibility} for this team's death Texts
     */
    Visibility getDeathMessageVisibility();

    /**
     * Sets the {@link Visibility} which controls who death Texts
     * of players on this team are visible to.
     *
     * @param visibility The {@link Visibility} for this team's death Texts
     */
    default void setDeathMessageVisibility(Supplier<? extends Visibility> visibility) {
        this.setDeathMessageVisibility(visibility.get());
    }

    /**
     * Sets the {@link Visibility} which controls who death Texts
     * of players on this team are visible to.
     *
     * @param visibility The {@link Visibility} for this team's death Texts
     */
    void setDeathMessageVisibility(Visibility visibility);

    /**
     * Gets the {@link CollisionRule} for entities on this team.
     *
     * @return The {@link CollisionRule} for entities on this team
     */
    CollisionRule getCollisionRule();

    /**
     * Sets the {@link CollisionRule} for entities on this team.
     *
     * @param rule The {@link CollisionRule} for entities on this team
     */
    default void setCollisionRule(Supplier<? extends CollisionRule> rule) {
        this.setCollisionRule(rule.get());
    }

    /**
     * Sets the {@link CollisionRule} for entities on this team.
     *
     * @param rule The {@link CollisionRule} for entities on this team
     */
    void setCollisionRule(CollisionRule rule);

    /**
     * Gets the {@link Component}s representing the members of this team.
     *
     * @return the {@link Component}s for this team's members
     */
    Set<Component> getMembers();

    /**
     * Adds the specified {@link Component} to this team.
     *
     * <p>While any {@link Component} may be added, the {@link Component} to use should
     * normally be obtained by calling
     * {@link TeamMember#getTeamRepresentation()} on a {@link TeamMember}, such
     * as a {@link Player}.</p>
     *
     * @param member the {@link Component} to add
     */
    void addMember(Component member);

    /**
     * Removes the specified {@link Component} from this team.
     *
     * <p>While any {@link Component} may be removed, the {@link Component}
     * to use should normally be obtained by calling {@link TeamMember#getTeamRepresentation()}
     * on a {@link TeamMember}, such as a {@link Player}.</p>
     *
     * @param member The {@link Component} to remove
     * @return Whether the {@link Component} was on this team
     */
    boolean removeMember(Component member);

    /**
     * Returns the scoreboard this team is registered on, if available.
     *
     * <p>This will return {@link Optional#empty()} when a team has
     * been removed from its {@link Scoreboard}, or has been created
     * but not yet registered.</p>
     *
     * @return The scoreboard this team is registered on, if available.
     */
    Optional<Scoreboard> getScoreboard();

    /**
     * Unregisters this team from its {@link Scoreboard}, if present.
     *
     * <p>A team can still be fully used after being unregistered. However,
     * it will not affect the game in any way until registered to a
     * {@link Scoreboard} again, through
     * {@link Scoreboard#registerTeam(Team)}.</p>
     *
     * @return Whether this team was registered to a {@link Scoreboard}.
     */
    boolean unregister();

    /**
     * Represents a builder tp create {@link Team} instances.
     */
    interface Builder extends CopyableBuilder<Team, Builder> {

        /**
         * Sets the name of the {@link Team}.
         *
         * @param name The name to set
         * @return This builder
         */
        Builder name(String name);

        /**
         * Sets the color of the {@link Team}.
         *
         * <p>The team's color is a distinct concept from its prefix or suffix.
         * It is only used for colored sidebar display slots, and certain
         * statistic criteria.</p>
         *
         * @param color The color to set
         * @return This builder
         */
        Builder color(NamedTextColor color);

        /**
         * Sets the name displayed to users for the {@link Team}.
         *
         * <p>Display names may be truncated in order to meet an
         * implementation-defined length limit. In Vanilla, this is sixteen
         * characters.</p>
         *
         * <p>By default, this is set to {@link #name(String)}</p>
         *
         * @param displayName The {@link Component} to set
         * @return This builder
         * @throws IllegalArgumentException If the name is longer than 16
         *     characters
         */
        Builder displayName(Component displayName) throws IllegalArgumentException;

        /**
         * Sets the prefix prepended to the display name of users on the
         * {@link Team}.
         *
         * <p>Display names may be truncated in order to meet an
         * implementation-defined length limit. In Vanilla, this is sixteen
         * characters.</p>
         *
         * @param prefix The new prefix for the {@link Team}
         * @return This builder
         */
        Builder prefix(Component prefix);

        /**
         * Sets the suffix appended to the display name of users on the
         * {@link Team}.
         *
         * <p>Display names may be truncated in order to meet an
         * implementation-defined length limit. In Vanilla, this is sixteen
         * characters.</p>
         *
         * @param suffix The new suffix for the {@link Team}.
         * @return This builder
         */
        Builder suffix(Component suffix);

        /**
         * Sets whether friendly fire is enabled for the {@link Team}.
         *
         * @param enabled Whether friendly fire is enabled
         * @return This builder
         */
        Builder allowFriendlyFire(boolean enabled);

        /**
         * Sets whether invisible team members are shown for the
         * {@link Team}.
         *
         * @param enabled Whether to show invisible teammates
         * @return This builder
         */
        Builder canSeeFriendlyInvisibles(boolean enabled);

        /**
         * Sets the {@link Visibility} which controls to who nametags
         * of players on the {@link Team} are visible to.
         *
         * @param visibility The {@link Visibility} for the {@link Team}'s
         *     nametags
         * @return This builder
         */
        default Builder nameTagVisibility(Supplier<? extends Visibility> visibility) {
            return this.nameTagVisibility(visibility.get());
        }

        /**
         * Sets the {@link Visibility} which controls to who nametags
         * of players on the {@link Team} are visible to.
         *
         * @param visibility The {@link Visibility} for the {@link Team}'s
         *     nametags
         * @return This builder
         */
        Builder nameTagVisibility(Visibility visibility);

        /**
         * Sets the {@link Visibility} which controls who death Texts
         * of players on the {@link Team} are visible to.
         *
         * @param visibility The {@link Visibility} for the {@link Team}'s
         *     death Texts
         * @return This builder
         */
        default Builder deathTextVisibility(Supplier<? extends Visibility> visibility) {
            return this.deathTextVisibility(visibility.get());
        }

        /**
         * Sets the {@link Visibility} which controls who death Texts
         * of players on the {@link Team} are visible to.
         *
         * @param visibility The {@link Visibility} for the {@link Team}'s
         *     death Texts
         * @return This builder
         */
        Builder deathTextVisibility(Visibility visibility);

        /**
         * Sets the {@link CollisionRule} for this team's members.
         *
         * @param rule The {@link CollisionRule} for the {@link Team}'s members
         * @return This builder
         */
        default Builder collisionRule(Supplier<? extends CollisionRule> rule) {
            return this.collisionRule(rule.get());
        }

        /**
         * Sets the {@link CollisionRule} for this team's members.
         *
         * @param rule The {@link CollisionRule} for the {@link Team}'s members
         * @return This builder
         */
        Builder collisionRule(CollisionRule rule);

        /**
         * Sets the set of {@link Component} members on the {@link Team}.
         *
         * <p>By default, this is the empty set.</p>
         *
         * @param users The set of {@link Component} members on the {@link Team}
         * @return This builder
         */
        Builder members(Set<Component> users);

        /**
         * Builds an instance of a {@link Team}.
         *
         * @return A new instance of a {@link Team}
         * @throws IllegalStateException if the {@link Team} is not complete
         */
        Team build() throws IllegalStateException;

    }
}
