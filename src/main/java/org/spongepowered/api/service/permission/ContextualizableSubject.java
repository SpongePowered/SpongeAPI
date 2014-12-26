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
import org.spongepowered.api.service.permission.context.Context;

import javax.annotation.Nullable;

/**
 * Represents subject that can have multiple {@link Context}s. This should be
 * used for global/per world permissions. The main subject uses all active
 * {@link Context}s.
 * <p>
 * <b>Note:</b> Subjects for different context cannot be summed up to get a
 * valid result for all a specific method, because there might be a priority
 * list involved internally.
 * </p>
 */
public interface ContextualizableSubject extends Subject {

    /**
     * Gets the subject limited to the given context.
     *
     * @param context The context for the subject
     * @return The subject limited to the given context
     */
    ContextualSubject getContextedSubject(Context context);

    /**
     * Temporarily disables all other contexts and limit the {@link Subject} to
     * the specified {@link Context}. If the context is no longer enforced it
     * will be removed from the user and all other
     *
     * @param context The context to limit the subject to, or null to reactivate
     *            all contexts.
     * @return The subject for the specified context if feature is supported and
     *         the subject was bound to the given context
     */
    Optional<ContextualSubject> enforceContext(@Nullable Context context);

    /**
     * Checks whether a context is enforced on this context.
     *
     * @return True if the feature is supported and a special context is
     *         enforced.
     */
    boolean isContextEnforced();

}
