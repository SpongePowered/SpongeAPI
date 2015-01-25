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
package org.spongepowered.api.util.bans;

import org.spongepowered.api.entity.player.User;

import java.util.Collection;

/**
 * Represents something that can provide information for bans.
 */
public interface BanProvider {

    /**
     * Gets all bans registered in this provider.
     *
     * @return The bans
     */
    Collection<Ban> getBans();

    /**
     * Gets all bans registered in this provider to the given user.
     *
     * @param user The user
     * @return The bans
     */
    Collection<Ban> getBansFor(User user);

    /**
     * Removes all bans in this system for a certain user.
     *
     * @param user The user
     */
    void pardon(User user);

    /**
     * Removes the ban from this system.
     *
     * @param ban The ban
     */
    void remove(Ban ban);

    /**
     * Checks if the specified ban is contained in this provider.
     *
     * @param ban The ban
     * @return True if the ban exists in this provider, false otherwise
     */
    boolean hasBan(Ban ban);

    /**
     * Checks if a user has any bans.
     *
     * @param user The user
     * @return True if the user has any bans, false otherwise
     */
    boolean isBanned(User user);

}
