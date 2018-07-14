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
import org.junit.Test;
import org.spongepowered.api.command.args.ArgumentParseException;

import java.util.List;
import java.util.stream.Collectors;

public class SpaceSplitInputTokenizerTest {

    private static List<String> parseFrom(String args) throws ArgumentParseException {
        return InputTokenizer.spaceSplitString().tokenize(args, false).stream().map(SingleArg::getValue).collect(Collectors.toList());
    }

    @Test
    public void testEmptyString() throws ArgumentParseException {
        assertEquals(ImmutableList.of(), parseFrom(""));
    }

    @Test
    public void testSpaceString() throws ArgumentParseException {
        assertEquals(ImmutableList.of(""), parseFrom(" "));
    }

    @Test
    public void testStandardString() throws ArgumentParseException {
        assertEquals(ImmutableList.of("arg1", "arg2", "arg3"), parseFrom("arg1 arg2 arg3"));
    }

    @Test
    public void testDoubleSpacedString() throws ArgumentParseException {
        assertEquals(ImmutableList.of("arg1", "arg2", "arg3"), parseFrom("arg1 arg2  arg3"));
    }

    @Test
    public void testTrailingSpaceString() throws ArgumentParseException {
        assertEquals(ImmutableList.of("arg1", "arg2", "arg3", ""), parseFrom("arg1 arg2 arg3 "));
    }
}
