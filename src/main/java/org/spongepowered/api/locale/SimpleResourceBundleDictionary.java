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

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Represents a simple implementation of {@link ResourceBundleDictionary} using
 * a "base name" and {@link ResourceBundle#getBundle(String)} to retrieve
 * bundles.
 */
public class SimpleResourceBundleDictionary extends AbstractDictionary implements ResourceBundleDictionary<ResourceBundle> {

    protected final String baseName;
    protected final Map<Locale, ResourceBundle> bundles = new HashMap<>();

    public SimpleResourceBundleDictionary(Object subject, Locale defaultLocale, String baseName) {
        super(subject, defaultLocale);
        this.baseName = baseName;
    }

    @Override
    public ResourceBundle getBundle(Locale locale) {
        checkNotNull(locale, "locale");
        ResourceBundle bundle = this.bundles.get(locale);
        if (bundle == null) {
            setBundle(locale, bundle = ResourceBundle.getBundle(this.baseName, locale));
        }
        return bundle;
    }

    @Override
    public void setBundle(Locale locale, ResourceBundle bundle) {
        checkNotNull(locale, "locale");
        this.bundles.put(locale, bundle);
    }

}
