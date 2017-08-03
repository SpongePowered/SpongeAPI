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

import java.util.Set;

/**
 * Calculates the {@link Context}s applicable for a {@link Contextual}.
 *
 * <p>These methods may be invoked frequently, and therefore should be fast.</p>
 */
public interface ContextCalculator<T extends Contextual> {

    /**
     * Adds any {@link Context}s this calculator determines to be applicable to
     * the provided context accumulator.
     *
     * @param calculable the {@link Contextual} for this operation
     * @param accumulator a {@link Set} of {@link Context}s this operation
     *                    will accumulate to.
     */
    void accumulateContexts(T calculable, Set<Context> accumulator);

    /**
     * Checks if a {@link Context} is currently applicable to a
     * {@link Contextual}.
     * 
     * <p>If this calculator does not handle the given type of context, this
     * method should return false.</p>
     *
     * <p>For the given set of contexts which would be accumulated using
     * {@link #accumulateContexts(Contextual, Set)}, this method should return
     * true if the given context would be included in the accumulated set.</p>
     *
     * @param context the {@link Context} being checked
     * @param calculable the {@link Contextual} that is being checked against
     * @return True if the given {@link Context} is handled by this calculator
     *         and is applicable to the given {@link Contextual}. Otherwise
     *         false.
     */
    boolean matches(Context context, T calculable);
}
