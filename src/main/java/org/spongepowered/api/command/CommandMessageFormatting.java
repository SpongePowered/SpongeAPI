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
package org.spongepowered.api.command;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

public class CommandMessageFormatting {

    private CommandMessageFormatting() {
    }

    public static final Text FORWARD_SLASH = Text.of("/");
    public static final Text COMMA_SPACE = Text.of(", ");
    public static final Text LEFT_SQUARE = Text.of("[");
    public static final Text RIGHT_SQUARE = Text.of("]");
    public static final Text PIPE_TEXT = Text.of("|");
    public static final Text SPACE_TEXT = Text.of(" ");
    public static final Text STAR_TEXT = Text.of("*");
    public static final Text LT_TEXT = Text.of("<");
    public static final Text GT_TEXT = Text.of(">");
    public static final Text ELLIPSIS_TEXT = Text.of("…");
    public static final Text LEFT_PARENTHESIS = Text.of("(");
    public static final Text RIGHT_PARENTHESIS = Text.of(")");

}
