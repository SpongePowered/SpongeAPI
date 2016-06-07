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

import com.google.common.collect.Multimap;
import org.spongepowered.api.command.CommandCallable;
import org.spongepowered.api.command.CommandMapping;
import org.spongepowered.api.command.CommandSource;

import java.util.Optional;
import java.util.Set;

import javax.annotation.Nullable;

/**
 * Executes a command based on user input.
 */
public interface Dispatcher extends CommandCallable {

    /**
     * Gets a list of commands. Each command, regardless of how many aliases it
     * may have, will only appear once in the returned set.
     *
     * <p>The returned collection cannot be modified.</p>
     *
     * @return A list of registrations
     */
    Set<? extends CommandMapping> getCommands();

    /**
     * Gets a list of primary aliases.
     *
     * <p>The returned collection cannot be modified.</p>
     *
     * @return A list of aliases
     */
    Set<String> getPrimaryAliases();

    /**
     * Gets a list of all the command aliases, which includes the primary alias.
     *
     * <p>A command may have more than one alias assigned to it. The returned
     * collection cannot be modified.</p>
     *
     * @return A list of aliases
     */
    Set<String> getAliases();

    /**
     * Gets the {@link CommandMapping} associated with an alias. Returns null if
     * no command is named by the given alias.
     *
     * @param alias The alias
     * @return The command mapping, if available
     */
    Optional<? extends CommandMapping> get(String alias);

    /**
     * Gets the {@link CommandMapping} associated with an alias in the context
     * of a given {@link CommandSource}. Returns null if no command is named by
     * the given alias.
     *
     * @param alias The alias to look up
     * @param source The source this alias is being looked up for
     * @return The command mapping, if available
     */
    Optional<? extends CommandMapping> get(String alias, @Nullable CommandSource source);

    /**
     * Gets all the {@link CommandMapping}s associated with an alias.
     *
     * @param alias The alias
     * @return The command mappings associated with the alias
     */
    Set<? extends CommandMapping> getAll(String alias);

    /**
     * Gets all commands currently registered with this dispatcher. The returned
     * value is immutable.
     *
     * @return a multimap from alias to mapping of every registered command
     */
    Multimap<String, CommandMapping> getAll();

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
}
