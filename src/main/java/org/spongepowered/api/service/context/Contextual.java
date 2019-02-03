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
package org.spongepowered.api.service.context;

import java.util.Optional;
import java.util.Set;

/**
 * A common interface for objects that have an identifier and can have a set of
 * active {@link Context}s determined.
 *
 * <p>Used primarily by {@link ContextualService}s.</p>
 */
public interface Contextual {

    /**
     * Returns the identifier associated with this Contextual.
     *
     * <p>The identifier of each distinct Contextual within a collection of
     * contextuals should be unique.</p>
     *
     * <p>Not guaranteed to be human-readable. Use
     * {@link #getFriendlyIdentifier()} for a more readable alternative.</p>
     *
     * @return The identifier for this subject
     */
    String getIdentifier();

    /**
     * Returns the friendly identifier associated with this Contextual.
     *
     * <p>Unlike {@link #getIdentifier()}, this value is not guaranteed to be
     * unique.</p>
     *
     * <p>If the friendly identifier is equal to the normal identifier,
     * this method should return {@link Optional#empty()}.</p>
     *
     * <p>Contextuals which represent a Player or a User should return the
     * username here, if available.</p>
     *
     * @return The friendly identifier for this contextual
     */
    default Optional<String> getFriendlyIdentifier() {
        return Optional.empty();
    }

    /**
     * Calculates the objects active contexts at the given moment, using the
     * {@link ContextCalculator}s held by the {@link ContextualService}.
     *
     * <p>"Active" contexts refers to the contexts currently applicable to the
     * contextual.</p>
     *
     * <p>The result of these calculations may be cached.</p>
     *
     * @return An immutable set of active contexts
     */
    Set<Context> getActiveContexts();
}
