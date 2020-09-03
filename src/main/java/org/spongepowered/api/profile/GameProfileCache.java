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
package org.spongepowered.api.profile;

import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.user.UserManager;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Represents a cache of profile data.
 */
public interface GameProfileCache {

    /**
     * Remove entries from this cache in bulk.
     *
     * @param profile The profile to remove from the cache
     * @return Whether the profile was successfully removed
     */
    boolean remove(GameProfile profile);

    /**
     * Remove entries from this cache in bulk.
     *
     * @param profiles The profiles to remove from the cache
     * @return A collection of profiles successfully removed
     */
    Collection<GameProfile> remove(Iterable<GameProfile> profiles);

    /**
     * Remove entries from this cache in bulk.
     *
     * @param filter The filter which will be used to selected profiles to be removed
     * @return A collection of profiles successfully removed
     */
    Collection<GameProfile> removeIf(Predicate<GameProfile> filter);

    /**
     * Clears all the entries from this cache.
     */
    void clear();

    /**
     * Gets a {@link GameProfile} from this cache by its unique id.
     *
     * @param uniqueId The unique id of the profile
     * @return The profile, if present, or {@link Optional#empty()} if
     *     the cache did not contain a profile with the provided id
     */
    Optional<GameProfile> getById(UUID uniqueId);

    /**
     * Gets {@link GameProfile}s in bulk by their unique id.
     *
     * @param uniqueIds The unique ids
     * @return A collection of successfully found up profiles
     */
    Map<UUID, Optional<GameProfile>> getByIds(Iterable<UUID> uniqueIds);

    /**
     * Gets a {@link GameProfile} from this cache by its name.
     *
     * @param name The name of the profile
     * @return The profile, if present, or {@link Optional#empty()} if
     *     the cache did not contain a profile with the provided name
     */
    Optional<GameProfile> getByName(String name);

    /**
     * Gets {@link GameProfile}s in bulk by their name.
     *
     * @param names The names
     * @return A collection of successfully found up profiles
     */
    Map<String, Optional<GameProfile>> getByNames(Iterable<String> names);

    /**
     * Gets a collection of all cached {@link GameProfile}s.
     *
     * @return A {@link Collection} of cached {@link GameProfile}s
     */
    Collection<GameProfile> all();

    /**
     * Gets a {@link Stream} of all cached {@link GameProfile}s.
     *
     * @return A {@link Stream} of cached {@link GameProfile}s
     */
    Stream<GameProfile> stream();

    /**
     * Returns a collection of matching cached {@link GameProfile}s whose last
     * known names start with the given string (case-insensitive).
     *
     * <p>This collection may also contain profiles of players who never played
     * on the server. If you would prefer a collection or stream of known
     * profiles that also have {@link User} data,
     * {@link UserManager#streamOfMatches(String)} should be used instead.</p>
     *
     * @param name The name
     * @return A {@link Collection} of matching {@link GameProfile}s
     */
    Collection<GameProfile> allMatches(final String name);

    /**
     * Returns a stream of matching cached {@link GameProfile}s whose last
     * known names start with the given string (case-insensitive).
     *
     * <p>This stream may also return profiles of players who never played
     * on the server. If you would prefer only known profiles that also have
     * {@link User} data, {@link UserManager#streamOfMatches(String)} should
     * be used instead.</p>
     *
     * @param name The name
     * @return A {@link Stream} of matching {@link GameProfile}s
     */
    Stream<GameProfile> streamOfMatches(String name);
}
