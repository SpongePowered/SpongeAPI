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
package org.spongepowered.api.user;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.profile.GameProfileManager;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * Stores the persistent {@link User} data of a {@link Player}.
 *
 * <p>Any {@link User}s retrieved from this manager should not be stored, as
 * they may become invalid at any time.</p>
 */
public interface UserManager {

    /**
     * Gets the data of a {@link User} by their unique id.
     *
     * @param uniqueId The UUID of the user
     * @return {@link User} or Optional.empty() if not found
     */
    CompletableFuture<Optional<User>> load(UUID uniqueId);

    /**
     * Gets the data of a {@link User} by their last known user name
     * (case-insensitive).
     *
     * <p>To get the current name of a player, use the
     * {@link GameProfileManager} service.</p>
     *
     * @param lastKnownName The user name
     * @return {@link User} or Optional.empty() if not found
     */
    CompletableFuture<Optional<User>> load(String lastKnownName);

    /**
     * Gets the data of a {@link User} by their {@link GameProfile}.
     *
     * @param profile The profile
     * @return {@link User} or Optional.empty() if not found
     */
    CompletableFuture<Optional<User>> load(GameProfile profile);

    /**
     * Gets or creates a persistent {@link User} with the given UUID.
     *
     * @param uuid The {@link UUID} of the player to load or create.
     * @return The user object
     */
    CompletableFuture<User> loadOrCreate(UUID uuid);

    /**
     * Deletes the data associated with a {@link User}, if the player is
     * offline.
     *
     * @param uuid The uuid of the user to delete
     * @return true if the deletion was successful
     */
    CompletableFuture<Boolean> delete(UUID uuid);

    /**
     * If the implementation supports caching user objects, this will hint
     * to the implementation that the user with the given UUID should no
     * longer be cached. Any {@link User} objects held that this point
     * will become invalid (though developers should not be storing
     * users).
     *
     * <p>Be aware, any changes that have been made to the user may not
     * be saved.</p>
     *
     * <p>Users that are online will not be affected by this call.</p>
     *
     * @param uuid The UUID of the user to save.
     * @return {@code true} if the user was removed from a cache.
     */
    boolean removeFromCache(UUID uuid);

    /**
     * If the implementation supports caching user objects, this will hint
     * to the implementation that the user with the given UUID should be saved
     * to the disk immediately.
     *
     * <p>If an exception is encountered during save, the completed future
     * will be exceptional and the boolean will be {@code null}. It is therefore
     * recommended that you check for any exceptions this future holds.</p>
     *
     * @param uuid The user to attempt to save.
     * @return A completed future that returns {@code true} if the implementation
     *         saved the user.
     */
    CompletableFuture<Boolean> forceSave(UUID uuid);

    /**
     * Returns whether data to create a {@link User} exists for a given
     * player with a specified {@link UUID}.
     *
     * <p>If this is {@code false}, then {@link #load(UUID)} will return
     * an {@linkplain Optional#empty() empty optional}.</p>
     *
     * @param playerUuid The {@link UUID} of the player to check.
     * @return If the player has existing user data that can be loaded.
     */
    boolean exists(UUID playerUuid);

    /**
     * Gets a {@link Stream} that returns a {@link GameProfile} for each stored
     * {@link User}s.
     *
     * <p>This {@link Stream} may contain profiles that only hold a result for
     * {@link GameProfile#uniqueId()}, that is, do not return a user's name.
     * Such profiles should thus be treated as incomplete and are no more than
     * an indicator that a {@link User} associated with the given {@link UUID}
     * exists.</p>
     *
     * <p>Similarly, for {@link GameProfile}s that are filled and thus contain
     * name data, the profile information is based on the latest information
     * the server holds and no attempt is made to update this information.</p>
     *
     * <p>If you require up to date {@link GameProfile}s, use the appropriate
     * methods on the {@link GameProfileManager} and/or its associated
     * {@link GameProfileManager}.</p>
     *
     * <p>Use {@link #load(GameProfile)} to load the {@link User} data associated
     * with the associated {@link GameProfile}.</p>
     *
     * @return A {@link Stream} of {@link GameProfile}s
     */
    Stream<GameProfile> streamAll();

    /**
     * Gets a {@link Stream} that returns a {@link GameProfile} for each stored
     * {@link User} whose last known user names start with the given string
     * (case-insensitive).
     *
     * <p>It is important to note that the names this method uses to perform the
     * matching is based on the latest information the server holds and no
     * attempt is made to update this information.</p>
     *
     * <p>If you require up to date {@link GameProfile}s, use the appropriate
     * methods on the {@link GameProfileManager} and/or its associated
     * {@link GameProfileManager}.</p>
     *
     * <p>Use {@link #load(GameProfile)} to load associated {@link User} data.
     * </p>
     *
     * @param lastKnownName The name to check for
     * @return A {@link Stream} of {@link GameProfile}s
     */
    Stream<GameProfile> streamOfMatches(String lastKnownName);
}
