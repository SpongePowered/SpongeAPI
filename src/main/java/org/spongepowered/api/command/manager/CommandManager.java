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

import io.leangen.geantyref.TypeToken;
import net.kyori.adventure.audience.Audience;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.exception.CommandException;
import org.spongepowered.api.command.registrar.CommandRegistrar;
import org.spongepowered.api.command.registrar.tree.CommandTreeNode;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.lifecycle.RegisterCommandEvent;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.util.annotation.DoNotStore;
import org.spongepowered.plugin.PluginContainer;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Registers and dispatches commands.
 *
 * <p>The command manager may be replaced at any point during the game lifecycle
 * when the client chooses to reload registries.</p>
 */
@DoNotStore
public interface CommandManager {

    /**
     * Get a registrar that will register commands of {@code type} to the active
     * command manager.
     *
     * <p>This allows for out-of-band command registrations between calls to
     * {@link RegisterCommandEvent}, though where possible that event should be
     * preferred.</p>
     *
     * <p>When commands are registered outside of events, changes will not be
     * automatically reflected in client command views. To update any applicable
     * clients, see {@link #updateCommandTreeForPlayer(ServerPlayer)}.</p>
     *
     * @param type the registrar type
     * @param <T> registrar type
     * @return a registrar, if any is known for {@code type}
     */
    <T> Optional<CommandRegistrar<T>> registrar(final Class<T> type);

    /**
     * Get a registrar that will register commands of {@code type} to the active
     * command manager.
     *
     * <p>This allows for out-of-band command registrations between calls to
     * {@link RegisterCommandEvent}, though where possible that event should be
     * preferred.</p>
     *
     * <p>When commands are registered outside of events, changes will not be
     * automatically reflected in client command views. To update any applicable
     * clients, see {@link #updateCommandTreeForPlayer(ServerPlayer)}.</p>
     *
     * @param type the registrar type
     * @param <T> registrar type
     * @return a registrar, if any is known for {@code type}
     */
    <T> Optional<CommandRegistrar<T>> registrar(final TypeToken<T> type);

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
     * {@link Audience} to return command messages to.
     *
     * @param subjectReceiver The {@link Subject} &amp; {@link Audience}
     * @param arguments The arguments to parse and execute
     * @param <T> The type of receiver
     * @return The {@link CommandResult}
     * @throws CommandException if something goes wrong during parsing or
     *                          execution
     */
    <T extends Subject & Audience> CommandResult process(T subjectReceiver, String arguments) throws CommandException;

    /**
     * Executes a command based on the provided arguments, with a provided
     * {@link Subject} for permission checks and a provided
     * {@link Audience} to return command messages to.
     *
     * @param subject The {@link Subject} for permission checks
     * @param channel The {@link Audience} to return messages to
     * @param arguments The arguments of the command
     * @return The {@link CommandResult}
     * @throws CommandException if something goes wrong during parsing or
     *                          execution
     */
    CommandResult process(Subject subject, Audience channel, String arguments) throws CommandException;

    /**
     * Suggests possible completions based on the input argument string.
     *
     * @param arguments The arguments
     * @return The completions
     */
    List<String> suggest(String arguments);

    /**
     * Suggests possible completions based on the input argument string,
     * with a provided object that is both a {@link Subject} for permission
     * checks and a {@link Audience} to return command messages to.
     *
     * @param subjectReceiver The {@link Subject} &amp; {@link Audience}
     * @param arguments The arguments
     * @param <T> The type of receiver
     * @return The completions
     */
    <T extends Subject & Audience> List<String> suggest(T subjectReceiver, String arguments);

    /**
     * Suggests possible completions based on the input argument string,
     * with a provided a {@link Subject} for permission checks and a
     * {@link Audience} to return command messages to.
     *
     * @param subject The {@link Subject}
     * @param receiver The {@link Audience}
     * @param arguments The arguments
     * @return The completions
     */
    List<String> suggest(Subject subject, Audience receiver, String arguments);

    /**
     * Gets all the command aliases known to this command manager.
     *
     * @return The known aliases
     */
    Set<String> knownAliases();

    /**
     * Gets a {@link Collection} of {@link PluginContainer}s with commands
     * registered.
     *
     * @return A {@link Collection} of {@link PluginContainer}s.
     */
    Collection<PluginContainer> plugins();

    /**
     * Gets the {@link CommandMapping} associated with the requested alias,
     * if any.
     *
     * @param alias The alias to get the mapping for
     * @return The {@link CommandMapping}, if any
     */
    Optional<CommandMapping> commandMapping(final String alias);

    /**
     * Asks the server to send an updated client completion command tree to
     * the specified {@link ServerPlayer}.
     *
     * <p>This should be used sparingly as repeated calls may cause performance
     * issues. Implementations may choose to ignore this call if it deems it
     * unnecessary to send an update.</p>
     *
     * <p>This method may return before the updates have been sent.</p>
     *
     * @param player The {@link ServerPlayer} to send the command tree to.
     */
    void updateCommandTreeForPlayer(final ServerPlayer player);

    /**
     * A mutable view of the command manager, allowing additional commands
     * to be registered.
     *
     * <p>This view exists for access through {@link CommandRegistrar}s. To
     * register commands, see the {@link RegisterCommandEvent}.</p>
     */
    interface Mutable extends CommandManager {

        /**
         * Registers a set of command aliases with this manager.
         * This method should only be used by plugins that implement their own
         * command framework, as described in the description of the
         * {@link CommandRegistrar} class.
         *
         * <p>When registering a command, any aliases provided are prefixed with
         * the plugin's ID, followed by a colon to provide command namespacing in
         * addition to the unnamespaced aliases. As an example, if a plugin with
         * ID {@code foo} tries to register the command {@code bar}, the command
         * manager will attempt to register the commands {@code /bar} and
         * {@code /foo:bar}.</p>
         *
         * <p>Command aliases may not contain whitespace.</p>
         *
         * <p>If you wish to inspect the aliases that were registered, you may
         * inspect the returned {@link CommandMapping} for the registered aliases.
         * </p>
         *
         * @param registrar The {@link CommandRegistrar} that is requesting the
         *                  aliases
         * @param container The {@link PluginContainer} to register the command for
         * @param commandTree The {@link CommandTreeNode} that represents this command
         *                    structure.
         * @param primaryAlias The first command alias to register
         * @param secondaryAliases Secondary aliases to register, if any
         * @return The {@link CommandMapping} containing the command mapping
         *         information.
         * @throws CommandFailedRegistrationException thrown if the command could not be
         *                                     registered.
         */
        CommandMapping registerAlias(
                CommandRegistrar<?> registrar,
                PluginContainer container,
                CommandTreeNode.Root commandTree,
                String primaryAlias,
                String... secondaryAliases)
                throws CommandFailedRegistrationException;

    }

}
