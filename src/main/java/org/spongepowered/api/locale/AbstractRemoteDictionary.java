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

import java.io.InputStream;
import java.util.Locale;

/**
 * Abstract implementation of {@link RemoteDictionary}.
 */
public abstract class AbstractRemoteDictionary extends AbstractDictionary implements RemoteDictionary {

    protected final SourceResolver resolver = new SourceResolver();

    public AbstractRemoteDictionary(Object subject, Locale defaultLocale) {
        super(subject, defaultLocale);
    }

    /**
     * Returns the {@link SourceResolver} for this Dictionary.
     *
     * @return Source resolver
     */
    public SourceResolver getResolver() {
        return this.resolver;
    }

    @Override
    public InputStream getSource(Locale locale) throws Exception {
        checkNotNull(locale, "locale");
        return this.resolver.resolve(locale).orElseThrow(() -> new IllegalStateException("Could not resolve source for locale " + locale + "."));
    }

}
