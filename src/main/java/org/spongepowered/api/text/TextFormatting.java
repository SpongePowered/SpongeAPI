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

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * All supported formatting options for chat and other styled messages.
 */
public final class TextFormatting {

    private static final Map<String, TextFormatting> BY_NAME = new LinkedHashMap<String, TextFormatting>();
    private static final Map<Character, TextFormatting> BY_CODE = new LinkedHashMap<Character, TextFormatting>();

    /**
     * Represents black.
     */
    @Nonnull public static final TextFormatting BLACK = new TextFormatting("BLACK", true, '0');
    /**
     * Represents dark blue.
     */
    @Nonnull public static final TextFormatting DARK_BLUE = new TextFormatting("DARK_BLUE", true, '1');
    /**
     * Represents dark green.
     */
    @Nonnull public static final TextFormatting DARK_GREEN = new TextFormatting("DARK_GREEN", true, '2');
    /**
     * Represents turquoise (aqua / dark cyan).
     */
    @Nonnull public static final TextFormatting DARK_TURQUOISE = new TextFormatting("DARK_TURQUOISE", true, '3');
    /**
     * Represents dark red.
     */
    @Nonnull public static final TextFormatting DARK_RED = new TextFormatting("DARK_RED", true, '4');
    /**
     * Represents purple.
     */
    @Nonnull public static final TextFormatting PURPLE = new TextFormatting("PURPLE", true, '5');
    /**
     * Represents orange.
     */
    @Nonnull public static final TextFormatting ORANGE = new TextFormatting("ORANGE", true, '6');
    /**
     * Represents light gray.
     */
    @Nonnull public static final TextFormatting LIGHT_GRAY = new TextFormatting("LIGHT_GRAY", true, '7');
    /**
     * Represents dark gray.
     */
    @Nonnull public static final TextFormatting DARK_GRAY = new TextFormatting("DARK_GRAY", true, '8');
    /**
     * Represents blue.
     */
    @Nonnull public static final TextFormatting BLUE = new TextFormatting("BLUE", true, '9');
    /**
     * Represents green.
     */
    @Nonnull public static final TextFormatting LIGHT_GREEN = new TextFormatting("LIGHT_GREEN", true, 'a');
    /**
     * Represents light blue.
     */
    @Nonnull public static final TextFormatting LIGHT_BLUE = new TextFormatting("LIGHT_BLUE", true, 'b');
    /**
     * Represents red.
     */
    @Nonnull public static final TextFormatting RED = new TextFormatting("RED", true, 'c');
    /**
     * Represents light magenta.
     */
    @Nonnull public static final TextFormatting MAGENTA = new TextFormatting("MAGENTA", true, 'd');
    /**
     * Represents yellow.
     */
    @Nonnull public static final TextFormatting YELLOW = new TextFormatting("YELLOW", true, 'e');
    /**
     * Represents white.
     */
    @Nonnull public static final TextFormatting WHITE = new TextFormatting("WHITE", true, 'f');
    /**
     * Represents magical characters that change around randomly.
     */
    @Nonnull public static final TextFormatting DISGUISE = new TextFormatting("DISGUISE", true, 'k');
    /**
     * Makes the text bold.
     */
    @Nonnull public static final TextFormatting BOLD = new TextFormatting("BOLD", true, 'l', true);
    /**
     * Makes a line appear through the text.
     */
    @Nonnull public static final TextFormatting STRIKETHROUGH = new TextFormatting("STRIKETHROUGH", true, 'm', true);
    /**
     * Makes the text appear underlined.
     */
    @Nonnull public static final TextFormatting UNDERLINE = new TextFormatting("UNDERLINE", true, 'n', true);
    /**
     * Makes the text italic.
     */
    @Nonnull public static final TextFormatting ITALICS = new TextFormatting("ITALICS", true, 'o', true);
    /**
     * Resets all previous chat colors or formats.
     */
    @Nonnull public static final TextFormatting RESET = new TextFormatting("RESET", true, 'r');

    private static final char FORMAT_CHAR = '\u00A7';
    private static String COLOR_INFLUENCERS = null;
    private static String FORMAT_INFLUENCERS = null;
    private static Pattern STRIP_FORMAT_PATTERN = null;

    @Nonnull private final String name;
    private final boolean isDefault;
    private final char code;
    private final boolean isStyle;
    @Nonnull private final String text;

    private TextFormatting(@Nonnull final String name, final boolean isDefault, final char code) {
        this(name, isDefault, code, false);
    }

    @SuppressWarnings("null")
    private TextFormatting(@Nonnull final String name, final boolean isDefault, final char code, final boolean isStyle) {
        super();
        if (code == '\\') {
            throw new IllegalArgumentException("Code cannot be \"\\\"!");
        }
        this.name = name.toUpperCase();
        this.isDefault = isDefault;
        this.code = Character.toLowerCase(code);
        this.isStyle = isStyle;
        this.text = new String(new char[] { FORMAT_CHAR, code });
        if (!BY_NAME.containsKey(this.name) && !BY_CODE.containsKey(this.code)) {
            BY_NAME.put(this.name, this);
            BY_CODE.put(this.code, this);
            BY_CODE.put(Character.toUpperCase(this.code), this);
            generatePatterns();
        } else {
            throw new IllegalArgumentException("TextFormatting with name " + this.name + " or code " + this.code + " does already exist!");
        }
    }

    private static void generatePatterns() {
        final StringBuilder colorBuilder = new StringBuilder();
        final StringBuilder formatBuilder = new StringBuilder();
        final StringBuilder patternBuilder = new StringBuilder(FORMAT_CHAR);
        patternBuilder.append("[\\Q");
        for (final Entry<Character, TextFormatting> formatting : BY_CODE.entrySet()) {
            final char code = formatting.getKey().charValue();
            if (!formatting.getValue().isStyle) {
                colorBuilder.append(code);
            }
            formatBuilder.append(code);
            patternBuilder.append(code);
        }
        patternBuilder.append("\\E]");
        COLOR_INFLUENCERS = colorBuilder.toString();
        FORMAT_INFLUENCERS = formatBuilder.toString();
        STRIP_FORMAT_PATTERN = Pattern.compile(patternBuilder.toString());
    }

    /**
     * Creates a new TextFormatting with a given name and code. If name and code
     * is unique it will be registered as global TextFormatting.
     *
     * @param name The name of this TextFormatting
     * @param code The code of this TextFormatting, cannot be '\'
     * @param isStyle True, if this indicates a style otherwise false
     * @throws IllegalArgumentException If the given name or code does already exist
     */
    public TextFormatting(@Nonnull final String name, final char code, final boolean isStyle) {
        this(name, false, code, isStyle);
    }

    /**
     * Checks whether this format is provided by the API and not
     * server/implementation dependent.
     *
     * @return True, if this TextFormatting is specified by the API, otherwise
     *         false.
     */
    public boolean isDefault() {
        return isDefault;
    }

    /**
     * Gets the char value associated with this color.
     *
     * @return A char value of this format code
     */
    public final char getCode() {
        return code;
    }

    /**
     * Checks if this code is a color formatter as opposed to a style formatter.
     *
     * @return True, if this formatter represents a color otherwise false
     */
    public final boolean isColor() {
        return !isStyle && this != RESET;
    }

    /**
     * Checks if this code is a style formatter as opposed to a color formatter.
     *
     * @return True, if this formatter represents a color otherwise false
     */
    public final boolean isStyle() {
        return isStyle;
    }

    @Override
    @Nonnull
    public String toString() {
        return text;
    }

    /**
     * Gets the TextFormatting for the given format name.
     *
     * @param name The name to check
     * @return The TextFormatting for the given (case insesitive) name or null,
     *         if the given name does not specify a format.
     */
    @Nullable
    public static TextFormatting getByName(@Nonnull final String name) {
        return BY_NAME.get(name.toUpperCase());
    }

    /**
     * Gets the TextFormatting for the given format char.
     *
     * @param code The code to check
     * @return The TextFormatting for the given code or null, if the given code
     *         does not influence the format.
     */
    @Nullable
    public static TextFormatting getByCode(final char code) {
        return BY_CODE.get(code);
    }

    /**
     * Gets all registered TextFormattings.
     *
     * @return A {@link Set} all registered TextFormattings .
     */
    @Nonnull
    public static Set<TextFormatting> getAll() {
        return new LinkedHashSet<TextFormatting>(BY_NAME.values());
    }

    /**
     * Converts your alternative format representation to minecraft's
     * representation.
     *
     * @param message The message to convert
     * @param formatChar The format code used in your text that should be
     *        replaced
     * @return The converted message
     */
    @Nonnull
    public static String translateFormatting(@Nonnull final String message, final char formatChar) {
        final char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == formatChar && FORMAT_INFLUENCERS.indexOf(chars[i + 1]) > -1) {
                chars[i] = FORMAT_CHAR;
                chars[i + 1] = Character.toLowerCase(chars[i + 1]);
            }
        }
        return new String(chars);
    }

    /**
     * Converts minecraft's format representation to your alternative
     * representation.
     *
     * @param message The message to convert
     * @param formatChar The format code that should be used
     * @return The converted message
     */
    @Nonnull
    public static String reverseTranslateFormatting(@Nonnull final String message, final char formatChar) {
        final char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == FORMAT_CHAR && FORMAT_INFLUENCERS.indexOf(chars[i + 1]) > -1) {
                chars[i] = formatChar;
                chars[i + 1] = Character.toLowerCase(chars[i + 1]);
            }
        }
        return new String(chars);
    }

    /**
     * Removes every formatting from the given string.
     *
     * @param formatedString The string to clean
     * @return The given message as plain text or null if the given string was
     *         null
     */
    @Nullable
    public static String removeFormatting(@Nullable final String formatedString) {
        if (formatedString == null) {
            return null;
        } else {
            return STRIP_FORMAT_PATTERN.matcher(formatedString).replaceAll("");
        }
    }

    /**
     * Returns the last color that would be applied to any character that would
     * be appended to the given string.
     *
     * @param formatedString The string to search for color codes
     * @return The last color code applied to the given string or null if no
     *         color was applied or the color has been reseted afterwards.
     */
    @Nullable
    public static TextFormatting getLastColor(@Nullable final String formatedString) {
        if (formatedString == null) {
            return null;
        } else {
            final char[] chars = formatedString.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] == FORMAT_CHAR && COLOR_INFLUENCERS.indexOf(chars[i + 1]) > -1) {
                    final TextFormatting format = getByCode(chars[i + 1]);
                    return format == RESET ? null : format;
                }
            }
            return null;
        }
    }

    /**
     * Returns all formats that would be applied to any character that would be
     * appended to the given string.
     * <p>
     * Use the following scriptlet to apply the returned format to any other
     * message:
     * </p>
     *
     * <pre>
     * List&lt;TextFormatting&gt; list = new ArrayList&lt;TextFormatting&gt;(formats);
     * Collections.reverse(list).toString() + message;
     * </pre>
     *
     * @param formatedString The string to search for formatting
     * @return A set containing all format codes applied to the given string.
     *         May be empty if no format codes have been applied or have been
     *         reset afterwards. Returns null if the given message was null.
     */
    @Nullable
    public static Set<TextFormatting> getLastFormats(@Nullable final String formatedString) {
        if (formatedString == null) {
            return null;
        } else {
            final char[] chars = formatedString.toCharArray();
            final Set<TextFormatting> formats = new LinkedHashSet<TextFormatting>();
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] == FORMAT_CHAR) {
                    final TextFormatting format = getByCode(chars[i + 1]);
                    if (format != null) {
                        if (!format.isStyle) {
                            if (format == RESET) {
                                formats.clear();
                            } else {
                                formats.add(format);
                            }
                            break;
                        } else {
                            formats.add(format);
                        }
                    }
                }
            }
            return formats;
        }
    }
}
