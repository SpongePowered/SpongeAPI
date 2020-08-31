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
package org.spongepowered.api.service.ban;

import org.spongepowered.api.profile.GameProfile;

import java.net.InetAddress;
import java.util.Collection;
import java.util.Optional;

/**
 * Represents a service with which to ban things, such as {@link GameProfile}s or IP addresses.
 *
 * <p>Implementors of this service should treat expired bans as non-existent,
 * even if they choose to retain them in a way not accessible through the ban
 * service API (e.g. writing them to a database). In essence, expired bans
 * should be treated the same as user-removed bans.
 *
 * <p>For example, {@link #getBans()} would not include any expired bans,
 * and {@link #hasBan(Ban)} would return <code>false</code>.</p>
 */
public interface BanService {

    /**
     * Gets all bans registered.
     *
     * @return All registered bans
     */
    Collection<? extends Ban> getBans();

    /**
     * Gets all {@link GameProfile} bans registered.
     *
     * @return All registered {@link GameProfile} bans
     */
    Collection<Ban.Profile> getProfileBans();

    /**
     * Gets all IP bans registered.
     *
     * @return All registered IP bans
     */
    Collection<Ban.Ip> getIpBans();

    /**
     * Gets the ban for the given {@link GameProfile}, if available.
     *
     * @param profile The profile
     * @return The ban, if available
     */
    Optional<Ban.Profile> getBanFor(GameProfile profile);

    /**
     * Gets the ban for the given address, if available.
     *
     * @param address The address.
     * @return All registered IP bans
     */
    Optional<Ban.Ip> getBanFor(InetAddress address);

    /**
     * Checks if a {@link GameProfile} has a ban.
     *
     * @param profile The profile
     * @return True if the profile has a ban, false otherwise
     */
    boolean isBanned(GameProfile profile);

    /**
     * Checks if an IP has a ban.
     *
     * @param address The address
     * @return True if the address has a ban, false otherwise
     */
    boolean isBanned(InetAddress address);

    /**
     * Pardons a profile, or removes its ban, if present.
     *
     * @param profile The profile
     * @return Whether the profile had a ban present
     */
    boolean pardon(GameProfile profile);

    /**
     * Pardons an IP address, or removes its ban, if present.
     *
     * @param address The IP address
     * @return Whether the address had a ban present
     */
    boolean pardon(InetAddress address);

    /**
     * Removes a ban.
     *
     * @param ban The ban
     * @return Whether the ban was present in this ban service
     */
    boolean removeBan(Ban ban);

    /**
     * Adds a ban.
     *
     * <p>If the GameProfile or IP address of the ban already has a ban set,
     * the passed in ban will replace the existing ban.</p>
     *
     * @param ban The ban to add to this ban service
     * @return The previous ban, if available
     */
    Optional<? extends Ban> addBan(Ban ban);

    /**
     * Checks if the specified ban is present.
     *
     * @param ban The ban
     * @return True if the ban exists in this ban service, false otherwise
     */
    boolean hasBan(Ban ban);

}
