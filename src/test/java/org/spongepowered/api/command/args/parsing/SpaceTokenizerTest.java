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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.spongepowered.api.command.args.ArgumentParseException;
import org.spongepowered.api.text.TestPlainTextSerializer;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(Parameterized.class)
public class SpaceTokenizerTest {

    private static List<String> parseFrom(String args) throws ArgumentParseException {
        return SpaceSplitInputTokenizer.INSTANCE.tokenize(args, false).stream()
                .map(SingleArg::getValue).collect(Collectors.toList());
    }

    @Parameterized.Parameters
    public static List<Object[]> testParameters() {
        return Lists.newArrayList(
                new Object[] { "", ImmutableList.of() },
                new Object[] { " ", ImmutableList.of() },
                new Object[] { "first second third", ImmutableList.of("first", "second", "third") },
                new Object[] { "first second third ", ImmutableList.of("first", "second", "third", "") },
                new Object[] { "first second  third", ImmutableList.of("first", "second", "third") },
                new Object[] { "first second  third ", ImmutableList.of("first", "second", "third", "") },
                new Object[] { "-abc value something --a=b -- pure strings",
                        ImmutableList.of("-abc", "value", "something", "--a=b", "--", "pure", "strings") },
                new Object[] { "a 'single quoted string' is here",
                        ImmutableList.of("a", "'single", "quoted", "string'", "is", "here") },
                new Object[] { "a \"double quoted string\" is here",
                        ImmutableList.of("a", "\"double", "quoted", "string\"", "is", "here") },
                new Object[] { "an \"unterminated quoted string is okay",
                        ImmutableList.of("an", "\"unterminated", "quoted", "string", "is", "okay") },
                new Object[] { "a test argument string ", ImmutableList.of("a", "test", "argument", "string", "") }
        );
    }

    @Parameterized.Parameter
    public String input;

    @Parameterized.Parameter(1)
    public List<String> output;

    @Before
    public void initialize() throws Exception {
        TestPlainTextSerializer.inject();
    }

    @Test
    public void test() throws ArgumentParseException {
        assertEquals(this.output, parseFrom(this.input));
    }
}
