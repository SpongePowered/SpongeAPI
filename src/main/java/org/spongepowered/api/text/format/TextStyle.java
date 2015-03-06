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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.annotation.CatalogedBy;
import org.spongepowered.api.util.text.OptBool;

import javax.annotation.Nullable;

/**
 * Represents an immutable text style of a {@link Text}. It is a utility that is
 * not normally present in Minecraft. It can be either empty, a {@link Base}
 * with an additional legacy formatting code or a composite.
 *
 * <p>Combined styles can be created using {@link TextStyles#of(TextStyle...)}
 * or using one of the {@link #and(TextStyle...)}, {@link #andNot(TextStyle...)}
 * or {@link #negate()} method.</p>
 *
 * <p>Each individual style within a TextStyle, e.g. bold, italic is not just a
 * boolean, but an {@code Optional&lt;Boolean&gt;} since it can be unapplied
 * (or, in Optional terms, "absent"). These styles will hereafter be referred to
 * as properties.<br> See the {@link OptBool} utility class for working with
 * properties.</p>
 *
 * <p>Implementation note: Absent styles should not appear in the final chat
 * component JSON. Properties that are set to true or false should appear, even
 * if they override inherited properties.</p>
 *
 * @see TextStyles
 */
@CatalogedBy(TextStyles.class)
public class TextStyle {

    /**
     * Whether text where this style is applied is bolded.
     */
    protected final Optional<Boolean> bold;

    /**
     * Whether text where this style is applied is italicized.
     */
    protected final Optional<Boolean> italic;

    /**
     * Whether text where this style is applied is underlined.
     */
    protected final Optional<Boolean> underline;

    /**
     * Whether text where this style is applied has a strikethrough.
     */
    protected final Optional<Boolean> strikethrough;

    /**
     * Whether text where this style is applied is obfuscated.
     */
    protected final Optional<Boolean> obfuscated;

    /**
     * Constructs a new {@link TextStyle}.
     *
     * @param bold Whether text where this style is applied is bolded
     * @param italic Whether text where this style is applied is italicized
     * @param underline Whether text where this style is applied is underlined
     * @param obfuscated Whether text where this style is applied is obfuscated
     * @param strikethrough Whether text where this style is applied has a
     *        strikethrough
     */
    public TextStyle(@Nullable Boolean bold,
            @Nullable Boolean italic,
            @Nullable Boolean underline,
            @Nullable Boolean strikethrough,
            @Nullable Boolean obfuscated) {
        this(
                OptBool.of(bold),
                OptBool.of(italic),
                OptBool.of(underline),
                OptBool.of(strikethrough),
                OptBool.of(obfuscated)
        );
    }

    /**
     * Constructs a new {@link TextStyle}.
     *
     * @param bold Whether text where this style is applied is bolded
     * @param italic Whether text where this style is applied is italicized
     * @param underline Whether text where this style is applied is underlined
     * @param obfuscated Whether text where this style is applied is obfuscated
     * @param strikethrough Whether text where this style is applied has a
     *        strikethrough
     */
    private TextStyle(Optional<Boolean> bold,
            Optional<Boolean> italic,
            Optional<Boolean> underline,
            Optional<Boolean> strikethrough,
            Optional<Boolean> obfuscated) {
        this.bold = bold;
        this.italic = italic;
        this.underline = underline;
        this.obfuscated = obfuscated;
        this.strikethrough = strikethrough;
    }

    /**
     * Constructs an empty {@link TextStyle}.
     */
    TextStyle() {
        this(
                OptBool.ABSENT,
                OptBool.ABSENT,
                OptBool.ABSENT,
                OptBool.ABSENT,
                OptBool.ABSENT
        );

    }

    /**
     * Returns whether this {@link TextStyle} is a composite of multiple text
     * styles.
     *
     * @return {@code true} if this text style is a composite
     */
    public boolean isComposite() {
        // Return true by default as the TextStyle class is composite by default
        return true;
    }

    /**
     * Returns whether this {@link TextStyle} has no set properties.
     *
     * @return {@code true} if this style is empty
     */
    public boolean isEmpty() {
        return !(this.bold.isPresent()
                || this.italic.isPresent()
                || this.underline.isPresent()
                || this.strikethrough.isPresent()
                || this.obfuscated.isPresent());
    }

    /**
     * Returns a new {@link TextStyle} with the bold property changed.
     *
     * @param bold Whether text where the new style is applied is bolded
     * @return The new text style
     */
    public TextStyle bold(@Nullable Boolean bold) {
        return new TextStyle(
                OptBool.of(bold),
                this.italic,
                this.underline,
                this.strikethrough,
                this.obfuscated
        );
    }

    /**
     * Returns a new {@link TextStyle} with the italic property changed.
     *
     * @param italic Whether text where the new style is applied is italicized
     * @return The new text style
     */
    public TextStyle italic(@Nullable Boolean italic) {
        return new TextStyle(
                this.bold,
                OptBool.of(italic),
                this.underline,
                this.strikethrough,
                this.obfuscated
        );
    }

    /**
     * Returns a new {@link TextStyle} with the underline property changed.
     *
     * @param underline Whether text where the new style is applied is underline
     * @return The new text style
     */
    public TextStyle underline(@Nullable Boolean underline) {
        return new TextStyle(
                this.bold,
                this.italic,
                OptBool.of(underline),
                this.strikethrough,
                this.obfuscated
        );
    }

    /**
     * Returns a new {@link TextStyle} with the strikethrough property changed.
     *
     * @param strikethrough Whether text where the new style is applied has a
     *        strikethrough
     * @return The new text style
     */
    public TextStyle strikethrough(@Nullable Boolean strikethrough) {
        return new TextStyle(
                this.bold,
                this.italic,
                this.underline,
                OptBool.of(strikethrough),
                this.obfuscated
        );
    }

    /**
     * Returns a new {@link TextStyle} with the obfuscated property changed.
     *
     * @param obfuscated Whether text where the new style is applied is
     *        obfuscated
     * @return The new text style
     */
    public TextStyle obfuscated(@Nullable Boolean obfuscated) {
        return new TextStyle(
                this.bold,
                this.italic,
                this.underline,
                this.strikethrough,
                OptBool.of(obfuscated)
        );
    }

    /**
     * Checks for whether text where this style is applied is bolded.
     *
     * @return The value for the bold property, or {@link Optional#absent()}
     */
    public Optional<Boolean> isBold() {
        return this.bold;
    }

    /**
     * Checks for whether text where this style is applied is italicized.
     *
     * @return The value for the italic property, or {@link Optional#absent()}
     */
    public Optional<Boolean> isItalic() {
        return this.italic;
    }

    /**
     * Checks for whether text where this style is applied has an underline.
     *
     * @return The value for the underline property, or
     *         {@link Optional#absent()}
     */
    public Optional<Boolean> hasUnderline() {
        return this.underline;
    }

    /**
     * Checks for whether text where this style is applied has a strikethrough.
     *
     * @return The value for the strikethrough property, or
     *         {@link Optional#absent()}
     */
    public Optional<Boolean> hasStrikethrough() {
        return this.strikethrough;
    }

    /**
     * Checks for whether text where this style is obfuscated.
     *
     * @return The value for the obfuscated property, or
     *         {@link Optional#absent()}
     */
    public Optional<Boolean> isObfuscated() {
        return this.obfuscated;
    }

    /**
     * Returns whether the given {@link TextStyle} is contained in this
     * {@link TextStyle}.
     *
     * <p>For example, a {@link TextStyle} with {@code bold: true, italic:
     * true}} would return {@code true} for <code>contains(
     * {@link TextStyles#BOLD})</code> and <code>contains(
     * {@link TextStyles#ITALIC}).</code></p>
     *
     * <p>If the specified {@link TextStyle} is a composite of multiple styles
     * it returns {@code true} if this style has at least all of the properties
     * set in the specified style.</p>
     *
     * @param styles The text styles to check
     * @return {@code true} if the given text styles are contained in this text
     *         style
     */
    public boolean contains(TextStyle... styles) {
        for (TextStyle style : checkNotNull(styles, "styles")) {
            checkNotNull(style, "style");
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
     * Utility method to compose the current TextStyle with the given styles,
     * with optional negation.
     *
     * @param styles The styles to compose with
     * @param negate Whether or not to negate the passed-in styles
     * @return The composed style
     */
    private TextStyle compose(TextStyle[] styles, boolean negate) {
        checkNotNull(styles, "styles");
        if (styles.length == 0) {
            return this;
        } else if (this.isEmpty() && styles.length == 1) {
            TextStyle style = checkNotNull(styles[0], "style");
            return negate ? style.negate() : style;
        }

        Optional<Boolean> boldAcc = this.bold;
        Optional<Boolean> italicAcc = this.italic;
        Optional<Boolean> underlineAcc = this.underline;
        Optional<Boolean> strikethroughAcc = this.strikethrough;
        Optional<Boolean> obfuscatedAcc = this.obfuscated;

        if (negate) {
            for (TextStyle style : styles) {
                checkNotNull(style, "style");
                boldAcc = propCompose(boldAcc, propNegate(style.bold));
                italicAcc = propCompose(italicAcc, propNegate(style.italic));
                underlineAcc = propCompose(underlineAcc, propNegate(style.underline));
                strikethroughAcc = propCompose(strikethroughAcc, propNegate(style.strikethrough));
                obfuscatedAcc = propCompose(obfuscatedAcc, propNegate(style.obfuscated));
            }
        } else {
            for (TextStyle style : styles) {
                checkNotNull(style, "style");
                boldAcc = propCompose(boldAcc, style.bold);
                italicAcc = propCompose(italicAcc, style.italic);
                underlineAcc = propCompose(underlineAcc, style.underline);
                strikethroughAcc = propCompose(strikethroughAcc, style.strikethrough);
                obfuscatedAcc = propCompose(obfuscatedAcc, style.obfuscated);
            }
        }

        return new TextStyle(
                boldAcc,
                italicAcc,
                underlineAcc,
                strikethroughAcc,
                obfuscatedAcc
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TextStyle)) {
            return false;
        }

        TextStyle that = (TextStyle) o;
        return this.bold.equals(that.bold)
                && this.italic.equals(that.italic)
                && this.underline.equals(that.underline)
                && this.obfuscated.equals(that.obfuscated)
                && this.strikethrough.equals(that.strikethrough);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.bold, this.italic, this.underline, this.obfuscated, this.strikethrough);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("bold", this.bold)
                .add("italic", this.italic)
                .add("underline", this.underline)
                .add("strikethrough", this.strikethrough)
                .add("obfuscated", this.obfuscated)
                .toString();
    }

    /**
     * Utility method to check if the given "super-property" contains the given
     * "sub-property".
     *
     * @param superprop The super property
     * @param subprop The sub property
     * @return True if the property is contained, otherwise false
     */
    private static boolean propContains(Optional<Boolean> superprop, Optional<Boolean> subprop) {
        return !subprop.isPresent() || superprop.equals(subprop);
    }

    /**
     * Utility method to negate a property if it is not null.
     *
     * @param prop The property to negate
     * @return The negated property, or {@link Optional#absent()}
     */
    private static Optional<Boolean> propNegate(Optional<Boolean> prop) {
        if (prop.isPresent()) {
            return OptBool.of(!prop.get());
        } else {
            return OptBool.ABSENT;
        }
    }

    /**
     * Utility method to perform a compose operation between two properties.
     *
     * @param prop1 The first property
     * @param prop2 The second property
     * @return The composition of the two properties
     */
    private static Optional<Boolean> propCompose(Optional<Boolean> prop1, Optional<Boolean> prop2) {
        if (!prop1.isPresent()) {
            return prop2;
        } else if (!prop2.isPresent()) {
            return prop1;
        } else if (!prop1.equals(prop2)) {
            return OptBool.ABSENT;
        } else {
            return prop1;
        }
    }

    /**
     * Represents a {@link TextStyle} that is not a composite, for example
     * {@link TextStyles#BOLD}. It is a base text style in Minecraft with a name
     * and a legacy formatting code.
     *
     * @see TextStyle
     * @see Base
     */
    public abstract static class Base extends TextStyle implements BaseFormatting {

        /**
         * Constructs a new {@link Base}.
         *
         * @param bold Whether text where this style is applied is bolded
         * @param italic Whether text where this style is applied is italicized
         * @param underline Whether text where this style is applied is
         *        underlined
         * @param obfuscated Whether text where this style is applied is
         *        obfuscated
         * @param strikethrough Whether text where this style is applied has a
         *        strikethrough
         */
        protected Base(@Nullable Boolean bold,
                @Nullable Boolean italic,
                @Nullable Boolean underline,
                @Nullable Boolean strikethrough,
                @Nullable Boolean obfuscated) {
            super(
                    bold,
                    italic,
                    underline,
                    strikethrough,
                    obfuscated
            );
        }

        @Override
        public boolean isComposite() {
            // By definition, base TextStyles are not composites
            return false;
        }

    }

}
