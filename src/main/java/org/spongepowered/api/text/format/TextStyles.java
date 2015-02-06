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
 * TextStyles is a list of the text styles provided by Vanilla Minecraft.
 */
public final class TextStyles {

    private TextStyles() {
    }

    public static final TextStyle.Base OBFUSCATED = null;
    public static final TextStyle.Base BOLD = null;
    public static final TextStyle.Base STRIKETHROUGH = null;
    public static final TextStyle.Base UNDERLINE = null;
    public static final TextStyle.Base ITALIC = null;

    public static final TextStyle NONE = new TextStyle();

    /**
     * Resets all currently applied text styles to their default values.
     */
    public static final TextStyle.Base RESET = null;

    /**
     * Constructs a composite text style from the specified styles. This will
     * result in the same as calling {@link TextStyle#and(TextStyle...)} on all
     * of the text styles.
     *
     * @param styles The styles to combine.
     * @return A composite text style from the specified styles
     */
    public static TextStyle of(TextStyle... styles) {
        return NONE.and(styles);
    }

}
