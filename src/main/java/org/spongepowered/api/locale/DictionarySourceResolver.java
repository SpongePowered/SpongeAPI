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
package org.spongepowered.api.locale;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Function;

import javax.annotation.Nullable;

/**
 * A {@link R dictionary source} resolver which transforms a
 * {@link Locale} into {@link R}.
 */
public class DictionarySourceResolver<R> {

    @Nullable protected Function<Locale, R> primary;
    protected final List<Function<Locale, R>> sources = Lists.newArrayList();

    /**
     * Constructs a dictionary source resolver with no primary resolver.
     */
    public DictionarySourceResolver() {
        this(null);
    }

    /**
     * Constructs a dictionary source resolver with a primary resolver.
     *
     * @param primary The primary resolver
     */
    public DictionarySourceResolver(@Nullable Function<Locale, R> primary) {
        this.primary = primary;
    }

    /**
     * Sets the primary resolver.
     *
     * @param primary The primary resolver
     */
    public final void setPrimary(@Nullable Function<Locale, R> primary) {
        this.primary = primary;
    }

    /**
     * Adds a {@link Function} to supply an {@link R} for a
     * {@link Locale}.
     *
     * @param function The function to supply {@link R}
     */
    public final void add(Function<Locale, R> function) {
        this.sources.add(checkNotNull(checkNotNull(function, "function")));
    }

    /**
     * Resolves the {@link R source} for the given
     * {@link Locale}.
     *
     * @param locale The locale to resolve the source for
     * @return {@link R}, if present, {@link Optional#empty()} otherwise
     */
    public final Optional<R> resolve(Locale locale) {
        checkNotNull(locale, "locale");

        // Attempt to resolve source from provided sources first
        for (Function<Locale, R> function : this.sources) {
            R source = function.apply(locale);
            if (source != null) {
                return Optional.of(source);
            }
        }

        // Resolve from primary source if available
        if (this.primary != null) {
            return Optional.ofNullable(this.primary.apply(locale));
        }

        return Optional.empty();
    }
}
