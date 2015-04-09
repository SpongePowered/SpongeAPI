/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.util.command.dispatcher;

import com.google.common.base.Optional;
import org.spongepowered.api.util.command.CommandMapping;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.CommandSpec;

import java.util.List;
import java.util.Set;

/**
 * Executes a command based on user input.
 */
public interface Dispatcher {

    /**
     * Get a list of commands. Each command, regardless of how many aliases
     * it may have, will only appear once in the returned set.
     *
     * <p>The returned collection cannot be modified.</p>
     *
     * @return A list of registrations
     */
    Set<? extends CommandMapping> getCommands();

    /**
     * Get a list of primary aliases.
     *
     * <p>The returned collection cannot be modified.</p>
     *
     * @return A list of aliases
     */
    Set<String> getPrimaryAliases();

    /**
     * Get a list of all the command aliases, which includes the primary alias.
     *
     * <p>A command may have more than one alias assigned to it. The returned
     * collection cannot be modified.</p>
     *
     * @return A list of aliases
     */
    Set<String> getAliases();

    /**
     * Get the {@link CommandSpec} associated with an alias. Returns
     * null if no command is named by the given alias.
     *
     * @param alias The alias
     * @return The command mapping, if available
     */
    Optional<? extends CommandMapping> get(String alias);

    /**
     * Returns whether the dispatcher contains a registered command for the
     * given alias.
     *
     * @param alias The alias
     * @return True if a registered command exists
     */
    boolean containsAlias(String alias);

    /**
     * Returns whether the dispatcher contains the given mapping.
     *
     * @param mapping The mapping
     * @return True if a mapping exists
     */
    boolean containsMapping(CommandMapping mapping);

    /**
     * Process a command input, containing a full command string attached to a source.
     *
     * @param source The source to process the command for
     * @param commandLine the command line, not including a preceding /
     * @return whether any command was found
     */
    Optional<CommandResult> process(CommandSource source, String commandLine);

    /**
     * Return the appropriate tab completions for this command, or an empty list if none are present.
     *
     * @param src The source executing this command
     * @param arguments The arguments currently input
     * @return possible completions for the entire last word
     */
    List<String> complete(CommandSource src, final String arguments);

}
