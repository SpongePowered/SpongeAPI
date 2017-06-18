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
package org.spongepowered.api.command.parameter.token;

import org.spongepowered.api.command.parameter.ArgumentParseException;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

public final class InputTokenizers {

    private InputTokenizers() {}

    // SORTFIELDS:ON

    /**
     * Use an input string tokenizer that supports quoted arguments and
     * character escapes.
     *
     * <p>The grammar is roughly:</p>
     *
     * <blockquote><pre> WHITESPACE = Character.isWhiteSpace(codePoint)
     * CHAR := (all unicode)
     * ESCAPE := '\' CHAR
     * QUOTE = ' | "
     * UNQUOTED_ARG := (CHAR | ESCAPE)+ WHITESPACE
     * QUOTED_ARG := QUOTE (CHAR | ESCAPE)+ QUOTE
     * ARGS := ((UNQUOTED_ARG | QUOTED_ARG) WHITESPACE+)+</pre></blockquote>
     *
     * <p>Using the lenient parser means that the following applies:</p>
     *
     * <ul>
     *     <li>Unclosed quotations are treated as a single string from the
     *     opening quotation to the end of the arguments rather than throwing
     *     an exception.</li>
     * </ul>
     *
     * <p>See also {@link #QUOTED_STRING}</p>
     */
    public static final InputTokenizer LENIENT_QUOTED_STRING = DummyObjectProvider.createFor(InputTokenizer.class, "LENIENT_QUOTED_STRING");

    /**
     * Use an input string tokenizer that supports quoted arguments and
     * character escapes.
     *
     * <p>Using this parser means that the following might apply:</p>
     *
     * <ul>
     *     <li>Unclosed quotations are treated as an error condition, and a
     *     {@link ArgumentParseException} will be thrown if this occurs.</li>
     *     <li>Implementations can request lenient parsing.</li>
     * </ul>
     *
     * <p>See also {@link #LENIENT_QUOTED_STRING}</p>
     */
    public static final InputTokenizer QUOTED_STRING = DummyObjectProvider.createFor(InputTokenizer.class, "QUOTED_STRING");

    /**
     * Returns an input tokenizer that returns the input string as a single
     * argument.
     */
    public static final InputTokenizer RAW_STRING = DummyObjectProvider.createFor(InputTokenizer.class, "RAW_STRING");

    /**
     * Returns an input tokenizer that takes input strings and splits them by
     * space.
     */
    public static final InputTokenizer SPACE_SPLIT = DummyObjectProvider.createFor(InputTokenizer.class, "SPACE_SPLIT");

    // SORTFIELDS:OFF

}
