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

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Callable;

/**
 * Represents a {@link Dictionary} with a remote source.
 */
public interface RemoteDictionary extends Dictionary {

    /**
     * Returns an {@link InputStream} for the remote source of this Dictionary.
     *
     * @return Source of dictionary
     * @throws IOException
     */
    InputStream getSource(Locale locale) throws Exception;

    /**
     * Returns an {@link InputStream} for the remote source of this Dictionary.
     *
     * @return Source of dictionary
     * @throws IOException
     */
    default InputStream getSource() throws Exception {
        return getSource(getDefaultLocale());
    }

    /**
     * Class that resolves an {@link InputStream} source for a given {@link Locale}.
     */
    class SourceResolver {

        Callable<InputStream> primary;
        final Map<Locale, List<Callable<InputStream>>> sources = new HashMap<>();

        SourceResolver() {
        }

        /**
         * Sets the primary or "default" resolver.
         *
         * @param primary Resolver
         * @return This resolver
         */
        public SourceResolver primary(Callable<InputStream> primary) {
            this.primary = checkNotNull(primary, "primary");
            return this;
        }

        /**
         * Adds a {@link Callable} to supply an {@link InputStream} for the
         * given {@link Locale}.
         *
         * @param locale Locale to supply for
         * @param callable Callable to supply InputStream
         * @return This resolver
         */
        public SourceResolver add(Locale locale, Callable<InputStream> callable) {
            checkNotNull(locale, "locale");
            checkNotNull(callable, "callable");
            List<Callable<InputStream>> list = this.sources.get(locale);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(callable);
            this.sources.put(locale, list);
            return this;
        }

        /**
         * Resolves the {@link InputStream} source for the given
         * {@link Locale}.
         *
         * @param locale Locale to resolve source for
         * @return Optional InputStream. Empty if unresolved.
         * @throws Exception
         */
        public Optional<InputStream> resolve(Locale locale) throws Exception {
            checkNotNull(locale, "locale");
            List<Callable<InputStream>> list = this.sources.get(locale);
            if (list == null) {
                list = Collections.emptyList();
            }
            for (Callable<InputStream> callable : list) {
                InputStream in = callable.call();
                if (in != null) {
                    return Optional.of(in);
                }
            }
            if (this.primary != null) {
                return Optional.ofNullable(this.primary.call());
            }
            return Optional.empty();
        }

    }

}
