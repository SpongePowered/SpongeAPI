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

import org.spongepowered.api.service.permission.context.Context;

import java.util.Map;
import java.util.Set;

/**
 * Object that manages subjects of a certain type (user, group, etc).
 */
public interface SubjectCollection {

    /**
     * Return the identifier for the type of subjects this collection contains.
     *
     * @return The appropriate identifier
     */
    String getIdentifier();

    /**
     * Returns the subject specified. Will not return null.
     *
     * @param identifier The identifier to look up a subject by.
     *                   Case-insensitive
     * @return A stored subject if present, otherwise a subject that may be
     *         stored if data is changed from defaults
     */
    Subject get(String identifier);

    /**
     * Returns whether there is any data stored for the given subject. The
     * return value of this function does not influence whether or not the
     * result from {@link #get(String)} should be queried.
     *
     * @param identifier The identifier of the given subject
     * @return whether any data is stored
     */
    boolean hasRegistered(String identifier);

    /**
     * Returns all subjects. The iterator provided by this method may be
     * populated asynchronously. Be aware that for large collections this method
     * may be very resource-intensive
     *
     * @return An iterable providing all subjects stored by this collection.
     */
    Iterable<Subject> getAllSubjects();

    /**
     * Return all known subjects with the given permission information. Because
     * no context is passed, only subjects who have this permission globally or
     * subjects which have accurate context calculations are returned.
     *
     * @param permission The permission to check
     * @return Any subject known to have this permission set, and the value this
     *         permission is set to
     */
    Map<Subject, Boolean> getAllWithPermission(String permission);

    /**
     * Return all known subjects with the given permission information.
     *
     * @param contexts The context combination to check for permissions in
     * @param permission The permission to check
     * @return Any subject known to have this permission set, and the value this
     *         permission is set to
     */
    Map<Subject, Boolean> getAllWithPermission(Set<Context> contexts, String permission);
}
