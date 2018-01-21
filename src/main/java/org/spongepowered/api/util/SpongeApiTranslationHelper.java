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
package org.spongepowered.api.util;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.translation.ResourceBundleTranslation;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Function;

/**
 * This class provides translations for strings within SpongeAPI. Plugins
 * should consult an implementation of Translation for help.
 *
 * <p>THIS IS AN API-INTERNAL CLASS -- DO NOT USE OUTSIDE OF API OR YOU WILL
 * LIVE A SAD AND LONELY LIFE</p>
 */
public class SpongeApiTranslationHelper {

    private static final Function<Locale, ResourceBundle> LOOKUP_FUNC = input ->
            ResourceBundle.getBundle("org.spongepowered.api.Translations", input);

    /**
     * Gets the translated text for a given string.
     *
     * @param key The translation key
     * @param args Translation parameters
     * @return The translatable text
     */
    public static Text t(String key, Object... args) {
        return Text.of(new ResourceBundleTranslation(key, LOOKUP_FUNC), args);
    }

    // Suppress default constructor to ensure non-instantiability.
    private SpongeApiTranslationHelper() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
