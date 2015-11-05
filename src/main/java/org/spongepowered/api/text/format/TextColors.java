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

import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.Color;

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

        private final Color color = Color.BLACK;

        @Override
        public String getName() {
            return "NONE";
        }

        @Override
        public Color getColor() {
            return this.color;
        }

        @Override
        public String getId() {
            return "NONE";
        }

        @Override
        public String toString() {
            return getId();
        }

    };

    public static final TextColor BLACK = null;
    public static final TextColor DARK_BLUE = null;
    public static final TextColor DARK_GREEN = null;
    public static final TextColor DARK_AQUA = null;
    public static final TextColor DARK_RED = null;
    public static final TextColor DARK_PURPLE = null;
    public static final TextColor GOLD = null;
    public static final TextColor GRAY = null;
    public static final TextColor DARK_GRAY = null;
    public static final TextColor BLUE = null;
    public static final TextColor GREEN = null;
    public static final TextColor AQUA = null;
    public static final TextColor RED = null;
    public static final TextColor LIGHT_PURPLE = null;
    public static final TextColor YELLOW = null;
    public static final TextColor WHITE = null;

    /**
     * Resets the current color to the default one on the client. In most cases
     * this should be the same as {@link #WHITE}.
     */
    public static final TextColor RESET = null;

}
