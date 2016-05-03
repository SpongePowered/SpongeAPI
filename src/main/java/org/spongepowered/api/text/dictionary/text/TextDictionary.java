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

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.dictionary.Dictionary;
import org.spongepowered.api.text.dictionary.MinecraftDictionary;

import java.util.Locale;
import java.util.Optional;

/**
 * A dictionary which can output {@link Text}.
 */
public interface TextDictionary extends Dictionary {

    /**
     * Gets the entry for the specified key in this dictionary
     * for the {@link #getDefaultLocale() default locale}.
     *
     * @param key The key whose associated value is to be returned
     * @return The {@link Text} value for {@code key}, if present,
     *     {@link Optional#empty()} otherwise
     * @see Dictionary#get(String)
     */
    default Optional<Text> getText(String key) {
        return this.getText(key, this.getDefaultLocale());
    }

    /**
     * Gets the entry for the specified key in this dictionary
     * for the {@link #getDefaultLocale() default locale}.
     *
     * @param key The key whose associated value is to be returned
     * @param args An array of formatting arguments
     * @return The string value for {@code key}, if present,
     *     {@link Optional#empty()} otherwise
     */
    default Optional<Text> getText(String key, Object... args) {
        return this.getText(key, this.getDefaultLocale(), args);
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
    Optional<Text> getText(String key, Locale locale);

    /**
     * Gets the entry for the specified key for the specified
     * {@link Locale}.
     *
     * @param key The key whose associated value is to be returned
     * @param locale The locale under which the value should be
     *     obtained in
     * @param args An array of formatting arguments
     * @return The string value for {@code key}, if present,
     *     {@link Optional#empty()} otherwise
     */
    default Optional<Text> getText(String key, Locale locale, Object... args) {
        Optional<String> string = this.get(key, locale);
        if (!string.isPresent()) {
            return Optional.empty();
        } else {
            return Optional.of(MinecraftDictionary.format(string.get(), args));
        }
    }

}
