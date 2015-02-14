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
package org.spongepowered.api.service.permission.context;

import org.spongepowered.api.service.permission.Subject;

import java.util.Set;

/**
 * Calculate the availability of contexts. These methods may be invoked
 * frequently, and therefore should be fast.
 */
public interface ContextCalculator {

    /**
     * Add any contexts this calculator determines to be applicable to the
     * provided accumulator.
     *
     * @param subject The subject being checked
     * @param accumulator The accumulator to add to
     */
    void accumulateContexts(Subject subject, Set<Context> accumulator);

    /**
     * Checks if a single context is currently applicable to a single subject.
     * If this calculator does not handle the given type of context, this method
     * should return false.
     *
     * @param context The context being checked
     * @param subject The subject this context is being checked against
     * @return Whether the given context is handled by this calculator and is
     *         applicable to the given subject
     */
    boolean matches(Context context, Subject subject);
}
