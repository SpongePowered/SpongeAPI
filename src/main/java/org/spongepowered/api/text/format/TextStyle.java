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
package org.spongepowered.api.text.format;

import com.google.common.base.Optional;
import org.spongepowered.api.text.Text;

import javax.annotation.Nullable;

/**
 * A TextStyle represents an immutable text style of a {@link Text}.
 * It is a utility that is not normally present in Minecraft.
 *
 * <p>
 * Combined styles can be created using {@link TextStyles#of(TextStyle...)} or
 * using one of the {@link #and(TextStyle...)}, {@link #andNot(TextStyle...)}
 * or {@link #negate()} method.
 * </p>
 *
 * <p>
 * Each individual style within a TextStyle, e.g. bold, italic is not just a boolean,
 * but a nullable Boolean since it can be unapplied. They will hereafter be referred to
 * as properties.
 * </p>
 *
 * <p>
 * Implementation note: Null styles should not appear in the final chat
 * component JSON. Properties that are set to true or false should appear, even if they
 * override inherited properties.
 * </p>
 *
 * @see TextStyles
 */
public class TextStyle {

    /**
     * Whether text where this style is applied is bolded.
     */
    @Nullable private final Boolean bold;

    /**
     * Whether text where this style is applied is italicized.
     */
    @Nullable private final Boolean italic;

    /**
     * Whether text where this style is applied is underlined.
     */
    @Nullable private final Boolean underline;

    /**
     * Whether text where this style is applied has a strikethrough.
     */
    @Nullable private final Boolean strikethrough;

    /**
     * Whether text where this style is applied is obfuscated.
     */
    @Nullable private final Boolean obfuscated;

    /**
     * Constructs a new TextStyle.
     *
     * @param bold Whether text where this style is applied is bolded
     * @param italic Whether text where this style is applied is italicized
     * @param underline Whether text where this style is applied is underlined
     * @param obfuscated Whether text where this style is applied is obfuscated
     * @param strikethrough Whether text where this style is applied has a strikethrough
     */
    protected TextStyle(@Nullable Boolean bold,
                        @Nullable Boolean italic,
                        @Nullable Boolean underline,
                        @Nullable Boolean strikethrough,
                        @Nullable Boolean obfuscated) {
        this.bold = bold;
        this.italic = italic;
        this.underline = underline;
        this.obfuscated = obfuscated;
        this.strikethrough = strikethrough;
    }

    /**
     * Constructs an empty TextStyle.
     */
    TextStyle() {
        this(null, null, null, null, null);
    }

    /**
     * Returns whether this text style is a composite of multiple text styles.
     *
     * @return True if this text style is a composite
     */
    public boolean isComposite() {
        // Return true by default as the TextStyle class is composite by default
        return true;
    }

    /**
     * Returns whether this text style has no set properties.
     *
     * @return {@code true} if this style is empty
     */
    public boolean isEmpty() {
        return (this.obfuscated == null)
                && (this.bold == null)
                && (this.strikethrough == null)
                && (this.underline == null)
                && (this.italic == null);
    }

    /**
     * Returns a new text style with the bold property changed.
     *
     * @param bold Whether text where the new style is applied is bolded
     * @return The new text style
     */
    public TextStyle bold(@Nullable Boolean bold) {
        return new TextStyle(
                bold,
                this.italic,
                this.underline,
                this.strikethrough,
                this.obfuscated
        );
    }

    /**
     * Returns a new text style with the italic property changed.
     *
     * @param italic Whether text where the new style is applied is italicized
     * @return The new text style
     */
    public TextStyle italic(@Nullable Boolean italic) {
        return new TextStyle(
                this.bold,
                italic,
                this.underline,
                this.strikethrough,
                this.obfuscated
        );
    }

    /**
     * Returns a new text style with the underline property changed.
     *
     * @param underline Whether text where the new style is applied is underline
     * @return The new text style
     */
    public TextStyle underline(@Nullable Boolean underline) {
        return new TextStyle(
                this.bold,
                this.italic,
                underline,
                this.strikethrough,
                this.obfuscated
        );
    }

    /**
     * Returns a new text style with the strikethrough property changed.
     *
     * @param strikethrough Whether text where the new style is applied has a strikethrough
     * @return The new text style
     */
    public TextStyle strikethrough(@Nullable Boolean strikethrough) {
        return new TextStyle(
                this.bold,
                this.italic,
                this.underline,
                strikethrough,
                this.obfuscated
        );
    }

    /**
     * Returns a new text style with the obfuscated property changed.
     *
     * @param obfuscated Whether text where the new style is applied is obfuscated
     * @return The new text style
     */
    public TextStyle obfuscated(@Nullable Boolean obfuscated) {
        return new TextStyle(
                this.bold,
                this.italic,
                this.underline,
                this.strikethrough,
                obfuscated
        );
    }

    /**
     * Checks for whether text where this style is applied is bolded.
     *
     * @return The value for the bold property,
     *      or {@link Optional#absent()}
     */
    public Optional<Boolean> isBold() {
        return Optional.fromNullable(this.bold);
    }

    /**
     * Checks for whether text where this style is applied is italicized.
     *
     * @return The value for the italic property,
     *      or {@link Optional#absent()}
     */
    public Optional<Boolean> isItalic() {
        return Optional.fromNullable(this.italic);
    }

    /**
     * Checks for whether text where this style is applied has an underline.
     *
     * @return The value for the underline property,
     *      or {@link Optional#absent()}
     */
    public Optional<Boolean> hasUnderline() {
        return Optional.fromNullable(this.underline);
    }

    /**
     * Checks for whether text where this style is applied has a strikethrough.
     *
     * @return The value for the strikethrough property,
     *      or {@link Optional#absent()}
     */
    public Optional<Boolean> hasStrikethrough() {
        return Optional.fromNullable(this.strikethrough);
    }

    /**
     * Checks for whether text where this style is obfuscated.
     *
     * @return The value for the obfuscated property,
     *      or {@link Optional#absent()}
     */
    public Optional<Boolean> isObfuscated() {
        return Optional.fromNullable(this.obfuscated);
    }

    /**
     * Returns whether the given {@link TextStyle} is contained in this
     * {@link TextStyle}.
     *
     * <p>
     * For example, a {@link TextStyle} with {@code {bold: true, italic: true}} would return
     * true for <code>contains({@link TextStyles#BOLD})</code> and
     * <code>contains({@link TextStyles#ITALIC}).</code>
     * </p>
     *
     * <p>
     * If the specified {@link TextStyle} is a composite of multiple styles it
     * returns true if this style has at least all of the properties set in the
     * specified style.
     * </p>
     *
     * @param styles The text styles to check
     * @return True if the given text styles are contained in this text style
     */
    public boolean contains(TextStyle... styles) {
        for (TextStyle style : styles) {
            if (!propContains(this.bold, style.bold)
                    || !propContains(this.italic, style.italic)
                    || !propContains(this.underline, style.underline)
                    || !propContains(this.strikethrough, style.strikethrough)
                    || !propContains(this.obfuscated, style.obfuscated)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Negates this {@link TextStyle}. This is useful for undoing text styles
     * that are inherited from parent messages.
     *
     * @return The inverse of this text style
     */
    public TextStyle negate() {
        // Do a negation of each property
        return new TextStyle(
                propNegate(this.obfuscated),
                propNegate(this.bold),
                propNegate(this.strikethrough),
                propNegate(this.underline),
                propNegate(this.italic)
        );
    }

    /**
     * Composes this {@link TextStyle} with the specified text styles.
     *
     * @param styles The text styles to compose this one with
     * @return A new text style composed out of the given text styles
     */
    public TextStyle and(TextStyle... styles) {
        return compose(styles, false);
    }

    /**
     * Composes this {@link TextStyle} with the passed in TextStyles, but
     * negates them before composition. This is the same as negating all the
     * passed in {@link TextStyle} and then using the {@link #and(TextStyle...)}
     * method.
     *
     * @param styles The text styles to compose this one with
     * @return A new text style composed out of the given text styles
     */
    public TextStyle andNot(TextStyle... styles) {
        return compose(styles, true);
    }

    /**
     * Utility method to compose the current TextStyle with the given styles, with optional
     * negation.
     *
     * @param styles The styles to compose with
     * @param negate Whether or not to negate the passed-in styles
     * @return The composed style
     */
    private TextStyle compose(TextStyle[] styles, boolean negate) {
        TextStyle acc = this;
        if (negate) {
            for (TextStyle style : styles) {
                acc = new TextStyle(
                        propCompose(acc.bold, propNegate(style.bold)),
                        propCompose(acc.italic, propNegate(style.italic)),
                        propCompose(acc.underline, propNegate(style.underline)),
                        propCompose(acc.strikethrough, propNegate(style.strikethrough)),
                        propCompose(acc.obfuscated, propNegate(style.obfuscated))
                );
            }
        } else {
            for (TextStyle style : styles) {
                acc = new TextStyle(
                        propCompose(acc.bold, style.bold),
                        propCompose(acc.italic, style.italic),
                        propCompose(acc.underline, style.underline),
                        propCompose(acc.strikethrough, style.strikethrough),
                        propCompose(acc.obfuscated, style.obfuscated)
                );
            }
        }
        return acc;
    }

    /**
     * Utility method to check if the given "super-property" contains the given "sub-property".
     *
     * @param superprop The super property
     * @param subprop The sub property
     * @return True if the property is contained, otherwise false
     */
    private static boolean propContains(@Nullable Boolean superprop, @Nullable Boolean subprop) {
        return subprop != null && superprop == subprop;
    }

    /**
     * Utility method to negate a property if it is not null.
     *
     * @param bool The property to negate
     * @return The negated property, or null
     */
    @Nullable private static Boolean propNegate(@Nullable Boolean bool) {
        return bool == null ? null : !bool;
    }

    /**
     * Utility method to perform a compose operation between two properties.
     *
     * @param prop1 The first property
     * @param prop2 The second property
     * @return The composition of the two properties
     */
    @Nullable private static Boolean propCompose(@Nullable Boolean prop1, @Nullable Boolean prop2) {
        if (prop1 == null) {
            return prop2;
        } else if (prop2 == null) {
            return prop1;
        } else if (prop1 != prop2) {
            return null;
        } else {
            return prop1;
        }
    }

    /**
     * A Base text style is a text style that is represented in Minecraft.
     * There  are several Base styles specified in
     * {@link TextStyles} which are the
     * Minecraft base types. Base extends FormattingCode because it does have a
     * corresponding formatting code; it is a single, pure text style.
     */
    public static class Base extends TextStyle implements BaseFormatting {

        /**
         * The name of this Base TextStyle.
         */
        private final String name;

        /**
         * The char code behind this Base TextStyle.
         */
        private final char code;

        /**
         * Constructs a new Base text style.
         *
         * @param name The name of the TextStyle
         * @param code The char code behind this TextStyle
         * @param bold Whether text where this style is applied is bolded
         * @param italic Whether text where this style is applied is italicized
         * @param underline Whether text where this style is applied is underlined
         * @param obfuscated Whether text where this style is applied is obfuscated
         * @param strikethrough Whether text where this style is applied has a strikethrough
         */
        public Base(String name, char code,
                    @Nullable Boolean bold,
                    @Nullable Boolean italic,
                    @Nullable Boolean underline,
                    @Nullable Boolean strikethrough,
                    @Nullable Boolean obfuscated) {
            super(bold, italic, underline, strikethrough, obfuscated);
            this.name = name;
            this.code = code;
        }

        @Override
        public boolean isComposite() {
            // By definition, base TextStyles are not composites
            return false;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        @Deprecated
        public char getCode() {
            return this.code;
        }

    }

}
