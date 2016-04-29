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
package org.spongepowered.api.text.dictionary.bundle;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.text.dictionary.Dictionary;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * A {@link Dictionary} that retrieves values from a {@link ResourceBundle}.
 *
 * @param <B> The resource bundle type
 */
public interface ResourceBundleDictionary<B extends ResourceBundle> extends Dictionary {

    /**
     * Gets the {@link ResourceBundle} for the specified {@link Locale}.
     *
     * @param locale Locale to get bundle for
     * @return Optional bundle
     * @throws MissingResourceException
     */
    B getBundle(Locale locale) throws MissingResourceException;

    @Override
    default Optional<String> get(String key, Locale locale) {
        checkNotNull(key, "key");
        checkNotNull(locale, "locale");

        try {
            return Optional.of(this.getBundle(locale).getString(key));
        } catch (MissingResourceException e) {
            try {
                // We failed with the provided locale, fallback to the default locale
                return Optional.of(this.getBundle(this.getDefaultLocale()).getString(key));
            } catch (MissingResourceException e2) {
                return Optional.empty();
            }
        }
    }

}
