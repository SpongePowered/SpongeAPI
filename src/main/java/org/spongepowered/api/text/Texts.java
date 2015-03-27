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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyle;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.text.selector.Selector;
import org.spongepowered.api.text.translation.Translatable;
import org.spongepowered.api.text.translation.Translation;

/**
 * Utility class to work with and create {@link Text}.
 */
public final class Texts {

    private static final TextFactory factory = null;
    static final Text.Literal EMPTY = new Text.Literal();

    private Texts() {
    }

    /**
     * Returns an empty, unformatted {@link Text} instance.
     *
     * @return An empty text
     */
    public static Text of() {
        return EMPTY;
    }

    /**
     * Creates a {@link Text} with the specified plain text. The created message
     * won't have any formatting or events configured.
     *
     * @param content The content of the text
     * @return The created text
     * @see Text.Literal
     */
    public static Text.Literal of(String content) {
        if (checkNotNull(content, "content").isEmpty()) {
            return EMPTY;
        }
        return new Text.Literal(content);
    }

    /**
     * Creates a new unformatted {@link Text.Translatable} with the given
     * {@link Translation} and arguments.
     *
     * @param translation The translation for the text
     * @param args The arguments for the translation
     * @return The created text
     * @see Text.Translatable
     */
    public static Text.Translatable of(Translation translation, Object... args) {
        return new Text.Translatable(translation, ImmutableList.copyOf(checkNotNull(args, "args")));
    }

    /**
     * Creates a new unformatted {@link Text.Translatable} from the given
     * {@link Translatable}.
     *
     * @param translatable The translatable for the text
     * @param args The arguments for the translation
     * @return The created text
     * @see Text.Translatable
     */
    public static Text.Translatable of(Translatable translatable, Object... args) {
        return of(checkNotNull(translatable, "translatable").getTranslation(), args);
    }

    /**
     * Creates a new unformatted {@link Text.Selector} with the given selector.
     *
     * @param selector The selector for the text
     * @return The created text
     * @see Text.Selector
     */
    public static Text.Selector of(Selector selector) {
        return new Text.Selector(selector);
    }

    /**
     * Creates a new unformatted {@link Text.Score} with the given score.
     *
     * @param score The score for the text
     * @return The created text
     * @see Text.Score
     */
    // TODO: Replace with Statistic API
    public static Text.Score of(Object score) {
        return new Text.Score(score);
    }

    /**
     * Builds a {@link Text} from a given array of objects.
     *
     * <p>For instance, you can use this like
     * <code>Texts.of(TextColors.DARK_AQUA, "Hi", TextColors.AQUA, "Bye")</code>
     * </p>
     *
     * <p>This will create the correct {@link Text} instance if the input object
     * is the input for one of the {@link Text} types or convert the object to a
     * string otherwise.</p>
     *
     * @param objects The object array
     * @return The built text object
     */
    public static Text of(Object... objects) {
        TextBuilder builder = builder();
        TextColor color = TextColors.NONE;
        TextStyle style = TextStyles.NONE;

        for (Object obj : objects) {
            if (obj instanceof TextColor) {
                color = (TextColor) obj;
            } else if (obj instanceof TextStyle) {
                style = obj.equals(TextStyles.RESET) ? TextStyles.NONE : style.and((TextStyle) obj);
            } else if (obj instanceof Text) {
                builder.append((Text) obj);
            } else {
                TextBuilder childBuilder;

                if (obj instanceof String) {
                    childBuilder = Texts.builder((String) obj);
                } else if (obj instanceof Translation) {
                    childBuilder = Texts.builder((Translation) obj, new Object[0]); // TODO: Remove explicit array initializer
                } else if (obj instanceof Selector) {
                    childBuilder = Texts.builder((Selector) obj);
                /*} else if (obj instanceof Object) { // TODO: Statistic API
                    childBuilder = Texts.builder((Object) obj);*/
                } else {
                    childBuilder = Texts.builder(String.valueOf(obj));
                }

                builder.append(childBuilder.color(color).style(style).build());
            }
        }

        return builder.build();
    }

    /**
     * Creates a {@link TextBuilder} with empty text.
     *
     * @return A new text builder with empty text
     */
    public static TextBuilder builder() {
        return new TextBuilder.Literal();
    }

    /**
     * Creates a new unformatted {@link TextBuilder.Literal} with the specified
     * content.
     *
     * @param content The content of the text
     * @return The created text builder
     * @see Text.Literal
     * @see TextBuilder.Literal
     */
    public static TextBuilder.Literal builder(String content) {
        return new TextBuilder.Literal(content);
    }

    /**
     * Creates a new {@link TextBuilder.Literal} with the formatting and actions
     * of the specified {@link Text} and the given content.
     *
     * @param text The text to apply the properties from
     * @param content The content for the text builder
     * @return The created text builder
     * @see Text.Literal
     * @see TextBuilder.Literal
     */
    public static TextBuilder.Literal builder(Text text, String content) {
        return new TextBuilder.Literal(text, content);
    }

    /**
     * Creates a new unformatted {@link TextBuilder.Translatable} with the given
     * {@link Translation} and arguments.
     *
     * @param translation The translation for the builder
     * @param args The arguments for the translation
     * @return The created text builder
     * @see Text.Translatable
     * @see TextBuilder.Translatable
     */
    public static TextBuilder.Translatable builder(Translation translation, Object... args) {
        return new TextBuilder.Translatable(translation, args);
    }

    /**
     * Creates a new unformatted {@link TextBuilder.Translatable} from the given
     * {@link Translatable}.
     *
     * @param translatable The translatable for the builder
     * @param args The arguments for the translation
     * @return The created text builder
     * @see Text.Translatable
     * @see TextBuilder.Translatable
     */
    public static TextBuilder.Translatable builder(Translatable translatable, Object... args) {
        return new TextBuilder.Translatable(translatable, args);
    }

    /**
     * Creates a new {@link TextBuilder.Translatable} with the formatting and
     * actions of the specified {@link Text} and the given {@link Translation}
     * and arguments.
     *
     * @param text The text to apply the properties from
     * @param translation The translation for the builder
     * @param args The arguments for the translation
     * @return The created text builder
     * @see Text.Translatable
     * @see TextBuilder.Translatable
     */
    public static TextBuilder.Translatable builder(Text text, Translation translation, Object... args) {
        return new TextBuilder.Translatable(text, translation, args);
    }

    /**
     * Creates a new {@link TextBuilder.Translatable} with the formatting and
     * actions of the specified {@link Text} and the given {@link Translatable}.
     *
     * @param text The text to apply the properties from
     * @param translatable The translatable for the builder
     * @param args The arguments for the translation
     * @return The created text builder
     * @see Text.Translatable
     * @see TextBuilder.Translatable
     */
    public static TextBuilder.Translatable builder(Text text, Translatable translatable, Object... args) {
        return new TextBuilder.Translatable(text, translatable, args);
    }

    /**
     * Creates a new unformatted {@link TextBuilder.Selector} with the given
     * selector.
     *
     * @param selector The selector for the builder
     * @return The created text builder
     * @see Text.Selector
     * @see TextBuilder.Selector
     */
    public static TextBuilder.Selector builder(Selector selector) {
        return new TextBuilder.Selector(selector);
    }

    /**
     * Creates a new {@link TextBuilder.Selector} with the formatting and
     * actions of the specified {@link Text} and the given selector.
     *
     * @param text The text to apply the properties from
     * @param selector The selector for the builder
     * @return The created text builder
     * @see Text.Selector
     * @see TextBuilder.Selector
     */
    public static TextBuilder.Selector builder(Text text, Selector selector) {
        return new TextBuilder.Selector(text, selector);
    }

    // TODO: Replace with Statistic API

    /**
     * Creates a new unformatted {@link TextBuilder.Score} with the given score.
     *
     * @param score The score for the text builder
     * @return The created text builder
     * @see Text.Score
     * @see TextBuilder.Score
     */
    public static TextBuilder.Score builder(Object score) {
        return new TextBuilder.Score(score);
    }

    /**
     * Creates a new {@link TextBuilder.Score} with the formatting and actions
     * of the specified {@link Text} and the given score.
     *
     * @param text The text to apply the properties from
     * @param score The score for the text builder
     * @return The created text builder
     * @see Text.Score
     * @see TextBuilder.Score
     */
    public static TextBuilder.Score builder(Text text, Object score) {
        return new TextBuilder.Score(text, score);
    }

    /**
     * Joins a sequence of text objects together.
     *
     * @param texts The texts to join
     * @return A text object that joins the given text objects
     */
    public static Text join(Text... texts) {
        return builder().append(texts).build();
    }

    /**
     * Joins a sequence of text objects together.
     *
     * @param texts The texts to join
     * @return A text object that joins the given text objects
     */
    public static Text join(Iterable<? extends Text> texts) {
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
        switch (texts.length) {
            case 0:
                return of();
            case 1:
                return texts[0];
            default:
                TextBuilder builder = builder();
                boolean appendSeparator = false;
                for (Text text : texts) {
                    if (appendSeparator) {
                        builder.append(separator);
                    } else {
                        appendSeparator = true;
                    }

                    builder.append(text);
                }

                return builder.build();
        }
    }

    /**
     * Parses the specified JSON text and returns the parsed result.
     *
     * @param json The valid JSON text
     * @return The parsed text
     * @throws IllegalArgumentException If the JSON is invalid
     */
    public static Text parseJson(String json) throws IllegalArgumentException {
        return factory.parseJson(json);
    }

    /**
     * Parses the specified JSON text and returns the parsed result.
     *
     * <p>Unlike {@link #parseJson(String)} this will ignore some formatting
     * errors and parse the JSON data more leniently.</p>
     *
     * @param json The JSON text
     * @return The parsed text
     * @throws IllegalArgumentException If the JSON couldn't be parsed
     */
    public static Text parseJsonLenient(String json) throws IllegalArgumentException {
        return factory.parseJsonLenient(json);
    }

    /**
     * Returns a plain text representation of the {@link Text} without any
     * formatting.
     *
     * @param text The text to convert
     * @return The text converted to plain text
     */
    public static String toPlain(Text text) {
        return factory.toPlain(text);
    }

    /**
     * Returns a JSON representation of the {@link Text} as used in commands.
     *
     * @param text The text to convert
     * @return The text converted to JSON
     */
    public static String toJson(Text text) {
        return factory.toJson(text);
    }

    /**
     * Returns the default legacy formatting character.
     *
     * @return The legacy formatting character
     * @deprecated Legacy formatting codes are being phased out of Minecraft
     */
    @Deprecated
    public static char getLegacyChar() {
        return factory.getLegacyChar();
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

    /**
     * Returns a representation of the {@link Text} using the legacy color
     * codes.
     *
     * @param text The text to convert
     * @return The text converted to the old color codes
     * @deprecated Legacy formatting codes are being phased out of Minecraft
     */
    @Deprecated
    public static String toLegacy(Text text) {
        return toLegacy(text, getLegacyChar());
    }

    /**
     * Returns a representation of the {@link Text} using the legacy color
     * codes.
     *
     * @param text The text to convert
     * @param code The legacy char to use for the message
     * @return The text converted to the old color codes
     * @deprecated Legacy formatting codes are being phased out of Minecraft
     */
    @Deprecated
    public static String toLegacy(Text text, char code) {
        return factory.toLegacy(text, code);
    }

}
