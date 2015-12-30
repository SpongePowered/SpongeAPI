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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.spongepowered.api.command.args.GenericArguments.allOf;
import static org.spongepowered.api.command.args.GenericArguments.bool;
import static org.spongepowered.api.command.args.GenericArguments.choices;
import static org.spongepowered.api.command.args.GenericArguments.enumValue;
import static org.spongepowered.api.command.args.GenericArguments.firstParsing;
import static org.spongepowered.api.command.args.GenericArguments.integer;
import static org.spongepowered.api.command.args.GenericArguments.none;
import static org.spongepowered.api.command.args.GenericArguments.optional;
import static org.spongepowered.api.command.args.GenericArguments.optionalWeak;
import static org.spongepowered.api.command.args.GenericArguments.remainingJoinedStrings;
import static org.spongepowered.api.command.args.GenericArguments.repeated;
import static org.spongepowered.api.command.args.GenericArguments.seq;
import static org.spongepowered.api.command.args.GenericArguments.string;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.util.test.TestHooks;


/**
 * Tests for all argument types contained in GenericArguments.
 */
public class GenericArgumentsTest {

    private static final CommandSource MOCK_SOURCE = Mockito.mock(CommandSource.class);
    static final CommandExecutor NULL_EXECUTOR = new CommandExecutor() {
        @Override
        public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
            return CommandResult.empty();
        }
    };

    static {
        TestHooks.initialize();
    }

    private static Text untr(String string) {
        return Text.of(string);
    }

    @Rule
    public ExpectedException expected = ExpectedException.none();

    private static CommandContext parseForInput(String input, CommandElement element) throws ArgumentParseException {
        CommandSpec spec = CommandSpec.builder()
                .arguments(element)
                .executor(NULL_EXECUTOR)
                .build();
        final CommandArgs args = new CommandArgs(input, spec.getInputTokenizer().tokenize(input, false));
        final CommandContext context = new CommandContext();
        spec.populateContext(MOCK_SOURCE, args, context);
        return context;
    }

    @Test(expected = CommandException.class)
    public void testNone() throws ArgumentParseException {
        parseForInput("a", none());
    }

    @Test
    public void testSequence() throws ArgumentParseException {
        CommandElement el = seq(string(untr("one")), string(untr("two")), string(untr("three")));
        CommandContext context = parseForInput("a b c", el);
        assertEquals("a", context.getOne("one").get());
        assertEquals("b", context.getOne("two").get());
        assertEquals("c", context.getOne("three").get());

        this.expected.expect(ArgumentParseException.class);
        parseForInput("a b", el);
    }

    @Test
    public void testChoices() throws ArgumentParseException {
        CommandElement el = choices(untr("val"), ImmutableMap.of("a", "one", "b", "two"));
        CommandContext context = parseForInput("a", el);
        assertEquals("one", context.getOne("val").get());

        this.expected.expect(ArgumentParseException.class);
        parseForInput("c", el);
    }

    @Test
    public void testFirstParsing() throws ArgumentParseException {
        CommandElement el = firstParsing(integer(untr("val")), string(untr("val")));
        CommandContext context = parseForInput("word", el);
        assertEquals("word", context.getOne("val").get());

        context = parseForInput("42", el);
        assertEquals(42, context.getOne("val").get());
    }

    @Test
    public void testOptional() throws ArgumentParseException {
        CommandElement el = optional(string(untr("val")));
        CommandContext context = parseForInput("", el);
        assertFalse(context.getOne("val").isPresent());

        el = optional(string(untr("val")), "def");
        context = parseForInput("", el);
        assertEquals("def", context.getOne("val").get());

        el = seq(optionalWeak(integer(untr("val"))), string(untr("str")));
        context = parseForInput("hello", el);
        assertEquals("hello", context.getOne("str").get());

        el = seq(optional(integer(untr("val")), string(untr("str"))));
        this.expected.expect(ArgumentParseException.class);
        parseForInput("hello", el);
    }

    @Test
    public void testRepeated() throws ArgumentParseException {
        CommandContext context = parseForInput("1 1 2 3 5", repeated(integer(untr("key")), 5));
        assertEquals(ImmutableList.<Object>of(1, 1, 2, 3, 5), ImmutableList.copyOf(context.getAll("key")));
    }

    @Test
    public void testAllOf() throws ArgumentParseException {
        CommandContext context = parseForInput("2 4 8 16 32 64 128", allOf(integer(untr("key"))));
        assertEquals(ImmutableList.<Object>of(2, 4, 8, 16, 32, 64, 128), ImmutableList.copyOf(context.getAll("key")));
    }

    @Test
    public void testString() throws ArgumentParseException {
        CommandContext context = parseForInput("\"here it is\"", string(untr("a value")));
        assertEquals("here it is", context.getOne("a value").get());
    }

    @Test
    public void testInteger() throws ArgumentParseException {
        CommandContext context = parseForInput("52", integer(untr("a value")));
        assertEquals(52, context.getOne("a value").get());

        this.expected.expect(ArgumentParseException.class);
        parseForInput("notanumber", integer(untr("a value")));
    }

    @Test
    public void testBool() throws ArgumentParseException {
        CommandElement boolEl = bool(untr("val"));
        assertEquals(true, parseForInput("true", boolEl).getOne("val").get());
        assertEquals(true, parseForInput("t", boolEl).getOne("val").get());
        assertEquals(false, parseForInput("f", boolEl).getOne("val").get());

        this.expected.expect(ArgumentParseException.class);
        parseForInput("notabool", boolEl);
    }

    private enum TestEnum {
        ONE, TWO, RED
    }

    @Test
    public void testEnumValue() throws ArgumentParseException {
        CommandElement enumEl = enumValue(untr("val"), TestEnum.class);
        assertEquals(TestEnum.ONE, parseForInput("one", enumEl).getOne("val").get());
        assertEquals(TestEnum.TWO, parseForInput("TwO", enumEl).getOne("val").get());
        assertEquals(TestEnum.RED, parseForInput("RED", enumEl).getOne("val").get());

        this.expected.expect(ArgumentParseException.class);
        parseForInput("notanel", enumEl);
    }

    @Test
    public void testRemainingJoinedStrings() throws ArgumentParseException {
        CommandElement remainingJoined = remainingJoinedStrings(untr("val"));
        assertEquals("one", parseForInput("one", remainingJoined).getOne("val").get());
        assertEquals("one big string", parseForInput("one big string", remainingJoined).getOne("val").get());
    }
}
