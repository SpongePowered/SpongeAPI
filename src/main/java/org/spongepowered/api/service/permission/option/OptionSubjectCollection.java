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
package org.spongepowered.api.service.permission.option;

import org.spongepowered.api.service.permission.context.Context;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.service.permission.SubjectCollection;

import java.util.Map;
import java.util.Set;

/**
 * Object that manages option subjects of a certain type (user, group, etc).
 */
public interface OptionSubjectCollection extends SubjectCollection {

    /**
     * Returns the option subject specified. Will not return null.
     *
     * @param identifier The identifier to look up a subject by.
     *                   Case-insensitive
     * @return A stored option subject if present, otherwise a option subject that may be
     *         stored if data is changed from defaults
     */
    @Override
    OptionSubject get(String identifier);

    /**
     * Returns all option subjects. The iterator provided by this method may be
     * populated asynchronously. Be aware that for large collections this method
     * may be very resource-intensive
     *
     * @return An iterable providing all option subjects stored by this collection.
     */
    Iterable<OptionSubject> getAllSubjects();

    /**
     * Return all known option subjects with the given option information. Because
     * no context is passed, only option subjects who have this option globally or
     * option subjects which have accurate context calculations are returned.
     *
     * @param option The option to check
     * @return Any option subject known to have this option set, and the value this
     *         option is set to
     */
    Map<OptionSubject, String> getAllWithOption(String option);

    /**
     * Return all known option subjects with the given option information.
     *
     * @param contexts The context combination to check for options in
     * @param option The option to check
     * @return Any subject known to have this option set, and the value this
     *         option is set to
     */
    Map<OptionSubject, String> getAllWithOption(Set<Context> contexts, String option);
}
