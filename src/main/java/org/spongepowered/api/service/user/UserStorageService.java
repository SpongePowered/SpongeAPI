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
package org.spongepowered.api.service.user;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.profile.GameProfileManager;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Stores the persistent {@link User} data of a {@link Player}.
 */
public interface UserStorageService {

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
     * <p>Note that this method is resource-intensive depending on the amount of
     * stored data.</p>
     *
     * <p>Use {@link #get(GameProfile)} to get the {@link User} data
     * corresponding to a {@link GameProfile}.</p>
     *
     * @return A {@link Collection} of {@link GameProfile}s
     */
    Collection<GameProfile> getAll();

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
     * Returns a collection of matching {@link GameProfile}s with stored
     * {@link User} data whose last known user names start with the given string
     * (case-insensitive).
     *
     * <p>Use {@link #get(GameProfile)} to get the {@link User} data
     * corresponding to a {@link GameProfile}.</p>
     *
     * @param lastKnownName The user name
     * @return The result of the request
     */
    Collection<GameProfile> match(String lastKnownName);
}
