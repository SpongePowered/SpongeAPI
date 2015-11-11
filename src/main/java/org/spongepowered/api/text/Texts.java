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
package org.spongepowered.api.text;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.spongepowered.api.scoreboard.Score;
import org.spongepowered.api.text.action.ClickAction;
import org.spongepowered.api.text.action.HoverAction;
import org.spongepowered.api.text.action.ShiftClickAction;
import org.spongepowered.api.text.action.TextAction;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextFormat;
import org.spongepowered.api.text.format.TextStyle;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.text.selector.Selector;
import org.spongepowered.api.text.template.TextArgsElement;
import org.spongepowered.api.text.template.TextElement;
import org.spongepowered.api.text.template.TextElements;
import org.spongepowered.api.text.translation.Translatable;
import org.spongepowered.api.text.translation.Translation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

/**
 * Utility class to work with and create {@link Text}.
 */
public final class Texts {

    private static TextFactory factory = null;
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
    public static Text.Score of(Score score) {
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
        TextFormat format = TextFormat.empty();
        HoverAction<?> hoverAction = null;
        ClickAction<?> clickAction = null;
        ShiftClickAction<?> shiftClickAction = null;

        for (Object obj : objects) {
            if (obj instanceof TextFormat) {
                format = (TextFormat) obj;
            } else if (obj instanceof TextColor) {
                format = format.color((TextColor) obj);
            } else if (obj instanceof TextStyle) {
                format = format.style(obj.equals(TextStyles.RESET) ? TextStyles.NONE : format.getStyle().and((TextStyle) obj));
            } else if (obj instanceof TextAction) {
                if (obj instanceof HoverAction) {
                    hoverAction = (HoverAction<?>) obj;
                } else if (obj instanceof ClickAction) {
                    clickAction = (ClickAction<?>) obj;
                } else if (obj instanceof ShiftClickAction) {
                    shiftClickAction = (ShiftClickAction<?>) obj;
                } else {
                    throw new IllegalArgumentException("Unsupported type of TextAction supplied to Texts.of");
                }
            } else if (obj instanceof TextElement) {
                throw new IllegalArgumentException("Texts.of does not support taking text elements, " +
                    "use TextTemplate.of instead");
            } else if (obj instanceof TextArgsElement) {
                throw new IllegalArgumentException("Texts.of does not support taking text argument elements, " +
                    "use TextTemplate.of instead");
            } else {
                TextBuilder childBuilder;

                if (obj instanceof String) {
                    childBuilder = Texts.builder((String) obj);
                } else if (obj instanceof Translation) {
                    childBuilder = Texts.builder((Translation) obj);
                } else if (obj instanceof Selector) {
                    childBuilder = Texts.builder((Selector) obj);
                } else if (obj instanceof Score) {
                    childBuilder = Texts.builder((Score) obj);
                } else {
                    childBuilder = Texts.builder(String.valueOf(obj));
                }

                if (hoverAction != null) {
                    builder.onHover(hoverAction);
                }
                if (clickAction != null) {
                    builder.onClick(clickAction);
                }
                if (shiftClickAction != null) {
                    builder.onShiftClick(shiftClickAction);
                }

                builder.append(childBuilder.format(format).build());
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

    /**
     * Creates a new unformatted {@link TextBuilder.Score} with the given score.
     *
     * @param score The score for the text builder
     * @return The created text builder
     * @see Text.Score
     * @see TextBuilder.Score
     */
    public static TextBuilder.Score builder(Score score) {
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
    public static TextBuilder.Score builder(Text text, Score score) {
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
    public static Text join(Text separator, Iterable<? extends Text> texts) {
        List<Text> textsList = Lists.newArrayList(texts);
        switch (textsList.size()) {
            case 0:
                return of();
            case 1:
                return textsList.get(0);
            default:
                TextBuilder builder = builder();
                boolean appendSeparator = false;
                for (Text text : textsList) {
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
     * Returns a plain text representation of the {@link Text} without any
     * formatting.
     *
     * @param text The text to convert
     * @param locale The locale to translate
     * @return The text converted to plain text
     */
    public static String toPlain(Text text, Locale locale) {
        return factory.toPlain(text, locale);
    }

    /**
     * Get a {@link TextRepresentation} for the Mojangson representation of a
     * {@link Text} object.
     *
     *
     * @return The json serializer
     */
    public static TextRepresentation json() {
        return factory.json();
    }

    /**
     * Get a {@link TextRepresentation} for the TextXML representation of a
     * {@link Text} object.
     *
     * @return The xml text serializer
     */
    public static TextRepresentation xml() {
        return factory.xml();
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
     * Return a representation that accepts and outputs legacy color codes,
     * using the default legacy char {{@link #getLegacyChar()} .
     *
     * @return The appropriate legacy representation handler
     */
    @Deprecated
    public static TextRepresentation legacy() {
        return legacy(getLegacyChar());
    }

    /**
     * Return a representation that accepts and outputs legacy color codes,
     * using the provided legacy character.
     *
     * @param legacyChar The legacy character to parse and output using
     * @return The appropriate legacy representation handler
     */
    @Deprecated
    public static TextRepresentation legacy(char legacyChar) {
        return factory.legacy(legacyChar);
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
