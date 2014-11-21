/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

/**
 * A Translation most closely represents any given Minecraft translation ID. It
 * allows for getting a string of text in multiple locales in the client;
 * however, it is mostly used to hold a translation ID when sending a message so
 * the client can do translation. Some Translations have parameters, and some do
 * not.
 *
 * <p>
 * On the server-side, the only available locale is English.
 * </p>
 */
public interface Translation {

    /**
     * Returns the translation identifier for this Translation.
     *
     * @return A String for the translation identifier
     */
    String getId();

    /**
     * Gets the default translation without any parameters. If the translations
     * contains any parameters they will be filled with empty text.
     *
     * @return A String for the translation
     */
    String get();

    /**
     * Gets the default translation with the specified parameters.
     *
     * @param args The parameters for this translation
     * @return The default translation with the specified parameters
     */
    String get(Object... args);

    // TODO locale api
    // String get(Object locale);
    // String get(Object locale, Object... args);

}
