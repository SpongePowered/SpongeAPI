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
package org.spongepowered.api.command.args;

import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.parsing.InputTokenizer;
import org.spongepowered.api.text.TestPlainTextSerializer;
import org.spongepowered.api.text.Text;

import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;

public class PatternMatchingCommandElementTest {

    private final InputTokenizer TOKENIZER = InputTokenizer.quotedStrings(true);
    private CommandElement testElement;
    private Text testKey;

    @Before
    public void initialize() throws Exception {
        TestPlainTextSerializer.inject();
        this.testKey = Text.of("testkey");
        this.testElement = new TestCommandElement(this.testKey);
    }

    @Test
    public void testGetOneElementThatIsSubstringOfAnother() throws ArgumentParseException {
        CommandSource commandSource = Mockito.mock(CommandSource.class);
        CommandArgs args = new CommandArgs("test1", TOKENIZER.tokenize("test1", true));
        CommandContext context = new CommandContext();
        this.testElement.parse(commandSource, args, context);
        Assert.assertEquals("test1", context.requireOne(this.testKey));
    }

    @Test
    public void testGetAllElementsThatMatchTestSubstring() throws ArgumentParseException {
        CommandSource commandSource = Mockito.mock(CommandSource.class);
        CommandArgs args = new CommandArgs("test", TOKENIZER.tokenize("test", true));
        CommandContext context = new CommandContext();
        this.testElement.parse(commandSource, args, context);
        Collection<String> elements = context.getAll(this.testKey);
        Assert.assertTrue(elements.contains("test1"));
        Assert.assertTrue(elements.contains("test2"));
        Assert.assertTrue(elements.contains("test123"));
        Assert.assertTrue(elements.contains("test124"));
    }

    @Test
    public void testGetAllElementsThatMatchTest1Substring() throws ArgumentParseException {
        CommandSource commandSource = Mockito.mock(CommandSource.class);
        CommandArgs args = new CommandArgs("test12", TOKENIZER.tokenize("test12", true));
        CommandContext context = new CommandContext();
        this.testElement.parse(commandSource, args, context);
        Collection<String> elements = context.getAll(this.testKey);
        Assert.assertTrue(elements.contains("test123"));
        Assert.assertTrue(elements.contains("test124"));
        Assert.assertFalse(elements.contains("test1"));
        Assert.assertFalse(elements.contains("test2"));
    }

    @Test(expected = ArgumentParseException.class)
    public void testGibberishThrowsException() throws ArgumentParseException {
        CommandSource commandSource = Mockito.mock(CommandSource.class);
        CommandArgs args = new CommandArgs("gibberish", TOKENIZER.tokenize("gibberish", true));
        CommandContext context = new CommandContext();
        this.testElement.parse(commandSource, args, context);
    }

    public static final class TestCommandElement extends PatternMatchingCommandElement {

        private final List<String> choices = ImmutableList.of(
                "test1",
                "test2",
                "test123",
                "test124"
        );

        protected TestCommandElement(@Nullable Text key) {
            super(key, false);
        }

        @Override
        protected Iterable<String> getChoices(CommandSource source) {
            return this.choices;
        }

        @Override
        protected Object getValue(String choice) throws IllegalArgumentException {
            if (this.choices.contains(choice)) {
                return choice;
            }
            throw new IllegalArgumentException("Nope");
        }

    }

}
