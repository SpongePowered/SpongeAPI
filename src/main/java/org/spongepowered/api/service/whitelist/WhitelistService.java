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
package org.spongepowered.api.service.whitelist;

import org.spongepowered.api.Server;
import org.spongepowered.api.profile.GameProfile;

import java.util.Collection;

/**
 * Represents the service for managing a whitelist of {@link GameProfile}s.
 *
 * <p>In Vanilla, the service is controlled by {@link Server#hasWhitelist()}.
 * Additionally, operators are always allowed to join, regardless of their
 * absence or presence on the whitelist service.</p>
 */
public interface WhitelistService {

    /**
     * Gets the collection of {@link GameProfile}s present on this whitelist.
     *
     * @return The {@link GameProfile}s present on this whitelist
     */
    Collection<GameProfile> getWhitelistedProfiles();

    /**
     * Gets whether the specified {@link GameProfile} is present on this
     * whitelist.
     *
     * @param profile The game profile to check for
     * @return Whether the specified {@link GameProfile} is present on this
     *         whitelist
     */
    boolean isWhitelisted(GameProfile profile);

    /**
     * Adds the specified {@link GameProfile} to this whitelist.
     *
     * @param profile The game profile to add
     * @return Whether the specified {@link GameProfile} was already present on
     *         this whitelist
     */
    boolean addProfile(GameProfile profile);

    /**
     * Removes the specified {@link GameProfile} from this whitelist, if present.
     *
     * @param profile The game profile to remove
     * @return Whether the specified {@link GameProfile} was present before
     *         removal
     */
    boolean removeProfile(GameProfile profile);
}
