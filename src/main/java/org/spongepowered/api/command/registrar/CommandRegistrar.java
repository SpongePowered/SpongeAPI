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
package org.spongepowered.api.command.registrar;

import net.kyori.adventure.text.Component;
import org.spongepowered.api.command.CommandCause;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.exception.CommandException;
import org.spongepowered.api.command.manager.CommandFailedRegistrationException;
import org.spongepowered.api.command.manager.CommandManager;
import org.spongepowered.api.command.manager.CommandMapping;
import org.spongepowered.api.command.registrar.tree.CommandTreeNode;
import org.spongepowered.api.event.EventContextKeys;
import org.spongepowered.api.event.lifecycle.RegisterRegistryValueEvent;
import org.spongepowered.api.util.annotation.DoNotStore;
import org.spongepowered.plugin.PluginContainer;

import java.util.List;
import java.util.Optional;

/**
 * {@link CommandRegistrar}s are the entry point for plugins wishing to provide
 * their own command framework. The {@link CommandManager} will proxy calls to
 * the correct registrar amd will handle the final {@link CommandResult}.
 *
 * <p>This interface defines a way to register commands. This registration
 * method <strong>must</strong> call
 * {@link CommandManager.Mutable#registerAlias(CommandRegistrar, PluginContainer,
 * CommandTreeNode.Root, String, String...)} to indicate that they wish to take
 * control of certain aliases. Beyond this call, the {@link CommandRegistrar}
 * will only need to retain the link between the {@link CommandMapping} and its
 * command (of type) {@code T} to execute, as the {@link CommandManager} will
 * always supply the mapping of the command being invoked at runtime. The alias
 * that was matched will also be supplied.</p>
 *
 * <p>For command that wishes to investigate the command string that was
 * executed, they may investigate the context in
 * {@link CommandCause#cause()}, looking for the
 * {@link EventContextKeys#COMMAND} context key.</p>
 *
 * <p>Command frameworks are free to choose how they parse commands. However,
 * a framework's {@link CommandRegistrar} <strong>must</strong> do the following
 * in order to be successfully registered and receive their commands:</p>
 *
 * <ul>
 *     <li>The registrar <strong>must</strong> have its type registered during the
 *     {@link RegisterRegistryValueEvent} for {@link CommandRegistrarType}s; and</li>
 *     <li>Commands registered through the registrar must be synced back
 *     to the {@link CommandManager}, otherwise such commands will not
 *     be passed back to this registrar.</li>
 * </ul>
 *
 * @param <T> The type of command interface this handles.
 */
@DoNotStore
public interface CommandRegistrar<T> {

    /**
     * Get the type defining this command registrar.
     *
     * @return the type
     */
    CommandRegistrarType<T> type();

    /**
     * Registers a command.
     *
     * @param container The {@link PluginContainer} performing the registration
     * @param command The command to register
     * @param primaryAlias The primary alias
     * @param secondaryAliases Any secondary aliases. May be empty.
     * @return The {@link CommandMapping}
     * @throws CommandFailedRegistrationException if the registration failed
     */
    CommandMapping register(
            PluginContainer container,
            T command,
            String primaryAlias,
            String... secondaryAliases) throws CommandFailedRegistrationException;

    /**
     * Process the provided command.
     *
     * <p>Note for implementors: the provided {@code command} will be the one
     * registered as the primary alias when registering with the
     * {@link CommandManager}.</p>
     *
     * @param cause The {@link CommandCause} that caused the command to be
     *              executed
     * @param mapping The {@link CommandMapping} for the command being invoked
     * @param command The alias that was used to invoke the command
     * @param arguments The arguments of the command (that is, the raw string
     *                  with the command alias removed, so if
     *                  {@code /sponge test test2} is invoked, arguments will
     *                  contain {@code test test2}.)
     * @return The {@link CommandResult}
     * @throws CommandException if there is an error executing the command
     */
    CommandResult process(CommandCause cause, CommandMapping mapping, String command, String arguments) throws CommandException;

    /**
     * Provides a list of suggestions associated with the provided argument
     * string.
     *
     * <p>See {@link #process(CommandCause, CommandMapping, String, String)} for any
     * implementation notes.</p>
     *
     * @param cause The {@link CommandCause} that caused the command to be
     *              executed
     * @param mapping The {@link CommandMapping} for the command being invoked
     * @param command The alias that was used to invoke the command
     * @param arguments The arguments of the command (that is, the raw string
     *                  with the command alias removed, so if
     *                  {@code /sponge test test2} is invoked, arguments will
     *                  contain {@code test test2}.)
     * @return The suggestions
     */
    List<String> suggestions(CommandCause cause, CommandMapping mapping, String command, String arguments) throws CommandException;

    /**
     * Returns help text for the invoked command.
     *
     * @param cause The {@link CommandCause} that caused the command to be
     *              executed
     * @param mapping The {@link CommandMapping} that is associated with the
     *                command
     * @return The help, if any
     */
    Optional<Component> help(CommandCause cause, CommandMapping mapping);

    /**
     * Gets whether the given {@link CommandCause} can execute the command
     * associated with the given {@link CommandMapping}.
     *
     * @param cause The {@link CommandCause}
     * @param mapping The {@link CommandMapping}
     * @return true of the command can execute the command
     */
    boolean canExecute(CommandCause cause, CommandMapping mapping);

}
