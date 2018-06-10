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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.spongepowered.api.Game;
import org.spongepowered.api.command.args.ArgumentParseException;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.dispatcher.SimpleDispatcher;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.CauseStackManager;
import org.spongepowered.api.text.TestPlainTextSerializer;
import org.spongepowered.api.text.Text;
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
    public void testEmptyChildrenWorks() throws CommandException {
        final AtomicBoolean parent = new AtomicBoolean();
        final CommandSpec spec = CommandSpec.builder()
                .children(ImmutableMap.<List<String>, CommandSpec>of())
                .executor((s, c) -> {
                    parent.set(true);
                    return CommandResult.success();
                })
                .build();
        final SimpleDispatcher execute = new SimpleDispatcher();
        execute.register(spec, "emptyparent");
        execute.process(mock(CommandSource.class), "emptyparent");

        assertTrue(parent.get());
    }

    @Test
    public void testEmptyChildrenWorksWithArgument() throws CommandException {
        final AtomicBoolean parent = new AtomicBoolean();
        final CommandSpec spec = CommandSpec.builder()
                .arguments(GenericArguments.optional(GenericArguments.string(Text.of("a"))))
                .children(ImmutableMap.<List<String>, CommandSpec>of())
                .executor((s, c) -> {
                    parent.set(true);
                    return CommandResult.success();
                })
                .build();
        final SimpleDispatcher execute = new SimpleDispatcher();
        execute.register(spec, "emptyparentwith");
        execute.process(mock(CommandSource.class), "emptyparentwith child");

        assertTrue(parent.get());
    }

    @Test
    public void testEmptyChildrenWorksWithOptionalArgument() throws CommandException {
        final AtomicBoolean parent = new AtomicBoolean();
        final CommandSpec spec = CommandSpec.builder()
                .arguments(GenericArguments.optional(GenericArguments.string(Text.of("b"))))
                .children(ImmutableMap.<List<String>, CommandSpec>builder()
                        .put(Lists.newArrayList("aaa"),
                                CommandSpec.builder().executor((s, c) -> CommandResult.empty()).build()).build())
                .executor((s, c) -> {
                    parent.set(true);
                    return CommandResult.success();
                })
                .build();
        final SimpleDispatcher execute = new SimpleDispatcher();
        execute.register(spec, "emptyparentwithopt");
        execute.process(mock(CommandSource.class), "emptyparentwithopt");

        assertTrue(parent.get());
    }

    @Test
    public void testSimpleChildCommand() throws CommandException {
        final AtomicBoolean childExecuted = new AtomicBoolean();
        final CommandSpec spec = CommandSpec.builder()
                .children(ImmutableMap.of(ImmutableList.of("child"), CommandSpec.builder()
                        .executor((src, args) -> {
                            childExecuted.set(true);
                            return CommandResult.builder().successCount(1).build();
                        })
                        .build()))
                        .build();
        final SimpleDispatcher execute = new SimpleDispatcher();
        execute.register(spec, "parent");
        execute.process(mock(CommandSource.class), "parent child");

        assertTrue(childExecuted.get());
    }

    @Test
    public void testSimpleChildCommandIsSuppressedOnError() throws CommandException {
        final AtomicBoolean parentExecuted = new AtomicBoolean();
        final AtomicBoolean childExecuted = new AtomicBoolean();
        final CommandSpec spec = CommandSpec.builder()
                .children(ImmutableMap.of(ImmutableList.of("child"), CommandSpec.builder()
                        .arguments(GenericArguments.literal(Text.of("test"), "test"))
                        .executor((src, args) -> {
                            childExecuted.set(true);
                            return CommandResult.builder().successCount(1).build();
                        })
                        .build()))
                .arguments(GenericArguments.literal(Text.of("t"), "child"))
                .executor((src, args) -> {
                    parentExecuted.set(true);
                    return CommandResult.success();
                })
                .build();
        final SimpleDispatcher execute = new SimpleDispatcher();
        execute.register(spec, "parent");
        execute.process(mock(CommandSource.class), "parent child");

        assertFalse(childExecuted.get());
        assertTrue(parentExecuted.get());
    }

    @Test
    public void testSimpleChildCommandIsThrownOnErrorWhenSelected() throws CommandException {
        final AtomicBoolean parentExecuted = new AtomicBoolean();
        final AtomicBoolean childExecuted = new AtomicBoolean();
        final CommandSpec spec = CommandSpec.builder()
                .children(ImmutableMap.of(ImmutableList.of("child"), CommandSpec.builder()
                        .arguments(GenericArguments.literal(Text.of("test"), "test"))
                        .executor((src, args) -> {
                            childExecuted.set(true);
                            return CommandResult.builder().successCount(1).build();
                        })
                        .build()))
                .arguments(GenericArguments.literal(Text.of("t"), "child"))
                .executor((src, args) -> {
                    parentExecuted.set(true);
                    return CommandResult.success();
                })
                .childArgumentParseExceptionFallback(false)
                .build();
        final SimpleDispatcher execute = new SimpleDispatcher();
        execute.register(spec, "parent");

        try {
            execute.process(mock(CommandSource.class), "parent child");
        } catch (ArgumentParseException ex) {
            // ignored - we check this with the booleans
        }

        assertFalse(childExecuted.get());
        assertFalse(parentExecuted.get());
    }

    @Test
    public void testErrorOnNonExistentChildWithNoExecutor() throws CommandException {
        final CommandSpec spec = CommandSpec.builder()
                .children(ImmutableMap.of(ImmutableList.of("child"), CommandSpec.builder()
                        .executor((src, args) -> CommandResult.builder().successCount(1).build())
                        .build()))
                .childArgumentParseExceptionFallback(false)
                .build();
        final SimpleDispatcher execute = new SimpleDispatcher();
        execute.register(spec, "parent");

        try {
            execute.process(mock(CommandSource.class), "parent wrong");
        } catch (ArgumentParseException ex) {
            assertEquals("Input command wrong was not a valid subcommand!\nwrong\n^", ex.getMessage());
        }
    }

    @Test
    public void testErrorOnNonExistentChildWithNoOtherParameters() throws CommandException {
        final CommandSpec spec = CommandSpec.builder()
                .children(ImmutableMap.of(ImmutableList.of("child"), CommandSpec.builder()
                        .executor((src, args) -> CommandResult.builder().successCount(1).build())
                        .build()))
                .childArgumentParseExceptionFallback(false)
                .executor((src, args) -> CommandResult.success())
                .build();
        final SimpleDispatcher execute = new SimpleDispatcher();
        execute.register(spec, "parent");

        try {
            execute.process(mock(CommandSource.class), "parent wrong");
        } catch (ArgumentParseException ex) {
            assertEquals("Input command wrong was not a valid subcommand!\nwrong\n^", ex.getMessage());
        }
    }

}
