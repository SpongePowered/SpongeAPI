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
package org.spongepowered.api.command;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;
import org.spongepowered.api.Game;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.dispatcher.SimpleDispatcher;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.CauseStackManager;
import org.spongepowered.api.text.TestPlainTextSerializer;
import org.spongepowered.api.util.test.TestHooks;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Tests for child commands.
 */
public class ChildCommandsTest {

    @Before
    public void initialize() throws Exception {
        TestPlainTextSerializer.inject();
        
        Game game = mock(Game.class);
        CauseStackManager csm = mock(CauseStackManager.class);
        when(game.getCauseStackManager()).thenReturn(csm);
        when(csm.pushCause(null)).thenReturn(csm);
        when(csm.popCause()).thenReturn(null);
        CommandManager cm = mock(CommandManager.class);
        when(game.getCommandManager()).thenReturn(cm);
        TestHooks.setGame(game);
        TestHooks.setInstance("commandManager", cm);
    }

    @Test
    public void testSimpleChildCommand() throws CommandException {
        final AtomicBoolean childExecuted = new AtomicBoolean();
        final CommandSpec spec = CommandSpec.builder()
                .children(ImmutableMap.<List<String>, CommandSpec>of(ImmutableList.of("child"), CommandSpec.builder()
                        .executor(new CommandExecutor() {
                            @Override
                            public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
                                childExecuted.set(true);
                                return CommandResult.builder().successCount(1).build();
                            }
                        })
                        .build()))
                        .build();
        final SimpleDispatcher execute = new SimpleDispatcher();
        execute.register(spec, "parent");
        execute.process(mock(CommandSource.class), "parent child");

        assertTrue(childExecuted.get());
    }
}
