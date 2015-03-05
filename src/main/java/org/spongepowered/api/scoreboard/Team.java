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


import com.google.common.base.Optional;
import org.spongepowered.api.entity.player.User;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.message.Message;

import java.util.Set;

/**
 * A team on a scoreboard that has a common display theme and other
 * properties. This team is only relevant for the display of the associated
 * {@link #getScoreboard() scoreboard}.
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
    Message getDisplayName();

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
     * @param displayName The {@link Message} to use
     * @throws IllegalArgumentException If displayName is longer than 32
     *     characters
     */
    void setDisplayName(Message displayName) throws IllegalArgumentException;

    /**
     * Gets the prefix prepended to the display name of users on this team.
     *
     * @return The prefix for this team
     */
    Message getPrefix();

    /**
     * Sets the prefix prepended to the display name of users on this team.
     *
     * @param prefix The new prefix for this team
     * @throws IllegalArgumentException If prefix is longer than 16
     *     characters
     */
    void setPrefix(Message prefix) throws IllegalArgumentException;

    /**
     * Gets the suffix appended to the display name of users on this team.
     *
     * @return The team's current suffix
     */
    Message getSuffix();

    /**
     * Sets the suffix appended to the display name of users on this team.
     *
     * @param suffix The new suffix for this team.
     * @throws IllegalArgumentException If suffix is longer than 16
     *     characters
     */
    void setSuffix(Message suffix) throws IllegalArgumentException;

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
     * Gets the {@link Visibility} which controls who death messages
     * for players on this team are visible to.
     *
     * @return The {@link Visibility} for this team's death messages
     */
    Visibility getDeathMessageVisibility();

    /**
     * Sets the {@link Visibility} which controls who death messages
     * of players on this team are visible to.
     *
     * @param visibility The {@link Visibility} for this team's death messages
     */
    void setDeathMessageVisibility(Visibility visibility);

    /**
     * Gets the {@link User}s on the team.
     *
     * @return The {@link User}s on the team
     */
    Set<User> getUsers();

    /**
     * Gets the {@link Scoreboard} to which this team is attached, if this team
     * is registered.
     *
     * @return The owning {@link Scoreboard}, if this team is registered
     */
    Optional<Scoreboard> getScoreboard();

    /**
     * Adds the specified {@link User} to this team for the {@link Scoreboard}.
     *
     * <p>This will remove the {@link User} from any other team on the {@link Scoreboard}.</p>
     *
     * @param user The {@link User} to add
     */
    void addUser(User user);

    /**
     * Removes the specified {@link User} from this team.
     *
     * @param user The {@link User} to remove
     * @return Whether the {@link User} was on this team
     */
    boolean removeUser(User user);

    /**
     * Unregisters this team from the {@link Scoreboard}.
     */
    void unregister();

    /**
     * Checks to see if the specified {@link User} is a member of this team.
     *
     * @param user The {@link User} to check for
     * @return Whether the {@link User} is a member of this team
     */
    boolean hasUser(User user);

}
