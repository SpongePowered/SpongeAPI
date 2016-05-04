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
package org.spongepowered.api.text.dictionary.text;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.dictionary.Dictionary;
import org.spongepowered.api.text.serializer.TextSerializer;

import java.util.Locale;
import java.util.Optional;

/**
 * A delegating {@link Dictionary} which has methods that return {@link Text}.
 */
public class TextSerializerDelegateDictionary implements TextDictionary {

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

    @Override
    public Optional<Text> getText(String key, Locale locale) {
        return this.get(key, locale).map(this.serializer::deserializeUnchecked);
    }

    @Override
    public Object getSubject() {
        return this.delegate.getSubject();
    }

}
