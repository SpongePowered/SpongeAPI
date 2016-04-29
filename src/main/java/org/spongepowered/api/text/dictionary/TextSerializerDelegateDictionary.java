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
package org.spongepowered.api.text.dictionary;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializer;

import java.util.Locale;
import java.util.Optional;

/**
 * A delegating {@link Dictionary} which has methods that return {@link Text}.
 */
public class TextSerializerDelegateDictionary implements Dictionary {

    protected final Dictionary delegate;
    protected final TextSerializer serializer;

    public TextSerializerDelegateDictionary(Dictionary delegate, TextSerializer serializer) {
        this.delegate = checkNotNull(delegate, "delegate");
        this.serializer = checkNotNull(serializer, "serializer");
    }

    @Override
    public Optional<String> get(String key, Locale locale) {
        return this.delegate.get(key, locale);
    }

    /**
     * Gets the entry for the specified key in this dictionary
     * for the {@link #getDefaultLocale() default locale}.
     *
     * @param key The key whose associated value is to be returned
     * @return The {@link Text} value for {@code key}, if present,
     *     {@link Optional#empty()} otherwise
     * @see Dictionary#get(String)
     */
    public Optional<Text> getText(String key) {
        return this.getText(key, this.getDefaultLocale());
    }

    /**
     * Gets the entry for the specified key for the specified
     * {@link Locale}.
     *
     * @param key The key whose associated value is to be returned
     * @param locale The locale under which the value should be
     *     obtained in
     * @return The {@link Text} value for {@code key}, if present,
     *     {@link Optional#empty()} otherwise
     * @see Dictionary#get(String, Locale)
     */
    public Optional<Text> getText(String key, Locale locale) {
        return this.get(key, locale).map(this.serializer::deserializeUnchecked);
    }

    @Override
    public Object getSubject() {
        return this.delegate.getSubject();
    }
}
