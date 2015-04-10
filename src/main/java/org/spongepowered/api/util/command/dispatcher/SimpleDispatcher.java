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
import static org.spongepowered.api.util.command.dispatcher.CommandMessageFormatting.NEWLINE_TEXT;
import static org.spongepowered.api.util.command.dispatcher.CommandMessageFormatting.SPACE_TEXT;
import static org.spongepowered.api.util.command.dispatcher.CommandMessageFormatting.error;
import static org.spongepowered.api.util.command.dispatcher.TranslationPlaceholder.t;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextBuilder;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.util.StartsWithPredicate;
import org.spongepowered.api.util.command.CommandCallable;
import org.spongepowered.api.util.command.CommandContext;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandExecutor;
import org.spongepowered.api.util.command.CommandMapping;
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
     * @throws IllegalArgumentException Thrown if new conflicting aliases are added in the callback
     */
    public synchronized Optional<CommandMapping> register(CommandCallable callable, List<String> aliases,
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
    public synchronized Optional<CommandMapping> get(String alias) {
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
    public boolean process(CommandSource source, String commandLine) throws CommandException {
        final String[] argSplit = commandLine.split(" ", 2);
        Optional<CommandMapping> cmdOptional = get(argSplit[0]);
        if (!cmdOptional.isPresent()) {
            return false;
        }
        final String arguments = argSplit.length > 1 ? argSplit[1] : "";
        final CommandCallable spec = cmdOptional.get().getCallable();
        return spec.process(source, arguments);
    }

    @Override
    public List<String> getSuggestions(CommandSource src, final String arguments) throws CommandException {
        final String[] argSplit = arguments.split(" ", 2);
        Optional<CommandMapping> cmdOptional = get(argSplit[0]);
        if (!cmdOptional.isPresent() || argSplit.length == 1) {
            return ImmutableList.copyOf(Iterables.filter(filterCommands(src), new StartsWithPredicate(argSplit[0])));
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
        TextBuilder build = Texts.builder("Available commands:\n");
        for (Iterator<String> it = filterCommands(source).iterator(); it.hasNext();) {
            final CommandMapping mapping = this.commands.get(it.next());
            final Optional<Text> description = mapping.getCallable().getShortDescription(source);
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

    @Override
    public List<String> complete(final CommandSource src, CommandArgs args, CommandContext context) {
        final Optional<String> commandComponent = args.nextIfPresent();
        if (commandComponent.isPresent()) {
            if (args.hasNext()) {
                Optional<CommandMapping> child = get(commandComponent.get());
                if (!child.isPresent()) {
                    return ImmutableList.of();
                }
                args.nextIfPresent();
                final String arguments = args.getRaw().substring(args.getRawPosition());
                while (args.hasNext()) {
                    args.nextIfPresent();
                }
                try {
                    return child.get().getCallable().getSuggestions(src, arguments);
                } catch (CommandException e) {
                    src.sendMessage(error(e.getText()));
                    return ImmutableList.of();
                }
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
                return SimpleDispatcher.this.commands.get(input).getCallable().testPermission(src);
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
        context.putArg(getUntranslatedKey() + "_args", args.getRaw().substring(args.getRawPosition()));
        while (args.hasNext()) {
            args.next();
        }
    }

    @Override
    protected Object parseValue(CommandArgs args) throws ArgumentParseException {
        final String key = args.next();
        final Optional<CommandMapping> mapping = get(key);
        if (!mapping.isPresent()) {
            throw args.createError(t("Input command %s was not a valid subcommand!", key));
        }

        return mapping.get();
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
                build.append(CommandMessageFormatting.PIPE_TEXT);
            }
        }
        return build.build();
    }


    @Override
    public void execute(CommandSource src, CommandContext args) throws CommandException {
        final String arguments = args.<String>getOne(getUntranslatedKey() + "_args").get();
        CommandMapping mapping = args.<CommandMapping>getOne(getUntranslatedKey()).get();
        if (mapping == null) {
            if (this.fallbackExecutor != null) {
                this.fallbackExecutor.execute(src, args);
                return;
            } else {
                throw new CommandException(t("Invalid subcommand state -- no more than one mapping may be provided for child arg %s", getKey()));
            }
        }
        mapping.getCallable().process(src, arguments);
    }
}
