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

import org.checkerframework.checker.nullness.qual.Nullable;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * A provider which can be used to lookup {@link GameProfile}s.
 */
public interface GameProfileProvider {

    /**
     * Attempts to get a basic {@link GameProfile} for the given unique id.
     *
     * <p>Basic game profiles don't include any profile properties.</p>
     *
     * <p>The {@link CompletableFuture} can fail with a
     * {@link ProfileNotFoundException} if no profile was found with the
     * given unique id.</p>
     *
     * @param uniqueId The unique id
     * @return The profile found for the given unique id
     */
    CompletableFuture<GameProfile> getBasicProfile(UUID uniqueId);

    /**
     * Attempts to get a basic {@link GameProfile} for the given name.
     *
     * <p>Basic game profiles don't include any profile properties.</p>
     *
     * <p>The {@link CompletableFuture} can fail with a
     * {@link ProfileNotFoundException} if no profile was found with the
     * given name.</p>
     *
     * <p>The requested name is matched case insensitively, the corrected
     * name will be present in the {@link GameProfile}.</p>
     *
     * @param name The name
     * @return The profile found for the given name
     */
    default CompletableFuture<GameProfile> getBasicProfile(final String name) {
        return this.getBasicProfile(name, null);
    }

    /**
     * Attempts to get a basic {@link GameProfile} for the given name.
     *
     * <p>Basic game profiles don't include any profile properties.</p>
     *
     * <p>The {@link CompletableFuture} can fail with a
     * {@link ProfileNotFoundException} if no profile was found with the
     * given name.</p>
     *
     * <p>The requested name is matched case insensitively, the corrected
     * name will be present in the {@link GameProfile}.</p>
     *
     * @param name The name
     * @param time The time at which the name was assigned to a specific profile, or null if current
     * @return The profile found for the given name
     */
    CompletableFuture<GameProfile> getBasicProfile(String name, @Nullable Instant time);

    /**
     * Attempts to get a basic {@link GameProfile}s for the given names.
     *
     * <p>Basic game profiles don't include any profile properties.</p>
     *
     * <p>The requested names are matched case insensitively, the corrected
     * names will be present in the {@link GameProfile}s.</p>
     *
     * @param names The names
     * @return The profiles found for the given names
     */
    default CompletableFuture<Map<String, GameProfile>> getBasicProfiles(final Iterable<String> names) {
        return this.getBasicProfiles(names, null);
    }

    /**
     * Attempts to get a basic {@link GameProfile}s for the given names.
     *
     * <p>Basic game profiles don't include any profile properties.</p>
     *
     * <p>The requested names are matched case insensitively, the corrected
     * names will be present in the {@link GameProfile}s.</p>
     *
     * @param names The names
     * @param time The time at which the names were assigned to specific profiles, or null if current
     * @return The profiles found for the given names
     */
    CompletableFuture<Map<String, GameProfile>> getBasicProfiles(Iterable<String> names, @Nullable Instant time);

    /**
     * Attempts to get a full {@link GameProfile} for the given profile.
     *
     * <p>The {@link CompletableFuture} can fail with a
     * {@link ProfileNotFoundException} if no profile was found with the
     * unique id of the given profile.</p>
     *
     * @param profile The profile
     * @return The profile found for the given unique id
     */
    default CompletableFuture<GameProfile> getProfile(final GameProfile profile) {
        return this.getProfile(profile.getUniqueId(), true);
    }

    /**
     * Attempts to get a full {@link GameProfile} for the given profile.
     *
     * <p>The {@link CompletableFuture} can fail with a
     * {@link ProfileNotFoundException} if no profile was found with the
     * unique id of the given profile.</p>
     *
     * @param profile The profile
     * @param signed Whether property values should be signed
     * @return The profile found for the given unique id
     */
    default CompletableFuture<GameProfile> getProfile(final GameProfile profile, final boolean signed) {
        return this.getProfile(profile.getUniqueId(), signed);
    }

    /**
     * Attempts to get a full {@link GameProfile} for the given name.
     *
     * <p>The {@link CompletableFuture} can fail with a
     * {@link ProfileNotFoundException} if no profile was found with the
     * given name.</p>
     *
     * @param name The name
     * @return The profile found for the given name
     */
    default CompletableFuture<GameProfile> getProfile(final String name) {
        return this.getProfile(name, true);
    }

    /**
     * Attempts to get a full {@link GameProfile} for the given unique id.
     *
     * <p>The {@link CompletableFuture} can fail with a
     * {@link ProfileNotFoundException} if no profile was found with the
     * given unique id.</p>
     *
     * @param uniqueId The unique id
     * @return The profile found for the given unique id
     */
    default CompletableFuture<GameProfile> getProfile(final UUID uniqueId) {
        return this.getProfile(uniqueId, true);
    }

    /**
     * Attempts to get a full {@link GameProfile} for the given name.
     *
     * <p>The {@link CompletableFuture} can fail with a
     * {@link ProfileNotFoundException} if no profile was found with the
     * given name.</p>
     *
     * @param name The name
     * @param signed Whether property values should be signed
     * @return The profile found for the given name
     */
    CompletableFuture<GameProfile> getProfile(String name, boolean signed);

    /**
     * Attempts to get a full {@link GameProfile} for the given unique id.
     *
     * <p>The {@link CompletableFuture} can fail with a
     * {@link ProfileNotFoundException} if no profile was found with the
     * given unique id.</p>
     *
     * @param uniqueId The unique id
     * @param signed Whether property values should be signed
     * @return The profile found for the given unique id
     */
    CompletableFuture<GameProfile> getProfile(UUID uniqueId, boolean signed);
}
