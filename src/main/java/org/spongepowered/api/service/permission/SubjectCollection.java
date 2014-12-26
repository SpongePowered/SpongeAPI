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

/**
 * Object that manages subjects of a certain type (user, group, etc{}
 */
public interface SubjectCollection {

    /**
     * Gets the type of subjects contained in this collection.
     *
     * @return The type of subjects contained in this collection
     */
    SubjectType getSubjectType();

    /**
     * Checks whether the given {@link Subject}'s identifier is contained
     * subject collection.
     *
     * @param identifier The subject's identifier to check
     * @return True if the subject's identifier is contained in this collection
     */
    boolean hasRegistered(String identifier);

    /**
     * Gets the {@link Subject} with the given identifier.
     *
     * @param identifier The identifier for the subject
     * @return The subject with the given identifier, if available or created
     */
    Optional<Subject> get(String identifier);

    /**
     * Checks whether the given {@link Subject} is contained in the subject
     * collection.
     *
     * @param subject The subject to check
     * @return True if the subject is contained in this collection
     */
    boolean contains(Subject subject);

    /**
     * Get all {@link Subject}s contained in this subject collection.
     * <p>
     * <b>Note:</b> This method may work asynchronously!
     * </p>
     *
     * @return An iterable containing all subjects
     */
    Iterable<Subject> getAllSubjects();

}
