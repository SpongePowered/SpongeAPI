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
package org.spongepowered.api.service.command;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.spongepowered.api.util.SpongeApiTranslationHelper.t;
import static org.spongepowered.api.util.command.CommandMessageFormatting.error;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Optional;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.SpongeEventFactory;
import org.spongepowered.api.event.message.CommandEvent;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.command.CommandCallable;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandMapping;
import org.spongepowered.api.util.command.CommandPermissionException;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.InvocationCommandException;
import org.spongepowered.api.util.command.dispatcher.Disambiguator;
import org.spongepowered.api.util.command.dispatcher.SimpleDispatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

/**
 * A simple implementation of {@link CommandService}.
 * This service calls the appropriate events for a command.
 */
public class SimpleCommandService implements CommandService {
    private final Game game;
    private final SimpleDispatcher dispatcher;
    private final Multimap<PluginContainer, CommandMapping> owners = HashMultimap.create();
    private final Object lock = new Object();

    /**
     * Construct a simple {@link CommandService}.
     *
     * @param game The game to use for this CommandService
     */
    @Inject
    public SimpleCommandService(Game game) {
        this(game, SimpleDispatcher.FIRST_DISAMBIGUATOR);
    }

    /**
     * Construct a simple {@link CommandService}.
     *
     * @param disambiguator The function to resolve a single command when multiple options are available
     * @param game The game to use for this CommandService
     */
    @Inject
    public SimpleCommandService(Game game, Disambiguator disambiguator) {
        checkNotNull(game, "game");
        this.game = game;
        this.dispatcher = new SimpleDispatcher(disambiguator);
    }

    @Override
    public Optional<CommandMapping> register(Object plugin, CommandCallable callable, String... alias) {
        return register(plugin, callable, Arrays.asList(alias));
    }

    @Override
    public Optional<CommandMapping> register(Object plugin, CommandCallable callable, List<String> aliases) {
        return register(plugin, callable, aliases, Functions.<List<String>>identity());
    }

    @Override
    public Optional<CommandMapping> register(Object plugin, CommandCallable callable, List<String> aliases,
            Function<List<String>, List<String>> callback) {
        checkNotNull(plugin, "plugin");

        Optional<PluginContainer> containerOptional = this.game.getPluginManager().fromInstance(plugin);
        if (!containerOptional.isPresent()) {
            throw new IllegalArgumentException(
                    "The provided plugin object does not have an associated plugin container "
                            + "(in other words, is 'plugin' actually your plugin object?");
        }

        PluginContainer container = containerOptional.get();

        synchronized (this.lock) {
            // <namespace>:<alias> for all commands
            List<String> aliasesWithPrefix = new ArrayList<String>(aliases.size() * 2);
            for (String alias : aliases) {
                final Collection<CommandMapping> ownedCommands = this.owners.get(container);
                for (CommandMapping mapping : this.dispatcher.getAll(alias)) {
                    if (ownedCommands.contains(mapping)) {
                        throw new IllegalArgumentException("A plugin may not register multiple commands for the same alias ('" + alias + "')!");
                    }
                }
                aliasesWithPrefix.add(alias);
                aliasesWithPrefix.add(container.getId() + ":" + alias);
            }

            Optional<CommandMapping> mapping = this.dispatcher.register(callable, aliasesWithPrefix, callback);

            if (mapping.isPresent()) {
                this.owners.put(container, mapping.get());
            }

            return mapping;
        }
    }

    @Override
    public Optional<CommandMapping> removeMapping(CommandMapping mapping) {
        synchronized (this.lock) {
            Optional<CommandMapping> removed = this.dispatcher.removeMapping(mapping);

            if (removed.isPresent()) {
                forgetMapping(removed.get());
            }

            return removed;
        }
    }

    private void forgetMapping(CommandMapping mapping) {
        Iterator<CommandMapping> it = this.owners.values().iterator();
        while (it.hasNext()) {
            if (it.next().equals(mapping)) {
                it.remove();
                break;
            }
        }
    }

    @Override
    public Set<PluginContainer> getPluginContainers() {
        synchronized (this.lock) {
            return ImmutableSet.copyOf(this.owners.keySet());
        }
    }

    @Override
    public Set<CommandMapping> getCommands() {
        return this.dispatcher.getCommands();
    }

    @Override
    public Set<CommandMapping> getOwnedBy(PluginContainer container) {
        synchronized (this.lock) {
            return ImmutableSet.copyOf(this.owners.get(container));
        }
    }

    @Override
    public Set<String> getPrimaryAliases() {
        return this.dispatcher.getPrimaryAliases();
    }

    @Override
    public Set<String> getAliases() {
        return this.dispatcher.getAliases();
    }

    @Override
    public Optional<CommandMapping> get(String alias) {
        return this.dispatcher.get(alias);
    }

    @Override
    public Set<? extends CommandMapping> getAll(String alias) {
        return this.dispatcher.getAll(alias);
    }

    @Override
    public Multimap<String, CommandMapping> getAll() {
        return this.dispatcher.getAll();
    }

    @Override
    public boolean containsAlias(String alias) {
        return this.dispatcher.containsAlias(alias);
    }

    @Override
    public boolean containsMapping(CommandMapping mapping) {
        return this.dispatcher.containsMapping(mapping);
    }

    @Override
    public Optional<CommandResult> process(CommandSource source, String commandLine) {
        final String[] argSplit = commandLine.split(" ", 2);
        final CommandEvent event = SpongeEventFactory.createCommand(this.game, argSplit.length > 1 ? argSplit[1] : "", source, argSplit[0], null);
        this.game.getEventManager().post(event);
        if (event.isCancelled()) {
            return event.getResult();
        }

        try {
            try {
                this.dispatcher.process(source, commandLine);
            } catch (InvocationCommandException ex) {
                if (ex.getCause() != null) {
                    throw ex.getCause();
                }
            } catch (CommandPermissionException ex) {
                Text text = ex.getText();
                if (text != null) {
                    source.sendMessage(error(text));
                }
            } catch (CommandException ex) {
                Text text = ex.getText();
                if (text != null) {
                    source.sendMessage(error(text));
                }

                final Optional<CommandMapping> mapping = this.dispatcher.get(argSplit[0], source);
                if (mapping.isPresent()) {
                    source.sendMessage(error(t("Usage: /%s %s", argSplit[0], mapping.get().getCallable().getUsage(source))));
                }
            }
        } catch (Throwable thr) {
            source.sendMessage(error(t("Error occurred while executing command: %s", String.valueOf(thr.getMessage()))));
            thr.printStackTrace();
        }
        return Optional.of(CommandResult.empty());
    }

    @Override
    public List<String> getSuggestions(CommandSource src, String arguments) {
        try {
            return this.dispatcher.getSuggestions(src, arguments);
        } catch (CommandException e) {
            src.sendMessage(error(t("Error getting suggestions: %s", e.getText())));
            return Collections.emptyList();
        }
    }

    @Override
    public boolean testPermission(CommandSource source) {
        return this.dispatcher.testPermission(source);
    }

    @Override
    public Optional<Text> getShortDescription(CommandSource source) {
        return this.dispatcher.getShortDescription(source);
    }

    @Override
    public Optional<Text> getHelp(CommandSource source) {
        return this.dispatcher.getHelp(source);
    }

    @Override
    public Text getUsage(CommandSource source) {
        return this.dispatcher.getUsage(source);
    }

    @Override
    public int size() {
        return this.dispatcher.size();
    }
}
