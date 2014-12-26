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
package org.spongepowered.api.service.permission;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableCollection;
import org.spongepowered.api.service.permission.context.Context;
import org.spongepowered.api.service.permission.context.ContextCalculator;
import org.spongepowered.api.text.message.Message;

/**
 * Simple server that can be used to get subjects for offline and online
 * players, groups and registering new permissions.
 */
public interface PermissionService {

    /**
     * Registers a permission with the given string and description.
     * <p>
     * <b>Note:</b> This only registers the description. After this method is
     * called the default values should be added to the default
     * {@link SubjectGroup} listed in {@link SubjectGroups} to allow permission
     * plugins to use those groups as fallback if they don't have the permission
     * specified internally.
     * </p>
     *
     * @param permission The permission string
     * @param description The description for the permission
     * @see SubjectGroups
     */
    void registerPermission(String permission, Message description);

    /**
     * Gets all registered permissions with the given prefix.
     *
     * @param prefix The prefix to search
     * @return An immutable collection containing all permissions with the given
     *         prefix
     */
    ImmutableCollection<String> getRegisteredPermissions(String prefix);

    /**
     * Gets all registered permissions.
     *
     * @return An immutable collection containing all permissions
     */
    ImmutableCollection<String> getRegisteredPermissions();

    /**
     * Gets the description belonging to the given permission.
     *
     * @param permission The permission string
     * @return The description belonging to the given permission
     */
    Optional<Message> getDescription(String permission);

    /**
     * Gets a {@link SubjectCollection} containing all user {@link Subject}s
     * that are online or have persistent data/have been stored.
     *
     * @return A subject collection containing all users
     */
    public SubjectCollection getUserSubjects();

    /**
     * Gets a {@link SubjectCollection} containing all group {@link Subject}s
     * that are currently available.
     *
     * @return A subject collection containing all groups
     */
    public SubjectCollection getGroupSubjects();

    /**
     * ?????
     */
    public void registerContextCalculator(ContextCalculator calculator);

    /**
     * Gets a {@link SubjectCollection} containing {@link Subject}s of the
     * specified type, which are not limited to a single {@link Context}. Useful
     * for user collections.
     *
     * @param type The type of subjects this subject collection should contain
     * @return The subject collection
     */
    public Optional<SubjectCollection> getSubjects(SubjectType type);

    /**
     * Gets a {@link SubjectCollection} containing {@link Subject}s of the
     * specified type, which are limited to a single {@link Context}. Useful for
     * per world group collections.
     *
     * @param type The type of subjects this subject collection should contain
     * @param context The context for the user collection
     * @return The subject collection
     */
    public Optional<SubjectCollection> getSubjects(SubjectType type, Context context);

}
