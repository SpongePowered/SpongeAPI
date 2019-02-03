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

import java.util.Collection;
import java.util.Set;

/**
 * A common interface for services which provide a means to store and query
 * data for {@link Contextual}s, according to given or calculated
 * {@link Context} state.
 *
 * <p>When functionality is provided to query data based upon a given
 * {@link Set} of {@link Context}s, the querying code must consider which of the
 * underlying data is "applicable" to the contexts specified in the query
 * request. It is expected that implementations will deem entries of underlying
 * data to be applicable if the {@link Set} of contexts defined in the query
 * contain all of the {@link Context}s required by the data entry.
 * Mathematically, an underlying data entry is "applicable" if
 * [the context of the entry] is a subset of [the context provided in the
 * query], or programmatically if [the context provided in the query]
 * {@link Set#containsAll(Collection)} of [the context of the entry].</p>
 *
 * @param <T> the contextual type
 */
public interface ContextualService<T extends Contextual> {

    /**
     * Registers a {@link ContextCalculator} for use by this service.
     *
     * <p>It is not guaranteed that the calculator will be used by the service,
     * as some implementations may not support contexts.</p>
     *
     * @param calculator The context calculator to register
     */
    void registerContextCalculator(ContextCalculator<T> calculator);
}
