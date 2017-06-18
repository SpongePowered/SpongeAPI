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
package org.spongepowered.api.command.dispatcher;

import org.spongepowered.api.command.Command;
import org.spongepowered.api.command.CommandMapping;

import java.util.Collection;
import java.util.Map;

/**
 * A CommandNode is a structure that allows consumers to walk down a command
 * tree and find a specific subcommand.
 *
 * <p>As an example, imagine that the command {@code /foo} has been registered
 * using the {@link Command#builder()}, and that a child was registered on
 * {@code foo} using {@link Command.Builder#child(Command, String...)} with the
 * name {@code bar}. If this node represents {@code foo}, then calling
 * {@link #getSubcommands()} will contain one entry - {@code bar} along with its
 * own node. {@code bar}s node will return an empty map on
 * {@link #getSubcommands()}</p>
 *
 * <p>The only subcommands that are guaranteed to appear in this node are those
 * registered through Sponge's high level command API - that is using
 * {@link Command.Builder#child(Command, String...)}.</p>
 *
 * <p>Any information provided here is immutable. It would be of most use to
 * informational systems, such as those wishing to build up a command tree
 * visually, or a help system that can take advantage of subcommands.</p>
 */
public interface CommandNode {

    /**
     * Get the {@link CommandMapping} that this node represents.
     *
     * @return The {@link CommandMapping}
     */
    CommandMapping getCommandMapping();

    /**
     * Gets the subcommands to this command as {@link CommandNode}s.
     *
     * <p>This may be lazy loaded.</p>
     *
     * @return A {@link Collection} of {@link CommandNode}s. May be empty.
     */
    Map<String, ? extends CommandNode> getSubcommands();

}
