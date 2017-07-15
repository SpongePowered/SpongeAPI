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
import org.spongepowered.api.service.user.UserStorageService;

import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

/**
 * Represents a cache of {@link GameProfile}s.
 */
public interface GameProfileCache {

    /**
     * Add an entry to this cache.
     *
     * @param profile The profile to cache
     * @return {@code true} if the profile was successfully cached,
     *     otherwise {@code false}
     */
    default boolean add(GameProfile profile) {
        return this.add(profile, (Instant) null);
    }

    /**
     * Add an entry to this cache, with an optional expiration date.
     *
     * @param profile The profile to cache
     * @param expiry The expiration date
     * @return {@code true} if the profile was successfully cached,
     *     otherwise {@code false}
     * @deprecated Use {@link #add(GameProfile, Instant)}
     */
    @Deprecated
    default boolean add(GameProfile profile, @Nullable Date expiry) {
        return this.add(profile, expiry == null ? null : expiry.toInstant());
    }

    /**
     * Add an entry to this cache, with an optional expiration date.
     *
     * @param profile The profile to cache
     * @param expiry The expiration date
     * @return {@code true} if the profile was successfully cached,
     *     otherwise {@code false}
     */
    default boolean add(GameProfile profile, @Nullable Instant expiry) {
        return this.add(profile, false, expiry);
    }

    /**
     * Add an entry to this cache, with an optional expiration date.
     *
     * @param profile The profile to cache
     * @param overwrite If we should overwrite the cache entry for
     *      the provided profile
     * @param expiry The expiration date
     * @return {@code true} if the profile was successfully cached,
     *     otherwise {@code false}
     * @deprecated Use {@link #add(GameProfile, boolean, Instant)}
     */
    @Deprecated
    default boolean add(GameProfile profile, boolean overwrite, @Nullable Date expiry) {
        return this.add(profile, overwrite, expiry == null ? null : expiry.toInstant());
    }

    /**
     * Add an entry to this cache, with an optional expiration date.
     *
     * @param profile The profile to cache
     * @param overwrite If we should overwrite the cache entry for
     *      the provided profile
     * @param expiry The expiration date
     * @return {@code true} if the profile was successfully cached,
     *     otherwise {@code false}
     */
    boolean add(GameProfile profile, boolean overwrite, @Nullable Instant expiry);

    /**
     * Remove an entry from this cache.
     *
     * @param profile The profile to remove from the cache
     * @return {@code true} if the profile was successfully removed,
     *     otherwise {@code false}
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
     * Clear all entries from this cache.
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
     * Looks a {@link GameProfile} up by its unique id and
     * loads it into this cache.
     *
     * @param uniqueId The unique id of the profile
     * @return The profile, if present, or {@link Optional#empty()} if
     *     we couldn't find a profile with the provided id
     */
    Optional<GameProfile> lookupById(UUID uniqueId);

    /**
     * Looks up {@link GameProfile}s in bulk by their unique id and
     * loads them into this cache.
     *
     * @param uniqueIds The unique ids
     * @return A collection of successfully looked up profiles
     */
    Map<UUID, Optional<GameProfile>> lookupByIds(Iterable<UUID> uniqueIds);

    /**
     * Gets a {@link GameProfile} from this cache by its id if available,
     * or lookups the profile by its unique id.
     *
     * @param uniqueId The unique id of the profile
     * @return The profile, if present, or {@link Optional#empty()} if
     *     the cache did not contain a profile with the provided id and
     *     we couldn't lookup a profile with the provided id
     */
    Optional<GameProfile> getOrLookupById(UUID uniqueId);

    /**
     * Gets {@link GameProfile}s in bulk from this cache by when available,
     * and lookups the profiles by their unique id when not cached.
     *
     * @param uniqueIds The unique ids of the profiles
     * @return A collection of successfully found profiles
     */
    Map<UUID, Optional<GameProfile>> getOrLookupByIds(Iterable<UUID> uniqueIds);

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
     * Looks a {@link GameProfile} up by its name and
     * loads it into this cache.
     *
     * @param name The name of the profile
     * @return The profile, if present, or {@link Optional#empty()} if
     *     we couldn't find a profile with the provided name
     */
    Optional<GameProfile> lookupByName(String name);

    /**
     * Looks up {@link GameProfile}s in bulk by their name  and
     * loads them into this cache.
     *
     * @param names The names
     * @return A collection of successfully looked up profiles
     */
    Map<String, Optional<GameProfile>> lookupByNames(Iterable<String> names);

    /**
     * Gets a {@link GameProfile} from this cache by its if available,
     * or lookups the profile by its name.
     *
     * @param name The name of the profile
     * @return The profile, if present, or {@link Optional#empty()} if
     *     the cache did not contain a profile with the provided name and
     *     we couldn't lookup a profile with the provided name
     */
    Optional<GameProfile> getOrLookupByName(String name);

    /**
     * Gets {@link GameProfile}s in bulk from this cache by when available,
     * and lookups the profiles by their unique id when not cached.
     *
     * @param names The names of the profiles
     * @return A collection of successfully found profiles
     */
    Map<String, Optional<GameProfile>> getOrLookupByNames(Iterable<String> names);

    /**
     * Fills a {@link GameProfile} from cached values.
     *
     * @param profile The profile to fill
     * @return The filled profile, if present, or {@link Optional#empty()} if
     *     we were unable to fill the profile
     */
    default Optional<GameProfile> fillProfile(GameProfile profile) {
        return this.fillProfile(profile, false);
    }

    /**
     * Fills a {@link GameProfile} from cached values.
     *
     * @param profile The profile to fill
     * @param signed true if we should request that the profile data be signed
     * @return The filled profile, if present, or {@link Optional#empty()} if
     *     we were unable to fill the profile
     */
    Optional<GameProfile> fillProfile(GameProfile profile, boolean signed);

    /**
     * Gets a collection of all cached {@link GameProfile}s.
     *
     * @return A {@link Collection} of cached {@link GameProfile}s
     */
    Collection<GameProfile> getProfiles();

    /**
     * Returns a collection of matching cached {@link GameProfile}s whose last
     * known names start with the given string (case-insensitive).
     *
     * <p>This collection may also contain profiles of players who never played
     * on the server!</p>
     *
     * <p>Use {@link UserStorageService#match(String)} for a collection that
     * only contains {@link GameProfile}s with attached {@link User} data.</p>
     *
     * <p>This method only searches the local cache, so the data may not be up
     * to date.</p>
     *
     * @param name The name
     * @return A {@link Collection} of matching {@link GameProfile}s
     */
    Collection<GameProfile> match(String name);

}
