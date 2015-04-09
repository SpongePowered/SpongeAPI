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

import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import org.spongepowered.api.util.command.dispatcher.SimpleDispatcher;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Tests for child commands.
 */
public class ChildCommandsTest {
    @Test
    @Ignore("Cannot run these tests unless Text factories are available in testing")
    public void testSimpleChildCommand() throws CommandException {
        final AtomicBoolean childExecuted = new AtomicBoolean();
        final CommandSpec spec = CommandSpec.builder()
                .setChildren(ImmutableMap.<List<String>, CommandSpec>of(ImmutableList.of("child"), CommandSpec.builder()
                        .setExecutor(new CommandExecutor() {
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
        execute.process(Mockito.mock(CommandSource.class), "parent child");

        assertTrue(childExecuted.get());
    }
}
