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

import static org.junit.Assert.assertEquals;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.spongepowered.api.command.args.ArgumentParseException;
import org.spongepowered.api.text.TestPlainTextSerializer;

import java.util.Collections;
import java.util.List;

import javax.annotation.Nullable;

public class QuotedStringTokenizerTest {

    private static List<String> parseFrom(String args) throws ArgumentParseException {
        return Lists.transform(new QuotedStringTokenizer(true, false, false).tokenize(args, false), new Function<SingleArg, String>() {
            @Nullable
            @Override
            public String apply(SingleArg input) {
                return input.getValue();
            }
        });
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void initialize() throws Exception {
        TestPlainTextSerializer.inject();
    }

    @Test
    public void testEmptyString() throws ArgumentParseException {
        assertEquals(Collections.<String>emptyList(), parseFrom(""));
    }

    @Test
    public void testUnquotedString() throws ArgumentParseException {
        assertEquals(ImmutableList.of("first", "second", "third"),
                parseFrom("first second third"));
    }

    @Test
    public void testFlagString() throws ArgumentParseException {
        assertEquals(ImmutableList.of("-abc", "value", "something", "--a=b", "--", "pure", "strings"),
                parseFrom("-abc value something --a=b -- pure strings"));
    }

    @Test
    public void testSingleQuotedString() throws ArgumentParseException {
        assertEquals(ImmutableList.of("a", "single quoted string", "is", "here"),
                parseFrom("a 'single quoted string' is here"));
    }

    @Test
    public void testDoubleQuotedString() throws ArgumentParseException {
        assertEquals(ImmutableList.of("a", "double quoted string", "is", "here"),
                parseFrom("a \"double quoted string\" is here"));
    }

    @Test
    public void testUnterminatedQuote() throws ArgumentParseException {
        this.expectedException.expect(ArgumentParseException.class);
        this.expectedException.expectMessage("Unterminated quoted string");
        parseFrom("an \"unterminated quoted string is bad");
    }

    @Test
    public void testEscape() throws ArgumentParseException {
        assertEquals(ImmutableList.of("this", "demonstrates escapes", "\"of", "various\' characters"),
                parseFrom("this demonstrates\\ escapes \\\"of 'various\\' characters\'"));
    }

    @Test
    public void testTrailingSpace() throws ArgumentParseException {
        assertEquals(ImmutableList.of("a", "test", "argument", "string", ""), parseFrom("a test argument string "));
    }
}
