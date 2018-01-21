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
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * TextColors is a list of text colors provided by Vanilla Minecraft.
 */
public final class TextColors {

    // Suppress default constructor to ensure non-instantiability.
    private TextColors() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
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

    // SORTFIELDS:ON

    public static final TextColor AQUA = DummyObjectProvider.createFor(TextColor.class, "AQUA");

    public static final TextColor BLACK = DummyObjectProvider.createFor(TextColor.class, "BLACK");

    public static final TextColor BLUE = DummyObjectProvider.createFor(TextColor.class, "BLUE");

    public static final TextColor DARK_AQUA = DummyObjectProvider.createFor(TextColor.class, "DARK_AQUA");

    public static final TextColor DARK_BLUE = DummyObjectProvider.createFor(TextColor.class, "DARK_BLUE");

    public static final TextColor DARK_GRAY = DummyObjectProvider.createFor(TextColor.class, "DARK_GRAY");

    public static final TextColor DARK_GREEN = DummyObjectProvider.createFor(TextColor.class, "DARK_GREEN");

    public static final TextColor DARK_PURPLE = DummyObjectProvider.createFor(TextColor.class, "DARK_PURPLE");

    public static final TextColor DARK_RED = DummyObjectProvider.createFor(TextColor.class, "DARK_RED");

    public static final TextColor GOLD = DummyObjectProvider.createFor(TextColor.class, "GOLD");

    public static final TextColor GRAY = DummyObjectProvider.createFor(TextColor.class, "GRAY");

    public static final TextColor GREEN = DummyObjectProvider.createFor(TextColor.class, "GREEN");

    public static final TextColor LIGHT_PURPLE = DummyObjectProvider.createFor(TextColor.class, "LIGHT_PURPLE");

    public static final TextColor RED = DummyObjectProvider.createFor(TextColor.class, "RED");

    /**
     * Resets the current color to the default one on the client. In most cases
     * this should be the same as {@link #WHITE}.
     */
    public static final TextColor RESET = DummyObjectProvider.createFor(TextColor.class, "RESET");

    public static final TextColor WHITE = DummyObjectProvider.createFor(TextColor.class, "WHITE");

    public static final TextColor YELLOW = DummyObjectProvider.createFor(TextColor.class, "YELLOW");

    // SORTFIELDS:OFF

}
