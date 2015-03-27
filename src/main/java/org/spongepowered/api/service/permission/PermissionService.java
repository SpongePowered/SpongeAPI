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
import org.spongepowered.api.service.permission.context.ContextCalculator;

import java.util.Map;


/**
 * Represents a provider for permissions. This is the interface that a
 * permissions plugin must implement to provide permissions for a user.
 */
public interface PermissionService {

    String SUBJECTS_USER = "user";
    String SUBJECTS_GROUP = "group";
    String SUBJECTS_SYSTEM = "system";
    String SUBJECTS_COMMAND_BLOCK = "commandblock";

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
     * Register a function that calculates contexts relevant to a given user at
     * the time the function is called.
     *
     * @param calculator The context calculator to register
     */
    void registerContextCalculator(ContextCalculator calculator);
}
