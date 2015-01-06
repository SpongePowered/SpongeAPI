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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import org.spongepowered.api.util.command.CommandCallable;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandMapping;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.ImmutableCommandMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A simple implementation of a {@link Dispatcher}.
 */
public class SimpleDispatcher implements Dispatcher {

    private final Map<String, CommandMapping> commands = Maps.newHashMap();

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
     * @param callable The command
     * @param alias An array of aliases
     * @return The registered command mapping, unless no aliases could be registered
     */
    public Optional<CommandMapping> register(CommandCallable callable, String... alias) {
        checkNotNull(alias);
        return register(callable, Arrays.asList(alias));
    }

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
     * @param callable The command
     * @param aliases A list of aliases
     * @return The registered command mapping, unless no aliases could be registered
     */
    public Optional<CommandMapping> register(CommandCallable callable, List<String> aliases) {
        return register(callable, aliases, Functions.<List<String>>identity());
    }

    /**
     * Register a given command using a given list of aliases.
     *
     * <p>The provided callback function will be called with a list of aliases
     * that are not taken (from the list of aliases that were requested) and
     * it should return a list of aliases to actually register. Aliases may be
     * removed, and if no aliases remain, then the command will not be
     * registered. It may be possible that no aliases are available, and thus
     * the callback would receive an empty list. New aliases should not be added
     * to the list in the callback as this may cause
     * {@link IllegalArgumentException} to be thrown.</p>
     *
     * <p>The first non-conflicted alias becomes the "primary alias."</p>
     *
     * @param callable The command
     * @param aliases A list of aliases
     * @param callback The callback
     * @return The registered command mapping, unless no aliases could be registered
     * @throws IllegalArgumentException Thrown if new conflicting aliases are added in the callback
     */
    public synchronized Optional<CommandMapping> register(CommandCallable callable, List<String> aliases,
                                                          Function<List<String>, List<String>> callback) {
        checkNotNull(aliases);
        checkNotNull(callable);
        checkNotNull(callback);

        List<String> free = new ArrayList<String>();

        // Filter out commands that are already registered
        for (String alias : aliases) {
            if (!commands.containsKey(alias.toLowerCase())) {
                free.add(alias);
            }
        }

        // Invoke the callback with the commands that /can/ be registered
        //noinspection ConstantConditions
        free = new ArrayList<String>(callback.apply(free));

        if (!free.isEmpty()) {
            // The callback should /not/ have added any new commands
            for (String alias : free) {
                if (commands.containsKey(alias.toLowerCase())) {
                    throw new IllegalArgumentException("A command by the name of '" + alias + "' already exists");
                }
            }

            String primary = free.get(0);
            List<String> secondary = free.subList(1, free.size());
            CommandMapping mapping = new ImmutableCommandMapping(callable, primary, secondary);

            for (String alias : free) {
                commands.put(alias.toLowerCase(), mapping);
            }

            return Optional.of(mapping);
        } else {
            return Optional.absent();
        }
    }

    /**
     * Remove a mapping identified by the given alias.
     *
     * @param alias The alias
     * @return The previous mapping associated with the alias, if one was found
     */
    public synchronized Optional<CommandMapping> remove(String alias) {
        return Optional.of(commands.remove(alias.toLowerCase()));
    }

    /**
     * Remove all mappings identified by the given aliases.
     *
     * @param c A collection of aliases
     * @return Whether any were found
     */
    public synchronized boolean removeAll(Collection<?> c) {
        checkNotNull(c);

        boolean found = false;

        for (Object alias : c) {
            commands.remove(alias.toString().toLowerCase());
            found = true;
        }

        return found;
    }

    /**
     * Remove a command identified by the given mapping.
     *
     * @param mapping The mapping
     * @return The previous mapping associated with the alias, if one was found
     */
    public synchronized Optional<CommandMapping> removeMapping(CommandMapping mapping) {
        checkNotNull(mapping);

        CommandMapping found = null;

        Iterator<CommandMapping> it = commands.values().iterator();
        while (it.hasNext()) {
            CommandMapping current = it.next();
            if (current.equals(mapping)) {
                it.remove();
                found = current;
            }
        }

        return Optional.fromNullable(found);
    }

    /**
     * Remove all mappings contained with the given collection.
     *
     * @param c The collection
     * @return Whether the at least one command was removed
     */
    public synchronized boolean removeMappings(Collection<?> c) {
        checkNotNull(c);

        boolean found = false;

        Iterator<CommandMapping> it = commands.values().iterator();
        while (it.hasNext()) {
            if (c.contains(it.next())) {
                it.remove();
                found = true;
            }
        }

        return found;
    }

    @Override
    public synchronized Set<CommandMapping> getCommands() {
        return ImmutableSet.copyOf(commands.values());
    }

    @Override
    public synchronized Set<String> getPrimaryAliases() {
        Set<String> aliases = new HashSet<String>();

        for (CommandMapping mapping : commands.values()) {
            aliases.add(mapping.getPrimaryAlias());
        }

        return Collections.unmodifiableSet(aliases);
    }

    @Override
    public synchronized Set<String> getAliases() {
        Set<String> aliases = new HashSet<String>();

        for (CommandMapping mapping : commands.values()) {
            aliases.addAll(mapping.getAllAliases());
        }

        return Collections.unmodifiableSet(aliases);
    }

    @Override
    public synchronized Optional<CommandMapping> get(String alias) {
        return Optional.fromNullable(commands.get(alias.toLowerCase()));
    }

    @Override
    public synchronized boolean containsAlias(String alias) {
        return commands.containsKey(alias.toLowerCase());
    }

    @Override
    public boolean containsMapping(CommandMapping mapping) {
        checkNotNull(mapping);

        for (CommandMapping test : commands.values()) {
            if (mapping.equals(test)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Get the number of registered aliases.
     *
     * @return The number of aliases
     */
    public synchronized int size() {
        return commands.size();
    }

    @Override
    public boolean call(CommandSource source, String arguments, List<String> parents) throws CommandException {
        String[] parts = arguments.split(" +", 2);
        Optional<CommandMapping> mapping = get(parts[0]);

        if (mapping.isPresent()) {
            List<String> passedParents = new ArrayList<String>(parents.size() + 1);
            passedParents.addAll(parents);
            passedParents.add(parts[0]);

            mapping.get().getCallable().call(source, parts.length > 1 ? parts[1] : "", Collections.unmodifiableList(passedParents));

            return true;
        } else {
            return false;
        }
    }

    @Override
    public synchronized boolean testPermission(CommandSource source) {
        for (CommandMapping mapping : commands.values()) {
            if (!mapping.getCallable().testPermission(source)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public List<String> getSuggestions(CommandSource source, String arguments) throws CommandException {
        String[] parts = arguments.split(" +", 2);
        List<String> suggestions = new ArrayList<String>();

        if (parts.length == 1) { // Auto completing commands
            String incompleteCommand = parts[0].toLowerCase();

            synchronized (this) {
                for (CommandMapping mapping : commands.values()) {
                    for (String alias : mapping.getAllAliases()) {
                        if (alias.toLowerCase().startsWith(incompleteCommand)) {
                            suggestions.add(alias);
                        }
                    }
                }
            }
        } else { // Complete using subcommand
            Optional<CommandMapping> mapping = get(parts[0]);

            if (mapping.isPresent()) {
                mapping.get().getCallable().getSuggestions(source, parts.length > 1 ? parts[1] : "");
            }
        }

        return Collections.unmodifiableList(suggestions);
    }

    @Override
    public Optional<String> getShortDescription() {
        return Optional.absent();
    }

    @Override
    public Optional<String> getHelp() {
        return Optional.absent();
    }

    @Override
    public String getUsage() {
        return "<sub-command>"; // @TODO: Translate
    }

}
