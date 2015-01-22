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

import org.spongepowered.api.text.Text;

import java.awt.Color;

/**
 * Represents the color of the text of a {@link Text}.
 *
 * @see TextColors
 */
public interface TextColor {

    /**
     * Returns the corresponding {@link Color} for this {@link TextColor}.
     *
     * @return The RGB color of this text color
     */
    Color getColor();

    /**
     * Returns whether this color resets the color to the default one.
     *
     * @return True if this color is the reset color
     */
    boolean isReset();

    /**
     * Represents a base {@link TextColor} in Minecraft. It can be represented using legacy formatting codes.
     *
     * @see TextColors
     */
    interface Base extends TextColor, BaseFormatting {

    }

}
