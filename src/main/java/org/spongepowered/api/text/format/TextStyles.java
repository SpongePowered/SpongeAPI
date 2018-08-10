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

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * Represents a list of the text styles provided by Vanilla Minecraft.
 */
public final class TextStyles {

    /**
     * Represents an empty {@link TextStyle}.
     */
    public static final TextStyle NONE = DummyObjectProvider.createFor(TextStyle.class, "NONE");

    public static final TextStyle.Base OBFUSCATED = DummyObjectProvider.createFor(TextStyle.Base.class, "OBFUSCATED");
    public static final TextStyle.Base BOLD = DummyObjectProvider.createFor(TextStyle.Base.class,"BOLD");
    public static final TextStyle.Base STRIKETHROUGH = DummyObjectProvider.createFor(TextStyle.Base.class,"STRIKETHROUGH");
    public static final TextStyle.Base UNDERLINE = DummyObjectProvider.createFor(TextStyle.Base.class,"UNDERLINE");
    public static final TextStyle.Base ITALIC = DummyObjectProvider.createFor(TextStyle.Base.class,"ITALIC");

    /**
     * Represents a {@link TextStyle} with all bases set to {@code false}.
     */
    public static final TextStyle.Base RESET = DummyObjectProvider.createFor(TextStyle.Base.class,"RESET");

    private TextStyles() {
    }

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
}
