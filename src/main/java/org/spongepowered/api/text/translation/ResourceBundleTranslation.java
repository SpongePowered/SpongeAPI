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
package org.spongepowered.api.text.translation;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.function.Function;

/**
 * <p>A translation class designed to be used for ResourceBundles. For
 * convenience, most users will want to wrap this in a class that keeps track of
 * resource bundles. A simple implementation would look like:</p>
 *
 * <blockquote><code>public class TranslationHelper {<br />&nbsp; &nbsp; private
 * static final Function&lt;Locale, ResourceBundle&gt; LOOKUP_FUNC = new
 * Function&lt;Locale, ResourceBundle&gt;() {<br />&nbsp; &nbsp; &nbsp; &nbsp;
 * &#064;Nullable &#064;Override<br />&nbsp; &nbsp; &nbsp; &nbsp; public
 * ResourceBundle apply(Locale input) {<br />&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
 * &nbsp; return ResourceBundle.getBundle("com.mydomain.myplugin.Translations",
 * input);<br /> &nbsp; &nbsp; &nbsp; &nbsp; }<br />&nbsp; &nbsp; };<br /><br />
 * &nbsp; &nbsp; private TranslationHelper() {} // Prevent instance creation
 * <br /><br />&nbsp; &nbsp; public static Text t(String key, Object... args) {
 * <br />&nbsp; &nbsp; &nbsp; &nbsp; return Texts.of(new
 * ResourceBundleTranslation(key, LOOKUP_FUNC), args);<br />&nbsp; &nbsp; }
 * <br />}</code></blockquote>
 */
public class ResourceBundleTranslation implements Translation {

    private final String key;
    private final Function<Locale, ResourceBundle> bundleFunction;

    /**
     * Create a ResourceBundle-backed translation for the given key and bundle
     * factory.
     *
     * @param key The key to use
     * @param bundleFunction The bundle function to get a bundle from
     */
    public ResourceBundleTranslation(String key, Function<Locale, ResourceBundle> bundleFunction) {
        this.key = key;
        this.bundleFunction = bundleFunction;
    }

    @Override
    public String getId() {
        return this.key;
    }

    @Override
    public String get(Locale locale) {
        checkNotNull(locale, "locale");
        try {
            ResourceBundle bundle = this.bundleFunction.apply(locale);
            return bundle == null ? this.key : bundle.getString(this.key);
        } catch (MissingResourceException ex) {
            return this.key;
        }
    }

    @Override
    public String get(Locale locale, Object... args) {
        return String.format(locale, get(locale), args);
    }
}
