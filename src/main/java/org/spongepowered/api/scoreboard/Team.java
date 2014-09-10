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
 * <p>This class provides means of combining different {@link Teamable}s
 * to one scoreboard entry.</p>
 */
public interface Team {

    /**
     * Gets the name of the team.</p>
     * The name must be at most 16 chars long, and one single word.
     *
     * @return The name of the team
     */
    String getName();

    /**
     * Sets the name of the team.</p>
     * The name must be at most 16 chars long, and one single world.</p>
     * Note that this will recreate the team entry on all assigned objectives.
     *
     * @param name The new name
     */
    void setName(String name);

    /**
     * Gets the display name of the team.</p>
     * The display name must be at most 16 chars long.
     *
     * @return The display name of the team
     */
    String getDisplayName();

    /**
     * Sets the display name to the specified value.</p>
     * The display name must be at most 16 chars long.
     *
     * @param displayName The display name which will be set for this team.
     */
    void setDisplayName(String displayName);

    /**
     * Gets the prefix assigned to this team.
     *
     * @return The prefix
     */
    String getPrefix();

    /**
     * Sets the prefix assigned to this team.
     *
     * @param prefix The prefix
     */
    void setPrefix(String prefix);

    /**
     * Gets the suffix assigned to this team.
     *
     * @return The suffix
     */
    String getSuffix();

    /**
     * Sets the suffix assigned to this team.
     *
     * @param suffix The suffix
     */
    void setSuffix(String suffix);

    /**
     * Sets whether friendly fire is allowed.
     *
     * @param friendlyFire Whether friendly fire is allowed or not.
     */
    void setFriendlyFireAllowed(boolean friendlyFire);

    /**
     * Gets whether friendly fire is allowed.
     *
     * @return True if friendly fire is allowed, false otherwise.
     */
    boolean isFriendlyFireAllowed();

    /**
     * Sets whether teammates can see each other, even when they are invisible.
     *
     * @param seeInvisibleFriends True if members can see invisible teammates,
     *                            false otherwise.
     */
    void setSeeInvisibleFriends(boolean seeInvisibleFriends);

    /**
     * Gets whether teammates can see each other, even when they are invisible.
     *
     * @return True if members can see invisible teammates, false otherwise.
     */
    boolean canSeeInvisibleFriends();

    /**
     * Adds a new member to this team.
     *
     * @param member The member to add
     */
    void addMember(Teamable member);

    /**
     * Removes the specified member from this team.
     *
     * @param member The member to remove
     */
    void removeMember(Teamable member);

    /**
     * Checks whether the specified member is in this team.
     *
     * @param member The member to check
     * @return True if the member is in this team, false otherwise.
     */
    boolean hasMember(Teamable member);

    /**
     * Gets the total count of all members in this team.
     *
     * @return The total member count
     */
    int getMemberCount();

    /**
     * Gets all members in this team.
     *
     * @return All team members
     */
    Collection<Teamable> getMembers();
}
