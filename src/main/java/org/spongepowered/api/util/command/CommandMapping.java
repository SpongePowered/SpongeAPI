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

package org.spongepowered.api.util.command;

import java.util.Set;

/**
 * Provides information about a mapping between a command and its aliases.
 *
 * <p>Implementations are not required to implement a sane
 * {@link java.lang.Object#equals(Object)} but may choose to do so.</p>
 */
public interface CommandMapping {

    /**
     * Get the primary alias.
     *
     * @return The primary alias
     */
    String getPrimaryAlias();

    /**
     * Get an immutable list of all aliases.
     *
     * <p>The returned list must contain at least one entry, of which one must
     * be the one returned by {@link #getPrimaryAlias()}.</p>
     *
     * <p>There may be several versions of the same alias with different
     * casing, although generally implementations should ignore the casing
     * of aliases.</p>
     *
     * @return A set of aliases
     */
    Set<String> getAllAliases();

    /**
     * Gets the callable.
     *
     * @return The callable
     */
    CommandCallable getCallable();

}
