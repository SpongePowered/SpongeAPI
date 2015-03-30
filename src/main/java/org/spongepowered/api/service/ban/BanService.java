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
package org.spongepowered.api.service.ban;

import org.spongepowered.api.entity.player.User;
import org.spongepowered.api.util.ban.Ban;

import java.net.InetAddress;
import java.util.Collection;

/**
 * Represents the service with which to ban users.
 */
public interface BanService {

    /**
     * Gets all bans registered.
     *
     * @return All registered bans
     */
    Collection<Ban> getBans();

    /**
     * Gets all user bans registered.
     *
     * @return All registered User bans
     */
    Collection<Ban.User> getUserBans();

    /**
     * Gets all IP bans registered.
     *
     * @return All registered IP bans
     */
    Collection<Ban.Ip> getIpBans();

    /**
     * Gets all bans registered to the given user.
     *
     * @param user The user
     * @return The bans
     */
    Collection<Ban.User> getBansFor(User user);

    /**
     * Gets all IP bans registered to the given address.
     *
     * @param address The address.
     * @return All registered IP bans
     */
    Collection<Ban.Ip> getBansFor(InetAddress address);

    /**
     * Checks if a user has any bans.
     *
     * @param user The user
     * @return True if the user has any bans, false otherwise
     */
    boolean isBanned(User user);

    /**
     * Checks if an IP has any bans.
     *
     * @param address The address
     * @return True if the address has any bans, false otherwise
     */
    boolean isBanned(InetAddress address);

    /**
     * Pardons a user, or removes all their bans.
     *
     * @param user The user
     */
    void pardon(User user);

    /**
     * Pardons an IP address, or removes all the bans against that IP.
     *
     * @param address The IP address
     */
    void pardon(InetAddress address);

    /**
     * Adds a ban.
     *
     * @param ban The ban to put on the user
     */
    void ban(Ban ban);

    /**
     * Pardons a ban.
     *
     * @param ban The ban
     */
    void pardon(Ban ban);

    /**
     * Checks if the specified ban has been set.
     *
     * @param ban The ban
     * @return True if the ban exists in this provider, false otherwise
     */
    boolean hasBan(Ban ban);

}
