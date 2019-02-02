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
package org.spongepowered.api.command.manager;

import org.spongepowered.api.command.Command;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.exception.CommandException;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.text.channel.MessageReceiver;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Registers and dispatches commands
 */
public interface CommandManager {

    /**
     * Executes a command based on the provided arguments.
     *
     * @param arguments The arguments to parse and execute
     * @return The {@link CommandResult}
     * @throws CommandException if something goes wrong during parsing or
     *                          execution
     */
    CommandResult process(String arguments) throws CommandException;

    /**
     * Executes a command based on the provided arguments, with a provided
     * object that is both a {@link Subject} for permission checks and a
     * {@link MessageReceiver} to return command messages to.
     *
     * @param subjectReceiver The {@link Subject} & {@link MessageReceiver}
     * @param arguments The arguments to parse and execute
     * @return The {@link CommandResult}
     * @throws CommandException if something goes wrong during parsing or
     *                          execution
     */
    // TODO: If we keep CommandSource, this goes here.
    <T extends Subject & MessageReceiver> CommandResult process(T subjectReceiver, String arguments) throws CommandException;

    /**
     * Executes a command based on the provided arguments, with a provided
     * {@link Subject} for permission checks and a provided
     * {@link MessageChannel} to return command messages to.
     *
     * @param subject The {@link Subject} for permission checks
     * @param channel The {@link MessageChannel} to return messages to
     * @param arguments The arguments of the command
     * @return The {@link CommandResult}
     * @throws CommandException if something goes wrong during parsing or
     *                          execution
     */
    CommandResult process(Subject subject, MessageChannel channel, String arguments) throws CommandException;

    /**
     * Suggests possible completions based on the input argument string.
     *
     * @param arguments The arguments
     * @return The completions
     */
    List<String> suggest(String arguments);

    /**
     * Suggests possible completions based on the input argument string,
     *  with a provided object that is both a {@link Subject} for permission
     *  checks and a {@link MessageReceiver} to return command messages to.
     *
     * @param subjectReceiver The {@link Subject} & {@link MessageReceiver}
     * @param arguments The arguments
     * @return The completions
     */
    <T extends Subject & MessageReceiver> List<String> suggest(T subjectReceiver, String arguments);

    /**
     * Suggests possible completions based on the input argument string,
     *  with a provided a {@link Subject} for permission checks and a
     *  {@link MessageChannel} to return command messages to.
     *
     * @param subject The {@link Subject}
     * @param receiver The {@link MessageChannel}
     * @param arguments The arguments
     * @return The completions
     */
    List<String> suggest(Subject subject, MessageChannel receiver, String arguments);

    /**
     * Registers a {@link Command} with the {@link CommandManager}.
     *
     * @param container The {@link PluginContainer} to register the command for
     * @param command The {@link Command} to register
     * @param primaryAlias The first command alias to register
     * @param secondaryAliases Secondary aliases to register, if any
     * @return The {@link CommandMapping} if successful.
     */
    Optional<CommandMapping> register(PluginContainer container, Command command, String primaryAlias, String... secondaryAliases);

    /**
     * Unregisters a command based on the alias and provided
     * {@link PluginContainer}
     *
     * @param mapping The {@link CommandMapping} that represents the command to remove.
     * @return A {@link CommandMapping} representing what was unregistered, if anything.
     */
    Optional<CommandMapping> unregister(CommandMapping mapping);

    /**
     * Unregisters all commands associated with the provided
     * {@link PluginContainer}
     *
     * <p>Note that some system {@link PluginContainer}s may not allow for their
     * commands to be removed.</p>
     *
     * @param container The {@link PluginContainer} to remove commands from
     * @return A {@link Collection} of removed {@link CommandMapping}s
     */
    Collection<CommandMapping> unregisterAll(PluginContainer container);

    /**
     * Gets a {@link Collection} of {@link PluginContainer}s with commands
     * registered.
     *
     * @return A {@link Collection} of {@link PluginContainer}s.
     */
    Collection<PluginContainer> getPlugins();

}
