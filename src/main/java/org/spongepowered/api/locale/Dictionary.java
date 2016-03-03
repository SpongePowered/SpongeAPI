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

import org.spongepowered.api.text.translation.locale.Locales;

import java.util.Locale;
import java.util.Optional;

/**
 * Represents a Dictionary for a particular subject. Dictionaries take a
 * given string key and return a localized result.
 */
public interface Dictionary {

    /**
     * Returns the "subject" for this dictionary.
     *
     * @return Subject of dictionary
     */
    Object getSubject();

    /**
     * Returns the default {@link Locale} to be used if no Locale is specified.
     *
     * @return Default Locale
     */
    default Locale getDefaultLocale() {
        return Locales.DEFAULT;
    }

    /**
     * Returns the entry for the specified key for the specified
     * {@link Locale}.
     *
     * @param key Key to search for
     * @param locale Locale to get
     * @return Localized string for "key"
     */
    Optional<String> get(String key, Locale locale);

    /**
     * Returns the entry for the specified key for the default {@link Locale}
     * defined by {@link #getDefaultLocale()}.
     *
     * @param key Key to search for
     * @return Localized string for "key"
     */
    default Optional<String> get(String key) {
        return get(key, getDefaultLocale());
    }

}
