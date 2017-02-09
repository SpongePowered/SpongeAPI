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

import org.spongepowered.api.profile.property.ProfileProperty;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.annotation.Nullable;

/**
 * Manages {@link GameProfile} creation and data population.
 *
 * <p>The manager may cache the data of a request for faster lookups. Note that
 * the cached data may not always be up to date.</p>
 */
public interface GameProfileManager {

    /**
     * Creates a {@link GameProfile} from the provided ID and name.
     *
     * @param uniqueId The unique ID
     * @param name The name
     * @return The created profile
     * @see GameProfile#of(UUID, String)
     */
    GameProfile createProfile(UUID uniqueId, @Nullable String name);

    /**
     * Creates a {@link ProfileProperty} from the provided name, value,
     * and optional signature.
     *
     * @param name The name for the property
     * @param value The value of the property
     * @param signature The signature of the property
     * @return The created profile property
     * @see ProfileProperty#of(String, String)
     * @see ProfileProperty#of(String, String, String)
     */
    ProfileProperty createProfileProperty(String name, String value, @Nullable String signature);

    /**
     * Looks up a {@link GameProfile} by its unique ID.
     *
     * <p>This method checks the local profile cache before contacting the
     * profile servers. Use {@link #get(UUID, boolean)} to disable the cache
     * lookup.</p>
     *
     * <p>The returned {@link CompletableFuture} throws an {@link ExecutionException}
     * caused by a {@link ProfileNotFoundException} if the profile does not exist or
     * an {@link IOException} if a network error occurred.</p>
     *
     * @param uniqueId The unique ID
     * @return The result of the request
     */
    default CompletableFuture<GameProfile> get(UUID uniqueId) {
        return this.get(uniqueId, true);
    }

    /**
     * Looks up a {@link GameProfile} by its user name (case-insensitive).
     *
     * <p>This method checks the local profile cache before contacting the
     * profile servers. Use {@link #get(String, boolean)} to disable the cache
     * lookup.</p>
     *
     * <p>The returned {@link CompletableFuture} throws an {@link ExecutionException}
     * caused by a {@link ProfileNotFoundException} if the profile does not exist or
     * an {@link IOException} if a network error occurred.</p>
     *
     * @param name The username
     * @return The result of the request
     */
    default CompletableFuture<GameProfile> get(String name) {
        return this.get(name, true);
    }

    /**
     * Looks up a {@link GameProfile} by its unique ID.
     *
     * <p>The returned {@link CompletableFuture} throws an {@link ExecutionException}
     * caused by a {@link ProfileNotFoundException} if the profile does not exist or
     * an {@link IOException} if a network error occurred.</p>
     *
     * @param uniqueId The unique ID
     * @param useCache true to perform a cache lookup first
     * @return The result of the request
     */
    CompletableFuture<GameProfile> get(UUID uniqueId, boolean useCache);

    /**
     * Looks up a {@link GameProfile} by its user name (case-insensitive).
     *
     * <p>The returned {@link CompletableFuture} throws an {@link ExecutionException}
     * caused by a {@link ProfileNotFoundException} if the profile does not exist or
     * an {@link IOException} if a network error occurred.</p>
     *
     * @param name The username
     * @param useCache true to perform a cache lookup first
     * @return The result of the request
     */
    CompletableFuture<GameProfile> get(String name, boolean useCache);

    /**
     * Gets a collection of {@link GameProfile}s by their unique IDs.
     *
     * <p>The returned {@link CompletableFuture} throws an {@link ExecutionException}
     * caused by a {@link ProfileNotFoundException} if the profile does not exist or
     * an {@link IOException} if a network error occurred.</p>
     *
     * @param uniqueIds The UUIDs
     * @param useCache true to perform a cache lookup first
     * @return The result of the request
     */
    CompletableFuture<Collection<GameProfile>> getAllById(Iterable<UUID> uniqueIds, boolean useCache);

    /**
     * Gets a collection of {@link GameProfile}s by their user names
     * (case-insensitive).
     *
     * <p>The returned {@link CompletableFuture} throws an {@link ExecutionException}
     * caused by a {@link ProfileNotFoundException} if the profile does not exist or
     * an {@link IOException} if a network error occurred.</p>
     *
     * @param names The user names
     * @param useCache true to perform a cache lookup first
     * @return The result of the request
     */
    CompletableFuture<Collection<GameProfile>> getAllByName(Iterable<String> names, boolean useCache);

    /**
     * Fills a {@link GameProfile}.
     *
     * <p>The returned {@link CompletableFuture} throws an {@link ExecutionException}
     * caused by a {@link ProfileNotFoundException} if the profile does not exist or
     * an {@link IOException} if a network error occurred.</p>
     *
     * @param profile The profile to fill
     * @return The result of the request
     */
    default CompletableFuture<GameProfile> fill(GameProfile profile) {
        return this.fill(profile, false);
    }

    /**
     * Fills a {@link GameProfile}.
     *
     * <p>The returned {@link CompletableFuture} throws an {@link ExecutionException}
     * caused by a {@link ProfileNotFoundException} if the profile does not exist or
     * an {@link IOException} if a network error occurred.</p>
     *
     * @param profile The profile to fill
     * @param signed true if we should request that the profile data be signed
     * @return The result of the request
     */
    default CompletableFuture<GameProfile> fill(GameProfile profile, boolean signed) {
        return this.fill(profile, signed, true);
    }

    /**
     * Fills a {@link GameProfile}.
     *
     * <p>The returned {@link CompletableFuture} throws an {@link ExecutionException}
     * caused by a {@link ProfileNotFoundException} if the profile does not exist or
     * an {@link IOException} if a network error occurred.</p>
     *
     * @param profile The profile to fill
     * @param signed true if we should request that the profile data be signed
     * @param useCache true to perform a cache lookup first
     * @return The result of the request
     */
    CompletableFuture<GameProfile> fill(GameProfile profile, boolean signed, boolean useCache);

    /**
     * Gets the active {@link GameProfile} cache.
     *
     * @return The active cache
     */
    GameProfileCache getCache();

    /**
     * Sets the {@link GameProfile} cache.
     *
     * <p>To restore the original cache, pass the result of {@link #getDefaultCache()}.</p>
     *
     * @param cache The new cache
     */
    void setCache(GameProfileCache cache);

    /**
     * Gets the default cache.
     *
     * @return The default cache.
     */
    GameProfileCache getDefaultCache();

}
