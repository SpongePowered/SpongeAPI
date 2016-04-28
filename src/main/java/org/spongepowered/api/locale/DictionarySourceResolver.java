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

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.function.Function;

import javax.annotation.Nullable;

/**
 * Class that resolves an {@link R} source for a given {@link Locale}.
 */
public class DictionarySourceResolver<R> {

    @Nullable protected Function<Locale, R> primary;
    protected final Multimap<Locale, Function<Locale, R>> sources = HashMultimap.create();

    public DictionarySourceResolver() {
        this(null);
    }

    public DictionarySourceResolver(@Nullable Function<Locale, R> primary) {
        this.primary = primary;
    }

    public final void setPrimary(Function<Locale, R> primary) {
        this.primary = checkNotNull(primary, "primary");
    }

    /**
     * Adds a {@link Callable} to supply an {@link R} for the
     * given {@link Locale}.
     *
     * @param locale Locale to supply for
     * @param function The function to supply {@link R}
     * @return This resolver
     */
    public DictionarySourceResolver<R> add(Locale locale, Function<Locale, R> function) {
        this.sources.put(checkNotNull(locale, "locale"), checkNotNull(function, "function"));
        return this;
    }

    /**
     * Resolves the {@link R} source for the given
     * {@link Locale}.
     *
     * @param locale Locale to resolve source for
     * @return Optional InputStream. Empty if unresolved.
     */
    public Optional<R> resolve(Locale locale) {
        checkNotNull(locale, "locale");

        for (Function<Locale, R> function : this.sources.get(locale)) {
            R in = function.apply(locale);
            if (in != null) {
                return Optional.of(in);
            }
        }

        if (this.primary != null) {
            return Optional.ofNullable(this.primary.apply(locale));
        }

        return Optional.empty();
    }
}
