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

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Stores the persistent {@link User} data of a {@link Player}.
 */
public interface UserManager {

    /**
     * Gets the data of a {@link User} by their unique id.
     *
     * @param uniqueId The UUID of the user
     * @return {@link User} or Optional.empty() if not found
     */
    Optional<User> get(UUID uniqueId);

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
    Optional<User> get(String lastKnownName);

    /**
     * Gets the data of a {@link User} by their {@link GameProfile}.
     *
     * @param profile The profile
     * @return {@link User} or Optional.empty() if not found
     */
    Optional<User> get(GameProfile profile);

    /**
     * Gets or creates a persistent {@link User} associated with the given
     * {@link GameProfile}.
     *
     * <p>To obtain a {@link GameProfile}, use the {@link GameProfileManager}.
     * </p>
     *
     * @param profile The profile
     * @return The user object
     */
    User getOrCreate(GameProfile profile);

    /**
     * Gets the collection of all {@link GameProfile}s with stored {@link User}
     * data.
     *
     * <p>This method may be resource intensive, particularly for servers that
     * have a large number of {@link User}s. If you require a subset of this
     * {@link Collection}, use {@link #streamOfMatches(String)} or
     * {@link #streamAll()} and use {@link Stream} operations for your queries
     * instead.</p>
     *
     * <p>This {@link Stream} may contain profiles that only hold a result for
     * {@link GameProfile#getUniqueId()}, that is, do not return a user's name.
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
     * {@link GameProfileCache}.</p>
     *
     * <p>Use {@link #get(GameProfile)} to load the {@link User} data associated
     * with the associated {@link GameProfile}.</p>
     *
     * @return A {@link Stream} of {@link GameProfile}s
     */
    Collection<GameProfile> getAll();

    /**
     * Gets a {@link Stream} that returns a {@link GameProfile} for each stored
     * {@link User}s.
     *
     * <p>This {@link Stream} may contain profiles that only hold a result for
     * {@link GameProfile#getUniqueId()}, that is, do not return a user's name.
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
     * {@link GameProfileCache}.</p>
     *
     * <p>Use {@link #get(GameProfile)} to load the {@link User} data associated
     * with the associated {@link GameProfile}.</p>
     *
     * @return A {@link Stream} of {@link GameProfile}s
     */
    Stream<GameProfile> streamAll();

    /**
     * Deletes the data associated with a {@link User}.
     *
     * <p>This may not work if the user is logged in.</p>
     *
     * @param profile The profile of the user to delete
     * @return true if the deletion was successful
     */
    boolean delete(GameProfile profile);

    /**
     * Deletes the data associated with a {@link User}.
     *
     * <p>This may not work if the user is logged in.</p>
     *
     * @param user The user to delete
     * @return true if the deletion was successful
     */
    boolean delete(User user);

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
     * {@link GameProfileCache}.</p>
     *
     * <p>Use {@link #get(GameProfile)} to load associated {@link User} data.
     * </p>
     *
     * @param lastKnownName The name to check for
     * @return A {@link Stream} of {@link GameProfile}s
     */
    Stream<GameProfile> streamOfMatches(String lastKnownName);
}
