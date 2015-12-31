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
package org.spongepowered.api.service.permission;

import org.spongepowered.api.service.context.ContextCalculator;
import org.spongepowered.api.service.context.ContextualService;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;


/**
 * Represents a provider for permissions. This is the interface that a
 * permissions plugin must implement to provide permissions for a user.
 */
public interface PermissionService extends ContextualService<Subject> {

    String SUBJECTS_USER = "user";
    String SUBJECTS_GROUP = "group";
    String SUBJECTS_SYSTEM = "system";
    String SUBJECTS_COMMAND_BLOCK = "commandblock";
    String SUBJECTS_ROLE_TEMPLATE = "role-template";

    /**
     * Returns the permissions level that describes users. User identifiers are
     * expected to be UUIDs in RFC4122 string format (This *does* have dashes.
     * Mojang is stupid).
     *
     * @return A subject collection for users
     */
    SubjectCollection getUserSubjects();

    /**
     * Returns the collection of group subjects available.
     *
     * @return A collection managing group subjects
     */
    SubjectCollection getGroupSubjects();

    /**
     * This is a transient data object that contains data that will be applied
     * by default to all subjects.
     *
     * @return The default data object, which will accept modifications but which is transient
     */
    SubjectData getDefaultData();

    /**
     * Returns a subject collection with the given identifier.
     *
     * @param identifier The identifier
     * @return a subject collection for this type of subject
     */
    SubjectCollection getSubjects(String identifier);

    /**
     * Returns an immutable copy of the mapping of all subject collections
     * stored by this permission service.
     *
     * @return The known subjects for this map
     */
    Map<String, SubjectCollection> getKnownSubjects();

    /**
     * Creates a new description builder for the given plugin's permission. May
     * return {@link Optional#empty()} if the service does not support
     * {@link PermissionDescription}s.
     *
     * @param plugin The plugin to create permission descriptions for
     * @return The newly created permission description builder, if supported
     */
    Optional<PermissionDescription.Builder> newDescriptionBuilder(Object plugin);

    /**
     * Gets the registered or generated {@link PermissionDescription} for the
     * given permission if available. If the given permission is not defined
     * itself this might also return the associated permission template.
     *
     * @param permission The permission to get the description for
     * @return The description for the given permission or
     *         {@link Optional#empty()}
     */
    Optional<PermissionDescription> getDescription(String permission);

    /**
     * Gets a immutable collection containing all registered or generated
     * {@link PermissionDescription}s.
     *
     * @return An immutable collection contain all registered or generated
     *         descriptions
     */
    Collection<PermissionDescription> getDescriptions();

}
