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

import org.spongepowered.api.text.message.Message;

/**
 * Represents an immutable text style of a {@link Message}.
 *
 * <p>
 * Combined styles can be created using {@link TextStyles#of(TextStyle...)} or
 * using one of the {@link #and(TextStyle...)}, {@link #andNot (TextStyle...)}
 * or {@link #negate()} method.
 * </p>
 *
 * @see TextStyles
 */
public interface TextStyle {

    /**
     * Returns whether this text style is a composite of multiple text styles.
     *
     * @return True if this text style is a composite
     */
    boolean isComposite();

    /**
     * Returns whether the given {@link TextStyle} is contained in this
     * {@link TextStyle}.
     *
     * <p>
     * For example, a {@link TextStyle} with {@code [Bold, Italic]} would return
     * true for <code>is({@link TextStyles#BOLD})</code> and
     * <code>is({@link TextStyles#ITALIC}).</code>
     * </p>
     *
     * <p>
     * If the specified {@link TextStyle} is a composite of multiple styles it
     * returns true if this style has at least all of the properties set in the
     * specified style.
     * </p>
     *
     * @param style The text style to check
     * @return True if the given text style is contained in this text style
     */
    boolean is(TextStyle style);

    // TODO: Decide if this would fit better inside the builder

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

    /**
     * Represent a {@link TextStyle} with {@link LegacyFormatting}.
     */
    interface Base extends TextStyle, LegacyFormatting {

    }

}
