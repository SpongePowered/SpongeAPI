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

import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyle;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.text.translation.Translatable;
import org.spongepowered.api.text.translation.Translation;

/**
 * Utility class to work with and create {@link Text}.
 */
public final class Texts {

    private static final TextFactory factory = null;

    private Texts() {
    }

    /**
     * Creates a {@link TextBuilder} with empty text.
     *
     * @return A new message builder with empty text
     */
    public static TextBuilder builder() {
        return factory.createEmptyBuilder();
    }

    /**
     * Creates a {@link TextBuilder.Literal} with the specified text.
     *
     * @param text The text for the message
     * @return A new message builder with the specified text
     * @see Text.Literal
     */
    public static TextBuilder.Literal builder(String text) {
        return factory.createTextBuilder(text);
    }

    /**
     * Creates a {@link TextBuilder.Translatable} with the specified
     * translation and arguments.
     *
     * @param translation The translation to use for the message
     * @param args The arguments for the translation, can be empty
     * @return A new message builder with the specified translation and
     *         arguments
     * @see Text.Translatable
     */
    public static TextBuilder.Translatable builder(Translation translation, Object... args) {
        return factory.createTranslatableBuilder(translation, args);
    }

    /**
     * Creates a {@link TextBuilder.Translatable} with the specified
     * {@link Translatable} object and arguments.
     *
     * @param translatable The translatable object to insert to the message
     * @param args The arguments for the translation, can be empty
     * @return A new message builder with the translation of the translatable
     *         object
     * @see Text.Translatable
     */
    public static TextBuilder.Translatable builder(Translatable translatable, Object... args) {
        return builder(translatable.getTranslation(), args);
    }

    // TODO: Change to builder() when possible?

    /**
     * Creates a new {@link TextBuilder.Selector} with the specified
     * selector.
     *
     * @param selector The selector for the message
     * @return A new message builder with the specified selector
     * @see Text.Selector
     */
    public static TextBuilder.Selector selector(String selector) {
        return factory.createSelectorBuilder(selector);
    }

    /**
     * Creates a new {@link TextBuilder.Score} with the specified score.
     *
     * @param score The score for the message
     * @return A new message builder with the specified score
     * @see Text.Score
     */
    public static TextBuilder.Score score(Object score) {
        return factory.createScoreBuilder(score);
    }

    /**
     * Creates a {@link Text} with the specified plain text. The created
     * message won't have any formatting or events configured.
     *
     * @param content The content of the Message
     * @return The created {@link Text}
     */
    public static Text.Literal of(String content) {
        return factory.createPlain(content);
    }

    /**
     * Joins a sequence of text objects together.
     *
     * @param texts The text to join
     * @return A text object that joins the given text objects
     */
    public static Text join(Text... texts) {
        return builder().append(texts).build();
    }

    /**
     * Joins a sequence of text objects together along with a separator.
     *
     * @param separator The separator
     * @param texts The text to join
     * @return A text object that joins the given text objects
     */
    public static Text join(Text separator, Text... texts) {
        if (texts.length < 2) {
            return join(texts);
        } else {
            TextBuilder builder = builder();
            for (int i = 0; i < texts.length - 1; i++) {
                builder.append(texts[i]);
                builder.append(separator);
            }
            builder.append(texts[texts.length - 1]);
            return builder.build();
        }
    }

    /**
     * Builds a Text object from a given array of objects.
     *
     * <p>For instance, you can use this like
     * <code>Txt.of(TextColors.DARK_AQUA, "Hi", TextColors.AQUA, "Bye")</code>
     * </p>
     *
     * @param objects The object array
     * @throws IllegalArgumentException If a passed-in argument is not of type
     *         TextColor, TextStyle, String or Text
     * @return The built text object
     */
    public static Text of(Object... objects) throws IllegalArgumentException {
        TextBuilder builder = builder();
        TextColor color = TextColors.NONE;
        TextStyle style = TextStyles.NONE;
        for (Object obj: objects) {
            if (obj instanceof TextColor) {
                color = (TextColor) obj;
            } else if (obj instanceof TextStyle) {
                style = obj.equals(TextStyles.RESET) ? TextStyles.NONE : style.and((TextStyle) obj);
            } else if (obj instanceof String) {
                builder.append(builder((String) obj).color(color).build());
            } else if (obj instanceof Text) {
                builder.append((Text) obj);
            } else {
                throw new IllegalArgumentException("Unexpected type for object " + obj);
            }
        }
        return builder.build();
    }

    /**
     * Parses the specified JSON text and returns the parsed result.
     *
     * @param json The valid JSON text
     * @return The parsed text
     * @throws IllegalArgumentException If the JSON is invalid
     */
    public static Text parse(String json) throws IllegalArgumentException {
        throw new UnsupportedOperationException(); // TODO
    }

    /**
     * Parses the specified JSON text and returns the parsed result.
     *
     * <p>Unlike {@link #parse(String)} this will ignore some formatting errors and parse the JSON data more leniently.</p>
     *
     * @param json The JSON text
     * @return The parsed text
     * @throws IllegalArgumentException If the JSON couldn't be parsed
     */
    public static Text parseLenient(String json) {
        throw new UnsupportedOperationException(); // TODO
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
    public static Text.Literal fromLegacy(String text) {
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
    public static Text.Literal fromLegacy(String text, char color) {
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
