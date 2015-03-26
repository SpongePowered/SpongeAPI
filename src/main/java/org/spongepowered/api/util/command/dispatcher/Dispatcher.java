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
import org.spongepowered.api.util.command.CommandCallable;
import org.spongepowered.api.util.command.CommandMapping;
import org.spongepowered.api.util.command.CommandSource;

import java.util.Map;
import java.util.Set;

/**
 * Executes a command based on user input.
 * 
 * @param <T> The return type of the commands this Dispatcher can dispatch
 */
public interface Dispatcher<T> extends CommandCallable<T> {

    /**
     * Get a list of commands. Each command, regardless of how many aliases it
     * may have, will only appear once in the returned set.
     *
     * <p>
     * The returned collection cannot be modified.
     * </p>
     *
     * @return A list of registrations
     */
    Set<? extends CommandMapping> getCommands();

    /**
     * Get a map of primary aliases.
     *
     * <p>
     * The returned collection cannot be modified. The string is the alias, and
     * the integer is how many times it's been registered.
     * </p>
     *
     * @return A list of aliases
     */
    Map<String, Integer> getPrimaryAliases();

    /**
     * Get a list of all the command aliases, which includes the primary alias.
     *
     * <p>
     * A command may have more than one alias assigned to it. The returned
     * collection cannot be modified.
     * </p>
     *
     * @return A list of aliases and how many times they've been registered.
     */
    Map<String, Integer> getAliases();

    /**
     * Get the {@link CommandMapping}(s) associated with an alias.
     * 
     * @param alias The alias
     * @return The command mappings
     */
    Set<CommandMapping> getAll(String alias);

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
     * Resolves the alias of a command to a {@link CommandMapping} with a
     * certain {@link CommandSource}.
     * 
     * @param alias The alias of the command.
     * @param source The CommandSource the command is being sent from.
     * @return A mapping for the command, if one was found. Otherwise,
     *         Optional.absent().
     */
    Optional<CommandMapping> resolveMapping(String alias, CommandSource source);

}
