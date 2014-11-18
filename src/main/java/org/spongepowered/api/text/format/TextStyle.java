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

/**
 * A TextStyle represents the style that a {@link org.spongepowered.api.text.message.Message} has.
 * It is an immutable class.
 * There are several Base styles specified in {@link org.spongepowered.api.text.format.TextStyles}
 * which are the Minecraft base types.
 * From these types, the {@link #and(TextStyle...)}, {@link #andNot(TextStyle...)}, and {@link #negate()} methods
 * can compose text styles together.
 *
 * <p>Interestingly enough, TextStyle actually forms a monoid with the {@link #and(TextStyle...)} operation
 * as the monoid operation and the TextStyle elements as the elements of the monoid. I do not want to prove
 * closure or the other monoid laws, but yay math!</p>
 */
public interface TextStyle {

    /**
     * Returns whether this text style is a composite of multiple base text styles.
     *
     * @return A boolean for whether this text style is a composite
     */
    boolean isComposite();

    /**
     * Checks for if the given TextStyle is contained in this TextStyle.
     * It is equivalent if checking that applying this TextStyle includes applying the passed in TextStyle.
     *
     * @param style The TextStyle to check for existence
     * @return A boolean representing if the given TextStyle is in this TextStyle
     */
    boolean is(TextStyle style);

    // TODO: Decide if this would fit better inside the builder

    /**
     * Negates this text style.
     * This is useful for undoing text styles that are inherited from parent Messages.
     *
     * @return A new TextStyle that is the inverse of this TextStyle.
     */
    TextStyle negate();

    /**
     * Composes this TextStyle with the passed in TextStyles.
     *
     * @param styles A list of TextStyles to compose this one with
     * @return A new TextStyle composed out of passed in text styles
     */
    TextStyle and(TextStyle... styles);

    /**
     * Composes this TextStyle with the passed in TextStyles, but negates them before composition.
     * This is the same as negating all the passed in TextStyles and then using the {@link #and(TextStyle...)} method.
     *
     * @param styles A list of TextStyles to compose this one with
     * @return A new TextStyle composed out of passed in text styles
     */
    TextStyle andNot(TextStyle... styles);

    /**
     * A Base text style is a text style that is represented in Minecraft.
     * There are several Base styles specified in {@link org.spongepowered.api.text.format.TextStyles}
     * which are the Minecraft base types.
     * Base extends FormattingCode because it does have a corresponding formatting code;
     * it is a single, pure text style.
     */
    interface Base extends FormattingCode, TextStyle { }

}
