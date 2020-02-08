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
package org.spongepowered.api.text.format;

import static com.google.common.base.Preconditions.checkNotNull;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextElement;
import org.spongepowered.api.util.OptBool;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Represents an immutable text style of a {@link Text}. It is a utility that is
 * not normally present in Minecraft. It can be either empty, a {@link Type}
 * with an additional legacy formatting code or a composite.
 *
 * <p>Combined styles can be created using {@link TextStyle#of(TextStyle...)}
 * or using one of the {@link #and(TextStyle...)}, {@link #andNot(TextStyle...)}
 * or {@link #negate()} method.</p>
 *
 * <p>Each individual style within a TextStyle, e.g. bold, italic is not just a
 * boolean, but an {@code Optional&lt;Boolean&gt;} since it can be unapplied
 * (or, in Optional terms, "empty"). These styles will hereafter be referred to
 * as properties.<br> See the {@link OptBool} utility class for working with
 * properties.</p>
 *
 * <p>Implementation note: Absent styles should not appear in the final chat
 * component JSON. Properties that are set to true or false should appear, even
 * if they override inherited properties.</p>
 *
 * @see TextStyles
 */
public interface TextStyle extends TextElement {

    /**
     * Represents a {@link TextStyle} with all bases set to {@code false}.
     *
     * @return A base text style with lacking all styles
     */
    static TextStyle of() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).empty();
    }

    /**
     * Constructs a composite text style from the specified styles. This will
     * result in the same as calling {@link TextStyle#and(TextStyle...)} on all
     * of the text styles.
     *
     * @param styles The styles to combine
     * @return A composite text style from the specified styles
     */
    static TextStyle of(TextStyle... styles) {
        checkNotNull(styles);
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).empty().and(styles);
    }

    /**
     * Returns whether this {@link TextStyle} is a composite of multiple text
     * styles.
     *
     * @return {@code true} if this text style is a composite
     */
    boolean isComposite();

    /**
     * Returns whether this {@link TextStyle} has no set properties.
     *
     * @return {@code true} if this style is empty
     */
    boolean isEmpty();

    /**
     * Returns a new {@link TextStyle} with the bold property changed.
     *
     * @param bold Whether text where the new style is applied is bolded
     * @return The new text style
     */
    TextStyle bold(@Nullable Boolean bold);

    /**
     * Returns a new {@link TextStyle} with the italic property changed.
     *
     * @param italic Whether text where the new style is applied is italicized
     * @return The new text style
     */
    TextStyle italic(@Nullable Boolean italic);

    /**
     * Returns a new {@link TextStyle} with the underline property changed.
     *
     * @param underline Whether text where the new style is applied is underline
     * @return The new text style
     */
    TextStyle underline(@Nullable Boolean underline);

    /**
     * Returns a new {@link TextStyle} with the strikethrough property changed.
     *
     * @param strikethrough Whether text where the new style is applied has a
     *        strikethrough
     * @return The new text style
     */
    TextStyle strikethrough(@Nullable Boolean strikethrough);

    /**
     * Returns a new {@link TextStyle} with the obfuscated property changed.
     *
     * @param obfuscated Whether text where the new style is applied is
     *        obfuscated
     * @return The new text style
     */
    TextStyle obfuscated(@Nullable Boolean obfuscated);

    /**
     * Checks for whether text where this style is applied is bolded.
     *
     * @return The value for the bold property, or {@link Optional#empty()}
     */
    Optional<Boolean> hasBold();

    /**
     * Checks for whether text where this style is applied is italicized.
     *
     * @return The value for the italic property, or {@link Optional#empty()}
     */
    Optional<Boolean> hasItalic();

    /**
     * Checks for whether text where this style is applied has an underline.
     *
     * @return The value for the underline property, or {@link Optional#empty()}
     */
    Optional<Boolean> hasUnderline();

    /**
     * Checks for whether text where this style is applied has a strikethrough.
     *
     * @return The value for the strikethrough property, or
     *         {@link Optional#empty()}
     */
    Optional<Boolean> hasStrikethrough();

    /**
     * Checks for whether text where this style is obfuscated.
     *
     * @return The value for the obfuscated property, or
     *         {@link Optional#empty()}
     */
    Optional<Boolean> hasObfuscated();

    /**
     * Returns whether the given {@link TextStyle} is contained in this
     * {@link TextStyle}.
     *
     * <p>For example, a {@link TextStyle} with {@code bold: true, italic:
     * true} would return {@code true} for <code>contains(
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
    boolean contains(TextStyle... styles);

    /**
     * Negates this {@link TextStyle}. This is useful for undoing text styles
     * that are inherited from parent messages.
     *
     * @return The inverse of this text style
     */
    TextStyle negate();

    /**
     * Composes this {@link TextStyle} with the specified text styles.
     *
     * @param styles The text styles to compose this one with
     * @return A new text style composed out of the given text styles
     */
    TextStyle and(TextStyle... styles);

    /**
     * Composes this {@link TextStyle} with the passed in TextStyles, but
     * negates them before composition. This is the same as negating all the
     * passed in {@link TextStyle} and then using the {@link #and(TextStyle...)}
     * method.
     *
     * @param styles The text styles to compose this one with
     * @return A new text style composed out of the given text styles
     */
    TextStyle andNot(TextStyle... styles);

    @Override
    default void applyTo(Text.Builder builder) {
        builder.style(this);
    }

    /**
     * Represents a {@link TextStyle} that is not a composite, for example
     * {@link TextStyles#BOLD}. It is a base text style in Minecraft with a
     * name.
     *
     * @see TextStyle
     * @see Type
     */
    @CatalogedBy(TextStyles.class)
    interface Type extends CatalogType, TextStyle {

        @Override
        default boolean isComposite() {
            // By definition, base TextStyles are not composites
            return false;
        }
    }

    interface Factory {

        TextStyle empty();
    }
}
