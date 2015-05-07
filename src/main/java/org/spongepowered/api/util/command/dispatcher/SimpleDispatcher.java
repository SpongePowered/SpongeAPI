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
package org.spongepowered.api.util.command.dispatcher;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.spongepowered.api.util.SpongeApiTranslationHelper.t;
import static org.spongepowered.api.util.command.CommandMessageFormatting.NEWLINE_TEXT;
import static org.spongepowered.api.util.command.CommandMessageFormatting.SPACE_TEXT;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextBuilder;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.util.StartsWithPredicate;
import org.spongepowered.api.util.command.CommandCallable;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandMapping;
import org.spongepowered.api.util.command.CommandMessageFormatting;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.ImmutableCommandMapping;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

/**
 * A simple implementation of a {@link Dispatcher}.
 */
public final class SimpleDispatcher implements Dispatcher {

    /**
     * This is a disambiguator function that returns the first matching command.
     */
    public static final Disambiguator FIRST_DISAMBIGUATOR = new Disambiguator() {
        @Override
        public Optional<CommandMapping> disambiguate(CommandSource source, final String aliasUsed, List<CommandMapping> availableOptions) {
            for (CommandMapping mapping : availableOptions) {
                if (mapping.getPrimaryAlias().toLowerCase().equals(aliasUsed.toLowerCase())) {
                    return Optional.of(mapping);
                }
            }
            return Optional.of(availableOptions.get(0));
        }
    };

    private final Disambiguator disambiguatorFunc;
    private final ListMultimap<String, CommandMapping> commands = ArrayListMultimap.create();

    /**
     * Creates a basic new dispatcher.
     */
    public SimpleDispatcher() {
        this(FIRST_DISAMBIGUATOR);
    }

    /**
     * Creates a new dispatcher with a specific disambiguator.
     *
     * @param disambiguatorFunc Function that returns the preferred command if multiple exist for a given alias
     */
    public SimpleDispatcher(Disambiguator disambiguatorFunc) {
        this.disambiguatorFunc = disambiguatorFunc;
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
    public Optional<CommandMapping> register(CommandCallable callable, String... alias) {
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
     */
    public synchronized Optional<CommandMapping> register(CommandCallable callable, List<String> aliases,
            Function<List<String>, List<String>> callback) {
        checkNotNull(aliases, "aliases");
        checkNotNull(callable, "callable");
        checkNotNull(callback, "callback");

        // Invoke the callback with the commands that /can/ be registered
        //noinspection ConstantConditions
        aliases = ImmutableList.copyOf(callback.apply(aliases));
        if (!aliases.isEmpty()) {
            String primary = aliases.get(0);
            List<String> secondary = aliases.subList(1, aliases.size());
            CommandMapping mapping = new ImmutableCommandMapping(callable, primary, secondary);

            for (String alias : aliases) {
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
    public synchronized Collection<CommandMapping> remove(String alias) {
        return this.commands.removeAll(alias.toLowerCase());
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
            if (!this.commands.removeAll(alias.toString().toLowerCase()).isEmpty()) {
                found = true;
            }
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
    public Optional<CommandMapping> get(String alias) {
        return get(alias, null);
    }

    /**
     * Get a given command in the context of a certain command source.
     *
     * @param alias The alias to look up
     * @param source The source this alias is being looked up for
     * @return the command if exactly one matches
     */
    public synchronized Optional<CommandMapping> get(String alias, @Nullable CommandSource source) {
        List<CommandMapping> results = this.commands.get(alias.toLowerCase());
        if (results.size() == 1) {
            return Optional.of(results.get(0));
        } else if (results.size() == 0 || source == null) {
            return Optional.absent();
        } else {
            return this.disambiguatorFunc.disambiguate(source, alias, results);
        }
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
    public Optional<CommandResult> process(CommandSource source, String commandLine) throws CommandException {
        final String[] argSplit = commandLine.split(" ", 2);
        Optional<CommandMapping> cmdOptional = get(argSplit[0], source);
        if (!cmdOptional.isPresent()) {
            return Optional.absent();
        }
        final String arguments = argSplit.length > 1 ? argSplit[1] : "";
        final CommandCallable spec = cmdOptional.get().getCallable();
        return spec.process(source, arguments);
    }

    @Override
    public List<String> getSuggestions(CommandSource src, final String arguments) throws CommandException {
        final String[] argSplit = arguments.split(" ", 2);
        Optional<CommandMapping> cmdOptional = get(argSplit[0], src);
        if (argSplit.length == 1) {
            return ImmutableList.copyOf(Iterables.filter(filterCommands(src), new StartsWithPredicate(argSplit[0])));
        } else if (!cmdOptional.isPresent()) {
            return ImmutableList.of();
        }
        return cmdOptional.get().getCallable().getSuggestions(src, argSplit[1]);
    }

    @Override
    public boolean testPermission(CommandSource source) {
        for (CommandMapping mapping : this.commands.values()) {
            if (mapping.getCallable().testPermission(source)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Text> getShortDescription(CommandSource source) {
        return Optional.absent();
    }

    @Override
    public Optional<Text> getHelp(CommandSource source) {
        if (this.commands.isEmpty()) {
            return Optional.absent();
        }
        TextBuilder build = t("Available commands:\n").builder();
        for (Iterator<String> it = filterCommands(source).iterator(); it.hasNext();) {
            final Optional<CommandMapping> mappingOpt = get(it.next(), source);
            if (!mappingOpt.isPresent()) {
                continue;
            }
            CommandMapping mapping = mappingOpt.get();
            @SuppressWarnings("unchecked")
            final Optional<Text> description = (Optional<Text>) mapping.getCallable().getShortDescription(source);
            build.append(Texts.builder(mapping.getPrimaryAlias())
                    .color(TextColors.GREEN)
                    .style(TextStyles.UNDERLINE)
                    .onClick(TextActions.suggestCommand("/" + mapping.getPrimaryAlias())).build(),
                    SPACE_TEXT, description.or(mapping.getCallable().getUsage(source)));
            if (it.hasNext()) {
                build.append(NEWLINE_TEXT);
            }
        }
        return Optional.of(build.build());
    }

    private Iterable<String> filterCommands(final CommandSource src) {
        return Multimaps.filterValues(this.commands, new Predicate<CommandMapping>() {
            @Override
            public boolean apply(@Nullable CommandMapping input) {
                return input != null && input.getCallable().testPermission(src);
            }
        }).keys();
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
    public Text getUsage(final CommandSource source) {
        final TextBuilder build = Texts.builder();
        Iterable<String> filteredCommands = Iterables.filter(filterCommands(source), new Predicate<String>() {
            @Override
            public boolean apply(@Nullable String input) {
                if (input == null) {
                    return false;
                }
                final Optional<CommandMapping> ret = get(input, source);
                return ret.isPresent() && ret.get().getPrimaryAlias().equals(input);
            }
        });

        for (Iterator<String> it = filteredCommands.iterator(); it.hasNext();) {
            build.append(Texts.of(it.next()));
            if (it.hasNext()) {
                build.append(CommandMessageFormatting.PIPE_TEXT);
            }
        }
        return build.build();
    }

    @Override
    public synchronized Set<CommandMapping> getAll(String alias) {
        return ImmutableSet.copyOf(this.commands.get(alias));
    }

    @Override
    public Multimap<String, CommandMapping> getAll() {
        return ImmutableMultimap.copyOf(this.commands);
    }
}
