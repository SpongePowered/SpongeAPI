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
package org.spongepowered.api.util.command;

import static org.junit.Assert.assertEquals;
import static org.spongepowered.api.util.command.TranslationPlaceholder.t;
import static org.spongepowered.api.util.command.args.GenericArguments.*;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import org.spongepowered.api.util.command.args.CommandArgs;


/**
 * Test for command flags.
 */
@Ignore("Cannot run these tests unless Text factories are available in testing")
public class CommandFlagsTest {
    private static final CommandSource TEST_SOURCE = Mockito.mock(CommandSource.class);

    @Test
    public void testFlaggedCommand() throws CommandException {
        CommandSpec command = CommandSpec.builder()
                .setArguments(flags()
                        .flag("a").valueFlag(integer(t("quot")), "q").buildWith(string(t("key"))))
                .setExecutor(new CommandExecutor() {
                    @Override
                    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
                        assertEquals(true, args.getOne("a").get());
                        assertEquals(42, args.getOne("quot").get());
                        assertEquals("something", args.getOne("key").get());
                        return CommandResult.builder().successCount(3).build();
                    }
                })
                .build();
        process(command, "-a -q 42 something");
        process(command, "-aq 42 something");
        process(command, "-a something -q 42");
    }

    private static void process(CommandSpec spec, String arguments) throws CommandException {
        final CommandArgs args = new CommandArgs(arguments, spec.getInputTokenizer().tokenize(arguments, false));
        final CommandContext context = new CommandContext();
        spec.populateContext(args, context);
        spec.getExecutor().execute(TEST_SOURCE, context);
    }
}
