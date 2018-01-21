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
import static org.junit.Assert.assertTrue;
import static org.spongepowered.api.command.args.GenericArguments.flags;
import static org.spongepowered.api.command.args.GenericArguments.integer;
import static org.spongepowered.api.command.args.GenericArguments.none;
import static org.spongepowered.api.command.args.GenericArguments.string;
import static org.spongepowered.api.util.SpongeApiTranslationHelper.t;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.parsing.InputTokenizer;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.TestPlainTextSerializer;


/**
 * Test for command flags.
 */
public class CommandFlagsTest {
    @Rule
    public final ExpectedException expected = ExpectedException.none();
    private static final CommandSource TEST_SOURCE = Mockito.mock(CommandSource.class);

    @Before
    public void initialize() throws Exception {
        TestPlainTextSerializer.inject();
    }

    @Test
    public void testFlaggedCommand() throws CommandException {
        CommandSpec command = CommandSpec.builder()
                .arguments(flags()
                        .flag("a").valueFlag(integer(t("quot")), "q").buildWith(string(t("key"))))
                .executor((src, args) -> {
                    assertEquals(true, args.getOne("a").get());
                    assertEquals(42, args.getOne("quot").get());
                    assertEquals("something", args.getOne("key").get());
                    return CommandResult.builder().successCount(3).build();
                })
                .build();
        process(command, "-a -q 42 something");
        process(command, "-aq 42 something");
        process(command, "-a something -q 42");
    }

    private static void process(CommandSpec spec, String arguments) throws CommandException {
        final CommandArgs args = new CommandArgs(arguments, spec.getInputTokenizer().tokenize(arguments, false));
        final CommandContext context = new CommandContext();
        spec.populateContext(TEST_SOURCE, args, context);
        spec.getExecutor().execute(TEST_SOURCE, context);
    }

    private CommandContext parseWithInput(CommandElement element, String input) throws ArgumentParseException {
        CommandContext context = new CommandContext();
        element.parse(TEST_SOURCE, new CommandArgs(input, InputTokenizer.quotedStrings(false).tokenize(input, false)), context);
        return context;
    }

    @Test
    public void testUnknownFlagBehaviorError() throws ArgumentParseException {
        CommandElement flags = flags()
                .setUnknownLongFlagBehavior(CommandFlags.UnknownFlagBehavior.ERROR)
                .setUnknownShortFlagBehavior(CommandFlags.UnknownFlagBehavior.ERROR)
                .flag("h", "-help")
                .buildWith(none());
        CommandContext context = parseWithInput(flags, "-h");
        assertTrue(context.hasAny("h"));

        this.expected.expect(ArgumentParseException.class);
        parseWithInput(flags, "--another");
    }

    @Test
    public void testUnknownFlagBehaviorIgnore() throws ArgumentParseException {
        CommandElement flags = flags()
                .setUnknownLongFlagBehavior(CommandFlags.UnknownFlagBehavior.IGNORE)
                .setUnknownShortFlagBehavior(CommandFlags.UnknownFlagBehavior.IGNORE)
                .flag("h", "-help")
                .buildWith(none());

        CommandContext context = parseWithInput(flags, "-h --other -q");
        assertTrue(context.hasAny("h"));
        assertFalse(context.hasAny("other"));
        assertFalse(context.hasAny("q"));
    }

    @Test
    public void testUnknownFlagBehaviorAcceptNonValue() throws ArgumentParseException {
        CommandElement flags = flags()
                .setUnknownLongFlagBehavior(CommandFlags.UnknownFlagBehavior.ACCEPT_NONVALUE)
                .setUnknownShortFlagBehavior(CommandFlags.UnknownFlagBehavior.ACCEPT_NONVALUE)
                .flag("h", "-help")
                .buildWith(none());

        CommandContext context = parseWithInput(flags, "-h --other something -q else --forceargs=always");
        assertTrue(context.hasAny("h"));
        assertEquals(true, context.getOne("other").get());
        assertEquals(true, context.getOne("q").get());
        assertEquals("always", context.getOne("forceargs").get());
    }

    @Test
    public void testUnknownFlagBehaviorAcceptValue() throws ArgumentParseException {
        CommandElement flags = flags()
                .setUnknownLongFlagBehavior(CommandFlags.UnknownFlagBehavior.ACCEPT_VALUE)
                .setUnknownShortFlagBehavior(CommandFlags.UnknownFlagBehavior.ACCEPT_VALUE)
                .flag("h", "-help")
                .buildWith(none());

        CommandContext context = parseWithInput(flags, "-h --other something -q else --forceargs=always");
        assertTrue(context.hasAny("h"));
        assertEquals("something", context.getOne("other").get());
        assertEquals("else", context.getOne("q").get());
        assertEquals("always", context.getOne("forceargs").get());
    }
}
