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

import org.spongepowered.api.text.translation.locale.Locales;

import java.io.InputStream;
import java.util.Locale;

/**
 * An abstract implementation of a {@link RemoteDictionary}.
 */
public abstract class AbstractRemoteDictionary extends AbstractDictionary implements RemoteDictionary {

    protected final DictionarySourceResolver<InputStream> resolver = new DictionarySourceResolver<>();

    /**
     * Constructs an abstract remote dictionary with
     * the {@link Locales#DEFAULT default} locale.
     *
     * @param subject The subject of this dictionary
     */
    protected AbstractRemoteDictionary(Object subject) {
        super(subject);
    }

    /**
     * Constructs an abstract remote dictionary with a default locale.
     *
     * @param subject The subject of this dictionary
     * @param defaultLocale The default locale for this dictionary
     */
    protected AbstractRemoteDictionary(Object subject, Locale defaultLocale) {
        super(subject, defaultLocale);
    }

    /**
     * Returns the {@link DictionarySourceResolver} for this dictionary.
     *
     * @return The dictionary source resolver
     */
    public DictionarySourceResolver<InputStream> getResolver() {
        return this.resolver;
    }

    @Override
    public InputStream getSource(Locale locale) throws Exception {
        checkNotNull(locale, "locale");
        return this.resolver.resolve(locale).orElseThrow(() -> new IllegalStateException("Could not resolve source for locale " + locale + "."));
    }

}
