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
package org.spongepowered.api.text.translation.dictionary.bundle;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.text.translation.dictionary.AbstractTranslationDictionary;
import org.spongepowered.api.text.translation.locale.Locales;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * A simple implementation of a {@link ResourceBundleTranslationDictionary}.
 */
public class SimpleResourceBundleTranslationDictionary extends AbstractTranslationDictionary
        implements ResourceBundleTranslationDictionary<ResourceBundle> {

    protected final String bundleName;

    public SimpleResourceBundleTranslationDictionary(Object subject, String bundleName) {
        this(subject, Locales.DEFAULT, bundleName);
    }

    public SimpleResourceBundleTranslationDictionary(Object subject, Locale defaultLocale, String bundleName) {
        super(subject, defaultLocale);
        this.bundleName = checkNotNull(bundleName, "bundle name");
    }

    @Override
    public ResourceBundle getBundle(Locale locale) {
        checkNotNull(locale, "locale");
        return ResourceBundle.getBundle(this.bundleName, locale, this.subject.getClass().getClassLoader());
    }

}
