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
import static org.spongepowered.api.util.command.dispatcher.CommandMessageFormatting.debug;
import static org.spongepowered.api.util.command.dispatcher.CommandMessageFormatting.error;
import static org.spongepowered.api.util.command.dispatcher.TranslationPlaceholder._;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextBuilder;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.StartsWithPredicate;
import org.spongepowered.api.util.command.CommandContext;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandExecutor;
import org.spongepowered.api.util.command.CommandMapping;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.CommandSpec;
import org.spongepowered.api.util.command.ImmutableCommandMapping;
import org.spongepowered.api.util.command.args.ArgumentParseException;
import org.spongepowered.api.util.command.args.CommandArgs;
import org.spongepowered.api.util.command.args.CommandElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nullable;

/**
 * A simple implementation of a {@link Dispatcher}.
 */
public final class SimpleDispatcher extends CommandElement implements Dispatcher, CommandExecutor {
    private static final AtomicInteger COUNTER = new AtomicInteger();

    @Nullable
    private final CommandExecutor fallbackExecutor;
    private final Map<String, CommandMapping> commands = Maps.newHashMap();

    /**
     * Creates a basic new dispatcher.
     */
    public SimpleDispatcher() {
        this(null);
    }

    /**
     * Creates a new dispatcher with a fallback executor.
     *
     * @param fallbackExecutor Executor to use when this dispatcher is being used for subcommands
     */
    public SimpleDispatcher(@Nullable CommandExecutor fallbackExecutor) {
        super(Texts.of("child" + COUNTER.getAndIncrement()));
        this.fallbackExecutor = fallbackExecutor;
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
     * @param alias An array of aliases
     * @return The registered command mapping, unless no aliases could be registered
     */
    public Optional<CommandMapping> register(CommandSpec callable, String... alias) {
        checkNotNull(alias, "alias");
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
    public Optional<CommandMapping> register(CommandSpec callable, List<String> aliases) {
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
    public synchronized Optional<CommandMapping> register(CommandSpec callable, List<String> aliases,
            Function<List<String>, List<String>> callback) {
        checkNotNull(aliases, "aliases");
        checkNotNull(callable, "aliases");
        checkNotNull(callback, "aliases");

        List<String> free = new ArrayList<String>();

        // Filter out commands that are already registered
        for (String alias : aliases) {
            if (!this.commands.containsKey(alias.toLowerCase())) {
                free.add(alias);
            }
        }

        // Invoke the callback with the commands that /can/ be registered
        //noinspection ConstantConditions
        free = new ArrayList<String>(callback.apply(free));

        if (!free.isEmpty()) {
            // The callback should /not/ have added any new commands
            for (String alias : free) {
                if (this.commands.containsKey(alias.toLowerCase())) {
                    throw new IllegalArgumentException("A command by the name of '" + alias + "' already exists");
                }
            }

            String primary = free.get(0);
            List<String> secondary = free.subList(1, free.size());
            CommandMapping mapping = new ImmutableCommandMapping(callable, primary, secondary);

            for (String alias : free) {
                this.commands.put(alias.toLowerCase(), mapping);
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
        return Optional.of(this.commands.remove(alias.toLowerCase()));
    }

    /**
     * Remove all mappings identified by the given aliases.
     *
     * @param aliases A collection of aliases
     * @return Whether any were found
     */
    public synchronized boolean removeAll(Collection<?> aliases) {
        checkNotNull(aliases, "aliases");

        boolean found = false;

        for (Object alias : aliases) {
            this.commands.remove(alias.toString().toLowerCase());
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
        checkNotNull(mapping, "mapping");

        CommandMapping found = null;

        Iterator<CommandMapping> it = this.commands.values().iterator();
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
     * @param mappings The collection
     * @return Whether the at least one command was removed
     */
    public synchronized boolean removeMappings(Collection<?> mappings) {
        checkNotNull(mappings, "mappings");

        boolean found = false;

        Iterator<CommandMapping> it = this.commands.values().iterator();
        while (it.hasNext()) {
            if (mappings.contains(it.next())) {
                it.remove();
                found = true;
            }
        }

        return found;
    }

    @Override
    public synchronized Set<CommandMapping> getCommands() {
        return ImmutableSet.copyOf(this.commands.values());
    }

    @Override
    public synchronized Set<String> getPrimaryAliases() {
        Set<String> aliases = new HashSet<String>();

        for (CommandMapping mapping : this.commands.values()) {
            aliases.add(mapping.getPrimaryAlias());
        }

        return Collections.unmodifiableSet(aliases);
    }

    @Override
    public synchronized Set<String> getAliases() {
        Set<String> aliases = new HashSet<String>();

        for (CommandMapping mapping : this.commands.values()) {
            aliases.addAll(mapping.getAllAliases());
        }

        return Collections.unmodifiableSet(aliases);
    }

    @Override
    public synchronized Optional<CommandMapping> getFirst(String alias) {
        return Optional.fromNullable(this.commands.get(alias.toLowerCase()));
    }

    @Override
    public synchronized boolean containsAlias(String alias) {
        return this.commands.containsKey(alias.toLowerCase());
    }

    @Override
    public boolean containsMapping(CommandMapping mapping) {
        checkNotNull(mapping, "mapping");

        for (CommandMapping test : this.commands.values()) {
            if (mapping.equals(test)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Optional<CommandResult> process(CommandSource source, String arguments) {
        final String[] argSplit = arguments.split(" ", 2);
        CommandMapping cmd = this.commands.get(argSplit[0].toLowerCase());
        if (cmd == null) {
            return Optional.absent();
        }
        try {
            return Optional.of(cmd.getSpec().process(source, argSplit[1]));
        } catch (CommandException ex) {
            if (ex.getText() != null) {
                source.sendMessage(error(ex.getText()));
            }
            source.sendMessage(error(_("Usage: /%s %s", argSplit[0], getUsage(source))));
        } catch (Throwable t) {
            source.sendMessage(error(_("Error occurred while executing command: %s", String.valueOf(t.getMessage()))));
            t.printStackTrace();
        }
        return Optional.of(CommandResult.empty());
    }

    @Override
    public List<String> complete(CommandSource src, final String arguments) {
        final String[] argSplit = arguments.split(" ", 2);
        CommandMapping cmd = this.commands.get(argSplit[0].toLowerCase());
        if (cmd == null || argSplit.length == 1) {
            return ImmutableList.copyOf(Iterables.filter(filterCommands(src), new StartsWithPredicate(argSplit[0])));
        }

        try {
            cmd.getSpec().checkPermission(src);
        } catch (CommandException ex) {
            return Collections.emptyList();
        }
        try {
            return cmd.getSpec().complete(src, argSplit[1]);
        } catch (ArgumentParseException e) {
            src.sendMessage(debug(e.getText()));
            return Collections.emptyList();
        }
    }

    @Override
    public List<String> complete(final CommandSource src, CommandArgs args, CommandContext context) {
        final Optional<String> commandComponent = args.nextIfPresent();
        if (commandComponent.isPresent()) {
            if (args.hasNext()) {
                CommandMapping child = this.commands.get(commandComponent.get());
                if (child == null) {
                    return ImmutableList.of();
                }
                return child.getSpec().complete(src, args, context);
            } else {
                return ImmutableList.copyOf(Iterables.filter(filterCommands(src), new StartsWithPredicate(commandComponent.get())));
            }
        } else {
            return ImmutableList.copyOf(filterCommands(src));
        }
    }

    private Iterable<String> filterCommands(final CommandSource src) {
        return Iterables.filter(this.commands.keySet(), new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                CommandSpec child = SimpleDispatcher.this.commands.get(input).getSpec();
                try {
                    child.checkPermission(src);
                    return true;
                } catch (CommandException ex) {
                    return false;
                }
            }
        });
    }

    /**
     * Get the number of registered aliases.
     *
     * @return The number of aliases
     */
    public synchronized int size() {
        return this.commands.size();
    }

    @Override
    public void parse(CommandArgs args, CommandContext context) throws ArgumentParseException {
        super.parse(args, context);
        CommandSpec spec = context.<CommandSpec>getOne(getUntranslatedKey()).get();
        spec.process(args, context);
    }

    @Override
    protected Object parseValue(CommandArgs args) throws ArgumentParseException {
        final String key = args.next();
        if (!this.commands.containsKey(key.toLowerCase())) {
            throw args.createError(_("Input command %s was not a valid subcommand!", key));
        }

        return this.commands.get(key.toLowerCase());
    }

    @Override
    public Text getUsage(CommandSource context) {
        final TextBuilder build = Texts.builder();
        Iterable<String> filteredCommands = Iterables.filter(filterCommands(context), new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return SimpleDispatcher.this.commands.get(input).getPrimaryAlias().equals(input); // Restrict to primary aliases in usage
            }
        });

        for (Iterator<String> it = filteredCommands.iterator(); it.hasNext();) {
            build.append(Texts.of(it.next()));
            if (it.hasNext()) {
                build.append(Texts.of("|"));
            }
        }
        return build.build();
    }

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        CommandSpec spec = args.<CommandSpec>getOne(getUntranslatedKey()).get();
        if (spec == null) {
            if (this.fallbackExecutor != null) {
                return this.fallbackExecutor.execute(src, args);
            } else {
                throw new CommandException(_("Invalid subcommand state -- no more than one spec may be provided for child arg %s", getKey()));
            }
        }
        return spec.getExecutor().execute(src, args);
    }

    @Override
    public synchronized Set<CommandMapping> getAll(String alias) {
        Set<CommandMapping> mappings = Sets.newHashSet();
        Optional<CommandMapping> mapping = this.getFirst(alias);
        if (mapping.isPresent()) {
            mappings.add(mapping.get());
        }
        return mappings;
    }

    @Override
    public synchronized Optional<CommandMapping> resolveMapping(String alias, CommandSource source) {
        return this.getFirst(alias);
    }
}
