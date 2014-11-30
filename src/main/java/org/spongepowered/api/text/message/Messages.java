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
package org.spongepowered.api.text.message;

import org.spongepowered.api.text.translation.Translation;

/**
 * Utility class to work with and create Messages.
 */
public final class Messages {

    private static final MessageFactory factory = null;

    private Messages() {
    }

    /**
     * Creates a new {@link MessageBuilder}.
     *
     * @param content The content of the Message
     * @param <T> The type parameter of the Message
     * @return A new MessageBuilder
     *
     * @throws UnsupportedOperationException If the specified content type is
     *             not supported by this server
     */
    public static <T> MessageBuilder<T> builder(T content) {
        return factory.createBuilder(content);
    }

    /**
     * Creates a new {@link MessageBuilder} that builds {@link Translation}
     * messages.
     *
     * @param translation The translation of the Message
     * @param args The arguments to the translation
     * @return A new MessageBuilder
     */
    public static MessageBuilder<Translation> builder(Translation translation, Object... args) {
        return factory.createTranslationBuilder(translation, args);
    }

    // TODO: Score API

    /**
     * Creates a new {@link MessageBuilder} that builds {@link Message.Score}
     * messages. If you wish to not override the score, use the
     * {@link #builder(Object)} method.
     *
     * @param score The score of the Message
     * @param override The override of the score
     * @return A
     */
    public static MessageBuilder<Object> builder(Object score, String override) {
        return factory.createScoreBuilder(score, override);
    }

    /**
     * Creates a new {@link MessageBuilder} out of the given content and builds
     * it immediately. This is a shorthand to {@link #builder(Object)}.
     *
     * @param content The content of the Message
     * @param <T> The type parameter of the Message
     * @return The constructed {@link Message}
     */
    public static <T> Message<T> of(T content) {
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
     * @param message The message to be converted as a String
     * @return The converted Message
     * @deprecated Legacy formatting codes are being phased out of Minecraft
     */
    @Deprecated
    public static Message.Text fromLegacy(String message) {
        return fromLegacy(message, getLegacyChar());
    }

    /**
     * Creates a Message from a legacy string, given a color character.
     *
     * @param message The message to be converted as a String
     * @param color The color character to be replaced
     * @return The converted Message
     * @deprecated Legacy formatting codes are being phased out of Minecraft
     */
    @Deprecated
    public static Message.Text fromLegacy(String message, char color) {
        return factory.parseLegacyMessage(message, color);
    }

    /**
     * Removes the legacy formatting character from a legacy string.
     *
     * @param message The legacy message as a String
     * @return The stripped message
     * @deprecated Legacy formatting codes are being phased out of Minecraft
     */
    @Deprecated
    public static String stripCodes(String message) {
        return stripCodes(message, getLegacyChar());
    }

    /**
     * Removes the legacy formatting character from a legacy string.
     *
     * @param message The legacy message as a String
     * @param color The color character to be replaced
     * @return The stripped message
     * @deprecated Legacy formatting codes are being phased out of Minecraft
     */
    @Deprecated
    public static String stripCodes(String message, char color) {
        return factory.stripLegacyCodes(message, color);
    }

    /**
     * Replaces the given formatting character with the default legacy
     * formatting character from a legacy string.
     *
     * @param message The legacy message as a String
     * @param from The color character to be replaced
     * @return The replaced message
     * @deprecated Legacy formatting codes are being phased out of Minecraft
     */
    @Deprecated
    public static String replaceCodes(String message, char from) {
        return replaceCodes(message, from, getLegacyChar());
    }

    /**
     * Replaces the given formatting character with another given formatting
     * character from a legacy string.
     *
     * @param message The legacy message as a String
     * @param from The color character to be replaced
     * @param to The color character to replace with
     * @return The replaced message
     * @deprecated Legacy formatting codes are being phased out of Minecraft
     */
    @Deprecated
    public static String replaceCodes(String message, char from, char to) {
        return factory.replaceLegacyCodes(message, from, to);
    }

}
