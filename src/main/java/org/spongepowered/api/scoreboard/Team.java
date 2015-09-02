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


import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColor;

import java.util.Set;

/**
 * A team on a scoreboard that has a common display theme and other
 * properties.
 *
 * <p>A team is comprised of different members, represented by {@link Text} objects.
 * While any {@link Text} can be added to a team, certain {@link Text}s convey a special
 * meaning.</p>
 *
 * <p>Examples of this include players, whose names gain the prefix and suffix of
 * the team they are on.</p>
 */
public interface Team {

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
    Text getDisplayName();

    /**
     * Gets the color of this team.
     *
     * <p>The team's color is a distinct concept from its prefix or suffix.
     * It is only used for colored sidebar display slots, and certain statistic
     * criteria.</p>
     *
     * @return The team color
     */
    TextColor getColor();

    /**
     * Sets the color of this team.
     *
     * <p>The team's color is a distinct concept from its prefix or suffix.
     * It is only used for colored sidebar display slots, and certain statistic
     * criteria.</p>
     *
     * @param color The team color
     * @throws IllegalArgumentException If color is {@link org.spongepowered.api.text.format.TextColors#RESET}
     */
    void setColor(TextColor color) throws IllegalArgumentException;

    /**
     * Sets the name displayed to users for this team.
     *
     * @param displayName The {@link Text} to use
     * @throws IllegalArgumentException If displayName is longer than 32
     *     characters
     */
    void setDisplayName(Text displayName) throws IllegalArgumentException;

    /**
     * Gets the prefix prepended to the display name of users on this team.
     *
     * @return The prefix for this team
     */
    Text getPrefix();

    /**
     * Sets the prefix prepended to the display name of users on this team.
     *
     * @param prefix The new prefix for this team
     * @throws IllegalArgumentException If prefix is longer than 16
     *     characters
     */
    void setPrefix(Text prefix) throws IllegalArgumentException;

    /**
     * Gets the suffix appended to the display name of users on this team.
     *
     * @return The team's current suffix
     */
    Text getSuffix();

    /**
     * Sets the suffix appended to the display name of users on this team.
     *
     * @param suffix The new suffix for this team.
     * @throws IllegalArgumentException If suffix is longer than 16
     *     characters
     */
    void setSuffix(Text suffix) throws IllegalArgumentException;

    /**
     * Gets whether friendly fire is enabled.
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
    void setNameTagVisibility(Visibility visibility);

    /**
     * Gets the {@link Visibility} which controls who death Texts
     * for players on this team are visible to.
     *
     * @return The {@link Visibility} for this team's death Texts
     */
    Visibility getDeathTextVisibility();

    /**
     * Sets the {@link Visibility} which controls who death Texts
     * of players on this team are visible to.
     *
     * @param visibility The {@link Visibility} for this team's death Texts
     */
    void setDeathTextVisibility(Visibility visibility);

    /**
     * Gets the {@link Text}s representing the members of this team.
     *
     * @return the {@link Text}s for this team's members
     */
    Set<Text> getMembers();

    /**
     * Adds the specified {@link Text} to this team.
     *
     * <p>While any {@link Text} may be added, the {@link Text}
     * to use should normally be obtained by calling {@link TeamMember#getTeamRepresentation()}
     * on a {@link TeamMember}, such as a {@link Player}.</p>
     *
     * @param member the {@link Text} to add
     */
    void addMember(Text member);

    /**
     * Removes the specified {@link Text} from this team.
     *
     * <p>While any {@link Text} may be removed, the {@link Text}
     * to use should normally be obtained by calling {@link TeamMember#getTeamRepresentation()}
     * on a {@link TeamMember}, such as a {@link Player}.</p
     *
     * @param member The {@link Text} to remove
     * @return Whether the {@link Text} was on this team
     */
    boolean removeMember(Text member);

    /**
     * Gets the {@link Text}s on the team.
     *
     * <p>Text-based methods on {@link Team} are usually used for "fake player" entries on the
     * scoreboard.</p>
     *
     * @return The {@link Text}s on the team
     */
    Set<Text> getTexts();

    /**
     * Adds the specified {@link Text} to this team for the {@link Scoreboard}.
     *
     * <p>Text-based methods on {@link Team} are usually used for "fake player" entries on the
     * scoreboard.</p>
     * <p>This will remove the {@link Text} from any other team on the {@link Scoreboard}.</p>
     *
     * @param text The {@link Text} to add
     */
    void addText(Text text);

    /**
     * Removes the specified {@link Text} from this team.
     *
     * <p>Text-based methods on {@link Team} are usually used for "fake player" entries on the
     * scoreboard.</p>
     *
     * @param text The {@link Text} to remove
     * @return Whether the {@link Text} was on this team
     */
    boolean removeText(Text text);

    /**
     * Returns a {@link Set} of parent {@link Scoreboard}s this {@link Team} is
     * registered to.
     *
     * @return A {@link Set} of parent {@link Scoreboard}s this {@link Team} is
     *         registered to
     */
    Set<Scoreboard> getScoreboards();

}
