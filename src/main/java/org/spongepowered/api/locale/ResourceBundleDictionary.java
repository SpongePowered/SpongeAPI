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

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Represents a {@link Dictionary} that handles retrieval through {@link ResourceBundle}s.
 *
 * @param <B> Bundle type
 */
public interface ResourceBundleDictionary<B extends ResourceBundle> extends Dictionary {

    /**
     * Returns the {@link ResourceBundle} for the specified {@link Locale}.
     *
     * @param locale Locale to get bundle for
     * @return Optional bundle
     */
    B getBundle(Locale locale);

    /**
     * Sets the {@link ResourceBundle} for the specified {@link Locale}.
     *
     * @param locale Locale to set
     * @param bundle Bundle to use for Locale
     */
    void setBundle(Locale locale, B bundle);

    @Override
    default Optional<String> get(String key, Locale locale) {
        checkNotNull(key, "key");
        checkNotNull(locale, "locale");
        try {
            return Optional.of(getBundle(locale).getString(key));
        } catch (MissingResourceException e) {
            return Optional.empty();
        }
    }

}
