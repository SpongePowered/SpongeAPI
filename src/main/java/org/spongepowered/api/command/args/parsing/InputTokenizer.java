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
package org.spongepowered.api.command.args.parsing;

import org.spongepowered.api.command.args.ArgumentParseException;

import java.util.List;

public interface InputTokenizer {

    /**
     * Use an input string tokenizer that supports quoted arguments and
     * character escapes.
     *
     * <p>Forcing lenient to true makes the following apply:</p>
     *
     * <ul>
     *     <li>Unclosed quotations are treated as a single string from the
     *     opening quotation to the end of the arguments rather than throwing
     *     an exception </li>
     * </ul>
     *
     * @param forceLenient Whether the tokenizer is forced into lenient mode
     * @return the appropriate tokenizer
     */
    static InputTokenizer quotedStrings(boolean forceLenient) {
        return new QuotedStringTokenizer(true, forceLenient, false);
    }

    /**
     * Returns an input tokenizer that takes input strings and splits them by
     * space.
     *
     * @return The appropriate tokenizer
     */
    static InputTokenizer spaceSplitString() {
        return SpaceSplitInputTokenizer.INSTANCE;
    }

    /**
     * Returns an input tokenizer that returns the input string as a single
     * argument.
     *
     * @return The appropriate tokenizer
     */
    static InputTokenizer rawInput() {
        return RawStringInputTokenizer.INSTANCE;
    }

    /**
     * Take the input string and split it as appropriate into argument tokens.
     *
     * @param arguments The provided arguments
     * @param lenient Whether to parse leniently
     * @return The tokenized strings. Empty list if error occurs
     * @throws ArgumentParseException if an invalid input is provided
     */
    List<SingleArg> tokenize(String arguments, boolean lenient) throws ArgumentParseException;

}
