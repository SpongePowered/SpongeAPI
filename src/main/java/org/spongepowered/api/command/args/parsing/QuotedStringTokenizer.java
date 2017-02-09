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
import org.spongepowered.api.text.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Parser for converting a quoted string into a list of arguments.
 *
 * <p>Grammar is roughly (yeah, this is not really a proper grammar but it gives
 * you an idea of what's happening:</p>
 *
 * <blockquote><pre> WHITESPACE = Character.isWhiteSpace(codePoint)
 * CHAR := (all unicode)
 * ESCAPE := '\' CHAR
 * QUOTE = ' | "
 * UNQUOTED_ARG := (CHAR | ESCAPE)+ WHITESPACE
 * QUOTED_ARG := QUOTE (CHAR | ESCAPE)+ QUOTE
 * ARGS := ((UNQUOTED_ARG | QUOTED_ARG) WHITESPACE+)+</pre></blockquote>
 */
class QuotedStringTokenizer implements InputTokenizer {
    private static final int CHAR_BACKSLASH = '\\';
    private static final int CHAR_SINGLE_QUOTE = '\'';
    private static final int CHAR_DOUBLE_QUOTE = '"';
    private final boolean handleQuotedStrings;
    private final boolean forceLenient;
    private final boolean trimTrailingSpace;

    QuotedStringTokenizer(boolean handleQuotedStrings, boolean forceLenient, boolean trimTrailingSpace) {
        this.handleQuotedStrings = handleQuotedStrings;
        this.forceLenient = forceLenient;
        this.trimTrailingSpace = trimTrailingSpace;
    }

    @Override
    public List<SingleArg> tokenize(String arguments, boolean lenient) throws ArgumentParseException {
        if (arguments.length() == 0) {
            return Collections.emptyList();
        }

        final TokenizerState state = new TokenizerState(arguments, lenient);
        List<SingleArg> returnedArgs = new ArrayList<>(arguments.length() / 4);
        if (this.trimTrailingSpace) {
            skipWhiteSpace(state);
        }
        while (state.hasMore()) {
            if (!this.trimTrailingSpace) {
                skipWhiteSpace(state);
            }
            int startIdx = state.getIndex() + 1;
            String arg = nextArg(state);
            returnedArgs.add(new SingleArg(arg, startIdx, state.getIndex()));
            if (this.trimTrailingSpace) {
                skipWhiteSpace(state);
            }
        }
        return returnedArgs;
    }

    // Parsing methods

    private void skipWhiteSpace(TokenizerState state) throws ArgumentParseException {
        if (!state.hasMore()) {
            return;
        }
        while (state.hasMore() && Character.isWhitespace(state.peek())) {
            state.next();
        }
    }

    private String nextArg(TokenizerState state) throws ArgumentParseException {
        StringBuilder argBuilder = new StringBuilder();
        if (state.hasMore()) {
            int codePoint = state.peek();
            if (this.handleQuotedStrings && (codePoint == CHAR_DOUBLE_QUOTE || codePoint == CHAR_SINGLE_QUOTE)) {
                // quoted string
                parseQuotedString(state, codePoint, argBuilder);
            } else {
                parseUnquotedString(state, argBuilder);
            }
        }
        return argBuilder.toString();
    }

    private void parseQuotedString(TokenizerState state, int startQuotation, StringBuilder builder) throws ArgumentParseException {
        // Consume the start quotation character
        int nextCodePoint = state.next();
        if (nextCodePoint != startQuotation) {
            throw state.createException(Text.of(String.format("Actual next character '%c' did not match expected quotation character '%c'",
                    nextCodePoint, startQuotation)));
        }

        while (true) {
            if (!state.hasMore()) {
                if (state.isLenient() || this.forceLenient) {
                    return;
                }
                throw state.createException(Text.of("Unterminated quoted string found"));
            }
            nextCodePoint = state.peek();
            if (nextCodePoint == startQuotation) {
                state.next();
                return;
            } else if (nextCodePoint == CHAR_BACKSLASH) {
                parseEscape(state, builder);
            } else {
                builder.appendCodePoint(state.next());
            }
        }
    }

    private void parseUnquotedString(TokenizerState state, StringBuilder builder) throws ArgumentParseException {
        while (state.hasMore()) {
            int nextCodePoint = state.peek();
            if (Character.isWhitespace(nextCodePoint)) {
                return;
            } else if (nextCodePoint == CHAR_BACKSLASH) {
                parseEscape(state, builder);
            } else {
                builder.appendCodePoint(state.next());
            }
        }
    }

    private void parseEscape(TokenizerState state, StringBuilder builder) throws ArgumentParseException {
        state.next(); // Consume \
        builder.appendCodePoint(state.next()); // TODO: Unicode character escapes (\u00A7 type thing)?
    }

}
