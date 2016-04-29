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
package org.spongepowered.api.locale.bundle;

import com.google.common.collect.Maps;
import org.spongepowered.api.locale.CachingDictionary;
import org.spongepowered.api.locale.DictionarySourceResolver;

import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Function;

/**
 * A {@link ResourceBundleDictionary} with multiple resource bundle sources.
 *
 * @see SimpleResourceBundleDictionary
 */
public class MultiSourceResourceBundleDictionary extends SimpleResourceBundleDictionary implements CachingDictionary {

    protected final Map<Locale, ResourceBundle> cache = Maps.newHashMap();
    protected final Resolver resolver;

    public MultiSourceResourceBundleDictionary(Object subject, Locale defaultLocale, String bundleName) {
        super(subject, defaultLocale, bundleName);
        this.resolver = new Resolver(this.bundleName);
        this.resolver.setPrimary(locale -> ResourceBundle.getBundle(this.bundleName, locale, subject.getClass().getClassLoader()));
    }

    /**
     * Returns the {@link DictionarySourceResolver} for this dictionary.
     *
     * @return The dictionary source resolver
     */
    public Resolver getResolver() {
        return this.resolver;
    }

    @Override
    public ResourceBundle getBundle(Locale locale) throws MissingResourceException {
        return this.cache.computeIfAbsent(locale, this.resolver);
    }

    @Override
    public void clearCache() {
        this.cache.clear();
    }

    public static class Resolver extends DictionarySourceResolver<ResourceBundle> implements Function<Locale, ResourceBundle> {

        private final String bundleName;

        public Resolver(String bundleName) {
            this.bundleName = bundleName;
        }

        @Override
        public ResourceBundle apply(Locale locale) {
            Optional<ResourceBundle> bundle = this.resolve(locale);
            if (bundle.isPresent()) {
                return bundle.get();
            } else {
                throw new MissingResourceException("Can't find bundle for base name " + this.bundleName + ", locale " + locale,
                        this.bundleName + '_' + locale, "");
            }
        }

    }

}
