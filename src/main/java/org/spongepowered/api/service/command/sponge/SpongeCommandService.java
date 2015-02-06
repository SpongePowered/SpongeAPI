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

package org.spongepowered.api.service.command.sponge;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.Game;
import org.spongepowered.api.event.message.CommandEvent;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.api.service.command.CommandService;
import org.spongepowered.api.util.command.CommandCallable;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandMapping;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.event.Order;
import org.spongepowered.api.util.event.Subscribe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

public class SpongeCommandService implements CommandService<CommandResult> {

    private static final Logger log = LoggerFactory.getLogger(SpongeCommandService.class);

    private final PluginManager pluginManager;
    private final SpongeDispatcher dispatcher;
    private final Multimap<PluginContainer, CommandMapping> owners = HashMultimap.create();
    private final Object lock = new Object();

    @Inject
    public SpongeCommandService(PluginManager pluginManager, Game game) {
        checkNotNull(pluginManager, "pluginManager");
        this.pluginManager = pluginManager;
        this.dispatcher = new SpongeDispatcher(pluginManager, game);
    }

    @Subscribe(order = Order.LAST)
    public void onCommandEvent(final CommandEvent event) {
        try {
            if (call(event.getSource(), event.getCommand() + " " + event.getArguments(), Collections.<String> emptyList()).wasProcessed()) {
                event.setCancelled(true);
            }
        } catch (CommandException e) {
            event.setCancelled(true);
            log.warn("Failed to execute a command", e);
        }
    }

    @Override
    public Optional<CommandMapping> register(Object plugin, CommandCallable<CommandResult> callable, String... aliases) {
        return register(plugin, callable, Arrays.asList(aliases));
    }

    @Override
    public Optional<CommandMapping> register(Object plugin, CommandCallable<CommandResult> callable, List<String> aliases,
            Function<List<String>, List<String>> callback) {
        return register(plugin, callable, aliases);
    }

    public Optional<CommandMapping> register(Object plugin, CommandCallable<CommandResult> callable, List<String> aliases) {
        checkNotNull(plugin);

        Optional<PluginContainer> containerOptional = pluginManager.fromInstance(plugin);
        if (!containerOptional.isPresent()) {
            throw new IllegalArgumentException("The provided plugin object does not have an associated plugin container "
                    + "(in other words, is 'plugin' actually your plugin object?");
        }
        for (String alias : aliases) {
            if (alias.contains(":")) {
                throw new IllegalArgumentException("Command name must not include the the character ':'.");
            }
        }
        PluginContainer container = containerOptional.get();

        synchronized (lock) {
            Optional<CommandMapping> mapping = dispatcher.register(callable, aliases.get(0), aliases, container.getId());

            if (mapping.isPresent()) {
                owners.put(container, mapping.get());
            }

            return mapping;
        }
    }

    @Override
    public Optional<CommandMapping> remove(String alias) {
        synchronized (lock) {
            Optional<CommandMapping> removed = dispatcher.remove(alias);

            if (removed.isPresent()) {
                forgetMapping(removed.get());
            }

            return removed;
        }
    }

    @Override
    public Optional<CommandMapping> removeMapping(CommandMapping mapping) {
        synchronized (lock) {
            Optional<CommandMapping> removed = dispatcher.removeMapping(mapping);

            if (removed.isPresent()) {
                forgetMapping(removed.get());
            }

            return removed;
        }
    }

    private void forgetMapping(CommandMapping mapping) {
        Iterator<CommandMapping> it = owners.values().iterator();
        while (it.hasNext()) {
            if (it.next().equals(mapping)) {
                it.remove();
                break;
            }
        }
    }

    @Override
    public Set<PluginContainer> getPluginContainers() {
        synchronized (lock) {
            return ImmutableSet.copyOf(owners.keySet());
        }
    }

    @Override
    public Set<CommandMapping> getCommands() {
        return dispatcher.getCommands();
    }

    @Override
    public Set<CommandMapping> getOwnedBy(PluginContainer container) {
        synchronized (lock) {
            return ImmutableSet.copyOf(owners.get(container));
        }
    }

    @Override
    public Map<String, Integer> getPrimaryAliases() {
        return dispatcher.getPrimaryAliases();
    }

    @Override
    public Map<String, Integer> getAliases() {
        return dispatcher.getAliases();
    }

    @Override
    public Set<CommandMapping> getAll(String alias) {
        return dispatcher.getAll(alias);
    }

    @Override
    public boolean containsAlias(String alias) {
        return dispatcher.containsAlias(alias);
    }

    @Override
    public boolean containsMapping(CommandMapping mapping) {
        return dispatcher.containsMapping(mapping);
    }

    @Override
    public CommandResult call(CommandSource source, String arguments, List<String> parents) throws CommandException {
        return dispatcher.call(source, arguments, parents);
    }

    @Override
    public boolean testPermission(CommandSource source) {
        return dispatcher.testPermission(source);
    }

    @Override
    public boolean testSource(CommandSource source) {
        return dispatcher.testSource(source);
    }

    @Override
    public List<String> getSuggestions(CommandSource source, String arguments) throws CommandException {
        return dispatcher.getSuggestions(source, arguments);
    }

    @Override
    public Optional<String> getShortDescription() {
        return dispatcher.getShortDescription();
    }

    @Override
    public Optional<String> getHelp() {
        return dispatcher.getHelp();
    }

    @Override
    public String getUsage() {
        return dispatcher.getUsage();
    }

    @Override
    public int size() {
        return dispatcher.size();
    }

    @Override
    public Optional<CommandMapping> resolveMapping(String alias, CommandSource source) {
        return dispatcher.resolveMapping(alias, source);
    }

    public void addAliasContext(String alias, AliasContext context) {
        dispatcher.addAliasContext(alias, context);
    }

    public void removeAliasContext(String alias) {
        dispatcher.removeAliasContext(alias);
    }

}
