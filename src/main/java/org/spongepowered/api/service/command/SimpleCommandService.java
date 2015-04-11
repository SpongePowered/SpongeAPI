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

package org.spongepowered.api.service.command;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Optional;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.SpongeEventFactory;
import org.spongepowered.api.event.message.CommandEvent;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.util.command.CommandMapping;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.CommandSpec;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

/**
 * A simple implementation of {@link CommandService}.
 * This service calls the appropriate events for a command.
 */
public class SimpleCommandService implements CommandService {

    private static final Logger log = LoggerFactory.getLogger(SimpleCommandService.class);

    private final Game game;
    private final ContextualDispatcher dispatcher = new ContextualDispatcher();
    private final Multimap<PluginContainer, CommandMapping> owners = HashMultimap.create();
    private final Object lock = new Object();

    /**
     * Construct a simple {@link CommandService}.
     *
     * @param game The game to use for this CommandService
     */
    @Inject
    public SimpleCommandService(Game game) {
        checkNotNull(game, "game");
        this.game = game;
    }

    @Override
    public Optional<CommandMapping> register(Object plugin, CommandSpec spec, String... alias) {
        return register(plugin, spec, Arrays.asList(alias));
    }

    @Override
    public Optional<CommandMapping> register(Object plugin, CommandSpec spec, List<String> aliases) {
        return register(plugin, spec, aliases, Functions.<List<String>>identity());
    }

    @Override
    public Optional<CommandMapping> register(Object plugin, CommandSpec spec, List<String> aliases,
            Function<List<String>, List<String>> callback) {
        checkNotNull(plugin, "plugin");

        Optional<PluginContainer> containerOptional = this.game.getPluginManager().fromInstance(plugin);
        if (!containerOptional.isPresent()) {
            throw new IllegalArgumentException(
                    "The provided plugin object does not have an associated plugin container "
                            + "(in other words, is 'plugin' actually your plugin object?");
        }

        List<String> realAliases = Lists.newArrayList();

        for (String alias : aliases) {
            if (alias.contains(":")) {
                throw new IllegalArgumentException("Command alias must not contain a colon.");
            }
            realAliases.add(alias.toLowerCase());
        }

        PluginContainer container = containerOptional.get();

        synchronized (this.lock) {

            CommandMapping mapping = this.dispatcher.register(spec, container, realAliases);

            this.owners.put(container, mapping);

            return Optional.of(mapping);

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
    public Optional<CommandMapping> getFirst(String alias) {
        return this.dispatcher.getFirst(alias);
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
        final CommandEvent event = SpongeEventFactory.createCommand(this.game, argSplit[0], source, argSplit[1], null);
        this.game.getEventManager().post(event);
        if (event.isCancelled()) {
            return event.getResult();
        }
        return this.dispatcher.process(source, commandLine);
    }

    @Override
    public List<String> complete(CommandSource src, String commandLine) {
        return this.dispatcher.complete(src, commandLine);
    }

    @Override
    public int size() {
        return this.dispatcher.size();
    }

    @Override
    public Set<? extends CommandMapping> getAll(String alias) {
        return this.dispatcher.getAll(alias);
    }

    @Override
    public Optional<CommandMapping> resolveMapping(String alias, CommandSource source) {
        return this.dispatcher.resolveMapping(alias, source);
    }

    public void setContext(String alias, AliasContext context) {
        this.dispatcher.setContext(alias, context);
    }
}
