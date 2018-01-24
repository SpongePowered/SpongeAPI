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

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * Represents a list of the text styles provided by Vanilla Minecraft.
 */
public final class TextStyles {

    // Suppress default constructor to ensure non-instantiability.
    private TextStyles() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

    /**
     * Represents an empty {@link TextStyle}.
     */
    public static final TextStyle NONE = new NoneTextStyle();

    public static final TextStyle.Base OBFUSCATED = new DummyTextStyle("OBFUSCATED");
    public static final TextStyle.Base BOLD = new DummyTextStyle("BOLD");
    public static final TextStyle.Base STRIKETHROUGH = new DummyTextStyle("STRIKETHROUGH");
    public static final TextStyle.Base UNDERLINE = new DummyTextStyle("UNDERLINE");
    public static final TextStyle.Base ITALIC = new DummyTextStyle("ITALIC");

    /**
     * Represents a {@link TextStyle} with all bases set to {@code false}.
     */
    public static final TextStyle.Base RESET = new DummyTextStyle("RESET");

    /**
     * Returns an empty {@link TextStyle}.
     *
     * @return An empty text style
     */
    public static TextStyle of() {
        return NONE;
    }

    /**
     * Constructs a composite text style from the specified styles. This will
     * result in the same as calling {@link TextStyle#and(TextStyle...)} on all
     * of the text styles.
     *
     * @param styles The styles to combine
     * @return A composite text style from the specified styles
     */
    public static TextStyle of(TextStyle... styles) {
        return NONE.and(styles);
    }

    /**
     * A private class that represents the type of the {@link #NONE} text style.
     */
    private static final class NoneTextStyle extends TextStyle.Base {

        /**
         * Constructs a new {@link NoneTextStyle}.
         */
        NoneTextStyle() {
            super(
                null,
                null,
                null,
                null,
                null
            );
        }

        @Override
        public String getId() {
            return "NONE";
        }

        @Override
        public String getName() {
            return "NONE";
        }
    }

    private static final class DummyTextStyle extends TextStyle.Base {

        private final String name;

        DummyTextStyle(String fieldName) {
            super(false, false, false, false, false);
            this.name = fieldName;
        }

        @Override
        public boolean isComposite() {
            throw new UnsupportedOperationException("TextStyles." + this.name + " is not properly assigned!");
        }

        @Override
        public boolean isEmpty() {
            throw new UnsupportedOperationException("TextStyles." + this.name + " is not properly assigned!");
        }

        @Override
        public TextStyle bold(@Nullable Boolean bold) {
            throw new UnsupportedOperationException("TextStyles." + this.name + " is not properly assigned!");
        }

        @Override
        public TextStyle italic(@Nullable Boolean italic) {
            throw new UnsupportedOperationException("TextStyles." + this.name + " is not properly assigned!");
        }

        @Override
        public TextStyle underline(@Nullable Boolean underline) {
            throw new UnsupportedOperationException("TextStyles." + this.name + " is not properly assigned!");
        }

        @Override
        public TextStyle strikethrough(@Nullable Boolean strikethrough) {
            throw new UnsupportedOperationException("TextStyles." + this.name + " is not properly assigned!");
        }

        @Override
        public TextStyle obfuscated(@Nullable Boolean obfuscated) {
            throw new UnsupportedOperationException("TextStyles." + this.name + " is not properly assigned!");
        }

        @Override
        public Optional<Boolean> isBold() {
            throw new UnsupportedOperationException("TextStyles." + this.name + " is not properly assigned!");
        }

        @Override
        public Optional<Boolean> isItalic() {
            throw new UnsupportedOperationException("TextStyles." + this.name + " is not properly assigned!");
        }

        @Override
        public Optional<Boolean> hasUnderline() {
            throw new UnsupportedOperationException("TextStyles." + this.name + " is not properly assigned!");
        }

        @Override
        public Optional<Boolean> hasStrikethrough() {
            throw new UnsupportedOperationException("TextStyles." + this.name + " is not properly assigned!");
        }

        @Override
        public Optional<Boolean> isObfuscated() {
            throw new UnsupportedOperationException("TextStyles." + this.name + " is not properly assigned!");
        }

        @Override
        public boolean contains(TextStyle... styles) {
            throw new UnsupportedOperationException("TextStyles." + this.name + " is not properly assigned!");
        }

        @Override
        public TextStyle negate() {
            throw new UnsupportedOperationException("TextStyles." + this.name + " is not properly assigned!");
        }

        @Override
        public TextStyle and(TextStyle... styles) {
            throw new UnsupportedOperationException("TextStyles." + this.name + " is not properly assigned!");
        }

        @Override
        public TextStyle andNot(TextStyle... styles) {
            throw new UnsupportedOperationException("TextStyles." + this.name + " is not properly assigned!");
        }

        @Override
        public void applyTo(Text.Builder builder) {
            throw new UnsupportedOperationException("TextStyles." + this.name + " is not properly assigned!");
        }

        @Override
        public String getId() {
            throw new UnsupportedOperationException("TextStyles." + this.name + " is not properly assigned!");
        }

        @Override
        public String getName() {
            throw new UnsupportedOperationException("TextStyles." + this.name + " is not properly assigned!");
        }
    }

}
