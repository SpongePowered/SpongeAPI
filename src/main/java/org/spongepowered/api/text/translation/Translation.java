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

import org.spongepowered.api.text.translation.locale.Locales;
import org.spongepowered.api.text.translation.locale.NamedLocales;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Represents an identifier for text that can be translated into multiple
 * languages. Minecraft-included translations are generally translated
 * clientside. Translations not included in Minecraft are generally expected to
 * be translated server-side, for example using Gettext or a
 * {@link ResourceBundle}
 *
 * <p>Some translations require parameters to be sent together with them, if
 * they're not given they will be filled with empty text.</p>
 *
 * <p>While the client has multiple locales available, server-side vanilla
 * translations usually support only {@link NamedLocales#AMERICAN_ENGLISH}.</p>
 */
public interface Translation {

    /**
     * Gets the identifier for this {@link Translation}.
     *
     * @return The translation identifier of this translation
     */
    String getId();

    /**
     * Gets the default translation without extra parameters.
     *
     * @return The default translation
     */
    default String get() {
        return get(Locales.DEFAULT);
    }

    /**
     * Gets the default translation format with the specified parameters.
     *
     * @param args The parameters for this translation
     * @return The default translation with the specified parameters
     */
    default String get(Object... args) {
        return get(Locales.DEFAULT, args);
    }

    /**
     * Gets the translation without any parameters replaced.
     *
     * @param locale The language to get the translated format string for
     * @return The translation without any parameters
     */
    String get(Locale locale);

    /**
     * Gets the translation format with the specified parameters.
     *
     * @param locale The language to get the translated string for
     * @param args The parameters for this translation
     * @return The translation with the specified parameters
     */
    String get(Locale locale, Object... args);
}
