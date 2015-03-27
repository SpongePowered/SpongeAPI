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
 * TextColors is a list of text colors provided by Vanilla Minecraft.
 */
public final class TextColors {

    private TextColors() {
    }

    /**
     * Represents a base color that is used as default if no color is specified.
     * This will result in either the default color of the receiver or inherit
     * it from a parent {@link Text}.
     */
    public static final TextColor NONE = new TextColor() {

        private final Color color = new Color(0, 0, 0, 0);

        @Override
        public Color getColor() {
            return this.color;
        }

    };

    public static final TextColor.Base BLACK = null;
    public static final TextColor.Base DARK_BLUE = null;
    public static final TextColor.Base DARK_GREEN = null;
    public static final TextColor.Base DARK_AQUA = null;
    public static final TextColor.Base DARK_RED = null;
    public static final TextColor.Base DARK_PURPLE = null;
    public static final TextColor.Base GOLD = null;
    public static final TextColor.Base GRAY = null;
    public static final TextColor.Base DARK_GRAY = null;
    public static final TextColor.Base BLUE = null;
    public static final TextColor.Base GREEN = null;
    public static final TextColor.Base AQUA = null;
    public static final TextColor.Base RED = null;
    public static final TextColor.Base LIGHT_PURPLE = null;
    public static final TextColor.Base YELLOW = null;
    public static final TextColor.Base WHITE = null;
    
    /**
     * Resets the current color to the default one on the client. In most cases
     * this should be the same as {@link #WHITE}.
     */
    public static final TextColor.Base RESET = null;

}
