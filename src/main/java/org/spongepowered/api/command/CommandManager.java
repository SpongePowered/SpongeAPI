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

import org.spongepowered.api.command.dispatcher.Dispatcher;
import org.spongepowered.api.event.CauseStackManager;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.EventContextKey;
import org.spongepowered.api.event.cause.EventContextKeys;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import javax.annotation.Nullable;

/**
 * A command dispatcher watches for commands (such as those said in chat)
 * and dispatches them to the correct command handler.
 */
public interface CommandManager extends Dispatcher {

    /**
     * Register a given command using the given list of aliases.
     *
     * <p>If there is a conflict with one of the aliases (i.e. that alias
     * is already assigned to another command), then the alias will be skipped.
     * It is possible for there to be no alias to be available out of
     * the provided list of aliases, which would mean that the command would not
     * be assigned to any aliases.</p>
     *
     * <p>The first non-conflicted alias becomes the "primary alias."</p>
     *
     * @param plugin A plugin instance
     * @param command The command
     * @param alias An array of aliases
     * @return The registered command mapping, unless no aliases could be
     *     registered
     * @throws IllegalArgumentException Thrown if {@code plugin} is not a
     *     plugin instance
     */
    Optional<CommandMapping> register(Object plugin, Command command, String... alias);

    /**
     * Register a given command using the given list of aliases.
     *
     * <p>If there is a conflict with one of the aliases (i.e. that alias
     * is already assigned to another command), then the alias will be skipped.
     * It is possible for there to be no alias to be available out of
     * the provided list of aliases, which would mean that the command would
     * not be assigned to any aliases.</p>
     *
     * <p>The first non-conflicted alias becomes the "primary alias."</p>
     *
     * @param plugin A plugin instance
     * @param command The command
     * @param aliases A list of aliases
     * @return The registered command mapping, unless no aliases could be
     *     registered
     * @throws IllegalArgumentException Thrown if {@code plugin} is not a
     *     plugin instance
     */
    Optional<CommandMapping> register(Object plugin, Command command, List<String> aliases);

    /**
     * Register a given command using the given list of aliases.
     *
     * <p>If there is a conflict with one of the aliases (i.e. that alias
     * is already assigned to another command), then the alias will be skipped.
     * It is possible for there to be no alias to be available out of
     * the provided list of aliases, which would mean that the command would not
     * be assigned to any aliases.</p>
     *
     * <p>The first non-conflicted alias becomes the "primary alias."</p>
     *
     * @param pluginContainer A {@link PluginContainer}
     * @param command The command
     * @param alias An array of aliases
     * @return The registered command mapping, unless no aliases could be
     *     registered
     * @throws IllegalArgumentException Thrown if {@code plugin} is not a
     *     plugin instance
     */
    Optional<CommandMapping> register(PluginContainer pluginContainer, Command command, String... alias);

    /**
     * Register a given command using the given list of aliases.
     *
     * <p>If there is a conflict with one of the aliases (i.e. that alias
     * is already assigned to another command), then the alias will be skipped.
     * It is possible for there to be no alias to be available out of
     * the provided list of aliases, which would mean that the command would
     * not be assigned to any aliases.</p>
     *
     * <p>The first non-conflicted alias becomes the "primary alias."</p>
     *
     * @param pluginContainer A {@link PluginContainer}
     * @param command The command
     * @param aliases A list of aliases
     * @return The registered command mapping, unless no aliases could be
     *     registered
     * @throws IllegalArgumentException Thrown if the {@link PluginContainer}
     *     is not valid.
     */
    Optional<CommandMapping> register(PluginContainer pluginContainer, Command command, List<String> aliases);

    /**
     * Remove a command identified by the given mapping.
     *
     * @param mapping The mapping
     * @return The previous mapping associated with the alias, if one was found
     */
    Optional<CommandMapping> removeMapping(CommandMapping mapping);

    /**
     * Gets a set of plugin containers that have commands registered.
     *
     * @return A set of plugin containers
     */
    Set<PluginContainer> getPluginContainers();

    /**
     * Gets a set of commands owned by the given plugin instance.
     *
     * @param instance The plugin instance
     * @return A set of mappings
     */
    Set<CommandMapping> getOwnedBy(Object instance);

    /**
     * Gets the owner of a CommandMapping, if any is present.
     *
     * @param mapping The mapping to get an owner for
     * @return The owner, if present.
     */
    Optional<PluginContainer> getOwner(CommandMapping mapping);

    /**
     * Gets the number of registered aliases.
     *
     * @return The number of aliases
     */
    int size();

    /**
     * Execute the command based on input arguments. The {@link Cause} of the
     * invocation will be taken from the {@link CauseStackManager} at the time
     * this method is invoked.
     *
     * <p>The implementing class must perform the necessary permission
     * checks.</p>
     *
     * <p>Note that the {@link CommandManager} is <strong>not</strong> permitted
     * to throw a {@link CommandException} if the selected command fails, it
     * must handle the error gracefully and return an appropriate
     * {@link CommandResult}</p>
     *
     * @param arguments The raw arguments for this command
     * @return The result of a command being processed
     */
    CommandResult process(String arguments);

    /**
     * Execute the command based on input arguments. The {@link Cause} of the
     * invocation will be taken from the {@link CauseStackManager} at the time
     * this method is invoked, with the {@link EventContextKeys#COMMAND_SOURCE}
     * {@link EventContextKeys#COMMAND_PERMISSION_SUBJECT} set to the specified
     * {@link CommandSource}.
     *
     * <p>The implementing class must perform the necessary permission
     * checks.</p>
     *
     * <p>Note that the {@link CommandManager} is <strong>not</strong> permitted
     * to throw a {@link CommandException} if the selected command fails, it
     * must handle the error gracefully and return an appropriate
     * {@link CommandResult}</p>
     *
     * @param arguments The raw arguments for this command
     * @return The result of a command being processed
     */
    CommandResult process(CommandSource commandSource, String arguments);

    /**
     * Execute the command based on input arguments.
     *
     * <p>The implementing class must perform the necessary permission
     * checks.</p>
     *
     * <p>Note that the {@link CommandManager} is <strong>not</strong> permitted
     * to throw a {@link CommandException} if the selected command fails, it
     * must handle the error gracefully and return an appropriate
     * {@link CommandResult}</p>
     *
     * @param cause The {@link Cause} of the command
     * @param arguments The raw arguments for this command
     * @return The result of a command being processed
     */
    CommandResult process(Cause cause, String arguments);

    /**
     * Gets a list of suggestions based on input. The {@link Cause} of the
     * invocation will be taken from the {@link CauseStackManager} at the time
     * this method is invoked.
     *
     * <p>If a suggestion is chosen by the user, it will replace the last
     * word.</p>
     *
     * <p>Note that the {@link CommandManager} is <strong>not</strong> permitted
     * to throw a {@link CommandException} if the selected command fails, it
     * must handle the error gracefully and return a list of suggestions
     * (which may be empty)</p>
     *
     * @param arguments The arguments entered up to this point
     * @param targetPosition The position the source is looking at when
     *     performing tab completion
     * @return A list of suggestions
     */
    List<String> getSuggestions(String arguments, @Nullable Location<World> targetPosition);

    /**
     * Gets a list of suggestions based on input. The {@link Cause} of the
     * invocation will be taken from the {@link CauseStackManager} at the time
     * this method is invoked, with the {@link EventContextKeys#COMMAND_SOURCE}
     * and {@link EventContextKeys#COMMAND_PERMISSION_SUBJECT} set to the
     * specified {@link CommandSource}.
     *
     * <p>If a suggestion is chosen by the user, it will replace the last
     * word.</p>
     *
     * <p>Note that the {@link CommandManager} is <strong>not</strong> permitted
     * to throw a {@link CommandException} if the selected command fails, it
     * must handle the error gracefully and return a list of suggestions
     * (which may be empty)</p>
     *
     * @param arguments The arguments entered up to this point
     * @param targetPosition The position the source is looking at when
     *     performing tab completion
     * @return A list of suggestions
     */
    List<String> getSuggestions(CommandSource commandSource, String arguments, @Nullable Location<World> targetPosition);

    /**
     * Gets a list of suggestions based on input.
     *
     * <p>If a suggestion is chosen by the user, it will replace the last
     * word.</p>
     *
     * <p>Note that the {@link CommandManager} is <strong>not</strong> permitted
     * to throw a {@link CommandException} if the selected command fails, it
     * must handle the error gracefully and return a list of suggestions
     * (which may be empty)</p>
     *
     * @param cause The {@link Cause}
     * @param arguments The arguments entered up to this point
     * @param targetPosition The position the source is looking at when
     *     performing tab completion
     * @return A list of suggestions
     */
    List<String> getSuggestions(Cause cause, String arguments, @Nullable Location<World> targetPosition);

    /**
     * Gets the primary alias for the supplied {@link Command}, if it
     * has been registered.
     *
     * @param command The {@link Command}
     * @return The primary alias, if it exists.
     */
    Optional<String> getPrimaryAlias(Command command);

}
