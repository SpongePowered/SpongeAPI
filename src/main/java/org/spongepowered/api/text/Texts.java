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
package org.spongepowered.api.text;

import org.spongepowered.api.text.translation.Translation;

/**
 * Utility class to work with and create Messages.
 */
public final class Texts {

    private static final TextFactory factory = null;

    private Texts() {
    }

    /**
     * Creates a new {@link TextBuilder}.
     *
     * @param content The content of the Message
     * @param <T> The type parameter of the Message
     * @return A new MessageBuilder
     *
     * @throws UnsupportedOperationException If the specified content type is
     *             not supported by this server
     */
    public static <T> TextBuilder<T> builder(T content) {
        return factory.createBuilder(content);
    }

    /**
     * Creates a new {@link TextBuilder} that builds {@link Translation}
     * messages.
     *
     * @param translation The translation of the Message
     * @param args The arguments to the translation
     * @return A new MessageBuilder
     */
    public static TextBuilder<Translation> builder(Translation translation, Object... args) {
        return factory.createTranslationBuilder(translation, args);
    }

    // TODO: Score API

    /**
     * Creates a new {@link TextBuilder} that builds {@link Text.Score}
     * messages. If you wish to not override the score, use the
     * {@link #builder(Object)} method.
     *
     * @param score The score of the Message
     * @param override The override of the score
     * @return A
     */
    public static TextBuilder<Object> builder(Object score, String override) {
        return factory.createScoreBuilder(score, override);
    }

    /**
     * Creates a new {@link TextBuilder} out of the given content and builds
     * it immediately. This is a shorthand to {@link #builder(Object)}.
     *
     * @param content The content of the Message
     * @param <T> The type parameter of the Message
     * @return The constructed {@link Text}
     */
    public static <T> Text<T> of(T content) {
        return builder(content).build();
    }

    /**
     * Returns the default legacy formatting character.
     *
     * @return The legacy formatting character
     * @deprecated Legacy formatting codes are being phased out of Minecraft
     */
    @Deprecated
    public static char getLegacyChar() {
        return factory.getColorChar();
    }

    /**
     * Creates a Message from a legacy string using the default legacy.
     *
     * @param text The text to be converted as a String
     * @return The converted Message
     * @deprecated Legacy formatting codes are being phased out of Minecraft
     */
    @Deprecated
    public static Text.Plain fromLegacy(String text) {
        return fromLegacy(text, getLegacyChar());
    }

    /**
     * Creates a Message from a legacy string, given a color character.
     *
     * @param text The text to be converted as a String
     * @param color The color character to be replaced
     * @return The converted Message
     * @deprecated Legacy formatting codes are being phased out of Minecraft
     */
    @Deprecated
    public static Text.Plain fromLegacy(String text, char color) {
        return factory.parseLegacyMessage(text, color);
    }

    /**
     * Removes the legacy formatting character from a legacy string.
     *
     * @param text The legacy text as a String
     * @return The stripped text
     * @deprecated Legacy formatting codes are being phased out of Minecraft
     */
    @Deprecated
    public static String stripCodes(String text) {
        return stripCodes(text, getLegacyChar());
    }

    /**
     * Removes the legacy formatting character from a legacy string.
     *
     * @param text The legacy text as a String
     * @param color The color character to be replaced
     * @return The stripped text
     * @deprecated Legacy formatting codes are being phased out of Minecraft
     */
    @Deprecated
    public static String stripCodes(String text, char color) {
        return factory.stripLegacyCodes(text, color);
    }

    /**
     * Replaces the given formatting character with the default legacy
     * formatting character from a legacy string.
     *
     * @param text The legacy text as a String
     * @param from The color character to be replaced
     * @return The replaced text
     * @deprecated Legacy formatting codes are being phased out of Minecraft
     */
    @Deprecated
    public static String replaceCodes(String text, char from) {
        return replaceCodes(text, from, getLegacyChar());
    }

    /**
     * Replaces the given formatting character with another given formatting
     * character from a legacy string.
     *
     * @param text The legacy text as a String
     * @param from The color character to be replaced
     * @param to The color character to replace with
     * @return The replaced text
     * @deprecated Legacy formatting codes are being phased out of Minecraft
     */
    @Deprecated
    public static String replaceCodes(String text, char from, char to) {
        return factory.replaceLegacyCodes(text, from, to);
    }

}
